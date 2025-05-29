package com.example.Biblioteca.Views;

import java.util.List;

import com.example.Biblioteca.GestorArchivos;
import com.example.Biblioteca.InformacionCompartida;
import com.example.Biblioteca.Libro;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./ModificarStyle.css")
@Route("modificar")
@PageTitle("Modificar Libro")
public class ModificarView extends VerticalLayout {

    public Grid<Libro> grid; //Tabla para mostrar los libros
    public ListDataProvider<Libro> dataProvider; //Herramienta para surtir la tabla con los libros

    public ModificarView() {

        setAlignItems(Alignment.CENTER);
        setPadding(true);
        setSpacing(true);
        addClassName("fondo");

        //Titulo arriba del todo
        H1 titulo = new H1("Modificar Libro");
        titulo.addClassName("titulo");

        //Subtitulo abajo del grid
        H2 subtitulo = new H2("Ingresa la nueva información del libro");
        subtitulo.addClassName("subtitulo");

        //Cargamos todos los libros desde la clase de información compartida
        List<Libro> libros = InformacionCompartida.lista_libros;

        //Botones para las redirecciones al home y gestionar
        Image imagenHome = new Image("https://static.thenounproject.com/png/391821-200.png", "Icono home");
        imagenHome.addClassName("imagen-home");

        Button botonHome = new Button(imagenHome);
        Button botonRegresar = new Button("Regresar");
        
        botonRegresar.addClassName("botones");
        botonHome.addClassName("boton-home");

        botonHome.addClickListener(e -> UI.getCurrent().navigate(""));
        botonRegresar.addClickListener(e -> UI.getCurrent().navigate("gestion"));

        //Metemos los botones de home y de redireccion en un arreglo horizontal
        HorizontalLayout botones = new HorizontalLayout(botonHome, botonRegresar);
        botones.setJustifyContentMode(JustifyContentMode.CENTER);
        botones.setSpacing(true);

        //Definimos elementos por si no se encuentran libros disponibles en la lista
        Image noLibro = new Image("images/no-libro.png", "Sin libro");
        noLibro.addClassName("imagen-no-libro");

        Paragraph parrafo = new Paragraph("No hay libros disponibles para modificar.");
        parrafo.addClassName("parrafo");

        //Si no encontramos libros mostramos otra interfaz para que el usuario sepa que no hay libros
        if (libros.isEmpty()) {

            add(titulo, parrafo, noLibro, botones);
            return;

        }

        dataProvider = new ListDataProvider<>(libros); //Lleamos el dataprovider con todos los libros
        grid = new Grid<>(Libro.class, false); //Definimos que el grid es de tipo libroW
        grid.setItems(dataProvider); //Llenamos el grid con los libros contenidos en el dataprovider
        grid.setSelectionMode(Grid.SelectionMode.SINGLE); //Solo puedo modificar un libro a la vez

        //Establecemos las columnas
        grid.addColumn(Libro::getTitulo).setHeader("Título");
        grid.addColumn(Libro::getAutor).setHeader("Autor");
        grid.addColumn(Libro::getGenero).setHeader("Género");
        grid.addColumn(Libro::getAnio).setHeader("Año");
        grid.addColumn(libro -> libro.getDisponibilidad() ? "Disponible" : "No disponible").setHeader("Estado"); //Expresión condicional lambda para mostrar disponible y no disponible en lugar de mostrar true o false

        //Filtros
        ComboBox<String> filtroGenero = new ComboBox<>("Filtrar por género");
        filtroGenero.setItems("Ficción", "Romance", "Misterio", "Ciencia Ficción", "Fantasía", "Terror", "Literatura infantil", "No ficción", "Autoayuda", "Historia");

        ComboBox<String> filtroEstado = new ComboBox<>("Filtrar por estado");
        filtroEstado.setItems("Disponible", "No disponible");

        //Busqueda parcial
        TextField filtroTitulo = new TextField("Buscar por título");
        TextField filtroAutor = new TextField("Buscar por autor");

        filtroTitulo.setPlaceholder("Escribe parte del título");
        filtroAutor.setPlaceholder("Escribe parte del autor");

        Button limpiarFiltro = new Button("Limpiar filtros");
        limpiarFiltro.addClassName("boton-limpiar-filtro");

        limpiarFiltro.addClickListener(e -> {

            filtroGenero.clear();
            filtroEstado.clear();
            filtroTitulo.clear();
            filtroAutor.clear();
            dataProvider.clearFilters();

        });

        //Estamos pendientes de que cualquier cambio en algún field de los filtros para invocar la función que se va a encargar de filtrar
        filtroGenero.addValueChangeListener(e -> aplicarFiltros(filtroGenero, filtroEstado, filtroTitulo, filtroAutor));
        filtroEstado.addValueChangeListener(e -> aplicarFiltros(filtroGenero, filtroEstado, filtroTitulo, filtroAutor));
        filtroTitulo.addValueChangeListener(e -> aplicarFiltros(filtroGenero, filtroEstado, filtroTitulo, filtroAutor));
        filtroAutor.addValueChangeListener(e -> aplicarFiltros(filtroGenero, filtroEstado, filtroTitulo, filtroAutor));

        HorizontalLayout filtros = new HorizontalLayout(filtroGenero, filtroEstado, filtroTitulo, filtroAutor, limpiarFiltro);
        filtros.setSpacing(true);

        //Campos para modificar al seleccionar un libro
        TextField nombreField = new TextField("Nombre del libro");
        TextField autorField = new TextField("Autor");
        ComboBox<String> generoField = new ComboBox<>("Género");
        NumberField anioField = new NumberField("Año");
        ComboBox<String> estadoField = new ComboBox<>("Disponibilidad");

        generoField.setItems("Ficción", "Romance", "Misterio", "Ciencia Ficción", "Fantasía", "Terror", "Literatura infantil", "No ficción", "Autoayuda", "Historia");
        estadoField.setItems("Disponible", "No disponible");

        nombreField.setWidth("30%");
        autorField.setWidth("30%");
        generoField.setWidth("30%");
        anioField.setWidth("30%");
        estadoField.setWidth("30%");

        nombreField.setRequiredIndicatorVisible(true);
        autorField.setRequiredIndicatorVisible(true);
        generoField.setRequiredIndicatorVisible(true);
        anioField.setRequiredIndicatorVisible(true);
        estadoField.setRequiredIndicatorVisible(true);

        anioField.setMin(1000);
        anioField.setMax(2025);
        anioField.setStep(1);

        Button guardarBoton = new Button("Guardar Cambios");
        guardarBoton.setEnabled(false);
        guardarBoton.addClassName("boton-guardar");

        Image imagenChulo = new Image("/images/logo-chulo.png", "Imagen de chulo");
        imagenChulo.addClassName("imagen-chulo");

        HorizontalLayout confirmar = new HorizontalLayout(guardarBoton, imagenChulo);

        confirmar.setJustifyContentMode(JustifyContentMode.CENTER);
        confirmar.setSpacing(true);

        //Validacion para activar el botón
        Runnable validar = () -> {

            boolean valido = !nombreField.isEmpty()
                    && !autorField.isEmpty()
                    && generoField.getValue() != null
                    && anioField.getValue() != null
                    && estadoField.getValue() != null
                    && anioField.getValue() >= 1000
                    && anioField.getValue() <= 2025
                    && anioField.getValue() % 1 == 0
                    && !nombreField.getValue().startsWith(" ")
                    && !autorField.getValue().startsWith(" ");

            guardarBoton.setEnabled(valido);

        };

        //Comprobación activa para ver si habilitamos el botón
        nombreField.addValueChangeListener(e -> validar.run());
        autorField.addValueChangeListener(e -> validar.run());
        generoField.addValueChangeListener(e -> validar.run());
        anioField.addValueChangeListener(e -> validar.run());
        estadoField.addValueChangeListener(e -> validar.run());

        //Cuando seleccionamos un le cargamos a los fields los datos del libro seleccionado
        grid.asSingleSelect().addValueChangeListener(event -> {

            Libro seleccionado = event.getValue();

            if (seleccionado != null) {

                nombreField.setValue(seleccionado.getTitulo());
                autorField.setValue(seleccionado.getAutor());
                generoField.setValue(seleccionado.getGenero());
                anioField.setValue((double) seleccionado.getAnio());
                estadoField.setValue(seleccionado.getDisponibilidad() ? "Disponible" : "No disponible");

                guardarBoton.setEnabled(false);

            }

        });

        //Al hacer click en guardar ya se habrá modificado algún campo de manera exitosa y actualizamos la información
        guardarBoton.addClickListener(e -> {

            Libro seleccionado = grid.asSingleSelect().getValue();

            if (seleccionado == null) {

                Notification.show("Selecciona un libro primero");
                return;

            }

            seleccionado.setTitulo(nombreField.getValue());
            seleccionado.setAutor(autorField.getValue());
            seleccionado.setGenero(generoField.getValue());
            seleccionado.setAnio(anioField.getValue().shortValue());
            seleccionado.setDisponibilidad(estadoField.getValue().equals("Disponible"));

            dataProvider.refreshAll();
            grid.asSingleSelect().clear();
            nombreField.clear();
            autorField.clear();
            generoField.clear();
            anioField.clear();
            estadoField.clear();
            guardarBoton.setEnabled(false);
            Notification.show("Libro actualizado correctamente.");
            GestorArchivos.guardarLibros(InformacionCompartida.lista_libros); //La lista de libros ya se habrá modificado exitosamente y procedemos a re escribir en el archivo la nueva lista actualizado

        });

        add(titulo, filtros, grid, subtitulo,nombreField, autorField, generoField, anioField, estadoField, confirmar, botones);

    }

    //Método para aplicar los filtros
    public void aplicarFiltros(ComboBox<String> filtroGenero, ComboBox<String> filtroEstado, TextField filtroTitulo, TextField filtroAutor) {

        //Sacamos el valor de los fields de filtros a strings
        String genero = filtroGenero.getValue();
        String estado = filtroEstado.getValue();
        String titulo = filtroTitulo.getValue() != null ? filtroTitulo.getValue().toLowerCase() : ""; //Expresion lambda condicional para asignarle el valor del field a la variable string o dejarla vacía
        String autor = filtroAutor.getValue() != null ? filtroAutor.getValue().toLowerCase() : ""; //Expresion lambda condicional para asignarle el valor del field a la variable string o dejarla vacía

        dataProvider.clearFilters(); //Limpiamos todos los filtros antes de aplicar los nuevos filtros para evitar choque entre filtros

        //Vemos cual filtro fue llenado de información para aplicarlo
        if (genero != null) {

            dataProvider.addFilter(libro -> genero.equals(libro.getGenero()));

        }

        if (estado != null) {

            boolean disponibilidad = estado.equals("Disponible");
            dataProvider.addFilter(libro -> libro.getDisponibilidad() == disponibilidad);

        }

        if (!titulo.isEmpty()) {

            dataProvider.addFilter(libro -> libro.getTitulo().toLowerCase().contains(titulo));

        }

        if (!autor.isEmpty()) {

            dataProvider.addFilter(libro -> libro.getAutor().toLowerCase().contains(autor));

        }

    }

}