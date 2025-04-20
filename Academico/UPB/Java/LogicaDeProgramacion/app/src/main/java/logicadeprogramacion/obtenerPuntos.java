/*

     * 3. Diseñe un algoritmo e implemente la función Obtener_puntos que reciba
     * tres enteros representando el número de partidos ganados, perdidos y
     * empatados de un equipo de fútbol, y devuelva un entero que represente
     * los puntos totales del equipo. La puntuación sigue los lineamientos
     * de la FIFA: 3 puntos por partido ganado, 1 punto por partido empatado y
     * 0 puntos por partido perdido. Si hay algún error, retorne -1.
     * 
     * Valide ademas que los partidos ganados, perdidos y empatados sean mayores o
     * iguales a 0. Si no es así, retorne -1.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class obtenerPuntos {

    public static long excepciones(Scanner usuario) {

        long dato = 0;
        boolean input = false;

        while(!input) {

            try {

                System.out.println("");
                dato = usuario.nextLong();

                input = true;

            } catch(Exception e) {

                System.out.println("Error: solo puedes ingresar numeros enteros\nIntentalo de nuevo:");
                usuario.next();

            }

        }

        return dato;

    }

    public static long obtener_puntos(long ganados, long empatados) {

        long puntos = (ganados * 3) + empatados;

        return puntos;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        long ganados = 0, perdidos = 0, empatados = 0, puntos = 0;

        try {

            System.out.println("Ingresa la cantidad de partidos ganados:");
            ganados = excepciones(usuario);

            while(ganados < 0) {

                System.out.println("Error: los partidos ganados no pueden ser menores a cero\nIntentalo de nuevo:");
                ganados = excepciones(usuario);

            }

            System.out.println("Ingresa la cantidad de partidos perdidos:");
            perdidos = excepciones(usuario);

            while(perdidos < 0) {

                System.out.println("Error: los partidos perdidos no pueden ser menores a cero\nIntentalo de nuevo:");
                perdidos = excepciones(usuario);

            }

            System.out.println("Ingresa la cantidad de partidos empatados:");
            empatados = excepciones(usuario);

            while(empatados < 0) {

                System.out.println("Error: los partidos empatados no pueden ser menores a cero\nIntentalo de nuevo:");
                empatados = excepciones(usuario);

            }

            puntos = obtener_puntos(ganados, empatados);

        } finally {

            System.out.println("Los resultados de la fase de grupos para tu equipo fueron:\n" + ganados + " partidos ganados\n" + perdidos + " partidos perdidos\n" + empatados + " partidos empatados\nLo que suma un total de " + puntos + " puntos para tu equipo");

            usuario.close();

        }

    }
    
}