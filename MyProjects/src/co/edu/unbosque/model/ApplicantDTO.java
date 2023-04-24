package co.edu.unbosque.model;

/**
 * 
 * DTO de aspirante
 * @author Andres Espitia
 * @author Diego Forero
 *
 */
public class ApplicantDTO extends PersonDTO{
	/**
	 * Carrera
	 */
	private String career;
	
	/**
	 * Constructor vacio
	 */
	public ApplicantDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con campos
	 * @param career
	 */
	public ApplicantDTO(String career) {
		super();
		this.career = career;
	}

	/**
	 * Constructor desde la superclase
	 * @param name
	 * @param age
	 * @param food
	 * @param color
	 * @param career
	 */
	public ApplicantDTO(String name, int age, String food, String color, String career) {
		super(name, age, food, color);
		this.career = career;
	}
	
	/**
	 * @return the career
	 */
	public String getCareer() {
		return career;
	}

	/**
	 * @param career the career to set
	 */
	public void setCareer(String career) {
		this.career = career;
	}

	@Override
	public String toString() {
		String aux = this.getName()+","+this.getAge()+","+this.getFood()+","+this.getColor()+","+this.career;
		return aux;
	}
}
