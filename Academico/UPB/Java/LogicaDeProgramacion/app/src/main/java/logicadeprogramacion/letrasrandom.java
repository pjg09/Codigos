package logicadeprogramacion;

import java.util.concurrent.ThreadLocalRandom;

public class letrasrandom {
    
    public static void main(String[] args) {
        
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 26);
        
        char letraAleatoria = (char) ('A' + numeroAleatorio);

        System.out.println(letraAleatoria);

    }

}