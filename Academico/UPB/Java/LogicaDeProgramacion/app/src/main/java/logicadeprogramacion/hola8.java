/*

    Diseñar y desarrollar una función que NO reciba datos de entrada
    genere aleatoriamente un numero al que se les va a calcular la 
    raíz entre 2 y 355 y retorne el valor de la raíz.
    Para calcular las raíces usar la función Sqrt de la biblioteca Math.

*/

package logicadeprogramacion;





public class hola8 {

    public static int azar() {

        int azar = (int) (Math.random() * (355 - 2 + 1)) + 2;

        return azar;

    }

    public static void main(String[] args) {

        int azar = azar();
        double raiz = Math.sqrt(azar);

        System.out.println("La raiz de " + azar + " es " + raiz);
        


    }




    
}