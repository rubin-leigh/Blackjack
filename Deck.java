//http://docs.oracle.com/javase/7/docs/api/
import java.util.ArrayList;
import java.util.Random;
/**
 * @author Leigh Rubin
 * Assignment #3: Deck.java
 * Blueprint for a Deck object
 */
public class Deck
{
    private ArrayList<Card> deck;
    
    /**
     * Constructs a Deck object with 52 Cards
     */
    public Deck()
    {
        deck = new ArrayList<Card>();
        for(int i = 0; i < 4; i++)
            for(int j = 1; j < 14; j++)
                if(j == 13)
                    deck.add(new Card(0,i));
                else
                    deck.add(new Card(j,i));
    }
    
    /**
     * Returns the Cards in the deck
     * @return ArrayList<Card> The Cards
     */
    public ArrayList<Card> getCards()
    {
        return deck;
    }
    
    /**
     * Return the number of Cards in the deck
     * @return int Number of Cards
     */
    public int getNumCards()
    {
        return deck.size();
    }
    
    /**
     * String representation of the Deck
     * @return String representation
     */
    public String toString()
    {
        return "The deck contains " + getNumCards() + " cards.";
    }
}    