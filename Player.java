//http://docs.oracle.com/javase/7/docs/api/
/**
 * @author Leigh Rubin
 * Assignment #6: Player.java
 * Blueprint for a Player object
 */
public class Player
{
    private Hand hand;
    private final String NAME;
    private double money;
    private double bet;
    private double insurance;
    
    /**
     * Constructs a Player with a Name and Bankroll
     * @param String Name
     * @param double Money
     */
    public Player(String n, double m)
    {
        hand = new Hand();
        NAME = n;
        money = m;
    }
    
    /**
     * Bets a certaing amount of money
     * @param
     */
    public void bet(double b)
    {
        if(b <= money)
        {
            bet = b;
        }
    }
    
    /**
     * Adds a card to the player's hand
     * @param Card c
     */
    public void hit(Card c)
    {
        if(!(hand.busted()))
            hand.addCard(c);
    }
    
    /**
     * Precondition: player has only 2 cards
     * Doubles the players bet
     */
    public void doubleDown()
    {
        if(hand.getCards().size() <= 2 && money >= bet*2)
            bet *= 2;
    }
    
    /**
     * Precondition: Dealer's up card is an Ace
     * Places a side bet of original bet / 2 that pays 2:1 on a Dealers blackjack
     * Sets insurance to 0 if insurance is > 0
     */
    public void insure()
    {
        if(insurance == 0)//set
            insurance = bet / 2.;
        else//reset
            insurance = 0;
    }
    
    /**
     * Returns the current insurance
     * @return double insurance
     */
    public double getInsurance()
    {
        return insurance;
    }
    
    /**
     * Returns the player's hand
     * @return Hand hand
     */
    public Hand getHand()
    {
        return hand;
    }
    
    /**
     * Return the player's name
     * @return String NAME
     */
    public String getName()
    {
        return NAME;
    }
    
    /**
     * Changes the amount of money
     * @param double Change in money
     */
    public void setMoney(double change)
    {
        money += change;
    }
    
    /**
     * Returns the player's bankroll
     * @return double money
     */
    public double getMoney()
    {
        return money;
    }
    
    /**
     * Returns the player's current bet
     * @return double bet
     */
    public double getBet()
    {
        return bet;
    }
    
    /**
     * String representation of the Player
     * @return String representation
     */
    public String toString()
    {
        return "Name: " + getName() + "\nBank: $" + getMoney() + "\nInsurance: $" + getInsurance();
    }
}
        