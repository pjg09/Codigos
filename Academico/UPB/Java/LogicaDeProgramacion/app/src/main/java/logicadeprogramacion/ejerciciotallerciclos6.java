/*
 * 
 * Escriba un algoritmo que pregunte al usuario números hasta que ingrese un valor de cero.
 * Se requiere la cuenta de números ingresados y su sumatoria.
 * 
 */

package logicadeprogramacion;

import java.util.Scanner;
import java.util.ArrayList;

public class ejerciciotallerciclos6 {

    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        long suma = 0;
        boolean input;

        while(true) {

            input = false;
            int numero = 0;

            while(!input) {

                try {

                    System.out.println("Ingresa un numero entero (ingresa 0 cuando quieras terminar):");
                    numero = Integer.parseInt(usuario.nextLine());
                    input= true;

                } catch(NumberFormatException e) {

                    System.out.println("Error: por favor ingresa un numero entero");

                }

            }

            if(numero == 0) {

                break;

            }

            numeros.add(numero);
            suma += numero;

        }

        System.out.println("Los numeros ingresados son " + String.join(", ", numeros.stream().map(String::valueOf).toArray(String[]::new)));
        System.out.println("Se ingresaron " + numeros.size() + " numeros");
        System.out.println("La sumatoria de los numeros es " + suma);

        usuario.close();


    }
    
}