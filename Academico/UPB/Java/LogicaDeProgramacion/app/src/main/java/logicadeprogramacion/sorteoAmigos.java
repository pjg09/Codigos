/*

    * 7. Un grupo de amigos hace un sorteo semanalmente con pelotas de ping pong,
    * para saber quién invita y a qué  la próxima salida.
    * Las opciones dependen del color que sacan en cada bola y son:
    * 
    * verde: Invita a las cervezas
    * azul: Invita a la pizza
    * rojo: Invita al postre
    * amarillo: Paga el parqueadero de todos
    * blanco o negro: Vaya y disfrute
    * Si la función recibe algo diferente a los colores dados, debe retornar
    * "Error en el color".
    * 
    * Se necesita una función en java Conocer_invitacion que reciba un string con
    * el color de la bola y retorna un
    * String con exactamente el texto de la invitación correspondiente.
    * 
    * Si hay un error inesperado, deberá mostrar el mensaje:
    * "Ocurrió un error inesperado".

*/

package logicadeprogramacion;

import java.util.Scanner;

public class sorteoAmigos {

    public static String conocerInvitacion(String color) {

        String invitacion = "";

        switch(color) {

            case "VERDE":
                invitacion = "invitas a las cervezas";
                break;

            case "AZUL":
                invitacion = "invitas a la pizza";
                break;

            case "ROJO":
                invitacion = "invitas al postre";
                break;

            case "AMARILLO":
                invitacion = "pagas el parqueadero de todos";
                break;

            case "BLANCO":
                invitacion = "ve y disfruta";
                break;

            case "NEGRO":
                invitacion = "ve y disfruta";
                break;

        }

        return invitacion;

    }

    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);
        String color = "", invitacion = "";
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("¿Cual es el color de la bola que sacaste? \n Ingresa solo el nombre del color");
                    color = usuario.nextLine().toUpperCase();

                    if(color.equals("VERDE") && color.equals("AZUL") && color.equals("ROJO")  && color.equals("AMARILLO") && color.equals("BLANCO")  && color.equals("NEGRO")) {

                        throw new IllegalArgumentException("Error: solo puedes ingresar verde, azul, rojo amarillo o blanco para indicar el color");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                }

            }

            invitacion = conocerInvitacion(color);

        } finally {

            System.out.println("Como sacaste el color " + color + " entonces " + invitacion);    
            
            usuario.close();

        }
        
    }
    
}