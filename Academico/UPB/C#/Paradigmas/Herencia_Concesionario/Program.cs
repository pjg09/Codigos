using Herencia_Concesionario.Clases;

namespace Herencia_Concesionario
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Creando el concesionario
            Concesionario auto_jaramillo = new Concesionario("Autos JaramilloRamirez", "Carrera 13 # 66 - 99");

            Persona garcia = new Vendedor("Garcia Garcia", "123456", 0.02f);
            Persona bitas = new Cliente("Bitas Peli Blanco", "456789", 0.025f);

            List<Persona> l_personas = new List<Persona>();
            l_personas.Add(garcia);
            l_personas.Add(bitas);

            Taxi taxi = new Taxi("123456", "Toyota", "Corolla", 2026, 1600, 5, Automovil.l_nro_puertas.p5, "locoporlacola", "Tax Alternos");

            Venta venta1 = new Venta(l_personas, taxi, 150000000);

            Console.WriteLine(auto_jaramillo.VenderAutomovil(taxi, l_personas, 150000000));

            Console.WriteLine(venta1);

            Console.WriteLine("hola");
        }
    }
}
