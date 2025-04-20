/*

    Pedir al usuario que ingrese un número entre 0 y 50.000 y decir cuántas cifras tiene.
    Por ejemplo 10 tiene dos cifras, 9999 tiene 4 cifras.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmoscondicionales4 {

    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);
        String cifras = "";
        int numero = 0, cantidadCifras = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingresa un numero entero entre 1 y 50000");
                    numero = usuario.nextInt();

                    if(numero < 0 || numero > 50000) {

                        throw new IllegalArgumentException("Error: solo puedes ingresar numeros entre 1 y 50000");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros entre 1 y 50000");

                }

            }

            cifras = Integer.toString(numero);
            cantidadCifras = cifras.length();

        } finally {

            System.out.println("El numero " + numero + " tiene " + cantidadCifras);
            usuario.close();

        }
        
    }
    
}
