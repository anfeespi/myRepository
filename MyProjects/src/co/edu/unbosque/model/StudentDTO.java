package co.edu.unbosque.model;

/**
 * 
 * DTO de estudiante
 * @author Andres Espitia
 * @author Diego Forero
 *
 */
public class StudentDTO extends PersonDTO{
	/**
	 * Materias perdidas
	 */
	private int missing_subjects;
	
	/**
	 * Constructor
	 */
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor usando campos
	 * @param missing_subjects
	 */
	public StudentDTO(int missing_subjects) {
		super();
		this.missing_subjects = missing_subjects;
	}

	/**
	 * Constructor desde la super clase
	 * @param name
	 * @param age
	 * @param food
	 * @param color
	 * @param missing_subjects
	 */
	public StudentDTO(String name, int age, String food, String color, int missing_subjects) {
		super(name, age, food, color);
		this.missing_subjects = missing_subjects;
	}

	
	
	/**
	 * @return the missing_subjects
	 */
	public int getMissing_subjects() {
		return missing_subjects;
	}
	/**
	 * @param missing_subjects the missing_subjects to set
	 */
	public void setMissing_subjects(int missing_subjects) {
		this.missing_subjects = missing_subjects;
	}
	@Override
	public String toString() {
		String aux = this.getName()+","+this.getAge()+","+this.getFood()+","+this.getColor()+","+this.missing_subjects;
		return aux;
	}
}
