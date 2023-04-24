package controlador;
import java.util.ArrayList;

import modelo.*;
import vista.Consola;

public class Controller {
	private Consola vista;
	private Convertir a;
	private Primo b;
	private Descomponer c, c1;
	
	private String menu = "Elija una opción: \n"
	    	+"1) Averiguar si un número ingresado es primo.\n"
	    	+"2) Conversión de bases.\n"
	    	+"3) Descomposición de un número a factores primos.\n"
	    	+"4) Encontrar el mcm de 2 números.\n"
	    	+"5) Encontrar el MCD de 2 números.\n"
	    	+"Otro caracter) Finalizar\n\n\n"
	    	+"Ingrese la opción: ";
	private String submenu2 = "Elija una opcion: \n"
	    	+"1) De decimal a binario.\n"
	    	+"2) De binario a decimal.\n"
	    	+"3) De decimal a octal.\n"
	    	+"4) De octal a decimal.\n"
	    	+"5) De decimal a hexadecimal.\n"
	    	+"6) De hexadecimal a decimal.\n"
	    	+"Ingrese la opción: ";
	
	public Controller() {
		vista = new Consola();
		a = new Convertir();
		b = new Primo();
		c = new Descomponer();
		c1 = new Descomponer();
		funcionar();
	}
	
	public void funcionar() {
		boolean rep = true;
		do {
			int opc1 = vista.pedirDatoEntero(menu);
			switch (opc1) {
			case 1:
				primo();
				break;
			case 2:
				menu2();
				break;
			case 3:
				factores();
				break;
			case 4:
				mcm();
				break;
			case 5:
				mcd();
				break;
			default:
				rep = repetir();
				break;
			}
		}while(rep);
		
	}
	
	public void primo() {
		b.setN(vista.pedirDatoEntero("Ingrese el numero: "));
		if(b.esPrimo()) {
			vista.mostrarInfo("El numero es primo");
		}
		else {
			vista.mostrarInfo("El numero no es primo");
		}
	}
	
	public void factores() {
		c.setN(vista.pedirDatoEntero("Ingrese el dato: "));
		c.factoresPrimos();
		vista.mostrarInfo("Los factores son: "+c.imprimirArreglo());
	}
	
	public void mcm() {
		ArrayList<Integer> mcm = new ArrayList<>();
		c.setN(vista.pedirDatoEntero("Ingrese el primer dato: "));
		c.factoresPrimos();
		c1.setN(vista.pedirDatoEntero("Ingrese el segundo dato: "));
		c1.factoresPrimos();
		
		int[] primos = new int[]{2,3,5,7,11,13,17,19,23};
		for(int i=0; i<primos.length; i++) {
			int i1 = 0, i2=0;
			
			for(int j=0; j<c.getdescomposicion().size(); j++) {
				if(primos[i]==c.getdescomposicion().get(j)) i1++;
			}
			for(int j=0; j<c1.getdescomposicion().size(); j++) {
				if(primos[i]==c1.getdescomposicion().get(j)) i2++;
			}
			
			int m = 0;
			if(i1>i2) m=i1;
			else m=i2;
			for(int j=0; j<m; j++) mcm.add(primos[i]);
		}
		int n = 1;
		for(int i=0; i<mcm.size(); i++) {
			n = n * mcm.get(i);
		}
		vista.mostrarInfo("El mcm es: "+n+" : "+mcm.toString());
	}
	
	public void mcd() {
		ArrayList<Integer> mcm = new ArrayList<>();
		c.setN(vista.pedirDatoEntero("Ingrese el primer dato: "));
		c.factoresPrimos();
		c1.setN(vista.pedirDatoEntero("Ingrese el segundo dato: "));
		c1.factoresPrimos();
		
		int[] primos = new int[]{2,3,5,7,11,13,17,19,23};
		for(int i=0; i<primos.length; i++) {
			int i1 = 0, i2=0;
			
			for(int j=0; j<c.getdescomposicion().size(); j++) {
				if(primos[i]==c.getdescomposicion().get(j)) i1++;
			}
			for(int j=0; j<c1.getdescomposicion().size(); j++) {
				if(primos[i]==c1.getdescomposicion().get(j)) i2++;
			}
			
			int m = 0;
			if(i1<i2) m=i1;
			else m=i2;
			for(int j=0; j<m; j++) mcm.add(primos[i]);
		}
		int n = 1;
		for(int i=0; i<mcm.size(); i++) {
			n = n * mcm.get(i);
		}
		vista.mostrarInfo("El mcm es: "+n+" : "+mcm.toString());
	}
	
	public boolean repetir() {
		boolean r=true;
		int s = vista.pedirDatoEntero("Seguro que quiere salir?\n1) Si\n2) No.");
		if(s != 2) r=false;
		return r;
	}
	
	public void menu2() {
		int opc2 = vista.pedirDatoEntero(submenu2);
		switch (opc2) {
		case 1:
			a.setDec(vista.pedirDatoEntero("Ingrese el decimal: "));
			a.decToBin();
			vista.mostrarInfo("El numero en binario es: "+a.getBin());
			break;
		case 2:
			a.setBin(vista.pedirString("Ingrese el binario: "));
			a.binToDec();
			vista.mostrarInfo("El numero en decimal es: "+a.getDec());
			break;
		case 3:
			a.setDec(vista.pedirDatoEntero("Ingrese el decimal: "));
			a.decToOct();
			vista.mostrarInfo("El numero en octal es: "+a.getOct());
			break;
		case 4:
			a.setOct(vista.pedirString("Ingrese el octal: "));
			a.octToDec();
			vista.mostrarInfo("El numero en decimal es: "+a.getDec());
			break;
		case 5:
			a.setDec(vista.pedirDatoEntero("Ingrese el decimal: "));
			a.decToHex();
			vista.mostrarInfo("El numero en hexadecimal es: "+a.getHex());
			break;
		case 6:
			a.setHex(vista.pedirString("Ingrese el hexadecimal: "));
			a.hexToDec();
			vista.mostrarInfo("El numero en decimal es: "+a.getDec());
			break;
		default:
			break;
		}
	}
	
}