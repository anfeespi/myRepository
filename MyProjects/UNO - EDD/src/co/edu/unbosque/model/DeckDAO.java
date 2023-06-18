package co.edu.unbosque.model;
import java.util.Random;

public class DeckDAO {
	private static List deck;
	private StackDAO discard;
	
	public DeckDAO() {
		deck = new List();
		discard = new StackDAO();
		for(int i=0; i<10; i++) {
			if(i==0) {
				deck.add(new CardsDTO((i)+"", "blue"));
			}
			else{
				deck.add(new CardsDTO((i)+"", "blue"));
				deck.add(new CardsDTO((i)+"", "blue"));
			}
		}
		deck.add(new CardsDTO("+2", "blue"));
		deck.add(new CardsDTO("+2", "blue"));
		deck.add(new CardsDTO("switch", "blue"));
		deck.add(new CardsDTO("switch", "blue"));
		deck.add(new CardsDTO("block", "blue"));
		deck.add(new CardsDTO("block", "blue"));

		
		for(int i=0; i<10; i++) {
			if(i==0) {
				deck.add(new CardsDTO((i)+"", "green"));
			}
			else{
				deck.add(new CardsDTO((i)+"", "green"));
				deck.add(new CardsDTO((i)+"", "green"));
			}
		}
		deck.add(new CardsDTO("+2", "green"));
		deck.add(new CardsDTO("+2", "green"));
		deck.add(new CardsDTO("switch", "green"));
		deck.add(new CardsDTO("switch", "green"));
		deck.add(new CardsDTO("block", "green"));
		deck.add(new CardsDTO("block", "green"));
		
		for(int i=0; i<10; i++) {
			if(i==0) {
				deck.add(new CardsDTO((i)+"", "red"));
			}
			else{
				deck.add(new CardsDTO((i)+"", "red"));
				deck.add(new CardsDTO((i)+"", "red"));
			}
		}
		deck.add(new CardsDTO("+2", "red"));
		deck.add(new CardsDTO("+2", "red"));
		deck.add(new CardsDTO("switch", "red"));
		deck.add(new CardsDTO("switch", "red"));
		deck.add(new CardsDTO("block", "red"));
		deck.add(new CardsDTO("block", "red"));
		
		for(int i=0; i<10; i++) {
			if(i==0) {
				deck.add(new CardsDTO((i)+"", "yellow"));
			}
			else{
				deck.add(new CardsDTO((i)+"", "yellow"));
				deck.add(new CardsDTO((i)+"", "yellow"));
			}
		}
		deck.add(new CardsDTO("+2", "yellow"));
		deck.add(new CardsDTO("+2", "yellow"));
		deck.add(new CardsDTO("switch", "yellow"));
		deck.add(new CardsDTO("switch", "yellow"));
		deck.add(new CardsDTO("block", "yellow"));
		deck.add(new CardsDTO("block", "yellow"));

		
		deck.add(new CardsDTO("wildcard", "multi"));
		deck.add(new CardsDTO("wildcard", "multi"));
		deck.add(new CardsDTO("wildcard", "multi"));
		deck.add(new CardsDTO("wildcard", "multi"));
		deck.add(new CardsDTO("+4", "multi"));
		deck.add(new CardsDTO("+4", "multi"));
		deck.add(new CardsDTO("+4", "multi"));
		deck.add(new CardsDTO("+4", "multi"));
	}
	
	public void shuffle() {
        Random r = new Random();
        for (int i = deck.getCards().length-1; i > 0; i--) {
            int j = r.nextInt(i);
            CardsDTO temp = deck.getCards()[i];
            deck.getCards()[i] = deck.getCards()[j];
            deck.getCards()[j] = temp;
        }
    }

	/**
	 * @return the discard
	 */
	public StackDAO getDiscard() {
		return discard;
	}

	/**
	 * @param discard the discard to set
	 */
	public void setDiscard(StackDAO discard) {
		this.discard = discard;
	}

	/**
	 * @return the deck
	 */
	public List getDeck() {
		return deck;
	}

	/**
	 * @param deck the deck to set
	 */
	public void setDeck(List deck) {
		this.deck = deck;
	}
}
