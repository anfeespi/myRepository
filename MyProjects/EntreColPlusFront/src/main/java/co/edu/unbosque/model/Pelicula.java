package co.edu.unbosque.model;

import java.time.Year;
import java.util.ArrayList;

public class Pelicula {
	private Integer id_pelicula;
	private String titulo;
	private Year anio_lanzamiento;
	private ArrayList<Genero> generos;
	
	
	public Pelicula() {
		generos = new ArrayList<>();
	}

	public Pelicula(Integer id_pelicula, String titulo, Year anio_lanzamiento) {
		super();
		this.id_pelicula = id_pelicula;
		this.titulo = titulo;
		this.anio_lanzamiento = anio_lanzamiento;
	}

	public Integer getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(Integer id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Year getAnio_lanzamiento() {
		return anio_lanzamiento;
	}

	public void setAnio_lanzamiento(Year anio_lanzamiento) {
		this.anio_lanzamiento = anio_lanzamiento;
	}

	public ArrayList<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
	}
	
}
