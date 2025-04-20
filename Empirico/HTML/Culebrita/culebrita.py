from turtle import *
from random import randrange
from freegames import square,vector

comida=vector(0,0)
culebra=[vector(10,0)]
direccion=vector(0,-10)

def change(x,y):
	direccion.x=x
	direccion.y=y

def inside(head):
	return -200 < head.x <190 and -200 < head.y < 190

def move():
	head=culebra[-1].copy()
	head.move(direccion)

if not inside(head) or head in culebra:
	square(head.x,head.y,9,'red')
	update()

culebra.append()

if head==comida:
	print('culebra',len(culebra))
	comida.x=randrange(-15, 15)*10
	comida.y=randrange(-15, 15)*10

else:
	culebra.pop(0)

clear()

for body in culebra:
	square(body.x,body.y,9,'green')

square(comida.x,comida.y,9,'red')
update()
ontimer(move, 100)

hideturtle()
tracer(False)
listen()
onkey(lambda:changes(10,0),'Right')
onkey(lambda:changes(-10,0),'Left')
onkey(lambda:changes(0,10),'Up')
onkey(lambda:changes(0,-10),'Down')

move()
done()