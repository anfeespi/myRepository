package co.edu.unbosque.EntreColPlusBack.model;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pelicula;
	private String titulo;
	private Year anio_lanzamiento;
	@JsonManagedReference
	@ManyToMany(cascade = { CascadeType.REFRESH })
	@JoinTable(
			name = "peliculas_generos",
			joinColumns = { @JoinColumn(name = "id_pelicula") },
			inverseJoinColumns = { @JoinColumn(name = "id_genero") }
	)
	private Set<Genero> generos = new HashSet<>();
	
	
	public Pelicula() {
		// TODO Auto-generated constructor stub
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

	public Set<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}
	
}
