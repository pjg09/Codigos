using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aspectos_Operaciones_BasesDeDatos.Interfaces
{
    public interface IOperacionesBaseDeDatos
    {
        void Crear();
        void Leer();
        void Actualizar();
        void Eliminar();
    }
}
