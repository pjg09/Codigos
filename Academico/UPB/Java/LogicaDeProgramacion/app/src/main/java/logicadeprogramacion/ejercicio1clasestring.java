package logicadeprogramacion;

public class ejercicio1clasestring {

    public static void main(String[] args) {

        //Split
        
        String fecha = "22/08/2024";
        String[] fechaSeparada = fecha.split("/");

        System.out.println("El dia es " + fechaSeparada[0]);
        System.out.println("El mes es " + fechaSeparada[1]);
        System.out.println("El año es " + fechaSeparada[2]);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

/*
--------------------------------------------------------------------------------------------------------------------------------------
*/

        //Conversion mayusculas y minusculas

        String nombre = "Pedro";
        String nombreFixLow = nombre.toLowerCase();
        String nombreFixUp = nombre.toUpperCase();

        System.out.println("El nombre en minusculas es: " + nombreFixLow);
        System.out.println("El nombre en mayusculas es: " + nombreFixUp);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

/*
--------------------------------------------------------------------------------------------------------------------------------------
*/

        //Comparacion

        String nombre1 = "Pedro";
        boolean verificacion = false;

        verificacion = nombre.equals(nombre1);

        System.out.println(verificacion);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

/*
--------------------------------------------------------------------------------------------------------------------------------------
*/

    }    
    
}