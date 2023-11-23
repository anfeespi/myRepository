package co.edu.unbosque.util;

import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.beans.EntreColPlusFrontBean;
import co.edu.unbosque.model.Bono;
import co.edu.unbosque.model.Empleado;
import co.edu.unbosque.model.EmpleadoBono;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class EmpleadoService {
	private List<EmpleadoBono> emplebono;
	private String[] dependencias = {"Comercial", "Tecnología", "Contabilidad", "Facturación"};
	private String[] cargos = {"Auditor interno", "Auxiliar especializado", "DBA", "Director de cartera", "Director de costos", "Director de Facturación", "Director de Impuestos", "Director de presupuestos", "Director de ventas", "Gerente de ventas", "Ingeniero de Desarrollo", "Ingeniero de Soporte", "Líder de infraestructura", "Líder de QA"};
	private String[] eps = {"Aliansalud EPS", "EPS-Sanitas", "EPS-Sura", "Nueva EPS"};
	private String[] arls = {"Positiva"};
	private String[] pensiones = {"Colpensiones", "Protección", "Provenir", "Skandia"};
	
	@PostConstruct
    public void init() {
		List<Empleado> empleados = EntreColPlusFrontBean.empleados;
		emplebono = new ArrayList<>();
		for (Empleado emp : empleados) {
			Bono bonoaux = (Bono) emp.getBonos().toArray()[0];
			if (bonoaux.getDias_trabajados() != 30) {
				EmpleadoBono aux = new EmpleadoBono();
				aux.setCodigo_empleado(emp.getCodigo_empleado());
				aux.setNombre(emp.getNombre());
				aux.setDependencia(emp.getDependencia());
				aux.setCargo(emp.getCargo());
				aux.setCodigo_novedad(bonoaux.getCodigo_novedad());
				aux.setDias_trabajados(bonoaux.getDias_trabajados());
				aux.setDias_incapacidad(bonoaux.getDias_incapacidad());
				aux.setDias_vacaciones(bonoaux.getDias_vacaciones());
				aux.setFecha_inicio_vacaciones(bonoaux.getFecha_inicio_vacaciones());
				aux.setFecha_fin_vacaciones(bonoaux.getFecha_fin_vacaciones());
				aux.setFecha_inicio_incapacidad(bonoaux.getFecha_inicio_incapacidad());
				aux.setFecha_fin_incapacidad(bonoaux.getFecha_fin_incapacidad());
				aux.setBonificacion(bonoaux.getBonificacion());
				aux.setTransporte(bonoaux.getTransporte());
				emplebono.add(aux);
			}
		}
	}
	
	public List<Empleado> getEmpleados() {
        List<Empleado> customers = EntreColPlusFrontBean.empleados;
        return customers;
    }

	public List<EmpleadoBono> getEmplebono() {
		return emplebono;
	}

	public void setEmplebono(List<EmpleadoBono> emplebono) {
		this.emplebono = emplebono;
	}

	public String[] getDependencias() {
		return dependencias;
	}

	public void setDependencias(String[] dependencias) {
		this.dependencias = dependencias;
	}

	public String[] getCargos() {
		return cargos;
	}

	public void setCargos(String[] cargos) {
		this.cargos = cargos;
	}

	public String[] getEps() {
		return eps;
	}

	public void setEps(String[] eps) {
		this.eps = eps;
	}

	public String[] getArls() {
		return arls;
	}

	public void setArls(String[] arls) {
		this.arls = arls;
	}

	public String[] getPensiones() {
		return pensiones;
	}

	public void setPensiones(String[] pensiones) {
		this.pensiones = pensiones;
	}
}
