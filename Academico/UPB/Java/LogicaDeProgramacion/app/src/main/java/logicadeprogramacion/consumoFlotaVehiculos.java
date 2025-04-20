/*

    Cálculo del Consumo de Combustible para una Flota de Vehículos
    Objetivo:
    Desarrollar un programa en Java que permita a una empresa de transporte de la Guajira calcular cuántos litros de combustible consume
    cada vehículo por tour segúnlos kilómetros recorridos. El programa debe aceptar la entrada de distancia en metros,
    convertirla a kilómetros, y luego calcular el consumo de combustible para cada vehículo.
    Al final, el programa debe mostrar el consumo total de combustible de todos los vehículos.
    Requisitos del Programa:
    1.	Entrada de Datos:

    •	El programa debe preguntar al usuario cuántos vehículos participaron. 
    •	Para cada vehículo, el programa debe preguntar cuántos metros recorrió.
    •	El programa debe convertir la distancia de metros a kilómetros antes de calcular el consumo de combustible.

    2.	Cálculos:

    •	Conversión de Metros a Kilómetros:
    o	Convertir la distancia ingresada en metros a kilómetros.
    o	Fórmula: 
    
    •	Cálculo de Combustible por Vehículo
    o	Para cada vehículo, calcular cuántos litros de gasolina ha consumido en función de los kilómetros recorridos.
    
    •	Cálculo del Consumo Total General:
    o	Sumar el consumo total de combustible de todos los vehículos para obtener el total de litros gastados por la empresa durante el tour analizado.
    3. Salida de Datos:
    •	El programa debe mostrar:
    o	Los kilómetros recorridos por cada vehículo (resultado de la conversión).
    o	Los litros de gasolina consumidos por cada vehículo
    o	Los litros de gasolina consumidos por todos los vehículos.
    4. Consideraciones:
    •	Implementar validaciones para asegurarse de que los metros recorridos sean un número positivo.
    •	Utilizar un ciclo for para iterar sobre los vehículos y realizar los cálculos.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class consumoFlotaVehiculos {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        int cantidadVehiculos = 0;
        double consumoTotal = 0;
        double [] distanciaRecorrida;
        double [] consumoVehiculo;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("¿Cuantos vehiculos participaron en el tour?");
                    cantidadVehiculos = usuario.nextInt();
    
                    if(cantidadVehiculos < 1) {
    
                        throw new IllegalArgumentException("Error: tuvo que haber participado minimo 1 vehiculo.");
    
                    }
    
                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros para indicar la cantidad de vehiculos que participaron en el tour.");
                    usuario.next();

                }

            }

            distanciaRecorrida = new double[cantidadVehiculos];
            consumoVehiculo = new double[cantidadVehiculos];

            for(int i = 0; i <= distanciaRecorrida.length - 1; i++) {

                while(input) {

                    try {

                        System.out.println("Ingresa la distancia recorrida en metros para el vehiculo numero " + (i + 1));
                        distanciaRecorrida [i] = usuario.nextDouble();

                        if(distanciaRecorrida [i] < 0) {

                            throw new IllegalArgumentException("Error: debes ingresar un numero mayor a cero para indicar la distancia recorrida por el vehiculo");

                        }

                        input = false;

                    } catch(IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    } catch(Exception e) {

                        System.out.println("Error: solo puedes ingresar numeros para indicar la distancia recorrida");
                        usuario.next();

                    }

                }

                input = true;

                distanciaRecorrida [i] /= 1000;

                consumoVehiculo [i] = distanciaRecorrida [i] * 0.4;

                }

            for(int j = 0; j <= distanciaRecorrida.length - 1; j++) {

                for(int k = 0; k <= distanciaRecorrida.length - 1; k++) {

                    consumoTotal += consumoVehiculo [k];

                }

                System.out.println("El consumo para el vehiculo numero " + (j + 1) + " es de " + consumoVehiculo [j] + " litros");

            }

        } finally {

            System.out.println("El consumo total de los " + cantidadVehiculos + " fue de " + consumoTotal + " litros");

            usuario.close();

        }

    }
    
}