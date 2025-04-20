/*

    Un avión necesita cargar combustible para cubrir sus rutas programadas en el día.
    Cada 0.2 toneladas de combustible puede recorrer 60.8 Km en velocidad de crucero.
    En el despegue el avión consume 1.2 toneladas de combustible y en el aterrizaje consume 0.4 toneladas.
    El piloto desea un algoritmo que ingresando 4 rutas, y el kilometraje de cada ruta, obtenga la cantidad de combustible que debe
    tanquear en el avión.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class hola2 {

    public static void main(String[] args) {
        
        double ruta1 = 0;
        double ruta2 = 0;
        double ruta3 = 0;
        double ruta4 = 0;
        double totalConsumo = 0;
        double totalKm = 0;
    
        Scanner sc = new Scanner(System.in);
    
        // Desarrollo 

        System.out.println("Ingrese los km de la ruta 1");
        ruta1 = sc.nextDouble();

        System.out.println("Ingrese los km de la ruta 2");
        ruta2 = sc.nextDouble();

        System.out.println("Ingrese los km de la ruta 3");
        ruta3 = sc.nextDouble();

        System.out.println("Ingrese los km de la ruta 4");
        ruta4 = sc.nextDouble();

        totalKm = ruta1 + ruta2 + ruta3 + ruta4;

        totalConsumo = (1.6 * 3) + (totalKm * (0.2 / 60.8));

        System.out.println("Amor, el consumo total es de  " + totalConsumo + " toneladas de combustible");

        sc.close();

    }

    
    
}
