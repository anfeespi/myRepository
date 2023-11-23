package co.edu.unbosque.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import co.edu.unbosque.beans.EntreColPlusFrontBean;
import co.edu.unbosque.model.Genero;
import co.edu.unbosque.model.Libro;
import co.edu.unbosque.model.Pelicula;
import co.edu.unbosque.model.PeliculaGeneros;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class PeliculasLibrosService {
	
	private List<PeliculaGeneros> pelGen;
	private List<Libro> libros;
	private List<Libro> mejores_libros;
	private List<Libro> peores_libros;
	private String[] generos = {"Adventure", "Animation", "Children", "Comedy", "Fantasy", "Romance", "Drama", "Action", "Crime", "Thriller", "Horror", "Mystery", "Sci-Fi", "IMAX", "Documentary", "War", "Musical", "Film-Noir", "Western", "(no genres listed)"};
	private String[] anios;
	
	@PostConstruct
	private void init() {
		List<Pelicula> aux = EntreColPlusFrontBean.peliculas;
		libros = EntreColPlusFrontBean.libros;
		peores_libros = libros.stream().sorted(Comparator.comparingDouble(Libro::getRating_promedio)).collect(Collectors.toList()).subList(0, 5);
		mejores_libros = libros.stream().sorted(Comparator.comparingDouble(Libro::getRating_promedio).reversed()).collect(Collectors.toList()).subList(0, 5);
		pelGen = new ArrayList<>();
		for (Pelicula pel : aux) {
			PeliculaGeneros pelaux = new PeliculaGeneros();
			pelaux.setId_pelicula(pel.getId_pelicula());
			pelaux.setTitulo(pel.getTitulo());
			pelaux.setAnio_lanzamiento(Integer.parseInt(pel.getAnio_lanzamiento().toString()));
			String generos = "";
			for (Genero g : pel.getGeneros()) {
				generos = g.getGenero() + " / " + generos;
				
			}
			pelaux.setGeneros(generos.substring(0, generos.length()-2));
			pelaux.setNum_gen(pel.getGeneros().size());
			pelGen.add(pelaux);
		}
		Set<Integer> auxanios = new HashSet<>();
		for (Libro lib : libros) {
			auxanios.add(Integer.parseInt(lib.getFecha_publicacion().substring(6, lib.getFecha_publicacion().length())));
		}
		int i = 0;
		anios = new String[auxanios.size()];
		for (Integer integer : auxanios) {
			anios[i] = integer+"";
			i++;
		}
	}
	
	public List<Pelicula> getPeliculas() {
		return EntreColPlusFrontBean.peliculas;
	}

	public List<PeliculaGeneros> getPelGen() {
		return pelGen;
	}

	public void setPelGen(List<PeliculaGeneros> pelGen) {
		this.pelGen = pelGen;
	}

	public String[] getGeneros() {
		return generos;
	}

	public void setGeneros(String[] generos) {
		this.generos = generos;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public List<Libro> getMejores_libros() {
		return mejores_libros;
	}

	public void setMejores_libros(List<Libro> mejores_libros) {
		this.mejores_libros = mejores_libros;
	}

	public List<Libro> getPeores_libros() {
		return peores_libros;
	}

	public void setPeores_libros(List<Libro> peores_libros) {
		this.peores_libros = peores_libros;
	}

	public String[] getAnios() {
		return anios;
	}

	public void setAnios(String[] anios) {
		this.anios = anios;
	}
}
