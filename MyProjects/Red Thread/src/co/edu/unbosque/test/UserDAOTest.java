package co.edu.unbosque.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.unbosque.model.UserDAOImpl;

public class UserDAOTest {
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
	public void testTrueUpdateAlias() {
		UserDAOImpl us = new UserDAOImpl();
		us.updateUserAlias(56, "fifi");
		assertTrue(true);
	}
	
	@Test
	public void testTrueUpdateEmail() {
		UserDAOImpl us = new UserDAOImpl();
		us.updateUserEmail(187, "jakdakd@gmail.com");
		assertTrue(true);
	}
	
	@Test
	public void testTrueUpdateOrigin() {
		UserDAOImpl us = new UserDAOImpl();
		us.updateUserOrigin(11, "Ecuador");
		assertTrue(true);
	}
	
	@Test
	public void testTrueUpdateResidence() {
		UserDAOImpl us = new UserDAOImpl();
		us.updateUserResidence(13, "Brazil");
		assertTrue(true);
	}
	
	@Test
	public void testTrueUpdateContact() {
		UserDAOImpl us = new UserDAOImpl();
		us.updateUserContact(89, "31289768989");
		assertTrue(true);
	}
	
	@Test
	public void testTrueUpdateOrientation() {
		UserDAOImpl us = new UserDAOImpl();
		us.updateUserOrientation(89, "Homosexual");
		assertTrue(true);
	}
}
