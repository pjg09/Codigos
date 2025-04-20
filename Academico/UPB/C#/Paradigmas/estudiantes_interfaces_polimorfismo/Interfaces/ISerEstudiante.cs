using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace estudiantes_interfaces_polimorfismo.Interfaces
{
    internal interface ISerEstudiante
    {
        void Estudiar();
        void Exponer(string tema);
        string PresentarPrueba(string prueba);
    }
}
