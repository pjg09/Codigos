package logicadeprogramacion;

import java.io.*;

public class ejerciciomanejoarchivos2 {

    public static void main(String[] args) {
        
        try {

            float acumuladorTemperaturas = 0, promedioTemperaturas = 0;
            int contador = 0;

            File archivoLectura = new File("C:\\Users\\pjgom\\OneDrive\\Desktop\\prueba.txt");
            FileReader mediciones = new FileReader(archivoLectura);
            BufferedReader datos = new BufferedReader(mediciones);

            FileWriter archivoEscritura = new FileWriter("C:\\Users\\pjgom\\OneDrive\\Desktop\\ResultadoPruebas.txt", false);
            PrintWriter lineaEscritura = new PrintWriter(archivoEscritura);

            String linea = "";

            while((linea = datos.readLine()) != null) {

                String[] lineaSplit = linea.split(";");

                for(int i = 0; i < lineaSplit.length; i++) { //El lineaSplit.length cuenta cuantos factores de split (en este caso punto y coma) hay

                    acumuladorTemperaturas += Float.parseFloat(lineaSplit[i]);

                }

                contador = lineaSplit.length;

            }

            promedioTemperaturas = acumuladorTemperaturas / contador;

            lineaEscritura.println("El promedio de las temperaturas es: " + promedioTemperaturas);

            datos.close();
            lineaEscritura.close();

        } catch(IOException io) {

            System.out.println("Error en el archivo" + io.getMessage());

        }  catch(Exception e) {

            System.out.println("Error en el archivo" + e.getMessage());

        }

    }
    
}