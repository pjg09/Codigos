/*
 * 
 * Escriba un algoritmo que pida al usuario un número entero positivo y muestre por 
 * pantalla todos los números impares desde 1 hasta ese número separados por comas.
 * 
 */

package logicadeprogramacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejerciciotallerciclos1 {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        int numero = 0;
        int indice = 0;
        int cantidadImpares = 0;
        boolean input = false;

        while(!input) {

            try {

                System.out.println("Ingrese un numero entero positivo");
                numero = usuario.nextInt();

                if(numero <= 0) {

                    throw new IllegalArgumentException("solo puedes ingresar numeros mayores o iguales a 1");

                }

                input = true;

            } catch(InputMismatchException e) {

                System.out.println("Error: solo puedes ingresar numeros");
                usuario.next();

            } catch(IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            }

        }

        cantidadImpares = (numero + 1) / 2;

        int[] vector = new int[cantidadImpares];

        for (int i = 1; i <= numero; i += 2) {
            
            vector[indice] = i;
            indice++;
            
        }

        System.out.println("Los numeros impares desde 1 hasta " + numero + " son:");

        for (int i = 0; i < vector.length; i++) {

            if (i != 0) {

                System.out.print(", ");

            }

            System.out.print(vector[i]);

        }

        usuario.close();
    
    }

}