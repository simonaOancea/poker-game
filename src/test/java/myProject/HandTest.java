package myProject;
import static org.junit.Assert.assertEquals; //import static vs import
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.Iterator;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

public class HandTest {
	
	@Test
	public void testAddCard(){
		Card card = new Card(15, Suit.HEARTS);
		Hand hand = new Hand();
		
		hand.add(card);
		
		Card sameCard = new Card(15, Suit.HEARTS);
		for(ICard c : hand){
			assertTrue(c.equals(sameCard));
		}
		 int expectedSize = 1;
		 assertTrue(expectedSize == hand.size());

	}

	@Test
	public void testRankFrequency(){
		//Arrange
		Hand hand = new Hand();
		ArrayList<ICard> givenCardList = new ArrayList<>();
		givenCardList.add(new Card(5, Suit.HEARTS));
		givenCardList.add(new Card(6, Suit.HEARTS));
		givenCardList.add(new Card(5, Suit.HEARTS));
		givenCardList.add(new Card(6, Suit.HEARTS));
		givenCardList.add(new Card(8, Suit.HEARTS));
		
		hand.add(new Card(5, Suit.HEARTS));
		hand.add(new Card(6, Suit.HEARTS));
		hand.add(new Card(10, Suit.HEARTS));
		hand.add(new Card(6, Suit.HEARTS));
		hand.add(new Card(8, Suit.HEARTS));
		
		HashMap<Integer, Integer> expectedFrequency = new HashMap<>();
		expectedFrequency.put(5, 2);
		expectedFrequency.put(6, 2);
		expectedFrequency.put(8, 1);
		
		HashMap<Integer, Integer> myFrequency = hand.rankFrequency();
		
		//Assert
		assertFalse(expectedFrequency.keySet().equals(myFrequency.keySet()));	
		
	}
	
	@Test
	public void testSameSuit(){
		Hand hand = new Hand();
	
		hand.add(new Card(5, Suit.HEARTS));
		hand.add(new Card(6, Suit.HEARTS));
		hand.add(new Card(7, Suit.HEARTS));
		hand.add(new Card(8, Suit.HEARTS));
		hand.add(new Card(9, Suit.HEARTS));
		
		assertTrue(hand.sameSuit());
	}
	
	@Test
	public void testTwoOfAKindReturnsTrue(){
		Hand hand = new Hand();
		hand.add(new Card(8, Suit.HEARTS));
		hand.add(new Card(2, Suit.SPADES));
		hand.add(new Card(5, Suit.DIAMONDS));
		hand.add(new Card(3, Suit.DIAMONDS));
		hand.add(new Card(8, Suit.CLUBS));
		
		assertTrue(hand.twoOfAKind());
	}

	@Test
	public void testTwoOfAKindReturnsFalse(){
		
		Hand hand = new Hand();
		hand.add(new Card(8, Suit.HEARTS));
		hand.add(new Card(2, Suit.SPADES));
		hand.add(new Card(5, Suit.DIAMONDS));
		hand.add(new Card(3, Suit.DIAMONDS));
		hand.add(new Card(1, Suit.CLUBS));
		
		assertFalse(hand.twoOfAKind());
	}
	
	
	@Test
	public void testThreeOfAKindReturnsTrue(){
	    Hand hand = new Hand();

        hand.add(new Card(5, Suit.HEARTS));
        hand.add(new Card(6, Suit.HEARTS));
        hand.add(new Card(10, Suit.HEARTS));
        hand.add(new Card(6, Suit.HEARTS));
        hand.add(new Card(6, Suit.HEARTS));

        assertTrue(hand.threeOfAKind());

	}

	@Test
    public void testThreeOfAKindReturnsFalse(){
        Hand hand = new Hand();

        hand.add(new Card(5, Suit.HEARTS));
        hand.add(new Card(6, Suit.HEARTS));
        hand.add(new Card(10, Suit.HEARTS));
        hand.add(new Card(6, Suit.HEARTS));
        hand.add(new Card(9, Suit.HEARTS));

        assertFalse(hand.threeOfAKind());

    }

    @Test
    public void testTwoPairsReturnTrue(){
        Hand hand = new Hand();
        hand.add(new Card(5, Suit.HEARTS));
        hand.add(new Card(6, Suit.HEARTS));
        hand.add(new Card(5, Suit.HEARTS));
        hand.add(new Card(6, Suit.HEARTS));
        hand.add(new Card(9, Suit.HEARTS));

        assertTrue(hand.twoPairs());


    }

    @Test
    public void testTwoPairsReturnsFalse(){
        Hand hand = new Hand();
        hand.add(new Card(5, Suit.HEARTS));
        hand.add(new Card(6, Suit.HEARTS));
        hand.add(new Card(12, Suit.HEARTS));
        hand.add(new Card(6, Suit.HEARTS));
        hand.add(new Card(9, Suit.HEARTS));

        assertFalse(hand.twoPairs());

    }
    
    @Test
    public void testFourOfAKindReturnsTrue(){
    	Hand hand = new Hand();
    	hand.add(new Card(5, Suit.HEARTS));
    	hand.add(new Card(5, Suit.CLUBS));
    	hand.add(new Card(5, Suit.DIAMONDS));
    	hand.add(new Card(5, Suit.SPADES));
    	hand.add(new Card(10, Suit.SPADES));
    	
    	assertTrue(hand.fourOfAKind());
    }
    
    @Test
    public void testFourOfAKindReturnsFalse(){
    	Hand hand = new Hand();
    	hand.add(new Card(5, Suit.HEARTS));
    	hand.add(new Card(8, Suit.CLUBS));
    	hand.add(new Card(5, Suit.DIAMONDS));
    	hand.add(new Card(10, Suit.SPADES));
    	hand.add(new Card(5, Suit.SPADES));
    	
    	assertFalse(hand.fourOfAKind());
    
    }
    
    @Test
    public void testFullHouseReturnsTrue(){
    	Hand hand = new Hand();
    	hand.add(new Card(5, Suit.HEARTS));
    	hand.add(new Card(5, Suit.DIAMONDS));
    	hand.add(new Card(12, Suit.CLUBS));
    	hand.add(new Card(12, Suit.SPADES));
    	hand.add(new Card(12, Suit.DIAMONDS));
    	
    	assertTrue(hand.fullHouse());
    }
    
    @Test
    public void testFullFouseReturnsFalse(){
    	Hand hand = new Hand();
    	hand.add(new Card(5, Suit.HEARTS));
    	hand.add(new Card(5, Suit.DIAMONDS));
    	hand.add(new Card(12, Suit.CLUBS));
    	hand.add(new Card(12, Suit.SPADES));
    	hand.add(new Card(14, Suit.DIAMONDS));
    	
    	assertFalse(hand.fullHouse());
    	
    }
    
    @Test
    public void testStraightReturnsTrue(){
    	Hand hand = new Hand();
    	hand.add(new Card(5, Suit.HEARTS));
    	hand.add(new Card(7, Suit.HEARTS));
    	hand.add(new Card(8, Suit.HEARTS));
    	hand.add(new Card(6, Suit.HEARTS));
    	hand.add(new Card(9, Suit.SPADES));
    	
    	assertTrue(hand.straight());
    	
    }
    
    @Test
    public void testStraightReturnsFalse(){
    	Hand hand = new Hand();
    	hand.add(new Card(5, Suit.DIAMONDS));
    	hand.add(new Card(7, Suit.HEARTS));
    	hand.add(new Card(8, Suit.HEARTS));
    	hand.add(new Card(6, Suit.HEARTS));
    	hand.add(new Card(10, Suit.HEARTS));
    	
    	assertFalse(hand.straight());
    	
    }
    
    @Test
    public void testGetScoreReturnsValueForOnePair(){
    	int finalScore = 1098240;
    	Hand hand = new Hand();
    	hand.add(new Card(5, Suit.DIAMONDS));
    	hand.add(new Card(9, Suit.SPADES));
    	hand.add(new Card(10, Suit.DIAMONDS));
    	hand.add(new Card(5, Suit.SPADES));
    	hand.add(new Card(12, Suit.HEARTS));
    	
    	assertTrue(hand.getScore() == finalScore);
    	
    	
    }
    
    @Test
    public void testStraightFlushReturnTrue(){
    	Hand hand = new Hand();
    	hand.add(new Card(5, Suit.DIAMONDS));
    	hand.add(new Card(6, Suit.DIAMONDS));
    	hand.add(new Card(7, Suit.DIAMONDS));
    	hand.add(new Card(8, Suit.DIAMONDS));
    	hand.add(new Card(9, Suit.DIAMONDS));
    	assertTrue(hand.straightFlush());
    	
    }
    
    @Test
    public void testStraightFlushReturnsFalse(){
    	Hand hand = new Hand();
    	hand.add(new Card(5, Suit.DIAMONDS));
    	hand.add(new Card(6, Suit.DIAMONDS));
    	hand.add(new Card(7, Suit.DIAMONDS));
    	hand.add(new Card(10, Suit.DIAMONDS));
    	hand.add(new Card(3, Suit.DIAMONDS));
    	assertFalse(hand.straightFlush());
    }
    
    
    
    @Test
    public void testToString(){
        Hand hand = new Hand();
        hand.add(new Card(5, Suit.DIAMONDS));
        hand.add(new Card(7, Suit.HEARTS));
        String expected = "This hand contains the following cards: 5 of Diamonds, 7 of Hearts.";
        assertEquals(expected, hand.toString());

    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
