/*
 * 
 * Escribir un algoritmo que pida al usuario un número entre 2 y 10 y muestre por pantalla la tabla de multiplicar para ese número.
 * 
 */

package logicadeprogramacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejerciciotallerciclos3 {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        byte numero = 0;
        boolean input = false;

        while(!input) {

            try {

                System.out.println("Ingrese un numero entre 2 y 10 para ver su tabla de multiplicar");
                numero = usuario.nextByte();

                if(numero < 2 || numero > 10) {

                    throw new IllegalArgumentException("el numero debe estar entre 2 y 10");

                }

                input = true;

            } catch(InputMismatchException e) {

                System.out.println("Error: solo puedes ingresar numeros");
                usuario.next();

            } catch(IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            }

        }

        System.out.println("La tabla del " + numero + " es:");

        for(byte i = 1; i <= 10; i++) {

            System.out.println(numero + " x " + i + " = " + (numero * i));

        }

        usuario.close();

    }
    
}
