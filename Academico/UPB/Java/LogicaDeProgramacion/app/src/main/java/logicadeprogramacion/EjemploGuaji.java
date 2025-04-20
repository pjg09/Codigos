package logicadeprogramacion;

import java.util.Random;

public class EjemploGuaji {
    public static void main(String[] args) {
        int[] cajaGrande = new int[10];
        Random aleatorio = new Random();

        for(int i = 0; i < cajaGrande.length; i++){
            cajaGrande[i] = aleatorio.nextInt(100);
            System.out.println(cajaGrande[i] );
        }
    }
}
