package logicadeprogramacion;

import java.util.Scanner;

public class ejercicio10 {
    
    public static void main(String[] args) {

        // Declaración de variables
        Scanner usuario = new Scanner (System.in);
        String nombre = "";
        int [] resultados = new int [3];
        short puntaje = 0;
        boolean nombreValido = false;
        
        // Manejo de excepciones
        while (!nombreValido) {

            try {

                System.out.println("Ingresa tu nombre para ordenar iniciar el juego: ");
                nombre = usuario.nextLine();

                if (nombre == null || nombre.trim().isEmpty()) {

                    throw new IllegalArgumentException("El nombre no puede estar vacío.");

                }

                if (nombre.matches(".*\\d.*")) {

                    throw new IllegalArgumentException("El nombre no puede contener números.");

                }

                if (!nombre.matches("[a-zA-Z\\s]+")) {

                    throw new IllegalArgumentException("El nombre no puede contener caracteres especiales.");

                }

                nombreValido = true;

            } catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            } 
            
        }

            for (byte i = 0; i < 3; i++) {

                resultados [i] = (int)(Math.random() * 6) + 1;

            }

            System.out.println(nombre + " los resultados de tus dados son los siguientes: " + resultados [0] + ", " + resultados [1] + ", " + resultados [2] + ".");

            if (resultados [0] == resultados [1] && resultados [0] == resultados [2]) {

                puntaje = 1000;

            } else {

                if (resultados [0] == resultados [1] || resultados [0] == resultados [2] || resultados [1] == resultados [2]) {

                    puntaje = 500;
    
                } else {

                    System.out.println("Que tengas mejor suerte la proxima vez.");

                }

            }

        System.out.println(nombre + " tu puntaje es de " + puntaje + " puntos.");

        usuario.close();

    }

}