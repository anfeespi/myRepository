from PIL import Image


def calculateDiferences(img_uno, img_dos):
    flag = True

    img_uno = Image.open(img_uno)
    img_dos = Image.open(img_dos)

    pxls_uno = img_uno.load()
    pxls_dos = img_dos.load()

    tamano_uno = img_uno.size
    tamano_dos = img_dos.size

    anchura_uno = tamano_uno[0]
    anchura_dos = tamano_dos[0]

    altura_uno = tamano_uno[1]
    altura_dos = tamano_dos[1]

    print("La achura de la primer imagen es {}".format(anchura_uno))
    print("La altura de la primer imagen es {}".format(altura_uno))

    print("La achura de la segunda imagen es {}".format(anchura_dos))
    print("La altura de la segunda imagen es {}".format(altura_dos))

    if anchura_uno != anchura_dos:
        flag = False

    if anchura_uno > anchura_dos:
        anchura_max = anchura_dos
    else:
        anchura_max = anchura_uno

    if altura_uno > altura_dos:
        altura_max = altura_dos
    else:
        altura_max = altura_uno

    c = 0
    for x in range(anchura_max):
        for y in range(altura_uno):
            pxl_uno = pxls_uno[x, y]
            pxl_dos = pxls_dos[x, y]

            if pxl_uno != pxl_dos:
                c += 1
                flag = False

    if flag:
        print("Son exactamente las mismas imagenes!")
    else:
        print("Son imagenes muy distintas, difieren en {} pixeles".format(c))
        if anchura_uno != anchura_dos or altura_uno != altura_dos:
            print("Y difieren en sus dimensiones!")
        else:
            print("Pero tienen sus mismas dimensiones!")

    print("\n\n")


#Son distintas:
print("Cuando son imagenes distintas: ")
calculateDiferences("mujer.jpg", "cebras.jpg")

#Son iguales
print("Cuando son imagenes iguales: ")
calculateDiferences("mujer.jpg", "mujer.jpg")


