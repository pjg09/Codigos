/*

    Diseñe un algoritmo, defina e implemente la función Estimar_Cambio  que recibe un monto en pesos (COPs)
    arma y devuelve en un texto,  el equivalente en las siguientes monedas, según el factor:

    1 Dólar Americano = $4445
    1 Euro = $4560
    1 Dólar canadiense = $4365
    1 Yen japonés = $34,7

    Considere para este ejercicio definir los factores como constantes y globales para que lo pueda usar cualquier función definida.

*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class algoritmosfunciones2 {

    public static double estimarCambio(double cop, double tasa) {

        double conversion = cop / tasa;

        return conversion;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        DecimalFormat fix = new DecimalFormat("#,###,00");
        byte opcion = 0;
        double cop = 0, tasa = 0, conversion = 0;
        String nombreMoneda = "";
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingrese la cantidad de pesos: ");
                    cop = usuario.nextDouble();

                    if(cop < 0) {

                        throw new IllegalArgumentException("Error: no puedes convertir menos de 0 pesos");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros.");
                    usuario.next();

                }

            }

            while(input) {

                try {

                    System.out.println("A cual moneda deseas realizar la conversion ingresa el numero para seleccionar tu opcion: \n 1. Dolar estadounidense \n 2. Euro \n 3. Dolar canadiense \n 4. Yen japomes");
                    opcion = usuario.nextByte();

                    if(opcion < 1 || opcion > 4) {

                        throw new IllegalArgumentException("Error: solo puedes ingresar numeros enteros del 1 al 4");

                    }

                    input = false;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");
                    usuario.next();

                }

            }

            switch(opcion) {

                case 1:
                    tasa = 4445;
                    nombreMoneda = "dolares";
                    break;
    
                case 2:
                    tasa = 4560;
                    nombreMoneda = "euros";
                    break;
    
                case 3:
                    tasa = 4365;
                    nombreMoneda = "dolares canadienses";
                    break;
    
                case 4:
                    tasa = 34.7;
                    nombreMoneda = "yenes";
                    break;
    
            }

            conversion = estimarCambio(cop, tasa);

        } finally {

            System.out.println("$" + cop + " pesos equivalen a $" + fix.format(conversion) + " " + nombreMoneda);
            usuario.close();

        }

    }
    
}