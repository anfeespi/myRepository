package co.edu.unbosque.model;

public class Cola{
	private Nodo inicio;
	private int tamanio;

	public Cola() {
		inicio = null;
		tamanio = 0;
	}

	public boolean estaVacia() {
		return inicio == null;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void encolar(Encargo valor) {
		Nodo nuevo = new Nodo();
		nuevo.setValor(valor);
		if (estaVacia()) {
			inicio = nuevo;
		} else {
			Nodo aux = inicio;
			while(aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
		}
		tamanio++;
	}

	public void desencolar() {
		if (!estaVacia()) {
			inicio = inicio.getSiguiente();
			tamanio--;
		}
	}

	public Nodo cima() throws Exception {
		if (!estaVacia()) {
			return inicio;
		} else {
			throw new Exception("La cola se encuentra vacia.");
		}
	}

	public String listar() {
		StringBuilder sb = new StringBuilder();
		sb.append("El listado de ordenes, por orden de llegada es el siguiente: ");
		
		Nodo aux = inicio;
		while (aux != null) {
			sb.append("\n"+aux.toString());
			aux = aux.getSiguiente();
		}
		return sb.toString();
	}

}

