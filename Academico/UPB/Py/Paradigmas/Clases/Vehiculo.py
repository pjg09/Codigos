from Clases.IReparar import IReparar
from abc import ABC, abstractmethod
from datetime import datetime

class Vehiculo(IReparar):
    
    def __init(self, codigo: str, fecha_compra: datetime, codigo_gps: str) -> None: #Constructor
        super().__init__()


        if not isinstance(codigo, str): #Accesor
            raise ValueError("El código debe ser una cadena de texto")
    
        if not isinstance(fecha_compra, datetime): #Accesor
            raise ValueError("La fecha de compra ser un objeto datetime")
    
        if not isinstance(codigo_gps, str):
            raise ValueError("El código GPS debe ser una cadena de texto")
            
        self.codigo = codigo
        self.fecha_compra = fecha_compra
        self.codigo_gps = codigo_gps
    
    @abstractmethod
    def reparar(self):
        pass

    def __str__(self) -> str:
        return f"Vehiculo con codigo {self.codigo} fue comprada en {self.fecha_compra}, tiene el código GPS {self.codigo_gps}"
    
    def __repr__(self):
        return self.__str__(self)