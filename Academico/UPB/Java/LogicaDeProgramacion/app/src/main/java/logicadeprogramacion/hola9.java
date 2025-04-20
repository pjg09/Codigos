/*

    Diseñe un algoritmo e implemente una función en Java que identifique y escriba el número mayor entre 3 números short
    digitados por los usuarios. Defina usted los elementos de esta función de acuerdo a las recomendaciones vistas en clase.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class hola9 {

    public static String numMayor(short num1, short num2, short num3) {

        String mensaje = "";

        if (num1 > num2 && num1 > num3) {
            mensaje += "El número mayor es el " + num1;

        } else if (num2 > num1 && num2 > num3) {
            mensaje += "El numero mayor es el " + num2;

        } else {
            mensaje += "El número mayor es " + num3;
        }

        return mensaje;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        short num1 = 0;
        short num2 = 0;
        short num3 = 0;
        String numMayor1 = "";

        try {

            System.out.println("Ingrese el primer número");
            num1 = sc.nextShort();

            System.out.println("Ingrese el segundo número");
            num2 = sc.nextShort();

            System.out.println("Ingrese el tercer número");
            num3 = sc.nextShort();

        } catch (Exception e) {

            System.out.println("Error, ingrese únicamente números");

        }

        numMayor1 = numMayor(num1, num2, num3);

        System.out.println(numMayor1);

        sc.close();

    }

}