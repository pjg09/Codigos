/*

     * Diseñe un algoritmo e implemente la función Calcular_area_triangulo
     * que reciba dos floats representando la base y la altura de un triángulo
     * rectángulo, y devuelva un float que represente el área del triángulo.
     * 
     * Valide que la base y la altura sean mayores a 0. Si no es así, retorne -1.
     * 
     * La fórmula del área es: área = 1/2 * base * altura.
     * 
     * Si hay algún error, retorne -1.


*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class AreaTriangulo {

    public static double excepciones(Scanner usuario) {

        double dato = 0;
        boolean input = false;

        while(!input) {

            try {

                dato = usuario.nextDouble();

                input = true;

            } catch(Exception e) {

                System.out.println("Error: solo puedes ingresar numeros\nIntentalo de nuevo");

            }

        }

        return dato;

    }

    public static double calcularAreaTriangulo(double base, double altura) {

        double area = 0.5 * base * altura;

        return area;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        DecimalFormat fix = new DecimalFormat("#,###.00");

        double base = 0, altura = 0, area = 0;

        try {

            System.out.println("Algoritmo para calcular el area de un triangulo rectangulo\n");

            System.out.println("Ingresa la base del triangulo");
            base = excepciones(usuario);

            while(base < 1) {

                System.out.println("Error: la base del triangulo no puede ser menor a 0\nIntentalo de nuevo");
                base = excepciones(usuario);

            }

            System.out.println("Ingresa la altura del triangulo");
            altura = excepciones(usuario);

            while(altura < 1) {

                System.out.println("Error: la altura del triangulo debe ser mayor a 0\nIntentalo de nuevo");
                altura = excepciones(usuario);

            }

            area = calcularAreaTriangulo(base, altura);

        } finally {

            System.out.println("El area del triangulo rectangulo de base " + base + " y altura " + altura + " es " + fix.format(area));

            usuario.close();

        }

    }
    
}