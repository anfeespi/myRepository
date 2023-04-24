package co.edu.unbosque.model;
/**
 * Clase de tipo DTO que establece los atributos de la CPU que actua como jugador
 * @author Diego Forero
 * @author Andres Espitia
 * @author Camilo Uribe
 *
 */
public class PlayerCPUDTO extends PlayerDTO{
	/**
	 * Metodo constructor vacio
	 */
	public PlayerCPUDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo constructor de la clase super
	 * @param name Nombre del jugador (No asigna ya que es la CPU)
	 * @param team Equipo del jugador (No asigna ya que es la CPU)
	 */
	public PlayerCPUDTO(String name, String team) {
		super(name, team);
		// TODO Auto-generated constructor stub
	}
}
