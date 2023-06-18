package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estudiantes")
public class EstudianteDTO {
	@Id
	@Column(name="cedula")
	private int cedula;
	
	@Column(name="espitia")
	private String espitia;
	
	
	public EstudianteDTO() {
		// TODO Auto-generated constructor stub
	}


	public EstudianteDTO(int cedula, String espitia) {
		super();
		this.cedula = cedula;
		this.espitia = espitia;
	}


	@Override
	public String toString() {
		return "EstudianteDTO [cedula=" + cedula + ", espitia=" + espitia + "]";
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
	
	
}
