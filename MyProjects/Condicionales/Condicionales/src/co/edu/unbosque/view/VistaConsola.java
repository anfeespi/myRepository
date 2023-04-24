package co.edu.unbosque.view;

import java.util.Scanner;

public class VistaConsola {
	private Scanner leer;
	
	public VistaConsola() {
		leer = new Scanner(System.in);
	}
	
	public int leerDatosEntero(String mensaje) {
		System.out.println(mensaje);
		int dato = leer.nextInt();
		return dato;
	}
	
	public void mostrarInformacion(String mensaje) {
		System.out.println(mensaje);
	}
}
