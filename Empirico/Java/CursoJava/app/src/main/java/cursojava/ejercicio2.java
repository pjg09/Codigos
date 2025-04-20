package cursojava;

import java.util.Scanner;

public class ejercicio2 {

    public static void main(String[] args) {

        System.out.println("Programa para ingresar y promediar las notas de tres alumnos.");
        System.out.println("Recuerde que cada nota tiene el mismo peso.");
        
        Scanner usuario = new Scanner (System.in);
        double matriz [][] = new double [4][4];
        String alumno1 = "";
        String alumno2 = "";
        String alumno3 = "";
        String alumno4 = "";
        String cuestion = "";
        byte contador = 0;

        System.out.println("Ingrese el nombre del primer alumno: ");
        alumno1 = usuario.nextLine();

        System.out.println("Ingrese el nombre del segundo alumno: ");
        alumno2 = usuario.nextLine();

        System.out.println("Ingrese el nombre del tercer alumno: ");
        alumno3 = usuario.nextLine();

        System.out.println("Ingrese el nombre del cuarto alumno: ");
        alumno4 = usuario.nextLine();

        for (byte filas = 0; filas <= 3; filas++) {

            if (contador == 0) {

                cuestion = alumno1;

            } else {

                if (contador == 1) {

                    cuestion = alumno2;

                } else {

                    if (contador == 2) {

                        cuestion = alumno3;

                    } else {

                        if (contador == 3) {

                            cuestion = alumno4;

                        }

                    }

                }

            }

            for (byte columnas = 0; columnas <= 3; columnas++) {

                
                System.out.println("Ingrese la nota del estudiante " + cuestion);
                matriz [filas][columnas] = usuario.nextDouble();

            }

            contador++;

        }

        matriz [0] [3] = (matriz [0][0] + matriz [0][1] + matriz [0][2]) / 3;
        matriz [1] [3] = (matriz [1][0] + matriz [1][1] + matriz [1][2]) / 3;
        matriz [2] [3] = (matriz [2][0] + matriz [2][1] + matriz [2][2]) / 3;
        matriz [3] [3] = (matriz [3][0] + matriz [3][1] + matriz [3][2]) / 3;

        System.out.println("Las notas del alumno " + alumno1 + " son " + matriz [0][0] + ", " + matriz [0][1] + ", " + matriz [0][2] + ", y el promedio es de " + matriz [0][3]);
        System.out.println("Las notas del alumno " + alumno2 + " son " + matriz [1][0] + ", " + matriz [1][1] + ", " + matriz [1][2] + ", y el promedio es de " + matriz [1][3]);
        System.out.println("Las notas del alumno " + alumno3 + " son " + matriz [2][0] + ", " + matriz [2][1] + ", " + matriz [2][2] + ", y el promedio es de " + matriz [2][3]);
        System.out.println("Las notas del alumno " + alumno4 + " son " + matriz [3][0] + ", " + matriz [3][1] + ", " + matriz [3][2] + ", y el promedio es de " + matriz [3][3]);

        usuario.close();
    }
    
}