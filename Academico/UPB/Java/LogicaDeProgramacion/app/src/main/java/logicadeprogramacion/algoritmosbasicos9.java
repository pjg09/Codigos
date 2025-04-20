/*

    Un avión necesita cargar combustible para cubrir sus rutas programadas en el día.
    Cada 0.2 toneladas de combustible puede recorrer 60.8 Km en velocidad de crucero.
    En el despegue el avión consume 1.2 toneladas de combustible y en el aterrizaje consume 0.4 toneladas.
    El piloto desea un algoritmo que ingresando 4 rutas, y el kilometraje de cada ruta
    obtenga la cantidad de combustible que debe tanquear en el avión.

*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class algoritmosbasicos9 {

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
        double destino = 0, consumoTotal = 0, consumoLocal = 0;
        long contador = 0;

        try {

            for(byte i = 1; i <= 4; i++) {

                System.out.println("Ingrese la distancia del recorrido numero " + i);
                destino = excepciones(usuario);

                consumoLocal = ((destino * 0.2) / 60.8) + 1.6;
                consumoTotal += consumoLocal;
                contador++;

                System.out.println("El consumo de combustible para la ruta " + i + " es de " + fix.format(consumoLocal) + " toneladas");

            }

        } finally {

            System.out.println("El consumo total por las " + contador + " rutas es de " + fix.format(consumoTotal) + " toneladas");
            usuario.close();

        }

    }
    
}