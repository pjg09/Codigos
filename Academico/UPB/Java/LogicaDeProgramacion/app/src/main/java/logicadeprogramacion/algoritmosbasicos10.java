/*

    Diseñar un algoritmo que calcule el peso neto en la luna de un peso terrestre ingresado por teclado.
    La gravedad de la Luna es de alrededor del 17% más que la de la tierra

*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class algoritmosbasicos10 {

    public static void main(String[] args) {

        DecimalFormat fix = new DecimalFormat("#.000");
        Scanner usuario = new Scanner(System.in);
        double pesoTerrestre = 0, pesoLunar = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingrese el peso terrestre");
                    pesoTerrestre = usuario.nextDouble();

                    if(pesoTerrestre < 0) {

                        throw new IllegalArgumentException("Error: el peso no puede ser negativo");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros");
                    usuario.next();

                }

                pesoLunar = pesoTerrestre * 0.17;

            }

        } finally {

            System.out.println("El peso lunar de " + fix.format(pesoTerrestre) + " es " + fix.format(pesoLunar));
            usuario.close();

        }

    }
    
}