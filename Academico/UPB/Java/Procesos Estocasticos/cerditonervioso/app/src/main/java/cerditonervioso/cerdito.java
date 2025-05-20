package cerditonervioso;

import java.util.Scanner;

public class cerdito {
 
    public static void main(String[] args) {
        
        Scanner escaner = new Scanner(System.in);
        boolean input = false;
        byte posicionInicialFantasma = 0, posicionInicialCerdito = 2, meta = 22, estadoA = 13;
        short numeroSimulaciones = 0;

        try {

            while(!input) {

                try {

                    System.out.println("Ingrese la cantidad de veces que quiere simular el juego (debe ser un número entero entre 1 y 1.000)");
                    numeroSimulaciones = escaner.nextShort();

                    if (numeroSimulaciones >= 1 && numeroSimulaciones <= 1000) {

                        input = true;

                    } else {

                        throw new IllegalArgumentException("Error: la cantidad de simulaciones debe estar entre 1 y 1.000");

                    }

                } catch (IllegalArgumentException recoleccionDatos) {

                    System.out.println(recoleccionDatos.getMessage());
                    escaner.next();

                } catch (Exception e) {

                    System.out.println("Error: la cantidad de simulaciones debe estar entre 1 y 1.000");
                    escaner.next();

                }

            }

            for (short i = 1; i <= numeroSimulaciones; i++) {

                

            }

        } catch (Exception e) {



        } finally {



        }

    }

}