package co.edu.unbosque.EntreColPlusBack.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.EntreColPlusBack.model.Admin;
import co.edu.unbosque.EntreColPlusBack.repository.AdminRepository;
import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@Transactional
public class LogInController {
	@Autowired
	private AdminRepository arep;
	
	@GetMapping("/login")
	public ResponseEntity<String> save(@RequestParam String username, @RequestParam String password) {
		List<Admin> users = arep.findAll();
		for (Admin admin : users) {
			if(admin.getUsuario().equals(username) && admin.getClave().equals(password))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("nomina.xhtml");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
	}
	
}
