package logicadeprogramacion;

import java.util.Scanner;

public class calculadora {

    public static double suma (double valor1, double valor2) {

        try {

            double resultado = valor1 + valor2;

            return resultado;

        } catch (Exception e) {

            return -1;

        }

    }

    public static double multiplicar (double valor1, double valor2) {

        try {

            double resultado = valor1 * valor2;

            return resultado;

        } catch (Exception e) {

            return -1;

        }

    }

    public static double restar (double valor1, double valor2) {

        try {

            double resultado = valor1 - valor2;

            return resultado;

        } catch (Exception e) {

            return -1;

        }

    }

    public static double division (double valor1, double valor2) {

        try {

            double resultado = valor1 / valor2;

            return resultado;

        }   catch (Exception e) {

            return -1;

        }

    }

    public static void main (String[]arg) {

        Scanner usuario = new Scanner (System.in);
        double resultado = 0;
        String operacion = "";

        try {

            System.out.println("Ingrese el primer valor: ");
            double valor1 = usuario.nextInt();

            System.out.println("Ingrese el segundo valor: ");
            double valor2 = usuario.nextInt();

            System.out.println("¿Que operacion deseas realizar? \n 1: Sumar \n 2: Multiplicar \n 3: Restar \n 4: Division");
            byte opcion = usuario.nextByte();

            switch (opcion) {

                case 1:
                    resultado = suma(valor1, valor2);
                    operacion = "suma";
                    break;

                case 2:
                    resultado = multiplicar(valor1, valor2);
                    operacion = "multiplicacion";
                    break;

                case 3:
                    resultado = restar(valor1, valor2);
                    operacion = "restar";
                    break;

                case 4:
                    resultado = division(valor1, valor2);
                    operacion = "division";
                    break;

                default:
                    System.out.println("Operacion invalida");
                    break;

            }

            System.out.println("El resultado de la " + operacion + " es " + resultado);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            usuario.close();

        }

    }
    
}