package co.edu.unbosque.model;

public class PlayerDAO {
	private PlayerDTO[] players;
	
	public PlayerDAO() {
		players = new PlayerDTO[3];
		for (int i = 0; i < players.length; i++) {
			players[i] = new PlayerDTO();
		}
	}
	
	public void playCard(int player, int pos) {
		players[player].getHand().remove(pos);
	}
	
	public void stealCard(int player, CardsDTO card) {
		
		players[player].getHand().add(card);
	}
	
	public boolean win(int player) {
		if(players[player].getHand().getCards().length == 0) return true;
		else return false;
	}

	/**
	 * @return the players
	 */
	public PlayerDTO[] getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(PlayerDTO[] players) {
		this.players = players;
	}
	
}
