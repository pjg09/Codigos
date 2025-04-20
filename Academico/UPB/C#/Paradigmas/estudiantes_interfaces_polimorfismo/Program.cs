using estudiantes_interfaces_polimorfismo.Clases;
using System.Security.Cryptography.X509Certificates;

namespace estudiantes_interfaces_polimorfismo
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Posgrado jaramillo = new Posgrado("Jaramillo", "Maestría en sexo");

            jaramillo.Estudiar();
            jaramillo.Exponer("Como culiar rico en la U");
            jaramillo.EscribirTesis("Tesis sobre los productos de Juanagogo");
            Console.WriteLine($"{jaramillo.nombre} sustentó la tesis y ganó? {jaramillo.SustentarTesis(new DateTime(2025, 12, 1))}");

            Console.WriteLine(jaramillo);

        }
    }
}