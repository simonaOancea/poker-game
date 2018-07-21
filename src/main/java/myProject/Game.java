package myProject;
import javax.swing.*;

public class Game {
	
	public static void main(String[] args) {
        Card card1 = new Card(5, Suit.DIAMONDS);
        Card card2 = new Card(6, Suit.SPADES);
        Card card3 = new Card(10, Suit.SPADES);
        Card card4 = new Card(10, Suit.HEARTS);
        Card card5 = new Card(12, Suit.CLUBS);

        Card card6 = new Card(13, Suit.DIAMONDS);
        Card card7 = new Card(2, Suit.SPADES);
        Card card8 = new Card(5, Suit.SPADES);
        Card card9 = new Card(13, Suit.HEARTS);
        Card card10 = new Card(8, Suit.CLUBS);


        Player playerOne = new Player("Michael Scott", "Michael01", 300);
        IHand handOne = playerOne.getHand();
        handOne.add(card1);
        handOne.add(card2);
        handOne.add(card3);
        handOne.add(card4);
        handOne.add(card5);

        Player playerTwo = new Player("Daniel Brown", "Daniel18", 300);
        IHand handTwo = playerTwo.getHand();
        handTwo.add(card6);
        handTwo.add(card7);
        handTwo.add(card8);
        handTwo.add(card9);
        handTwo.add(card10);

        JFrame frame = new JFrame();

        frame.setSize(800,500);//400 width and 500 height
        frame.setLayout(null);//using no layout managers
        frame.setVisible(true);


        for (ICard card : handOne) {
            // place a button having a text with the .toString of the card

        }

    }


}
