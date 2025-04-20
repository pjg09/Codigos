using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_parque_yo.Clases
{
    internal class Parque
    {
        //Atributos de usuario
        private string nombre;

        //Atributos de estado
        private List<Atraccion> lista_atracciones;
        private List<Taquilla> lista_taquillas;
        private List<Registro> lista_registros;
        private List<Manilla> lista_manillas;
        private bool abierto;

        //Atributos de reglas de negocio
        private readonly byte longitud_minima_nombre = 1, longitud_maxima_nombre = 85, longitud_lista_atracciones = 10, longitud_lista_taquillas = 3;
        private readonly ushort longitud_maxima_lista_taquillas = 1000;
    }
}
