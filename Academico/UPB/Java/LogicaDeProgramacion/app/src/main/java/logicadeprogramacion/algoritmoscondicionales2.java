/*

    Diseñe y desarrolle una función en Java llamada Calcular_Costo
    la cual, dada la duración en minutos de una llamada retorne el costo, considerando: 
	Hasta tres minutos el costo es 0.50 Por encima de tres minutos es 0.50 más 0.1*cada minuto adicional a los tres primeros

*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmoscondicionales2 {

    public static double FcostoLlamada(double duracionLlamada) {

        double costoLlamada = 0;

        if(duracionLlamada < 3) {

            costoLlamada = 0.50;

        } else {

            costoLlamada = ((duracionLlamada - 3) * 0.1) + 0.50;

        }

        return costoLlamada;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        double duracionLlamada = 0, costoLlamada = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingrese la duracion de la llamada en minutos: ");
                    duracionLlamada = usuario.nextDouble();

                    if(duracionLlamada < 0) {

                        throw new IllegalArgumentException("Error: la llamada no puede durar menos de cero minutos.");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puede ingresar numeros para indicar la duracion de la llamada.");

                }

            }

        } finally {

            costoLlamada = FcostoLlamada(duracionLlamada);

            System.out.println("El costo de la llamada con una duracion de " + duracionLlamada + " es de $" + String.format("%.2f", costoLlamada));

            usuario.close();

        }

    }
    
}