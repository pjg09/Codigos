/*

    Solicitar al usuario ingresar Nro de Días, nro de horas, nro de minutos y nro segundos y convertir todo a segundos. 

*/

package logicadeprogramacion;

import java.util.Scanner;

public class hola1 {

    public static void main(String[] args) {

        int dias = 0, horas = 0, minutos = 0, segundos = 0, total = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una cantidad de dias");
        dias = sc.nextInt();

        System.out.println("Ingrese una cantidad de horas");
        horas = sc.nextInt();

        System.out.println(" Ingrese una cantodad de minutos");
        minutos = sc.nextInt();

        System.out.println("Ingrese una cantidad de segundos");
        segundos = sc.nextInt();

        sc.close();
        //desarrollo

        total = (dias * 86400) + (horas * 3600) + (minutos * 60) + (segundos);

        System.out.println("Amor, el total de todos los datos que me diste es " + total + " Te amo demasiado");


    }
    
}
