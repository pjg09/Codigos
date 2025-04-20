package logicadeprogramacion;

import java.util.Scanner;

public class matrices {

    public static int [][] llenarMatriz(int[][] matriz) {

        for(int i = 0; i < matriz.length; i++) {

            for(int j = 0; j < matriz[i].length; j++) {

                matriz[i][j] = (int)(Math.random() * (99 - (- 99) + 1)) + (-99);

            }

        }

        return matriz;

    }

    public static void imprimirMatriz (int matriz[][]) {

        String mensaje = "";
        
        for(int i = 0; i < matriz.length; i++) {

            mensaje += "|";

            for(int j = 0; j < matriz[i].length; j++) {

                mensaje += matriz[i][j] + "|";

            }

            mensaje += "\n";

        }

        System.out.println(mensaje);

    }

    public static void diagonalPrincipal(int matriz[][]) {

        String mensaje = "";
        int [] diagonalPrincipal = new int[matriz.length];

        for(int i = 0; i < matriz.length; i++) {

            diagonalPrincipal[i] = matriz[i][i];

        }

        mensaje += "|";

        for(int i = 0; i < matriz.length; i++) {

            mensaje += diagonalPrincipal[i] + "|";

        }

        System.out.println(mensaje);

    }

    public static void diagonalSecundaria(int matriz[][]) {

        String mensaje = "";
        int [] diagonalSecundaria = new int[matriz.length];

        for(int i = 0; i < matriz.length; i++) {

            diagonalSecundaria[i] = matriz[i][matriz.length - i - 1];

        }

        mensaje += "|";

        for(int i = 0; i < matriz.length; i++) {

            mensaje += diagonalSecundaria[i] + "|";

        }

        System.out.println(mensaje);

    }

    public static void escalonadas(int matriz[][]) {

        System.out.println("Escalonada superior");

        for(int i = 0; i < matriz.length; i++) {

            System.out.print("|");

            for(int j = 0; j < matriz[i].length; j++) {

                if(j >= i) {

                    System.out.print(matriz[i][j] + "|");

                } else {

                    System.out.print("0|");

                }

            }

            System.out.println();

        }

        System.out.println("Escalonada inferior");
        
        for(int i = 0; i < matriz.length; i++) {

            System.out.print("|");

            for(int j = 0; j < matriz[i].length; j++) {

                if(j <= i) {

                    System.out.print(matriz[i][j] + "|");

                } else {

                    System.out.print("0|");

                }

            }
            
            System.out.println();
            
        }

    }
 
    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        int tamaño = 0, opcion = 0;
        int matriz[][];
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingresa el tamaño de la matriz");
                    tamaño = usuario.nextInt();

                    if(tamaño < 2) {

                        throw new IllegalArgumentException("Error: la matriz no puede tener menos de 2 filas y 2 columnas");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros para indicar el tamaño de la matriz");
                    usuario.next();

                }

            }

            matriz = new int[tamaño][tamaño];
            matriz = llenarMatriz(matriz);

            while(opcion != 5){

                while(input) {

                    try {

                        System.out.println("Elige\n1. Imprimir matriz.\n2. Imprimir diagonal principal.\n3. Imprimir diagonal secundaria.\n4. Imprimir escalonada superior e inferior.\n5. Salir.");
                        opcion = usuario.nextInt();

                        if(opcion < 1 || opcion > 5) {

                            throw new IllegalArgumentException("Error: solo puedes ingresar numeros entre 1 y 4 para indicar tu eleccion");

                        }

                        input = false;

                    } catch(IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    } catch(Exception e) {

                        System.out.println("Error: solo puedes ingresar numeros enteros");
                        usuario.next();

                    }

                }

                input = true;

                switch(opcion) {

                    case 1:
                        imprimirMatriz(matriz);
                        break;

                    case 2:
                        diagonalPrincipal(matriz);
                        break;

                    case 3:
                        diagonalSecundaria(matriz);
                        break;

                    case 4:
                        escalonadas(matriz);
                        break;

                    default:

                }

            }

        } finally{

            usuario.close();

        }

    }

}