using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_parque.Clases
{
    internal class Atraccion
    {

        //Atributos de usuario
        private string nombre;
        private TimeSpan duracion;
        private byte puntos_ingresar;

        //Atributos de reglas de negocio (validacion, restricciones, etc.)
        private readonly byte puntos_minimos = 10, puntos_maximos = 25, longitud_minima = 5;
        TimeSpan duracion_minima = new TimeSpan(0, 1, 0), duracion_maxima = new TimeSpan(0, 5, 0);

        //Constructor
        public Atraccion(string nombre, TimeSpan duracion, byte puntos_ingresar)
        {

            Nombre = nombre;
            Duracion = duracion;
            Puntos_ingresar = puntos_ingresar;

        }

        //Accesores
        public string Nombre
        {
            get => nombre;
            set => nombre = !(String.IsNullOrEmpty(value)) || String.IsNullOrWhiteSpace(value) || value.Length < longitud_minima) ? value : throw new Exception($"El nombre {value} no es válido");
        }

        public byte Puntos_ingresar
        {
            get => puntos_ingresar;
            set => puntos_ingresar = value >= puntos_minimos && value <= puntos_maximos ? value : throw new Exception($"Los puntos {value} no son válidos");
        }

        public TimeSpan Duracion
        {
            get => duracion;
            set => duracion = value >= duracion_minima && value <= duracion_maxima ? value : throw new Exception($"La duracion {value} no es válida");
        }

        //Metodos
        public string RegistrarIngreso(Manilla manilla)
        {

            try
            {
                
                //1. Validar que la manilla si tenga los puntos suficientes para entrar a la atracción.
                if (manilla.Saldo >= puntos_ingresar)
                {

                    manilla.RestarSaldo(puntos_ingresar);
                    Parque.lista_registros.Add(new Registro(manilla, this));
                    return ($"Ingreso aceptado, le queda de saldo {manilla.Saldo}");

                } else
                {

                    return ($"Ingreso rechazado, su saldo es {manilla.Saldo} puntos y para ingresar necesita {puntos_ingresar} puntos");

                }

            }
            catch (Exception ex)
            {

                throw new Exception("Ocurrió un error en registrar ingreso \n" + ex.ToString());

            }

        }
    }
}