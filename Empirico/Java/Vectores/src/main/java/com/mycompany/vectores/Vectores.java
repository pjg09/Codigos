package com.mycompany.vectores;

import java.util.Scanner;

public class Vectores {

    public static void main(String[] args) {
        
        byte vector [] = new byte [4];
        
        //Asignación manual del vector
        /*
        vector [0] = 2;
        vector [1] = 35;
        vector [2] = 48;
        vector [3] = 127;
        */
        
        //Asignación por el usuario
        Scanner usuario = new Scanner (System.in);
        
        for (byte indice = 0; indice < vector.length; indice++) {
        
            System.out.println("Ingrese un numero entre -127 y 127 para guardar en el indice " + indice + " del vector");
            
            vector [indice] = usuario.nextByte();
        
        }
        
        //Recorrida del vector
        for (byte indice = 0; indice < vector.length; indice++) {
        
            System.out.println("Estoy en el indice " + indice);
            System.out.println("Tengo guardado el numero " + vector[indice]);
            System.out.println("----------------------------------------------");
            
        }
        
    }
    
}
