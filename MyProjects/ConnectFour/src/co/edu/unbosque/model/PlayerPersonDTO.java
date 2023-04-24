package co.edu.unbosque.model;
/**
 * Clase que contiene los atributos o caracteristicas del jugador
 * @author Diego Forero
 * @author Andres Espitia
 * @author Camilo Uribe
 *
 */
public class PlayerPersonDTO extends PlayerDTO {
	/**
	 * Metodo constructor vacio
	 */
	public PlayerPersonDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo constructor heredado de la clase Super
	 * @param name Nombre del jugador
	 * @param team Equipo al que pertenece el jugador
	 */
	public PlayerPersonDTO(String name, String team) {
		super(name, team);
		// TODO Auto-generated constructor stub
	}
}
