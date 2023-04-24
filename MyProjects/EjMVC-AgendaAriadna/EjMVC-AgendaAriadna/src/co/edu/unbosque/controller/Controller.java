package co.edu.unbosque.controller;

import co.edu.unbosque.model.Parcero;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	
	private Parcero a1;
	private Parcero a2;
	private Parcero a3;
	private VistaConsola vista;
	
	public Controller() {
		a1 = new Parcero();
		a2 = new Parcero();
		a3 = new Parcero();
		vista  = new VistaConsola();
		funcionar();
	}
	
	public void funcionar() {
		
		a1.setNombre("Hugo");
		a1.setNtelefono(3216598);
		
		String aux1 = vista.leerDatoString("Ingrese nombre2:");
		a2.setNombre(aux1);
		long aux2 = vista.leerDatoEntero("Ingrese telefono2:");
		a2.setNtelefono(aux2);
		
		aux1 = vista.leerDatoString("Ingrese nombre3:");
		a3.setNombre(aux1);
		aux2 = vista.leerDatoEntero("Ingrese telefono3:");
		a3.setNtelefono(aux2);
		
		vista.mostrarInformacion(a1.toString());
		vista.mostrarInformacion(a2.toString());
		vista.mostrarInformacion(a3.toString());
		
	}

}
