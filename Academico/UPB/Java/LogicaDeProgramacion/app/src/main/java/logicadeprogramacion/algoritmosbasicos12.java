/*

    solicitar x e y y calcular raíz cuadrada de x al cuadrado más y al cuadrado

*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmosbasicos12 {

    public static double excepciones(Scanner usuario) {

        boolean input = false;
        double dato = 0;

        while(!input) {

            try {

                System.out.println("");
                dato = usuario.nextDouble();

                input = true;

            } catch(Exception e) {

                System.out.println("Error: solo puedes ingresar numeros \n Intentalo de nuevo");

                usuario.next();

            }

        }

        return dato;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        double x = 0;
        double y = 0;
        double resultado = 0;

        try {

            System.out.println("Ingresa el valor de x");
            x = excepciones(usuario);

            System.out.println("Ingresa el valor de y");
            y = excepciones(usuario);

            resultado = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        } finally {

            System.out.println("La raiz cuadrada de " + x + " al cuadrado mas " + y + " al cuadrado es igual a " + resultado);

            usuario.close();

        }

    }
    
}
