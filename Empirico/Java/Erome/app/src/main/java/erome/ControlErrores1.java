package erome;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class ControlErrores1 {
 
public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // BufferedReader bff = new BufferedReader(---);
 
        try {
            
            String nombreEstudiante = "";
 
            String resumenNotas = "";
 
            String [] estudiantes = new String[0];
 
            String [] notas = new String[0];
 
            int nota = 0;
 
            int opcionMenu = 0;
 
            int cantidadNotas = 3;
 
            while(true){
 
                do{
 
                    try{
 
                        System.out.println("\n1: Crear Estudiante \n2: Calcular Promedio \n3: Salir");
                        opcionMenu = Integer.parseInt(sc.nextLine());
 
                        if(opcionMenu >= 1 && opcionMenu <= 3){
                            break;
                        }
                        else{
                            System.out.println("El valor ingresado esta por fuera del rango");
                        }
 
                    }
                    catch (NumberFormatException im){
                        System.out.println("Valor incorrecto, debe ser numerico");
                        continue;
                    }
 
                }while(true);
 
                if (opcionMenu == 1){
 
                    do{
 
                        try{
 
                            System.out.println("Ingrese el nombre del estudiante: ");
                            nombreEstudiante = sc.nextLine();
 
                            if(nombreEstudiante.trim().length() <= 1 || nombreEstudiante.trim().length() >= 30){
                                throw new ArithmeticException("Nombre invalido");
                            }
                            else{
                                break;
                            }
 
                        }
                        catch(ArithmeticException ae){
                            System.out.println(ae.getMessage());
                            continue;
                        }
 
                    }while(true);
 
                    estudiantes = agregarPosicion(estudiantes, 'e');
 
                    estudiantes[estudiantes.length - 1] = nombreEstudiante;
 
                    notas = agregarPosicion(notas, 'n');
 
                    for(int i = (estudiantes.length - 1) * cantidadNotas; i < estudiantes.length * cantidadNotas; i++){
 
                        while(true){
 
                            try {
                                System.out.print("Ingrese una nota: ");
                                nota = Integer.parseInt(sc.nextLine());
 
                                if (nota >= 0 && nota <= 5){
                                    break;
                                }
                                else{
                                    System.out.println("Ingrese una nota dentro del rango");
                                    continue;
                                }
                            }
                            catch (NumberFormatException errorEntrada) {
                                System.out.println("Ingres una nota valida");
                                continue;
                            }
                        }
                        
                        notas[i] = String.valueOf(nota);
 
                    }
 
                    System.out.println("\n===Estudiantes===\n");
                    System.out.println(Arrays.toString(estudiantes));
                    
                    System.out.println("\n===Notas===\n");
                    System.out.println(Arrays.toString(notas));
 
                }
                else if (opcionMenu == 2){
 
                    if(estudiantes.length >= 1){
 
                        resumenNotas = exponerPromedioEstudiantes(estudiantes, notas);
 
                        System.out.println(resumenNotas);
 
                    }
                    else{
                        System.out.println("Debe haber un estudiante");
                    }
 
                }
                else if (opcionMenu == 3){
 
                    break;
 
                }
                else{
 
                    System.out.println("Ingrese una opcion valida");
                    continue;
 
                }
 
            }
 
        }
        catch (IndexOutOfBoundsException ioobe){
            System.out.println("Error de indices: " + ioobe.getMessage() + "\n" + ioobe);
        }
        catch (InputMismatchException ime){
            System.out.println("Error de entrada: " + ime.getMessage() + "\n" + ime);
        }
        catch (NumberFormatException nfe){
            System.out.println("Error de formato numerico: " + nfe.getMessage() + "\n" + nfe);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n" + e);
        }
        finally{
 
            sc.close();
            // bff.close();
 
            System.out.println("Fin ejecucion");
 
        }
 
    }
 
    public static String [] agregarPosicion(String [] vectoViejo, char tipoVector) throws Exception {
 
        try {
            
            String [] vectorNuevo;
 
            /*switch (tipoVector) {
                case 'e':
                    vectorNuevo = new String[vectoViejo.length + 1];
                    break;
                case 'n':
                    vectorNuevo = new String[vectoViejo.length + 3];
                    break;
                default:
                    vectorNuevo = new String[vectoViejo.length];
                    break;
            }*/
 
            
 
            /*for(int i = 0; i < vectoViejo.length; i++){
 
                vectorNuevo[i] = vectoViejo[i];
 
            }*/
 
            switch (tipoVector) {
                case 'e':
                    vectorNuevo = Arrays.copyOf(vectoViejo, vectoViejo.length + 1);
                    break;
                case 'n':
                    vectorNuevo = Arrays.copyOf(vectoViejo, vectoViejo.length + 3);
                    break;
                default:
                    vectorNuevo = Arrays.copyOf(vectoViejo, vectoViejo.length);
                    break;
            }
 
            return vectorNuevo;
 
        }
        catch (Exception e) {
            throw new Exception("Error en la funcion [agregarPosicion]: " + e.getMessage() + "\n" + e);
        }
 
    }
 
    public static String exponerPromedioEstudiantes(String [] estudiantes, String [] notas) throws Exception {
 
        try {
            
            String resumen = "";
 
            String nota = "";
 
            int cantidadNotas = 3;
 
            int promedio = 0;
 
            int acumulativo = 0;
 
            for(int i = 0; i < estudiantes.length; i++){
 
                resumen += "\nEstudiante: " + estudiantes[i] + " : \n";
 
                for(int j = i * cantidadNotas; j < (i * cantidadNotas) + cantidadNotas; j++){
 
                    nota = notas[j];
 
                    resumen += "\n\t* " + nota;
 
                    acumulativo += Integer.parseInt(nota);
 
                }
 
                promedio = acumulativo / cantidadNotas;
 
                resumen += "\n\t= " + promedio + "\n\t " + (promedio >= 3 ? "** Aprueba **" : "** Reprueba **");
 
                acumulativo = 0;
 
            }
 
            
            return resumen;
 
        }
        catch (Exception e) {
            throw new Exception("Error en la funcion [exponerPromedioEstudiantes]: " + e.getMessage() + "\n" + e);
        }
 
    }
 
}