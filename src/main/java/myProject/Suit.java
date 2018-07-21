package myProject;

public enum Suit {
	// hearts, diamonds, clubs, spades
	HEARTS,
	DIAMONDS,
	CLUBS,
	SPADES;
	
	public String toString(){
		String meaning = new String();
		
		if(this == Suit.CLUBS){
			meaning = "Clubs";
		}else if(this == Suit.DIAMONDS){
			meaning = "Diamonds";
		}else if(this == Suit.SPADES){
			meaning = "Spades";
		}else if(this == Suit.HEARTS){
			meaning = "Hearts";
		}

		return meaning;
	}
}
