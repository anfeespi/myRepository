package co.edu.unbosque.controller;

import co.edu.unbosque.model.Cola;
import co.edu.unbosque.model.Encargo;
import co.edu.unbosque.model.Pila;
import co.edu.unbosque.view.Console;

public class Controller {
	private Cola encargos;
	private Pila carros[];
	private Console c;
	
	public Controller() {
		encargos = new Cola();
		carros = new Pila[8];
		for (int i = 0; i < carros.length; i++) {
			carros[i] = new Pila();
		}
		c = new Console();
		menu();
	}
	
	public void menu() {
		c.printMessageLn(	  "1. Registrar solicitudes del Cliente.\r\n"
							+ "2. Mostrar todas las solicitudes de los clientes con sus características completas, según el orden en que se ingresaron.\r\n"
							+ "3. Generar la Distribución de solicitudes a los Transportistas\r\n"
							+ "4. Listar la forma en que se Distribuyeron las actividades del día\r\n"
							+ "5. Reportes de cada vehículo de la forma en que realizaron la entrega de la mercancía y/o giros asignados");
		int opc = c.nextInt();
		switch (opc) {
		case 1:
			c.printMessage("Ingrese el NIT de cliente: ");
			int nit = c.nextInt();
			c.printMessage("Ingrese la dirección destino: ");
			String destino = c.nextLine();
			c.printMessage("Ingrese el sector: \n1. Sur, \n2. Norte, \n3. Oriente, \n4. Occidente");
			int sector = c.nextInt();
			c.printMessage("Ingrese el tipo de encargo: \n1. Mercancia, \n2. Giros");
			int tipo = c.nextInt();
			
			encargos.encolar(new Encargo(nit, tipo, destino, sector));
			menu();
			break;
		case 2:
			c.printMessageLn(encargos.listar());
			menu();
			break;
		case 3:
			while(!encargos.estaVacia()) {
				try {
					switch (encargos.cima().getValor().getTipo_servicio()) {
					case 1:
						//0-3
						carros[encargos.cima().getValor().getSector()-1].apilar(encargos.cima().getValor());
						break;
					case 2:
						//4-7
						carros[encargos.cima().getValor().getSector()+3].apilar(encargos.cima().getValor());
						break;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				encargos.desencolar();
			}
			c.printMessageLn("Los encargos se han pasado a los carros!!");
			menu();
			break;
		case 4:
			c.printMessageLn("A continuación se mostraran las actividades que se tendrá en el dia: ");
			for (int i = 0; i < carros.length; i++) {
				if(i<=3) {
					c.printMessageLn("C"+(i+1));
					carros[i].listar();
				}else {
					c.printMessageLn("V"+(i-3));
					carros[i].listar();
				}
			}
			menu();
			break;
		case 5:
			c.printMessageLn("A continuación se muestra la forma en que se entregaron las actividades del dia");
			for (int i = 0; i < carros.length; i++) {
				if(i<=3) {
					c.printMessageLn("C"+(i+1));
					carros[i].listar();
					carros[i].eliminar();
				}
			}
			menu();
			break;
		default:
			break;
		}
	}
	
}
