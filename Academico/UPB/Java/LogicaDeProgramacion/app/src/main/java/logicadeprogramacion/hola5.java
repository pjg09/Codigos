/*

    Pedir al usuario tres números enteros diferentes y escribirlos en orden ascendente

*/

package logicadeprogramacion;

import java.util.Scanner;

public class hola5 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int auxiliar1 = 0;
        int auxiliar2 = 0;
        int auxiliar3 = 0;

        try {

            System.out.println(" ingrese el numero 1");
            num1 = sc.nextInt();

            System.out.println("Ingrese el numero 2");
            num2 = sc.nextInt();

            System.out.println(" Ingrese el numero 3");
            num3 = sc.nextInt();

        } catch (Exception e) {

            System.out.println("Error, Ingresa un numero entero");
        }

        if(num3 < num2 && num2 < num1) {

            auxiliar3 = num1;
            auxiliar1 = num3;
            num1 = auxiliar1;
            num3 = auxiliar3;

        } else if(num2 < num1  && num1 < num3) {

            auxiliar1 = num2;
            auxiliar2 = num1;
            num2 = auxiliar2;
            num1 = auxiliar1;

        } else if (num3 < num1 && num1 < num2) {

            auxiliar2 = num1;
            auxiliar3 = num2;
            auxiliar1 = num3;
            num1 = auxiliar1;
            num2 = auxiliar2;
            num3 = auxiliar3;
            
        } else if (num1 < num3 && num3 < num2) {

            auxiliar2 = num3;
            auxiliar3 = num2;
            num3 = auxiliar3;
            num2 = auxiliar2;
            
        } else if (num2 < num3 && num3 < num1) {

            auxiliar3 = num1;
            auxiliar1 = num2;
            auxiliar2 = num3;
            num1 = auxiliar1;
            num2 = auxiliar2;
            num3 = auxiliar3;
            
        } 

        System.out.println("Los números dados ens orden ascendente es: " + num1 + " - " + num2 + " - " + num3);

        sc.close();


        
    
}}