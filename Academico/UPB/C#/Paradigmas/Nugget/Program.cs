using Nugget.Clases;
using Nugget.Eventos;

try
{
    Registro registro = new Registro();

    Console.WriteLine($"La nota final de Jaramillo es: {registro.CalcularNotaFinal(5, 5, 5, 5)}");

}
catch (Exception ex)
{
    Console.WriteLine(ex.ToString());
}