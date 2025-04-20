package logicadeprogramacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicioparcial1 {

    public static void main(String[] args) {

        //Declaracion de variables
        Scanner usuario = new Scanner(System.in);
        byte camas = 0;
        byte refrigeracion = 0;
        boolean input = false;
        String [] habitaciones = {"101", "102", "201", "202", "301"};
        String [] plantas = {"1", "2", "3"};
        String seleccionRefrigeracion = "";

        //Manejo de excepciones
        while(!input) {

            try {

                System.out.println("Ingrese el numero de camas que desee para su habitacion, minimo una, maximo tres: ");
                camas = usuario.nextByte();

                System.out.println("Digita 1 si deseas aire acondicionado o 2 si deseas ventilador ");
                refrigeracion = usuario.nextByte();

                if(camas <= 0 || camas >= 4) {

                    throw new IllegalArgumentException("solo puedes elegir de 1 a 3 camas");

                }

                if(refrigeracion <= 0 || refrigeracion >= 3) {

                    throw new IllegalArgumentException("solo puedes ingresar 1 o 2 para elegir entre aire acondicionado o ventilador");

                }

                input = true;

            } catch(InputMismatchException e) {

                System.out.println("Error: ingresa un numero para tus elecciones");
                usuario.next();

            } catch(IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            }

        }

        //Analisis de las selecciones y muestra de resultados
        if(refrigeracion == 1) {

            seleccionRefrigeracion = "aire acondicionado";

        } else if(refrigeracion == 2) {

            seleccionRefrigeracion = "ventilador";

        }

        if(camas == 2 && refrigeracion == 1) {

            System.out.println("Las habitaciones disponibles para tu seleccion son: \n La habitacion " + habitaciones[0] + " en la planta " + plantas[0] + " \n La habitacion " + habitaciones[4] + " en la planta " + plantas[2] + " \n Ambas cuentan con " + seleccionRefrigeracion);

        } else if(camas == 1 && refrigeracion == 2) {

            System.out.println("La habitacion disponible para tu seleccion es la habitacion " + habitaciones[1] + " en la planta " + plantas[0] + " y cuenta con " + seleccionRefrigeracion);

        } else if(camas == 3 && refrigeracion == 1) {

            System.out.println("La habitacion disponible para tu seleccion es la habitacion " + habitaciones[2] + " en la planta " + plantas[1] + " y cuenta con " + seleccionRefrigeracion);

        } else if(camas == 2 && refrigeracion == 2) {

            System.out.println("La habitacion disponible para tu seleccion es la habitacion " + habitaciones[3] + " en la planta " + plantas[1] +  " y cuenta con " + seleccionRefrigeracion);

        } else {

            System.out.println("Lo sentimos, no contamos con ninguna habitacion disponible que se adapte a tus necesidades");

        }

        usuario.close();

    }
    
}
