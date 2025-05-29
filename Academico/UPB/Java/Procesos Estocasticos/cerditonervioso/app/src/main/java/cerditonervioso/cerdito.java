package cerditonervioso;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class cerdito {

    public static byte avanceCerdito(byte posicionCerdito) {

        double probabilidadAvance = ThreadLocalRandom.current().nextDouble();

        switch (posicionCerdito) {

            case 20 -> {

                if (probabilidadAvance < 0.30) {

                    return 1;

                } else {

                    return 2;

                }

            }

            case 21 -> {

                return 1;

            }

            default -> {

                if (probabilidadAvance < 0.3) {

                    return 1;

                } else if (probabilidadAvance < 0.65) {

                    return 2;

                } else {

                    return 3;

                }
            }
        }
    }

    public static byte avanceFantasma(byte posicionFantasma) {

        double probabilidadAvance = ThreadLocalRandom.current().nextDouble();

        switch (posicionFantasma) {

            case 19 -> {

                if (probabilidadAvance < 0.35) {

                    return 1;

                } else if (probabilidadAvance < 0.70) {

                    return 2;

                } else {

                    return 3;

                }

            }
            case 20 -> {

                if (probabilidadAvance < 0.35) {

                    return 1;

                } else {

                    return 2;

                }

            }

            case 21 -> {

                return 1;

            }

            default -> {

                if (probabilidadAvance < 0.35) {

                    return 1;

                } else if (probabilidadAvance < 0.70) {

                    return 2;

                } else if (probabilidadAvance < 0.88) {

                    return 3;

                } else {

                    return 4;

                }

            }

        }

    }

    public static void main(String[] args) {

        System.out.println("Bienvenido al juego del cerdito nervioso\n");

        Scanner escaner = new Scanner(System.in);

        boolean input = false;
        byte posicionInicialFantasma = 0, posicionInicialCerdito = 2, meta = 22, estadoA = 13, posicionCerdito, posicionFantasma, turnoCerdito, turnoFantasma;
        short turno;
        int alcanzadoEstadoA = 0, numeroSimulaciones = 0;
        double probabilidadLlegarEstadoA = 0;

        try {
            while (!input) {
                try {
                    System.out.println("Ingrese la cantidad de veces que quiere simular el juego (debe ser un número entero entre 1 y 100.000)");
                    numeroSimulaciones = escaner.nextInt();
                    System.out.println("");

                    if (numeroSimulaciones >= 1 && numeroSimulaciones <= 100000) {
                        input = true;
                    } else {
                        throw new IllegalArgumentException("Error: la cantidad de simulaciones debe estar entre 1 y 100.000\n");
                    }
                } catch (IllegalArgumentException recoleccionDatos) {
                    System.out.println(recoleccionDatos.getMessage());
                    escaner.next();
                } catch (Exception e) {
                    System.out.println("Error: la cantidad de simulaciones debe estar entre 1 y 100.000\n");
                    escaner.next();
                }
            }

            for (short i = 1; i <= numeroSimulaciones; i++) {
                System.out.println("");
                System.out.println("---------- Juego número " + i + " ----------");

                posicionCerdito = posicionInicialCerdito;
                posicionFantasma = posicionInicialFantasma;

                System.out.println("El cerdito comienza en la posición " + posicionCerdito);
                System.out.println("El fantasma comienza en la posición" + posicionFantasma);

                turno = 1;

                while (posicionFantasma < meta && posicionCerdito < meta) {
                    System.out.println("");
                    System.out.println("Turno número " + turno);

                    turnoCerdito = avanceCerdito(posicionCerdito);
                    turnoFantasma = avanceFantasma(posicionFantasma);

                    System.out.println("El cerdito avanza " + turnoCerdito + " casillas en este turno");
                    System.out.println("El fantasma avanza " + turnoFantasma + " casillas en este turno\n");

                    posicionCerdito += turnoCerdito;
                    posicionFantasma += turnoFantasma;

                    System.out.println("Ahora el cerdito se encuentra en la casilla " + posicionCerdito);
                    System.out.println("Ahora el fantasma se encuentra en la casilla " + posicionFantasma);

                    turno += 1;

                    if (posicionCerdito == estadoA) {
                        System.out.println("¡¡¡El cerdito ha llegado por primera vez al estado A!!!");
                        alcanzadoEstadoA++;
                    }

                    if (posicionFantasma >= posicionCerdito) {
                        break;
                    }
                }

                System.out.println("");

                if (posicionFantasma >= posicionCerdito) {
                    System.out.println("El juego número " + i + " ha finalizado con el fantasma como ganador");
                } else {
                    System.out.println("El juego número " + i + " ha finalizado con el cerdito como ganador");
                }
            }

            probabilidadLlegarEstadoA = (double) alcanzadoEstadoA / numeroSimulaciones;

        } catch (Exception e) {

            System.out.println("Ha ocurrido un error inesperado");

        } finally {

            System.out.println("");
            System.out.println("De " + numeroSimulaciones + " simulaciones se llegó " + alcanzadoEstadoA + " veces al estado A, lo que indica que hubo una probabilidad de llegar al estado A de un " + String.format("%.3f", probabilidadLlegarEstadoA));

            escaner.close();

        }

    }

}