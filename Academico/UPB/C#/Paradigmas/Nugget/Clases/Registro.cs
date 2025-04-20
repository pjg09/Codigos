using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Nugget.Eventos;

namespace Nugget.Clases
{
    internal class Registro
    {
        //Atributos de validacion
        internal readonly float p1 = 0.3f, p2 = 0.2f, p3 = 0.35f, p4 = 0.15f;

        //Atributos de estado
        internal float nota_final;

        //Atributo para suscribirme al Publisher
        internal Publisher_Becas publicador_becas;

        //Constructor universal
        public Registro() { }

        //Método para manejar los eventos, qué es obligatorio cuando me estoy suscribiendo
        internal void EventHandler() { }

        //Métodos
        internal float CalcularNotaFinal(float n1, float n2, float n3, float n4)
        {
            try
            {
                nota_final = 0;

                if (n1 >= 0 && n1 <= 5 && n2 >= 0 && n2 <= 5 && n3 >= 0 && n3 <= 5 && n4 >= 0 && n4 <= 5)
                {
                    nota_final = (n1 * p1) + (n2 * p2) + (n3 * p3) + (n4 * p4);

                    //Instanciamos la clase publisher para poder usar el atributo de tipo publisher de esta clase
                    publicador_becas = new Publisher_Becas();

                    //Me suscribo al evento que necesito del Publisher
                    //Gracias a la suscripción, la validación en el evento del Publisher será true
                    publicador_becas.evento_beca += EventHandler;

                    //Invocamos los métodos asociados a los eventos
                    publicador_becas.InformarBecaExcelencia(nota_final);
                    publicador_becas.InformarBecaSuperior(nota_final);

                    publicador_becas.evento_beca -= EventHandler;

                    return nota_final;
                } else
                {
                    throw new Exception("Error: Revise las notas");
                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.ToString());
            }
        }
    }
}