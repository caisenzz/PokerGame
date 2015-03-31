package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<Card> deck = new ArrayList<Card>();

	public Deck() {
		for (SuitEnum suit : SuitEnum.values()) {
			for (CardValueEnum value : CardValueEnum.values()) {
				this.deck.add(new Card(value, suit));
			}
		}
	}

	// This method is used to test. It shouldn't be exposed to users.
	public List<Card> getDeck() {
		return deck;
	}

	public int getCardNum() {
		return deck.size();
	}

	public void shuffle() {
		// This API works, but no challenge!!!
		// Collections.shuffle(this.deck);

		// Fisher–Yates shuffle
		int num = this.getCardNum();
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			int randomNum = i + random.nextInt(num - i);
			swap(this.deck, i, randomNum);
		}
	}

	private void swap(List<Card> deck, int i, int j) {
		Card tmp = deck.get(i);
		deck.set(i, deck.get(j));
		deck.set(j, tmp);
	}

}
