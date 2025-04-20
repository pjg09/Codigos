/*

    Diseñar y desarrollar una función que NO reciba datos de entrada
    genere aleatoriamente los números a los que se les va a calcular la raíz entre 2 y 355 y retorne el valor de la raíz.
    Para calcular las raíces usar la función Sqrt de la biblioteca Math.

    En el main, antes de invocar la función, se le debe solicitar por teclado al usuario la cantidad de veces que va a llamar a la función
    y en un ciclo, mostrar los resultados.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmosfunciones5 {

    public static int numero() {

        byte minimo = 2;
        short maximo = 355;
        int random = (int)(Math.random() * ((maximo - minimo) + 1)) + minimo;

        return random;

    }

    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);
        int numero = 0;
        long cantidad = 0, contador = 1;
        double resultado = 0;
        boolean input = false;
        
        try {

            while(!input) {

                try {

                    System.out.println("Ingresa la cantidad de numeros a los que quieres sacarle la raiz");
                    cantidad = usuario.nextLong();

                    if(cantidad < 1) {

                        throw new IllegalArgumentException("Error: solo puedes ingresar numeros mayores a 1");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");

                }

            }

        } finally {

            while(contador <= cantidad) {

                numero = numero();
                resultado = Math.sqrt(numero);

                System.out.println("La raiz cuadrada de " + numero + " es " + resultado);

                contador++;

            }

            usuario.close();

        }

    }
    
}
