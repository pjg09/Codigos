package com.example.Biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//En esta clase vamos a manejar todo lo que es escritura y lectura de archivos por lo que esta clase no tendrá ni atributos ni constructor
public class GestorArchivos {

    //En estas constantes vamos a almacenar las rutas relativas de los archivos
    public static final String rutaLibros = "src/main/resources/data/libros.txt";
    public static final String rutaPrestamos = "src/main/resources/data/prestamos.txt";
    public static final String rutaEstadisticas = "src/main/resources/data/estadisticas.txt";

    //Este método va a leer los libros que están guardados en el archivo para cargarlos en cada nueva ejecución de la aplicación y tener una especie de base de datos
    public static List<Libro> leerLibros() {

        List<Libro> libros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaLibros))) {

            String linea;

            while((linea = br.readLine()) != null) {

                String [] partes = linea.split("\\|");

                if (partes.length == 5) {

                    String titulo = partes[0];
                    String autor = partes[1];
                    String genero = partes[2];
                    short anio = Short.parseShort(partes[3]);
                    boolean disponibilidad = Boolean.parseBoolean(partes[4]);

                    Libro libro = new Libro(titulo, autor, genero, anio, disponibilidad);
                    
                    libros.add(libro);

                }

            }

        } catch (Exception e) {

            System.out.println("Error al leer libros: " + e.getMessage());

        }

        return libros;

    }

    //Este método va a guardar cualquer cambio que haya en los libros para actualizar el archivo y tener siempre la información actualizada
    public static void guardarLibros(List<Libro> libros) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaLibros))) {

            for (Libro libro : libros) {

                writer.println(libro.getTitulo() + "|" + libro.getAutor() + "|" + libro.getGenero() + "|" + libro.getAnio() + "|" + libro.getDisponibilidad());

            }

        } catch (Exception e) {

            System.out.println("Error al guardar libros: " + e.getMessage());

        }

    }

    //Este método va a leer los prestamos que están guardados en el archivo para cargarlos en cada nueva ejecución de la aplicación y tener una especie de base de datos
    public static List<Prestamo> leerPrestamos() {

        List<Prestamo> prestamos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaPrestamos))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split("\\|");

                if (partes.length == 3) {

                    String titulo = partes[0];
                    String persona = partes[1];
                    LocalDate fecha = LocalDate.parse(partes[2]);

                    Libro libro = InformacionCompartida.lista_libros.stream().filter(l -> l.getTitulo().equals(titulo)).findFirst().orElse(null);

                    if (libro != null) {

                        Prestamo prestamo = new Prestamo(libro, persona, fecha);

                        prestamos.add(prestamo);

                    }

                }

            }

        } catch (Exception e) {

            System.out.println("Error al leer préstamos: " + e.getMessage());

        }

        return prestamos;

    }

    //Este método va a registrar los nuevos prestamos para actualizar el archivo y tener siempre la información actualizada
    public static void guardarPrestamos(List<Prestamo> prestamos) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaPrestamos, false))) {

            for (Prestamo prestamo : prestamos) {

                writer.println(prestamo.getLibro().getTitulo() + "|" + prestamo.getPersona() + "|" + prestamo.getFecha());

            }

        } catch (Exception e) {

            System.out.println("Error al guardar préstamos: " + e.getMessage());

        }

    }

    //Este método se va a encargar de reescribir las estadísticas cada vez que entremos a la vista de estadísticas
    public static void guardarEstadisticas(String resumen) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaEstadisticas))) {

            writer.println(resumen);

        } catch (Exception e) {

            System.out.println("Error al guardar estadísticas: " + e.getMessage());

        }

    }

}