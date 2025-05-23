package gosones;

public class funciones {

    public static double CalcularValorInventario (int [] inventario, double [] precios) {

        double valorInventario = 0;

        for (int i = 0; i < inventario.length; i++) {

            valorInventario += inventario[i] * precios[i];

        }

        return valorInventario;

    }

    public static void main(String[] args) {
        
        int [] inventario = {5, 2, 10, 4, 5};
        double [] precios = {25500, 109800, 45600, 77777, 59900};
        double valorInventario = CalcularValorInventario(inventario, precios);

        System.out.println("El valor del inventario es: " + valorInventario);

    }
    
}