/*

    Un usuario tiene un sistema de báscula para pesar camiones
    dado el peso de un camión debe sacar el peso neto de la carga en kilos y toneladas

*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class algoritmosbasicos7 {

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
        double bascula = 0, camion = 0, total = 0;

        try {

            System.out.println("Ingresa el peso que marca la bascula: ");
            bascula = excepciones(usuario);

            System.out.println("Ingresa el peso de tu cambion sin carga: ");
            camion = excepciones(usuario);

            total = bascula - camion;

        } finally {

            System.out.println("El peso de la bascula es: " + fix.format(total));

            usuario.close();

        }

    }
    
}