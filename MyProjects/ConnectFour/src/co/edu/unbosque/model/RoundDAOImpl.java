package co.edu.unbosque.model;

import java.util.ArrayList;
import co.edu.unbosque.model.persistence.FileHandler;
/**
 * Clase que implementa los metodos propios que aplican a las rondas o partidas de juego
 * @author Diego Forero
 * @author Andres Espitia
 * @author Camilo Uribe
 *
 */
public class RoundDAOImpl implements RoundDAO{
	/**
	 * Arreglo de rondas o partidas de juego
	 */
	private ArrayList<RoundDTO> rounds;
	/**
	 * Clase que contiene los atributos o caracteristicas la partida que se jugo
	 */
	private RoundDTO roundaux;
	/**
	 * Metodo constructor
	 */
	public RoundDAOImpl() {
		rounds = new ArrayList<>();
	}
	/**
	 * Metodo que carga las partidas jugadas registradas
	 */
	public void loadSerializable() {
		Object aux = FileHandler.readSerializable("roundsserializable.daec");
		rounds = (ArrayList<RoundDTO>) aux;
	}
	/**
	 * Metodo que crea y registra la partida que se juega o jugo
	 * 
	 */
	@Override
	public void createRound(String winner, int pieces, String date, String team) {
		roundaux = new RoundDTO(winner, pieces, team, date);
		rounds.add(roundaux);
		FileHandler.writeSerializable(rounds, "roundsserializable.daec");
	}

	/**
	 * @return the rounds
	 */
	public ArrayList<RoundDTO> getRounds() {
		return rounds;
	}

	/**
	 * @param rounds the rounds to set
	 */
	public void setRounds(ArrayList<RoundDTO> rounds) {
		this.rounds = rounds;
	}

}
