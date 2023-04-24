package co.edu.unbosque.model;
/**
 * Clase de tipo DTO que establece los atributos del jugador
 * @author Diego Forero
 * @author Andres Espitia
 * @author Camilo Uribe
 *
 */
public class PlayerDTO {
	/**
	 *  Nombre que se le asigna al jugador
	 */
	private String name;
	/**
	 * Equipo al que pertenece el jugador (Autobots o Decepticons)
	 */
	private String team;
	/**
	 * Metodo constructor
	 */
	public PlayerDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo constructor heredado de la clase super
	 * @param name Nombre del jugador
	 * @param team Equipo al que pertenece el jugador
	 */
	public PlayerDTO(String name, String team) {
		super();
		this.name = name;
		this.team = team;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		return this.name+";"+this.team;
	}
}
