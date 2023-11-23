from PIL import Image

imagen_uno = Image.open("grises.jpg")
imagen_dos = Image.open("grises2.jpg")

pixeles_uno = imagen_uno.load()
pixeles_dos = imagen_dos.load()

tamano_uno = imagen_uno.size
tamano_dos = imagen_dos.size

anchura = tamano_uno[0]
altura = tamano_uno[1]

pixeles_diferentes = 0
if tamano_uno == tamano_dos:
    for x in range(anchura):
        for y in range(altura):
            pixel_uno = pixeles_uno[x,y]
            pixel_dos = pixeles_dos[x, y]

            if pixel_uno != pixel_dos:
                pixeles_diferentes += 1

    if pixeles_diferentes > 0:
        print("Las dos imagenes son diferentes")
        print("Tienen " + str(pixeles_diferentes) + " pixeles diferentes")
    else:
        print("Las imagenes son iguales")
else:
    print("Las imagenes tienen diferente anchura o altura")


