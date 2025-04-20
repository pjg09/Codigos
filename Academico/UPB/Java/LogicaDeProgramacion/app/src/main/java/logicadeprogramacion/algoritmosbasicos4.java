/*

    Solicitar al usuario ingresar una cantidad en dólares y convertirla a pesos según la TRM del día
 
*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmosbasicos4 {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        double dolares = 0;
        double pesos = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingresa una cantidad en dolares");
                    dolares = usuario.nextDouble();

                    input = true;

                    pesos = dolares * 4013.18;

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros");
                    usuario.next();

                }

            }

        } catch(Exception e) {

            System.out.println("");

        } finally {

            System.out.println("$" + dolares + " dolares el día 22 de agosto equivalen a $" + pesos);
            usuario.close();

        }

    }
    
}
