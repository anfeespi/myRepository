package co.edu.unbosque.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import co.edu.unbosque.controller.HttpClientSynchronous;
import co.edu.unbosque.model.Bono;
import co.edu.unbosque.model.Empleado;
import co.edu.unbosque.model.Genero;
import co.edu.unbosque.model.Libro;
import co.edu.unbosque.model.Pelicula;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@SuppressWarnings("removal")
@ManagedBean
@RequestScoped
public class EntreColPlusFrontBean {
	public static List<Empleado> empleados = crearListaEmpleados();
	public static List<Libro> libros = crearListaLibros();
	public static List<Pelicula> peliculas = crearListaPeliculas();
	private static String username;
	private static String password;
	
	public static String login() {
		String response = HttpClientSynchronous.doGetLogIn("login?username="+username+"&password="+password);
		if (response.equals("No encontrado")) {
			showSticky("Error!", "Credenciales Invalidas");
			return "";
		}
		System.out.println(username + " " + password);
		System.out.println(response); 
		return response;
	}
	
	public static List<Empleado> crearListaEmpleados() {
		String json = HttpClientSynchronous.doGet("empleados");
		JSONParser jsonParser = new JSONParser();
        List<Empleado> emple_aux = new ArrayList<Empleado>();
        JSONArray usuarios = null;
		try {
			usuarios = (JSONArray) jsonParser.parse(json);
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        @SuppressWarnings("rawtypes")
		Iterator i = usuarios.iterator();
        SimpleDateFormat nuevoFormato = new SimpleDateFormat("dd/MM/yyyy");
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Empleado emp = new Empleado();
            emp.setCodigo_empleado(Integer.parseInt(innerObj.get("codigo_empleado").toString()));
            emp.setNombre(innerObj.get("nombre").toString());
            emp.setDependencia(innerObj.get("dependencia").toString());
            emp.setCargo(innerObj.get("cargo").toString());
            emp.setFecha_ingreso(convertirStringADate(innerObj.get("fecha_ingreso").toString()));
            emp.setIngreso(fechaFormateada(innerObj.get("fecha_ingreso").toString()));
            emp.setEps(innerObj.get("eps").toString());
            emp.setArl(innerObj.get("arl").toString());
            emp.setPension(innerObj.get("pension").toString());
            emp.setSueldo(Float.parseFloat(innerObj.get("sueldo").toString()));
            Bono aux = new Bono();
            JSONArray bonosArray = (JSONArray) innerObj.get("bonos");
            JSONObject bonoaux = (JSONObject) bonosArray.get(0);
            aux.setCodigo_novedad(Integer.parseInt(bonoaux.get("codigo_novedad").toString()));
            aux.setNovedad_incapacidad(Integer.parseInt(bonoaux.get("novedad_incapacidad").toString()));
            aux.setNovedad_vacaciones(Integer.parseInt(bonoaux.get("novedad_vacaciones").toString()));
            aux.setDias_trabajados(Integer.parseInt(bonoaux.get("dias_trabajados").toString()));
            aux.setDias_incapacidad(Integer.parseInt(bonoaux.get("dias_incapacidad").toString()));
            aux.setDias_vacaciones(Integer.parseInt(bonoaux.get("dias_vacaciones").toString()));
            aux.setFecha_inicio_vacaciones(bonoaux.get("fecha_inicio_vacaciones") == null ? null : fechaFormateada(bonoaux.get("fecha_inicio_vacaciones").toString()));
            aux.setFecha_fin_vacaciones(bonoaux.get("fecha_fin_vacaciones") == null ? null : fechaFormateada(bonoaux.get("fecha_fin_vacaciones").toString()));
            aux.setFecha_inicio_incapacidad(bonoaux.get("fecha_inicio_incapacidad") == null ? null : fechaFormateada(bonoaux.get("fecha_inicio_incapacidad").toString()));
            aux.setFecha_fin_incapacidad(bonoaux.get("fecha_fin_incapacidad") == null ? null : fechaFormateada(bonoaux.get("fecha_fin_incapacidad").toString()));
            aux.setBonificacion(Float.parseFloat(bonoaux.get("bonificacion").toString()));
            aux.setTransporte(Float.parseFloat(bonoaux.get("transporte").toString()));
            emp.getBonos().add(aux);
            emple_aux.add(emp);
        }
        return emple_aux;
	}
	
	public static List<Pelicula> crearListaPeliculas() {
		String json = HttpClientSynchronous.doGet("peliculas?beg=100");
		JSONParser jsonParser = new JSONParser();
        List<Pelicula> peli_aux = new ArrayList<Pelicula>();
        JSONArray peliculas = null;
		try {
			peliculas = (JSONArray) jsonParser.parse(json);
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        @SuppressWarnings("rawtypes")
		Iterator i = peliculas.iterator();
        SimpleDateFormat nuevoFormato = new SimpleDateFormat("dd/MM/yyyy");
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Pelicula pel = new Pelicula();
            pel.setId_pelicula(Integer.parseInt(innerObj.get("id_pelicula").toString()));
            pel.setTitulo(innerObj.get("titulo").toString());
            pel.setAnio_lanzamiento(Year.of(Integer.parseInt(innerObj.get("anio_lanzamiento").toString())));
            JSONArray generosArray = (JSONArray) innerObj.get("generos");
            Iterator j = generosArray.iterator();
            while (j.hasNext()) {
            	 JSONObject generoJson = (JSONObject) j.next();
            	 pel.getGeneros().add(new Genero(Integer.parseInt(generoJson.get("id_genero").toString()), generoJson.get("genero").toString()));
            }
            peli_aux.add(pel);
        }
        return peli_aux;
	}
	
	public static List<Libro> crearListaLibros() {
		String json = HttpClientSynchronous.doGet("libros?beg=100");
		JSONParser jsonParser = new JSONParser();
        List<Libro> lib_aux = new ArrayList<Libro>();
        JSONArray lib = null;
		try {
			lib = (JSONArray) jsonParser.parse(json);
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        @SuppressWarnings("rawtypes")
		Iterator i = lib.iterator();
        SimpleDateFormat nuevoFormato = new SimpleDateFormat("dd/MM/yyyy");
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            Libro libaux = new Libro();
            libaux.setId_libro(Integer.parseInt(innerObj.get("id_libro").toString()));
            libaux.setTitulo(innerObj.get("titulo").toString());
            libaux.setAutores(innerObj.get("autores").toString());
            libaux.setRating_promedio(Float.parseFloat(innerObj.get("rating_promedio").toString()));
            libaux.setIsbn(innerObj.get("isbn").toString());
            libaux.setIsbn13(innerObj.get("isbn13").toString());
            libaux.setCodigo_idioma(innerObj.get("codigo_idioma").toString());
            libaux.setNum_paginas(Integer.parseInt(innerObj.get("num_paginas").toString()));
            libaux.setContador_rating(Integer.parseInt(innerObj.get("contador_rating").toString()));
            libaux.setContador_reviews(Integer.parseInt(innerObj.get("contador_reviews").toString()));
            libaux.setFecha_publicacion(fechaFormateada(innerObj.get("fecha_publicacion").toString()));
            libaux.setEditor(innerObj.get("editor").toString());
            lib_aux.add(libaux);
        }
        return lib_aux;
	}
	
	public static Date convertirStringADate(String fechaEnTexto) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;

        try {
            fecha = formatoFecha.parse(fechaEnTexto.replace("-", "/"));
        } catch (ParseException e) {
        	e.printStackTrace();
        }

        return fecha;
    }
	
	public static String fechaFormateada(String fechaEnTexto) {
		SimpleDateFormat formatoOriginal = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		Date date;
		try {
			date = formatoOriginal.parse(fechaEnTexto);
			SimpleDateFormat nuevoFormato = new SimpleDateFormat("dd/MM/yyyy");
			return nuevoFormato.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static void showSticky(String sticky_Message, String message_content) {
		FacesContext.getCurrentInstance().addMessage("sticky-key",new FacesMessage(
				FacesMessage.SEVERITY_INFO, 
				sticky_Message, 
				message_content)
		);
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados_aux) {
		empleados = empleados_aux;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
