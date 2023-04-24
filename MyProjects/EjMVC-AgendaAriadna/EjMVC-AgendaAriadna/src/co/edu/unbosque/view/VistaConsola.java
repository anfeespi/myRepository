package co.edu.unbosque.view;

import java.util.Scanner;

public class VistaConsola {
	
	private Scanner leer;
	
	public VistaConsola() {
		leer = new Scanner(System.in);
	}
	
	public long leerDatoEntero(String mensaje) {
		System.out.println(mensaje);
		long dato = leer.nextLong();
		leer.nextLine();
		return dato;
	}
	
	public String leerDatoString(String mensaje) {
		System.out.println(mensaje);
		String dato = leer.nextLine();
		return dato;
	}
	
	public void mostrarInformacion(String mensaje) {
		System.out.println(mensaje);
	}

}
