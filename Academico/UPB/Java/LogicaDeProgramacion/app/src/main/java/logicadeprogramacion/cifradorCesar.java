package logicadeprogramacion;

import java.util.Scanner;

public class cifradorCesar {

    public static String cifrado(long desplazamiento, String mensajeNoCifrado) {

        StringBuilder mensajeCifrado = new StringBuilder();
        char caracterActual, caracterCifrado;
        
        desplazamiento = desplazamiento % 26;

        for(int i = 0; i < mensajeNoCifrado.length(); i++) {

            caracterActual = mensajeNoCifrado.charAt(i);

            if(caracterActual >= 'A' && caracterActual <= 'Z') {

                caracterCifrado = (char) (((caracterActual - 'A' + desplazamiento) % 26) + 'A');
                mensajeCifrado.append(caracterCifrado);

            } else if(caracterActual >= 'a' && caracterActual <= 'z') {

                caracterCifrado = (char) (((caracterActual - 'a' + desplazamiento) % 26) + 'a');
                mensajeCifrado.append(caracterCifrado);

            } else {

                mensajeCifrado.append(caracterActual);

            }

        }

        return mensajeCifrado.toString();

    }

    public static String descifrador(long desplazamiento, String mensajeNoCifrado) {

        StringBuilder mensajeCifrado = new StringBuilder();
        char caracterActual, caracterCifrado;
        
        desplazamiento = desplazamiento % 26;

        for(int i = 0; i < mensajeNoCifrado.length(); i++) {

            caracterActual = mensajeNoCifrado.charAt(i);

            if(caracterActual >= 'A' && caracterActual <= 'Z') {

                caracterCifrado = (char) (((caracterActual - 'A' - desplazamiento + 26) % 26) + 'A');
                mensajeCifrado.append(caracterCifrado);

            } else if(caracterActual >= 'a' && caracterActual <= 'z') {

                caracterCifrado = (char) (((caracterActual - 'a' - desplazamiento + 26) % 26) + 'a');
                mensajeCifrado.append(caracterCifrado);

            } else {

                mensajeCifrado.append(caracterActual);

            }

        }

        return mensajeCifrado.toString();
    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        String proceso = "", mensajeNoCifrado = "", mensaje = "";
        byte opcion = 0;
        long desplazamiento = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Digite su seleccion.\nDigite 1 para cifrar un mensaje.\n Digite 2 para descifrar un mensaje.");
                    opcion = usuario.nextByte();

                    if(opcion < 1 || opcion > 2) {

                        throw new IllegalArgumentException("Error: solo puedes digitar 1 o 2 para indicar tu eleccion.");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros para indicar tu eleccion.");
                    usuario.next();

                }

            }

            switch(opcion) {

                case 1:
                    proceso = "cifrado";
                    break;

                case 2:
                    proceso = "descifrado";
                    break;

            }

            while(input) {

                try {

                    System.out.println("Ingrese el desplazamiento para el " + proceso);
                    desplazamiento = usuario.nextLong();

                    if(desplazamiento < 1) {

                        throw new IllegalArgumentException("Error: El desplazamiento debe ser mayor a 1");

                    }

                    input = false;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: Solo puedes ingreasr numeros para indicar el desplazamiento");
                    usuario.next();

                }

            }

            while(!input) {

                try {

                    System.out.println("Ingresa el mensaje que deseas realizarle el " + proceso);
                    mensajeNoCifrado = usuario.nextLine();

                    if(mensajeNoCifrado == null || mensajeNoCifrado.trim().isEmpty()) {

                        throw new IllegalArgumentException("Error: el mensaje a cifrar no puede estar vacio");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                }

            }

            switch(opcion) {

                case 1:
                    mensaje = cifrado(desplazamiento, mensajeNoCifrado);
                    break;

                case 2:
                    mensaje = descifrador(desplazamiento, mensajeNoCifrado);
                    break;

            }

        } finally {

            System.out.println(mensaje);
            usuario.close();

        }

    }
    
}