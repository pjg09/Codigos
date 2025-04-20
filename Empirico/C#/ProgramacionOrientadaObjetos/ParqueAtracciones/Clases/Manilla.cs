using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ParqueAtracciones.Clases
{
    internal class Manilla
    {
        private static uint id = 0;

        //Atributos de métodos
        private uint saldo_puntos;

        //Constructor universal
        public Manilla()
        {
            id++;
            saldo_puntos = 0;
        }

        //Accesores
        public uint ID { get => id; }

        public uint Saldo_Puntos { get => saldo_puntos; }
    }
}
