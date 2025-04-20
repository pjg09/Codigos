using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Herencia_Concesionario.Clases
{
    public class Concesionario
    {
        private List<Venta> l_ventas;
        private string nombre, direccion;

        //Atributos de usuario
        private readonly byte longitud_minima_nombre = 5, longitud_minima_direccion = 10;

        public Concesionario(string nombre, string direccion)
        {
            this.Nombre = nombre;
            this.Direccion = direccion;
            l_ventas = new List<Venta>();
        }

        public string Nombre { get => nombre; 
            set => nombre = !(string.IsNullOrEmpty(value)) || !(string.IsNullOrWhiteSpace(value)) || value.Length >= longitud_minima_nombre ? value : throw new Exception($"Error: la longitud minima del nombre debe ser de {longitud_minima_nombre} caracteres"); }
        public string Direccion { get => direccion; 
            set => direccion = !(string.IsNullOrEmpty(value)) || !(string.IsNullOrWhiteSpace(value)) || value.Length >= longitud_minima_direccion ? value : throw new Exception($"Error: la longitud minima de la dirección debe ser de {longitud_minima_direccion} caracteres"); }

        public bool VenderAutomovil(Automovil auto, List<Persona> l_personas, ulong valor)
        {
            try
            {
                l_ventas.Add(new Venta(l_personas, auto, valor));
                return true;
            }
            catch (Exception ex)
            {
                return false;
            }
        }
    }
}
