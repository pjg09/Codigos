using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_taller_automotriz.Clases
{
    internal class Cliente
    {
        private static ushort id = 0;
        private string nombre;
        private uint telefono;
        private bool credito;
        private ulong saldo_deuda;

        public Cliente(string nombre, uint telefono, bool credito)
        {
            this.Nombre = nombre;
            this.Telefono = telefono;
            this.Credito = credito;

            id += 1;

            saldo_deuda = 0;
        }

        public string Nombre { get => nombre; set => nombre = value; }
        public uint Telefono { get => telefono; set => telefono = value; }
        public bool Credito { get => credito; set => credito = value; }
    }
}
