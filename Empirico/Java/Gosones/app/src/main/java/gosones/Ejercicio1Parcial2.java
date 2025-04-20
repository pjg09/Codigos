package gosones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1Parcial2 {

    public static void main(String[] args) {
        
        //Declaración de variables
        String rutaLectura = "C:\\Users\\pjgom\\OneDrive\\Desktop\\Programacion\\Codigos\\Empirico\\Java\\Archivos\\Ejercicio 1\\";
        String archivoLectura = "inventario.txt";
        String linea = "";
        String [][] stock;
        int filas = 0, columnas = 5, filaGuardada = 0, validaciones;

        //Inicio del try general
        try {

            //Verificar cuantos renglones tiene el archivo para armar la matriz
            try (BufferedReader reader = new BufferedReader(new FileReader(rutaLectura + archivoLectura))) {

                while((linea = reader.readLine()) != null) {
    
                    filas++;
    
                }
    
            } catch (IOException e) {
    
                System.out.println("Ha ocurrido un error con el manejo de los archivos");
    
            }
    
            //Si contamos con renglones disponibles vamos a crear la matriz y a desarrollar el proyecto
            if (filas > 0) {
    
                try (BufferedReader reader = new BufferedReader(new FileReader(rutaLectura + archivoLectura))) {

                    //Creación de la matriz
                    stock = new String[filas][columnas];

                    //Llenamos la matriz con los renglones del archivo
                    while ((linea = reader.readLine()) != null && filaGuardada < filas) {

                        stock[filaGuardada] = linea.split(",");
                        filaGuardada++;

                    }

                    //Validación de que el archivo haya sido entregado con el formato adecuado
                    for (int i = 0; i < stock.length; i++) {

                        for (int j = 0; j < stock[i].length; j++) {

                            switch (j) {
                                case 0:
                                    
                                    if (stock[i][j].matches("-?\\d+")) {

                                        if ((Integer.parseInt(stock[i][j])) <= 0) {

                                            throw new Exception("Error: el ID de los productos debe ser un número positivo");

                                        }

                                    } else {

                                        throw new Exception("Error: El archivo no se encuentra en el formato adecuado (El ID del producto debe ser un número)");

                                    }

                                    break;
                                default:

                                    throw new Exception("Error: El archivo no se encuentra en el formato adecuado");
                            }

                        }

                    }

                } catch (IOException e) {

                    System.out.println("Ha ocurrido un error con el manejo de los archivos");

                } catch (Exception e) {

                    System.out.println(e.getMessage());

                }
    
            } else {
    
                throw new Exception("Error: No se puede trabajar el archivo porque se encuentra vacío");
    
            }
            
        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }
    
}