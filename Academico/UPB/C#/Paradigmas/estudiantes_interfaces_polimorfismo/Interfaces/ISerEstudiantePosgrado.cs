using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace estudiantes_interfaces_polimorfismo.Interfaces
{
    internal interface ISerEstudiantePosgrado
    {
        void EscribirTesis(string tema);
        bool SustentarTesis(DateTime hora);
    }
}
