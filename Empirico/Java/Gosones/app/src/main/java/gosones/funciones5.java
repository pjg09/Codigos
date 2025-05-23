package gosones;

public class funciones5 {

    public static int [][] DetectarZonaRiesgo(double [][] temperaturasZona, double umbralRiesgo) {

        int [][] coordenadasRiesgosas;
        int filas = 0;
        int filaActual = 0;

        for (int i = 0; i < temperaturasZona.length; i++) {

            for (int j = 0; j < temperaturasZona[i].length; j++) {

                if (temperaturasZona[i][j] >= umbralRiesgo) {

                    filas++;

                }

            }

        }

        if (filas > 0) {

            coordenadasRiesgosas = new int [filas][2];

            for (int i = 0; i < temperaturasZona.length; i++) {

                for (int j = 0; j < temperaturasZona[i].length; j++) {

                    if (temperaturasZona[i][j] >= umbralRiesgo) {

                        coordenadasRiesgosas[filaActual][0] = i;
                        coordenadasRiesgosas[filaActual][1] = j;

                        filaActual++;

                    }

                }

            }

            return coordenadasRiesgosas;

        } else {

            coordenadasRiesgosas = new int [1][1];

            coordenadasRiesgosas[1][1] = 0;

            return coordenadasRiesgosas;

        }

    }
 
    public static void main(String[] args) {
        
        double [][] temperaturasZona = {

            {25.6, 28.9, 60},
            {95.8, 77, 4},
            {42, 16, 82}

        };

        double umbralRiesgo = 59.9;

        int [][] coordenadasRiesgosas = DetectarZonaRiesgo(temperaturasZona, umbralRiesgo);

        for (int i = 0; i < coordenadasRiesgosas.length; i++) {

            System.out.println("Coordenada de riesgo numero " + (i + 1) + ": (" + coordenadasRiesgosas[i][0] + ", " + coordenadasRiesgosas[i][1] + ")");

        }

    }

}