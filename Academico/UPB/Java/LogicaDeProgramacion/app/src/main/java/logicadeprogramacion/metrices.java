package logicadeprogramacion;

import java.util.Scanner;

public class metrices {
 
    public static void main(String[] args) {
        
        //Declaracion de variables

        Scanner usuario = new Scanner(System.in);
        String [][] tablaNombres = new String [2][2];
        int filas = 0, columnas = 0;
        int [][] tablaNumeros = {{2, 4, 6}, {8, 10, 12}, {14, 16, 18}};

        //Proceso

        filas = tablaNumeros.length;
        columnas = tablaNumeros[0].length;

        //Recorrido de filas a columnas

        System.out.println("Recorrido de filas a columnas");

        for(int i = 0; i < filas; i++) {

            for(int j = 0; j < columnas; j++) {

                System.out.println(" | " + tablaNumeros [i][j]);

            }

            System.out.println("");

        }

        System.out.println("");

        //Recorrido de columnas a filas

        System.out.println("Recorrido de columnas a filas");

        for(int j = 0; j < columnas; j++) {

            for(int i = 0; i < filas; i++) {

                System.out.println(" | " + tablaNumeros [i][j]);

            }

            System.out.println("");

        }

        System.out.println("");

        //Diagonal de la matriz

        System.out.println("Diagonal de la matriz");

        for(int j = 0; j < columnas; j++) {

            System.out.println(" | " + tablaNumeros [j][j]);

        }

        System.out.println("");

        //Diagonal secundaria de la matriz

        System.out.println("Diagonal secundaria de la matriz");

        for(int i = filas; i < columnas; i--) {

            System.out.println(" | " + tablaNumeros [i][i]);

        }

        System.out.println("");

        //Recorrido para asignar datos

        System.out.println("Recorrido para asginar datos");

        for(int i = 0; i < tablaNombres.length; i++) {

            for(int j = 0; j < tablaNombres[0].length; j++) {

                System.out.println("Ingrese el nombre para la fila " + (i + 1) + " y la columna " + (j + 1));
                tablaNombres[i][j] = usuario.nextLine();

            }

        }

        System.out.println("");

        for(int i = 0; i < tablaNombres.length; i++) {

            for(int j = 0; j < tablaNombres[0].length; j++) {

                System.out.println(" | " + tablaNombres[i][j]);

            }

        }

        System.out.println("");

        usuario.close();

    }

}