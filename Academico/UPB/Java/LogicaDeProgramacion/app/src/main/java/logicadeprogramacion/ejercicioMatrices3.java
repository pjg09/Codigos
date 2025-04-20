// Ejercicio 2 del taller de matrices de Rojas Higuita

package logicadeprogramacion;

import java.util.Scanner;

public class ejercicioMatrices3 {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        String respuesta1 = "", respuesta2 = "", respuesta3 = "";
        int matriz1 [][];
        int matriz2 [][];
        int matrizResultado [][];
        int filas = 0, columnas = 0;
        boolean input = false;

        try {

            System.out.println("Programa para multiplicar dos matrices cuadradas o rectangulares del mismo tamaño con numeros aleatorios");

            while(!input) {

                try {

                    System.out.println("Ingresa la cantidad de filas para las matrices:");
                    filas = usuario.nextInt();

                    if(filas < 2) {

                        throw new IllegalArgumentException("Error: debes ingresar un numero mayor a 2 para declarar la cantidad de filas de la matriz\nIntentalo de nuevo");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros para declarar la cantidad de filas de la matriz\n");
                    usuario.next();

                }

            }

            while(input) {

                try {

                    System.out.println("Ingresa la cantidad de columnas para las matrices:");
                    columnas = usuario.nextInt();

                    if(columnas < 2) {

                        throw new IllegalArgumentException("Error: debes ingresar un numero mayor a 2 para declarar la cantidad de columnas de la matriz\nIntentalo de nuevo");

                    }

                    input = false;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros para declarar la cantidad de columnas de la matriz\n");
                    usuario.next();

                }

            }

            matriz1 = new int [filas][columnas];
            matriz2 = new int [filas][columnas];
            matrizResultado = new int [filas][columnas];

            for(int i = 0; i < filas; i++) {

                for(int j = 0; j < columnas; j++) {

                    matriz1[i][j] = (int) (Math.random() * (9 - 1 + 1)) + 1;
                    matriz2[i][j] = (int) (Math.random() * (9 - 1 + 1)) + 1;

                }

            }

            for(int i = 0; i < filas; i++) {

                respuesta1 += "|";
                respuesta2 += "|";
                respuesta3 += "|";

                for(int j = 0; j < columnas; j++) {

                    matrizResultado[i][j] = matriz1[i][j] * matriz2[i][j];
                    respuesta1 += matriz1[i][j] + "|";
                    respuesta2 += matriz2[i][j] + "|";
                    respuesta3 += matrizResultado[i][j] + "|";

                }

                respuesta1 += "\n";
                respuesta2 += "\n";
                respuesta3 += "\n";

            }

        } finally {

            System.out.println("La multiplicacion de la matriz:\n" + respuesta1 + "con la matriz\n" + respuesta2 + " da como resultado la matriz\n" + respuesta3);

            usuario.close();

        }

    }
    
}