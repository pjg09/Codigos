using Aspectos_Operaciones_BasesDeDatos.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Aspectos_Operaciones_BasesDeDatos.Clases
{
    public class OperarBaseDeDatosMicrosoft : IOperacionesBaseDeDatos
    {
        //Constructor generico
        public OperarBaseDeDatosMicrosoft() { }

        //Metodos
        public void Crear()
        {
            Console.WriteLine("Usando base de datos Microsoft...\nValidando los datos del usuario...\nValidando la integridad...\nDatos creados correctamente");
        }

        public void Leer()
        {
            Console.WriteLine("Usando base de datos Microsoft...\nValidando los datos del usuario...\nDevolviendo los datos");
        }

        public void Actualizar()
        {
            Console.WriteLine("Usando base de datos Microsoft...\nValidando los datos del usuario...\nValidando la integridad de los nuevos datos...\nDatos actualizados correctamente");
        }

        public void Eliminar()
        {
            Console.WriteLine("Usando base de datos Microsoft...\nValidando los datos del usuario...\nBuscando registro a eliminar...\nDatos eliminados correctamente");
        }
    }
}
