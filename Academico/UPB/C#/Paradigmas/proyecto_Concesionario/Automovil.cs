using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace proyecto_Concesionario
{
    public class Automovil
    {

        //Atributos
        private string marca;
        private string modelo;
        private ulong precio;
        private string placa;

        //Constructor universal
        public Automovil(string marca, string modelo, ulong precio, string placa)
        {
            this.Marca = marca;
            this.Modelo = modelo;
            this.Precio = precio;
            this.Placa = placa;
        }

        //Accesores
        public string Marca { get => marca; set => marca = value; }
        public string Modelo { get => modelo; set => modelo = value; }
        public ulong Precio { get => precio; set => precio = value; }
        public string Placa { get => placa; set => placa = value; }
    }
}