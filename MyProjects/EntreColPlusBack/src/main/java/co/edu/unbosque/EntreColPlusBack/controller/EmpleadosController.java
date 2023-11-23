package co.edu.unbosque.EntreColPlusBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.EntreColPlusBack.model.Empleado;
import co.edu.unbosque.EntreColPlusBack.repository.EmpleadoRepository;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@Transactional
public class EmpleadosController {
	@Autowired
	private EmpleadoRepository erep;
	
	@GetMapping("/empleados")
	public ResponseEntity<List<Empleado>> showAll(){
		List<Empleado> aux = erep.findAll();
		if(aux.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(aux);
	}
	
}
