package com.mycompany.ejercicio;

import java.util.Scanner;

public class Ejercicio {

    public static void main(String[] args) {
        
        System.out.println("Calculadora de sueldos para empleados");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el numero correspondiente a su cargo, 1 para repositor, 2 para cajero y 3 para supervisor: ");
        byte empleado = scanner.nextByte();
        
        double salariofix = 0;
        String tipo = null;
        
        if(empleado == 1) {
        
            tipo = "repositor";
            salariofix = 15890 + (15890 * 0.10);
        
        }else {
        
            if(empleado == 2) {
            
                tipo = "cajero";
                salariofix = 25630.89;
            
            }else {
            
                if(empleado == 3) {
                
                    tipo = "supervisor";
                    salariofix = 35560.20 - (35560.20 * 0.11);
                
                }else {
                
                    System.out.println("No ingresaste un numero correspondiente a un cargo");
                
                }
            
            }
        
        }
        
        if(empleado == 1 || empleado == 2 || empleado == 3) {
        
            System.out.println("Su salario como " + tipo + " es de $" + salariofix + " dolares");
        
        }
        
    }
}