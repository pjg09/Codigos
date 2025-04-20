using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_taller_automotriz.Clases
{
    internal class Taller
    {
        private string nombre, factura;
        private static uint con_factura = 0;
        private List<Reparacion> l_reparacion;
        private ulong[][] historico = null;
        private uint monto, devuelta;


        public Taller (string nombre)
        {
            this.Nombre = nombre;
            con_factura += 1;
        }

        public string Nombre { get => nombre; set => nombre = value; }
        public static uint Con_factura { get => con_factura; set => con_factura = value; }
        internal List<Reparacion> Reparacion { get => l_reparacion; set => l_reparacion = value; }
        public ulong[][] Historico { get => historico; set => historico = value; }

        public string ImprimirFactura(Cliente cliente, Carro carro, Reparacion reparacion)
        {
            try
            {
                //Cliente, mecanico, carro, valor y fecha
                factura = $"Consecutivo de la factura: {con_factura}";
                factura += $"Nombre del cliente: {cliente.Nombre}";
                factura += $"Carro del cliente: {carro}";
                factura += $"Valor de la factura: {reparacion.Valor_reparacion}";
                factura += $"Fecha de la reparacion: {reparacion.Fecha}";

                //facturaImpresa();

                return factura ;
            }
            catch (Exception ex)
            {
                return $"Error en Imprimir Factura {ex}";
            }
        }

        public void PagarReparacion(Reparacion reparacion)
        {
            try
            {
                if (monto >= reparacion.Valor_reparacion)
                {
                    devuelta = (monto - reparacion.Valor_reparacion);
                }
                else
                    Console.WriteLine("El valor registrado no es valido");

            }
            catch (Exception ex) 
            {
                Console.WriteLine ($"Error {ex}");
            }
        }

        public void OrdenarReparacion()
        {

        }
    }
}
