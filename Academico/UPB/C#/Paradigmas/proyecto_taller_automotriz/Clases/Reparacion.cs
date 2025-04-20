using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_taller_automotriz.Clases
{
    internal class Reparacion
    {
        private Carro carro;
        private DateTime fecha;
        private List<Repuesto> l_repuesto;
        private List<Mecanico> l_mecanicos;
        private uint valor_reparacion;
        private bool factura, pagada;
        private static uint id = 0;

        public Reparacion(uint valor_reparacion)
        {
            this.Valor_reparacion = valor_reparacion;
            id += 1;
            factura = false;
            pagada = false;
            fecha = DateTime.Now;
        }

        internal Carro Carro { get => carro; set => carro = value; }
        public DateTime Fecha { get => fecha; set => fecha = value; }
        internal List<Repuesto> L_repuesto { get => l_repuesto; set => l_repuesto = value; }
        internal List<Mecanico> L_mecanicos { get => l_mecanicos; set => l_mecanicos = value; }
        public uint Valor_reparacion { get => valor_reparacion; set => valor_reparacion = value; }
        public bool Factura { get => factura; set => factura = value; }
        public bool Pagada { get => pagada; set => pagada = value; }
        public static uint Id { get => id; set => id = value; }

        public void facturaImpresa()
        {

            factura = true;

        }
    }
}
