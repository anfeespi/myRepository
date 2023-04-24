package co.edu.unbosque.model;

/**
 * 
 * Clase con la se hacen las preguntas al caer en algun portal
 * @author Andres Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */
public class Cuestionario {
	/**
	 * Arreglo de preguntas
	 */
	private Pregunta[] preguntas;
	
	/**
	 * Metodo constructor
	 */
	public Cuestionario() {
		preguntas = new Pregunta[15];
		for (int i = 0; i < preguntas.length; i++) {
			preguntas[i] = new Pregunta();
		}
		inicializarPreguntas();
		inicializarRespuestas();
	}

	/**
	 * Metodo para inicializar las preguntas
	 */
	public void inicializarPreguntas() {
		//pregunta 1
		preguntas[0].setPregunta("¿Que es la Universidad El Bosque según el reglamento?");

		//pregunta 2
		preguntas[1].setPregunta("Cual de las siguientes no es una razón de perdida de calidad del estudiante");

		//pregunta 3
		preguntas[2].setPregunta("¿La universidad realiza un proceso de selección para el ingreso?");

		//pregunta 4
		preguntas[3].setPregunta("¿Cuales son los estudiantes denominados como 'Estudiantes especiales'?");

		//pregunta 5
		preguntas[4].setPregunta("¿Cuales son los 3 tipos de matricula?");

		//pregunta 6
		preguntas[5].setPregunta("¿En qué casos se considera una asignatura perdida por fallas?");

		//pregunta 7
		preguntas[6].setPregunta("¿Qué documentos son necesarios para hacer el proceso de homologación de otra universidad?");

		//pregunta 8
		preguntas[7].setPregunta("¿Cuántos créditos puede matricular un estudiante por período académico?");

		//pregunta 9
		preguntas[8].setPregunta("¿Cuántas veces se le permite al estudiante cancelar una misma materia?");

		//pregunta 10
		preguntas[9].setPregunta("¿Qué porcentaje de dinero le reembolsa la universidad si cancela el semestre antes de iniciar clases?");

		//pregunta 11
		preguntas[10].setPregunta("¿Cuánto tiempo tiene un estudiante para hacer un supletorio después de presentar un parcial?");

		//pregunta 12
		preguntas[11].setPregunta("¿Cómo se llama el procedimiento a seguir para la defensa de los derechos estudiantiles?");

		//pregunta 13
		preguntas[12].setPregunta("¿Copiar en un examen es considerado una falta..?");

		//Pregunta 14
		preguntas[13].setPregunta("¿A cuántas horas de trabajo equivale un crédito académico?");

		//pregunta 15
		preguntas[14].setPregunta("¿De cuantos periodos académicos tiene vigencia la reserva de cupo?");
	}

	/**
	 * Metodo para inicializar las respuestas
	 */
	public void inicializarRespuestas() {
		//pregunta 1
		preguntas[0].setRespuesta1("Una institucion de educación superior, de utilidad común y sin ánimo de lucro"); //correcta
		preguntas[0].setRespuesta2("Una institución pública y sin ánimo de lucro");
		preguntas[0].setRespuesta3("Un parqueadero");
		preguntas[0].setRespuesta4("Una institución médica con animo de lucro");

		//pregunta 2
		preguntas[1].setRespuesta1("Ha finalizado el programa educativo y ha obtenido el titulo correspondiente");
		preguntas[1].setRespuesta2("A solicitud propia, se cancele el semestre o periodo académico");
		preguntas[1].setRespuesta3("No sea reconocido por el reconocimiento facial perteneciente a la entrada de la 134"); //correcta
		preguntas[1].setRespuesta4("Incurrir en bajo rendimiento académico");

		//pregunta 3
		preguntas[2].setRespuesta1("Si");//Correcta
		preguntas[2].setRespuesta2("No");
		preguntas[2].setRespuesta3("Depende");
		preguntas[2].setRespuesta4("¿Cuál universidad?");

		//pregunta 4
		preguntas[3].setRespuesta1("Estudiantes que obtuvieron una beca con ICETEX");
		preguntas[3].setRespuesta2("Estudiantes que con convenios interinstitucionales cursan materias en la Universidad");//correcta
		preguntas[3].setRespuesta3("Estudiantes en condición de discapacidad");
		preguntas[3].setRespuesta4("Estudiantes que cursan una doble titulación");

		//pregunta 5
		preguntas[4].setRespuesta1("Ordinaria, Condicional, Inexistente");
		preguntas[4].setRespuesta2("Tradicional, Novedosa, Completa");
		preguntas[4].setRespuesta3("Liberal, Termino indefinido, Extraordinaria");
		preguntas[4].setRespuesta4("Ordinaria, Extraordinaria, Extemporanea");//correcta

		//pregunta 6
		preguntas[5].setRespuesta1("10% prácticas"); 
		preguntas[5].setRespuesta2("20% teóricas");
		preguntas[5].setRespuesta3("a y b");//correcta
		preguntas[5].setRespuesta4("Ninguna de las anteriores");

		//pregunta 7
		preguntas[6].setRespuesta1("Certificado de notas"); 
		preguntas[6].setRespuesta2("Contenidos programáticos.");
		preguntas[6].setRespuesta3("Certificado de buena conducta");
		preguntas[6].setRespuesta4("Todas las anteriores");//correcta

		//pregunta 8
		preguntas[7].setRespuesta1("20 máximo"); 
		preguntas[7].setRespuesta2("Cuantos quiera el estudiante sin costo");
		preguntas[7].setRespuesta3("15 máximo con costo en créditos extra");
		preguntas[7].setRespuesta4("20 máximo con costo en créditos extra");//correcta

		//pregunta 9
		preguntas[8].setRespuesta1("Una vez"); 
		preguntas[8].setRespuesta2("Dos veces");//correcta
		preguntas[8].setRespuesta3("Tres veces");
		preguntas[8].setRespuesta4("Cuantas veces quiera");

		//pregunta 10
		preguntas[9].setRespuesta1("No hay reembolso"); 
		preguntas[9].setRespuesta2("50%");
		preguntas[9].setRespuesta3("90%");//correcta
		preguntas[9].setRespuesta4("100%");

		//pregunta 11
		preguntas[10].setRespuesta1("5 días");//correcta 
		preguntas[10].setRespuesta2("1 semana");
		preguntas[10].setRespuesta3("1 días");
		preguntas[10].setRespuesta4("2 semanas");

		//pregunta 12
		preguntas[11].setRespuesta1("Cláusula primera"); 
		preguntas[11].setRespuesta2("Ley marcial");
		preguntas[11].setRespuesta3("Ley de Murphy");
		preguntas[11].setRespuesta4("Debido proceso");//correcta
		
		//pregunta 13
		preguntas[12].setRespuesta1("Leve");
		preguntas[12].setRespuesta2("Grave");//correcta
		preguntas[12].setRespuesta3("Gravisima");
		preguntas[12].setRespuesta4("Observador");
		
		//pregunta 14
		preguntas[13].setRespuesta1("10 horas"); 
		preguntas[13].setRespuesta2("20 horas");
		preguntas[13].setRespuesta3("24 horas");
		preguntas[13].setRespuesta4("48 horas");//correcta
		
		//pregunta 15
		preguntas[14].setRespuesta1("1 semestre"); 
		preguntas[14].setRespuesta2("6 meses");
		preguntas[14].setRespuesta3("2 semestres");//correcta
		preguntas[14].setRespuesta4("Cuanto tiempo quiera el estudiante");
		
	}

	/**
	 * Metodo que devuelve el arreglo de preguntas
	 */
	public Pregunta[] getPreguntas() {
		return preguntas;
	}
	
	/**
	 * Metodo para verificar si una respuesta está bien o mal
	 */
	public boolean verificarRespuestas(int num, String res) {
		if (num == 0 || num == 2 || num == 10) {
			if (res.equals(preguntas[num].getRespuesta1())) return true;
		}
		if (num == 3 || num == 8 || num == 12) {
			if (res.equals(preguntas[num].getRespuesta2())) return true;
		}
		if (num == 1 || num == 5 || num == 9 || num == 14) {
			if (res.equals(preguntas[num].getRespuesta3())) return true;
		}
		if (num == 4 || num == 6 || num == 7 || num == 11 || num == 13) {
			if (res.equals(preguntas[num].getRespuesta4())) return true;
		}
		return false;
	}

	/**
	 * Metodo para cambiar las preguntas
	 */
	public void setPreguntas(Pregunta[] preguntas) {
		this.preguntas = preguntas;
	}

	/**
	 * Metodo para mostrar la pregunta unicamente
	 */
	public String mostrarPregunta(int pos) {
		return preguntas[pos].getPregunta();
	}

}