class Usuario:
    posee_vehiculo = False
    vehiculo = []
   
    def __init__(self, id: str, nombre: str, telefono: str) -> None:
        if not isinstance(id, str):
            raise ValueError("El id debe ser una cadena de texto.")
       
        if not isinstance(nombre, str):
            raise ValueError("El nombre debe ser una cadena de texto.")
       
        if not isinstance(telefono, str):
            raise ValueError("El telefono debe ser una cadena de texto.")
       
        self.id = id
        self.nombre = nombre
        self.telefono = telefono