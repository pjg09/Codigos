package logicadeprogramacion;

import java.util.Scanner;

public class bonificacion2 {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        byte opcion = 0;
        long numero = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Selecciona tu opcion\nDigita 1 para ver la tabla de multiplicar del 1 al 10 del numero que desees\nDigita 2 para ver todas las tablas de multiplicar del 1 al 10");
                    opcion = usuario.nextByte();

                    if(opcion < 1 || opcion > 2) {

                        throw new IllegalArgumentException("Error: solo puedes ingresar 1 o 2 para indicar tu eleccion en el menu");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");
                    usuario.next();

                }
                
            }

        } finally {

            switch(opcion) {

                case 1:
                
                    while(input) {

                        try {

                            System.out.println("Ingresa el numero del que deseas ver las tablas de multiplicar");
                            numero = usuario.nextLong();
                            
                            input = false;

                        } catch(Exception e) {

                            System.out.println("Error: solo puedes ingresar numeros enteros para determinar el numero del que quieres ver las tablas");

                        }

                    }

                    for(byte i = 1; i <= 10; i++) {

                        System.out.println(i + " x " + numero + " = " + (i * numero));

                    }

                    break;

                case 2:
                    for(byte i = 1; i <= 10; i++) {

                        for(byte j = 1; j <= 10; j++) {

                            System.out.println(i + " x " + j + " = " + (i * j));

                        }

                    }
                    break;

            }

            usuario.close();

        }

    }
    
}
