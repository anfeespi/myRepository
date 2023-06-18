package co.edu.unbosque.model;

public class MemberDTO {
	private String name;
	private int age;
	private boolean gender;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String name, int age, boolean gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		String g;
		if(isGender()) g = "Masculino";
		else g = "Femenino";
		return "\nNombre: " + name + ", Edad: " + age + ", Genero=" + g;
	}
	
	
}
