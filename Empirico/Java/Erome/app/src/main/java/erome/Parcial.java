package erome;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Parcial {
 
    public static void main(String[] args) {
        
        try {

            //Declaración del escáner
            Scanner sc = new Scanner(System.in);

            //Creación de la matriz con todos los asientos disponibles
            String [][] asientos = {
                {"1A", "1B", "1C", "1D"} , 
                {"2A", "2B", "2C", "2D"} ,
                {"3A", "3B", "3C", "3D"} ,
                {"4A", "4B", "4C", "4D"} ,
                {"5A", "5B", "5C", "5D"} ,
                {"6A", "6B", "6C", "6D"} ,
                {"7A", "7B", "7C", "7D"} ,
            };

            //Copia de matriz de asientos
            String [][] copiaAsientos = {
                {"1A", "1B", "1C", "1D"} , 
                {"2A", "2B", "2C", "2D"} ,
                {"3A", "3B", "3C", "3D"} ,
                {"4A", "4B", "4C", "4D"} ,
                {"5A", "5B", "5C", "5D"} ,
                {"6A", "6B", "6C", "6D"} ,
                {"7A", "7B", "7C", "7D"} ,
            };

            String asientoComprado, resumenAsientosComprados, consecutivoCancelacion;

            //Variable para manejar los consecutivos
            int consecutivo = 10;

            byte menu = 0, cantidadAsientos = 0, asientosDisponibles = 28, contador = 0;

            //Variable para manejar la recolección de datos
            boolean input;

            //Mensaje de bienvenida
            System.out.println("Bienvenido al sistema de gestión de asientos de la aerolinea\n");

            //Ciclo con el menú para que el usuario pueda hacer todas las operaciones todas las veces que desee mientras sea posible
            while (menu != 4) {

                input = false;

                //Ciclo para controlar la recolección de datos y atrapar al usuario hasta que ingrese una opción válida
                while (!input) {

                    //Control de errores durante la recolección de datos
                    try {

                        //Mensaje para la recolección de datos
                        System.out.println("Selecciona una opción\nDigita 1 para comprar boletos\nDigita 2 para cancelar reservas\nDigita 3 para visualizar el estado actual de los asientos del avión\nDigita 4 para salir finalizar la ejecución del programa\n");
                        menu = sc.nextByte();

                        //Estructura condicional para validar si la opción del usuario es válida
                        if (menu >= 1 && menu <= 4) {

                            input = true;

                        } else {

                            System.out.println("Error: Solo puedes ingresar números entre el 1 y el 4 para indicar tu elección en el menú\n");

                        }
                        
                    } catch (InputMismatchException e) {

                        System.out.println("Error: Solo puedes ingresar números enteros entre el 1 y el 4 para indicar tu elección en el menú\n");
                        sc.next();

                    } catch (Exception e) {

                        System.out.println("Error: Solo puedes ingresar números enteros entre el 1 y el 4 para indicar tu elección en el menú\n");
                        sc.next();

                    }

                }

                //Condicional switch para desarrollar la lógica de cada una de las opciones
                switch (menu) {
                    case 1:

                        System.out.println("Bienvenido al sistema de gestión de compra de boletos del avion\nActualmente se muestran los asientos disponibles\nLos asientos que se visualizen con dos números sin la letra que especifíca el asiento es porque no están disponibles\n");

                        for (byte i = 0; i < asientos.length; i++) {

                            for (byte j = 0; j < asientos[i].length; j++) {

                                System.out.print(asientos[i][j] + "\t");

                            }

                            System.out.println();

                        }

                        System.out.println("");

                        input = false;

                        //Ciclo para controlar la recolección de datos y atrapar al usuario hasta que ingrese una opción válida
                        while (!input) {

                            //Control de errores durante la recolección de datos
                            try {

                                //Mensaje para la recolección de datos
                                System.out.println("Cuantos asientos deseas comprar (minimo 1, máximo 4)\n");
                                cantidadAsientos = sc.nextByte();

                                //Estructura condicional para validar si la opción del usuario es válida
                                if (cantidadAsientos > asientosDisponibles) {

                                    System.out.println("Error: no hay suficientes hacientos disponibles para vender\n");

                                } else if (cantidadAsientos >= 1 && cantidadAsientos <= 4) {

                                    input = true;

                                } else {

                                    System.out.println("Error: solo puedes ingresar números enteros entre el 1 y el 4 para indicar tu elección en el menú\n");

                                }
                                
                            } catch (InputMismatchException e) {

                                System.out.println("Error: Solo puedes ingresar números enteros entre el 1 y el 4 para indicar tu elección en el menú\n");
                                sc.next();

                            } catch (Exception e) {

                                System.out.println("Error: Solo puedes ingresar números enteros entre el 1 y el 4 para indicar tu elección en el menú\n");
                                sc.next();

                            }

                        }

                        resumenAsientosComprados = "";

                        for (byte i = 1; i <= cantidadAsientos; i++) {

                            input = false;

                            while (!input) {

                                asientoComprado = "";
                                System.out.println("Ingrese que asiento desea para el número " + i + " (por ejemplo 3B)");
                                sc.nextLine();
                                asientoComprado = sc.nextLine().toUpperCase();

                                if (asientoComprado.length() == 2) {

                                    for (byte k = 0; k < asientos.length; k++) {

                                        for (byte j = 0; j < asientos[k].length; j++) {

                                            if (asientos[k][j].equals(asientoComprado)) {

                                                input = true;

                                                resumenAsientosComprados += asientos[k][j] + ", ";

                                                System.out.println("Asiento " + asientos[k][j] + " comprado exitosamente con consecutivo " + consecutivo);

                                                asientos[k][j] = String.valueOf(consecutivo);

                                                asientosDisponibles--;

                                                break;

                                            }

                                        }

                                        if (input) break;

                                    }

                                    if (!input) {

                                        System.out.println("Error: el asiento ingresado no existe o ya está ocupado, intentalo de nuevo");

                                    }

                                } else {

                                    System.out.println("Error: Entrada inválida, intenta de nuevo");

                                }

                            }

                        }

                        System.out.println("Compra exitosa, los asientos comprados fueron: " + resumenAsientosComprados + " con consecutivo de factura: " + consecutivo);

                        consecutivo++;

                        contador++;
                        
                        break;

                    case 3:

                        System.out.println("El estado actual de los asientos en el avión es el siguiente: ");

                        for (byte i = 0; i < asientos.length; i++) {

                            for (byte j = 0; j < asientos[i].length; j++) {

                                System.out.print(asientos[i][j] + "\t");

                            }

                            System.out.println();

                        }

                        break;

                    case 2:

                        if (contador >= 1) {

                            System.out.println("El estado actual de los asientos en el avión es el siguiente: ");

                            for (byte i = 0; i < asientos.length; i++) {

                                for (byte j = 0; j < asientos[i].length; j++) {

                                    System.out.print(asientos[i][j] + "\t");

                                }

                                System.out.println();

                            }

                            input = false;

                            while (!input) {

                                consecutivoCancelacion = "";

                                System.out.println("Ingresa el número de consecutivo de la reserva que deseas cancelar");
                                sc.nextLine();
                                consecutivoCancelacion = sc.nextLine();
                                
                                if (consecutivoCancelacion.length() == 2 && Character.isDigit(consecutivoCancelacion.charAt(0)) && Character.isDigit(consecutivoCancelacion.charAt(1))) {

                                        for (byte i = 0; i < asientos.length; i++) {

                                            for (byte j = 0; j < asientos[i].length; j++) {

                                                if (asientos[i][j].equals(consecutivoCancelacion)) {

                                                    asientosDisponibles++;

                                                    asientos[i][j] = copiaAsientos[i][j];

                                                    input = true;

                                                }

                                            }

                                        }

                                        if (input) {

                                            System.out.println("Reserva con consecutivo " + consecutivoCancelacion + " cancelada exitosamente.");

                                        } else {

                                            System.out.println("No se encontró ninguna reserva con el consecutivo ingresado.");
                                            
                                        }

                                } else {

                                    System.out.println("Error: consecutivo de compra inválido");

                                }

                            }

                        } else {

                            System.out.println("Error: No puedes hacer ninguna cancelación porque no se ha hecho ninguna compra");

                        }

                        break;

                    case 4:

                        break;
                }

            }
            
        } catch (Exception e) {
        }

    }

}