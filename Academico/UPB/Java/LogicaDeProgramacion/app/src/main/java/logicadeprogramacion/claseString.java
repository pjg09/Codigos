package logicadeprogramacion;

import java.util.Scanner;

public class claseString {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        String informacionGeneral = "", ciudad = "";
        String [] datos = new String [6];
        double salarioBasico = 0, horasTrabajadas = 0, horasExtras = 0, totalPagar = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingrese la siguiente informacion separando cada dato por punto y comas\nDebería verse de la siguiente manera: nombre;cedula;salario basico por hora;horas trabajadas;horas extras;ciudad\nPara la ciudad solo puedes ingresar BOG para Bogota o MED para Medellin");
                    informacionGeneral = usuario.nextLine();

                    datos = informacionGeneral.split(";");

                    if(datos.length != 6) {

                        throw new IllegalArgumentException("Error: Ingresaste mal los datos");

                    }

                    if(datos[0].matches(".*[^a-zA-Z0-9].*") || datos[0].matches(".*[0-9].*")) {

                        throw new IllegalArgumentException("Error: el nombre no puede contener numeros ni caracteres especiales");

                    }

                    if(datos[1].matches(".*[^a-zA-Z0-9].*") || datos[1].matches(".*[a-zA-Z].*")) {

                        throw new IllegalArgumentException("Error: la cedula no puede contener letras ni caracteres especiales");

                    }

                    if(datos[2].matches(".*[a-zA-Z].*") || datos[3].matches(".*[a-zA-Z].*") || datos[4].matches(".*[a-zA-Z].*")) {

                        throw new IllegalArgumentException("Error: El salario basico, las horas trabajadas y las horas extras no pueden contener letras");

                    }

                    salarioBasico = Double.parseDouble(datos[2]);
                    horasTrabajadas = Double.parseDouble(datos[3]);
                    horasExtras = Double.parseDouble(datos[4]);

                    if(salarioBasico < 0 || horasTrabajadas < 0 || horasExtras < 0) {

                        throw new IllegalArgumentException("Error: el salario basico, las horas trabajadas y las horas extras no pueden ser menor a cero");

                    }

                    ciudad = datos[5].toUpperCase();

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                }

            }

            totalPagar = (horasTrabajadas * salarioBasico) + (((salarioBasico * 0.15) + salarioBasico) * horasExtras);

        } finally {

            System.out.println("El trabajador " + datos[0] + " con cedula " + datos[1] + " de la ciudad " + ciudad + " se le debe pagar " + totalPagar);

            usuario.close();

        }

    }

}