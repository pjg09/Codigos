using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Nugget.Eventos
{
    internal class Publisher_Becas
    {
        //Delegado
        internal delegate void delegado_beca();

        //Evento(s)
        internal event delegado_beca evento_beca;

        //Atributos de validación
        float minimo_nota_superior = 4.95f, minimo_nota_excelencia = 4.7f;

        //Estas clases Publishers no llevan constructor

        //Metodo(s) que será(n) llamado(s) por lo(s) evento(s)
        public void InformarBecaSuperior(float nota)
        {
            //Verificamos que en efecto, el evento correspondiente haya sido quien haya llamado al metodo
            if (evento_beca != null)
            {
                if (nota >= minimo_nota_superior)
                {
                    Console.WriteLine("Beca Superior");
                }
            }
            else
            {
                Console.WriteLine("El método no está siendo llamado por un evento");
            }
        }

        public void InformarBecaExcelencia(float nota)
        {
            //Verificamos que en efecto, el evento correspondiente haya sido quien haya llamado al metodo
            if (evento_beca != null)
            {
                if (nota >= minimo_nota_excelencia && nota < minimo_nota_superior)
                {
                    Console.WriteLine("Beca Excelencia");
                }
            }
            else
            {
                Console.WriteLine("El método no está siendo llamado por un evento");
            }
        }
    }
}