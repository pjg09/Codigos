using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_parque.Clases
{
    internal class Parque
    {
        //Atributos de usuario
        private string nombre;
        private List<Atraccion> lista_atracciones;

        //Atributos de estado
        private bool abierto;
        private List<Taquilla> lista_taquillas;
        internal static List<Registro> lista_registros;
        private List<Manilla> lista_manillas;

        //Atributos de validación
        private readonly byte longitud_minima = 5, cantidad_atracciones = 10, cantidad_taquillas = 3, cantidad_manillas_enviar = 100;
        private readonly ushort cantidad_manillas = 1000;

        //Atributos de métodos


        //Constructor universal
        public Parque(string nombre, List<Atraccion> lista_atracciones)
        {

            this.Nombre = nombre;
            abierto = true;
            lista_atracciones = lista_atracciones;
            lista_registros = new List<Registro>();

            for(byte i = 1; i <= cantidad_manillas; i++)
            {
                lista_manillas.Add(new Manilla());
            }

            for (byte i = 1; i <= cantidad_taquillas; i++)
            {
                lista_taquillas.Add(new Taquilla(i));
                EnviarManillas(lista_taquillas.Find(taquilla => taquilla.Id == i));
                //EnviarManillas(lista_taquillas[length - 1]);
            }

        }

        //Accesores
        public string Nombre
        {

            get => nombre;
            set => nombre = !(String.IsNullOrEmpty(value) || String.IsNullOrWhiteSpace(value) || value.Length < longitud_minima) ? value : throw new Exception($"El nombre {value} no es válido");

        }
        internal List<Atraccion> Lista_atracciones { get => lista_atracciones;
            set => lista_atracciones = value.Count == cantidad_atracciones ? value : throw new Exception($"La lista de atracciones no cumple con el tamaño, deben ser {cantidad_atracciones}, y su lista tenia {value.Count}"); }

        //Metodos
        public bool EnviarManillas(Taquilla taquilla)
        {

            try
            {

                if (lista_manillas.Count >= cantidad_manillas_enviar && taquilla.Lista_manillas.Count == 0)
                {

                    for (byte i = 1; i <= cantidad_manillas_enviar; i++)
                    {

                        taquilla.Lista_manillas.Add(lista_manillas[0]);
                        lista_manillas.RemoveAt(0);

                    }

                    return true;

                }

                else return false;

            } catch (Exception ex)
            {

                throw new Exception($"Ocurrio un error no esperado en enviar manillas \n{ex}");

            }

        }

    }
}