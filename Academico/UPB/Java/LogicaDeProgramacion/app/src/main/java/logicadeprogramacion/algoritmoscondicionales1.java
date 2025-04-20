/*

    Diseñe y desarrolle una función en Java llamada Verificar_Orden
    que reciba 2 números y retorne un mensaje si están en orden creciente o decreciente. 
    Considere el caso en que sean iguales.


*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmoscondicionales1 {

    public static long excepciones(Scanner usuario) {

        long dato = 0;
        boolean input = false;

        while(!input) {

            try {

                System.out.println("");
                dato = usuario.nextLong();

                input = true;

            } catch(Exception e) {

                System.out.println("Error: solo puedes ingresar numeros enteros \n Intenta de nuevo: ");
                usuario.next();

            }

        }

        return dato;

    }

    public static String validarOrden (long numero1, long numero2) {

        if(numero1 < numero2) {

            return "Los numeros estan ordenados";

        } else if(numero1 > numero2) {

            return "Los numeros estan desordenados";

        } else {

            return "Los numeros son iguales";

        }

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        long numero1 = 0, numero2 = 0;

        try {

            System.out.println("Ingresa el primer numero: ");
            numero1 = excepciones(usuario);

            System.out.println("Ingresa el segundo numero: ");
            numero2 = excepciones(usuario);

        } finally {

            System.out.println(validarOrden(numero1, numero2));

        }

    }
    
}
