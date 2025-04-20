/*

    Solicitar al usuario ingresar Nro de Días, nro de horas, nro de minutos y nro segundos y convertir todo a segundos. 

*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class algoritmosbasicos6 {

    public static double excepciones(Scanner usuario) {

        double dato = 0;
        boolean input = false;

        while(!input) {

            try {

                System.out.println("");
                dato = usuario.nextDouble();

                input = true;

            } catch(Exception e) {

                System.out.println("Error: no puedes ingresar letras, solo numeros");
                usuario.next();

            }

        }

        return dato;

    }

    public static void main(String[] args) {
        
        DecimalFormat fix = new DecimalFormat("#.000");
        Scanner usuario = new Scanner(System.in);
        double dias = 0;
        double horas = 0;
        double minutos = 0;
        double segundos = 0;
        double total = 0;

        try {

            System.out.println("Ingresa la cantidad de dias: ");
            dias = excepciones(usuario);
    
            System.out.println("Ingresa la cantidad de horas: ");
            horas = excepciones(usuario);

            System.out.println("Ingresa la cantidad de minutos: ");
            minutos = excepciones(usuario);

            System.out.println("Ingresa la cantidad de segundos: ");
            segundos = excepciones(usuario);

            total = (dias * 86400) + (horas * 3600) + (minutos * 60) + segundos;
 
        } finally {

            System.out.println(fix.format(dias) + " dias, " + fix.format(horas) + " horas, " + fix.format(minutos) + " minutos y " + fix.format(segundos) + " segundos equivalen a " + fix.format(total) + " segundos");

            usuario.close();

        }

    }
    
}
