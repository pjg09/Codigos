using Lamparas.Clases;

namespace Lamparas
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Lampara lampara1 = new Lampara(Lampara.lista_colores.Negro, Lampara.lista_tipoBombilla.LED, "Lamparas Victus", 110, 600000, 3);

            Console.WriteLine(lampara1.ToString() + "\n");
            Console.WriteLine(lampara1.CambiarBombillo(800000) + "\n");
            Console.WriteLine(lampara1.CambiarCable(2) + "\n");
            Console.WriteLine(lampara1.AsignarTablero("ABCDEFGHIJK") + "\n");
            Console.WriteLine(lampara1.ToString());
        }
    }
}
