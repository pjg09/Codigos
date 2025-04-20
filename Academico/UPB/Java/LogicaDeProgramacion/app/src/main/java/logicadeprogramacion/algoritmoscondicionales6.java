/*

    Escriba un algoritmo que dado un caracter, nos diga si es un alfabético, numérico o carácter especial. 
    Valide que el caracter sea imprimible de acuerdo con la tabla ascii básica.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmoscondicionales6 {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        char caracter = ' ';
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingresa un caracter: ");
                    caracter = usuario.next().charAt(0);

                    input = true;

                } catch(Exception e) {

                    System.out.println("");

                }

            }

        } finally {

            if(Character.isLetter(caracter)) {

                System.out.println(caracter + " es una letra");

            } else if(Character.isDigit(caracter)) {

                System.out.println(caracter + " es un digito");

            } else {

                System.out.println(caracter + " no es ni una letra ni un digito");

            }

            usuario.close();

        }

    }
    
}
