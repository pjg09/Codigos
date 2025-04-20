package com.mycompany.condicionalif;

public class Condicionalif {

    public static void main(String[] args) {
        
        byte numero1, numero2;
        
        numero1 = 16;
        numero2 = 15;
        
        if(numero1 > numero2) {
           
            System.out.println(numero1 + " es mayor que " + numero2); 
            
        }else {
            
            if (numero1 == numero2) {
            
                System.out.println(numero1 + " = " + numero2);
                
            } else {
            
                System.out.println(numero1 + " es menor que " + numero2);
            
            }
            
        }
        
    }
    
}