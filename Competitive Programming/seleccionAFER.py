def seleccionar_actividades(actividades):
    actividades.sort(key=lambda x: x[1])  # Ordenar actividades por tiempo de finalización
    seleccionadas = [actividades[0]]
    
    for actividad in actividades[1:]:
        if actividad[0] >= seleccionadas[-1][1]:
            seleccionadas.append(actividad)
    
    return seleccionadas

lista_actividades = [(1, 3), (2, 5), (4, 7), (6, 9), (8, 10)]
actividades_seleccionadas = seleccionar_actividades(lista_actividades)
print(f"Actividades seleccionadas: {actividades_seleccionadas}")