/*
 
    Solicitar al usuario ingresar una cantidad expresada en cc (centímetros cúbicos) y devolver su cantidad en litros

*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmosbasicos3 {

    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);
        double cc = 0;
        double litros = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingrese una cantidad en centimetros cubicos, por favor solo numeros, no escriba letras");
                    cc = usuario.nextInt();

                    input = true;

                    litros = cc * 5000;

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros");
                    usuario.next();

                }

            }

        } catch(Exception e) {

            System.out.println("");

        } finally {

            System.out.println(cc + " centimetros cubicos equivalen a " + litros + " litros");
            usuario.close();

        }
        
    }
    
}
