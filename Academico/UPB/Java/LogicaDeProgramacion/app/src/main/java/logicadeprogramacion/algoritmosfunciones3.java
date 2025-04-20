/*

    Diseñe un algoritmo e implemente una función en Java (defina el nombre como lo hemos recomendado en clase) 
    que reciba dos números enteros, calcule su residuo y retorne un booleano si la división es exacta true o de lo contrario false. 
    Revise el funcionamiento del operador mod que le puede ayudar. Verifique que el denominador no sea cero 
    y en caso que sea, debe reportar el error y retornar false.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmosfunciones3 {

    public static boolean verificadorDivision(long numerador, long denominador) {

        long modulo = numerador % denominador;
        boolean verificador = false;

        if(modulo == 0) {

            verificador = true;

        }

        return verificador;

    }

    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);
        long numerador = 0, denominador = 1;
        boolean input = false;
        
        try {

            while(!input) {

                try {

                    System.out.println("Ingrese el dividendo (numerador), este debe ser entero.");
                    numerador = usuario.nextLong();

                    input = true;

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");
                    usuario.next();
                    
                }

            }

            while(input) {

                try {

                    System.out.println("Ingrese el divisor (denominador), este debe ser entero y diferente de cero.");
                    denominador = usuario.nextLong();

                    if(denominador == 0) {

                        throw new IllegalArgumentException("Error: el divisor debe ser un numero entero diferente de cero");

                    }

                    input = false;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puede ingresar numeros enteros");
                    usuario.next();

                }

            }

            input = verificadorDivision(numerador, denominador);

        } finally {

            if(input) {

                System.out.println("La division de " + numerador + " entre " + denominador + " es exacta");

            } else {

                System.out.println("La division de " + numerador + " entre " + denominador + " no es exacta");

            }

            usuario.close();

        }

    }
    
}