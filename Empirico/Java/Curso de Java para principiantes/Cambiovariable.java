public class Cambiovariable {

    public static void main(String[] args) {

        short numero1 = 20;
        short numero2 = 35;
        short auxiliar;

        auxiliar = numero1;
        numero1 = numero2;

        System.out.println(numero1);

        numero2 = auxiliar;

        System.out.println(numero2);

    }

}