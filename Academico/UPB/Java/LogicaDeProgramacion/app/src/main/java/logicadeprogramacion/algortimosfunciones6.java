/*

    Diseñar y desarrollar una función que reciba un valor inicial y un valor final, para generar 900 números aleatorios en este rango y
    retorne un texto que diga cuántos números pares fueron generados. Controle que el numero inicial sea menor que el número final,
    para establecer el rango.

    En el main, antes de invocar la función, se le debe solicitar por teclado al usuario el valor inicial y el valor final
    que se le va a enviar a la función y luego imprimir el resultado de la función, es decir, la cantidad de pares generados en ese rango.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class algortimosfunciones6 {

    public static long numeros(long minimo, long maximo) {

        long random = (long)(Math.random() * ((maximo - minimo) + 1)) + minimo;

        return random;

    }
    
    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        long minimo = 0, maximo = 0, cantidadPares = 0, numero = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingresa el valor minimo para generar los numeros");
                    minimo = usuario.nextLong();

                    input = true;

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");

                    usuario.next();

                }

            }

            while(input) {

                try {

                    System.out.println("Ingresa el valor maximo para generar los numeros");
                    maximo = usuario.nextLong();

                    if(maximo <= minimo) {

                        throw new IllegalArgumentException("Error: el valor maximo debe ser mayor que el minimo");

                    }

                    input = false;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");

                    usuario.next();

                }

            }

            for(short i = 1; i <= 900; i++) {

                numero = numeros(minimo, maximo);

                if(numero % 2 == 0) {

                    cantidadPares++;

                }

            }

        } finally {

            System.out.println("Se generaron " + cantidadPares + " numeros pares entre los 900 generados en un rango de [" + minimo + ", " + maximo + "]");

            usuario.close();

        }

    }

}
