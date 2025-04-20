using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_taller_automotriz.Clases
{
    internal class Mecanico
    {
        private static ushort id = 0;
        private string nombre;
        private uint telefono;
        private string especialidad;
        private ulong valor;

        public Mecanico(string nombre, uint telefono, string especialidad, ulong valor)
        {
            this.Nombre = nombre;
            this.Telefono = telefono;
            this.Especialidad = especialidad;
            this.Valor = valor;

            id += 1;
        }

        public string Nombre { get => nombre; set => nombre = value; }
        public uint Telefono { get => telefono; set => telefono = value; }
        public string Especialidad { get => especialidad; set => especialidad = value; }
        public ulong Valor { get => valor; set => valor = value; }
    }

}
