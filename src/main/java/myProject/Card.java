package myProject;

public class Card implements ICard{
	private int rank;
	private Suit suit;
	
	public Card(int rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
	}
	
	public void setRank(int rank){
		this.rank = rank;
	}
	
	public int getRank(){
		return this.rank;
	}
	
	public void setSuit(Suit suit){
		this.suit = suit;
	}
	
	public Suit getSuit(){
		return this.suit;
	}
	
	public String toString(){
		//String message = String.valueOf(rank) + " of " + suit.toString();
		//return message;
		return "" + rank + " of " + suit;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == this){
			return true;
		}
		
		if(!(o instanceof Card)){
			return false;
		}
		Card c = (Card) o;
		return rank == c.rank && suit == c.suit;
	}

	@Override
	public int hashCode(){
		int result = 17;
		result = 31 * result + rank;
		result = 31 * result + suit.hashCode();
		return result;
	}
	
	
	
}
