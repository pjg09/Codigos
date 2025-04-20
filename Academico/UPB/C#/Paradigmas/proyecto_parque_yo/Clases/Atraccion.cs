using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto_parque_yo.Clases
{
    internal class Atraccion
    {
        //Atributos de usuario
        private string nombre;
        private TimeSpan duracion;
        private byte puntos;

        //Atributos de reglas de negocio
        private readonly byte longitud_minima_nombre = 1, longitud_maxima_nombre = 85, puntos_minimos = 10, puntos_maximos = 25;
        private readonly TimeSpan duracion_minima = new TimeSpan(0, 1, 0), duracion_maxima = new TimeSpan(0, 5, 0);
    }
}
