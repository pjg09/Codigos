package logicadeprogramacion;

import java.util.Scanner;

public class ejercicio11 {

    public static void main(String[] args) {
        
        // Declaración de variables
        Scanner usuario = new Scanner (System.in);
        String nombre = "";
        String [] obsequio = {"postre", "bebida", "postre y una bebida"};
        byte plato = 0;
        boolean inputValido = false;
        boolean nombreValido = false;

        // Manejo de excepciones con un ciclo while y ayuda de una variable auxiliar booleana
        // Para asegurarnos de que el usuario ingrese un nombre adecuado
        while (!nombreValido) {

            try {

                System.out.println("Ingresa tu nombre para ordenar tu plato: ");
                nombre = usuario.nextLine();

                // Condicionales para detectar tipos de excepciones y enviarlas en caso de detectarlas
                // Incluyen el mensaje de la excepcion para ser más especifico
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

        // Manejo de excepciones con ciclo while para asegurarnos que se ingrese un numero de plato valido
        while(!inputValido) {

            try {

                System.out.println("Selecciona tu plato: 1, 2 o 3.");
                plato = usuario.nextByte();

                //Si llegamos a este punto la entrada es valida
                inputValido = true;

            }   catch (Exception e) {

                System.out.println("Error, ingresa un numero valido.");
                usuario.next();

            }

        }

        // Condicionales para asignar la recompensa del usuario
        if(plato == 1) {

            System.out.println("Felicitaciones " + nombre + " has ganado un " + obsequio [0]);

        } else {

            if(plato == 2) {

                System.out.println("Felicitaciones " + nombre + " has ganado un " + obsequio [1]);

            } else {

                if(plato == 3) {

                    System.out.println("Felicitaciones " + nombre + " has ganado un " + obsequio [2]);

                } else {

                    System.out.println("El plato que has seleccionado no es apto para ganar un obsequio");

                }

            }

        }

        usuario.close();

    }
    
}