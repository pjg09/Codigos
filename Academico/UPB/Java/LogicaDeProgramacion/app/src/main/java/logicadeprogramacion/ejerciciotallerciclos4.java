/*
 * 
 * Escriba un algoritmo que pida un número entero N mayor de 2 e imprima los primeros N términos de la serie de Fibonacci
 * (La sucesión de Fibonacci se trata de una serie infinita de números naturales que empieza con un 0 y un 1 y continúa añadiendo números que son la suma de los dos
 * anteriores: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597…).
 * 
 */

package logicadeprogramacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejerciciotallerciclos4 {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        int n = 0, numero1 = 0, numero2 = 1, terminoSiguiente;
        boolean input = false;

        while(!input) {

            try {

                System.out.println("Ingrese un numero entero N mayor a 2 para imprimir los primeros N terminos de la serie de Fibonacci");
                n = usuario.nextInt();

                if(n < 1) {

                    throw new IllegalArgumentException("el numero debe ser mayor o igual a 2");

                }

                input = true;

            } catch(InputMismatchException e) {

                System.out.println("Error: solo puedes ingresar numeros enteros");
                usuario.next();

            } catch(IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            }

        }

        int[] vector = new int[n];

        for(int i = 0; i <= n - 1; i++) {

            switch(i) {

                case 0:
                    vector[i] = 0;
                    break;

                case 1:
                    vector[i] = 1;
                    break;

            }

            if(i >= 2) {

                terminoSiguiente = numero1 + numero2;
                vector[i] = terminoSiguiente;
                numero1 = numero2;
                numero2 = terminoSiguiente;

            }

        }

        System.out.println("Los primeros " + n + " terminos de la seria de Fibomacci son: ");

        for(int i = 0; i <= n - 1; i++) {

            if (i != 0) {

                System.out.print(", ");

            }

            System.out.print(vector[i]);

        }

        usuario.close();

    }
    
}
