/*
 * Escriba un algoritmo que pida al usuario un número entero positivo mayor que 2 y muestre por pantalla si es un número primo o no.
 * 
 */

package logicadeprogramacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejerciciotallerciclos5 {

    public static boolean primo(long numero) {

        for (long i = 2; i <= Math.sqrt(numero); i++) {

            if (numero % i == 0) {

                return false;

            }

        }

        return true;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        long numero = 0;
        boolean input = false;

        while(!input){

            try {

                System.out.println("Ingresa un numero entero mayor que 2 para verificar si es primo");
                numero = usuario.nextLong();

                if(numero < 1) {

                    throw new IllegalArgumentException("el numero debe ser un entero mayor a 2");

                }

                input = true;

            } catch(InputMismatchException e) {

                System.out.println("Error: solo puedes ingresar numeros enteros");
                usuario.next();

            } catch(IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            }

        }

        if(primo(numero)) {

            System.out.println("El numero " + numero + " es primo");

        } else {

            System.out.println("El numero " + numero + " no es primo");

        }

        usuario.close();

    }
    
}
