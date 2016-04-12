//http://docs.oracle.com/javase/7/docs/api/
import java.util.ArrayList;
import java.util.Random;
/**
 * @author Leigh Rubin
 * Assignment #4: Shoe.java
 * Blueprint for a Shoe object
 */
public class Shoe
{
    private ArrayList<Card> shoe;
    private int decks;
    
    public Shoe()
    {
        shoe = new ArrayList<Card>();
    }
    
    /**
     * Constructs a Shoe with an amount of Decks
     * @param int Decks
     */
    public Shoe(int d)
    {
        decks = d;
        shoe = new ArrayList<Card>();
        for(int i = 0; i < decks; i++)
        {
            Deck deck = new Deck();
            for(Card c: deck.getCards())
                shoe.add(c);
        }
    }
    
    /**
     * Shuffles the Cards in the shoe
     */
    public void shuffle()
    {
        shoe.clear();
        for(int i = 0; i < decks; i++)
        {
            Deck deck = new Deck();
            for(Card c: deck.getCards())
                shoe.add(c);
        }
        ArrayList<Card> temp = new ArrayList<Card>();
        Random gen = new Random();
        while(shoe.size() > 0)
            temp.add(shoe.remove(gen.nextInt(shoe.size())));
        for(Card c: temp)
            shoe.add(c);
    }
    
    /**
     * Deals the top Card of the Shoe
     * @return Card The top Card
     */
    public Card dealCard()
    {
        Card c = shoe.get(0);
        shoe.remove(c);
        return c;
    }
    
    /**
     * Returns the Cards in the Shoe
     * @return ArrayList<Card> The Cards
     */
    public ArrayList<Card> getShoe()
    {
        return shoe;
    }
    
    /**
     * Return the number of decks in the Shoe
     * @return int Decks
     */
    public int getDecks()
    {
        return decks;
    }
    
    /**
     * Returns the Number of Cards left in the Shoe
     * @return int Number of Cards
     */
    public int getNumCards()
    {
        return shoe.size();
    }
    
    /**
     * Sets the amount of Decks in the shoe
     * @param int Decks
     */
    public void setDecks(int d)
    {
        decks = d;
        for(int i = 0; i < decks; i++)
        {
            Deck deck = new Deck();
            for(Card c: deck.getCards())
                shoe.add(c);
        }
    }
    
    /**
     * Shuffles the deck when the deck reaches 25% or less
     */
    public void reshuffle()
    {
        if(getNumCards() < (decks * 52) / 4)
            shuffle();
    }
    
    /**
     * String representation of the Shoe
     * @return String representation
     */
    public String toString()
    {
        return "The shoe contains " + getNumCards() + " cards.";
    }
}
        