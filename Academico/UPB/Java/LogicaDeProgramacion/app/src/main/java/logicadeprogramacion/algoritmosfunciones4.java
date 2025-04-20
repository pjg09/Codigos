/*

    Diseñe un algoritmo e implemente una función en Java que identifique y escriba el número mayor entre 3 números short
    digitados por los usuarios. Defina usted los elementos de esta función de acuerdo a las recomendaciones vistas en clase.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmosfunciones4 {

    public static short hallarMaximo(short lista[], short maximo) {

        for(byte i = 1; i <= 2; i++) {

            if(lista[i] > maximo) {

                maximo = lista[i];

            }            

        }

        return maximo;

    }

    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);
        short[] lista = new short[3];
        short maximo = 0;
        boolean input = false;

        try {

            for(byte i = 0; i < lista.length; i++) {

                while(!input) {

                    try {

                        System.out.println("Ingresa el numero " + (i + 1) + " debe ser entero y estar entre -32768 y 32767");
                        lista[i] = usuario.nextShort();

                        input = true;

                    } catch(Exception e) {

                        System.out.println("Error: solo puedes ingresar numeros enteros entre -32768 y 32767");

                    }

                }

                input = false;

            }

            maximo = lista[0];

            maximo = hallarMaximo(lista, maximo);

        } finally {

            System.out.println("El mayor de los tres numeros que ingresaste es " + maximo);

            usuario.close();

        }
        
    }
    
}