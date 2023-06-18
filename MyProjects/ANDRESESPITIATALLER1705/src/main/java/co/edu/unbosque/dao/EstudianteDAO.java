package co.edu.unbosque.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import co.edu.unbosque.dto.EstudianteDTO;

public class EstudianteDAO {
	private List<EstudianteDTO> listaEstudiante;

	public List<EstudianteDTO> getListaEstudiante() {
		return listaEstudiante;
	}

	public void setListaEstudiante(List<EstudianteDTO> listaEstudiante) {
		this.listaEstudiante = listaEstudiante;
	}
	
	public String agregar(Object registro) {
		// TODO Auto-generated method stub
		String resultado;
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(EstudianteDTO.class)
				.buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			miSession.save((EstudianteDTO)registro);
			miSession.getTransaction().commit();
			//System.out.println("Registro Insertado!");
			resultado = "OK";
			miSession.close();
		} catch (Exception e) {
			resultado = e.toString();
		} finally {
			miFactory.close();
		}
		return resultado;
	}
	
	public Object consultar() {
		SessionFactory miFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(EstudianteDTO.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			listaEstudiante = miSession.createQuery("from EstudianteDTO").getResultList();
			miSession.getTransaction().commit();
			miSession.close();
		} catch (Exception e) {
			listaEstudiante=null;
			//resultado = e.toString();
		} finally {
			miFactory.close();
		}		
		return listaEstudiante;
	}
}
