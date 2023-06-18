package co.edu.unbosque.DressCode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.DressCode.model.Customer;
import co.edu.unbosque.DressCode.repository.CustomerRepository;
import jakarta.transaction.Transactional;

@RestController
@Transactional
public class ModuleTwoController {
	@Autowired
	private CustomerRepository crep;
	
	@PostMapping("/customers/new")
	public ResponseEntity<String> add(@RequestParam String document, @RequestParam String name, @RequestParam String address, @RequestParam String phone_number, @RequestParam String email) {
		Customer temp = new Customer(document, name, address, phone_number, email);
		crep.save(temp);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con exito");
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> showAll(){
		List<Customer> temp = crep.findAll();
		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}
	
	@PostMapping("/customers/update/{id}")
    public ResponseEntity<String> update(@RequestParam Integer id, @RequestParam String update, @RequestParam String new_param) {
		Customer temporal = crep.findById(id).get();
		switch (update) {
		case "Cedula":
			temporal.setDocument(new_param);
			break;
		case "Nombre":
			temporal.setName(new_param);
			break;
		case "Direccion":
			temporal.setAddress(new_param);
			break;
		case "Telefono":
			temporal.setPhone_number(new_param);
			break;
		case "E-mail":
			temporal.setEmail(new_param);
			break;
		}
		crep.save(temporal);
        return ResponseEntity.status(HttpStatus.OK).body("Dato actualizado");
    }
	
	@DeleteMapping("/customers/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id, @RequestParam String document) {
		Customer temporal = crep.findById(id).get();
		if (document.equals(temporal.getDocument())) {			
			crep.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Dato eliminado");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("El nombre no coincide");
	}
}
