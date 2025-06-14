﻿using p_bicibleta.Clases;

namespace p_bicibleta
{
    internal class Program
    {
        static void Main(string[] args)
        {

            try
            {

                //Instanciar un objeto de la clase Bicicleta

                //Constructor universal creando un objeto en memoria de esa clase (bicicleta)
                Bicicleta bici1 = new Bicicleta();

                bici1.Tam_marco = Bicicleta.l_tam_marco.L;
                bici1.Tam_llanta = 17.2F;
                bici1.Material = Bicicleta.l_materiales.Titanio;
                bici1.Cant_cambios = 5;
                bici1.Color = Bicicleta.l_colores.Negro;
                    
                //Instanciar objeto con constructor parametrizado
                Bicicleta bici2 = new(Bicicleta.l_tam_marco.M, Bicicleta.l_materiales.Carbono, Bicicleta.l_colores.Gris, 7, 16.5F);

                Bicicleta bici3 = new Bicicleta();

                Console.WriteLine(bici1.GetHashCode());
                Console.WriteLine(bici2.GetHashCode());

                bici1.Rodar();
                bici1.Subir_cambio();
                Console.WriteLine(bici1.Cambio_actual);
                Console.WriteLine(bici1.En_movimiento);

                bici2.Rodar();
                Console.WriteLine(bici2.Cambio_actual);
                Console.WriteLine(bici2.En_movimiento);

            }
             catch (Exception ex)
            {

                Console.WriteLine(ex.ToString());

            }

        }
    }
}
