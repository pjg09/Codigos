using proyecto_parque.Clases;

namespace proyecto_parque
{
    internal class Program
    {
        static void Main(string[] args)
        {
            try
            {

                Atraccion hulk = new Atraccion("El Hulk", new TimeSpan(0, 1, 30), 22);
                Manilla manilla = new Manilla();
                Registro registro_prueba;
                Console.WriteLine("aa");
                

            }catch (Exception EX)
            {

                Console.WriteLine(EX.ToString());

            }

        }
    }
}
