package co.edu.unbosque.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Empleado {
	private Integer codigo_empleado;
	private String nombre;
	private String dependencia;
	private String cargo;
	private Date fecha_ingreso;
	private String ingreso;
	private String eps;
	private String arl;
	private String pension;
	private Float sueldo;
	private Set<Bono> bonos;
	
	public Empleado() {
		bonos = new HashSet<>();
	}

	public Empleado(Integer codigo_empleado, String nombre, String dependencia, String cargo, Date fecha_ingreso,
			String ingreso, String eps, String arl, String pension, Float sueldo) {
		super();
		this.codigo_empleado = codigo_empleado;
		this.nombre = nombre;
		this.dependencia = dependencia;
		this.cargo = cargo;
		this.fecha_ingreso = fecha_ingreso;
		this.ingreso = ingreso;
		this.eps = eps;
		this.arl = arl;
		this.pension = pension;
		this.sueldo = sueldo;
	}

	public Integer getCodigo_empleado() {
		return codigo_empleado;
	}

	public void setCodigo_empleado(Integer codigo_empleado) {
		this.codigo_empleado = codigo_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getArl() {
		return arl;
	}

	public void setArl(String arl) {
		this.arl = arl;
	}
	
	public String getPension() {
		return pension;
	}

	public void setPension(String pension) {
		this.pension = pension;
	}

	public Float getSueldo() {
		return sueldo;
	}

	public void setSueldo(Float sueldo) {
		this.sueldo = sueldo;
	}

	public Set<Bono> getBonos() {
		return bonos;
	}

	public void setBonos(Set<Bono> bonos) {
		this.bonos = bonos;
	}

	public String getIngreso() {
		return ingreso;
	}

	public void setIngreso(String ingreso) {
		this.ingreso = ingreso;
	}
	
}
