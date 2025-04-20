using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_parque.Clases
{
    internal class Taquilla
    {

        //Atributos de usuario
        private byte id;

        //Atributos de estado
        private List<Manilla> lista_manillas;
        private ulong saldo;

        //Atributos de validacion
        private readonly byte cantidad_manillas = 100;
        private readonly ushort monto_minimo = 20000, montosxpunto = 500, valor_entrada = 4000;

        //Constructor
        public Taquilla (byte id)
        {

            this.id = id;
            lista_manillas = new List<Manilla>();
            saldo = 0;

        }

        //Accesores
        public byte Id { get => id;
            set => id = value == 1 || value == 2 || value == 3 ? value : throw new Exception($"El ID {value} no es un ID válido de taquilla"); } //Corregir el quemado

        public ulong Saldo { get => saldo; set => saldo = value; }

        internal List<Manilla> Lista_manillas { get => lista_manillas;
            set => lista_manillas = value.Count == cantidad_manillas ? value : throw new Exception($"La cantidad de manillas {value.Count} no es válida"); }

        //Metodos
        public Manilla VenderManilla(ulong monto)
        {

            try
            {
                //0. Verificar que hallan manillas disponibles para la venta
                //1. Verifico el monto, debe ser exacto, multiplos de 500 para no dar devuelta
                //2. Calculo los puntos para el monto descontando la entrada
                //3. Agrego los puntos a la manilla
                //4. Devuelvo la manilla
            }
            catch (Exception e)
            {

                throw new Exception($"Ocurrio excepción en VenderManilla\n {e.ToString}");

            }

        }

        //metodo que recargue la manilla, devuelve un booleano, recibe un monto, no descuenta la entrada

    }
}
