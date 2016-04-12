import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.ArrayList;
/**
 * @author Leigh Rubin
 * Assignment #3: DeckTester.java
 * Tests the Deck class
 */
public class DeckTester
{
    public static void main()
    {
        Deck d = new Deck();
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        System.out.println(d);
        for(int i = 0; i < 13; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                System.out.print(d.getCards().get(i*4+j) + "\t");
                labels.add(d.getCards().get(i*4+j).getImage());
            }
            System.out.println();
        }
        
        JFrame frame = new JFrame("Blackjack");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0, 120, 0));
        Dimension gameSize = new Dimension(1280, 1000);
        
        frame.setMinimumSize(gameSize);
        frame.setPreferredSize(gameSize);
        frame.setMaximumSize(gameSize);
        
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        int x = 80;
        int y = 450;
        for(int i = 0; i < 52; i++)
        {
             JLabel q = labels.get(i);
             q.setLocation(x,y);
             q.setSize(71,96);
             frame.getContentPane().add(q);
             
             x += 20;
             y ++;
        }
    }
}
/*
The deck contains 52 cards.
Ace of Spades (11)	Two of Spades (2)	Three of Spades (3)	Four of Spades (4)	
Five of Spades (5)	Six of Spades (6)	Seven of Spades (7)	Eight of Spades (8)	
Nine of Spades (9)	Ten of Spades (10)	Jack of Spades (10)	Queen of Spades (10)	
King of Spades (10)	Ace of Diamonds (11)	Two of Diamonds (2)	Three of Diamonds (3)	
Four of Diamonds (4)	Five of Diamonds (5)	Six of Diamonds (6)	Seven of Diamonds (7)	
Eight of Diamonds (8)	Nine of Diamonds (9)	Ten of Diamonds (10)	Jack of Diamonds (10)	
Queen of Diamonds (10)	King of Diamonds (10)	Ace of Clubs (11)	Two of Clubs (2)	
Three of Clubs (3)	Four of Clubs (4)	Five of Clubs (5)	Six of Clubs (6)	
Seven of Clubs (7)	Eight of Clubs (8)	Nine of Clubs (9)	Ten of Clubs (10)	
Jack of Clubs (10)	Queen of Clubs (10)	King of Clubs (10)	Ace of Hearts (11)	
Two of Hearts (2)	Three of Hearts (3)	Four of Hearts (4)	Five of Hearts (5)	
Six of Hearts (6)	Seven of Hearts (7)	Eight of Hearts (8)	Nine of Hearts (9)	
Ten of Hearts (10)	Jack of Hearts (10)	Queen of Hearts (10)	King of Hearts (10)	
 */