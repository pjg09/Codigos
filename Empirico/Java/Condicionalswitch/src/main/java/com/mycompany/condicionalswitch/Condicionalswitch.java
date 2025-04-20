package com.mycompany.condicionalswitch;

import java.util.Scanner;

public class Condicionalswitch {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce el dia de la semana que quieras seleccionar con un numero del 1 al 7: ");
        
        byte dia = scanner.nextByte();
        
        String nombreDia;
        
        nombreDia = switch (dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miercoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sabado";
            case 7 -> "Domingo";
            default -> dia + " no es un numero de dia valido";
        };
        
        System.out.println("El dia de la semana seleccionado es: " + nombreDia);
        
    }
}
