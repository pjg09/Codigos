package gosones;

public class PracticaMatriz {
 
    public static void main(String[] args) {
        
        int [][] matriz = {
            {1, 2, 3} ,
            {4, 5, 6} ,
            {7, 8, 9}
        };

        int [] vector = {1, 2, 3};

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.println(matriz[j][i]);

            }

        }

    }

}