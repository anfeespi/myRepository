package co.edu.unbosque.model;

public class PeliculaGeneros {
	private int id_pelicula;
	private String titulo;
	private int anio_lanzamiento;
	private int num_gen;
	private String generos;
	
	public PeliculaGeneros() {
		// TODO Auto-generated constructor stub
	}

	public int getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio_lanzamiento() {
		return anio_lanzamiento;
	}

	public void setAnio_lanzamiento(int anio_lanzamiento) {
		this.anio_lanzamiento = anio_lanzamiento;
	}

	public String getGeneros() {
		return generos;
	}

	public void setGeneros(String generos) {
		this.generos = generos;
	}

	public int getNum_gen() {
		return num_gen;
	}

	public void setNum_gen(int num_gen) {
		this.num_gen = num_gen;
	}
}
