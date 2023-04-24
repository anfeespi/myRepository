package co.edu.unbosque.model;

/**
 * 
 * DAO de persona
 * @author Andres Espitia
 * @author Diego Forero
 *
 */
public class PersonDTO {
	/**
	 * Nombre
	 */
	private String name;
	/**
	 * Edad
	 */
	private int age;
	/**
	 * Comida favorita
	 */
	private String food;
	/**
	 * Color favorito
	 */
	private String color;
	
	/**
	 * Constructor vacio
	 */
	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Contructor con campos
	 * @param name
	 * @param age
	 * @param food
	 * @param color
	 */
	public PersonDTO(String name, int age, String food, String color) {
		super();
		this.name = name;
		this.age = age;
		this.food = food;
		this.color = color;
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the food
	 */
	public String getFood() {
		return food;
	}

	/**
	 * @param food the food to set
	 */
	public void setFood(String food) {
		this.food = food;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		String aux = this.name+","+this.age+","+this.food+","+this.color;
		return aux;
	}
}
