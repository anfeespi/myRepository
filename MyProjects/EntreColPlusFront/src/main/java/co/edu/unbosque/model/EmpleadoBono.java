package co.edu.unbosque.model;

public class EmpleadoBono {
	private Integer codigo_empleado;
	private String nombre;
	private String dependencia;
	private String cargo;
	private Integer codigo_novedad;
	private Integer dias_trabajados;
	private Integer dias_incapacidad;
	private Integer dias_vacaciones;
	private String fecha_inicio_vacaciones;
	private String fecha_fin_vacaciones;
	private String fecha_inicio_incapacidad;
	private String fecha_fin_incapacidad;
	private Float bonificacion;
	private Float transporte;
	
	public EmpleadoBono() {
		// TODO Auto-generated constructor stub
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

	public Integer getCodigo_novedad() {
		return codigo_novedad;
	}

	public void setCodigo_novedad(Integer codigo_novedad) {
		this.codigo_novedad = codigo_novedad;
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
}
