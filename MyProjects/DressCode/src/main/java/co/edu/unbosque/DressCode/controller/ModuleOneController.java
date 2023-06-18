package co.edu.unbosque.DressCode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.DressCode.model.Parameter;
import co.edu.unbosque.DressCode.repository.ParameterRepository;
import jakarta.transaction.Transactional;

@RestController
@Transactional
public class ModuleOneController {
	@Autowired
	private ParameterRepository prep;
	
	@PostMapping("/parameters/new")
	public ResponseEntity<String> add(@RequestParam Integer nit, @RequestParam String type, @RequestParam String name, @RequestParam String city, @RequestParam float iva, @RequestParam float interest_rate, @RequestParam String bank, @RequestParam String account, @RequestParam String manager_name){
		Parameter temp= new Parameter(nit, type, name, city, iva, interest_rate, bank, account, manager_name);
		prep.save(temp);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con exito");
	}
	
	@GetMapping("/parameters")
	public ResponseEntity<List<Parameter>> showAll(){
		List<Parameter> temp = prep.findAll();
		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}
	
	@PostMapping("/parameters/{id}")
    public ResponseEntity<String> update(@RequestParam Integer nit, @RequestParam String type, @RequestParam String name, @RequestParam String city, @RequestParam float iva, @RequestParam float interest_rate, @RequestParam String bank, @RequestParam String account, @RequestParam String manager_name) {
		Parameter temporal = prep.findById(nit).get();
		temporal = new Parameter(nit, type, name, city, iva, interest_rate, bank, account, manager_name);
		prep.save(temporal);
        return ResponseEntity.status(HttpStatus.OK).body("Dato actualizado");
    }
}
