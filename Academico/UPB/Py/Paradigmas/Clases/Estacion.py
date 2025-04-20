from Clases.Patineta import Patineta
from Clases.Bicicleta import Bicicleta
from Clases.Vehiculo import Vehiculo
from Clases.Usuario import Usuario

class Estacion:
    # vehiculo = [[b, b, b, b, b, b], [p, p, p, p, p, p]]

    def __init__(self, nombre: str, direccion: str, vehiculos: list) -> None:
        