using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_parque.Clases
{
    internal class Registro
    {

        //Atributos
        private Manilla manilla;
        private DateTime fecha_hora;
        private Atraccion atraccion;

        public Registro(Manilla manilla, Atraccion atraccion)
        {

            this.manilla = manilla;
            fecha_hora = DateTime.Now;
            this.atraccion = atraccion;

        }

        public DateTime Fecha_hora { get => fecha_hora; }
        internal Manilla Manilla { get => manilla; }
        internal Atraccion Atraccion { get => atraccion; }
    }
}
