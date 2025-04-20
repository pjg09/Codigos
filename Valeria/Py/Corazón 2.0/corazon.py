import math
from turtle import *
def corazonA(k):
	return 15*math.sin(k)**3
def corazonB(k):
	return 12*math.cos(k)-5*\
		math.cos(2*k)-2*\
		math.cos(3*k)-\
		math.cos(4*k)
speed(10)
bgcolor("black")
for i in range(10000):
	goto(corazonA(i)*20,corazonB(i)*20)
	for j in range(5):
		color("#FFE2FF")
	goto(0,0)
done()