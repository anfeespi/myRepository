package co.edu.unbosque.model;

public class CardsDTO {
	private String type;
	private String color;
	
	public CardsDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CardsDTO(String type, String color) {
		super();
		this.type = type;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return type+"_"+color;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
