package co.edu.unbosque.model;

import java.util.Date;

public class Bono {
	private Integer codigo_novedad;
	private int novedad_incapacidad;
	private int novedad_vacaciones;
	private Integer dias_trabajados;
	private Integer dias_incapacidad;
	private Integer dias_vacaciones;
	private String fecha_inicio_vacaciones;
	private String fecha_fin_vacaciones;
	private String fecha_inicio_incapacidad;
	private String fecha_fin_incapacidad;
	private Float bonificacion;
	private Float transporte;
	private Empleado empleado;
	
	public Bono() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCodigo_novedad() {
		return codigo_novedad;
	}

	public void setCodigo_novedad(Integer codigo_novedad) {
		this.codigo_novedad = codigo_novedad;
	}

	public int isNovedad_incapacidad() {
		return novedad_incapacidad;
	}

	public void setNovedad_incapacidad(int novedad_incapacidad) {
		this.novedad_incapacidad = novedad_incapacidad;
	}

	public int isNovedad_vacaciones() {
		return novedad_vacaciones;
	}

	public void setNovedad_vacaciones(int novedad_vacaciones) {
		this.novedad_vacaciones = novedad_vacaciones;
	}

	public Integer getDias_trabajados() {
		return dias_trabajados;
	}

	public void setDias_trabajados(Integer dias_trabajados) {
		this.dias_trabajados = dias_trabajados;
	}

	public Integer getDias_incapacidad() {
		return dias_incapacidad;
	}

	public void setDias_incapacidad(Integer dias_incapacidad) {
		this.dias_incapacidad = dias_incapacidad;
	}

	public Integer getDias_vacaciones() {
		return dias_vacaciones;
	}

	public void setDias_vacaciones(Integer dias_vacaciones) {
		this.dias_vacaciones = dias_vacaciones;
	}

	public String getFecha_inicio_vacaciones() {
		return fecha_inicio_vacaciones;
	}

	public void setFecha_inicio_vacaciones(String fecha_inicio_vacaciones) {
		this.fecha_inicio_vacaciones = fecha_inicio_vacaciones;
	}

	public String getFecha_fin_vacaciones() {
		return fecha_fin_vacaciones;
	}

	public void setFecha_fin_vacaciones(String fecha_fin_vacaciones) {
		this.fecha_fin_vacaciones = fecha_fin_vacaciones;
	}

	public String getFecha_inicio_incapacidad() {
		return fecha_inicio_incapacidad;
	}

	public void setFecha_inicio_incapacidad(String fecha_inicio_incapacidad) {
		this.fecha_inicio_incapacidad = fecha_inicio_incapacidad;
	}

	public String getFecha_fin_incapacidad() {
		return fecha_fin_incapacidad;
	}

	public void setFecha_fin_incapacidad(String fecha_fin_incapacidad) {
		this.fecha_fin_incapacidad = fecha_fin_incapacidad;
	}

	public Float getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(Float bonificacion) {
		this.bonificacion = bonificacion;
	}

	public Float getTransporte() {
		return transporte;
	}

	public void setTransporte(Float transporte) {
		this.transporte = transporte;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public int getNovedad_incapacidad() {
		return novedad_incapacidad;
	}

	public int getNovedad_vacaciones() {
		return novedad_vacaciones;
	}
	
	
	
}
