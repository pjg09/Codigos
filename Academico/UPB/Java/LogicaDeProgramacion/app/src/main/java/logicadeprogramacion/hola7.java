package logicadeprogramacion;

import java.util.Scanner;

public class hola7 {

    public static int Suma(int numero1, int numero2) {

        int suma = numero1 + numero2;

        return suma;

    }

    public static void main(String[] args) {
        
        int num1 = 0, num2 = 0, resultado = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero 1");
        num1 = sc.nextInt();

        System.out.println("Ingrese el numero 2");
        num2 = sc.nextInt();

        resultado = Suma(num1, num2);

        System.out.println("El resultado de la suma es " + resultado);

        sc.close();

    }
    
}