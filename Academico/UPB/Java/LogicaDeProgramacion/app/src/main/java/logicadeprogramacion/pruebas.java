/*
    Diseñar y desarrollar una función que reciba un valor inicial y un valor final, para generar 900 números aleatorios en este rango y
    retorne un texto que diga cuántos números pares fueron generados. Controle que el numero inicial sea menor que el número final,
    para establecer el rango.

    En el main, antes de invocar la función, se le debe solicitar por teclado al usuario el valor inicial y el valor final que se
    le va a enviar a la función y luego imprimir el resultado de la función, es decir, la cantidad de pares generados en ese rango.
*/

package logicadeprogramacion;

import java.util.Scanner;

public class pruebas {

    public static int contadorPares(int numeroInicial, int numeroFinal) {

        int numeroGenerado = 0, contador = 0;

        for(int i = 1; i <= 900; i++) {

            numeroGenerado = (int)(Math.random() * ((numeroFinal - numeroInicial) + 1)) + numeroInicial;

            if(numeroGenerado % 2 == 0) {

                contador++;

            }
                
        }

        return contador;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        int valorInicial = 0, valorFinal = 0, cantidadPares = 0;

        try {

            System.out.println("Ingrese el valor inicial");
            valorInicial = usuario.nextInt();

            System.out.println("Ingrese el valor final, este debe ser más grande que el valor inicial");
            valorFinal = usuario.nextInt();

        } catch(Exception e) {

            System.out.println("Error: solo puedes ingresar numeros enteros");

        } finally {

            if(valorInicial < valorFinal) {

                cantidadPares = contadorPares(valorInicial, valorFinal);

                System.out.println("Se generaron " + cantidadPares + " numero pares entre " + valorInicial + " y " + valorFinal );

            } else {
                
                System.out.println("Error: el numero inicial es mas grande que el numero final");

            }

            usuario.close();

        }

    }
    
}