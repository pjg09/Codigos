/*
 * 
 * Escriba un algoritmo que pregunte al usuario su edad (número entero positivo) y muestre por pantalla todos los años que ha cumplido 
 * (desde 1 hasta su edad).
 * 
 */

package logicadeprogramacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejerciciotallerciclos2 {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        byte edad = 0;
        byte indice = 0;
        boolean input = false;

        while(!input) {

            try {

                System.out.println("Ingresa tu edad: ");
                edad = usuario.nextByte();

                if(edad <= 0) {

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

        byte[] vector = new byte [edad];

        for(byte i = 1; i <= edad; i++) {

            vector[indice] = i;
            indice++;

        }

        System.out.println("Estos son los años que has cumplido desde que naciste hasta los " + edad + " años");

        for (byte i = 0; i < vector.length; i++) {

            if (i != 0) {

                System.out.print(", ");

            }

            System.out.print(vector[i]);

        }

        usuario.close();

    }
    
}
