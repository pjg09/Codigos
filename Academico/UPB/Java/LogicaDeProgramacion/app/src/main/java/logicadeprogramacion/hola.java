/*

    Diseñe un algoritmo que lea por teclado una velocidad en Km/seg y la convierta a metros/seg y a metros/hora

*/

package logicadeprogramacion;

import java.util.Scanner;

public class hola {

    public static void main(String[] args) {

        double datoEntrada = 0, metroSeg = 0, metroHora = 0;
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Deme los km/s pirobito");

        datoEntrada = sc.nextDouble();
        
        metroSeg = datoEntrada*1000;
        metroHora = metroSeg*3600;

        System.out.println("La conversión de los " + datoEntrada + "km/s fue: " + metroSeg + "m/s y " + metroHora + "m/h"  );
        
        sc.close();


    }
    
}