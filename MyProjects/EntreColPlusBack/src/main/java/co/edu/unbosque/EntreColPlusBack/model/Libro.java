package co.edu.unbosque.EntreColPlusBack.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_libro;
	private String titulo;
	private String autores;
	private Float rating_promedio;
	private String isbn;
	private String isbn13;
	private String codigo_idioma;
	private Integer num_paginas;
	private Integer contador_rating;
	private Integer contador_reviews;
	private Date fecha_publicacion;
	private String editor;
	
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public Libro(Integer id_libro, String titulo, String autores, Float rating_promedio, String isbn,
			String isbn13, String codigo_idioma, Integer num_paginas, Integer contador_rating,
			Integer contador_reviews, Date fecha_publicacion, String editor) {
		super();
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.autores = autores;
		this.rating_promedio = rating_promedio;
		this.isbn = isbn;
		this.isbn13 = isbn13;
		this.codigo_idioma = codigo_idioma;
		this.num_paginas = num_paginas;
		this.contador_rating = contador_rating;
		this.contador_reviews = contador_reviews;
		this.fecha_publicacion = fecha_publicacion;
		this.editor = editor;
	}

	public Integer getId_libro() {
		return id_libro;
	}

	public void setId_libro(Integer id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public Float getRating_promedio() {
		return rating_promedio;
	}

	public void setRating_promedio(Float rating_promedio) {
		this.rating_promedio = rating_promedio;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getCodigo_idioma() {
		return codigo_idioma;
	}

	public void setCodigo_idioma(String codigo_idioma) {
		this.codigo_idioma = codigo_idioma;
	}

	public Integer getNum_paginas() {
		return num_paginas;
	}

	public void setNum_paginas(Integer num_paginas) {
		this.num_paginas = num_paginas;
	}

	public Integer getContador_rating() {
		return contador_rating;
	}

	public void setContador_rating(Integer contador_rating) {
		this.contador_rating = contador_rating;
	}

	public Integer getContador_reviews() {
		return contador_reviews;
	}

	public void setContador_reviews(Integer contador_reviews) {
		this.contador_reviews = contador_reviews;
	}

	public Date getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(Date fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
	
}
