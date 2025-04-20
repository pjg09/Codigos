/*

    Pedir al usuario tres números enteros diferentes y escribirlos en orden ascendente


*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmoscondicionales3 {

    public static long excepciones(Scanner usuario) {

        long dato = 0;
        boolean input = false;

        while(!input) {

            try {

                System.out.println("");
                dato = usuario.nextLong();

                input = true;

            } catch(Exception e) {

                System.out.println("Error: solo puedes ingresar numeros enteros \n Intentalo de nuevo: ");
                usuario.next();

            }

        }

        return dato;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        long numero1 = 0, numero2 = 0, numero3 = 0, auxiliar = 0;

        try {

            System.out.println("Ingresa el primer numero entero: ");
            numero1 = excepciones(usuario);

            System.out.println("Ingresa el segundo numero entero: ");
            numero2 = excepciones(usuario);

            System.out.println("Ingresa el tercer numero entero: ");
            numero3 = excepciones(usuario);

            if(numero1 > numero2) {

                auxiliar = numero1;
                numero1 = numero2;
                numero2 = auxiliar;

            }

            if(numero1 > numero3) {

                auxiliar = numero1;
                numero1 = numero3;
                numero3 = auxiliar;

            }

            if(numero2 > numero3) {

                auxiliar = numero2;
                numero2 = numero3;
                numero3 = auxiliar;

            }

        } finally {

            System.out.println("Los numeros en orden ascendente son " + numero1 + " " + numero2 + " " + numero3);
            usuario.close();

        }

    }
    
}
