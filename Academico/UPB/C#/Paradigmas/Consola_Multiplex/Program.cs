using biblioteca_multiplex;
using biblioteca_multiplex.Clases;

namespace Consola_Multiplex
{
    internal class Program
    {
        static void Main(string[] args)
        {
            try
            {
                Taquillero taquillero1 = new Taquillero("Jaramillo", 19998887, 3013081357);
                Pelicula cap_ame = new Pelicula("Captain America", "Capitan America", new TimeSpan(14, 0, 0), 15);
                Sala sala1 = new Sala(1, 30, 60);
                Funcion f1 = new Funcion(sala1, cap_ame, new DateTime(2025, 3, 27, 2, 0, 0));
                Taquilla t1 = new Taquilla(1, taquillero1);
                Multiplex unicentro = new Multiplex("Unicentro");
                Socio socio1 = new Socio("Carolina", 1038868548, 3052100012);

                Console.WriteLine(t1.Vender_boleta(f1, 6, Multiplex.tipo_sillas.V, socio1));
            }
            catch (Exception err) 
            {
                Console.WriteLine(err.ToString());
            }
        }
    }
}
