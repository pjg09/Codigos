package logicadeprogramacion;

import java.util.Scanner;

public class hola3 {

    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int edad = 0;

        try {

            System.out.println("Ingresa tu edad");
            edad = sc.nextInt();

        } catch(Exception e) {

            System.out.println("Error la edad debe ser un numero entero");

        }

        System.out.println("Tu edad es " + edad);

        sc.close();

    }
    
}