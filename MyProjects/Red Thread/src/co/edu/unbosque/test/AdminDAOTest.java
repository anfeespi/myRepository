package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.AdminDAOImpl;

public class AdminDAOTest {
	static int prueba_numero=1;
	@BeforeAll
	static void antesDeTodo() {
		System.out.println("iniciando pruebas");
	}
	@AfterAll
	static void despuesDeTodo(){
		System.out.println("finalizando pruebas");
	} 	
	@BeforeEach
	 void antesDeCadaUna(){
		System.out.println("iniciando prueba "+prueba_numero);
		
	}
	@AfterEach
		void despuesDeCadaUna(){
		System.out.println("finalizando prueba "+prueba_numero);
		prueba_numero++;
	}
	
	@Test
	public void testDeleteUser() {
		AdminDAOImpl admin = new AdminDAOImpl();
		admin.deleteUser("luimuñoz");
		assertTrue(true);
	}
}
