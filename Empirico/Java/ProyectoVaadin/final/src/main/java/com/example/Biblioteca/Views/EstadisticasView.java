package com.example.Biblioteca.Views;

import java.util.List;
import java.util.stream.Collectors;

import com.example.Biblioteca.GestorArchivos;
import com.example.Biblioteca.InformacionCompartida;
import com.example.Biblioteca.Libro;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./EstadisticaStyle.css")
@Route("estadistica")
@PageTitle("Estadisticas")
public class EstadisticasView extends VerticalLayout {

    public EstadisticasView() {

        setAlignItems(Alignment.CENTER);
        setPadding(true);
        setSpacing(true);
        addClassName("fondo");

        H1 titulo = new H1("Estadisticas de la Biblioteca");
        titulo.addClassName("titulo");

        Image imagenHome = new Image("https://static.thenounproject.com/png/391821-200.png", "Icono home");
        imagenHome.addClassName("imagen-home");

        Button botonHome = new Button(imagenHome);
        botonHome.addClassName("boton-home");
        botonHome.addClickListener(e -> UI.getCurrent().navigate(""));

        HorizontalLayout botones = new HorizontalLayout(botonHome);

        botones.setJustifyContentMode(JustifyContentMode.CENTER);
        botones.setSpacing(true);

        List<Libro> libros = InformacionCompartida.lista_libros;

        String resumen = generarResumenEstadisticas(libros);

        GestorArchivos.guardarEstadisticas(resumen);

        Image noLibro = new Image("images/no-libro.png", "Sin libro");
        noLibro.addClassName("imagen-no-libro");

        Paragraph parrafo = new Paragraph("No hay libros disponibles para generar ninguna estadística.");
        parrafo.addClassName("parrafo");

        if (libros.isEmpty()) {

            add(titulo, parrafo, noLibro, botones);
            return;

        }

        add(titulo);

        //Sección para el total de libros
        agregarSeccion("Total de libros: " + libros.size(), libros);

        //Sección para el total de libros disponibles
        List<Libro> librosDisponibles = libros.stream().filter(Libro::getDisponibilidad).collect(Collectors.toList());
        agregarSeccion("Libros disponibles: " + librosDisponibles.size(), librosDisponibles);

        //Sección para el total de libros prestados
        List<Libro> librosPrestados = libros.stream().filter(libro -> !libro.getDisponibilidad()).collect(Collectors.toList());
        agregarSeccion("Libros prestados: " + librosPrestados.size(), librosPrestados);

        //Despliegue de las secciones de los libros por género
        String [] generos = {"Ficción", "Romance", "Misterio", "Ciencia Ficción", "Fantasía", "Terror", "Literatura infantil", "No ficción", "Autoayuda", "Historia"};

        for (String genero : generos) {

            List<Libro> librosGenero = libros.stream().filter(libro -> libro.getGenero().equals(genero)).collect(Collectors.toList());
            agregarSeccion("Libros del género \"" + genero + "\": " + librosGenero.size(), librosGenero);

        }

        add(botones);

    }

    public void agregarSeccion(String tituloTexto, List<Libro> libros) {

        Paragraph titulo = new Paragraph(tituloTexto);
        addClassName("seccion");

        ListDataProvider<Libro> dataProvider = new ListDataProvider<>(libros);

        add(titulo);

        Grid<Libro> grid = new Grid<>(Libro.class, false);
        grid.setDataProvider(dataProvider);
        grid.addColumn(Libro::getTitulo).setHeader("Título");
        grid.addColumn(Libro::getAutor).setHeader("Autor");
        grid.addColumn(Libro::getGenero).setHeader("Género");
        grid.addColumn(Libro::getAnio).setHeader("Año");
        grid.addColumn(libro -> libro.getDisponibilidad() ? "Disponible" : "Prestado").setHeader("Estado");
        grid.setVisible(false);

        TextField filtroTitulo = new TextField("Buscar por título");
        filtroTitulo.setPlaceholder("Ingresa el nombre del libro");

        TextField filtroAutor = new TextField("Buscar por autor");
        filtroAutor.setPlaceholder("Ingresa el nombre del autor");
        
        filtroTitulo.addValueChangeListener(e -> aplicarFiltros(filtroTitulo, filtroAutor, dataProvider));
        filtroAutor.addValueChangeListener(e -> aplicarFiltros(filtroTitulo, filtroAutor, dataProvider));

        Button limpiarFiltro = new Button("Limpiar Filtros");

        limpiarFiltro.addClassName("boton-limpiar-filtro");

        limpiarFiltro.addClickListener(e -> {

            filtroTitulo.clear();
            filtroAutor.clear();
            dataProvider.clearFilters();

        });

        HorizontalLayout filtros = new HorizontalLayout(filtroTitulo, filtroAutor, limpiarFiltro);
        filtros.setVisible(false);

        Button mostrar = new Button("Ver libros");
        mostrar.addClassName("botones-mostrar");
        mostrar.addClickListener(e -> grid.setVisible(true));
        mostrar.setEnabled(!libros.isEmpty());

        Button ocultar = new Button("Ocultar");
        ocultar.setVisible(false);
        ocultar.addClassName("botones");
        ocultar.addClickListener(e -> {

            grid.setVisible(false);
            ocultar.setVisible(false);
            filtros.setVisible(false);
            filtroTitulo.clear();
            filtroAutor.clear();
            dataProvider.clearFilters();

        });

        mostrar.addClickListener(e -> {

            grid.setVisible(true);
            ocultar.setVisible(true);
            filtros.setVisible(true);

        });

        add(mostrar, filtros, grid, ocultar);

    }

    public void aplicarFiltros(TextField filtroTitulo, TextField filtroAutor, ListDataProvider<Libro> dataProvider) {

        String titulo = filtroTitulo.getValue() != null ? filtroTitulo.getValue().toLowerCase() : "";
        String autor = filtroAutor.getValue() != null ? filtroAutor.getValue().toLowerCase() : "";

        dataProvider.clearFilters();

        if (!titulo.isEmpty()) {

            dataProvider.addFilter(libro -> libro.getTitulo().toLowerCase().contains(titulo));

        }

        if (!autor.isEmpty()) {

            dataProvider.addFilter(libro -> libro.getAutor().toLowerCase().contains(autor));

        }

    }

    public String generarResumenEstadisticas(List<Libro> libros) {

        String resumen = "Estadísticas de la Biblioteca\n\n";

        resumen += "Total de libros: " + libros.size() + "\n";

        long disponibles = libros.stream().filter(Libro::getDisponibilidad).count();
        long prestados = libros.stream().filter(libro -> !libro.getDisponibilidad()).count();

        resumen += "Libros disponibles: " + disponibles + "\n";
        resumen += "Libros prestados: " + prestados + "\n\n";

        resumen += "Libros por género:\n";

        String [] generos = {"Ficción", "Romance", "Misterio", "Ciencia Ficción", "Fantasía", "Terror", "Literatura infantil", "No ficción", "Autoayuda", "Historia"};

        for (String genero : generos) {

            long librosGenero = libros.stream().filter(libro -> libro.getGenero().equals(genero)).count();
            resumen += "Libros del género \"" + genero + "\": " + librosGenero + "\n";

        }

        return resumen;
        
    }

}