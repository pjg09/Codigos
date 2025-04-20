package logicadeprogramacion;

import java.io.*;

public class lindos {

    public static void main(String[] args) {
        FileWriter escritura = null;
        PrintWriter lineaEscritura = null;
        try {
            // Abrir el archivo en modo append (agregar al final)
            escritura = new FileWriter("C:/Users/pjgom/OneDrive/Desktop/pene.txt", true);
            lineaEscritura = new PrintWriter(escritura);

            int numAlea;
            int entrada;

            for (int i = 0; i < 10; i++) {
                // Generar un número aleatorio y calcular la entrada
                numAlea = (int) (Math.random() * (200 - 2 + 1)) + 2;
                entrada = numAlea * 10000;

                // Escribir el resultado en el archivo
                lineaEscritura.println(realizarRetiro(entrada));

                // Forzar el vaciado del buffer después de cada escritura
                lineaEscritura.flush();
            }
        } catch (IOException e) {
            System.out.println("Error con la lectura de los archivos: " + e.getMessage());
        } finally {
            // Cerrar los recursos en el bloque finally
            if (lineaEscritura != null) {
                lineaEscritura.close();
            }
            if (escritura != null) {
                try {
                    escritura.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }

    public static String realizarRetiro(int cantEst) {
        try {
            if (cantEst >= 20000 && cantEst <= 2000000 && (cantEst % 10000) == 0) {

                int B100000 = 500;
                int B50000 = 600;
                int B20000 = 600;
                int B10000 = 700;

                int cantMensaje = cantEst;

                int D100000 = 0;
                int D50000 = 0;
                int D20000 = 0;
                int D10000 = 0;

                while (cantEst != 0) {

                    if (cantEst >= 100000 && B100000 >= 1) {
                        cantEst -= 100000;
                        B100000--;
                        D100000++;
                    } else if (cantEst >= 50000 && B50000 >= 1) {
                        cantEst -= 50000;
                        B50000--;
                        D50000++;
                    } else if (cantEst >= 20000 && B20000 >= 1) {
                        cantEst -= 20000;
                        B20000--;
                        D20000++;
                    } else if (cantEst >= 10000 && B10000 >= 1) {
                        cantEst -= 10000;
                        B10000--;
                        D10000++;
                    }
                }

                return " --------------------------- \n El dinero retirado fue: " + cantMensaje + " con \n" +
                        D100000 + "Billetes de 100000 \n" +
                        D50000 + " Billetes de 50000 \n" +
                        D20000 + " Billetes de 20000 \n" +
                        D10000 + " Billetes de 10000 \n ---------------------------";

            } else {
                return "Error";
            }
        } catch (Exception e) {
            return "Error";
        }
    }
}
