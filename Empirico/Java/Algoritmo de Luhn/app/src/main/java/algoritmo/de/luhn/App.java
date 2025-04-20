package algoritmo.de.luhn;

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        long recolector = 0;
        String conversor = "";

        try {

            System.out.println("Ingrese el numero de su tarjeta de credito");
            recolector = usuario.nextLong();

        } catch(InputMismatchException e) {

            System.out.println("Error, solo puedes ingresar numeros para la tarjeta de credito");

        }

        conversor = Long.toString(recolector);
        long [] tarjeta = new long[conversor.length()];

        for(int indice = 0; indice < conversor.length(); indice++) {

            tarjeta[indice] = Character.getNumericValue(conversor.charAt(indice));

        }

        for(int indice = tarjeta.length - 1; indice <= 0; indice--) {

            if((tarjeta.length - 1 - indice) % 2 == 1) {

                tarjeta[indice] *= 2;

            }

        }        

        usuario.close();

    }

}
