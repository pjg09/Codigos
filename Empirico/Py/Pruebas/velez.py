# Abre el archivo CSV
with open('trabajo1estocasticos', mode='r', encoding='utf-8') as archivo:
    # Lee todas las líneas del archivo
    lineas = archivo.readlines()

    # Recorre las líneas e imprímelas
    for linea in lineas:
        fila = linea.strip().split(',')  # Divide cada línea por las comas
        print(fila)


        