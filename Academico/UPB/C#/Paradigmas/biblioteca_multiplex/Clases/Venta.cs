﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace biblioteca_multiplex.Clases
{
    internal class Venta
    {
        private Taquillero taquillero;
        private Boleta boleta;
        private DateTime fecha_venta;

        public Venta(Taquillero taquillero, Boleta boleta)
        {
            this.taquillero = taquillero;
            this.boleta = boleta;
            fecha_venta = DateTime.Now;
        }
    }
}
