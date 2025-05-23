package gosones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class funciones4 {

    public static int ContarPalabrasPositivas(String rutaArchivo, String [] palabrasPositivas) {

        String linea = "", palabraEnCuestion;
        String [] lineaSeparada;
        int contadorPalabrasPositivas = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {

            while ((linea = reader.readLine()) != null) {

                lineaSeparada = linea.split(" ");

                for (int i = 0; i < lineaSeparada.length; i++) {

                    palabraEnCuestion = lineaSeparada[i].toUpperCase();

                    for (int j = 0; j < palabrasPositivas.length; j++) {

                        if (palabraEnCuestion.matches(palabrasPositivas[j])) {

                            contadorPalabrasPositivas++;
                            break;

                        }

                    }

                }

            }

            reader.close();

            return contadorPalabrasPositivas;
            
        } catch (IOException e) {

            return -1;

        } 

    }
 
    public static void main(String[] args) {
        
        String rutaArchivo = "C:\\Users\\pjgom\\OneDrive\\Desktop\\Programacion\\Codigos\\Empirico\\Java\\Archivos\\Ejercicio 5\\resenas.txt";
        String [] palabrasPositivas = {"BUENO", "EXCELENTE", "BUENA", "RECOMENDADO", "RECOMENDADA"};
        int contadorPalabrasPositivas = ContarPalabrasPositivas(rutaArchivo, palabrasPositivas);

        System.out.println("Se contaron " + contadorPalabrasPositivas + " palabras positivas");

    }

}