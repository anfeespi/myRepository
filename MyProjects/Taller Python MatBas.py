import cv2 as cv
import numpy as np

##Ponemos el fondo de tamaño 500x700 con color negro
img = np.zeros((500, 700, 3), np.uint8)
img[:]=(0,0,0)

'''
De Derecha a Izquierda y de Arriba a Abajo
'''

##Triangulo Naranja
points = np.array([[350, 110], [420, 50], [495, 110]])
color = (19, 122, 255)
img = cv.fillPoly(img, [points], color)

##Cuadrado Amarillo
points = np.array([[495, 110], [425, 110], [425, 180],[495,180]])
color = (0, 215, 255)
img = cv.fillPoly(img, [points], color)

##Triangulo Verde
points = np.array([[495, 180], [285, 180], [390, 270]])
color = (102, 209, 0)
img = cv.fillPoly(img, [points], color)

##Triangulo Rosa
points = np.array([[180, 270], [285, 180], [390, 270]])
color = (120, 74, 255)
img = cv.fillPoly(img, [points], color)

##Cuadrilatero Azul Oscuro
points = np.array([[390, 270], [320,270], [260,330],[330,330]])
color = (227, 152, 0)
img = cv.fillPoly(img, [points], color)

##Triangulo Azul Claro
points = np.array([[330,410], [260,330], [330,330]])
color = (254, 209, 0)
img = cv.fillPoly(img, [points], color)

##Triangulo Morado
points = np.array([[295,370],[295,450],[365,450]])
color = (255, 82, 221)
img = cv.fillPoly(img, [points], color)


##Texto de Grupo
cv.putText(img,'Grupo de trabajo No. 3',(10,30),
cv.FONT_HERSHEY_SIMPLEX, 1, (255,255,255), 2, cv.LINE_AA)

cv.imshow('Taller 2, Corte 2 – Grupo 3', img)

cv.waitKey(0)

cv.destroyAllWindows()