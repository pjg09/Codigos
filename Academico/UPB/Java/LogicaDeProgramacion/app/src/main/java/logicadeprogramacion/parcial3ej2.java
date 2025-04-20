/*

    Enunciado:
    Un colegio organiza un torneo de ajedrez entre sus estudiantes. El colegio tiene varios cursos, y cada curso tiene un número
    diferente de estudiantes. El torneo se llevará a cabo de la siguiente manera: cada estudiante de un curso se enfrentará a cada
    estudiante de los otros cursos, asegurando que todos jueguen al menos una partida contra un estudiante de otro curso.

    El programa que debes implementar debe pedir al usuario:

    El número de cursos en el torneo.
    Para cada curso, el número de estudiantes que tiene.
    El programa debe imprimir cuántas partidas se jugarán en total en el torneo.

    Ejemplo:
    Si el colegio tiene 2 cursos:

    Curso 1 tiene 3 estudiantes.
    Curso 2 tiene 2 estudiantes.
    Entonces, se jugarán 6 partidas (3 estudiantes del Curso 1 * 2 estudiantes del Curso 2).

*/

package logicadeprogramacion;

import java.util.Scanner;

public class parcial3ej2 {
    
    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        int cantidadCursos = 0, cantidadPartidas = 0;
        int [] estudiantesCursos;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingresa la cantidad de cursos que van a participar en el torneo");
                    cantidadCursos = usuario.nextInt();

                    if(cantidadCursos < 2) {

                        throw new IllegalArgumentException("Error: deben participar minimo dos cursos en el torneo");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros para definir la cantidad de cursos que van a participar en el torneo");
                    usuario.next();

                }

            }

            estudiantesCursos = new int[cantidadCursos];

            for(int i = 0; i < cantidadCursos; i++) {

                while(input) {

                    try {

                        System.out.println("Ingresa la cantidad de estudiantes que van a participar del curso " + (i + 1));
                        estudiantesCursos [i] = usuario.nextInt();

                        if(estudiantesCursos[i] < 1) {

                            throw new IllegalArgumentException("Error: debe participar minimo un estudiante por curso");

                        }

                        input = false;

                    } catch(IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    } catch(Exception e) {

                        System.out.println("Error: solo puedes ingresar numeros enteros para determinar la cantidad de estudiantes por curso que van a participar en el torneo");
                        usuario.next();

                    }

                }

                input = true;

            }

            for(int i = 0; i < cantidadCursos; i++) {

                for(int j = i + 1; j < cantidadCursos; j++) {

                    cantidadPartidas += estudiantesCursos[i] * estudiantesCursos[j];

                }

            }

        } finally {

            System.out.println("Se jugaran un total de " + cantidadPartidas + " partidas en el torneo");

            usuario.close();

        }

    }

}