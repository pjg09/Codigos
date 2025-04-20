package logicadeprogramacion;

import javax.swing.*;

public class ejercicioMatrices {

    public static int[][] llenarAleatorios(int[][] matriz) {

        try {

            int[][] matrizResultado = new int[matriz.length][matriz.length];

            for(int i = 0; i < matrizResultado.length; i++) {

                for(int j = 0; j < matrizResultado[i].length; i++) {

                    matrizResultado[i][j] = (int)Math.round(Math.random() * (9) + 1);

                }

            }

            return matrizResultado;

        } catch(Exception e) {

            throw(e); 

        }

    }

    public static void imprimirMatriz(int[][] matriz) {

            for(int i = 0; i < matriz.length; i++) {

                for(int j = 0; j < matriz[i].length; j++) {

                    System.out.println(" | " + matriz[i][j]);

                }

                System.out.println("");

            }

    }

    public static int[] diagonalSecundaria(int[][] matriz) {

        try {

            int[] vectorRetorno = new int [matriz.length];

            for(int i = 0; i < matriz.length; i++) {

                vectorRetorno[i] = matriz[i][matriz.length - i - 1];

            }

            return vectorRetorno;

        } catch(Exception e) {

            throw(e);

        }

    }

    public static void cambioDatos(int[][] matriz) {

        try {

            //Superior

            System.out.println("");
            
            for(int i = 0; i < matriz.length; i++) {

                for(int j = 0; j < matriz[i].length; j++) {

                    if(i <= j) {

                        System.out.println(" | " + matriz[i][j]);

                    } else {

                        System.out.println(" | -1");

                    }

                }

                System.out.println("");

            }

            System.out.println("");
            
            for(int i = 0; i < matriz.length; i++) {

                for(int j = 0; j < matriz[i].length; j++) {

                    if(i >= j) {

                        System.out.println(" | " + matriz[i][j]);

                    } else {

                        System.out.println(" | -1");

                    }

                }

                System.out.println("");

            }

        } catch(Exception e) {



        }

    }

    public static void main(String[] args) {
        
        try {

            int tamañoMatriz = 0, opciones = 0;
            int [] vectorAuxiliar;
            int [][] tablaNumeros;

            tamañoMatriz = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la matriz"));

            tablaNumeros = new int [tamañoMatriz][tamañoMatriz];

            tablaNumeros = llenarAleatorios(tablaNumeros);

            while(true) {

                opciones = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion:\n1. Diagonal secundaria\n2. Cambio de datos\n3. Imprima la matriz"));

                if(opciones > 3 || opciones < 1) {

                    break;

                } else {

                    if(opciones == 3) {

                        imprimirMatriz(tablaNumeros);

                    } else {

                        if(opciones == 1) {

                            vectorAuxiliar = diagonalSecundaria(tablaNumeros);
                            System.out.println("");
                            
                            for(int i = 0; i < vectorAuxiliar.length; i++) {

                                System.out.println("|" + vectorAuxiliar[i]);

                            }

                        } else if(opciones == 2) {

                            cambioDatos(tablaNumeros);

                        }

                    }

                }

            }

        } catch(Exception e) {

            System.out.println("Error: hay un error general en " + e.getMessage());

        } finally {

            System.out.println("Fin de la ejecucion");

        }

    }
    
}