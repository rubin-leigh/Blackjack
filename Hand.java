//http://docs.oracle.com/javase/7/docs/api/
import java.util.ArrayList;
/**
 * @author Leigh Rubin
 * Assignment #5: Hand.java
 * Blueprint for a Hand object
 */
public class Hand
{
    private int value;
    private ArrayList<Card> cards;
    
    /**
     * Constructs an empty hand
     */
    public Hand()
    {
        cards = new ArrayList<Card>();
    }
    
    /**
     * Adds a Card to the hand
     * @param Card to be added to the hand
     */
    public void addCard(Card c)
    {
        value += c.getValue();
        if(c.getRank().equals("Ace") && busted())
        {
            c.setValue(1);
            value -= 10;//if ace dealt causes bust, change value to 1
        }
        else if(busted())
        {
            for(int i = 0; i < cards.size(); i++)
            {
                if(cards.get(i).getRank().equals("Ace") && cards.get(i).getValue() == 11)
                {
                    cards.get(i).setValue(1);
                    value -= 10;
                    break;//if busted and ace in hand with value of 11, change its value to 1
                }
            }
        }
        cards.add(c);
    }
    
    /**
     * Check if the hand is blackjack
     * @return boolean Blackjack
     */
    public boolean blackjack()
    {
        if(value == 21 && cards.size() == 2)
            return true;
        return false;
    }
    
    /**
     * Check if the hand has busted
     * @return boolean Busted
     */
    public boolean busted()
    {
        return value > 21;
    }
    
    /**
     * Check if the hand is five card charlie
     * @return boolean Five card charlie
     */
    public boolean fiveCardCharlie()
    {
        return cards.size() == 5 && value <= 21;
    }
    
    /**
     * Return the value of the Hand
     * @return int The value
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * When the hand is over, clears the hand
     */
    public void handOver()
    {
        cards.clear();
        value = 0;
    }
    
    /**
     * Returns the Cards in the hand
     * @return ArrayList<Card> Cards in the hand
     */
    public ArrayList<Card> getCards()
    {
        return cards;
    }
    
    /**
     * Gets a card at a certain location in the hand
     * @param int Location
     * @return Card in hand at loc
     */
    public Card getCardInHand(int loc)
    {
        return getCards().get(loc);
    }
    
    /**
     * String representation of the Hand
     * @return String representation
     */
    public String toString()
    {
        return "Hand: " + getCards() + "\nValue: " + getValue();
    }
}