/*

    Solicitar al usuario ingresar la temperatura en grados centígrados y convertirla en grados Fahrenheit
    (averiguar la fórmula) F = 32 + ( 9 * C / 5)

*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class algoritmosbasicos5 {

    public static void main(String[] args) {
        
        DecimalFormat fix = new DecimalFormat("#.000000000000");
        Scanner usuario = new Scanner(System.in);
        double grados = 0;
        double fahrenheit = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingresa una temperatura en grados centigrados, por favor solo ingresa numeros: ");
                    grados = usuario.nextDouble();

                    input = true;
                    fahrenheit = 32 + ((9 * grados) / 5);

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");

                    usuario.next();


                }

            }

        } finally {

            System.out.println(grados + " °C equivalen a " + fix.format(fahrenheit) + " °F");

            usuario.close();

        }

    }
    
}