def par(numero):
    if numero % 2 == 0:
        return True
    else:
        return False

numero = int(input("Introduce un número: "))

if par(numero):
    print(f"{numero} es un número par.")
else:
    print(f"{numero} no es un número par.")