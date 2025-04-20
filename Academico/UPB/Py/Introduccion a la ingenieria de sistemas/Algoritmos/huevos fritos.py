def huevos_fritos():
    print("Preparación de huevos fritos")
    cantidad_huevos = int(input("¿Cuántos huevos te gustaría comer?"))
    coccion = input("¿Cómo quieres los huevos fritos? blanditos, medianos o duros.").lower()

    if cantidad_huevos == 1:
        print("Recolectando 1 huevo del gallinero...")
        print("Calentando la sarten con mantequilla sobre la estufa...")
        print("Rompiendo el huevo perfectamente sobre la sarten...")
        
        if coccion == "blanditos":
            print(f"Cocinando el huevo durante 2 minutos...")
        elif coccion == "medianos":
            print(f"Cocinando el huevo durante 4 minutos...")
        elif coccion == "duros":
            print(f"Cocinando el huevo durante 6 minutos...")
        else:
            print("Lo siento, no entendí tu preferencia...")
        
        print("Sirviendo el huevo en un plato pando...")
        print("El huevo está servido, disfrutalo...")
    elif cantidad_huevos > 1:
        print(f"Recolectando {cantidad_huevos} huevos del gallinero...")
        print("Calentando la sarten con mantequilla sobre la estufa...")
        print("Rompiendo los huevos perfectamente sobre la sarten...")
        
        if coccion == "blanditos":
            print(f"Cocinando los huevos durante 2 minutos...")
        elif coccion == "medianos":
            print(f"Cocinando los huevos durante 4 minutos...")
        elif coccion == "duros":
            print(f"Cocinando los huevos durante 6 minutos...")
        else:
            print("Lo siento, no entendí tu preferencia...")
        
        print("Sirviendo los huevos en un plato pando...")
        print("Los huevos están servidos, disfrutalos...")  

huevos_fritos()