package com.example.Biblioteca.Views;

import com.example.Biblioteca.GestorArchivos;
import com.example.Biblioteca.InformacionCompartida;
import com.example.Biblioteca.Libro;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./AgregarStyle.css")
@Route("agregar")
@PageTitle("Añadir Libros")
public class AgregarView extends VerticalLayout {

    public AgregarView() {

        setAlignItems(Alignment.CENTER);
        setPadding(true);
        setSpacing(true);

        addClassName("fondo");

        //Titulo
        H1 titulo = new H1("Añadir Libros");
        titulo.addClassName("titulo-banner");

        //Banner
        Image imagenBanner = new Image("images/banner-agregar.png", "Banner de la vista agregar");
        imagenBanner.addClassName("imagen-banner");

        //Contenedor más flexible para poner el titulo encima del banner
        Div banner = new Div();
        banner.addClassName("banner");
        banner.add(imagenBanner, titulo);

        Image imagenHome = new Image("https://static.thenounproject.com/png/391821-200.png", "Icono home");
        imagenHome.addClassName("imagen-home");

        //Botones para regresar a gestión y al home
        Button botonHome = new Button(imagenHome);
        Button botonRegresar = new Button("Regresar");
        
        botonRegresar.addClassName("botones");
        botonHome.addClassName("boton-home");

        botonHome.addClickListener(e -> UI.getCurrent().navigate(""));
        botonRegresar.addClickListener(e -> UI.getCurrent().navigate("gestion"));

        HorizontalLayout botones = new HorizontalLayout(botonHome, botonRegresar);

        botones.setJustifyContentMode(JustifyContentMode.CENTER);
        botones.setSpacing(true);

        //Inputs para recolectar la información del libro
        TextField nombreField = new TextField("Nombre del libro");
        TextField autorField = new TextField("Autor");
        ComboBox<String> generoField = new ComboBox<>("Género");
        NumberField anioField = new NumberField("Año");
        ComboBox<String> disponibilidadField = new ComboBox<>("Estado");

        //Lista de géneros constantes, le asignamos a cada ComboBox los elementos que va a mostrar
        generoField.setItems("Ficción", "Romance", "Misterio", "Ciencia Ficción", "Fantasía", "Terror", "Literatura infantil", "No ficción", "Autoayuda", "Historia");
        disponibilidadField.setItems("Disponible", "No disponible");

        //Placeholders para que el usuario tenga una idea de que poner en cada campo
        nombreField.setPlaceholder("Ingresa el nombre del libro");
        autorField.setPlaceholder("Ingresa el autor del libro");
        generoField.setPlaceholder("Selecciona el género del libro");
        anioField.setPlaceholder("Ingresa el año del libro (debe ser un número entre 1000 y 2025)");
        disponibilidadField.setPlaceholder("Selecciona el estado del libro");

        //Tamaño de los fields
        nombreField.setWidth("250%");
        autorField.setWidth("250%");
        generoField.setWidth("250%");
        anioField.setWidth("250%");
        disponibilidadField.setWidth("250%");

        //Indicadores de que los campos obligatorios
        nombreField.setRequiredIndicatorVisible(true);
        autorField.setRequiredIndicatorVisible(true);
        generoField.setRequiredIndicatorVisible(true);
        anioField.setRequiredIndicatorVisible(true);
        disponibilidadField.setRequiredIndicatorVisible(true);

        //Configurar rango del año para el field del año
        anioField.setMin(1000);
        anioField.setMax(2025);
        anioField.setStep(1);

        //Organizamos todos los fields en un contenedo vertical
        VerticalLayout fields = new VerticalLayout(nombreField, autorField, generoField, anioField, disponibilidadField);
        fields.setJustifyContentMode(JustifyContentMode.CENTER);
        fields.setSpacing(true);

        //Imagen que va quedar junto a los fields
        Image imagenAgregar = new Image("images/agregar.PNG", "Señor llevando libros");

        //Colocamos el contenedor vertical y la imagen en un contenedor horizontal
        HorizontalLayout formulario = new HorizontalLayout(fields, imagenAgregar);
        formulario.setJustifyContentMode(JustifyContentMode.CENTER);
        formulario.setSpacing("280px");
        
        //Boton para agregar un libro que solo estará disponible al llenar todos los campos exitosamente
        Button agregarLibro = new Button("Agregar Libro");
        agregarLibro.setEnabled(false); //El botón comienza desactivado

        agregarLibro.addClassName("boton-agregar");

        //Validación para activar el botón
        Runnable validar = () -> {

            //Si se cumplen todas las condiciones la variable será true y se habilitará el botón
            boolean valido = !nombreField.isEmpty() && !autorField.isEmpty() && generoField.getValue() != null 
            && anioField.getValue() != null && anioField.getValue() >= 1000 && anioField.getValue() <= 2025 
            && disponibilidadField.getValue() != null;

            agregarLibro.setEnabled(valido);

        };

        //Comprobaciones en tiempo real para activar la validación, siempre que haya un cambio en un field se comprueba si el botón puede habilitarse
        nombreField.addValueChangeListener(e -> validar.run());
        autorField.addValueChangeListener(e -> validar.run());
        generoField.addValueChangeListener(e -> validar.run());
        anioField.addValueChangeListener(e -> validar.run());
        disponibilidadField.addValueChangeListener(e -> validar.run());

        //Esto va a ocurrir cuando se haga click en el boton, lo más importante es que el tipo de dato para el año sea correcto y no llegue un tipo de dato no soportado por el tipo short
        agregarLibro.addClickListener(e -> {

            //Control de errores para ver si la información de los fields es correcta
            try {

                //Convertimos todos los datos de tipo field a tipos con los que podemos trabajar
                String tituloLibro = nombreField.getValue();
                String autor = autorField.getValue();
                String genero = generoField.getValue();
                Double valorAnio = anioField.getValue(); //Porque numberField por defecto me recibe son decimales
                String disponibilidad = disponibilidadField.getValue();
                boolean estado = true;

                //Validamos que el nombre y el autor del libro no comiencen con espacios en blancos para evitar que nos introduzcan solo espacios vacios en uno de estos campos
                if (tituloLibro.startsWith(" ")) {

                    Notification.show("El nombre del libro no puede comenzar con un espacio");
                    return;

                }

                if (autor.startsWith(" ")) {

                    Notification.show("El nombre del autor no puede comenzar con un espacio");
                    return;

                }

                //Validamos el año
                if (valorAnio % 1 != 0) {

                    Notification.show("El año debe ser un numero entero");
                    return;

                }

                if (valorAnio == null || valorAnio < 1000 || valorAnio > 2025) {

                    Notification.show("El año debe estar entre 1000 y 2025");
                    return;

                }

                if (disponibilidad.matches("No disponible")) {

                    estado = false;

                }

                //Convertimos el año a short porque numberfield nos lo había entregado en double
                short anio = valorAnio.shortValue();

                //Creamos el libro y lo guardamos en la lista
                Libro nuevoLibro = new Libro(tituloLibro, autor, genero, anio, estado);
                InformacionCompartida.lista_libros.add(nuevoLibro); //Agregamos el libro a la lista de los libros
                GestorArchivos.guardarLibros(InformacionCompartida.lista_libros); //Con la lista de libros actualizada volvemos a reescribir el archivo

                Notification.show("Libro agregado con éxtio");

                //Limpiamos los campos
                nombreField.clear();
                autorField.clear();
                generoField.clear();
                anioField.clear();
                disponibilidadField.clear();
                agregarLibro.setEnabled(false);

            } catch (Exception ex) {

                Notification.show("Error: no se pudo agregar el libro, revisa la información");

            }

        });

        add(banner, formulario, agregarLibro, botones);

    }

}