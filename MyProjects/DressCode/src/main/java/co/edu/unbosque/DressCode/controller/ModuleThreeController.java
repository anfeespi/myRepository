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

import co.edu.unbosque.DressCode.model.Supplier;
import co.edu.unbosque.DressCode.repository.SupplierRepository;
import jakarta.transaction.Transactional;

@RestController
@Transactional
public class ModuleThreeController {
	@Autowired
	private SupplierRepository srep;
	
	@PostMapping("/suppliers/new")
	public ResponseEntity<String> add(@RequestParam String nit, @RequestParam String name, @RequestParam String address, @RequestParam String phone_number, @RequestParam String city) {
		Supplier temp = new Supplier(nit, name, address, phone_number, city);
		srep.save(temp);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con exito");
	}
	
	@GetMapping("/suppliers")
	public ResponseEntity<List<Supplier>> showAll(){
		List<Supplier> temp = srep.findAll();
		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}
	
	@PostMapping("/suppliers/update/{id}")
    public ResponseEntity<String> update(@RequestParam Integer id, @RequestParam String update, @RequestParam String new_param) {
		Supplier temporal = srep.findById(id).get();
		switch (update) {
		case "NIT":
			temporal.setNit(new_param);
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
		case "Ciudad":
			temporal.setCity(new_param);
			break;
		}
		srep.save(temporal);
        return ResponseEntity.status(HttpStatus.OK).body("Dato actualizado");
    }
	
	@DeleteMapping("/suppliers/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id, @RequestParam String nit) {
		Supplier temporal = srep.findById(id).get();
		if (nit.equals(temporal.getNit())) {			
			srep.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Dato eliminado");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("El NIT no coincide");
	}
}
