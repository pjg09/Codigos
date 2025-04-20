/*

Tienda de Ropa 

Un almacén de venta de ropa ofrece cuatro productos a los clientes con los siguientes precios: 

Camisas: $120,000 

Gorras: $45,000 

Pantalones: $80,000 

Buzos: $130,000 

Los clientes del almacén pueden ser de dos tipos: 

VIP (V): Clientes especiales que reciben un descuento en sus compras. 

Común (C): Clientes regulares sin descuento adicional. 

Requisitos del Programa 

Desarrolle un programa que permita a los clientes realizar compras en el almacén con las siguientes características: 

Solicitar el tipo de cliente: 

El programa debe preguntar si el cliente es VIP (V) o Común (C). 

Menú de selección de productos: 

El cliente podrá seleccionar el producto que desea comprar a través de un menú: 

Camisas 

Gorras 

Pantalones 

Buzos 

Terminar Compra 

También deberá ingresar la cantidad de unidades que desea comprar del producto seleccionado. 

El cliente puede repetir este proceso para añadir diferentes productos a su compra. 

Finalizar la compra: 

El cliente podrá terminar su proceso de compra seleccionando la opción 5 en el menú. 

Consideraciones Adicionales 

Descuento para clientes VIP: 

Si el cliente es VIP, se aplicará un 20% de descuento al total de la compra antes de agregar el IVA.	 

Cálculo del IVA: 

Se debe calcular un IVA del 19% sobre el valor total de los productos antes de aplicar cualquier descuento. 

Cálculo del total: 

El total de la factura debe incluir el descuento (si aplica), el IVA y una propina opcional que puede ser definida por el cliente o un valor fijo (a determinar en el diseño del programa). 

Ejemplo de Salida: 

Texto

Descripción generada automáticamente

*/

package logicadeprogramacion;

import java.util.Scanner;

public class tiendaderopa {

    public static byte Excepciones(Scanner usuario) {

        byte dato = 0;
        boolean input = false;

        while(!input) {

            try {

                System.out.println("");
                dato = usuario.nextByte();

                input = true;

            } catch(Exception e) {

                System.out.println("Error: solo puedes ingresar numeros enteros \n Intentalo de nuevo");
                usuario.next();

            }

        }

        return dato;

    }

    public static void main(String[] args) {
        
        Scanner usuario = new Scanner(System.in);
        String tipoProducto = "";
        byte tipoCliente = 0, producto = 0, opcionPropina = 0;
        int precioProducto = 0;
        long cantidadUnidades = 0, precioBruto = 0, brutoTotal = 0;
        double descuento = 0, propina = 0, iva = 0, totalNeto = 0, cantidadPropina = 0;
        boolean input = false;

        try {

            System.out.println("¿Eres cliente VIP o comun? \n Digita 1 para VIP \n Digita 2 para comun");
            tipoCliente = Excepciones(usuario);

            while(tipoCliente < 1 || tipoCliente > 2) {

                System.out.println("Error: solo puedes ingresar 1 o 2 para seleccionar que tipo de cliente eres \n Intentalo de nuevo");
                tipoCliente = Excepciones(usuario);

            }

            while(producto != 5) {

                System.out.println(" Menu de seleccion de productos \n Que producto deseas añadir al carrito \n Digita 1 para camisas \n Digita 2 para gorras \n Digita 3 para pantalones \n Digita 4 para buzos \n Digita 5 para finalizar la compra");
                producto = Excepciones(usuario);

                while(producto < 1 || producto > 5) {

                    System.out.println("Error: solo puedes ingresar numeros del 1 al 5 para las opciones del menu");
                    producto = Excepciones(usuario);

                }

                switch(producto) {

                    case 1:
                        tipoProducto = "camisas";
                        precioProducto = 120000;
                        break;

                    case 2:
                        tipoProducto = "gorras";
                        precioProducto = 45000;
                        break;

                    case 3:
                        tipoProducto = "pantalones";
                        precioProducto = 80000;
                        break;

                    case 4: 
                        tipoProducto = "buzos";
                        precioProducto = 130000;
                        break;

                    case 5:
                        precioProducto = 0;
                        break;

                }

                if(producto > 0 && producto < 5) {

                    while(!input) {

                        try {

                            System.out.println("¿Que cantidad de " + tipoProducto + " deseas llevar?");
                            cantidadUnidades = usuario.nextLong();

                            if(cantidadUnidades < 1) {

                                throw new IllegalArgumentException("Error: debes llevar una o mas unidades de " + tipoProducto);

                            }

                            input = true;

                        } catch(IllegalArgumentException e) {

                            System.out.println(e.getMessage());

                        } catch(Exception e) {

                            System.out.println("Error: solo puedes ingresar numeros enteros para indicar la cantidad de unidades");

                        }

                    }

                    input = false;

                    }

                    precioBruto = precioProducto * cantidadUnidades;

                    brutoTotal += precioBruto;

                }

                iva = brutoTotal * 0.19;

                if(tipoCliente == 1) {

                descuento = brutoTotal * 0.20;

            }

            totalNeto = brutoTotal + iva - descuento;

            System.out.println("Actualmente su saldo a pagar es de " + totalNeto + " ¿Te gustaria apoyarnos con una propia? \n Digita 1 para si \n Digita 2 para no");
            opcionPropina = Excepciones(usuario);

            while(opcionPropina < 1 || opcionPropina > 2) {

                System.out.println("Error: solo puedes ingresar 1 o 2 para determinar si quieres dar o no propina");

                opcionPropina = Excepciones(usuario);

            }

            if(opcionPropina == 1) {

                while(!input) {

                    try {

                        System.out.println("Ingresa el porcentaje de propina que deseas dar \n Ingresa solo el numero correspondiente al porcentaje de propina, por favor no ingreses signos");
                        cantidadPropina = usuario.nextDouble();

                        if(cantidadPropina < 0) {

                            throw new IllegalArgumentException("Solo puedes ingresar numeros de cero en adelante para determinar la cantidad de propina que quieres dar");

                        }

                        input = true;

                    } catch(IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    } catch(Exception e) {

                        System.out.println("Error: solo puedes ingresar numeros para determinar la cantidad del porcentaje de propina que deseas dar \n Recuerda no ingresar el signo de porcentaje o ningun otro signo");
                        usuario.next();

                    }

                }

                propina = (cantidadPropina / 100) * totalNeto++;
                totalNeto += propina;

            }

        } finally {

            System.out.println("El valor final a pagar es " + totalNeto);

            usuario.close();

        }

    }
    
}