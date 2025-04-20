/*

    Se requiere un algoritmo que le solicite al usuario la cantidad de números aleatorios que se deben de generar entre 1 y 100.
    Este valor será enviado a una función y esta será la encargada de retornar los números aleatorios separados por guiones.

    Ejemplo de Ejecución:
    Ingrese la cantidad de números a generar: 5
    (La función deberá generar 5 números aleatorios y retornarlo de la siguiente forma:)
    23-54-12-98-7
    (Esta información debe de mostrarse en la consola)

    ----------------------------------------------------------------------------------------------------------------------------------------

    Los números aleatorios devueltos por la función tendrán que ser enviados a otra función que retornará:
	La suma total de todos los números
	La suma de solo los números en índices pares (el cero cuenta como par)
	La suma de solo los números en posiciones impares
    (Esta información debe de imprimirse por consola)



*/

package logicadeprogramacion;

import java.util.Scanner;

public class numerosAleatorios {

    public static int generarNumero() {

        int numero = (int)(Math.random() * 100) + 1;

        return numero;

    }

    public static String calculos(int numerosAleatorios[]) {

        String resultados = "";
        long sumaTotal = 0, sumaIndicesPares = 0, sumaIndicesImpares = 0;

        for(int i = 0; i < numerosAleatorios.length; i++) {

            sumaTotal += numerosAleatorios[i];

            if(i == 0 || (i % 2) == 0) {

                sumaIndicesPares += numerosAleatorios[i];

            } else {

                sumaIndicesImpares += numerosAleatorios[i];

            }

        }

        resultados = "La suma de todos los numeros es: " + sumaTotal + "\nLa suma de todos los numeros en indices pares (contando el cero como par) es: " + sumaIndicesPares + "\nLa suma de todos los numeros en indices impares es: " + sumaIndicesImpares;

        return resultados;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        String resultado = "", StringNumeros = "";
        StringBuilder numeros = new StringBuilder();
        int cantidadNumeros = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingrese la cantidad de numeros aleatorios entre 1 y 100 que desea generar:");
                    cantidadNumeros = usuario.nextInt();

                    if(cantidadNumeros < 1) {

                        throw new IllegalArgumentException("Error: solo puedes generar 1 o mas numeros.");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros para indicar la cantidad de numeros que deseas generar.");
                    usuario.next();

                }

            }

            int [] numerosAleatorios = new int [cantidadNumeros];

            for(int i = 0; i < numerosAleatorios.length; i++) {

                numerosAleatorios[i] = generarNumero();

            }

            for(int i = 0; i < (numerosAleatorios.length - 1); i++) {

                numeros.append(numerosAleatorios[i] + " - ");

            }

            numeros.append(numerosAleatorios[(numerosAleatorios.length - 1)]);

            StringNumeros = numeros.toString();

            resultado = calculos(numerosAleatorios);

        } finally {

            System.out.println(StringNumeros);
            System.out.println(resultado);

            usuario.close();

        }

    }
    
}