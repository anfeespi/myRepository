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

import co.edu.unbosque.DressCode.model.Product;
import co.edu.unbosque.DressCode.repository.ProductRepository;
import jakarta.transaction.Transactional;

@RestController
@Transactional
public class ModuleFourController {
	@Autowired
	private ProductRepository prep;
	
	@PostMapping("/products/new")
	public ResponseEntity<String> add(@RequestParam String name, @RequestParam String nit_supplier, @RequestParam float purchase_price, @RequestParam float sales_price) {
		Product temp = new Product(name, nit_supplier, purchase_price, sales_price);
		prep.save(temp);
		return ResponseEntity.status(HttpStatus.CREATED).body("Dato creado con exito");
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> showAll(){
		List<Product> temp = prep.findAll();
		if (temp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(temp);
	}
	
	@PostMapping("/products/update/{id}")
    public ResponseEntity<String> update(@RequestParam Integer id, @RequestParam String update, @RequestParam String new_param) {
		Product temporal = prep.findById(id).get();
		float temp;
		switch (update) {
		case "Nombre":
			temporal.setName(new_param);
			break;
		case "NIT Provedor":
			temporal.setNit_supplier(new_param);
			break;
		case "Precio Compra":
			temp = Float.parseFloat(new_param);
			temporal.setPurchase_price(temp);
			break;
		case "Precio Venta":
			temp = Float.parseFloat(new_param);
			temporal.setSales_price(temp);
			break;
		}
		prep.save(temporal);
        return ResponseEntity.status(HttpStatus.OK).body("Dato actualizado");
    }
	
	@DeleteMapping("/products/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id, @RequestParam String name) {
		Product temporal = prep.findById(id).get();
		if (name.equals(temporal.getName())) {			
			prep.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Dato eliminado");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("El Nombre del producto no coincide");
	}
}
