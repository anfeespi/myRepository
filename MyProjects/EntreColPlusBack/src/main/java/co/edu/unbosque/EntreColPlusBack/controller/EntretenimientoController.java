package co.edu.unbosque.EntreColPlusBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.EntreColPlusBack.model.Libro;
import co.edu.unbosque.EntreColPlusBack.model.Pelicula;
import co.edu.unbosque.EntreColPlusBack.repository.LibroRepository;
import co.edu.unbosque.EntreColPlusBack.repository.PeliculaRepository;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@Transactional
public class EntretenimientoController {
	@Autowired
	private LibroRepository lrep;
	@Autowired
	private PeliculaRepository prep;
	
	@GetMapping("/libros")
	public ResponseEntity<List<Libro>> showAllBooks(@RequestParam int beg){
		List<Libro> aux = lrep.findAll().subList(beg<lrep.findAll().size() ? beg:lrep.findAll().size()-1, beg+100<lrep.findAll().size() ? beg+100:lrep.findAll().size()-1);
		if(aux.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(aux);
	}
	
	@GetMapping("/peliculas")
	public ResponseEntity<List<Pelicula>> showAllMovies(@RequestParam int beg){
		List<Pelicula> aux = prep.findAll().subList(beg<prep.findAll().size() ? beg:prep.findAll().size()-1, beg+100<prep.findAll().size() ? beg+100:prep.findAll().size()-1);
		if(aux.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(aux);
	}
	
}
