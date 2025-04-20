/*

    En un juego, cada jugador tiene 3 intentos para sacar cartas de una baraja. Las cartas van numeradas entre 1 y 10.
    Una función Jugar_21, deberá simular el juego para una cantidad de usuarios que enviará el usuario desde el programa principal
    entre 1 y 6.

    Para cada uno de los jugadores, el programa le calculará 3 cartas al azar y al final
    imprimirá el juego para cada jugador basado en las siguientes reglas: 
    
    Si saca 21 exactos: juego perfecto
    Si saca más de 21: se pasó
    Si saca menos de 21: faltaron puntos

    La función deberá imprimir los puntos de cada jugador junto con la regla anterior, como muestra el ejemplo:

    Jugador X, puntos 21 -- > juego perfecto
    Jugador Y, puntos 26 -- > se pasó

*/

package logicadeprogramacion;

import java.util.Scanner;

public class algoritmosciclosanidados3 {

    public static int[] jugar21() {

        int[] resultados = new int[3];
        byte minimo = 1, maximo = 10;

        for(byte i = 0; i <= 2; i++) {

            resultados[i] = (int)(Math.random() * ((maximo - minimo) + 1)) + minimo;

        }

        return resultados;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        int resultados[] = new int[3];
        byte cantidadJugadores = 0, contador = 1, resultadoTotal = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingresa la cantidad de jugadores que deseas para esta ronda (minimo 1, maximo 6)");
                    cantidadJugadores = usuario.nextByte();

                    if(cantidadJugadores < 1 || cantidadJugadores > 6) {

                        throw new IllegalArgumentException("Error: solo puedes ingresar un numero entre 1 y 6 para definir la cantidad de jugadores");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");

                    usuario.next();

                }

            }

        } finally {

            while(contador < cantidadJugadores) {

                resultados = jugar21();

                for(byte j = 0; j <= 2; j++) {

                    resultadoTotal += resultados[j];

                }

                if(resultadoTotal < 21) {

                    System.out.println("El jugador " + contador + " ha sacado " + resultadoTotal + ", le han faltado puntos");

                } else if(resultadoTotal == 21) {

                    System.out.println("El jugador " + contador + " ha sacado " + resultadoTotal + ", ha sacado un juego perfecto");

                } else {

                    System.out.println("El jugador " + contador + " ha sacado " + resultadoTotal + ", se ha pasado");

                }

                contador++;
                resultadoTotal = 0;

            }

            usuario.close();

        }

    }
    
}