package co.edu.unbosque.view;

import java.util.Scanner;

/**
 * 
 * Consola
 * @author Andres Espitia
 * @author Diego Forero
 *
 */
public class Console {
	/**
	 * Scanner para leer lo escrito en la consola
	 */
	private Scanner sc;
	/**
	 * booleano que permite saber si el ultimo dato fue de tipo numerico
	 */
	private boolean lastInteger;
	
	/**
	 * Constructor
	 */
	public Console() {
		sc = new Scanner(System.in);
		lastInteger = false;
	}
	
	/**
	 * Metodo para devolver el siguiente entero en consola
	 * @return
	 */
	public int nextInt() {
		int aux = sc.nextInt();
		lastInteger = true;
		
		return aux;
	}
	
	/**
	 * Metodo para devolver la siguiente cadena en consola
	 * @return
	 */
	public String nextLine() {
		String aux;
		if (lastInteger) {
			sc.nextLine();
			aux = sc.nextLine();			
		}
		else {
			aux = sc.nextLine();
		}
		lastInteger = false;
		return aux;
	}
	
	/**
	 * Metodo para escribir un mensaje con linea separada
	 * @param cadena
	 */
	public void printMessageLn(String cadena) {
		System.out.println(cadena);
	}
	/**
	 * Metodo para escribir un mensaje en la misma linea
	 * @param cadena
	 */
	public void printMessage(String cadena) {
		System.out.print(cadena);
	}
	

}