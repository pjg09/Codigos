package logicadeprogramacion;

import java.util.Scanner;

public class pene {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        int cantidadNumeros = 0;
        
        System.out.println("Ingrese la cantidad de numeros que desea guardar");
        cantidadNumeros = usuario.nextInt();

        int [] numeros = new int[cantidadNumeros];

        for(int i = 0; i < cantidadNumeros; i++) {

            System.out.println("Ingrese el numero para la posicion " + (i + 1));
            numeros[i] = usuario.nextInt();

        }

        System.out.println("Los numeros ingresados son");

        for(int i = 0; i < cantidadNumeros; i++) {

            System.out.println(numeros[i]);

        }

        usuario.close();

    }
    
}