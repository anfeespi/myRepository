package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * Clase para el manejo de archivos
 * @author Andres Espitia
 * @author Diego Forero
 *
 */
public class FileHandler {
	/**
	 * Scanner para leer el archivo
	 */
	private Scanner sc;
	/**
	 * Archivo
	 */
	private File f1;
	/**
	 * Objeto para escribir sobre el archivo
	 */
	private PrintWriter pw;
	/**
	 * Constructor
	 * @param url
	 */
	public FileHandler(String url) {
		f1 = new File("src/co/edu/unbosque/model/persistence/"+url);
	}
	
	/**
	 * Metodo para leer el archivo
	 * @return
	 */
	public String readFile() {
		String content = "";
		try {
			sc = new Scanner(f1);
			while (sc.hasNext()) {
				content += sc.nextLine()+"\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println("Scanner: File not found!");
			e.printStackTrace();
		}finally {
			sc.close();			
		}
		return content;
	}
	
	/**
	 * Metodo para escribir en el archivo
	 * @param content
	 */
	public void writeFile(String content) {
		try {
			pw = new PrintWriter(f1);
			pw.println(content);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Writer: File not found!");
			e.printStackTrace();
		}
	}
}
