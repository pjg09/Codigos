using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_parque.Clases
{
    internal class Manilla
    {

        //Atributos
        private static uint id = 100000;  
        private uint saldo_puntos;

        //Constructor
        public Manilla()
        {

            id += 1;
            saldo_puntos = 0;

        }

        //Accesores
        public uint Id { get => id; }

        public uint Saldo { get => saldo_puntos; }

        //Metodos
        internal void RestarSaldo(byte puntos) 
        {
        
            try
            {

                saldo_puntos -= puntos;

            } catch (Exception ex)
            {

                throw new Exception($"Excepción no esperada en el método actualizar saldo {ex.Message}");

            }
        
        }

    }
}
