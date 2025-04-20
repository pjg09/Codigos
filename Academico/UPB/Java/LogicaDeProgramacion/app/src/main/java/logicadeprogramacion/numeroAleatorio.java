package logicadeprogramacion;

import java.util.Random;

public class numeroAleatorio {

    public static void main(String[] args) {
        // Crear una instancia de Random
        Random random = new Random();
        
        // Generar un número aleatorio entre 0 y 9
        int numeroAleatorio = random.nextInt(10); // El rango es de 0 a 9

        // Imprimir el número aleatorio
        System.out.println("Número aleatorio generado: " + numeroAleatorio);
    }
}
