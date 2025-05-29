package com.example.Biblioteca.Views;

import com.example.Biblioteca.GestorArchivos;
import com.example.Biblioteca.InformacionCompartida;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./MainStyle.css")
@Route("")
@PageTitle("Biblioteca")
public class MainView extends VerticalLayout {

    public MainView() {

        //Cargamos la informacion de los libros sobre escribiendo la que había desde antes, esta informacion se guarda en las listas de la clase información compartida
        InformacionCompartida.lista_libros = GestorArchivos.leerLibros();
        InformacionCompartida.lista_prestamos = GestorArchivos.leerPrestamos();

        setAlignItems(Alignment.CENTER);
        setPadding(true);
        setSpacing(true);  
        addClassName("fondo");                   

        //Titulo
        H1 titulo = new H1("Sistema de Gestión de Biblioteca");
        titulo.addClassName("titulo");

        //Botones para navegar por las otras vistas
        Button gestion = new Button("Gestionar Libros");
        Button prestamos = new Button("Prestar Libros");
        Button estadisticas = new Button("Ver Estadisticas");

        Image imagen = new Image("images/imagen-bienvenida.JPG", "Imagen de bienvenida");

        //Les asignamos la clases para retocarlas en el css
        imagen.addClassName("imagen-bienvenida");
        gestion.addClassName("botones");
        prestamos.addClassName("botones");
        estadisticas.addClassName("botones");

        //Configuramos las redirecciones de los botones
        gestion.addClickListener(e -> UI.getCurrent().navigate("gestion"));
        prestamos.addClickListener(e -> UI.getCurrent().navigate("prestamos"));
        estadisticas.addClickListener(e -> UI.getCurrent().navigate("estadistica"));

        //Organizamos los botones en un layout horizontal centrado
        HorizontalLayout botones = new HorizontalLayout(gestion, prestamos, estadisticas);
        botones.setJustifyContentMode(JustifyContentMode.CENTER);
        botones.setSpacing(true);

        add(titulo, imagen, botones);

    }

}