package erome;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class archivos2 {
 
    public static void main(String[] args) {
        
        //Inicio del bloque try catch general
        try {

            //Herramientas para la lectura del archivo
            String ruta = "C:\\Users\\pjgom\\OneDrive\\Desktop\\Programacion\\Codigos\\Empirico\\Java\\Archivos\\Ejercicio 3\\Notas.txt";
            File archivo = new File(ruta);
            FileReader leerArchivo = new FileReader(archivo);
            BufferedReader cargarArchivo = new BufferedReader(leerArchivo);
            String linea = "";

            //Vectores para manejar las líneas de los archivos
            String [] separarNombres;
            String [] separarNotas;

            //Declaración de variables
            String respuesta = "";

            int cantidadEstudiantes = 0, gananCurso = 0, pierdenCurso = 0;

            double nota1, nota2, nota3, promedio, notaPromedio, notaMasAlta = 0, notaMasBaja = 5, sumaNotas = 0, pesoNota1 = 0.2, pesoNota2 = 0.4, pesoNota3 = 0.4;

            //Inicio de la lectura del archivo
            while ((linea = cargarArchivo.readLine()) != null) {

                //Contamos la cantidad de estudiantes
                cantidadEstudiantes++;

                //Separamos el nombre del estudiante de las notas
                separarNombres = linea.split(":");

                //Encasillamos cada nota en un vector para verlas por separado y parsearlas
                separarNotas = separarNombres[1].split(";");

                //Cada estudiante solo puede tener 3 notas, entonces validamos, si, en efecto solo hay 3 notas por estudiante, si hay más lanzamos excepción
                if (separarNotas.length >= 4) {

                    throw new Exception("Error: el/la estudiante " + separarNombres[0] + " tiene más de tres notas");

                }

                //Convertimos cada nota a una variable de tipo entero para poder hacer los cáclulos con ellas
                nota1 = Double.parseDouble(separarNotas[0]);
                nota2 = Double.parseDouble(separarNotas[1]);
                nota3 = Double.parseDouble(separarNotas[2]);

                //Las notas de los estudiantes deben ser numeros décimales de 0 a 5, válidamos si alguna nota es mayor a 5 o menor a 0
                if (nota1 < 0 || nota1 > 5) {

                    throw new Exception("Error: la nota 1 de el/la estudiante " + separarNombres[0] + " es incorrecta (" + nota1 + ")\nEsta debe estar entre 0 y 5");

                }

                if (nota2 < 0 || nota2 > 5) {

                    throw new Exception("Error: la nota 2 de el/la estudiante " + separarNombres[0] + " es incorrecta (" + nota2 + ")\nEsta debe estar entre 0 y 5");

                }

                if (nota3 < 0 || nota3 > 5) {

                    throw new Exception("Error: la nota 3 de el/la estudiante " + separarNombres[0] + " es incorrecta (" + nota3 + ")\nEsta debe estar entre 0 y 5");

                }

                //Calculamos el promedio de cada estudiante
                promedio = (nota1 * pesoNota1) + (nota2 * pesoNota2) + (nota3 * pesoNota3);


                //Construimos la respuesta
                respuesta += "El promedio de el/la estudiante " + separarNombres[0] + " es de: " + promedio + "\n";

                //Comprobamos cuantos estudiantes ganaron el curso
                if (promedio >= 3) {

                    gananCurso++;

                }

                //Sumamos todas las notas para después cálcular la nota promedio
                sumaNotas += nota1 + nota2 + nota3;

                //Determinamos cual es la nota más alta
                if (nota1 > notaMasAlta) {

                    notaMasAlta = nota1;

                }

                if (nota2 > notaMasAlta) {

                    notaMasAlta = nota2;

                }

                if (nota3 > notaMasAlta) {

                    notaMasAlta = nota3;

                }

                //Determinamos cual es la nota más baja
                if (nota1 < notaMasBaja) {

                    notaMasBaja = nota1;

                }

                if (nota2 < notaMasBaja) {

                    notaMasBaja = nota2;

                }

                if (nota3 < notaMasBaja) {

                    notaMasBaja = nota3;

                }

            }

            //Calculamos cuantos estudiantes perdieron el curso
            pierdenCurso = cantidadEstudiantes - gananCurso;

            //Calculamos la nota promedio
            notaPromedio = sumaNotas / (cantidadEstudiantes * 3);

            //Entregamos la respuesta
            System.out.println("El curso tuvo " + cantidadEstudiantes + " estudiantes\nEl curso fue aprobado por " + gananCurso + " estudiantes\n" + pierdenCurso + " estudiantes perdieron el curso\nLa nota promedio fue " + notaPromedio + "\nLa nota más alta fue " + notaMasAlta + "\nLa nota más baja fue " + notaMasBaja + "\n" + respuesta);

            cargarArchivo.close();
            
        } catch (IOException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}