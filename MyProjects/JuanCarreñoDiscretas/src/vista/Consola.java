package vista;

import java.util.*;

public class Consola {
			
	private Scanner leer;
	
	public Consola() {
		leer = new Scanner(System.in);
	}
			
	public void mostrarInfo(String mensaje) {
		System.out.println(mensaje);
	}
			
	public int pedirDatoEntero(String mensaje) {
		System.out.println(mensaje);
		int dato = leer.nextInt();
		leer.nextLine();
		return dato;
	}
			
	public String pedirString(String mensaje) {
		System.out.println(mensaje);
		String dato = leer.nextLine();
		leer.nextLine();
		return dato;
	}
		

}
