def dar_cambio(monedas, monto):
    monedas.sort(reverse=True)  # Ordenar monedas de mayor a menor
    cambio = []
    
    for moneda in monedas:
        while monto >= moneda:
            cambio.append(moneda)
            monto -= moneda
    
    return cambio

# Ejemplo de uso
monedas_disponibles = [1, 2, 5, 10]
monto_objetivo = 63
resultado = dar_cambio(monedas_disponibles, monto_objetivo)
print(f"Cambio para {monto_objetivo}: {resultado}")