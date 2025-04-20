package logicadeprogramacion;

import java.util.Scanner;

public class parcial3ej4 {

    public static int [][] m_numeros() {

        try {

        int orden = (int)(Math.random() * (9  - 6 + 1)) + 6;
        int [][] matriz = new int [orden][orden];

        return matriz;

        } catch(Exception e) {

            throw(e);

        }

    }

    public static int [][] LlenarDiagonalPrincipal(int [][] matriz) {

        try {

            for(int i = 0; i < matriz.length; i++) {

                int numero = (int)(Math.random() * (15 - 5 + 1)) + 5;
                matriz[i][i] = numero;             

            }

            return matriz;

        } catch(Exception e) {

            throw(e);

        }

    }

    public static int [][] LlenarSobre(int [][] matriz) {

        try {

            for(int i = 0; i < matriz.length; i++) {

                int numero = (int)(Math.random() * (40 - 1 + 1)) + 1;

                if(numero >= matriz[i][i]) {

                    matriz[i][i] = numero;

                } else {

                    matriz[i][i] = 0;

                }

            }

            return matriz;

        } catch(Exception e) {

            throw(e);

        }

    }

    public static void ImprimirMatriz(int [][] matriz) {

        try {

            for(int i = 0; i < matriz.length; i++) {

                for(int j = 0; j < matriz[i].length; j++) {

                    System.out.println(" | " + matriz[i][j]);

                }

                System.out.println("");

            }

        } catch(Exception e) {

            throw(e);

        }

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        int matriz [][] = m_numeros();
        byte opcion = 0;
        boolean input = false;

        while(opcion != 3) {

            while(!input) {

                try {

                    System.out.println("Ingrese su opcion \n1. Llenar diagonal principal con numeros aleatorios del 5 al 15\n2. Llenar la diagonal principal con numeros del 1 al 40\n3. Imprimir la matriz");
                    opcion = usuario.nextByte();

                    if(opcion < 1 || opcion > 3) {

                        throw new IllegalArgumentException("Error: solo puedes ingresar numeros entre 1 y 3 para indicar tu elección");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros paar indicar tu eleccion");
                    usuario.next();

                }

            }

            switch(opcion) {

                case 1:
                    matriz = LlenarDiagonalPrincipal(matriz);
                    break;

                case 2:
                    matriz = LlenarSobre(matriz);
                    break;

                default:
                    break;

            }

            input = false;

        }

        ImprimirMatriz(matriz);

        usuario.close();

    }
    
}