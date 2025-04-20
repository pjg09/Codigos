package calculadora;

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {

    public static double suma(double... valores) {

        double resultado = 0;
            
        for(double valor : valores) {

            resultado += valor;

        }

        return resultado;

    }

    public static double multiplicacion(double... valores) {

        double resultado = 1;

        for(double valor : valores) {

            resultado *= valor;

        }

        return resultado;

    }

    public static double division(double dividendo, double divisor) {

        double resultado = 1;
        resultado = dividendo / divisor;
        return resultado;

    }

    public static double residuo(double dividendo, double divisor) {

        double resultado = 1;
        resultado = dividendo % divisor;
        return resultado;

    }

    public static double logaritmo(double base, double argumento) {

        double resultado = 1;
        resultado = Math.log(argumento) / Math.log(base);
        return resultado;

    }

    public static double logaritmoNatural(double argumento) {

        double resultado = 1;
        resultado = Math.log(argumento);
        return resultado;

    }

    public static double calcularPorcentaje(double porcentaje, double numero) {

        double resultado = 1;
        resultado = numero * (porcentaje / 100);
        return resultado;

    }

    public static double raiz(double indice, double radicando) {

        double resultado = 1;
        resultado = Math.pow(radicando, 1.0 / indice);
        return resultado;

    }

    public static double potenciacion(double base, double exponente) {

        double resultado = 1;
        resultado = Math.pow(base, exponente);
        return resultado;

    }

    public static double exponencial(double exponente) {

        double resultado = 1;
        resultado = Math.exp(exponente);
        return resultado;

    }

    public static double seno(double angulo) {

        double resultado = 1;
        angulo = Math.toRadians(angulo);
        resultado = Math.sin(angulo);
        return resultado;

    }

    public static double coseno(double angulo) {

        double resultado = 1;
        angulo = Math.toRadians(angulo);
        resultado = Math.cos(angulo);
        return resultado;

    }

    public static double tangente(double angulo) {

        double resultado = 1;
        angulo = Math.toRadians(angulo);
        resultado = Math.tan(angulo);
        return resultado;

    }

    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);
        String nombre[] = {"sumar", "multiplicar"};
        double[] valoresComplejos;
        double valorSimple1 = 0;
        double valorSimple2 = 0;
        byte opcion = 0;
        int indice = 0;
        boolean input = false;
        boolean input2 = false;

        while(!input) {

            try {

                System.out.println("Seleccione la operacion que desea realizar \n 1 para sumas y restas \n 2 para multiplicacion \n 3 para division \n 4 para logaritmo \n 5 para logaritmo natural \n 6 para calcular un porcentaje \n 7 para una raiz \n 8 para elevar un numero a un exponente \n 9 para usar funcion exponencial \n 10 para usar seno \n 11 para coseno \n 12 para tangente");
                opcion = usuario.nextByte();

                if(opcion <= 0 || opcion >= 28) {

                    throw new IllegalArgumentException("solo puedes seleccionar una opcion entre 1 y 27");

                }

                input = true;

            } catch(InputMismatchException e) {

                System.out.println("Error: solo puedes ingresar numeros para seleccionar la opcion del menu");
                usuario.next();

            } catch(IllegalArgumentException e){

                System.out.println("Error: " + e.getMessage());

            }

        }

        if(opcion <= 2) {

            while(input) {

                try {

                    System.out.println("¿Cuantos valores deseas " + nombre[opcion - 1] + "? (Recuerda que si quieres restar algun numero en la suma debes debes poner el numero en negativo)");
                    indice = usuario.nextInt();

                    input = false;
 
                } catch(InputMismatchException e) {

                    System.out.println("Error: solo puedes ingresar numeros para determinar la cantidad de valores que quieres " + nombre[opcion - 1]);
                    usuario.next();

                }

            }
            
            valoresComplejos = new double[indice];

            while(!input) {

                try {

                    if(opcion == 1) {

                        for(int i = 0; i < indice; i++) {

                            System.out.println("Ingrese los valores que deseas " + nombre[opcion - 1]);
                            valoresComplejos[i] = usuario.nextDouble();

                        }

                    }

                    if(opcion == 2) {

                        for(int i = 0; i < indice; i++) {

                            System.out.println("Ingrese los valores que deseas " + nombre[opcion - 1]);
                            valoresComplejos[i] = usuario.nextDouble();

                        }

                    }

                    input = true;

                } catch(InputMismatchException e) {

                    System.out.println("Error: solo puedes ingresar numeros para esta operacion");
                    usuario.next();

                }

            }

            System.out.println("El resultado es " + multiplicacion(valoresComplejos));

        }

        switch(opcion) {

            case 3:
                while(!input2) {

                    try {

                        System.out.println("Ingrese el dividendo: ");
                        valorSimple1 = usuario.nextDouble();

                        System.out.println("Ingrese el divisor: ");
                        valorSimple2 = usuario.nextDouble();

                        if(valorSimple2 == 0) {

                            throw new IllegalArgumentException("el divisor no puede ser cero");

                        }

                        input2 = true;

                    } catch(InputMismatchException e) {

                        System.out.println("Error: solo puedes ingresar numeros para esta operacion");
                        usuario.next();

                    } catch(IllegalArgumentException e) {

                        System.out.println("Error: " + e.getMessage());

                    }

                }

                System.out.println("El resultado de la division de " + valorSimple1 + " entre " + valorSimple2 + " es " + division(valorSimple1, valorSimple2) + " y el residuo de la division es " + residuo(valorSimple1, valorSimple2));
                break;

                case 4:
                    while(!input2) {

                        try {

                            System.out.println("Ingrese la base que desea para el logaritmo: ");
                            valorSimple1 = usuario.nextDouble();

                            System.out.println("Ingrese el argumento que desea para el logaritmo: ");
                            valorSimple2 = usuario.nextDouble();

                            if(valorSimple1 <= 0 || valorSimple1 == 1) {

                                throw new IllegalArgumentException("la base del logaritmo debe ser positivo y diferente de uno y de cero");

                            }

                            if(valorSimple2 <= 0) {

                                throw new IllegalArgumentException("el argumento del logaritmo debe ser positivo y diferente de cero");

                            }

                            input2 = true;

                        } catch(InputMismatchException e) {

                            System.out.println("Error: solo puedes ingresar numeros para esta operacion");
                            usuario.next();

                        } catch(IllegalArgumentException e) {

                            System.out.println("Error: " + e.getMessage());

                        }

                    }

                    System.out.println("El resultado del logaritmo de " + valorSimple2 + " en base " + valorSimple1 + " es " + logaritmo(valorSimple1, valorSimple2));
                    break;

                case 5:
                    while(!input2) {

                        try {

                            System.out.println("Ingrese el valor que desea para el argumento del logaritmo: ");
                            valorSimple1 = usuario.nextDouble();

                            if(valorSimple1 <= 0) {

                                throw new IllegalArgumentException("el argumento del logaritmo debe ser positivo y diferente de cero");

                            }

                            input2 = true;

                        } catch(InputMismatchException e) {

                            System.out.println("Error: solo puedes ingresar numeros para esta operacion");
                            usuario.next();

                        } catch(IllegalArgumentException e) {

                            System.out.println("Error: " + e.getMessage());

                        }

                    }

                    System.out.println("El resultado del logaritmo natural de " + valorSimple1 + " es " + logaritmoNatural(valorSimple1));
                    break;

                case 6:
                    while(!input2) {

                        try {

                            System.out.println("Ingrese el numero al cual desea sacarle el porcentaje: ");
                            valorSimple1 = usuario.nextDouble();

                            System.out.println("Ingrese el porcentaje que desea obtener del numero, ingrese solo el numero del porcentaje SIN el signo de porcentaje: ");
                            valorSimple2 = usuario.nextDouble();

                            input2 = true;

                        } catch(InputMismatchException e) {

                            System.out.println("Error: solo puedes ingresar numeros para esta operacion");
                            usuario.next();

                        }

                    }

                    System.out.println("El " + valorSimple2 + "% de " + valorSimple1 + " es " + calcularPorcentaje(valorSimple2, valorSimple1));
                    break;

                case 7:
                    while(!input2) {

                        try {

                            System.out.println("Ingrese el indice que desee para la raiz: ");
                            valorSimple1 = usuario.nextDouble();

                            System.out.println("Ingrese el radicando que desee operar: ");
                            valorSimple2 = usuario.nextDouble();

                            if(valorSimple1 <= 0) {

                                throw new IllegalArgumentException("el indice de la raiz debe ser positivo y diferente de cero");

                            }

                            if(valorSimple2 < 0) {

                                throw new IllegalArgumentException("el indice de la raiz debe ser positivo o cero");

                            }

                            input2 = true;

                        } catch(InputMismatchException e) {

                            System.out.println("Error: solo puedes ingresar numeros para esta operacion");
                            usuario.next();

                        } catch(IllegalArgumentException e) {

                            System.out.println("Error: " + e.getMessage());

                        }

                    }

                    System.out.println("El resultado del radicando " + valorSimple2 + " con indice " + valorSimple1 + " es " + raiz(valorSimple1, valorSimple2));
                    break;

                case 8:
                    while(!input2) {

                        try {

                            System.out.println("Ingrese la base de la potencia: ");
                            valorSimple1 = usuario.nextDouble();

                            System.out.println("Ingrese el exponente de la potencia: ");
                            valorSimple2 = usuario.nextDouble();

                            input2 = true;

                        } catch(InputMismatchException e) {

                            System.out.println("Error: solo puedes ingresar numeros para esta operacion");
                            usuario.next();

                        }

                    }

                    System.out.println("El resultado de " + valorSimple1 + " elevado a la " + valorSimple2 + " es " + potenciacion(valorSimple1, valorSimple2));
                    break;

                case 9:
                    while(!input2) {

                        try {

                            System.out.println("Ingrese el exponente que desee: ");
                            valorSimple1 = usuario.nextDouble();

                            input2 = true;

                        } catch(InputMismatchException e) {

                            System.out.println("Error: solo puede ingresar numeros para esta operacion");
                            usuario.next();

                        }

                    }

                    System.out.println("El resultado de Euler al exponente " + valorSimple1 + " es " + exponencial(valorSimple1));
                    break;

                case 10: 
                    while(!input2) {

                        try {

                            System.out.println("Ingrese el angulo del argumento del seno en grados: ");
                            valorSimple1 = usuario.nextDouble();

                            input2 = true;

                        } catch(InputMismatchException e) {

                            System.out.println("Error: solo puede ingresar numeros para esta operacion");
                            usuario.next();

                        }

                    }

                    System.out.println("El resultado del seno de " + valorSimple1 + "° es " + seno(valorSimple1));
                    break;

                case 11:
                    while(!input2) {

                        try {

                            System.out.println("Ingrese el angulo del argumento del coseno en grados: ");
                            valorSimple1 = usuario.nextDouble();
    
                            input2 = true;

                        } catch(InputMismatchException e) {

                            System.out.println("Error: solo puede ingresar numeros para esta operacion");
                            break;

                        }

                    }

                    System.out.println("El resultado del coseno de " + valorSimple1 + "° es " + coseno(valorSimple1));
                    break;

                case 12:
                    while(!input2) {

                        try {

                            System.out.println("Ingrese el angulo que desea para el argumento de la tangente: ");
                            valorSimple1 = usuario.nextDouble();

                            valorSimple2 = valorSimple1 % 360;

                            if(valorSimple2 < 0) {

                                valorSimple2 += 360;

                            }

                            if(valorSimple2 == 90 || valorSimple2 == 270) {

                                throw new IllegalArgumentException("el argumento de la tangente no esta definido para angulos donde el coseno del argumento es igual a cero");

                            }

                            input2 = true;

                        } catch(InputMismatchException e) {

                            System.out.println("Error: solo puedes ingresar numeros para esta operacion");
                            usuario.next();

                        } catch(IllegalArgumentException e) {

                            System.out.println("Error: " + e.getMessage());

                        }

                    }

                    System.out.println("El resultado de tangente de " + valorSimple1 + "° es " + tangente(valorSimple2));
                    break;

        }

        usuario.close();

    }
    
}