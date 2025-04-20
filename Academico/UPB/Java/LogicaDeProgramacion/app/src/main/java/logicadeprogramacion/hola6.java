package logicadeprogramacion;

import java.util.Scanner;

public class hola6 {

    public static void main(String[] args) {

        int lado1 = 0;
        int lado2 = 0;
        int lado3 = 0;

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Ingrese la medida de el lado 1");
            lado1 = sc.nextInt();

            System.out.println("Ingrese la medida de el lado 2");
            lado2 = sc.nextInt();

            System.out.println("Ingrese la medida de el lado 3");
            lado3 = sc.nextInt();
            

        } catch (Exception e) {

            System.out.println("Error, solo puedes ingresar números mayores a 0");
            
        }
        
        if (lado1 == lado2 && lado2 == lado3 && lado3 == lado1) {

            System.out.println(" El triangulo es equilátero");
            
        } else if( lado1 == lado2 || lado2 == lado3 || lado1 == lado3){

            System.out.println(" El triangulo es isóceles");

        } else {

            System.out.println(" El triangulo es escaleno");
        }

        sc.close();



        


    }
    
}
