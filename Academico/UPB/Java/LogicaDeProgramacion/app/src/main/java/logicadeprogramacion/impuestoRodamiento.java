/*

    Desarrollar un programa en Java que ayude a la oficina de impuestos a calcular los impuestos de rodamiento y seguro que deben pagar los múltiples contribuyentes
    con vehículos. El programa debe permitir al usuario calcular estos impuestos para varios vehículos por usuario, ingresando los datos correspondientes para cada
    uno de ellos.
    Requisitos del Programa:
    1.	Entrada de Datos:

    •	El programa debe preguntarle al usuario si desea registrar un cliente
    •	El programa debe preguntar al usuario por la cantidad de vehículos que tiene el cliente que va a registrar
    •	Para cada vehículo del cliente, el programa debe solicitar:
    o	La década del modelo del vehículo.
    o	El avalúo del vehículo (en unidades monetarias).
    2. Cálculos:
    •	Impuesto de Rodamiento:
    o	Se calcula aplicando la tasa de rodamiento correspondiente a la década del modelo sobre el avalúo del vehículo.
    o	Fórmula: 
    
    •	Seguro:
    o	Se calcula aplicando la tasa de seguro correspondiente a la década del modelo sobre el avalúo del vehículo.
    o	Fórmula: 
    
    •	Total a Pagar:
    o	Es la suma del Impuesto de Rodamiento y el Seguro.
    o	Fórmula: 
    
    3. Salida de Datos:
    •	Por cliente y vehículo, el programa debe mostrar:
    o	El valor del avalúo.
    o	La década del vehículo
    o	El valor total para pagar.
    4. Consideraciones:
    •	Implementar validaciones para asegurarse de que la década del modelo sea válida y que el avalúo sea un número positivo.
    •	El usuario no sabrá cuantos clientes va a registrar, esta acción se realiza bajo demanda
    •	Utilizar un ciclo for para iterar sobre los vehículos del cliente y calcular los impuestos correspondientes.
    •	Ejemplo de ejecución: El usuario digita que desea registrar un cliente, al cliente se le pregunta que cantidad de vehículos tiene y por vehículo se hacen las
    preguntas necesarias para mostrar la cantidad a pagar por impuesto. Cuando culmine con todos los vehículos del cliente, el programa debe de volver a preguntarle al
    usuario si desea registrar un nuevo cliente y repetir el proceso

*/

package logicadeprogramacion;

import java.util.Scanner;
import java.text.DecimalFormat;

public class impuestoRodamiento {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        DecimalFormat fix = new DecimalFormat("#,###.00");
        byte [] decadas = new byte[0];
        int cantidadVehiculos = 0;
        double tasaSeguro = 0, tasaRodamiento = 0, totalPagar = 0, impuestoRodamiento = 0, seguro = 0;
        double [] avaluoComercial = new double[0];
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingrese la cantidad de vehiculos a los cuales desea calcular el impuesto de rodamiento");
                    cantidadVehiculos = usuario.nextInt();

                    if(cantidadVehiculos < 1) {

                        throw new IllegalArgumentException("Error: solo puedes calcular el impuesto a 1 o mas vehiculos");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros para indicar la cantidad de vehiculos que deseas calcular el impuesto");
                    usuario.next();

                }

            }

            decadas = new byte[cantidadVehiculos];
            avaluoComercial = new double[cantidadVehiculos];

            for(int i = 0; i <= cantidadVehiculos - 1; i++) {

                System.out.println("Vehiculo " + (i + 1));

                while(input) {

                    try {

                        System.out.println("Ingrese la decada del modelo del vehiculo (90, 00, 10, 20): ");
                        decadas [i] = usuario.nextByte();

                        if(decadas [i] != 90 && decadas [i] != 00 && decadas [i] != 10 && decadas [i] != 20) {

                            throw new IllegalArgumentException("Error: La decada del vehiculo debe ser 70, 80, 90, 00, 10, 20");

                        }

                        input = false;

                    } catch(IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    } catch(Exception e) {

                        System.out.println("Error: solo puedes ingresar numeros enteros para indicar la decada de tu vehiculo");
                        usuario.next();

                    }

                }

                while(!input) {

                    try {

                        System.out.println("Ingresa el avaluo comercial del vehiculo: ");
                        avaluoComercial [i] = usuario.nextDouble();

                        if(avaluoComercial [i] < 1) {

                            throw new IllegalArgumentException("Error: el avaluo comercial no puede ser menor a cero");

                        }

                        input = true;

                    } catch(IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    } catch(Exception e) {

                        System.out.println("Error: solo puedes ingresar numeros para determinar el avaluo comercial");
                        usuario.next();

                    }

                }

                System.out.println("Decada del modelo: " + decadas [i]);
                System.out.println("Avaluo comercial: $" + fix.format(avaluoComercial [i]));

                switch(decadas[i]) {
                
                    case 90:
                        tasaRodamiento = 0.0409;
                        tasaSeguro = 0.00816;
                        break;

                    case 00:
                        tasaRodamiento = 0.0434;
                        tasaSeguro = 0.00789;
                        break;

                    case 10:
                        tasaRodamiento = 0.0493;
                        tasaSeguro = 0.00712;
                        break;

                    case 20:
                        tasaRodamiento = 0.0568;
                        tasaSeguro = 0.00699;
                        break;
                        
                }

                seguro = tasaSeguro * avaluoComercial [i];
                impuestoRodamiento = tasaRodamiento * avaluoComercial [i];
                totalPagar = seguro + impuestoRodamiento;

                System.out.println("Total a pagar: $" + fix.format(totalPagar));

            }

        } finally {

            System.out.println("Gracias por usar nuestro servicio");

            usuario.close();

        }

    }
    
}
