package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * 
 * Clase de tipo mascota que almacena gatos y perros
 * @author Andrés Espitia
 * @author Diego Forero
 *
 */
public class Mascota {
	/**
	 * Arreglo de tamaño variable que contiene los gatos
	 */
	private ArrayList<Gato> gato;
	/**
	 * Arreglo de tamaño variavle que contiene los perros
	 */
	private ArrayList<Perro> perro ;
	
	/**
	 * Metodo Constructor
	 */
	public Mascota() {
		gato = new ArrayList<>();
		perro = new ArrayList<>();
	}
	
	/**
	 * Metodo que permite añadir un gato
	 * @param g objeto de tipo gato
	 */
	public void anadirGato(Gato g) {
		gato.add(g);
	}
	
	/**
	 * Metodo que permite añadir un perro
	 * @param p objeto de tipo perro
	 */
	public void anadirPerro(Perro p) {
		perro.add(p);
	}

	/**
	 * Metodo que devuelve el arreglo de gatos
	 * @return arreglo de gatos
	 */
	public ArrayList<Gato> getGato() {
		return gato;
	}

	/**
	 * Metodo que cambia el arreglo de gatos
	 * @param gato
	 */
	public void setGato(ArrayList<Gato> gato) {
		this.gato = gato;
	}

	/**
	 * Metodo que devuelve el arreglo de perros
	 * @return arreglo de perros
	 */
	public ArrayList<Perro> getPerro() {
		return perro;
	}

	/**
	 * Metodo que cambia el arreglo de perros
	 * @param perro
	 */
	public void setPerro(ArrayList<Perro> perro) {
		this.perro = perro;
	}
}
