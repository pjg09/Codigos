using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_taller_automotriz.Clases
{
    internal class Carro
    {
        private string placa, marca, modelo;
        private ushort año;
        private Cliente dueño_carro;

        public Carro(string placa, string marca, string modelo, ushort año)
        {
            this.Placa = placa;
            this.Marca = marca;
            this.Modelo = modelo;
            this.Año = año;
        }

        public string Placa { get => placa; set => placa = value; }
        public string Marca { get => marca; set => marca = value; }
        public string Modelo { get => modelo; set => modelo = value; }
        public ushort Año { get => año; set => año = value; }
        internal Cliente Dueño_carro { get => dueño_carro; set => dueño_carro = value; }
    }
}
