def max_music_on_cds(c, n, song_durations):
    song_durations.sort(reverse=True)  # Ordenar las duraciones de las canciones de mayor a menor
    cds = [[], []]  # CDs
    total_time = [0, 0]  # Tiempo total en cada CD

    for duration in song_durations:
        # Elegir el CD con menos tiempo acumulado hasta el momento
        idx = total_time.index(min(total_time))
        # Si hay espacio suficiente en el CD seleccionado, agregar la canción
        if total_time[idx] + duration <= c:
            cds[idx].append(duration)
            total_time[idx] += duration
        # Si no, intentar en el otro CD
        elif total_time[1 - idx] + duration <= c:
            cds[1 - idx].append(duration)
            total_time[1 - idx] += duration

    return max(total_time), min(total_time)

# Entrada
c, n = map(int, input().split())
song_durations = list(map(int, input().split()))

# Obtener la cantidad máxima de música en cada CD
max_time_on_cd1, max_time_on_cd2 = max_music_on_cds(c, n, song_durations)

# Salida
print(max_time_on_cd1, max_time_on_cd2)

