package co.edu.unbosque.controller;

import co.edu.unbosque.model.ApplicantDAO;
import co.edu.unbosque.model.ApplicantDTO;
import co.edu.unbosque.model.ExecutiveDAO;
import co.edu.unbosque.model.ExecutiveDTO;
import co.edu.unbosque.model.PersonDAO;
import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.model.StudentDAO;
import co.edu.unbosque.model.StudentDTO;
import co.edu.unbosque.view.Console;

/**
 * 
 * Clase controlador
 * @author Andres Espitia
 * @author Diego Forero
 *
 */
public class Controller {
	/**
	 * DAO de persona
	 */
	private PersonDAO p;
	/**
	 * DAO de estudiante
	 */
	private StudentDAO s;
	/**
	 * DAO de ejecutivo
	 */
	private ExecutiveDAO e;
	/**
	 * DAO de aspirante
	 */
	private ApplicantDAO a;
	/**
	 * Consola
	 */
	private Console c;
	/**
	 * Menu principal
	 */
	private String main_menu = "\nBienvenido!! \nQue desea hacer?\n "
								+ "1. Agregar Persona. \n "
								+ "2. Actualizar Persona. \n "
								+ "3. Eliminar Persona. \n "
								+ "4. Mostrar Personas.";
	/**
	 * Menu para añadir personas
	 */
	private String add_menu = "Que desea agregar?\n "
							+ "1. Agregar Persona. \n "
							+ "2. Agregar Estudiante. \n "
							+ "3. Agregar Ejecutivo. \n "
							+ "4. Agregar Aspirante.";
	/**
	 * Menu para actualizar personas
	 */
	private String update_menu = "Que desea actualizar?\n "
								+ "1. Actualizar Persona. \n "
								+ "2. Actualizar Estudiante. \n "
								+ "3. Actualizar Ejecutivo. \n "
								+ "4. Actualizar Aspirante.";
	/**
	 * Menu para eliminar personas
	 */
	private String delete_menu = "Que desea eliminar?\n "
								+ "1. Eliminar Persona. \n "
								+ "2. Eliminar Estudiante. \n "
								+ "3. Eliminar Ejecutivo. \n "
								+ "4. Eliminar Aspirante.";
	/**
	 * Menu para mostrar personas
	 */
	private String show_menu = "Que desea mostrar?\n "
								+ "1. Mostrar a Todos. \n "
								+ "2. Mostrar Estudiantes. \n "
								+ "3. Mostrar Ejecutivos. \n "
								+ "4. Mostrar Aspirantes.";
	/**
	 * Constructor
	 */
	public Controller() {
		p = new PersonDAO();
		s = new StudentDAO();
		e = new ExecutiveDAO();
		a = new ApplicantDAO();
		c = new Console();
		init();
	}
	
	/**
	 * Metodo para inicializar
	 */
	public void init() {
		c.printMessageLn(main_menu);
		switch (c.nextInt()) {
		case 1:			
			add();
			break;
		case 2:
			update();	
			break;
		case 3:
			delete();
			break;
		case 4:
			show();									
			break;
		default:
			close();
			break;
		}
	}
	
	/**
	 * Metodo para cerrar el menu
	 */
	public void close() {
		c.printMessageLn("Seguro desea abandonar?\n 1. Si. \n 2. No.");
		switch (c.nextInt()) {
		case 2:	
			init();
			break;
		default:
			break;
		}
	}
	
	/**
	 * Metodo para añadir
	 */
	public void add() {
		c.printMessageLn(add_menu);
		String name, food, color;
		int age;
		PersonDTO aux;
		
		switch (c.nextInt()) {
			case 1:			
				c.printMessageLn("Nombre:");
				name = c.nextLine();
				c.printMessageLn("Edad:");
				age = c.nextInt();
				c.printMessageLn("Comida Favorita:");
				food = c.nextLine();
				c.printMessageLn("Color Favorito:");
				color = c.nextLine();
				aux = new PersonDTO(name, age, food, color);
				p.addPerson(aux);
				c.printMessageLn("Persona agregada!!");
				break;
			case 2:
				c.printMessageLn("Nombre:");
				name = c.nextLine();
				c.printMessageLn("Edad:");
				age = c.nextInt();
				c.printMessageLn("Comida Favorita:");
				food = c.nextLine();
				c.printMessageLn("Color Favorito:");
				color = c.nextLine();
				c.printMessageLn("Materias Perdidas:");
				int missing_subjects = c.nextInt();
				aux = new StudentDTO(name, age, food, color, missing_subjects);
				s.addPerson(aux);
				c.printMessageLn("Persona agregada!!");
				break;
			case 3:
				c.printMessageLn("Nombre:");
				name = c.nextLine();
				c.printMessageLn("Edad:");
				age = c.nextInt();
				c.printMessageLn("Comida Favorita:");
				food = c.nextLine();
				c.printMessageLn("Color Favorito:");
				color = c.nextLine();
				c.printMessageLn("Cargo Administrativo:");
				String position = c.nextLine();
				aux = new ExecutiveDTO(name, age, food, color, position);
				e.addPerson(aux);
				c.printMessageLn("Persona agregada!!");
				break;
			case 4:
				c.printMessageLn("Nombre:");
				name = c.nextLine();
				c.printMessageLn("Edad:");
				age = c.nextInt();
				c.printMessageLn("Comida Favorita:");
				food = c.nextLine();
				c.printMessageLn("Color Favorito:");
				color = c.nextLine();
				c.printMessageLn("Carrera a la que aspira:");
				String career = c.nextLine();
				aux = new ApplicantDTO(name, age, food, color, career);
				a.addPerson(aux);
				c.printMessageLn("Persona agregada!!");
				break;
			default:
				init();
				break;
		}
		init();
	}
	
	/**
	 * Metodo para actualizar
	 */
	public void update() {
		c.printMessageLn(update_menu);
		switch (c.nextInt()) {
			case 1:			
				updatePerson();
				break;
			case 2:
				updateStudent();
				break;
			case 3:
				updateExecutive();
				break;
			case 4:
				updateApplicant();
				break;
			default:
				init();
				break;
		}
		init();
	}
	
	/**
	 * Metodo para eliminar
	 */
	public void delete() {
		c.printMessageLn(delete_menu);
		switch (c.nextInt()) {
		case 1:
			deletePerson();
			break;
		case 2:
			deleteStudent();
			break;
		case 3:
			deleteExecutive();
			break;
		case 4:
			deleteApplicant();
			break;
		default:
			break;
		}
		init();
	}
	
	/**
	 * Metodo para mostrar
	 */
	public void show() {
		c.printMessageLn(show_menu);
		
		switch (c.nextInt()) {
		case 1:
			c.printMessageLn("\nPersonas: \n"+
					"Nombre - Edad - Comida - Color");
			for (PersonDTO paux : p.getPlist()) {
				
				String[] colums = paux.toString().split(",");
				c.printMessageLn(colums[0]+" - "+colums[1]+" - "+colums[2]+" - "+colums[3]);
			}
			showStudent();
			showApplicant();
			showExecutive();
			break;
		case 2:
			showStudent();
			break;
		case 3:
			showExecutive();
			break;
		case 4:
			showApplicant();
			break;
		default:
			break;
		}
		init();
	}
	
	/**
	 * Metodo que muestra estudiantes
	 */
	public void showStudent() {
		c.printMessageLn("\nEstudiantes: \n"+
				"Nombre - Edad - Comida - Color - Materias");
		for (PersonDTO saux : s.getSlist()) {
			StudentDTO aux = (StudentDTO)saux;
			
			String[] colums = aux.toString().split(",");
			c.printMessageLn(colums[0]+" - "+colums[1]+" - "+colums[2]+" - "+colums[3]+" - "+colums[4]);
		}
	}
	
	/**
	 * Metodo que muestra aspirantes
	 */
	public void showApplicant() {
		c.printMessageLn("\nAspirantes: \n"+
				"Nombre - Edad - Comida - Color - Carrera");
		for (PersonDTO saux : a.getAlist()) {
			ApplicantDTO aux = (ApplicantDTO)saux;
			
			String[] colums = aux.toString().split(",");
			c.printMessageLn(colums[0]+" - "+colums[1]+" - "+colums[2]+" - "+colums[3]+" - "+colums[4]);
		}
	}
	
	/**
	 * Metodo que muestra ejecutivos
	 */
	public void showExecutive() {
		c.printMessageLn("\nEjecutivos: \n"+
				"Nombre - Edad - Comida - Color - Cargo");
		for (PersonDTO saux : e.getElist()) {
			ExecutiveDTO aux = (ExecutiveDTO)saux;
			
			String[] colums = aux.toString().split(",");
			c.printMessageLn(colums[0]+" - "+colums[1]+" - "+colums[2]+" - "+colums[3]+" - "+colums[4]);
		}
	}
	
	/**
	 * Metodo que elimina personas
	 */
	public void deletePerson() {
		String name;
		c.printMessageLn("Ingrese el nombre: ");
		name = c.nextLine();
		if(p.deletePerson(name)) {
			c.printMessageLn(name+" eliminado con exito!!");
		}else {
			c.printMessageLn(name+" no se encuentra en la lista!");
		}
	}
	
	/**
	 * Metodo que elimina estudiantes
	 */
	public void deleteStudent() {
		String name;
		c.printMessageLn("Ingrese el nombre: ");
		name = c.nextLine();
		if(s.deletePerson(name)) {
			c.printMessageLn(name+" eliminado con exito!!");
		}else {
			c.printMessageLn(name+" no se encuentra en la lista!");
		}
	}
	
	/**
	 * Metodo que elimina aspirantes
	 */
	public void deleteApplicant() {
		String name;
		c.printMessageLn("Ingrese el nombre: ");
		name = c.nextLine();
		if(a.deletePerson(name)) {
			c.printMessageLn(name+" eliminado con exito!!");
		}else {
			c.printMessageLn(name+" no se encuentra en la lista!");
		}
	}
	
	/**
	 * Metodo que elimina ejecutivos
	 */
	public void deleteExecutive() {
		String name;
		c.printMessageLn("Ingrese el nombre: ");
		name = c.nextLine();
		if(e.deletePerson(name)) {
			c.printMessageLn(name+" eliminado con exito!!");
		}else {
			c.printMessageLn(name+" no se encuentra en la lista!");
		}
	}
	
	/**
	 * Metodo que actualiza ejecutivos
	 */
	public void updateExecutive() {
		String name;
		int age;
		c.printMessageLn("Ingrese el nombre a buscar:");
		name = c.nextLine();
		c.printMessageLn("Ingrese la edad a cambiar:");
		age = c.nextInt();
		if(e.updatePerson(name, age)) {
			c.printMessageLn("Edad actualizada para "+name+"!!");				
		}else {
			c.printMessageLn("No se ha encontrado a "+name);
		}
	}
	
	/**
	 * Metodo que actualiza aspirantes
	 */
	public void updateApplicant() {
		String name;
		int age;
		c.printMessageLn("Ingrese el nombre a buscar:");
		name = c.nextLine();
		c.printMessageLn("Ingrese la edad a cambiar:");
		age = c.nextInt();
		if(a.updatePerson(name, age)) {
			c.printMessageLn("Edad actualizada para "+name+"!!");				
		}else {
			c.printMessageLn("No se ha encontrado a "+name);
		}
	}
	
	/**
	 * Metodo que actualiza estudiantes
	 */
	public void updateStudent() {
		String name;
		int age;
		c.printMessageLn("Ingrese el nombre a buscar:");
		name = c.nextLine();
		c.printMessageLn("Ingrese la edad a cambiar:");
		age = c.nextInt();
		if(s.updatePerson(name, age)) {
			c.printMessageLn("Edad actualizada para "+name+"!!");				
		}else {
			c.printMessageLn("No se ha encontrado a "+name);
		}
	}
	
	/**
	 * Metodo que actualiza personas
	 */
	public void updatePerson() {
		String name;
		int age;
		c.printMessageLn("Ingrese el nombre a buscar:");
		name = c.nextLine();
		c.printMessageLn("Ingrese la edad a cambiar:");
		age = c.nextInt();
		if(p.updatePerson(name, age)) {
			c.printMessageLn("Edad actualizada para "+name+"!!");				
		}else {
			c.printMessageLn("No se ha encontrado a "+name);
		}
	}
}
