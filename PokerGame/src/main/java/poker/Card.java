package poker;

public class Card implements Comparable<Card> {
	private CardValueEnum value;
	private SuitEnum suit;

	public Card(CardValueEnum cardValue, SuitEnum cardSuit) {
		this.value = cardValue;
		this.suit = cardSuit;
	}

	CardValueEnum getValue() {
		return value;
	}

	SuitEnum getSuit() {
		return suit;
	}

	public String toString() {
		return suit.getSuitCode() + "_" + value.getCardValue();
	}

	public int compareTo(Card card) {
		int i = this.suit.getRank() - card.getSuit().getRank();
		if (i != 0)
			return i;

		return (this.getValue().getCardValue() - card.getValue().getCardValue());
	}
}
