package co.edu.unbosque.model;

/**
 * 
 * DTO de ejecutivo
 * @author Andres Espitia
 * @author Diego Forero
 *
 */
public class ExecutiveDTO extends PersonDTO {
	/**
	 * Cargo
	 */
	private String position;
	
	/**
	 * Constructor vacio
	 */
	public ExecutiveDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor usando campos
	 * @param position
	 */
	public ExecutiveDTO(String position) {
		super();
		this.position = position;
	}

	/**
	 * Constructor desde la superclase
	 * @param name
	 * @param age
	 * @param food
	 * @param color
	 * @param position
	 */
	public ExecutiveDTO(String name, int age, String food, String color, String position) {
		super(name, age, food, color);
		this.position = position;
	}
	
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		String aux = this.getName()+","+this.getAge()+","+this.getFood()+","+this.getColor()+","+this.position;
		return aux;
	}
}
