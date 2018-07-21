package myProject;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Hand implements IHand, Comparable<IHand> {
    private ArrayList<ICard> cardList = new ArrayList<>();
    private static HashMap<String, Integer> frequency = new HashMap<>();
    
 
    static{
    	frequency.put("Royal flush", 4);
        frequency.put("Straight flush", 36);
        frequency.put("Four of a kind", 624);
        frequency.put("Full house", 3744);
        frequency.put("Flush", 5108);
        frequency.put("Straight", 10200);
        frequency.put("Three of a kind", 54912);
        frequency.put("Two pair", 123552);
        frequency.put("One pair", 1098240);
        frequency.put("No pair", 1302540);
    }


    public void add(ICard card) {
        cardList.add(card);

    }

    public void remove(ICard card) {
        cardList.remove(card);

    }

    public Iterator<ICard> iterator() { 

        return cardList.iterator();
    }
    

    public int size() {

        return cardList.size();
    }
    
 /*foreach element in cards, get the element (by rank) from the hashmap
   if null, it wasn't there! -> add it (key=rank, value=1)
   if not null, remove, +1 to its value, add again*/

    public HashMap<Integer, Integer> rankFrequency() {
        HashMap<Integer, Integer> rankFrequency = new HashMap<>();

        for (ICard c : cardList) {
            Integer rankOfCard = c.getRank();
            Integer frequencyOfCard = rankFrequency.get(rankOfCard);

            if (frequencyOfCard == null){
                frequencyOfCard = 1;
                rankFrequency.put(rankOfCard, frequencyOfCard);
            } else {
                rankFrequency.put(rankOfCard, ++frequencyOfCard);
            }
        }
        return rankFrequency;
    }
    
    @Override
    public String toString() {
        StringBuffer cards = new StringBuffer();

        for (int i = 0; i < cardList.size(); i++) {
            cards.append(cardList.get(i).toString());

            if (i == cardList.size() - 1) {
                cards.append(".");
            } else {
                cards.append(", ");
            }

        }

        return "This hand contains the following cards: " + cards;
    }

    
    public boolean sameSuit() {
    	int isClubs = 0;
    	int isDiamonds = 0;
    	int isHearts = 0;
    	int isSpades = 0;
    	
    	for(ICard c : cardList){
    		if(c.getSuit() == Suit.CLUBS){
    			isClubs++;
    		}else if(c.getSuit() == Suit.DIAMONDS){
    			isDiamonds++;
    		}else if(c.getSuit() == Suit.HEARTS){
    			isHearts++;
    		}else if(c.getSuit() == Suit.SPADES){
    			isSpades++;	
    		}
    		
    		if(isClubs == 5 || isDiamonds == 5 || isHearts == 5 || isSpades == 5){
    			return true;
    		}
    	}
    	return false;
    }

    public boolean twoOfAKind() {
        int m = 0;
        int[] ranks = new int[5];
        boolean onePair = false;

        for (ICard c : cardList) { //copy ranks to new array
            ranks[m] = c.getRank();
            m++;
        }

        for (int i = ranks.length - 1; i >= 0; i--) { //sort ranks
            for (int j = 1; j <= i; j++) {
                if (ranks[j - 1] > ranks[j]) {
                    int temp = ranks[j - 1];
                    ranks[j - 1] = ranks[j];
                    ranks[j] = temp;
                }
            }
        }

        for (int i = 0; i < ranks.length - 1; i++) {
            if (ranks[i] == ranks[i + 1]) {
                onePair = true;
            }
        }

        return onePair;
    }
    
    public boolean threeOfAKind() {
        HashMap<Integer, Integer> frequency = this.rankFrequency();

        return frequency.containsValue(3);
    }
    
    public boolean twoPairs() {
        int numberOfPairs = 0;
        HashMap<Integer, Integer> frequency = this.rankFrequency();

        Collection c = frequency.values();
        Iterator itr = c.iterator();
        while(itr.hasNext()){
            if(itr.next().equals(2)){
                numberOfPairs++;
            }
        }

        return numberOfPairs == 2;
    }

    public boolean fourOfAKind() {
    	HashMap<Integer, Integer> frequency = this.rankFrequency();
    	
        return frequency.containsValue(4);
    }
    
    
    public boolean fullHouse(){
    	if(this.twoOfAKind() & this.threeOfAKind()){
    		return true;
    	}
    	return false;
    }
    
    public boolean royalFlush(){
    	HashMap<Integer, Integer> frequency = this.rankFrequency();
    	
    	if(frequency.containsKey(10) & frequency.containsKey(12) & frequency.containsKey(13) & 
    			frequency.containsKey(14) & frequency.containsKey(15) & this.sameSuit()){
    		return true;
    	}
    	
    	return false;
    }
    
    
    public boolean straight(){ //excluding royalFlush and straightFlush
    	boolean areConsecutive = true;
    	ArrayList<Integer> orderedCards = new ArrayList<>();
    
    	for(ICard c : cardList){
    		Integer rank = c.getRank();
    		orderedCards.add(rank);
    	}
    	
    	Collections.sort(orderedCards);
    	
    	for(int i = 0; i < orderedCards.size() - 1; i++){
    		if(orderedCards.get(i) + 1 != orderedCards.get(i+1)){
    			areConsecutive = false;
    		}
    	}
    	
    	return areConsecutive;
    }
    
    
    public boolean straightFlush(){
    	if(this.straight() && this.sameSuit()){
    		return true;
    	}
    	return false;
    }
    
   
    
    public boolean noPair(){
    	
    	if(this.sameSuit() || this.twoOfAKind() || this.threeOfAKind() || this.fourOfAKind() || this.fullHouse()
    			|| this.royalFlush() || this.straight()){
    		return false;
    	}
    	return true;
    }
    
    
    public int getScore() {
    	boolean twoOfAKind = this.twoOfAKind();
        boolean threeOfAKind = this.threeOfAKind();
        boolean sameSuit = this.sameSuit();
        boolean twoPairs = this.twoPairs();
        boolean straight = this.straight();
        boolean straightFlush = this.straightFlush();
        boolean fourOfAKind = this.fourOfAKind();
        boolean fullHouse = this.fullHouse();
        boolean royalFlush = this.royalFlush();
        boolean noPair = this.noPair();
        int finalScore = 0;

        if(royalFlush){
            finalScore = frequency.get("Royal flush");
        }else if(fullHouse){
        	finalScore = frequency.get("Full house");
        }else if(fourOfAKind){
        	finalScore = frequency.get("Four of a kind");
        }else if(twoPairs){
        	finalScore = frequency.get("Two pairs");
        }else if(threeOfAKind){
        	finalScore = frequency.get("Three of a kind");
        }else if(twoOfAKind){
        	finalScore = frequency.get("One pair");
        }else if(sameSuit){
        	finalScore = frequency.get("Same suit");
        }else if(noPair){
        	finalScore = frequency.get("No pair");
        }else if(straight){
        	finalScore= frequency.get("Straight");
        }else if(straightFlush){
        	finalScore = frequency.get("Straight flush");
        }

        return finalScore;
    }

	@Override
	public int compareTo(IHand hand) {
		if(this.getScore() == ((Hand) hand).getScore()){
			if(this.noPair() == ((Hand) hand).noPair()){
				
			}
			return 0;
		}else if(this.getScore() > ((Hand) hand).getScore()){
			return 1;
		}else
			
		return -1;
	}


}
