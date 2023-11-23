package co.edu.unbosque.EntreColPlusBack.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bonos")
public class Bono {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_novedad;
	private int novedad_incapacidad;
	private int novedad_vacaciones;
	private Integer dias_trabajados;
	private Integer dias_incapacidad;
	private Integer dias_vacaciones;
	private Date fecha_inicio_vacaciones;
	private Date fecha_fin_vacaciones;
	private Date fecha_inicio_incapacidad;
	private Date fecha_fin_incapacidad;
	private Float bonificacion;
	private Float transporte;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_empleado", nullable = false, referencedColumnName = "codigo_empleado")
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

	public Date getFecha_inicio_vacaciones() {
		return fecha_inicio_vacaciones;
	}

	public void setFecha_inicio_vacaciones(Date fecha_inicio_vacaciones) {
		this.fecha_inicio_vacaciones = fecha_inicio_vacaciones;
	}

	public Date getFecha_fin_vacaciones() {
		return fecha_fin_vacaciones;
	}

	public void setFecha_fin_vacaciones(Date fecha_fin_vacaciones) {
		this.fecha_fin_vacaciones = fecha_fin_vacaciones;
	}

	public Date getFecha_inicio_incapacidad() {
		return fecha_inicio_incapacidad;
	}

	public void setFecha_inicio_incapacidad(Date fecha_inicio_incapacidad) {
		this.fecha_inicio_incapacidad = fecha_inicio_incapacidad;
	}

	public Date getFecha_fin_incapacidad() {
		return fecha_fin_incapacidad;
	}

	public void setFecha_fin_incapacidad(Date fecha_fin_incapacidad) {
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
