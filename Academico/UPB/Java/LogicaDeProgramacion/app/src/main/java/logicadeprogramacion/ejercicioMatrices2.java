// Crear una matriz de 3×3 con los números del 1 al 9. Mostrar por pantalla, tal como aparece en la matriz.

package logicadeprogramacion;

public class ejercicioMatrices2 {

    public static void main(String[] args) {
        
        String respuesta = "";
        int matriz [][] = new int [3][3];

        try {

            for(byte i = 0; i < matriz.length; i++) {

                respuesta += "|";

                for(byte j = 0; j < matriz.length; j++) {

                    matriz[i][j] = (int) (Math.random() * (10000 - 1 + 1)) + 1;
                    respuesta += matriz[i][j] + "|";

                }

                respuesta += "\n";

            }

        } finally {

            System.out.println(respuesta);

        }

    }
    
}