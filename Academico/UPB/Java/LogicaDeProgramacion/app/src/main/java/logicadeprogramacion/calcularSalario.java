/*

     * Diseñe un algoritmo e implemente la función Calcular_salario que
     * reciba cuatro enteros: cantidad de horas normales laboradas, cantidad
     * de horas extras diurnas laboradas, cantidad de horas extras nocturnas
     * laboradas, y el valor de la hora normal como un float. La función debe
     * retornar un float con el salario total. Las horas extras diurnas tienen
     * un recargo adicional del 15% sobre la hora normal, y las horas extras
     * nocturnas tienen un recargo adicional del 35% sobre la hora normal.
     * 
     * Valide que el valor de la hora normal sea mayor a 0. Si no es así, retorne
     * -1.
     * 
     * Si hay algún error, retorne -1.


*/

package logicadeprogramacion;

import java.util.Scanner;

public class calcularSalario {

    public static double excepciones(Scanner usuario) {

        double dato = 0;
        boolean input = false;

        while(!input) {

            try {

                dato = usuario.nextDouble();

                input = true;

            } catch(Exception e) {

                System.out.println("Error: solo puedes ingresar numeros enteros");

            }

        }

        return dato;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        double horasNormales = 0, horasExtrasDiurnas = 0, horasExtrasNocturnas = 0, precioHora = 0, salarioTotal = 0;
        
        try {

            System.out.println("Ingresa las horas laborales normales");
            horasNormales = excepciones(usuario);
            
            while(horasNormales < 0) {

                System.out.println("Error: las horas laborales normales no pueden ser menores a cero\nIntentalo de nuevo");
                horasNormales = excepciones(usuario);

            }

            System.out.println("Ingresa las horas laborales extras diurnas");
            horasExtrasDiurnas = excepciones(usuario);

            while(horasExtrasDiurnas < 0) {

                System.out.println("Error: las horas laborales extras diurnas no pueden ser menores a ceros\nIntentalo de nuevo");
                horasExtrasDiurnas = excepciones(usuario);

            }

            System.out.println("Ingresa las horas laborales extras nocturnas");
            horasExtrasNocturnas = excepciones(usuario);

            while(horasExtrasNocturnas < 0) {

                System.out.println("Error: las horas laborales extras nocturnas no pueden ser menores a cero\nIntentalo de nuevo");
                horasExtrasNocturnas = excepciones(usuario);

            }

            System.out.println("Ingresa el valor pagado por cada horas");
            precioHora = excepciones(usuario);

            while(precioHora < 1) {

                System.out.println("Error: el precio pagado por cada hora no puede ser menor a 1\nIntentalo de nuevo");
                precioHora = excepciones(usuario);

            }

            salarioTotal = (horasNormales * precioHora) + (((precioHora * 0.15) + precioHora) * horasExtrasDiurnas) + (((precioHora * 0.35) + precioHora) * horasExtrasNocturnas);

        } finally {

            System.out.println("El salario total a pagar es $" + salarioTotal);

            usuario.close();

        }

    }
    
}