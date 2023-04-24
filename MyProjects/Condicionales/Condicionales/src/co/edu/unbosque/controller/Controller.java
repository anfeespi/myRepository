package co.edu.unbosque.controller;

import co.edu.unbosque.model.Numero;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	private Numero a;
	private VistaConsola vista;
	
	public Controller() {
		a = new Numero();
		vista = new VistaConsola();
		funcionar();
	}
	
	public void funcionar() {
		a.setN(vista.leerDatosEntero("Ingrese un numero entero: "));
		Numero b = new Numero();
		b.setN(vista.leerDatosEntero("Ingrese otro numero entero: "));
		vista.mostrarInformacion("El menor es: "+a.menor(b));
	}
}	
