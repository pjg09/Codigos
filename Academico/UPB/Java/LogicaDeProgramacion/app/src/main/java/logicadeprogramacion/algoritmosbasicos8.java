/*

    Diseñe un algoritmo que calcule el tiempo necesario para alcanzar un destino dado por el usuario 
    quien además ingresará la velocidad promedio en kilómetros/hora  y la distancia en kilómetros

*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class algoritmosbasicos8 {

    public static double excepciones(Scanner usuario) {

        double dato = 0;
        boolean input = false;

        while(!input) {

            try {

                System.out.println("");
                dato = usuario.nextDouble();

                input = true;

            } catch(Exception e) {

                System.out.println("Error: solo puedes ingresar numeros \n Intenta nuevamente:");
                usuario.next();

            }

        }

        return dato;

    }

    public static void main(String[] args) {
        
        DecimalFormat fix = new DecimalFormat("#.000");
        Scanner usuario = new Scanner(System.in);
        double destino = 0, velocidad = 0, tiempo = 0;

        try {

            System.out.println("Ingrese la distancia en kilometros de su destino: ");
            destino = excepciones(usuario);

            System.out.println("Ingrese la velocidad promedio en el trayecto en kilometros por hora");
            velocidad = excepciones(usuario);

            if(velocidad == 0) {

                throw new IllegalArgumentException("No llegaras nunca a tu destino");

            }

            tiempo = destino / velocidad;

        } catch(IllegalArgumentException e) {

            System.out.println(e.getMessage());

        } finally {

            System.out.println("Te vas a demorar " + fix.format(tiempo) + " hora/s en llegar a tu destino que está a " + fix.format(destino) + " si te desplazas a " + fix.format(velocidad) + " kilometros por hora");

            usuario.close();

        }

    }
    
}
