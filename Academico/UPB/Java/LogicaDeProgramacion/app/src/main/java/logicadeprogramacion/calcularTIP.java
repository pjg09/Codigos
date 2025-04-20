/*

     * 2. Diseñe un algoritmo e implemente la función Calcular_tip que reciba
     * un float representando el valor del consumo de un cliente, y devuelva
     * un string que contenga el valor de la propina (10%), el impuesto al
     * consumo (8%) y el valor total a pagar.
     * 
     * MUY IMPORTANTE:
     * 
     * El formato del string debe ser: valor comida: $### - valor propina $### -
     * valor impoconsumo $### - total a pagar $###.
     * 
     * Si hay algún error, retorne "Error en la función Calcular_tip".
     * 
     * Ademas de esto, primero valide que el valor del consumo sea mayor a 0. Si no
     * es así, retorne "Error calculando consumo".

*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class calcularTIP {

     public static String calcular_tip(float consumo) {

          DecimalFormat fix = new DecimalFormat("#,###.00");
          double propina = consumo * 0.10, impuesto = consumo * 0.08;
          String tip = "La propina por el consumo de $" + fix.format(consumo) + " es de $" + fix.format(propina) + " y el impuesto al consumo es $" + fix.format(impuesto);
          
          return tip;

     }

     public static void main(String[] args) {
          
          Scanner usuario = new Scanner(System.in);
          float consumo = 0;
          String tip = "";
          boolean input = false;

          try {

               while(!input) {

                    try {

                         System.out.println("Ingresa el valor consumido por el cliente");
                         consumo = usuario.nextFloat();

                         if(consumo < 0) {

                              throw new IllegalArgumentException("Error: el consumo del cliente debe ser mayor a cero");

                         }

                         input = true;

                    } catch(IllegalArgumentException e) {

                         System.out.println(e.getMessage());

                    } catch(Exception e) {

                         System.out.println("Error: solo puedes ingresar numeros para indicar el consumo del cliente");
                         usuario.next();

                    }

               }

               usuario.close();

               tip = calcular_tip(consumo);

          } finally {

               System.out.println(tip);

          }

     }
    
}
