package logicadeprogramacion;

import java.util.Scanner;

public class CalculadorImpuestos {

    public static double calcularTasaRodamiento(byte decada) {

        double tasaRodamiento = 0;

        switch(decada) {

            case 90:
                tasaRodamiento = 0.0409;
                break;

            case 00:
                tasaRodamiento = 0.0434;
                break;

            case 10:
                tasaRodamiento = 0.0493;
                break;

            case 20:
                tasaRodamiento = 0.05680;
                break;

        }

        return tasaRodamiento;

    }

    public static double calcularTasaSeguro(byte decada) {

        double tasaSeguro = 0;

        switch(decada) {

            case 90:
                tasaSeguro = 0.00816;
                break;

            case 00:
                tasaSeguro = 0.00798;
                break;

            case 10:
                tasaSeguro = 0.00712;
                break;

            case 20:
                tasaSeguro = 0.00699;
                break;

        }

        return tasaSeguro;

    }

    public static double calcularRodamiento(double tasaRodamiento, double avaluoComercial) {

        double rodamiento = avaluoComercial * tasaRodamiento;

        return rodamiento;

    }

    public static double calcularSeguro(double tasaSeguro, double avaluoComercial) {

        double seguro = avaluoComercial * tasaSeguro;

        return seguro;

    }
    
    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        int cantidadVehiculos = 0, contador = 0;
        byte decadaVehiculo = 0;
        double avaluoComercial = 0, tasaRodamiento = 0, tasaSeguro = 0, rodamiento = 0, seguro = 0, totalLocal = 0, total = 0;
        boolean input = false;

        try {

                while(!input) {

                    try {

                        System.out.println("A cuantos vehiculos deseas calcular impuestos de rodamiento y seguro: ");
                        cantidadVehiculos = usuario.nextInt();

                        if(cantidadVehiculos <= 0) {

                            throw new IllegalArgumentException("Error: no puedes calcular los gastos menos de cero vehiculos");

                        } 

                        input = true;

                    } catch(IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    } catch(Exception e) {

                        System.out.println("Error: solo puedes ingresar numeros para determinar el numero de vehiculos");
                        usuario.next();

                    }

                }

            for(int i = 1; i <= cantidadVehiculos; i++) {

                while(input) {

                    try {
    
                        System.out.println("Cual es la decada del modelo del vehiculo " + i + " (90, 00, 10 o 20)");
                        decadaVehiculo = usuario.nextByte();
    
                        if(decadaVehiculo != 90 && decadaVehiculo != 00 && decadaVehiculo != 10 && decadaVehiculo != 20) {
    
                            throw new IllegalArgumentException("Error: decada de modelo del vehiculo invalida");
    
                        }
    
                        input = false;
    
                    } catch(IllegalArgumentException e) {
    
                        System.out.println(e.getMessage());
    
                    } catch(Exception e) {
    
                        System.out.println("Error: por favor ingresa solo numeros enteros para especificar la decada de tu vehiculo");
                        usuario.next();
    
                    } 
    
                }

                while(!input) {

                    try {

                        System.out.println("Ingrese el avaluo comercial del vehiculo " + i);
                        avaluoComercial = usuario.nextDouble();

                        if(avaluoComercial < 0) {

                            throw new IllegalArgumentException("Error: tu vehiculo no puede valer cero");

                        }

                        input = true;

                    } catch(IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    } catch(Exception e) {

                        System.out.println("Error: solo puedes ingresar numeros para el avaluo comercial de tu vehiculo");
                        usuario.next();

                    }

                }

                tasaRodamiento = calcularTasaRodamiento(decadaVehiculo);
                rodamiento = calcularRodamiento(tasaRodamiento, avaluoComercial);

                tasaSeguro = calcularTasaSeguro(decadaVehiculo);
                seguro = calcularSeguro(tasaSeguro, avaluoComercial);

                totalLocal = avaluoComercial + rodamiento + seguro;

                System.out.println("Este vehiculo de la decada de los " + decadaVehiculo + "s avaluado en $" + avaluoComercial + " va a pagar \n $" + rodamiento + " de rodamiento \n $" + seguro + " de seguro \n Para un total de $" + totalLocal);

                total += totalLocal;

                contador++;

            }

        } finally {

            System.out.println("En total vas a pagar $" + total + " por los " + contador + " vehiculos");

            usuario.close();

        }

    }

}