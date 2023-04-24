package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * Clase que contiene los atributos o caracteristicas la partida que se jugo
 * @author Diego Forero
 * @author Andres Espitia
 * @author Camilo Uribe
 *
 */
public class RoundDTO implements Serializable {
	/**
	 * Ganador de la partida
	 */
	private String winner;
	/**
	 * Piezas que se movieron para que hubiera un ganador
	 */
	private int pieces;
	/**
	 * Equipo al que pertenece el ganador
	 */
	private String team;
	/**
	 * Fecha del dia en que se jugo la partida
	 */
	private String date;
	/**
	 * Metodo constructor vacio
	 */
	public RoundDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo constructor heredado de la clase Super
	 * @param winner Ganador de la partida
	 * @param pieces Piezas que se movieron para que hubiera un ganador
	 * @param team Equipo al que pertenece el ganador
	 * @param date Fecha del dia en que se jugo la partida
	 */
	public RoundDTO(String winner, int pieces, String team, String date) {
		super();
		this.winner = winner;
		this.pieces = pieces;
		this.team = team;
		this.date = date;
	}

	/**
	 * @return the winner
	 */
	public String getWinner() {
		return winner;
	}

	/**
	 * @param winner the winner to set
	 */
	public void setWinner(String winner) {
		this.winner = winner;
	}

	/**
	 * @return the pieces
	 */
	public int getPieces() {
		return pieces;
	}

	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Name: "+this.winner+" Pieces: "+this.pieces+"  Date: "+this.date+"  Team: "+this.team+"\n";
	}
}
