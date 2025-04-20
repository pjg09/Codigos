using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Herencia_Concesionario.Clases
{
    internal class Venta
    {
        private List<Persona> l_personas;
        private Automovil automovil;
        private ulong valor;
        private DateTime fecha;

        //Atributos de validacion
        private byte cont_cliente = 0, cont_vendedores = 0;
        private readonly ulong valor_minimo = 60000000;

        public Venta(List<Persona> l_personas, Automovil automovil, ulong valor)
        {
            this.L_personas = l_personas;
            this.Automovil = automovil;
            this.Valor = valor;
            fecha = DateTime.Now;
        }

        public ulong Valor { get => Valor;
            set => valor = value >= valor_minimo ? value : throw new Exception("Error: El valor minimo de la venta debe ser de 60.000.000"); }

        public List<Persona> L_personas { get => l_personas;
            set {
                foreach (Persona p in value)
                {
                    if (p is Vendedor)
                        cont_vendedores++;
                    else if (p is Cliente)
                        cont_cliente++;
                }

                if (value.Count < 2 || cont_vendedores != 1 || cont_cliente != 1)
                    throw new Exception("Debe haber al menos dos personas en la venta");
                else
                    l_personas = value;
            } 
        }
        public Automovil Automovil { get => automovil; set => automovil = value; }

        public override string ToString()
        {
            return $"Se vendió un {automovil} por un valor de {valor}, el vendedor fue {l_personas[0]} y el comprador fue {l_personas[1]}";
        }
    }
}
