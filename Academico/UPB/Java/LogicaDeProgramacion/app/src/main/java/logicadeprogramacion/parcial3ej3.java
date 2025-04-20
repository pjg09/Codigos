package logicadeprogramacion;

import java.util.Scanner;

public class parcial3ej3 {
 
    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        String [] frases = new String[5];
        char caracter = ' ';
        boolean input = false;

        try {

            for(byte i = 0; i < 5; i++) {

                if(i == 0) {

                    for(byte j = 0; j < 5; j++) {

                        while(!input) {

                            try {

                                System.out.println("Por favor ingresa la frase " + (j + 1) + "\nLas frases deben tener al menos 6 caracteres y dos palabras");
                                frases[j] = usuario.nextLine();

                                if(frases[j].length() < 6) {

                                    throw new IllegalArgumentException("Error: la frase debe tener al menos 6 caracteres");

                                }

                                if(!frases[j].contains(" ") || frases[j].indexOf(" ") == 0) {

                                    throw new IllegalArgumentException("Error: la frase debe contener al menos dos palabras");

                                }

                                input = true;

                            } catch(IllegalArgumentException e) {

                                System.out.println(e.getMessage());

                            }

                        }

                        input = false;

                    }

                }

                System.out.println("La frase " + (i + 1) + " tiene una longitud de " + frases[i].length());

            }

            input = false;

            while(!input) {

                try {

                    System.out.println("Ingresa un caracter para buscarlo en cada frase\nLo ubicaremos en su primera posicion de aparicion y su ultima posicion de aparicion");
                    caracter = usuario.next().charAt(0);

                    input = true;

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar un caracter para buscarlo en cada frase");

                }

            }

            for(int i = 0; i < 5; i++) {

                System.out.println("---------- Para la frase " + (i + 1) + " ----------");
                System.out.println("Frase en mayusculas: " + frases[i].toUpperCase());
                System.out.println("Frase en minusculas: " + frases[i].toLowerCase());
                System.out.println("La primera posicion del caracter " + caracter + " en la frase es la numero: " + frases[i].indexOf(caracter));    
                System.out.println("La ultima posicion del caracter " + caracter + " en la frase es la numero: " + frases[i].lastIndexOf(caracter));
                System.out.println("El tercer caracter de la frase es: " + frases[i].charAt(3));
                System.out.println("La subcadena desde la posicion 2 hasta la posicion 5 es: " + frases[i].substring(1, 4));

            }

            char [] caracteres1 = frases[0].toCharArray();
            char [] caracteres2 = frases[1].toCharArray();
            char [] caracteres3 = frases[2].toCharArray();
            char [] caracteres4 = frases[3].toCharArray();
            char [] caracteres5 = frases[4].toCharArray();

            String [] split1 = frases[0].split(" ");
            String [] split2 = frases[1].split(" ");
            String [] split3 = frases[2].split(" ");
            String [] split4 = frases[3].split(" ");
            String [] split5 = frases[4].split(" ");

            System.out.println("Cada caracter de la frase 1 es: ");

            for(char c : caracteres1) {

                System.out.println(c);

            }

            System.out.println("Cada caracter de la frase 2 es: ");

            for(char c : caracteres2) {

                System.out.println(c);

            }

            System.out.println("Cada caracter de la frase 3 es: ");

            for(char c : caracteres3) {

                System.out.println(c);

            }

            System.out.println("Cada caracter de la frase 4 es: ");

            for(char c : caracteres4) {

                System.out.println(c);

            }

            System.out.println("Cada caracter de la frase 5 es: ");

            for(char c : caracteres5) {

                System.out.println(c);

            }

            System.out.println("Cada palabra de la frase 1 es: ");

            for(String p : split1) {

                System.out.println(p);

            }

            System.out.println("Cada palabra de la frase 2 es: ");

            for(String p : split2) {

                System.out.println(p);

            }

            System.out.println("Cada palabra de la frase 3 es: ");

            for(String p : split3) {

                System.out.println(p);

            }

            System.out.println("Cada palabra de la frase 4 es: ");

            for(String p : split4) {

                System.out.println(p);

            }

            System.out.println("Cada palabra de la frase 5 es: ");

            for(String p : split5) {

                System.out.println(p);

            }

            for(int i = 1; i < 5; i++) {

                if(frases[1].equalsIgnoreCase(frases[i])) {

                    System.out.println("La frase 1 es igual a la frase" + (i + 1));

                } else {

                    System.out.println("La frase 1 es diferente a la frase " + (i + 1));

                }

            }

        } finally {

            System.out.println("Fin de la ejecución");

            usuario.close();

        }

    }

}