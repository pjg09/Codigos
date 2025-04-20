//Que nos ingrese un numero mientras sea menor o igual a 500

package logicadeprogramacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejerciciowhile {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        short numero = 0;

        while(numero <= 500){

            try {

                System.out.println("Ingrese un numero");
                numero = usuario.nextShort();

            } catch(InputMismatchException e) {

                System.out.println("Error, solo puedes ingresar numeros");
                usuario.next();

            }

        }

        usuario.close();

    }
    
}
