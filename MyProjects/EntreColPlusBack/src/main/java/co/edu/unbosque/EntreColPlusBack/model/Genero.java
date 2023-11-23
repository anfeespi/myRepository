package co.edu.unbosque.EntreColPlusBack.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "generos")
public class Genero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_genero;
	private String genero;
	@JsonBackReference
	@ManyToMany(mappedBy = "generos")
	private Set<Pelicula> peliculas = new HashSet<>();
	
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

	public Set<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Set<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
}
