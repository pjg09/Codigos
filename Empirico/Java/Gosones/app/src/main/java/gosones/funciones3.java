package gosones;

public class funciones3 {

    public static double[] CalcularPromedioSatisfaccion (int [][] puntuaciones) {

        double [] promedioPregunta = new double[3];

        for (int j = 0; j < 3; j++) {

            for (int i = 0; i < 3; i++) {

                promedioPregunta[j] += puntuaciones[i][j];

            }

            promedioPregunta[j] = promedioPregunta[j] / 3;

        }

        return promedioPregunta;

    }
 
    public static void main(String[] args) {
        
        int [][] puntuaciones = {
            {2, 4, 1} ,
            {3, 5, 5} ,
            {4, 2, 2}
        };

        double [] promedioPregunta = CalcularPromedioSatisfaccion(puntuaciones);

        for (int i = 0; i < 3; i++) {

            System.out.println("El promedio para la pregunta " + (i + 1) + " es: " + promedioPregunta[i]);

        }

    }

}