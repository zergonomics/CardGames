package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 *  Is deck of cards.
 *  Has no error checking.
 * @author Sung-Hoon
 */
public class Deck {
	private LinkedList<String> cards;
	
	public Deck() {
		cards = new LinkedList<String>();
	}
	public Deck(List<String> data) {
		cards = new LinkedList<String> (data);
	}
	
	/**
	 * Method to add individual cards to the deck. Cards are added to the bottom.
	 * @param newCards VarArgs, the cards to be added
	 */
	public void addIndividualCards(String... newCards) {
		for(int i = 0; i < newCards.length; i++) {
			cards.add(newCards[i]);
		}
	}
	/**
	 * Method to add a {@link List} of cards to the deck. Cards are added to the bottom.
	 * @param newCards {@link List} of cards to be added
	 */
	public void addListOfCards(List<String> newCards) {
		cards.addAll(newCards);
	}
	/**
	 * Shuffles the deck.
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
	/**
	 * Draw a single card from the top of the deck.
	 * @return a card
	 */
	public String draw() {
		return this.drawMultiple(1).get(0);
	}
	/**
	 * Draw multiple cards from the top of the deck.
	 * @param numCards The number of cards to draw.
	 * @return List of cards
	 */
	public List<String> drawMultiple(int numCards) {
		List<String> drawn = new ArrayList<String>();
		for(int i = 0; i < numCards; i++) {
			drawn.add(cards.removeFirst());
		}
		return drawn;
	}
	/**
	 * Get size of deck
	 * @return size of deck
	 */
	public int getSize() {
		return cards.size();
	}
	
}
