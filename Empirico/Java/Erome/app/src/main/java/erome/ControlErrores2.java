package erome;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlErrores2 {

    public static void main(String[] args) {

        //Inicialización del escaner
        Scanner escaner = new Scanner(System.in);
        
        //Inicio del bloque try catch general
        try {

            //Declaración de variables
            Integer [] jugadoresOrganizados;
            int puntosAleatorios;
            int [] jugadoresDesorganizados;
            int [][] tabla;
            byte cantidadColumnas = 0, jugador = 1;
            boolean input = true;

            //Recolección de la cantidad de jugadores con control de errores diseñado para forzar al usuario a introducir un valor válido
            while(input) {

                try {
                 
                    System.out.println("Ingresa la cantidad de jugadores (debe ser un número entero entre 1 y 100)");
                    cantidadColumnas = escaner.nextByte();

                    if (cantidadColumnas <= 0 && cantidadColumnas >= 101) {

                        input = true;

                    } else {

                        input = false;

                    }

                } catch (InputMismatchException ime) {

                    System.out.println("Error: La cantidad de jugadores debe ser un número entero entre 1 y 100");
                    escaner.next();

                }

            }

            //Inicialización de los arreglos con sus variables
            tabla = new int [8][cantidadColumnas];
            jugadoresDesorganizados = new int [cantidadColumnas];
            jugadoresOrganizados = new Integer [cantidadColumnas];

            //Llenar la matriz con números aleatorios
            for (byte j = 0; j < cantidadColumnas; j++) {

                tabla[0][j] = jugador;
                jugador++;

                for (byte i = 1; i < 8; i++) {

                    puntosAleatorios = (int)(Math.random() * (100 - 1 + 1)) + 1;
                    tabla[i][j] = puntosAleatorios;

                }

            }            

            //Sumar los puntos de cada jugador y almacenarlos en un vector
            for (byte j = 0; j < cantidadColumnas; j++) {

                for (byte i = 1; i < 8; i++) {

                    jugadoresDesorganizados[j] += tabla[i][j];

                }

            }

            //Pasar los números desorganizados a otro vector que sea de tipo Integer y no de tipo int
            for (byte i = 0; i < cantidadColumnas; i++) {

                jugadoresOrganizados[i] = jugadoresDesorganizados[i];

            }

            //Ordenar los números de mayor a menor mediante este método raro de matrices
            Arrays.sort(jugadoresOrganizados, Collections.reverseOrder());

            //Comienzo de la respuesta
            System.out.println("El orden del puntaje de los jugadores en orden descendente está dado de la siguiente manera\n");

            //Entregar por consola la respuesta con los jugadores de mayor a menor
            for (byte i = 0; i < cantidadColumnas; i++) {

                System.out.println("Jugador " + (i + 1) + ": " + jugadoresOrganizados[i]);

            }

        //Bloques catch según se considere necesario
        } catch(ArrayStoreException ase) {

            System.out.println("Ha ocurrido un error al gestionar la tabla");

        } catch(IndexOutOfBoundsException ioobe) {

            System.out.println("Ha ocurrido un error al gestionar la tabla");

        } finally {

            escaner.close();

            System.out.println("Fin de la ejecución");

        }

    }
    
}