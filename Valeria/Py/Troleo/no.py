from tkinter import font, messagebox
from tkinter import *
import random

def rechazo(event=None):
	messagebox.showinfo(message="No me quieres", title="Lo sabía")

def interaccion(event):
	x = random.randint(10, 400)
	y = random.randint(10, 400)
	boton_2.place(x=x, y=y)

def salida(event):
	x = random.randint(10, 400)
	y = random.randint(10, 400)
	boton_2.place(x=x, y=y)

lienzo = Tk()
lienzo.geometry("600x400")
lienzo.iconbitmap('C:/Users/USER/Desktop/Escritorio/Programación/Programas/Valeria/Troleo/corazon.ico')
lienzo.configure(background='#B4FAEA')
lienzo.title('No se que poner jajaja')

texto = Label(lienzo, text="¿Quieres ser mi novia?", bg='#B4FAEA', fg='black', width=0, font=("Comic Sans MS", 30))
texto.place(x=90, y=60)

boton_1 = Button(lienzo, text="No", width=5, height=1, font=("Comic Sans MS", 30), bg='#EDB4FA', fg='black', command=rechazo)
boton_1.place(x=350, y=220)

boton_2 = Button(lienzo, text="Si", width=5, height=1, font=("Comic Sans MS", 30), bg='#EDB4FA', fg='black')
boton_2.place(x=100, y=220)

boton_2.bind("<Enter>", interaccion)
boton_2.bind("<Leave>", salida)

lienzo.mainloop()