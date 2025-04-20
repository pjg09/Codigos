using estudiantes_interfaces_polimorfismo.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace estudiantes_interfaces_polimorfismo.Clases
{
    internal abstract class Estudiante : ISerEstudiante
    {
        internal string nombre;
        
        public Estudiante(string nombre)
        {
            this.nombre = nombre;
        }

        public void Estudiar()
        {
            Console.WriteLine($"{nombre} está estudiando...");
        }

        public void Exponer(string tema)
        {
            Console.WriteLine($"{nombre} está exponiendo sobre {tema}...");
        }

        public virtual string PresentarPrueba(string tema)
        {
            if (new Random().Next(0, 5) < 3)
                return $"Perdió la prueba de {tema}";
            else
                return $"Ganó la prueba de {tema}";
        }
    }
}