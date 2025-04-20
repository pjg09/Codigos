/*

    Diseñe un algoritmo para calcular la propina en un restaurante(10%), el impuesto al consumo (8%) y el valor final que deberá pagar, 
    ingresando el valor de la comida.

*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class algoritmosbasicos11 {

    public static void main(String[] args) {
        
        DecimalFormat fix = new DecimalFormat("#,000");
        Scanner usuario = new Scanner(System.in);
        double valorComida = 0, propina = 0, impuesto = 0, valorFinal = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingrese el valor de la comida: ");
                    valorComida = usuario.nextDouble();

                    if(valorComida < 0) {

                        throw new IllegalArgumentException("Error: el valor de la comida no puede ser negativo");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros para el valor de la comida");
                    usuario.next();

                }

            }

            propina = valorComida * 0.10;
            impuesto = valorComida *0.08;
            valorFinal = valorComida + propina + impuesto;

        } finally {

            System.out.println("El valor total a pagar por la comida es $" + fix.format(valorFinal));
            usuario.close();

        }

    }
    
}