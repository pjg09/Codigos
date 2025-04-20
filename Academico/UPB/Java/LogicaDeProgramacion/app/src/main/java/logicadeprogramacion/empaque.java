/*

    En una fábrica se tiene el siguiente patrón de empaque: En una estiba(o pallet) caben 16  cajas y en cada caja, caben 30 bombillas.
    Desarrolle una función que se llame: Calcular_empaque que: reciba como argumento la cantidad de bombillas que se deben empacar y a
    partir de allí: calcule cuántas cajas necesita, cuántas estibas o pallets necesita. Luego escriba lo siguiente: 

    Para ### bombillas, se necesitan ## cajas y ## pallets. Se quedan ### bombillas sin empacar. Se empacará así:

    Pallet 1 --> Caja1, Caja2……,Caja16
    Pallet2 -->  Caja17, Caja18…..Caja 32
    .
    Palletn -- > Cajam, cajam+1…..
    
    La función retornará un texto, con la información anterior. Pruebe la función llamándola desde el programa principal:
    solicite al usuario el número de bombillas e invoque la función para imprimir en el main, los resultados.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class empaque {

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        long cantidadBombillas = 0, bombillasNoEmpacadas = 0, estibasNecesarias = 0, cajasNecesarias = 0, cajasRestantes = 0, cajaActual = 1;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingrese la cantidad de bombillas que necesita empacar: ");
                    cantidadBombillas = usuario.nextLong();

                    if(cantidadBombillas < 1) {

                        throw new IllegalArgumentException("Error: no puedes empacar menos de 1 bombilla.");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros para determinar la cantidad de bombillas que deseas empacar.");
                    usuario.next();

                }

            }

            if(cantidadBombillas <= 30 ) {

                System.out.println("Para " + cantidadBombillas + " bombillas, se necesita 1 caja y 1 estiba. Se quedan 0 bombillas sin empacar. Se empacara asi:\nEstiba 1 --> caja 1");

            } else {

                bombillasNoEmpacadas = cantidadBombillas % 30;
                cajasNecesarias = cantidadBombillas / 30;
                estibasNecesarias = cajasNecesarias / 16;
                cajasRestantes = cajasNecesarias % 16;

                if(cajasRestantes > 0) {

                    estibasNecesarias++;

                }

                System.out.println("Para " + cantidadBombillas + " bombillas, se necesitan " + cajasNecesarias + " cajas y " + estibasNecesarias + " estibas. Se quedan " + bombillasNoEmpacadas + " bombillas sin empacar. Se empacara asi:");

                for(long i = 1; i <= estibasNecesarias; i++) {

                    System.out.println("Estiba " + i + " --> ");

                    for(long j = 1; j <= 16 && cajaActual <= cajasNecesarias; j++) {

                        System.out.println("Caja " + cajaActual);

                        if(j < 16 && cajaActual < cajasNecesarias) {

                            System.out.println("");

                        }

                        cajaActual++;

                    }

                }

            }

        } finally {

            usuario.close();

        }

    }
    
}
