package logicadeprogramacion;

//Importación de librerías a utilizar
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.io.*;

public class proyectoFinal {

    //Constantes y variables globales
    static String[][] tasas = new String[3][2];
    //Método para redondear decimales
    final static DecimalFormat fix = new DecimalFormat("#,###.##");
    //
    final static String rutaTasas = "C:\\Users\\pjgom\\OneDrive\\Desktop\\Tasas.txt";
    final static String rutaResultados = "C:/Users/pjgom/OneDrive/Desktop/Final/Resultados.txt";
    final static byte beneficioDolar = 80;
    final static byte beneficioYen = 88;
    final static byte beneficioEuro = 69;

    //Funcion para cambiar los dolares a pesos
    public static float cambioDolares(float cantidadCambio) {

        int tasa = Integer.parseInt(tasas[0][1]);
        float pesos = cantidadCambio * tasa;
        return pesos;

    }

    //Funcion para cambiar los yenes a pesos
    public static float cambioYenes(float cantidadCambio) {

        int tasa = Integer.parseInt(tasas[1][1]);
        float pesos = cantidadCambio * tasa;
        return pesos;

    }

    //Funcion para cambiar los euros a pesos
    public static float cambioEuros(float cantidadCambio) {

        int tasa = Integer.parseInt(tasas[2][1]);
        float pesos = cantidadCambio * tasa;
        return pesos;

    }

    //Funcion para crear la matriz con las respuestas y calcular las ganancias
    public static float [][] respuestas(float totalDolares, float totalYenes, float totalEuros) {

        float resultados[][] = {

            {totalDolares, totalYenes, totalEuros},
            {totalDolares * beneficioDolar, totalYenes * beneficioYen, totalEuros * beneficioEuro}

        };

        return resultados;

    }
    
    public static void main(String[] args) {
        
        //Declaración de variables
        String partes[];
        String usuario = "", puntero = "", moneda = "";        
        byte opcion = 0, linea = 0;
        float datos[][] = new float[2][3];
        float cantidadCambio = 0, totalDolares = 0, totalYenes = 0, totalEuros = 0;
        boolean input = false;

        //Inicio del try principal
        try {

            //Variables para la lecutra del archivo
            File archivoTasas = new File(rutaTasas);
            FileReader lecturaTasas = new FileReader(archivoTasas);
            BufferedReader cargaTasas = new BufferedReader(lecturaTasas);

            //Variables para la escritura del archivo
            FileWriter archivoResultados = new FileWriter(rutaResultados, false);
            PrintWriter lineaEscritura = new PrintWriter(archivoResultados);

            //Lectura del archivo y recolección de las tasas de cambio
            while((puntero = cargaTasas.readLine()) != null && linea < 3) {

                partes = puntero.split("@");
                tasas[linea][0] = partes[0];
                tasas[linea][1] = partes[1];
                linea++;

            }

            //Ciclo para repetir las operaciones del menú
            while(opcion != 4) {

                //Menú con control de errores
                while(!input) {

                    try {

                        usuario = JOptionPane.showInputDialog("Selecciona tu opción.\n1. Cambiar de yen (¥) a pesos Colombianos ($).\n2. Cambiar de dólares ($) a pesos Colombianos ($).\n3. Cambiar de euros (€) a pesos Colombianos($).\n4. Finalizar transacciones y mostrar los datos.");

                        if(usuario == null || usuario.matches(".*[a-zA-Z].*") || usuario.matches(".*[^a-zA-Z0-9 ].*")) {

                            throw new IllegalArgumentException("Error: no puedes dejar vacía tu opción y esta solo puede contener números enteros.");

                        }

                        opcion = Byte.parseByte(usuario);

                        if(opcion < 1 || opcion > 4) {

                            throw new IllegalArgumentException("Error: solo puedes ingresar numeros entre 1 y 4 para seleccionar tu opción.");

                        }

                        input = true;

                    } catch(IllegalArgumentException e) {

                        JOptionPane.showMessageDialog(null, e.getMessage());

                    } catch(Exception e) {

                        JOptionPane.showMessageDialog(null, "Error: solo puedes ingresar numeros enteros para seleccionar tu opción.");

                    }

                }

                //If para trabajar siempre y cuando el usuario no haya elegido la opción de salida
                if(opcion != 4) {

                    //Switch para mostrarle al usuario la moneda que está cambiando
                    switch(opcion) {

                        case 1:
                            moneda = "yenes (¥)";
                            break;

                        case 2:
                            moneda = "dólares ($)";
                            break;

                        case 3:
                            moneda = "euros (€)";
                            break;

                        default:
                            break;

                    }

                    //Recolección de cantidad de dinero a cambiar con control de errores
                    while(input) {

                        try {

                            usuario = JOptionPane.showInputDialog("Ingresa la cantidad de " + moneda + " que deseas convertir a pesos");

                            if(usuario == null || usuario.matches(".*[a-zA-Z].*") || usuario.matches(".*[^0-9.].*")) {

                                throw new IllegalArgumentException("Error: no puedes dejar vacía tu opción y esta solo puede contener números decimales positivos.");

                            }

                            cantidadCambio = Float.parseFloat(usuario);

                            input = false;

                        } catch(IllegalArgumentException e) {

                            JOptionPane.showMessageDialog(null, e.getMessage());

                        } catch(Exception e) {

                            JOptionPane.showMessageDialog(null, "Error: solo puedes ingresar numeros para indicar tu elección.");

                        }

                    }

                    //Switch para elegir la función que va convertir el dinero
                    switch(opcion) {

                        case 1:
                            totalYenes += cantidadCambio;
                            JOptionPane.showMessageDialog(null, "Recibes $" + fix.format(cambioYenes(cantidadCambio)) + " pesos Colombianos por tus ¥" + fix.format(cantidadCambio) + " yenes.\nEsta información ha sido agregada al archivo donde se guardan las conversiones.");
                            break;

                        case 2:
                            totalDolares += cantidadCambio;
                            JOptionPane.showMessageDialog(null, "Recibes $" + fix.format(cambioDolares(cantidadCambio)) + " pesos Colombianos por tus $" + fix.format(cantidadCambio) + " dolares.\nEsta información ha sido agregada al archivo donde se guardan las conversiones.");
                            break;

                        case 3:
                            totalEuros += cantidadCambio;
                            JOptionPane.showMessageDialog(null, "Recibes $" + fix.format(cambioEuros(cantidadCambio)) + " pesos Colombianos por tus €" + fix.format(cantidadCambio) + " euros.\nEsta información ha sido agregada al archivo donde se guardan las conversiones.");
                            break;

                        default:
                            break;

                    }
                    
                }

            }

            datos = respuestas(totalDolares, totalYenes, totalEuros);

            lineaEscritura.println("Total Dólares: $" + fix.format(datos[0][0]) + "\nTotal ganado: $" + fix.format(datos[1][0]) + "\n\nTotal Yenes: ¥" + fix.format(datos[0][1]) + "\nTotal ganado: $" + fix.format(datos[1][1]) + "\n\nTotal Euros: €" + fix.format(datos[0][2]) + "\nTotal ganado: $" + fix.format(datos[1][2]));

            cargaTasas.close();
            lineaEscritura.close();

        } catch(IOException e) {

            JOptionPane.showMessageDialog(null, "Ha ocurrido un error con el manejo de los archivos.");

        } finally {

            JOptionPane.showMessageDialog(null, "Gracias por usar nuestro servicio\nYa puedes revisar el archivo de resultados para observar todas las conversiones realizadas.");

        }

    }

}