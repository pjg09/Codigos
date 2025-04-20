/*

    Diseñar y desarrollar una función que reciba una cantidad de números aleatorios que vienen como parámetro de entrada y los sume.
    La función deberá retornar el total de la suma. Usted defina los rangos que va a usar en el cálculo.

    En el main, antes de invocar la función, se le debe solicitar por teclado al usuario la cantidad de números que se le va a enviar
    a la función y mostrará el resultado arrojado por la función.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmosfunciones7 {

    public static long excepciones(Scanner usuario) {

        long dato = 0;
        boolean input = false;

        while(!input) {

            try {

                dato = usuario.nextLong();

                input = true;

            } catch(Exception e) {

                System.out.println("Error: solo puedes ingresar numeros enteros \n Intentalo de nuevo");
                
                usuario.next();

            }

        }

        return dato;

    }

    public static long sumatoria(long cantidadNumeros, long minimo, long maximo) {

        long sumatoria = 0, random = 0;

        for(long i = 1; i <= cantidadNumeros; i++) {

            random = (long)(Math.random() * ((maximo - minimo) + 1)) + minimo;

            sumatoria += random;

        }

        return sumatoria;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        long minimo = 0, maximo = 0, cantidadNumeros = 0, sumatoria = 0;
        boolean input = false;

        try {

            System.out.println("Ingresa la cantidad de numeros que quieres generar");
            cantidadNumeros = excepciones(usuario);

            System.out.println("Ingresa el valor minimo del rango para generar los numeros");
            minimo = excepciones(usuario);

            while(!input) {

                try {

                    System.out.println("Ingresa el valor maximo del rango para generar los numeros");
                    maximo = usuario.nextLong();
    
                    if(maximo <= minimo) {
    
                        throw new IllegalArgumentException ("Error: solo puedes ingresar numeros mayores al minimo");
    
                    }
    
                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");

                    usuario.next();

                }

            }

            sumatoria = sumatoria(cantidadNumeros, minimo, maximo);

        } finally {

            System.out.println("La suma de los " + cantidadNumeros + " numeros generador aleatoriamente entre [" + minimo + ", " + maximo + "] es " + sumatoria);

            usuario.close();

        }

    }
    
}
