/*

    Diseñe un algoritmo, defina e implemente una función en java que permita al usuario ingrese 5 números
    adicionalmente deberá pedir otro número. El programa indicará si el último número está contenido en los primeros 5 números.
    Todos los números que serán ingresados son enteros.
    Defina usted los elementos de esta función de acuerdo a las recomendaciones vistas en clase

*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmosfunciones1 {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        long[] lista = new long[5];
        long numero = 0;
        boolean input = false;

        try {

            for(byte i = 0; i <= 4; i++) {

                while(!input) {

                    try {

                        System.out.println("Ingrese el numero " + (i + 1) + " (este debe ser entero)");
                        lista[i] = usuario.nextLong();

                        input = true;

                    } catch(Exception e) {

                        System.out.println("Error: solo puedes ingresar numeros enteros");

                        usuario.next();

                    }

                }

                input = false;

            }

            while(!input) {

                try {

                    System.out.println("Ingresa un numero entero para ver si está contenido dentro de los 5 numeros que ingresaste anteriormente");
                    numero = usuario.nextLong();

                    input = true;

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");

                    usuario.next();

                }

            }

            input = false;

            for(byte i = 0; i <= 4; i++) {

                if(lista[i] == numero) {

                    input = true;

                }

            }

        } finally {

            if(input) {

                System.out.println("El numero " + numero + " esta contenido dentro de los primeros cinco numeros que ingresaste");

            } else {

                System.out.println("El numero " + numero + " no esta contenido dentro de los primeros cinco numeros que ingresaste");

            }

            usuario.close();

        }

    }
    
}