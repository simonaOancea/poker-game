package myProject;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardTest {

	@Test
	public void testNotEqual() {
		assertFalse(1 == 2);
	}
	
	@Test
	public void testGetRank(){
		// Arrange
		int rank;
		Card card = new Card(2, Suit.HEARTS);
		
		// Act
		rank = card.getRank();
		
		// Assert
		assertEquals(2, rank);
	}
	
	@Test
	public void testToString() {
//		Card card = new Card(13, Suit.DIAMONDS);
//		assertEquals("Queen of Diamonds", card.toString());
		
//		Card card = new Card(15, Suit.SPADES);
//		assertEquals("Ace of Spades", card.toString());
		
		Card card = new Card(3, Suit.CLUBS);
		assertEquals("3 of Clubs", card.toString());
		
	}
	
	@Test
	public void testExceptionWhenBadRank() {
		
		// Caz 1
		// Assert that new Card(1, Suit.CLUBS) throws exception
		// Assert that new Card(11, Suit.CLUBS) throws exception
		// Assert that new Card(16, Suit.CLUBS) throws exception
		
		// Caz 2 - go for this
		// Assert that new Card(1, Suit.CLUBS) has rank 15 (is Ace)
		// Assert that new Card(11, Suit.CLUBS) has rank 15 (is Ace)
		// Assert that new Card(16, Suit.CLUBS) throws an exception
	}
	
	@Test
	public void testCardsAreComparable () {
		// Assert comparable works as expected (e.g. Ace greater than King) (follow poker rules)
		// Assert two cards same value different suit are equal
	}
	
	
}