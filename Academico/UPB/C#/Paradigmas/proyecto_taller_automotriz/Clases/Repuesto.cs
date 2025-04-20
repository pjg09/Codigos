using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_taller_automotriz.Clases
{
    internal class Repuesto
    {
        private string nombre;
        private string proveedor;
        private DateTime fecha_compra;
        private uint valor;

        public Repuesto(string nombre, string proveedor, uint valor)
        {
            this.Nombre = nombre;
            this.Proveedor = proveedor;
            this.Valor = valor;
            fecha_compra = DateTime.Now;

        }

        public string Nombre { get => nombre; set => nombre = value; }
        public string Proveedor { get => proveedor; set => proveedor = value; }
        public DateTime Fecha_compra { get => fecha_compra; set => fecha_compra = value; }
        public uint Valor { get => valor; set => valor = value; }
    }
}
