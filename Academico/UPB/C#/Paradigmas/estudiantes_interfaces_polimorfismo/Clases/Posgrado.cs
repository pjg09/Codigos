using estudiantes_interfaces_polimorfismo.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace estudiantes_interfaces_polimorfismo.Clases
{
    internal class Posgrado : Estudiante, ISerEstudiantePosgrado
    {
        internal string carrera;
        internal bool resultado;

        public Posgrado(string nombre, string carrera) : base(nombre)
        {
            this.carrera = carrera;
        }

        public void EscribirTesis(string tema)
        {
            Console.WriteLine($"El estudiante {nombre} está escribiendo una tesis sobre {tema}...");
        }

        public bool SustentarTesis(DateTime hora)
        {
            Random numeroAleatorio = new Random();
            if (numeroAleatorio.Next(1, 9) % 2 == 0) return true;
            else return false;
        }

        public override string PresentarPrueba(string tema)
        {
            if (new Random().Next(0, 5) < 3.5)
                return $"Perdió la prueba de {tema}";
            else
                return $"Ganó la prueba de {tema}";
        }

        public override string ToString()
        {
            return $"El nombre del estudiante es {nombre} y está en el programa {carrera}";
        }
    }
}