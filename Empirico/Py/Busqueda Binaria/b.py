lista = [0, 88, 72, 21, 14, 16, 90, 35, 47, 6, 68, 12, 10, 54, 41]
lista.sort()
print(lista)

# 1. Buscar el punto medio de la lista
# 2. Comprobar si el punto medio es el valor que buscamos
# 3. Si el punto medio es menor al valor que buscamos aumentamos la variable inicio en uno sobre el punto medio
# 4. Si el punto medio es mayor al valor que buscamos disminuimos la variable final en uno abajo del punto medio
# 5. Si inicio es mayor o igual que final entonces el valor no está en la lista

def busqueda_binaria(valor):
    inicio = 0
    final = len(lista) - 1
    while inicio <= final:
        punto_medio = (inicio + final) // 2
        if valor == lista[punto_medio]:
            return punto_medio
        elif valor > lista[punto_medio]:
            inicio = punto_medio + 1
        else:
            final = punto_medio - 1
    return None

def buscar_valor(valor):
    resultado_busqueda = busqueda_binaria(valor)
    if resultado_busqueda == None:
        return f"El número {valor} no fue encontrado en la lista"
    else:
        return f"El número {valor} se encuentra en la posición {resultado_busqueda}"
    
print(buscar_valor(15))