import numpy as np

posicion_meta = 22
simulaciones = 100000

movimientos_fantasma = [1, 2, 3, 4]
probabilidades_fantasma = [0.35, 0.35, 0.18, 0.12]

movimientos_cerdito = [1, 2, 3]
probabilidades_cerdito = [0.30, 0.35, 0.35]

victorias_cerdito = 0
victorias_fantasma = 0

for _ in range(simulaciones):
    pos_fantasma = 0
    pos_cerdito = 2

    while True:
        avance_cerdito = np.random.choice(movimientos_cerdito, p=probabilidades_cerdito)
        pos_cerdito += avance_cerdito

        if pos_cerdito >= posicion_meta:
            victorias_cerdito += 1
            break

        avance_fantasma = np.random.choice(movimientos_fantasma, p=probabilidades_fantasma)
        pos_fantasma += avance_fantasma

        if pos_fantasma >= pos_cerdito:
            victorias_fantasma += 1
            break

p_victoria_cerdito = victorias_cerdito / simulaciones
p_victoria_fantasma = victorias_fantasma / simulaciones

p_victoria_cerdito, p_victoria_fantasma

print(p_victoria_cerdito, p_victoria_fantasma)