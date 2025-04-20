import pygame
import sys
import random

pygame.init()

width, height = 700, 775
screen = pygame.display.set_mode((width,height))
pygame.display.set_caption("Disparando ❤️ a mi amorcito")

imagen_pedro = pygame.image.load("imagenes/")
imagen_pedro = pygame.transform.scale(imagen_pedro, (60, 60))

imagen_proyectil = pygame.image.load("imagenes/corazon.png")
imagen_proyectil = pygame.transform.scale(imagen_proyectil, (50, 50))

imagen_valeria = pygame.image.load("imagenes/")
imagen_valeria = pygame.transform.scale(imagen_valeria, (60, 60))

imagen_fondo = pygame.image.load("imagenes/fondo.jpg")
imagen_fondo = pygame.transform.scale(imagen_fondo, (width, height))

