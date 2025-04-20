package logicadeprogramacion;

import java.io.*;
import java.text.*;

public class manejoArchivosyVectores {

    public static void main(String[] args) {
        
        //C:\\Users\\pjgom\\OneDrive\\Desktop\\ventas.csv

        try {

            DecimalFormat fix = new DecimalFormat("$#,###.00");

            File archivoLectura = new File("C:\\Users\\pjgom\\OneDrive\\Desktop\\ventas.csv");
            FileReader ventas = new FileReader(archivoLectura);
            BufferedReader datos = new BufferedReader(ventas);

            long totalVentasAnuales = 0, totalVentasMensuales = 0;
            short mesActivo = 0, anoActivo = 0;
            String linea = datos.readLine(); //Crea y ubica el puntero en el archivo para saber si está lleno o vacio (el archivo) y para que podamos trabajar en el archivo
            String [] vectorVentas;

            if(linea != null) {

                linea = datos.readLine(); //Salto de linea para bajar de los titulos del excel
                vectorVentas = linea.split(";");

                anoActivo = Short.parseShort(vectorVentas[1]);
                mesActivo = Short.parseShort(vectorVentas[2]);

                while(linea != null) {

                    if(anoActivo == Short.parseShort(vectorVentas[1])) {

                        if(mesActivo == Short.parseShort(vectorVentas[2])) {

                            totalVentasMensuales += Long.parseLong(vectorVentas[4]);

                        } else {

                            System.out.println("En el año " + anoActivo + " las ventas del mes " + mesActivo + " fueron: " + fix.format(totalVentasMensuales));

                            totalVentasAnuales += totalVentasMensuales;
                            totalVentasMensuales = Long.parseLong(vectorVentas[4]);
                            mesActivo = Short.parseShort(vectorVentas[2]);

                        }

                    } else {

                        System.out.println("En el año " + anoActivo + " las ventas del mes " + mesActivo + " fueron: " + fix.format(totalVentasMensuales));

                        totalVentasAnuales += totalVentasMensuales;
                        totalVentasMensuales = Long.parseLong(vectorVentas[4]);
                        mesActivo = Short.parseShort(vectorVentas[2]);

                        System.out.println("Las ventas del año " + anoActivo + " fueron: " + fix.format(totalVentasAnuales));

                        totalVentasAnuales = 0;
                        anoActivo = Short.parseShort(vectorVentas[1]);

                    }

                    linea = datos.readLine();

                    if(linea != null) {

                        vectorVentas = linea.split(";");

                    } else {

                        System.out.println("En el año " + anoActivo + " las ventas del mes " + mesActivo + " fueron: " + fix.format(totalVentasMensuales));
                        
                        totalVentasAnuales += totalVentasMensuales;

                        System.out.println("Las ventas del año " + anoActivo + " fueron: " + fix.format(totalVentasAnuales));

                    }

                }

            } else {

                System.out.println("El archivo esta vacio");

                datos.close();

            }

        } catch(Exception e) {

            System.out.println("Pene");

        }

    }
    
}