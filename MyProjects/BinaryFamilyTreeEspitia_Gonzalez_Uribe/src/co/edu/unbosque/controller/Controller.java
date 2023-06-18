package co.edu.unbosque.controller;

import co.edu.unbosque.model.FamilyDAO;
import co.edu.unbosque.model.MemberDTO;
import co.edu.unbosque.view.Panes;

public class Controller {
	private String menu = "\t--Bienvenido, elija una opción: \n"
						+ "1. Insertar miembro de familia (* para ser la raiz)\n"
						+ "2. Imprimir el contenido del arbol (PosOrden)\n"
						+ "3. Buscar miembro de la familia (Existe o no)\n"
						+ "4. Cantidad de miembros de la familia\n"
						+ "5. Crear copia del arbol según la edad\n"
						+ "6. Imprimir\n"
						+ "0. Salir";
	private String menu_6 = "1. Imprimir en Inorden\n"
						  + "2. Imprimir en Posorden\n";
	private Panes p;
	private FamilyDAO fdao;
	private FamilyDAO copy;
	
	public Controller() {
		init();
		exe();
	}

	private void init() {
		p = new Panes();
		fdao = new FamilyDAO();
	}

	private void exe() {
		int opc = 0;
		while(true) {
			try {
				opc = p.readInt(menu);
				break;
			}catch (Exception e) {
				// TODO: handle exception
			}			
		}
		
		switch (opc) {
		case 1:
			String name = p.readString("Ingrese el nombre: ");
			int age = p.readInt("Ingrese la edad: ");
			boolean gender;
			String options[] = {"1. Masculino", "2. Femenino"};
			if(p.readOption("Seleccione el genero: ", "Genero", options ) == 1) {
				gender = true;
			}else {
				gender = false;
			}
			
			String father = p.readString("Ingrese el nombre del padre (* si será la raiz): ");
			
			if(fdao.add(new MemberDTO(name, age, gender), father)) {
				p.printMessage("Añadido con éxito!");
			}else {
				p.printMessage("No se ha podido encontrar al padre!");
			}
			
			exe();
			break;
		case 2:
			p.printMessage(fdao.postOrder(fdao.getRoot()));
			exe();
			break;
		case 3:
			String find = p.readString("Ingrese el nombre a buscar");
			
			if(fdao.exist(find)) {
				p.printMessage(find+" si existe en este árbol.");
			}else {
				p.printMessage(find+" no existe en este árbol!!");
			}
			exe();
			break;
		case 4:
			p.printMessage("La cantidad de miembros de la familia es: "+fdao.countNodes(fdao.getRoot()));
			exe();
			break;
		case 5:
			p.printMessage("Copiando arbol...");
			copy = fdao.passTo();
			exe();
			break;
		case 6:
			menuSix();
			exe();
			break;

		default:
			break;
		}
	}
	
	private void menuSix() {
		int opc = p.readInt(menu_6);
		
		switch (opc) {
		case 1:
			p.printMessage(copy.inOrder(copy.getRoot()));
			break;
		case 2:
			p.printMessage(copy.preOrder(copy.getRoot()));
			break;

		default:
			break;
		}
	}
}
