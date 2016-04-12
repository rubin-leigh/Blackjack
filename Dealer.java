import java.util.Scanner;
import java.util.ArrayList;
/**
 * @author Leigh Rubin
 * Assignment #7: Dealer.java
 * Blueprint for a Dealer object
 */
public class Dealer
{
    private Hand hand;
    private Shoe shoe;
    
    /**
     * Constructs a Dealer object with an empty Hand and Shoe
     */
    public Dealer()
    {
        hand = new Hand();
        shoe = new Shoe();
    }
    
    /**
     * Adds a card to the Dealers hand
     * @return Card c
     */
    public Card hit()
    {
        Card c = shoe.dealCard();
        hand.addCard(c);
        return c;
    }
    
    /**
     * Returns the Dealer's second card
     * @return Card Up card
     */
    public Card getUpCard()
    {
        return hand.getCards().get(1);
    }
    
    /**
     * Returns the Dealer's hand
     * @return Hand hand
     */
    public Hand getHand()
    {
        return hand;
    }
    
    /**
     * Returns the Shoe
     * @return Shoe shoe
     */
    public Shoe getShoe()
    {
        return shoe;
    }
    
    /**
     * Returns the cards in the Dealer's hand
     * @return ArrayList<Card> Cards in hand
     */
    public ArrayList<Card> getCards()
    {
        return hand.getCards();
    }
    
    /**
     * String representation of the Dealer
     * @return String representation
     */
    public String toString()
    {
        return "Hand: " + getCards() + "\nUp Card: " + getUpCard();
    }
}
    
