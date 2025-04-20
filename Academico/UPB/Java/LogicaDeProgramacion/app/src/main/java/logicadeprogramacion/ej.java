package logicadeprogramacion;

import java.util.Scanner;

public class ej {

    public static int convertirDistanciaKilometros (int metros){

        try {

            int kilometros = 0;

            kilometros = metros / 1000;

            return kilometros;

        } catch (Exception e) {
            return -1;
        }

    }

    public static double combustiblePorVehiculo(int kilometros){

        try {

            
            double litrosGasolina = 0;

            litrosGasolina = ((kilometros * 55) / 750 );

            return litrosGasolina;

        } catch (Exception e) {
            return -1;
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int cantidadVehiculos = 0;
        int metrosRecorridos = 0;
        double consumoGasolina = 0;
        double consumoTotalGasolina = 0;
        int kilometros = 0;

        try{
        System.out.println("¿Ingrese la cantidad de vehiculos: ");
        cantidadVehiculos = sc.nextInt();
        } catch(Exception e) {

            System.out.println("Error: solo puedes ingresar numeros");

        }

        for (int i = 1; i <= cantidadVehiculos; i++){

            try{
            System.out.println("Ingrese los metros recorridos por el vehiculo: " + i);
            metrosRecorridos = sc.nextInt();
            } catch(Exception e) {

                System.out.println("Error: solo puedes ingresar numeros");

            }

            kilometros = convertirDistanciaKilometros(metrosRecorridos);

            consumoGasolina = combustiblePorVehiculo(kilometros);

            System.out.println("Vehiculo " + convertirDistanciaKilometros(metrosRecorridos) + "km ->" + consumoGasolina);
            
            consumoTotalGasolina += consumoGasolina;

        }

        System.out.println("El total de gasolina consumida por los " + cantidadVehiculos + " vehiculos es: " + consumoTotalGasolina + " litros");

        sc.close();

    }
    
}
