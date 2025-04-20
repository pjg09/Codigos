/*

    Se requiere una función en java que simule las ventas de tres años para un almacén.
    Para cada año, deberá generar un aleatorio para cada mes hasta completar los 12 meses.
    La función se llamará Simular_ventas, y debe retornar un String al final que muestre las ventas de cada año, así:

    Total ventas Año 1:  $##.###.###
    Total ventas Año 2: $##.###.###
    Total ventas Año 3: $##.###.###

*/

package logicadeprogramacion;

import java.text.DecimalFormat;
import java.util.Scanner;

public class algoritmosciclosanidados1 {

    public static double excepciones(Scanner usuario) {

        boolean input = false;
        double dato = 0;

        while(!input) {

            try {

                System.out.println("");
                dato = usuario.nextDouble();

                input = true;

            } catch(Exception e) {

                System.out.println("Error: solo puedes ingresar numeros \n Intentalo de nuevo");

            }

        }

        return dato;

    }

    public static String simularVentas(double minimo, double maximo) {

        DecimalFormat fix = new DecimalFormat("#,###.000");
        double aleatorio = 0, ventas = 0;

        for(byte i = 1; i <= 12; i++) {

            aleatorio = minimo + (maximo - minimo) * Math.random();
            ventas += aleatorio;

        }

        return fix.format(ventas);

    }

    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);
        long cantidadAños = 0;
        double minimo = 0, maximo = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("¿Para cuantos años deseas simular las ventas?");
                    cantidadAños = usuario.nextLong();

                    if(cantidadAños <= 0) {

                        throw new IllegalArgumentException("Error: debes ingresar para 1 o más años");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");
                    usuario.next();

                }

            }

            System.out.println("A continuacion debe ingresar los valores maximos y minimos bajo los cuales desea que se genere la simulacion de las ventas");
            System.out.println("Ingresa el valor minimo mensual de ventas: ");
            minimo = excepciones(usuario);

            System.out.println("Ingresa el valor maximo mensual de ventas: ");
            maximo = excepciones(usuario);

        } finally {

            for(long i = 1; i <= cantidadAños; i++) {

                System.out.println("El total de ventas del año " + i + " es " + simularVentas(minimo, maximo));

            }

            usuario.close();

        }

    }
    
}