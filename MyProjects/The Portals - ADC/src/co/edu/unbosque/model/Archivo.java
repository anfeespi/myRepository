package co.edu.unbosque.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * Clase con la que se guardan las partidas dentro de un archivo
 * @author Andres Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */
public class Archivo {
	/**
	 * Clase para escribir en el archivo
	 */
	private PrintWriter pw;
	/**
	 * Clase para leer un archivo
	 */
	private Scanner sc;
	/**
	 * Arreglo de partidas pasadas
	 */
	private ArrayList<String> past_partidas;
	
	/**
	 * Metodo constructor
	 */
	public Archivo() {
		try {
			sc = new Scanner(new FileReader("src/archivo_partidas.txt"));
			past_partidas = new ArrayList<String>();
			guardarPartidasPasadas();
			pw = new PrintWriter("src/archivo_partidas.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para guardar las partidas pasadas
	 */
	public void guardarPartidasPasadas() {
		while (sc.hasNextLine()) {
			String p = sc.nextLine();
			past_partidas.add(p);
		}
	}
	
	/**
	 * Metodo para guardar las nuevas partidas
	 * @param nombre_ganador
	 * @param filas
	 * @param columnas
	 * @param num_jugadores
	 */
	public void guardarNuevaPartida(String nombre_ganador, int filas, int columnas, int num_jugadores) {
		for (String b : past_partidas) {
			System.out.println(b);
			pw.println(b);
		}
		String partida_datos = "Tablero: " + filas + "x" + columnas + ", Num Jugadores: "+num_jugadores+", Ganador: "+nombre_ganador;
		past_partidas.add(partida_datos);
		pw.println(partida_datos);
		pw.close();
	}
	
	/**
	 * Devuelve la clase PrintWriter
	 */
	public PrintWriter getPw() {
		return pw;
	}

	/**
	 * Metodo para cambiar el PrintWriter
	 * @param pw
	 */
	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}

	/**
	 * Devuelve el Scanner
	 */
	public Scanner getSc() {
		return sc;
	}

	/**
	 * Metodo para cambiar el Scanner
	 * @param sc
	 */
	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	/**
	 * Devuelve el arreglo de partidas pasadas
	 */
	public ArrayList<String> getPast_partidas() {
		return past_partidas;
	}

	/**
	 * Metodo para cambiar el arreglo de partidas pasadas
	 * @param past_partidas
	 */
	public void setPast_partidas(ArrayList<String> past_partidas) {
		this.past_partidas = past_partidas;
	}
}
