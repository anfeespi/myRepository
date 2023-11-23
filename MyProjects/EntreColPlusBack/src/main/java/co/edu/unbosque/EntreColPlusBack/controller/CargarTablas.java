package co.edu.unbosque.EntreColPlusBack.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.EntreColPlusBack.model.Bono;
import co.edu.unbosque.EntreColPlusBack.model.Empleado;
import co.edu.unbosque.EntreColPlusBack.model.Genero;
import co.edu.unbosque.EntreColPlusBack.model.Libro;
import co.edu.unbosque.EntreColPlusBack.model.Pelicula;
import co.edu.unbosque.EntreColPlusBack.repository.BonoRepository;
import co.edu.unbosque.EntreColPlusBack.repository.EmpleadoRepository;
import co.edu.unbosque.EntreColPlusBack.repository.GeneroRepository;
import co.edu.unbosque.EntreColPlusBack.repository.LibroRepository;
import co.edu.unbosque.EntreColPlusBack.repository.PeliculaRepository;
import co.edu.unbosque.EntreColPlusBack.util.DatReader;
import co.edu.unbosque.EntreColPlusBack.util.ExcelReader;
import co.edu.unbosque.EntreColPlusBack.util.JsonReader;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@Transactional
public class CargarTablas {
	@Autowired
	private LibroRepository lrep;
	@Autowired
	private EmpleadoRepository erep;
	@Autowired
	private BonoRepository brep;
	@Autowired
	private PeliculaRepository prep;
	@Autowired
	private GeneroRepository grep;
	private ExcelReader er = new ExcelReader();
	private JsonReader jr = new JsonReader();
	private DatReader dr = new DatReader();
	
	@PostMapping("/save/libros")
	public void saveAllBooks(Model model) {
		for (Libro libro : jr.readJson("src/main/java/co/edu/unbosque/EntreColPlusBack/files/books.json")) {
			saveBook(libro, model);
		}
	}
	
	public void saveBook(@Valid Libro l, Model model) {
		lrep.save(l);
	}
	
	@PostMapping("/save/nomina")
	public void saveEmployeesBonus(Model model) {
		ArrayList<Empleado> em = er.readExcelEmpleados("src/main/java/co/edu/unbosque/EntreColPlusBack/files/Nomina.xlsx");
		ArrayList<Bono> bn = er.readExcelBonos("src/main/java/co/edu/unbosque/EntreColPlusBack/files/Nomina.xlsx");
		
		for (int i = 0; i < em.size(); i++) {
			bn.get(i).setEmpleado(em.get(i));
			saveEmployee(em.get(i), model);
			saveBonus(bn.get(i), model);
		}
	}
	
	public void saveEmployee(@Valid Empleado e, Model model) {
		erep.save(e);
	}
	
	
	public void saveBonus(@Valid Bono b, Model model) {
		brep.save(b);
	}
	
	@PostMapping("/save/movies")
	public void saveMoviesNGenders(Model model) {
		
		dr.readDat("src/main/java/co/edu/unbosque/EntreColPlusBack/files/movies.dat");
		
		for (Genero g : dr.getG()) {
			saveGender(g, model);
		}
		for (Pelicula p : dr.getP()) {
			saveMovie(p, model);
		}
		
	}
	
	public void saveMovie(@Valid Pelicula p, Model model) {
		prep.save(p);
	}
	
	public void saveGender(@Valid Genero g, Model model) {
		grep.save(g);
	}
	
}
