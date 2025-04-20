package erome;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class archivos1 {

    public static void main(String[] args) {
        
        try {

            //Herramientas para manejar las fechas
            //DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            //LocalDate fechaNacimiento;
            //LocalDate fechaActual;

            //Period edad;

            //Rutas de los archivos
            String rutaLectura = "C:\\Users\\pjgom\\OneDrive\\Desktop\\Programacion\\Codigos\\Empirico\\Java\\Archivos\\Ejercicio 2\\pacientes.csv";
            String rutaEscritura = "C:\\Users\\pjgom\\OneDrive\\Desktop\\Programacion\\Codigos\\Empirico\\Java\\Archivos\\Ejercicio 2\\edadesPacientes.txt";

            //Herramienta para ver la información de cada renglón del archivo
            String linea = "";

            //Vector para separar las fechas de cada renglón
            String [] informacion, fechaDesglosada;

            int anioNacimiento, mesNacimiento, diaNacimiento, anioActual = 2025, mesActual = 4, diaActual = 9, edad;
            
            //Variable para controlar que número de paciente va
            int iteraciones = 1;

            //Lectura Archivos
            File ubicacionLectura = new File(rutaLectura);
            FileReader archivoLectura = new FileReader(ubicacionLectura);
            BufferedReader datosMemoria = new BufferedReader(archivoLectura);

            //Escritura Archivos
            FileWriter archivoEscritura = new FileWriter(rutaEscritura, false);
            PrintWriter escritura = new PrintWriter(archivoEscritura);

            //Saltamos del encabezado del archivo a las fechas
            linea = datosMemoria.readLine();

            //Ciclo para recorrer renglón por renglón del archivo
            while((linea = datosMemoria.readLine()) != null) {

                informacion = linea.split("\\t");

                //fechaNacimiento = LocalDate.parse(informacion[0], formatoFecha);
                //fechaActual = LocalDate.now();
                //edad = Period.between(fechaNacimiento, fechaActual);

                //escritura.println("Paciente #" + iteraciones + " - " + edad.getYears() + " Años");

                fechaDesglosada = informacion[0].split("/");

                anioNacimiento = Integer.parseInt(fechaDesglosada[2]);
                mesNacimiento = Integer.parseInt(fechaDesglosada[1]);
                diaNacimiento = Integer.parseInt(fechaDesglosada[0]);

                if (mesNacimiento > mesActual) {

                    edad = anioActual - anioNacimiento - 1;

                } else if (mesNacimiento == mesActual) {

                    if (diaNacimiento > diaActual) {

                        edad = anioActual - anioNacimiento - 1;

                    } else {

                        edad = anioActual - anioNacimiento;

                    }

                } else {

                    edad = anioActual - anioNacimiento;

                }

                escritura.println("Paciente #" + iteraciones + " - " + edad + " Años");

                iteraciones++;

            }

            datosMemoria.close();
            escritura.close();
            
        } catch (IOException io) {

            System.out.println("Ha ocurrido un error con el manejo de los archivos " + io.getMessage());

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }
    
}