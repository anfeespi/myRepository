package co.edu.unbosque.model;

public class Libro {
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
	private String fecha_publicacion;
	private String editor;
	
	public Libro() {
		// TODO Auto-generated constructor stub
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

	public String getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
	
}
