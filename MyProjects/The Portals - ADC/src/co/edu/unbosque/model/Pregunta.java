package co.edu.unbosque.model;

/**
 * Inicializacion de las preguntas y las respuestas correpondientes
 * @author Diego Forero
 * @author Andrés Espitia
 * @author Camilo Uribe
 *
 */
public class Pregunta {
	/**
	 * Texto que contiene la pregutna
	 */
	private String pregunta;
	/**
	 * Opción de respuesta 1
	 */
	private String respuesta1;
	/**
	 * Opción de respuesta 2
	 */
	private String respuesta2;
	/**
	 * Opción de respuesta 3
	 */
	private String respuesta3;
	/**
	 * Opción de respuesta 4
	 */
	private String respuesta4;
	/**
	 * Indicador de asertividad de la pregunta
	 */
	private boolean correcto;
	
	/**
	 * Metodo constructor
	 */
	public Pregunta() {
		pregunta = "";
		respuesta1 = "";
		respuesta2 = "";
		respuesta4 = "";
		correcto = false;
	}

	/**
	 * Metodo que devuelve la pregunta
	 * @return
	 */
	public String getPregunta() {
		return pregunta;
	}

	/**
	 * Metodo que cambia la pregunta
	 * @param pregunta
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * Metodo que devuelve la respuesta 1
	 * @return
	 */
	public String getRespuesta1() {
		return respuesta1;
	}

	/**
	 * Metodo que cambia la respuesta 1
	 * @param respuesta1
	 */
	public void setRespuesta1(String respuesta1) {
		this.respuesta1 = respuesta1;
	}

	/**
	 * Metodo que devuelve la respuesta 2
	 * @return
	 */
	public String getRespuesta2() {
		return respuesta2;
	}

	/**
	 *  Metodo que cambia la respuesta 2
	 * @param respuesta2
	 */
	public void setRespuesta2(String respuesta2) {
		this.respuesta2 = respuesta2;
	}

	/**
	 * Metodo que devuelve la respuesta 3
	 * @return
	 */
	public String getRespuesta3() {
		return respuesta3;
	}

	/**
	 * Metodo que cambia la respuesta 3
	 * @param respuesta3
	 */
	public void setRespuesta3(String respuesta3) {
		this.respuesta3 = respuesta3;
	}

	/**
	 * Metodo que devuelve la respuesta
	 * @return
	 */
	public String getRespuesta4() {
		return respuesta4;
	}

	/**
	 * Metodo que cambia la respuesta 4
	 * @param respuesta4
	 */
	public void setRespuesta4(String respuesta4) {
		this.respuesta4 = respuesta4;
	}

	/**
	 * Metodo que devuelve el valor de la respuesta
	 * @return
	 */
	public boolean isCorrecto() {
		return correcto;
	}

	/**
	 * Metodo que cambia el valor de la respuesta
	 * @param correcto
	 */
	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

		
	
}