using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p_lamparas
{
    internal class Lampara
    {

        //Enums
        public enum lista_colores {Negro, Cromo, Rojo};
        public enum lista_voltajes {V110, V220};
        public enum lista_tipos_bombillas {Halogena, LED};

        //Atributos de usuario
        private lista_colores color;
        private lista_voltajes voltaje;
        private lista_tipos_bombillas tipo_bombilla;
        private string marca, codigo_tablero;
        private int duracion;
        private float longitud_cable;

        //Atributos reglas de negocio
        private const int duracion_minima = 500000, duracion_maxima = 1000000;
        private const float longitud_cable_minima = 1.5F, longitud_cable_maximo = 4.5F;

        //Atributos de metodos
        private bool encendida = false;

        //Constructor Universal
        public Lampara() { }

        //Accesores
        public string Marca { get => marca;

            set
            {
                if (value.Length < 6 || string.IsNullOrWhiteSpace(value))
                    throw new Exception("Error, la marca debe contener más de 6 carácteres y no debe estar vacía");
                else
                    marca = value.ToUpper();

            } 
        }

        public int Duracion { get => duracion;
            
            set
            {
                if (value < duracion_maxima || value > duracion_maxima)
                    throw new Exception("Error, la duración debe estar entre 500.000 y 1.000.000");

                else
                    duracion = value;

            } 
        }

        public float Longitud_cable { get => longitud_cable;

            set
            {
                if (value < 1.5 || value > 4.5)
                    throw new Exception("Error, la longitud del cable debe estar entre 1.5 y 4.5 metros");
                
                else
                    longitud_cable = value;
            }
        }

        public string Codigo_tablero { get => codigo_tablero;

            set
            {
                if (value.Length < 6)
                    throw new Exception("Error, el código del tablero debe ser superior a 6 caracteres");

                else
                    codigo_tablero = value;
            }
        }

        internal lista_colores Color { get => color; set => color = value; }
        internal lista_voltajes Voltaje { get => voltaje; set => voltaje = value; }
        internal lista_tipos_bombillas Tipo_bombilla { get => tipo_bombilla; set => tipo_bombilla = value; }

        //---Métodos---//

        //Consctructor universal
        public bool Encender() => !encendida ? encendida = true : encendida;
        public bool Apagar() => encendida ? encendida = false : encendida;

        public string Cambiar_Cable(float nueva_longitud)
        {

            if(encendida == false)
            {

                if (nueva_longitud < 1.5 || nueva_longitud > 4.5)
                {

                    throw new Exception("Error, la longitud del cable debe estar entre 1.5 y 4.5 metros");
                    longitud_cable = nueva_longitud;

                } else
                {

                    return "El cambio fue exitoso";

                }

            } else
            {

                return "No se pudo hacer el cambio, la lampara debe estar apagada";

            }

        } 
        public string Cambiar_Bombilla(lista_tipos_bombillas nueva_bombilla)
        {

            if (encendida == false)
            {

                if (nueva_bombilla == lista_tipos_bombillas.Halogena || nueva_bombilla == lista_tipos_bombillas.LED)
                {

                    return "El cambio fue exitoso";
                    tipo_bombilla = nueva_bombilla;

                } else
                {

                    return "No se pudo hacer el cambio, la bombilla debe ser halogena o LED";

                }

            } else
            {

                return "No se pudo hacer el cambio, la lampara debe estar apagada";

            }

        }
    }
}
