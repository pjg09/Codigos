package erome;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PracticaParcial1 {
 
    public static void main(String[] args) {
        
        try {

            Scanner sc = new Scanner(System.in);
            String rutaArchivo = "C:\\Users\\pjgom\\OneDrive\\Desktop\\Programacion\\Codigos\\Empirico\\Java\\Archivos\\Ejercicio 4\\stock.txt";
            String linea = "";
            String [] filaTabla = new String[4];
            int [][] tabla = new int[3][3];
            int contadorFila = 0, menu = 0, productoReabastecer = 0, cantidadReabastecer = 0, menor, indiceMenor = 0;
            boolean input = false;

            File ubicacionArchivo = new File(rutaArchivo);
            FileReader archivoLectura = new FileReader(ubicacionArchivo);
            BufferedReader cargarDatos = new BufferedReader(archivoLectura);

            linea = cargarDatos.readLine();

            while ((linea = cargarDatos.readLine()) != null) {

                filaTabla = linea.split(",");
                tabla[contadorFila][0] = Integer.parseInt(filaTabla[1]);
                tabla[contadorFila][1] = Integer.parseInt(filaTabla[2]);
                tabla[contadorFila][2] = Integer.parseInt(filaTabla[3]);
                
                contadorFila++;

            }

            while (menu != 3) {

                while (!input) {

                    try {

                        System.out.println("Que operación deseas hacer:\n1. Para reabastecer el inventario\n2. Para transferir inventario entre sucursales\n3. Para cerrar el menú y generar el reporte");
                        menu = sc.nextInt();

                        if (menu <= 0 || menu >= 4) {

                            System.out.println("Error: la solo puedes introducir 1, 2 o 3 para indicar tu elección");

                        } else {

                            input = true;

                        }
                        
                    } catch (InputMismatchException e) {

                        System.out.println("Error: la solo puedes introducir 1, 2 o 3 para indicar tu elección");
                        sc.next();

                    } catch (Exception e) {

                        System.out.println("Error: la solo puedes introducir 1, 2 o 3 para indicar tu elección");
                        sc.next();

                    }

                }

                System.out.println(menu);

                switch (menu) {
                    case 1:

                        input = false;

                        while (!input) {

                            try {

                                System.out.println("Que producto deseas reabastecer:\n1. Para zapatos \n2. Para camisas\n3. Para pantalones");
                                productoReabastecer = sc.nextInt();

                                if (productoReabastecer <= 0 || productoReabastecer >= 4) {

                                    System.out.println("Error: la solo puedes introducir 1, 2 o 3 para indicar tu elección");

                                } else {

                                    input = true;

                                }
                                
                            } catch (InputMismatchException e) {

                                System.out.println("Error: la solo puedes introducir 1, 2 o 3 para indicar tu elección");
                                sc.next();

                            } catch (Exception e) {

                                System.out.println("Error: la solo puedes introducir 1, 2 o 3 para indicar tu elección");
                                sc.next();

                            }

                        }

                        System.out.println("Cuanto quieres reabastecer");
                        cantidadReabastecer = sc.nextInt();

                        switch (productoReabastecer) {
                            case 1:

                                menor = tabla[0][0];
                                
                                for (int j = 1; j < 3; j++) {
                                    if (tabla[0][j] < menor) {
                                        menor = tabla[0][j];
                                        indiceMenor = j;
                                    }
                                }

                                tabla[0][indiceMenor] += cantidadReabastecer;

                                break;
                            
                            case 2:

                                menor = tabla[1][0];
                                
                                for (int j = 1; j < 3; j++) {
                                    if (tabla[1][j] < menor) {
                                        menor = tabla[1][j];
                                        indiceMenor = j;
                                    }
                                }

                                tabla[1][indiceMenor] += cantidadReabastecer;

                                break;

                            case 3:

                                menor = tabla[2][0];
                                
                                for (int j = 1; j < 3; j++) {
                                    if (tabla[2][j] < menor) {
                                        menor = tabla[2][j];
                                        indiceMenor = j;
                                    }
                                }

                                tabla[2][indiceMenor] += cantidadReabastecer;

                                break;
                        }
                        
                        break;
                    
                    case 2:

                        

                        break;

                    case 3:

                        System.out.println("Generando reporte");

                        break;
                }

            }
            
        } catch (Exception e) {
        }

    }

}