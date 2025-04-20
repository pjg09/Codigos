/*

    Diseñe y desarrolle una función en Java llamada Verificar_Orden
    que reciba 2 números y retorne un mensaje si están en orden creciente o decreciente. 
    Considere el caso en que sean iguales.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class hola4 {

    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int numero1 = 0;
        int numero2 = 0;

        try {

            System.out.println("Ingrese el numero 1");
            numero1 = sc.nextInt();

            System.out.println("Ingrese el numero 2");
            numero2 = sc.nextInt();
            
        } catch (Exception e) {
            
            System.out.println("Error: solo puedes ingresar numeros enteros");

        }

        if(numero1 < numero2) {

            System.out.println("Los numeros estan en orden creciente");

        } else if(numero1 > numero2) {

            System.out.println("Los numeros estan en orden decreciente");

        } else {

            System.out.println("Los numeros son iguales");

        }

        sc.close();

    }
    
}