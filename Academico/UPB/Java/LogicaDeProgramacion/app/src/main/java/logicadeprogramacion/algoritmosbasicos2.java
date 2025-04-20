/*
 
    Diseñe un algoritmo que lea por teclado una velocidad en Km/seg y la convierta a metros/seg y a metros/hora 
 
*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class algoritmosbasicos2 {

    public static void main(String[] args) {

        DecimalFormat fix = new DecimalFormat("#.000000000000");
        Scanner usuario = new Scanner(System.in);
        double velocidad = 0;
        double metroSegundo = 0;
        double metroHora = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingrese una velocidad en kilometros por segundo, por favor solo ingrese el numero: ");
                    velocidad = usuario.nextDouble();

                    input = true;

                    metroSegundo = velocidad * 1000;
                    metroHora = (velocidad * 1000) * 3600;


                } catch (Exception e) {

                    System.out.println("Error: no puedes ingresar letras, solo numeros");
                    usuario.next();

                }

            }

        } catch(Exception e) {

            System.out.println("");

        } finally {

            System.out.println(velocidad + " kilometros sobre segundos es igual a: \n " + fix.format(metroSegundo) + " metros sobre segundos \n " + fix.format(metroHora) + " metros sobre horas");

            usuario.close();

        }

    }
    
}
