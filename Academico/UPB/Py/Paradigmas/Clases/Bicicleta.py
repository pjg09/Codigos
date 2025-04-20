from Clases.Vehiculo import Vehiculo
from datetime import datetime
 
class Bicicleta(Vehiculo):
   
    def __init__(self, codigo: str = "0", fecha_compra: datetime = datetime.now(), codigo_gps: str = "0",nro_cambios: int = 1) -> None:
        super().__init__(codigo, fecha_compra, codigo_gps)
       
        if not isinstance(nro_cambios, int):
            raise ValueError("El número de cambios debe ser un entero.")
       
        self.nro_cambios = nro_cambios
       
    def reparar(self) -> str:
        return f"la bicicleta {self.codigo} fue reparada el {datetime.now()}"
   
    def __str__(self) -> str:
        return f"Bicicleta con codigo {self.codigo} fue comprada en {self.fecha_compra}, tiene el codigo GPS {self.codigo_gps} y tiene {self.nro_cambios} cambios."