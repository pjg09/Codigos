package gosones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class funciones6 {

    public static void GenerarInformeEstudiantes (String rutaLectura, String rutaEscritura, double notaMinima) {

        String linea = "";
        String [] renglonSeparado;
        double promedio;

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaLectura))) {

            PrintWriter lapiz = new PrintWriter(new FileWriter(rutaEscritura, false));

            while ((linea = reader.readLine()) != null) {

                promedio = 0;

                renglonSeparado = linea.split(";");

                for (int i = 2; i < renglonSeparado.length; i++) {

                    promedio += Double.parseDouble(renglonSeparado[i]);

                }

                promedio = promedio / 4;

                if (promedio >= notaMinima) {

                    lapiz.println("El estudiante " + renglonSeparado[0] + " con ID: " + renglonSeparado[1] + " sacó un promedio de: " + promedio + " por lo tanto aprobó la materia\n");

                } else {

                    lapiz.println("El estudiante " + renglonSeparado[0] + " con ID: " + renglonSeparado[1] + " sacó un promedio de: " + promedio + " por lo tanto se tiró la materia, que bobo\n");

                }

                lapiz.flush();
                lapiz.close();
                reader.close();

            }
            
        } catch (IOException e) {

            System.out.println("Error con el manejo de los archivos");

        }

    }
 
    public static void main(String[] args) {
        
        String rutaLectura = "C:\\Users\\pjgom\\OneDrive\\Desktop\\Programacion\\Codigos\\Empirico\\Java\\Archivos\\Ejercicio 6\\RegistroEstudiantes.txt";
        String rutaEscritura = "C:\\Users\\pjgom\\OneDrive\\Desktop\\Programacion\\Codigos\\Empirico\\Java\\Archivos\\Ejercicio 6\\InformeEstudiantes.txt";
        double notaMinima = 3;

        GenerarInformeEstudiantes(rutaLectura, rutaEscritura, notaMinima);

    }

}