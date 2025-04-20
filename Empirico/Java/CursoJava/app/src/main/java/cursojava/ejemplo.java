package cursojava;

import java.util.Scanner;

public class ejemplo {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner (System.in);

        int numero = 0;
        boolean input = false;

    while (!input){
        try {

            System.out.println("Ingrese su numero");
            numero = usuario.nextInt();
            input = true;

        } catch (Exception e) {

            System.out.println("Ingrese un numero valido");
            usuario.next();

        }
    }

        
        System.out.println("Su numero es " + numero);

        usuario.close();

    }
    
}
