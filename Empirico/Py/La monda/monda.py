import turtle
colors = ['red', 'purple', 'blue', 'green', 'orange', 'yellow']
pincel = turtle.Pen()
turtle.bgcolor('black')
for x in range(1920):
	pincel.speed(10)
	pincel.pencolor(colors[x%6])
	pincel.width(x//100 + 1)
	pincel.forward(x)
	pincel.left(59)