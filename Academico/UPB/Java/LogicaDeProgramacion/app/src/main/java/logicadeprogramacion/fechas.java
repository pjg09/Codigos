/*

    Solicite al usuario ingrese los siguientes datos en formato numérico: día, mes, año para enviarlos a una función que retorne 
    la fecha en el siguiente formato: dia de mes en texto de año.  
    Por ejemplo, si el usuario ingresa:

    •	Dia 10
    •	Mes 12
    •	Año 2019

    El programa debe retornar 10 de Diciembre de 2019. 

    Cuando el usuario ingrese la información, el programa debe controlar que los años no sean inferiores a 1950 ni mayores a 2020, 
    los meses estén entre 1 Y 12 y para cada mes, dentro de las opciones de la lista de comparación, los días correctos:

    •	Enero entre 1 y 31
    •	Febrero entre 1 y 29
    •	Marzo entre 1 y 31
    •	Abril entre 1 y 30
    •	Mayo entre 1 y 31
    •	Junio entre 1 y 30
    •	Julio entre 1 y 31
    •	Agosto entre 1 y 31
    •	Septiembre entre 1 y 30
    •	Octubre entre 1 y 31
    •	Noviembre entre 1 y 30
    •	Diciembre entre 1 y 31

    Defina usted los elementos de esta función de acuerdo con las recomendaciones vistas en clase.

*/

package logicadeprogramacion;

import java.util.Scanner;

public class fechas {   

    public static String construirFecha(short año, byte mes, byte dia) {

        String fecha = "";
        String textoMes = "";

        switch(mes) {

            case 1:
                textoMes = "Enero";
                break;

            case 2:
                textoMes = "Febrero";
                break;

            case 3:
                textoMes = "Marzo";
                break;

            case 4:
                textoMes = "Abril";
                break;

            case 5:
                textoMes = "Mayo";
                break;

            case 6:
                textoMes = "Junio";
                break;

            case 7:
                textoMes = "Julio";
                break;

            case 8:
                textoMes = "Agosto";
                break;

            case 9:
                textoMes = "Septiembre";
                break;

            case 10:
                textoMes = "Octubre";
                break;

            case 11:
                textoMes = "Noviembre";
                break;

            case 12:
                textoMes = "Diciembre";
                break;

        }

        fecha = dia + " de " + textoMes + " de " + año;

        return fecha;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        String fecha = "";
        byte dia = 0, mes = 0, diaFinal = 0;
        short año = 0;
        boolean input = false;

        try {

            while(!input) {

                try {

                    System.out.println("Ingrese el año \n Este debe ser un numero entero entre 1950 y 2020");
                    año = usuario.nextShort();

                    if(año < 1950 || año > 2020) {

                        throw new IllegalArgumentException("Error: el año solo puede estar entre 1950 y 2020");

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");
                    usuario.next();

                }

            }

            while(input) {

                try {

                    System.out.println("Ingrese el mes del año " + año + " \n Debe ser un numero entero entre 1 y 12");
                    mes = usuario.nextByte();

                    if(mes < 1 || mes > 12) {

                        throw new IllegalArgumentException("Error: el mes debe estar entre 1 y 12");

                    }

                    input = false;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");
                    usuario.next();

                }

            }

            if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {

                diaFinal = 31;

            } else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {

                diaFinal = 30;

            } else {

                diaFinal = 29;

            }

            while(!input) {

                try {

                    System.out.println("Ingresa el dia del mes " + mes + "\n Debe ser un numero entero entre 1 y " + diaFinal);
                    dia = usuario.nextByte();

                    if(dia < 1 || dia > diaFinal) {

                        throw new IllegalArgumentException("Error: solo puedes ingresar numeros entre 1 y " + diaFinal);

                    }

                    input = true;

                } catch(IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                } catch(Exception e) {

                    System.out.println("Error: solo puedes ingresar numeros enteros");
                    usuario.next();

                }

            }

            fecha = construirFecha(año, mes, dia);

            usuario.close();

        } finally {

            System.out.println(fecha);

        }

    }
    
}
