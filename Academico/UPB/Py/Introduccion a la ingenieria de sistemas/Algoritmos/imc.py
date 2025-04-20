def calcular_imc(peso, altura):
    imc = peso / (altura ** 2)
    return imc

def interpretar_imc(imc):
    if imc < 18.5:
        return "Bajo peso"
    elif 18.5 <= imc < 25:
        return "Peso normal"
    elif 25 <= imc < 30:
        return "Sobrepeso"
    elif imc > 30:
        return "Obesidad"
    else:
        return "No clasificado"
    
def main():
    print("Vamos a calcular tu indice de masa corporal")

    peso = float(input("Ingresa tu peso en kilogramos: "))
    altura = float(input("Ingresa tu altura en metros: "))
    imc = calcular_imc(peso, altura)
    estado = interpretar_imc(imc)

    print("Tu indice de masa corporal es: {:.2f}".format(imc))
    print("Tu estado actual es ", estado)

if __name__ == "__main__":
    main()