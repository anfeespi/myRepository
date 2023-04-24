package co.edu.unbosque.model;

import java.util.ArrayList;
/**
 * 
 * Interfaz de CRUD
 * @author Andres Espitia
 * @author Diego Forero
 *
 */
public interface CRUDInterface {
	/**
	 * Metodo para cargar la informacion
	 */
	public abstract void loadInfo();
	/**
	 * Metodo para guardar la informacion
	 * @param plist
	 * @return
	 */
	public abstract String saveInfo(ArrayList<PersonDTO> plist);
	/**
	 * Metodo para añadir una persona
	 * @param p
	 */
	public abstract void addPerson(PersonDTO p);
	/**
	 * Metodo para actualizar una persona
	 * @param name
	 * @param aux_age
	 * @return
	 */
	public abstract boolean updatePerson(String name, int aux_age);
	/**
	 * Metodo para eliminar una persona
	 * @param name
	 * @return
	 */
	public abstract boolean deletePerson(String name);
}
