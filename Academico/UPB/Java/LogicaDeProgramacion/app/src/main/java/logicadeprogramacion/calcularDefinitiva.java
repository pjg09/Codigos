/*

     * 4. Diseñe un algoritmo e implemente la función Calcular_definitiva que
     * reciba cinco floats representando las notas (entre 0 y 5) y cinco floats
     * representando los porcentajes (que entre todos deberán sumar 1 y cada uno
     * estar entre 0 y 1),
     * y devuelva un float que represente la nota definitiva. Si algo está mal
     * con los porcentajes o con las notas, retorne -1.


*/

package logicadeprogramacion;

import java.util.Scanner;

public class calcularDefinitiva {

     public static float excepciones(Scanner usuario) {

          float dato = 0;
          boolean input = false;

          while(!input) {

               try {

                    dato = usuario.nextFloat();

                    input = true;

               } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros\nIntentalo de nuevo");
                    usuario.next();

               }

          }

          return dato;

     }

     public static void main(String[] args) {
          
          Scanner usuario = new Scanner(System.in);
          float sumaPorcentajes = 0, notaDefinitiva = 0;
          float [] notas = new float [5];
          float [] porcentajes = new float [5];
          float [] notasConPorcentajes = new float [5];
          boolean input = false;

          try {

               for(byte i = 0; i < notas.length; i++) {

                    System.out.println("Ingrese la nota numero " + (i + 1));
                    notas[i] = excepciones(usuario);

                    while(notas[i] < 0 || notas[i] > 5) {

                         System.out.println("Error: la nota debe estar entre 0 y 5");
                         notas[i] = excepciones(usuario);

                    }

               }

               while(!input) {

                    for(byte i = 0; i < porcentajes.length; i++) {

                         System.out.println("Ingrese el porcentaje de la nota " + (i + 1) + " (" + notas[i] + ")\nSolo puedes ingresar numeros entre 0 y 1 para definir el porcentaje\nLa suma de los 5 porcentajes debe ser exactamente 1\nNo ingreses el signo de porcentaje o ningun otro signo para indicar el porcentaje de la nota");
                         porcentajes[i] = excepciones(usuario);

                         while(porcentajes[i] < 0 || porcentajes[i] > 1) {

                              System.out.println("Error: solo puedes ingresar numeros entre 0 y 1 para indicar el peso de la nota");
                              porcentajes[i] = excepciones(usuario);

                         }

                    }

                    for(byte j = 0; j < porcentajes.length; j++) {

                         sumaPorcentajes += porcentajes[j];

                    }

                    if(sumaPorcentajes != 1) {

                         System.out.println("Error: la suma de los porcentajes debe ser igual a 1\nIngresa nuevamente los porcentajes teniendo en cuenta esto");

                    } else if(sumaPorcentajes == 1) {

                         input = true;

                    }

               }

               for(byte j = 0; j < notasConPorcentajes.length; j++) {

                    notasConPorcentajes[j] = notas[j] * porcentajes[j];

               }

               for(byte i = 0; i < notasConPorcentajes.length; i++) {

                    notaDefinitiva += notasConPorcentajes[i];

               }

          } finally {

               if(notaDefinitiva >= 3) {

                    System.out.println("La nota definitiva es: " + notaDefinitiva + "\nHas aprobado la materia");

               } else {

                    System.out.println("La nota definitiva es: " + notaDefinitiva + "\nHas reprobado la materia");

               }

               usuario.close();

          }

     }
    
}