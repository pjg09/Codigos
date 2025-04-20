package logicadeprogramacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class salario {

    public static double salarioNeto(double valor, double horas) {

        try {

            double salarioNeto = valor * horas;

            return salarioNeto;

        } catch (Exception e) {

            return -1;

        }

    }

    public static double retencion(double salarioNeto, double porcentaje) {

        try {

            double valorRetencion = salarioNeto * (porcentaje / 100);

            return valorRetencion;

        } catch(Exception e) {

            return -1;

        }

    }

    public static double salarioCompleto(double salarioNeto, double valorRetencion) {

        try {

            double salarioEntregar = salarioNeto - valorRetencion;

            return salarioEntregar;

        } catch (Exception e) {

            return -1;

        }

    }

    public static void main(String[] args) {
           
        Scanner usuario = new Scanner (System.in);
        String nombre = "";
        double horas = 0, valor = 0, retencion = 0, salarioNeto = 0, totalRetencion = 0, salarioTotal = 0;
        long cedula = 0;
        boolean inputNombre = false;
        boolean inputNumeros = false;

        while(!inputNombre) {

            try {

                System.out.println("Ingrese su nombre y apellido: ");
                nombre = usuario.nextLine();

                if (nombre == null || nombre.trim().isEmpty()) {

                    throw new IllegalArgumentException("El nombre no puede estar vacío.");

                }

                if (nombre.matches(".*\\d.*")) {

                    throw new IllegalArgumentException("El nombre no puede contener números.");

                }

                if (!nombre.matches("[a-zA-Z\\s]+")) {

                    throw new IllegalArgumentException("El nombre no puede contener caracteres especiales.");

                }

                inputNombre = true;

            } catch(IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());
    
            }

        }

        while(!inputNumeros) {

            try {

                System.out.println("Ingrese su numero de cedula: ");
                cedula = usuario.nextLong();

                System.out.println("Ingrese el numero de horas que ha trabajado en el mes: ");
                horas = usuario.nextDouble();

                System.out.println("Ingrese el valor de cada hora trabajada: ");
                valor = usuario.nextDouble();

                System.out.println("Ingrese el procentaje de retencion SIN el signo porcentaje: ");
                retencion = usuario.nextDouble();

                if(cedula <= 0) {

                    throw new IllegalArgumentException("La cedula no puede se un numero negativo");

                }

                if(horas < 0) {

                    throw new IllegalArgumentException("La cantidad de horas trabajadas no puede ser negativas");

                }

                if(valor <= 0) {

                    throw new IllegalArgumentException("El valor de las horas trabajdas no puede ser negativo");

                }

                if(retencion < 0 || retencion > 100) {

                    throw new IllegalArgumentException("El porcentaje de la retencion solo puede estar entre 0 y 100");

                }

                inputNumeros = true;

                salarioNeto = salarioNeto(valor, horas);
                totalRetencion = retencion(salarioNeto, retencion);
                salarioTotal = salarioCompleto(salarioNeto, totalRetencion);
                
                System.out.println(nombre + " su salario neto es " + salarioNeto);
                System.out.println("Lo que se va descontar de su salario segun la retencion es " + totalRetencion);
                System.out.println("Su salario total es " + salarioTotal);


            } catch(InputMismatchException e) {

            System.out.println("Error, debes ingresar un tipo de entrada valida para las preguntas");
            usuario.next();

            } catch(IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            } finally {

                System.out.println("Fin");

            }

        }

        usuario.close();

    }

}