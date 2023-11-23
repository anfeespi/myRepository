package co.edu.unbosque.model;

public class Genero {
	private Integer id_genero;
	private String genero;
	
	public Genero() {
		// TODO Auto-generated constructor stub
	}

	public Genero(Integer id_genero, String genero) {
		super();
		this.id_genero = id_genero;
		this.genero = genero;
	}

	public Integer getId_genero() {
		return id_genero;
	}

	public void setId_genero(Integer id_genero) {
		this.id_genero = id_genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}	
}
