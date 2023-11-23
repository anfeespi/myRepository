package co.edu.unbosque.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import co.edu.unbosque.model.Empleado;
import co.edu.unbosque.model.EmpleadoBono;
import co.edu.unbosque.model.Libro;
import co.edu.unbosque.model.Pelicula;
import co.edu.unbosque.model.PeliculaGeneros;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("dtColumnsView")
@ViewScoped
public class ColumnsView implements Serializable {
    private String columnTemplate = "codigo_empleado nombre dependencia cargo ingreso sueldo";
    private String columnTemplate2 = "codigo_empleado nombre dependencia";
    private String columnTemplate3 = "codigo_empleado nombre dependencia cargo";
    private String columnTemplate4 = "codigo_empleado nombre dependencia cargo ingreso eps arl pension sueldo";
    private String columnTemplate5 = "codigo_empleado nombre cargo eps";
    private String columnTemplate6 = "codigo_empleado nombre cargo pension";
    private String columnTemplate7 = "codigo_empleado nombre codigo_novedad dias_trabajados dias_incapacidad dias_vacaciones fecha_inicio_vacaciones fecha_fin_vacaciones fecha_inicio_incapacidad fecha_fin_incapacidad bonificacion transporte";
    private String columnTemplate8 = "codigo_empleado nombre dependencia cargo codigo_novedad dias_trabajados dias_incapacidad dias_vacaciones fecha_inicio_vacaciones fecha_fin_vacaciones fecha_inicio_incapacidad fecha_fin_incapacidad bonificacion transporte";
    private String columnTemplate9 = "id_pelicula titulo anio_lanzamiento generos";
    private String columnTemplate10 = "id_pelicula titulo anio_lanzamiento num_gen generos";
    private String columnTemplate11 = "id_libro titulo autores rating_promedio isbn isbn13 codigo_idioma num_paginas contador_rating contador_reviews fecha_publicacion editor";
    private List<ColumnModel> columnas_primera_tabla;
    private List<ColumnModel> columnas_segunda_tabla;
    private List<ColumnModel> columnas_tercera_tabla;
    private List<ColumnModel> columnas_cuarta_tabla;
    private List<ColumnModel> columnas_eps_tabla;
    private List<ColumnModel> columnas_pension_tabla;
    private List<ColumnModel> columnas_novedades_tabla;
    private List<ColumnModel> columnas_novedades_tabla2;
    private List<ColumnModel> columnas_peliculas_tabla;
    private List<ColumnModel> columnas_peliculas_tabla2;
    private List<ColumnModel> columnas_libros_tabla;
    private List<Empleado> empleados;
    private List<Empleado> empleados_filtrados;
    private List<EmpleadoBono> empleados_bonos;
    private List<EmpleadoBono> empleados_bonos_filtrados;
    private List<Pelicula> peliculas;
    private List<PeliculaGeneros> pelGens;
    private List<PeliculaGeneros> pelGens_filtradas;
    private List<Libro> libros;
    private List<Libro> mejores_libros;
    private List<Libro> peores_libros;
    private List<Libro> libros_filtrados;
    private Map<String, Class> validColumns;
    private Map<String, Class> validColumnsBonos;
    private Map<String, Class> validColumnsPeliculas;
    private Map<String, Class> validColumnsLibros;
    private String[] filtro_dependencias = {"Comercial", "Tecnología", "Contabilidad", "Facturación"};
    private String[] filtro_cargo = {"Auditor interno", "Auxiliar especializado", "DBA", "Director de cartera", "Director de costos", "Director de Facturación", "Director de Impuestos", "Director de presupuestos", "Director de ventas", "Gerente de ventas", "Ingeniero de Desarrollo", "Ingeniero de Soporte", "Líder de infraestructura", "Líder de QA"};
    private String[] filtro_eps = {"Aliansalud EPS", "EPS-Sanitas", "EPS-Sura", "Nueva EPS"};
    private String[] filtro_pensiones = {"Colpensiones", "Protección", "Provenir", "Skandia"};
    private String[] filtro_peliculas_genero = {"Adventure", "Animation", "Children", "Comedy", "Fantasy", "Romance", "Drama", "Action", "Crime", "Thriller", "Horror", "Mystery", "Sci-Fi", "IMAX", "Documentary", "War", "Musical", "Film-Noir", "Western", "(no genres listed)"};
    
    @Inject
    private EmpleadoService service;
    
    @Inject
    private PeliculasLibrosService service2;

    @PostConstruct
    public void init() {
    	empleados = service.getEmpleados();
    	empleados_bonos = service.getEmplebono();
    	peliculas = service2.getPeliculas();
    	pelGens = service2.getPelGen();
    	libros = service2.getLibros();
    	mejores_libros = service2.getMejores_libros();
    	peores_libros = service2.getPeores_libros();
    	

        validColumns = Stream.of(Empleado.class.getDeclaredFields()).collect(Collectors.toMap(Field::getName, Field::getType));
        validColumnsBonos = Stream.of(EmpleadoBono.class.getDeclaredFields()).collect(Collectors.toMap(Field::getName, Field::getType));
        validColumnsPeliculas = Stream.of(PeliculaGeneros.class.getDeclaredFields()).collect(Collectors.toMap(Field::getName, Field::getType));
        validColumnsLibros = Stream.of(Libro.class.getDeclaredFields()).collect(Collectors.toMap(Field::getName, Field::getType));
        
        columnas_primera_tabla = createDynamicColumns(columnTemplate);
        columnas_segunda_tabla = createDynamicColumns(columnTemplate2);
        columnas_tercera_tabla = createDynamicColumns(columnTemplate3);
        columnas_cuarta_tabla = createDynamicColumns(columnTemplate4);
        columnas_eps_tabla = createDynamicColumns(columnTemplate5);
        columnas_pension_tabla = createDynamicColumns(columnTemplate6);
        
        columnas_novedades_tabla = createDynamicColumns2(columnTemplate7);
        columnas_novedades_tabla2 = createDynamicColumns2(columnTemplate8);
        
        columnas_peliculas_tabla = createDynamicColumnsPeliculas(columnTemplate9);
        columnas_peliculas_tabla2 = createDynamicColumnsPeliculas(columnTemplate10);
        
        columnas_libros_tabla = createDynamicColumnsLibros(columnTemplate11);
    }
    
    private List<ColumnModel> createDynamicColumns(String template) {
        String[] columnKeys = template.split(" ");
        List<ColumnModel> columnas = new ArrayList<>();

        for (String columnKey : columnKeys) {
            String key = columnKey.trim();

            if (validColumns.containsKey(key)) {
            	columnas.add(new ColumnModel(columnKey.toUpperCase(), columnKey, validColumns.get(key)));
            }
        }
        return columnas;
    }
    
    private List<ColumnModel> createDynamicColumns2(String template) {
        String[] columnKeys = template.split(" ");
        List<ColumnModel> columnas = new ArrayList<>();

        for (String columnKey : columnKeys) {
            String key = columnKey.trim();

            if (validColumnsBonos.containsKey(key)) {
            	columnas.add(new ColumnModel(columnKey.toUpperCase(), columnKey, validColumnsBonos.get(key)));
            }
        }
        return columnas;
    }
    
    private List<ColumnModel> createDynamicColumnsPeliculas(String template) {
    	String[] columnKeys = template.split(" ");
    	List<ColumnModel> columnas = new ArrayList<>();
    	
    	for (String columnKey : columnKeys) {
    		String key = columnKey.trim();
    		
    		if (validColumnsPeliculas.containsKey(key)) {
    			columnas.add(new ColumnModel(columnKey.toUpperCase(), columnKey, validColumnsPeliculas.get(key)));
    		}
    	}
    	return columnas;
    }
    
    private List<ColumnModel> createDynamicColumnsLibros(String template) {
    	String[] columnKeys = template.split(" ");
    	List<ColumnModel> columnas = new ArrayList<>();
    	
    	for (String columnKey : columnKeys) {
    		String key = columnKey.trim();
    		
    		if (validColumnsLibros.containsKey(key)) {
    			columnas.add(new ColumnModel(columnKey.toUpperCase(), columnKey, validColumnsLibros.get(key)));
    		}
    	}
    	return columnas;
    }

    public List<ColumnModel> getColumnas_primera_tabla() {
		return columnas_primera_tabla;
	}

	public void setColumnas_primera_tabla(List<ColumnModel> columnas_primera_tabla) {
		this.columnas_primera_tabla = columnas_primera_tabla;
	}

	public String getColumnTemplate() {
        return columnTemplate;
    }

    public void setColumnTemplate(String columnTemplate) {
        this.columnTemplate = columnTemplate;
    }

    public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Map<String, Class> getValidColumns() {
		return validColumns;
	}

	public void setValidColumns(Map<String, Class> validColumns) {
		this.validColumns = validColumns;
	}

	public List<Empleado> getEmpleados_filtrados() {
		return empleados_filtrados;
	}

	public void setEmpleados_filtrados(List<Empleado> empleados_filtrados) {
		this.empleados_filtrados = empleados_filtrados;
	}

	public String[] getFiltro_dependencias() {
		return filtro_dependencias;
	}

	public void setFiltro_dependencias(String[] filtro_dependencias) {
		this.filtro_dependencias = filtro_dependencias;
	}

	public String getColumnTemplate2() {
		return columnTemplate2;
	}

	public void setColumnTemplate2(String columnTemplate2) {
		this.columnTemplate2 = columnTemplate2;
	}

	public String getColumnTemplate3() {
		return columnTemplate3;
	}

	public void setColumnTemplate3(String columnTemplate3) {
		this.columnTemplate3 = columnTemplate3;
	}

	public List<ColumnModel> getColumnas_segunda_tabla() {
		return columnas_segunda_tabla;
	}

	public void setColumnas_segunda_tabla(List<ColumnModel> columnas_segunda_tabla) {
		this.columnas_segunda_tabla = columnas_segunda_tabla;
	}

	public List<ColumnModel> getColumnas_tercera_tabla() {
		return columnas_tercera_tabla;
	}

	public void setColumnas_tercera_tabla(List<ColumnModel> columnas_tercera_tabla) {
		this.columnas_tercera_tabla = columnas_tercera_tabla;
	}

	public List<ColumnModel> getColumnas_cuarta_tabla() {
		return columnas_cuarta_tabla;
	}

	public void setColumnas_cuarta_tabla(List<ColumnModel> columnas_cuarta_tabla) {
		this.columnas_cuarta_tabla = columnas_cuarta_tabla;
	}

	public EmpleadoService getService() {
		return service;
	}

	public void setService(EmpleadoService service) {
		this.service = service;
	}

	public String[] getFiltro_cargo() {
		return filtro_cargo;
	}

	public void setFiltro_cargo(String[] filtro_cargo) {
		this.filtro_cargo = filtro_cargo;
	}

	public String getColumnTemplate4() {
		return columnTemplate4;
	}

	public void setColumnTemplate4(String columnTemplate4) {
		this.columnTemplate4 = columnTemplate4;
	}

	public String getColumnTemplate5() {
		return columnTemplate5;
	}

	public void setColumnTemplate5(String columnTemplate5) {
		this.columnTemplate5 = columnTemplate5;
	}

	public String getColumnTemplate6() {
		return columnTemplate6;
	}

	public void setColumnTemplate6(String columnTemplate6) {
		this.columnTemplate6 = columnTemplate6;
	}

	public String[] getFiltro_eps() {
		return filtro_eps;
	}

	public void setFiltro_eps(String[] filtro_eps) {
		this.filtro_eps = filtro_eps;
	}

	public String[] getFiltro_pensiones() {
		return filtro_pensiones;
	}

	public void setFiltro_pensiones(String[] filtro_pensiones) {
		this.filtro_pensiones = filtro_pensiones;
	}

	public List<ColumnModel> getColumnas_eps_tabla() {
		return columnas_eps_tabla;
	}

	public void setColumnas_eps_tabla(List<ColumnModel> columnas_eps_tabla) {
		this.columnas_eps_tabla = columnas_eps_tabla;
	}

	public List<ColumnModel> getColumnas_pension_tabla() {
		return columnas_pension_tabla;
	}

	public void setColumnas_pension_tabla(List<ColumnModel> columnas_pension_tabla) {
		this.columnas_pension_tabla = columnas_pension_tabla;
	}

	public List<EmpleadoBono> getEmpleados_bonos() {
		return empleados_bonos;
	}

	public void setEmpleados_bonos(List<EmpleadoBono> empleados_bonos) {
		this.empleados_bonos = empleados_bonos;
	}

	public List<EmpleadoBono> getEmpleados_bonos_filtrados() {
		return empleados_bonos_filtrados;
	}

	public void setEmpleados_bonos_filtrados(List<EmpleadoBono> empleados_bonos_filtrados) {
		this.empleados_bonos_filtrados = empleados_bonos_filtrados;
	}

	public Map<String, Class> getValidColumnsBonos() {
		return validColumnsBonos;
	}

	public void setValidColumnsBonos(Map<String, Class> validColumnsBonos) {
		this.validColumnsBonos = validColumnsBonos;
	}

	public String getColumnTemplate7() {
		return columnTemplate7;
	}

	public void setColumnTemplate7(String columnTemplate7) {
		this.columnTemplate7 = columnTemplate7;
	}

	public List<ColumnModel> getColumnas_novedades_tabla() {
		return columnas_novedades_tabla;
	}

	public void setColumnas_novedades_tabla(List<ColumnModel> columnas_novedades_tabla) {
		this.columnas_novedades_tabla = columnas_novedades_tabla;
	}

	public String getColumnTemplate8() {
		return columnTemplate8;
	}

	public void setColumnTemplate8(String columnTemplate8) {
		this.columnTemplate8 = columnTemplate8;
	}

	public List<ColumnModel> getColumnas_novedades_tabla2() {
		return columnas_novedades_tabla2;
	}

	public void setColumnas_novedades_tabla2(List<ColumnModel> columnas_novedades_tabla2) {
		this.columnas_novedades_tabla2 = columnas_novedades_tabla2;
	}

	public String getColumnTemplate9() {
		return columnTemplate9;
	}

	public void setColumnTemplate9(String columnTemplate9) {
		this.columnTemplate9 = columnTemplate9;
	}

	public List<ColumnModel> getColumnas_peliculas_tabla() {
		return columnas_peliculas_tabla;
	}

	public void setColumnas_peliculas_tabla(List<ColumnModel> columnas_peliculas_tabla) {
		this.columnas_peliculas_tabla = columnas_peliculas_tabla;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public Map<String, Class> getValidColumnsPeliculas() {
		return validColumnsPeliculas;
	}

	public void setValidColumnsPeliculas(Map<String, Class> validColumnsPeliculas) {
		this.validColumnsPeliculas = validColumnsPeliculas;
	}

	public PeliculasLibrosService getService2() {
		return service2;
	}

	public void setService2(PeliculasLibrosService service2) {
		this.service2 = service2;
	}

	public List<PeliculaGeneros> getPelGens() {
		return pelGens;
	}

	public void setPelGens(List<PeliculaGeneros> pelGens) {
		this.pelGens = pelGens;
	}

	public List<PeliculaGeneros> getPelGens_filtradas() {
		return pelGens_filtradas;
	}

	public void setPelGens_filtradas(List<PeliculaGeneros> pelGens_filtradas) {
		this.pelGens_filtradas = pelGens_filtradas;
	}

	public String[] getFiltro_peliculas_genero() {
		return filtro_peliculas_genero;
	}

	public void setFiltro_peliculas_genero(String[] filtro_peliculas_genero) {
		this.filtro_peliculas_genero = filtro_peliculas_genero;
	}

	public String getColumnTemplate10() {
		return columnTemplate10;
	}

	public void setColumnTemplate10(String columnTemplate10) {
		this.columnTemplate10 = columnTemplate10;
	}

	public List<ColumnModel> getColumnas_peliculas_tabla2() {
		return columnas_peliculas_tabla2;
	}

	public void setColumnas_peliculas_tabla2(List<ColumnModel> columnas_peliculas_tabla2) {
		this.columnas_peliculas_tabla2 = columnas_peliculas_tabla2;
	}

	public String getColumnTemplate11() {
		return columnTemplate11;
	}

	public void setColumnTemplate11(String columnTemplate11) {
		this.columnTemplate11 = columnTemplate11;
	}

	public List<ColumnModel> getColumnas_libros_tabla() {
		return columnas_libros_tabla;
	}

	public void setColumnas_libros_tabla(List<ColumnModel> columnas_libros_tabla) {
		this.columnas_libros_tabla = columnas_libros_tabla;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public List<Libro> getLibros_filtrados() {
		return libros_filtrados;
	}

	public void setLibros_filtrados(List<Libro> libros_filtrados) {
		this.libros_filtrados = libros_filtrados;
	}

	public Map<String, Class> getValidColumnsLibros() {
		return validColumnsLibros;
	}

	public void setValidColumnsLibros(Map<String, Class> validColumnsLibros) {
		this.validColumnsLibros = validColumnsLibros;
	}

	public List<Libro> getMejores_libros() {
		return mejores_libros;
	}

	public void setMejores_libros(List<Libro> mejores_libros) {
		this.mejores_libros = mejores_libros;
	}

	public List<Libro> getPeores_libros() {
		return peores_libros;
	}

	public void setPeores_libros(List<Libro> peores_libros) {
		this.peores_libros = peores_libros;
	}
}
