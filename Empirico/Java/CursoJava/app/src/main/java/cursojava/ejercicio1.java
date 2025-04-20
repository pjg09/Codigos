package cursojava;

import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        
    Scanner usuario = new Scanner (System.in);
    int vector [] = new int [15];
    byte contador = 0;
    byte posicion = 1;

    for (byte indice = 0; indice <= 14; indice++) {

        System.out.println("Ingrese el numero entero que desee para la posición " + posicion + " del vector");
        posicion ++;
        vector [indice] = usuario.nextInt();
 

        }

    for (byte buscador = 0; buscador <= 14; buscador++) {

        if (vector [buscador] == 3) {

            contador++;            

        }

    }

    if (contador > 1) {

        System.out.println("El numero 3 se ha repetido " + contador + " veces");

    } else {

        if (contador == 1) {

            System.out.println("El numero 3 se ha repetido 1 vez");

        } else {

            System.out.println("El numero 3 no esta presente en el vector");

        }

    }

    usuario.close();

    }
    
}
