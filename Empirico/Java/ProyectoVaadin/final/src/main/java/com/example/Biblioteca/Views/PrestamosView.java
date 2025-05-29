package com.example.Biblioteca.Views;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.Biblioteca.GestorArchivos;
import com.example.Biblioteca.InformacionCompartida;
import com.example.Biblioteca.Libro;
import com.example.Biblioteca.Prestamo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./PrestamosStyle.css")
@Route("prestamos")
@PageTitle("Prestar Libros")
public class PrestamosView extends VerticalLayout {

    public Grid<Libro> grid; //Tabla para mostrar informacion
    public ListDataProvider<Libro> dataProvider; //Lista que recibe la tabla (puente entre el grid y la lista de libros)

    public PrestamosView() {

        setAlignItems(Alignment.CENTER);
        setPadding(true);
        setSpacing(true);
        addClassName("fondo");

        H1 titulo = new H1("Prestar Libros");
        titulo.addClassName("titulo");

        H2 subtituloPrestamo = new H2("Ingresa la información para solicitar el prestamo");
        subtituloPrestamo.addClassName("subtitulo");

        Image imagenHome = new Image("https://static.thenounproject.com/png/391821-200.png", "Icono home");
        imagenHome.addClassName("imagen-home");

        Button botonHome = new Button(imagenHome);
        botonHome.addClassName("boton-home");
        botonHome.addClickListener(e -> UI.getCurrent().navigate(""));

        HorizontalLayout botones = new HorizontalLayout(botonHome);

        botones.setJustifyContentMode(JustifyContentMode.CENTER);
        botones.setSpacing(true);

        //Sacamos solamente la lista con los libros disponibles
        List<Libro> librosDisponibles = InformacionCompartida.lista_libros.stream().filter(Libro::getDisponibilidad).collect(Collectors.toList());

        Image noLibro = new Image("images/no-libro.png", "Sin libro");
        noLibro.addClassName("imagen-no-libro");

        Paragraph parrafo = new Paragraph("No hay libros disponibles para prestar.");
        parrafo.addClassName("parrafo");

        //Validamos si hay o no libros para mostrar
        if (librosDisponibles.isEmpty()) {

            add(titulo, parrafo, noLibro, botones); //Si no hay libros para mostrar entonces ponemos esta vista
            return;

        }

        dataProvider = new ListDataProvider<>(librosDisponibles); //Le pasamos la lista de libros que vamos a utilizar al dataProvider para que se los pase al grid

        //Creamos el grid de tipo libro
        grid = new Grid<>(Libro.class, false);
        grid.setItems(dataProvider); //Le entregamos al grid los items del dataProvider
        grid.setSelectionMode(Grid.SelectionMode.MULTI);

        //Definimos las columnas y que es lo que va mostrar cada fila
        grid.addColumn(Libro::getTitulo).setHeader("Título");
        grid.addColumn(Libro::getAutor).setHeader("Autor");
        grid.addColumn(Libro::getGenero).setHeader("Género");
        grid.addColumn(Libro::getAnio).setHeader("Año");
        
        //Filtros por género
        ComboBox<String> filtroGenero = new ComboBox<>("Género");
        filtroGenero.setItems("Ficción", "Romance", "Misterio", "Ciencia Ficción", "Fantasía", "Terror", "Literatura infantil", "No ficción", "Autoayuda", "Historia");

        TextField filtroTitulo = new TextField("Buscar por título"); //Filtro por titulo
        TextField filtroAutor = new TextField("Buscar por autor"); //Filtro por autor

        filtroTitulo.setPlaceholder("Nombre libro");
        filtroAutor.setPlaceholder("Autor libro");

        filtroGenero.addValueChangeListener(e -> aplicarFiltros(filtroGenero, filtroTitulo, filtroAutor));
        filtroTitulo.addValueChangeListener(e -> aplicarFiltros(filtroGenero, filtroTitulo, filtroAutor));
        filtroAutor.addValueChangeListener(e -> aplicarFiltros(filtroGenero, filtroTitulo, filtroAutor));

        Button limpiarFiltro = new Button("Limpiar Filtros");
        limpiarFiltro.addClassName("boton-limpiar-filtro");
        limpiarFiltro.addClickListener(e -> {

            filtroGenero.clear();
            filtroTitulo.clear();
            filtroAutor.clear();
            dataProvider.clearFilters();

        });

        HorizontalLayout filtros = new HorizontalLayout(filtroGenero, filtroTitulo, filtroAutor, limpiarFiltro);

        //Datos para el prestamo
        TextField personaField = new TextField("Nombre de la persona");
        personaField.setEnabled(false);
        personaField.setPlaceholder("Ingresa tu nombre");
        personaField.setWidth("180%");
        personaField.setRequiredIndicatorVisible(true);

        DatePicker fechaField = new DatePicker("Fehca del préstamo");
        fechaField.setEnabled(false);
        fechaField.setLocale(new java.util.Locale("es", "ES"));
        fechaField.setMin(LocalDate.of(2025, 1, 1));
        fechaField.setMax(LocalDate.now());
        fechaField.setWidth("180%");
        fechaField.setRequiredIndicatorVisible(true);

        Image imagenFormulario = new Image("images/formulario.PNG", "Muñeco formulario");

        VerticalLayout fields = new VerticalLayout(personaField, fechaField);
        fields.setJustifyContentMode(JustifyContentMode.CENTER);
        fields.setSpacing(true);

        HorizontalLayout formulario = new HorizontalLayout(fields, imagenFormulario);
        formulario.setJustifyContentMode(JustifyContentMode.CENTER);
        formulario.setSpacing("280px");

        Button botonRegistrar = new Button("Registrar préstamo");
        botonRegistrar.addClassName("boton-registrar");
        botonRegistrar.setEnabled(false);

        Runnable validar = () -> {

            boolean valido = personaField.isEnabled()
                && !personaField.getValue().trim().isEmpty()
                && !personaField.getValue().startsWith(" ")
                && fechaField.getValue() != null;

            botonRegistrar.setEnabled(valido);

        };

        //Habilitar los campos para llenar el prestamos en caso tal haya selección de algún libro
        grid.addSelectionListener(e -> {

            boolean tieneSeleccion = !e.getAllSelectedItems().isEmpty();
            personaField.setEnabled(tieneSeleccion);
            fechaField.setEnabled(tieneSeleccion);

            validar.run();

        });

        personaField.addValueChangeListener(e -> validar.run());
        fechaField.addValueChangeListener(e -> validar.run());

        //Registrar un prestamo
        botonRegistrar.addClickListener(e -> {

            String persona = personaField.getValue();
            LocalDate fecha = fechaField.getValue();

            if (persona == null || persona.trim().isEmpty() || persona.startsWith(" ")) {

                Notification.show("El nombre de la persona no puede estar vacío ni comenzar con un espacio");
                return;

            }

            if (fecha == null) {

                Notification.show("Debes seleccionar una fecha válida");
                return;

            }

            Set<Libro> seleccionados = grid.getSelectedItems();

            for (Libro libro : seleccionados) {

                libro.setDisponibilidad(false);
                Prestamo nuevoPrestamo = new Prestamo(libro, persona, fecha);
                InformacionCompartida.lista_prestamos.add(nuevoPrestamo);

            }

            Notification.show("Préstamo registrado con éxito");

            //Refrescamos el grid y limpiamos la selección
            personaField.clear();
            fechaField.clear();
            personaField.setEnabled(false);
            fechaField.setEnabled(false);
            botonRegistrar.setEnabled(false);

            librosDisponibles.removeAll(seleccionados);
            dataProvider.refreshAll();
            dataProvider.clearFilters();
            grid.deselectAll();

            GestorArchivos.guardarLibros(InformacionCompartida.lista_libros);
            GestorArchivos.guardarPrestamos(InformacionCompartida.lista_prestamos);

            if (librosDisponibles.isEmpty()) {

                removeAll();
                add(titulo, parrafo, noLibro, botones);

            }

        });

        add(titulo, filtros, grid, subtituloPrestamo, formulario, botonRegistrar, botones);

    }

    public void aplicarFiltros(ComboBox<String> filtroGenero, TextField filtroTitulo, TextField filtroAutor) {

        //Obtengo los valores de los field de los filtros
        String genero = filtroGenero.getValue();
        String titulo = filtroTitulo.getValue() != null ? filtroTitulo.getValue().toLowerCase() : ""; //Compruebo si el filtro está vacío para dejarlo empty
        String autor = filtroAutor.getValue() != null ? filtroAutor.getValue().toLowerCase() : ""; //Compruebo si el filtro está vacío para dejarlo empty

        dataProvider.clearFilters(); //Limpio filtros antiguos para que no vaya a chocar

        if (genero != null) {

            dataProvider.addFilter(libro -> genero.equals(libro.getGenero())); //Que genero coincide con que me dio el usuario

        }

        if (!titulo.isEmpty()) {

            dataProvider.addFilter(libro -> libro.getTitulo().toLowerCase().contains(titulo)); //Que titulo de libro en minuscula contiene el que me dio el usuario

        }

        if (!autor.isEmpty()) {

            dataProvider.addFilter(libro -> libro.getAutor().toLowerCase().contains(autor)); //Que autor de libro en minuscula contiene al que medio el usuario

        }

    }

}