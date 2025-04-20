from Clases.Vehiculo import Vehiculo
from datetime import datetime
 
class Patineta(Vehiculo):
   
    #nivel_carga = 100
       
    def __init__(self, codigo, fecha_compra, codigo_gps):
        super().__init__(codigo, fecha_compra, codigo_gps)
        self.nivel_carga = 100
       
     
    def __str__(self):
        return f"Patineta con codigo {self.codigo} fue comprada en {self.fecha_compra}, tiene el codigo GPS {self.codigo_gps} y tiene {self.nivel_carga}% de carga."
       
    def reparar(self):
        return f"la patineta {self.codigo} fue reparada el {datetime.now()}"