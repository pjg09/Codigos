package com.mycompany.operadorternario;

import java.util.Scanner;

public class OperadorTernario {

    public static void main(String[] args) {
        
        String condicionFinal;
        
        Scanner usuario = new Scanner(System.in);
        
        System.out.println("Ingrese el promedio final de la asignatura: ");
        double promedio = usuario.nextDouble();
        
        condicionFinal = promedio >= 3 ? "aprobado" : "desaprobado";
        
        System.out.println("Usted ha " + condicionFinal + " la materia");
        
    }
    
}