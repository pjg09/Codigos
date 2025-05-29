package com.example.Biblioteca.Views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./GestionStyle.css")
@Route("gestion")
@PageTitle("Gestionar Libros")
public class GestionView extends VerticalLayout {

    public GestionView() {

        setAlignItems(Alignment.CENTER);
        setPadding(true);
        setSpacing(true);

        addClassName("fondo");

        //Titulo
        H1 titulo = new H1("Gestión de Libros");
        titulo.addClassName("titulo");

        //Imagen de bienvenida a la vista
        Image imagenBienvenida = new Image("images/fondo-gestion.jpg", "Imagen de bienvenida");
        imagenBienvenida.addClassName("imagen");

        //Botones para navegar por las demas vistas
        Button agregar = new Button("Agregar libros");
        Button eliminar = new Button("Eliminar libros");
        Button modificar = new Button("Modificar libros");
        Image imagenHome = new Image("https://static.thenounproject.com/png/391821-200.png", "Icono home");
        Button home = new Button(imagenHome);

        //Le asignamos las clases a los botones para darles la estetica
        imagenHome.addClassName("imagen-home");
        home.addClassName("boton-home");
        agregar.addClassName("botones");
        eliminar.addClassName("botones");
        modificar.addClassName("botones");

        //Configuramos las redirecciones
        agregar.addClickListener(e -> UI.getCurrent().navigate("agregar"));
        eliminar.addClickListener(e -> UI.getCurrent().navigate("eliminar"));
        modificar.addClickListener(e -> UI.getCurrent().navigate("modificar"));
        home.addClickListener(e -> UI.getCurrent().navigate(""));

        //Organizamos los botones de manera horizontal
        HorizontalLayout botones = new HorizontalLayout(agregar, eliminar, modificar);
        botones.setJustifyContentMode(JustifyContentMode.CENTER);
        botones.setSpacing(true);

        add(titulo, imagenBienvenida, botones, home);

    }

}