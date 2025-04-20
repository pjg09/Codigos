/*

     * Diseñe un algoritmo e implemente la función Calcular_perimetro_cuadrado
     * que reciba un float representando el lado de un cuadrado, y devuelva un
     * float que represente el perímetro del cuadrado.
     * 
     * Valide que el lado sea mayor a 0. Si no es así, retorne -1.
     * 
     * La fórmula del perímetro es: perímetro = lado * 4.
     * 
     * Si hay algún error, retorne -1.


*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class calcularPerimetro {

    public static double area(double lado) {

        double area = lado * lado;

        return area;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        DecimalFormat fix = new DecimalFormat("#,###.00");
        double lado = 0, area = 0;
        boolean input = false;

        try {

            System.out.println("Algoritmo para calcular el area de un cuadrado");

            while(!input) {

                try {

                    System.out.println("Ingresa uno de los lados del cuadrado");
                    lado = usuario.nextDouble();

                    if(lado <= 0) {

                        throw new IllegalArgumentException("Error: el lado del cuadrado debe ser mayor a cero");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros para indicar el lado del cuadrado");

                }

            }

            area = area(lado);

        } finally {

            System.out.println("El area del cuadrado de lado " + lado + " es " + fix.format(area));

            usuario.close();

        }

    }
    
}