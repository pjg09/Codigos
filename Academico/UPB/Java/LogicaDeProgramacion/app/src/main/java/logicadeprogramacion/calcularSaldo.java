/*

    * 1. Diseñe un algoritmo e implemente la función Calcular_saldo que reciba
    * tres enteros: la base de dinero en la taquilla, el total de recaudos y
    * el total de retiros, y retorne un entero que represente el saldo final
    * en la taquilla.
     
    * Valide que la base sea igual a 2.000.000. Si no es así, retorne -1.
    * 
    * saldo_taquilla = base + total recaudos - total_retiros
    * Si hay algún error, retorne -1.


*/

package logicadeprogramacion;

import java.util.Scanner;

public class calcularSaldo {

    public static long excepciones(Scanner usuario) {

        boolean input = false;
        long dato = 0;

        while(!input) {

            try {

                System.out.println("");
                dato = usuario.nextLong();

                if(dato < 0) {

                    throw new IllegalArgumentException("Error: el numero no puede ser negativo");

                }

                input = true;

            } catch(IllegalArgumentException e) {

                System.out.println(e.getMessage() + "\nIntentalo de nuevo");

            } catch(Exception e) {

                System.out.println("Error: solo puedes ingresar numeros enteros");
                usuario.next();

            }

        }

        return dato;

    }

    public static long calcular_saldo(int base, long totalRecaudos, long totalRetiros) {

        long saldoFinal = base + totalRecaudos - totalRetiros;

        return saldoFinal;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        byte opcion = 0;
        int base = 2000000;
        long totalRecaudos = 0, totalRetiros = 0, saldoFinal = 0, retiro = 0, recaudo = 0;
        boolean input = false;

        try {

            while(opcion != 3) {

                while(!input) {

                    try {

                        System.out.println("Seleccione la opcion que desea para su operacion\nDigite 1 para retirar dinero\nDigite 2 para ingresar dinero\nDigite 3 para finalizar las operaciones y revisar el saldo final de la taquilla");
                        opcion = usuario.nextByte();

                        if(opcion < 1 || opcion > 3) {

                            throw new IllegalArgumentException("Error: solo puedes ingresar numeros entre 1 y 3 para indicar tu eleccion");

                        }

                        input = true;

                    } catch(IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    } catch(Exception e) {

                        System.out.println("Error: solo puedes ingresar numeros enteros para indicar tu eleccion");
                        usuario.next();

                    }

                }

                input = false;
                
                if(opcion > 0 && opcion < 3) {

                    switch(opcion) {

                        case 1:
                            System.out.println("Ingresa la cantidad de dinero que deseas retirar");
                            retiro = excepciones(usuario);
    
                            totalRetiros += retiro;
                            break;
    
                        case 2:
                            System.out.println("Ingresa la cantidad de dinero que deseas ingresar");
                            recaudo = excepciones(usuario);
    
                            totalRecaudos += recaudo;
                            break;
    
                    }

                }

            }

            saldoFinal = calcular_saldo(base, totalRecaudos, totalRetiros);

        } finally {

            System.out.println("Gracias por usar nuestra taquilla\nLa base inicial fue de $2000000\nSe ingresaron $" + totalRecaudos + " pesos\nSe retiraron $" + totalRetiros + " pesos\n El saldo final de la taquilla es de $" + saldoFinal + " pesos");

            usuario.close();

        }

    }
    
}