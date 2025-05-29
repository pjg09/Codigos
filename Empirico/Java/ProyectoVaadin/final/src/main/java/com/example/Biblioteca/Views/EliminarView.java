package com.example.Biblioteca.Views;

import java.util.List;
import java.util.Set;

import com.example.Biblioteca.GestorArchivos;
import com.example.Biblioteca.InformacionCompartida;
import com.example.Biblioteca.Libro;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./EliminarStyle.css")
@Route("eliminar")
@PageTitle("Eliminar Libros")
public class EliminarView extends VerticalLayout {

    public Grid<Libro> grid; //Tabla que me muestra los libros y me permite seleccionarlos
    public ListDataProvider<Libro> dataProvider; //Puente entre la lista y el componente visual grid

    public EliminarView() {

        setAlignItems(Alignment.CENTER);
        setPadding(true);
        setSpacing(true);
        addClassName("fondo");

        //Titulo
        H1 titulo = new H1("Eliminar Libros");
        titulo.addClassName("titulo");

        //Botones para regresar a gestión o ir al home
        Image imagenHome = new Image("https://static.thenounproject.com/png/391821-200.png", "Icono home");
        imagenHome.addClassName("imagen-home");

        Button botonHome = new Button(imagenHome);
        Button botonRegresar = new Button("Regresar");

        botonRegresar.addClassName("botones");
        botonHome.addClassName("boton-home");

        botonHome.addClickListener(e -> UI.getCurrent().navigate(""));
        botonRegresar.addClickListener(e -> UI.getCurrent().navigate("gestion"));

        HorizontalLayout botones = new HorizontalLayout(botonHome, botonRegresar);

        botones.setJustifyContentMode(JustifyContentMode.CENTER);
        botones.setSpacing(true);

        List<Libro> libros = InformacionCompartida.lista_libros; //Cargamos la lista de todos los libros

        Image noLibro = new Image("images/no-libro.png", "Sin libro");
        noLibro.addClassName("imagen-no-libro");

        Paragraph parrafo = new Paragraph("No hay libros disponibles para eliminar.");
        parrafo.addClassName("parrafo");

        if (libros.isEmpty()) {

            add(titulo, parrafo, noLibro, botones);
            return;

        }

        dataProvider = new ListDataProvider<>(libros); //Cargamos la lista de los libros al dataprovider

        grid = new Grid<>(Libro.class, false); //Definimos el grid de clase Libro
        grid.setItems(dataProvider); //Le entregamos la información del data provider
        grid.setSelectionMode(Grid.SelectionMode.MULTI); //Asignamos modo de selección múltiple

        //Ponemos las columnas y le asignamos que va a mostrar cada fila
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

        Button limpiarFiltro = new Button("Limpiar filtros");
        limpiarFiltro.addClassName("boton-limpiar-filtro");

        //Busqueda parcial
        TextField filtroTitulo = new TextField("Buscar por título");
        TextField filtroAutor = new TextField("Buscar por autor");

        filtroTitulo.setPlaceholder("Escribe parte del título");
        filtroAutor.setPlaceholder("Escribe parte del autor");

        filtroGenero.addValueChangeListener(e -> aplicarFiltros(filtroGenero, filtroEstado, filtroTitulo, filtroAutor));
        filtroEstado.addValueChangeListener(e -> aplicarFiltros(filtroGenero, filtroEstado, filtroTitulo, filtroAutor));
        filtroTitulo.addValueChangeListener(e -> aplicarFiltros(filtroGenero, filtroEstado, filtroTitulo, filtroAutor));
        filtroAutor.addValueChangeListener(e -> aplicarFiltros(filtroGenero, filtroEstado, filtroTitulo, filtroAutor));


        limpiarFiltro.addClickListener(e -> {

            filtroGenero.clear();
            filtroEstado.clear();
            filtroTitulo.clear();
            filtroAutor.clear();
            dataProvider.clearFilters();

        });

        //Organizamos una imagen decorativa y el boton para eliminar en un contenedor horizontal
        Image imagenEliminar = new Image("images/logo-basura-render.png", "Icono basura");
        imagenEliminar.addClassName("imagen-eliminar");

        Button eliminar = new Button("Eliminar la selección");
        eliminar.setEnabled(false);

        HorizontalLayout seccionEliminar = new HorizontalLayout(eliminar, imagenEliminar);

        seccionEliminar.setJustifyContentMode(JustifyContentMode.CENTER);
        seccionEliminar.setSpacing(true);

        eliminar.addClassName("boton-eliminar");

        //Estamos pendientes a que haya una operación de selección en el grid para habilidar el botpon
        grid.addSelectionListener(selection -> {

            Set<Libro> seleccionados = selection.getAllSelectedItems();
            eliminar.setEnabled(!seleccionados.isEmpty());

        });

        //Cuando se haga click en el botón eliminaremos toda la seleccion
        eliminar.addClickListener(e -> {

            Set<Libro> seleccionados = grid.getSelectedItems();

            InformacionCompartida.lista_libros.removeAll(seleccionados); //removemos la seleccion de la lista
            dataProvider.getItems().removeAll(seleccionados); //sacamos también los items del data provider para que salgan de grid
            dataProvider.refreshAll();
            Notification.show("Libros eliminados éxitosamente");
            eliminar.setEnabled(false); 

            GestorArchivos.guardarLibros(InformacionCompartida.lista_libros); //Re escribimos la lista en el archivo de texto con la lista ya actualizada

            //Si nos quedamos sin libros para eliminar le informamos al usuario mostrando otra intefaz
            if (InformacionCompartida.lista_libros.isEmpty()) {

                removeAll();
                add(titulo, parrafo, noLibro, botones);

            }

        });

        HorizontalLayout filtros = new HorizontalLayout(filtroGenero, filtroEstado, filtroTitulo, filtroAutor, limpiarFiltro);

        add(titulo, filtros, grid, seccionEliminar, botones);

    }

    //Método para aplicar los filtros
    public void aplicarFiltros(ComboBox<String> filtroGenero, ComboBox<String> filtroEstado, TextField filtroTitulo, TextField filtroAutor) {

        String genero = filtroGenero.getValue();
        String estado = filtroEstado.getValue();
        String titulo = filtroTitulo.getValue() != null ? filtroTitulo.getValue().toLowerCase() : "";
        String autor = filtroAutor.getValue() != null ? filtroAutor.getValue().toLowerCase() : "";

        dataProvider.clearFilters();

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