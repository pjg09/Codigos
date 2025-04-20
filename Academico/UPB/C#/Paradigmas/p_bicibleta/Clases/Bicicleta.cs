using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace p_bicibleta.Clases
{
    internal class Bicicleta
    {
        //Los enum van a manejar las restricciones en algunos atributos
        public enum l_tam_marco {S, M, L, XL};
        public enum l_materiales {Carbono, Aluminio, Titanio};
        public enum l_colores {Negro, Blanco, Gris};

        //Cuando tengo los enum listos declaro los atributos en base a las restricciones declaradas por los enum
        //Atributos de usuario
        private l_tam_marco tam_marco;
        private l_materiales material;
        private l_colores color;
        private byte cant_cambios;
        private float tam_llanta;

        //Atributos de reglas de negocio
        private const byte camb_min = 1, camb_max = 20, cant_cam_min = 0;
        private const float tam_ll_min = 16, tam_ll_max = 18.5f;

        //Atributos de estado
        private byte cambio_actual = 1;
        private bool en_movimiento = false;

        //---Métodos---//

        //Accesores

        //Accesor con condicionales tradicionales
        /*public float Tam_llanta { get => tam_llanta;
        
            set {  
                
                if (value < tam_ll_min || value > tam_ll_max)
                    throw new Exception("El tamaño de la llanta no es válido");
                else
                    tam_llanta = value;
                        
                }
        
        }*/

        //Accesor con lambda y ternarios (codificación funcional)
        public float Tam_llanta
        {

            get => tam_llanta;
            set { tam_llanta = value < tam_ll_min || value > tam_ll_max ? throw new Exception("El tamaño de la llanata no es válido") : value; }

        }

        public byte Cant_cambios { get => cant_cambios;

            set
            {

                if (value < cant_cam_min || value > camb_max)
                    throw new Exception("La cantidad de cambios no es válida");
                else
                    cant_cambios = value;

            }

        }

        public byte Cambio_actual { get => cambio_actual; set => cambio_actual = value; }
        public bool En_movimiento { get => en_movimiento; set => en_movimiento = value; }

        internal l_tam_marco Tam_marco { get => tam_marco; set => tam_marco = value; }
        internal l_materiales Material { get => material; set => material = value; }
        internal l_colores Color { get => color; set => color = value; }

        //Consttuctor universal
        public Bicicleta() { } 

        //Constructor con parametros
        public Bicicleta(l_tam_marco tam_marco, l_materiales material, l_colores color, byte cant_cambios, float tam_llanta) 
        {
            Tam_marco = tam_marco;
            Material = material;
            Color = color;
            Cant_cambios = cant_cambios;
            Tam_llanta = tam_llanta;
        }

        //Otro constructor con parametros
        public Bicicleta(l_materiales material, l_colores color)
        {
            this.Material = material;
            this.Color = color;
        }



        //Metodos

        //Manera tradicional

        /*

        public void Subir_cambio()
        {

            try
            {

                if (cambio_actual < cant_cambios) cambio_actual++;

            }
            catch (Exception e)
            {
        
                throw new Exception("Error en el metodo de subir cambio");

            }

        }

        */

        //Podemos hacerlo de otra forma mediante funciones lambda, con lambda no podemos usar void

        //Manera funcional

        public byte Subir_cambio() => Cambio_actual < camb_max && En_movimiento ? Cambio_actual++ : Cambio_actual;
        public byte Bajar_cambio() => Cambio_actual > camb_min && En_movimiento ? Cambio_actual-- : Cambio_actual;
        public bool Rodar() => !En_movimiento ? En_movimiento = true : En_movimiento;
        public bool Frenar() => En_movimiento ? En_movimiento = false : En_movimiento;

    }
}
