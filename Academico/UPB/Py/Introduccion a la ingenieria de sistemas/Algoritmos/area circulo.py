import math

print("Para calcular el area de un circulo necesitaremos su radio...")

def calcular_area(radio):

    area = math.pi * (radio ** 2)
    return area

def main():
    radio = float(input("Ingresa el radio del circulo al cual deseas calcularle el area: "))
    area = calcular_area(radio)

    print("El area del circulo con radio {:.2f} es : {:.2f}".format(radio, area))

if __name__ == "__main__":
    main()