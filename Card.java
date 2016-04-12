//http://docs.oracle.com/javase/7/docs/api/
import javax.swing.JLabel;
import javax.swing.ImageIcon;
/**
 * @author Leigh Rubin
 * Assignment #2: Card.java
 * Blueprint for a Card object
 */
public class Card
{
    private final int RANK;//Rank 0-12, (King, Ace, 2, 3, ... 10, Jack, Queen)
    private final int SUIT;//Suit 0-3 (Clubs, Diamonds, Hearts, Spades)
    private int value;
    private JLabel img;
    
    /**
     * Constructs a card with a Rank, Suit, and assigns an Image and Value to the card
     * @param int Rank
     * @param int Suit
     */
    public Card(int r, int s)
    {
        String x = "";
        String y = "";
        RANK = r;
        SUIT = s;
        value = RANK;
        switch(value)
        {
            case 0: value = 10;
                    x = "k";
                    break;
            case 11:value = 10;
                    x = "j";
                    break;
            case 12:value = 10;
                    x = "q";
                    break;
            case 1: value = 11;
                    x = "1";
                    break;
        }
        if(x.equals(""))
            x = Integer.toString(RANK);
        y = getSuit().substring(0,1);
        //https://www.youtube.com/watch?v=Zh_CJxYi0wU
        ImageIcon icon = new ImageIcon(y + x + ".gif");
        img = new JLabel(icon);
    }
    
    /**
     * Returns the Rank of the Card
     * @return String the Rank
     */
    public String getRank()
    {
        String r = "";
        switch(RANK)
        {
            case 0: r = "King";
                    break;
            case 1: r = "Ace";
                    break;
            case 2: r = "Two";
                    break;
            case 3: r = "Three";
                    break;
            case 4: r = "Four";
                    break;
            case 5: r = "Five";
                    break;
            case 6: r = "Six";
                    break;
            case 7: r = "Seven";
                    break;
            case 8: r = "Eight";
                    break;
            case 9: r = "Nine";
                    break;
            case 10: r = "Ten";
                    break;
            case 11: r = "Jack";
                    break;
            case 12: r = "Queen";
                    break;
        }
        return r;
    }
    
    /**
     * Returns the Suit of the Card
     * @return String the Suit
     */
    public String getSuit()
    {
        String s = "";
        switch(SUIT)
        {
            case 0: s = "Spades";
                    break;
            case 1: s = "Diamonds";
                    break;
            case 2: s = "Clubs";
                    break;
            case 3: s = "Hearts";
                    break;
        }
        return s;
    }
    
    /**
     * Returns the value of the Card
     * @return int The value
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * Returns the Image associated with the Card as a JLabel
     * @return JLabel Image of the Card
     */
    public JLabel getImage()
    {
        return img;
    }
    
    /**
     * Precondition: Card is an Ace with a value of 11
     * Changes the value of a Card
     * @param int The new value
     */
    public void setValue(int v)
    {
        value = v;//Method only to be used for Aces
    }
    
    /**
     * String representation of the Card
     * @return String representation
     */
    public String toString()
    {
        return getRank() + " of " + getSuit() + " (" + getValue() + ")";
    }
}