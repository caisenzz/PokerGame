package poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PokerTest {

	private Deck deck;

	@Before
	public void setUp() {
		deck = new Deck();
	}

	@Test
	public void testDeckInit() {
		assertEquals("Size of cards should be 52", 52, deck.getCardNum());
	}

	@Test
	public void testShuffle() {

		// shuffle once
		deck.shuffle();
		List<Card> cardListOne = new ArrayList<Card>(deck.getDeck());
		for (Card card : deck.getDeck()) {
			System.out.println(card.toString());
		}
		// shuffle twice
		deck.shuffle();
		List<Card> cardListTwo = deck.getDeck();
		assertNotEquals(cardListOne, cardListTwo);

		int duplicatedNum = checkDuplicatedNum(cardListOne,cardListTwo);

		assertNotEquals(52, duplicatedNum);
	}

	@Test
	public void testSort() {
		// shuffle
		deck.shuffle();
		// get cards without order
		List<Card> randomCards = new ArrayList<Card>(deck.getDeck());

		// sort cards
		Collections.sort(deck.getDeck());

		int duplicatedNumOne = checkDuplicatedNum(randomCards,deck.getDeck());

		List<Card> orderedCards = deck.getDeck();
		// print out cards
		for (Card card : orderedCards) {
			System.out.println(card.toString());
		}

		Deck deckTest = new Deck();
		// initial deck has the same order with sortedDeck
		List<Card> iniOrderedCards = deckTest.getDeck();

		int duplicatedNum = checkDuplicatedNum(iniOrderedCards,orderedCards);

		assertNotEquals(52, duplicatedNumOne);
		assertEquals(52, duplicatedNum);

	}
	
	
	@Test
	public void TestSortWithRank(){
		SuitEnum.SPADES.setRank(1);		
		SuitEnum.HEARTS.setRank(2);
		SuitEnum.CLUBS.setRank(3);
		SuitEnum.DIAMONDS.setRank(4);
		
		List<Card> orderedCards =  new ArrayList<Card>(deck.getDeck());
		// print out cards
		for (Card card : orderedCards) {
			System.out.println(card.toString());
		}

		Collections.sort(deck.getDeck());
		for (Card card : deck.getDeck()) {
			System.out.println(card.toString());
		}
		
		int duplicatedNum = checkDuplicatedNum(orderedCards,deck.getDeck());
		assertEquals(0, duplicatedNum);
			
	
	}
	
	
	private int checkDuplicatedNum(List<Card> a,List<Card> b){
		int duplicatedNum = 0;
		for (int i = 0; i < 52; i++) {
			if (a.get(i).compareTo(b.get(i)) == 0) {
				duplicatedNum++;
			}
		}
		return duplicatedNum;
	}

}
