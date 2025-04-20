package logicadeprogramacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejerciciodowhile {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        short numero = 0;

        do {

            try {

                System.out.println("Ingresa un numero: ");
                numero = usuario.nextShort();

            } catch(InputMismatchException e) {

                System.out.println("Error: solo puedes ingresar numeros");
                usuario.next();

            }

        } while(numero <= 500);

        usuario.close();

    }
    
}
