using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lamparas.Clases
{
    internal class Lampara
    {
        public enum lista_colores {Negro, Cromo, Rojo};
        public enum lista_tipoBombilla {Halogena, LED};

        //Atributos de usuario
        private lista_colores color;
        private lista_tipoBombilla tipoBombilla;
        private string marca;
        private byte voltaje;
        private uint duracionBombilla;
        private float longitudCable;

        //Atributos de métodos
        private bool encendida;
        private string codigoTablero;

        //Atributos de control
        private readonly byte longitudMinimaMarca = 6, longitudMinimaCodigoTablero = 6;
        private readonly uint duracionMinimaBombilla = 500000, duracionMaximaBombilla = 1000000;
        private readonly float longitudMinimaCable = 1.5F, longitudMaximaCable = 4.5F;

        //Constructor principal
        public Lampara(lista_colores color, lista_tipoBombilla tipoBombilla, string marca, byte voltaje, uint duracionBombilla, float longitudCable)
        {
            this.Color = color;
            this.TipoBombilla = tipoBombilla;
            this.Marca = marca;
            this.Voltaje = voltaje;
            this.DuracionBombilla = duracionBombilla;
            this.LongitudCable = longitudCable;

            encendida = false;
        }

        //Accesores
        internal lista_colores Color { get => color; set => color = value; }
        internal lista_tipoBombilla TipoBombilla { get => tipoBombilla; set => tipoBombilla = value; }
        public string Marca { get => marca;
            set => marca = !(String.IsNullOrEmpty(value)) && !(String.IsNullOrWhiteSpace(value)) && value.Length > longitudMinimaMarca ? value : throw new Exception($"Error: La marca no puede estar vacía y su nombre debe ser mayor a {longitudMinimaMarca} caracteres"); }
        public byte Voltaje { get => voltaje;
            set => voltaje = value == 110 || value == 220 ? value : throw new Exception($"Error: El voltaje solo puede ser 110 o 220"); }
        public uint DuracionBombilla { get => duracionBombilla;
            set => duracionBombilla = value >= duracionMinimaBombilla && value <= duracionMaximaBombilla ? value : throw new Exception($"Error: La duración de la bombilla debe estar entre {duracionMinimaBombilla} y {duracionMaximaBombilla}"); }
        public float LongitudCable { get => longitudCable;
            set => longitudCable = value >= longitudMinimaCable && value <= longitudMaximaCable ? value : throw new Exception($"Error: La longitud del cable debe estar entre {longitudMinimaCable} y {longitudMaximaCable}"); }

        //Metodos
        public override string ToString()
        {
            return $"La lampara es de marca: {marca}\nEs de color: {color}\nLa bombilla es: {tipoBombilla}\nEl código de tablero es: {codigoTablero}\nEl voltaje de la lampara es: {voltaje}\nLa duracion de la bombilla es de: {duracionBombilla} horas\nLa longitud del cable de la lampara es de: {longitudCable} metros";
        }

        public string Encender()
        {
            try
            {
                if (!encendida)
                {
                    encendida = true;
                    return "La lampara se ha encendido correctamente";
                } 
                else
                {
                    throw new Exception("La lampara no puede encenderse debido a que actualmente se encuentra encendida. Intenta apagarla primero ;)");
                }
            }
            catch (Exception ex)
            {
                return ex.Message;
            }
        }

        public string Apagar()
        {
            try
            {
                if (encendida)
                {
                    encendida = false;
                    return "Se ha apagado la lampara correctamente";
                } 
                else
                {
                    throw new Exception("La lampara no puede apagarse debido a que actualmente se encuentra apagada. Intenta encenderla primero ;)");
                }
            }
            catch (Exception ex)
            {
                return ex.Message;
            }
        }

        public string CambiarBombillo(uint nuevaDuracionBombillo)
        {
            try
            {
                if (!encendida)
                {
                    if (nuevaDuracionBombillo >= duracionMinimaBombilla && nuevaDuracionBombillo <= duracionMaximaBombilla)
                    {
                        duracionBombilla = nuevaDuracionBombillo;
                        return $"El bombillo se ha cambiado exitosamente, la nueva duración es de {nuevaDuracionBombillo} horas";
                    } else
                    {
                        throw new Exception($"Error: No es posible cambiar el bombillo debido a que su duración debe estar entre {duracionMinimaBombilla} y {duracionMaximaBombilla}");
                    }
                }
                else
                {
                    throw new Exception("Error: No es posible cambiar el bombillo con la lampara encendida");
                }
            }
            catch (Exception ex)
            {
                return ex.Message;
            }
        }

        public string CambiarCable(float nuevoCable)
        {
            try
            {
                if (!encendida)
                {
                    if (nuevoCable >= longitudMinimaCable && nuevoCable <= longitudMaximaCable)
                    {
                        longitudCable = nuevoCable;
                        return $"Se ha cambiado exitosamente el cable, la nueva longitud es de {nuevoCable} metros";
                    } else
                    {
                        throw new Exception($"Error: El nuevo cable debe tener una longitud entre {longitudMinimaCable} y {longitudMaximaCable}");
                    }
                } else   
                {
                    throw new Exception("Error: No se puede cambiar el cable de la lampara mientras esta está encendida");
                }
            } 
            catch (Exception ex)
            {
                return ex.Message;
            }
        }

        public string AsignarTablero(string nuevoCodigoTablero)
        {
            try
            {
                if (!(string.IsNullOrEmpty(nuevoCodigoTablero) && (string.IsNullOrWhiteSpace(nuevoCodigoTablero))) && nuevoCodigoTablero.Length >= longitudMinimaCodigoTablero)
                {
                    codigoTablero = nuevoCodigoTablero;
                    return $"Se ha asginado correctamente el nuevo código de tablero de serial: {nuevoCodigoTablero}";
                }
                else
                {
                    throw new Exception($"Error: El código del tablero no puede estar vacío y debe tener una longitud mayor a {longitudMinimaCodigoTablero} caracteres");
                }
            }
            catch (Exception ex)
            {
                return ex.Message;
            }
        }
    }
}