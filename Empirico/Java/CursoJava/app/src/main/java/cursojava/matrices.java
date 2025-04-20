package cursojava;

public class matrices {

    public static void main(String[] args) {
        
        int matriz [][] = new int [3] [3];
        
        //Aisganción manual
        matriz [0] [0] = 5;
        matriz [0] [1] = 13;
        matriz [0] [2] = 96;
        matriz [1] [0] = 35;
        matriz [1] [1] = 33;
        matriz [1] [2] = 71;
        matriz [2] [0] = 446;
        matriz [2] [1] = 228;
        matriz [2] [2] = 24;

        //Recorrido
        for (byte filas = 0; filas <= 2; filas++) {

            for (byte columnas = 0; columnas <= 2; columnas++) {

                System.out.println("El valor de la posicion de la fila " + filas + " y de la columna " + columnas);
                System.out.println(" es de " + matriz [filas] [columnas]);

            }

        }
        
        // La carga automatica se puede hacer de igual manera que como se hace el recorrido

    }
    
}
