package co.edu.unbosque.model;

import java.util.List;

import javax.faces.bean.ManagedBean;

import co.edu.unbosque.dao.EstudianteDAO;
import co.edu.unbosque.dto.EstudianteDTO;

@ManagedBean
public class EstudiantesBean {
	
	private int cedula;
	private String espitia;
	private String resultado;
	private List<EstudianteDTO> listaEstudiantes;
	
	public EstudiantesBean() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getEspitia() {
		return espitia;
	}
	public void setEspitia(String espitia) {
		this.espitia = espitia;
	}

	public List<EstudianteDTO> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(List<EstudianteDTO> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}
	
	
	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String agregar() {
		EstudianteDAO es = new EstudianteDAO();
		this.resultado = es.agregar(new EstudianteDTO(this.cedula, this.espitia));
		this.listaEstudiantes = (List<EstudianteDTO>) es.consultar();
		if(this.resultado.equals("OK") && this.listaEstudiantes!=null) {
			return "tablaestudiantes.xhtml";
		}else {
			return "error.xhtml";
		}
	}
	
	
}
