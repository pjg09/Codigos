package com.mycompany.ejercicioslogicos;

public class EjerciciosLogicos {

    public static void main(String[] args) {
        
        byte numero1, numero2, auxiliar;
        
        numero1 = 20;
        numero2 = 35;

        auxiliar = numero1;
        numero1 = numero2;
        numero2 = auxiliar;

        System.out.println(numero1);
        System.out.println(numero2);
        
    }
}
