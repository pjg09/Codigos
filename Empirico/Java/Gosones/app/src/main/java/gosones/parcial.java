package gosones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class parcial {

    public static String [][] cargarDatosRutas(String rutaLectura) {

        String [][] datos = null;
        String [] lineaSeparada;
        String linea = "";
        byte filas = 0, columnas = 5, filaActual = 0;

        try {

            File ubicacionLectura = new File(rutaLectura);
            FileReader archivoLectura = new FileReader(ubicacionLectura);
            BufferedReader reader = new BufferedReader(archivoLectura);

            while ((linea = reader.readLine()) != null) {

                filas++;

            }
            
            reader.close();
            archivoLectura = new FileReader(ubicacionLectura);
            reader = new BufferedReader(archivoLectura);

            datos = new String[filas][columnas];

            while ((linea = reader.readLine()) != null && filaActual < filas) {

                lineaSeparada = linea.split(",");

                for (int j = 0; j < columnas; j++) {

                    datos[filaActual][j] = lineaSeparada[j];

                }

                filaActual++;

            }

            reader.close();
            
        } catch (IOException e) {

            System.out.println("Ha ocurrido un error con el manejo de los archivos");

        } catch (Exception e) {

            System.out.println("Ha ocurrido un error inesperado");

        }

        return datos;

    }

    public static int contarRutasUnicas(String rutaArchivo) {

        String[] rutasEncontradas = new String[100];
        int totalRutas = 0;
        boolean repetida;

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] partes = linea.split(",");
                String codigoRuta = partes[0];

                repetida = false;

                for (int i = 0; i < totalRutas; i++) {

                    if (rutasEncontradas[i].equals(codigoRuta)) {

                        repetida = true;
                        break;

                    }

                }

                if (!repetida) {

                    rutasEncontradas[totalRutas] = codigoRuta;
                    totalRutas++;

                }

            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Ha ocurrido un error con el manejo de los archivos");

        }

        return totalRutas;
    }

    public static double calcularTiempoRuta(int numeroRuta, String rutaLectura) {

        String [] lineaSeparada;
        String linea = "";

        double tiempoTotalRuta = 0;

        char ruta = (char) (numeroRuta + '0');

        try {

            File ubicacionLectura = new File(rutaLectura);
            FileReader archivoLectura = new FileReader(ubicacionLectura);
            BufferedReader reader = new BufferedReader(archivoLectura);

            while ((linea = reader.readLine()) != null) {

                lineaSeparada = linea.split(",");

                if (Double.parseDouble(lineaSeparada[3]) >= 1 && Double.parseDouble(lineaSeparada[3]) <= 20) {

                    if (ruta == (lineaSeparada[0].charAt(3))) {

                        tiempoTotalRuta += Double.parseDouble(lineaSeparada[3]);
                    
                    }

                } else {

                    return -1;

                }

            }

            reader.close();

            return tiempoTotalRuta;

        } catch (IOException e) {

            return -1;

        } catch (Exception e) {

            return -1;

        }

    }

    public static String encontrarRutaMasEficiente(double [] tiempoTotalRuta) {

        String respuesta = "";

        double mejorRuta = 0;

        int rutaMasEficiente = 0;

        for (int i = 0; i < tiempoTotalRuta.length; i++) {

            if (i == 0) {

                mejorRuta = tiempoTotalRuta[i];
                rutaMasEficiente = i + 1;

            } else {

                if (mejorRuta < tiempoTotalRuta[i]) {

                    mejorRuta = tiempoTotalRuta[i];
                    rutaMasEficiente = i + 1;

                }

            }

        }

        respuesta = "La ruta más eficiente es la número " + rutaMasEficiente + " con un viaje de " + mejorRuta + " minutos de duración";

        return respuesta;

    }

    public static void generarReporteTransporte(String rutaEscritura) {

        try {

            FileWriter archivoEscritura = new FileWriter(rutaEscritura);
            PrintWriter lapiz = new PrintWriter(archivoEscritura);
            
        } catch (IOException e) {

            System.out.println("Ha ocurrido un error con el manejo de los archivos");

        } catch (Exception e) {

            System.out.println("Ha ocurrido un error inesperado");

        }

    }

    public static void main(String[] args) {
        
        //Rutas para el manejo de archivos
        String rutaLectura = "C:\\Users\\pjgom\\OneDrive\\Desktop\\Programacion\\Codigos\\Empirico\\Java\\Archivos\\Ejercicio 7\\rutas_transporte.txt";
        String rutaEscritura = "C:\\Users\\pjgom\\OneDrive\\Desktop\\Programacion\\Codigos\\Empirico\\Java\\Archivos\\Ejercicio 7\\reporte_transporte_YYYY_MM_DD.txt";
        String rutaMasEficiente;

        String [][] datos = cargarDatosRutas(rutaLectura);
            
        int totalRutas = contarRutasUnicas(rutaLectura);

        double [] tiempoTotalRuta = new double[totalRutas];

        try {

            for (int i = 0; i < tiempoTotalRuta.length; i++) {

                tiempoTotalRuta[i] = calcularTiempoRuta((i + 1), rutaLectura);

            }

            rutaMasEficiente = encontrarRutaMasEficiente(tiempoTotalRuta);

        } catch (Exception e) {

            System.out.println("Ha ocurrido un error inesperado");

        }

    }

}