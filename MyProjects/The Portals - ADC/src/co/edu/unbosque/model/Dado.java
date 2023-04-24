package co.edu.unbosque.model;

import java.util.Random;

/**
 * 
 * Clase referente al dado para jugar
 * @author Andres Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */
public class Dado {
	/**
	 * Valor entero del dado
	 */
	private int valor;
	
	/**
	 * Metodo constructor
	 */
	public Dado() {
		valor = 0;
	}
	
	/**
	 * Metodo para crear un numero aleatorio de 1 a 6
	 */
	public void generarAleatorio() {
		Random random = new Random();

		valor = random.nextInt(6) + 1;
	}

	/**
	 * Metodo para obtener el valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Metodo para cambiar el valor
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
