import java.util.ArrayList;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Dimension;
/**
 * @author Leigh Rubin
 * Assignment #4: ShoeTester.java
 * Tests the Shoe class
 */
public class ShoeTester
{
    public static void main()
    {
        Shoe s = new Shoe(2);
        
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

        int screenHeight = 1280;
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        for(Card c: s.getShoe())
            labels.add(c.getImage());
        int x = 80;
        int y = 300;
        for(int i = 0; i < 2; i ++)
        {
            for(int j = 0; j < 52; j++)
            {
                JLabel q = labels.get(i*52 + j);
                q.setLocation(x,y);
                q.setSize(71,96);
                frame.getContentPane().add(q);

                x += 20;
                y ++;
            }
            y = 420;
            x = 80;
        }
        
        System.out.println(s);
        print(s);
        s.shuffle();
        System.out.println("\nAfter shuffling");
        print(s);
        for(int i = 0; i < 45; i++)
            s.dealCard();
        System.out.println("\nAfter dealing 45 cards");
        System.out.println(s);
        print(s);
        System.out.println("\nAfter reshuffling");
        s.shuffle();
        print(s);
    }

    /**
     * Prints the contents of a Shoe in a table
     * @param Shoe The shoe
     */
    public static void print(Shoe s)
    {
        try
        {
            for(int i = 0; i < s.getNumCards() / 4; i++)
            {
                for(int j = 0; j < 4; j++)
                    System.out.print(s.getShoe().get(i*4+j) + "\t");
                System.out.println();
            }
        }
        catch(Exception e)
        {
        }
    }
}
/*
The shoe contains 104 cards.
King of Clubs (10)  King of Diamonds (10)   King of Hearts (10) King of Spades (10) 
Ace of Clubs (11)   Ace of Diamonds (11)    Ace of Hearts (11)  Ace of Spades (11)  
Two of Clubs (2)    Two of Diamonds (2) Two of Hearts (2)   Two of Spades (2)   
Three of Clubs (3)  Three of Diamonds (3)   Three of Hearts (3) Three of Spades (3) 
Four of Clubs (4)   Four of Diamonds (4)    Four of Hearts (4)  Four of Spades (4)  
Five of Clubs (5)   Five of Diamonds (5)    Five of Hearts (5)  Five of Spades (5)  
Six of Clubs (6)    Six of Diamonds (6) Six of Hearts (6)   Six of Spades (6)   
Seven of Clubs (7)  Seven of Diamonds (7)   Seven of Hearts (7) Seven of Spades (7) 
Eight of Clubs (8)  Eight of Diamonds (8)   Eight of Hearts (8) Eight of Spades (8) 
Nine of Clubs (9)   Nine of Diamonds (9)    Nine of Hearts (9)  Nine of Spades (9)  
Ten of Clubs (10)   Ten of Diamonds (10)    Ten of Hearts (10)  Ten of Spades (10)  
Jack of Clubs (10)  Jack of Diamonds (10)   Jack of Hearts (10) Jack of Spades (10) 
Queen of Clubs (10) Queen of Diamonds (10)  Queen of Hearts (10)    Queen of Spades (10)    
King of Clubs (10)  King of Diamonds (10)   King of Hearts (10) King of Spades (10) 
Ace of Clubs (11)   Ace of Diamonds (11)    Ace of Hearts (11)  Ace of Spades (11)  
Two of Clubs (2)    Two of Diamonds (2) Two of Hearts (2)   Two of Spades (2)   
Three of Clubs (3)  Three of Diamonds (3)   Three of Hearts (3) Three of Spades (3) 
Four of Clubs (4)   Four of Diamonds (4)    Four of Hearts (4)  Four of Spades (4)  
Five of Clubs (5)   Five of Diamonds (5)    Five of Hearts (5)  Five of Spades (5)  
Six of Clubs (6)    Six of Diamonds (6) Six of Hearts (6)   Six of Spades (6)   
Seven of Clubs (7)  Seven of Diamonds (7)   Seven of Hearts (7) Seven of Spades (7) 
Eight of Clubs (8)  Eight of Diamonds (8)   Eight of Hearts (8) Eight of Spades (8) 
Nine of Clubs (9)   Nine of Diamonds (9)    Nine of Hearts (9)  Nine of Spades (9)  
Ten of Clubs (10)   Ten of Diamonds (10)    Ten of Hearts (10)  Ten of Spades (10)  
Jack of Clubs (10)  Jack of Diamonds (10)   Jack of Hearts (10) Jack of Spades (10) 
Queen of Clubs (10) Queen of Diamonds (10)  Queen of Hearts (10)    Queen of Spades (10)    

After shuffling
Three of Clubs (3)  Three of Clubs (3)  Seven of Clubs (7)  Two of Clubs (2)    
Ten of Clubs (10)   Seven of Diamonds (7)   Ten of Spades (10)  Eight of Hearts (8) 
Nine of Clubs (9)   Ace of Clubs (11)   Four of Clubs (4)   Five of Clubs (5)   
Six of Clubs (6)    Six of Diamonds (6) Five of Hearts (5)  Ten of Hearts (10)  
Five of Spades (5)  Ten of Diamonds (10)    Six of Hearts (6)   Five of Diamonds (5)    
Jack of Clubs (10)  Nine of Diamonds (9)    King of Spades (10) Jack of Diamonds (10)   
Eight of Clubs (8)  Ace of Spades (11)  Queen of Spades (10)    King of Hearts (10) 
Five of Spades (5)  Eight of Clubs (8)  Nine of Spades (9)  Three of Diamonds (3)   
Seven of Spades (7) Jack of Clubs (10)  Nine of Clubs (9)   Jack of Hearts (10) 
Queen of Diamonds (10)  Six of Spades (6)   King of Spades (10) Four of Diamonds (4)    
Ten of Spades (10)  King of Diamonds (10)   Seven of Clubs (7)  Jack of Spades (10) 
Nine of Hearts (9)  Six of Clubs (6)    Queen of Spades (10)    Seven of Spades (7) 
Two of Diamonds (2) Queen of Clubs (10) Jack of Spades (10) Three of Spades (3) 
Two of Diamonds (2) Ace of Hearts (11)  Ace of Spades (11)  Four of Hearts (4)  
Three of Hearts (3) Jack of Hearts (10) King of Clubs (10)  Four of Spades (4)  
Eight of Diamonds (8)   Six of Diamonds (6) Three of Spades (3) King of Diamonds (10)   
Four of Hearts (4)  Queen of Diamonds (10)  Two of Hearts (2)   Queen of Clubs (10) 
Queen of Hearts (10)    Ten of Hearts (10)  Two of Spades (2)   Seven of Diamonds (7)   
Nine of Diamonds (9)    Two of Hearts (2)   Four of Diamonds (4)    Seven of Hearts (7) 
Five of Diamonds (5)    Four of Clubs (4)   Nine of Hearts (9)  Eight of Hearts (8) 
Five of Hearts (5)  Eight of Diamonds (8)   Three of Diamonds (3)   Two of Clubs (2)    
Jack of Diamonds (10)   Six of Spades (6)   Five of Clubs (5)   Seven of Hearts (7) 
Ten of Diamonds (10)    Four of Spades (4)  Ace of Hearts (11)  Queen of Hearts (10)    
Three of Hearts (3) Ace of Diamonds (11)    Eight of Spades (8) King of Clubs (10)  
Eight of Spades (8) Two of Spades (2)   King of Hearts (10) Six of Hearts (6)   
Ace of Diamonds (11)    Ace of Clubs (11)   Ten of Clubs (10)   Nine of Spades (9)  

After dealing 45 cards
The shoe contains 59 cards.
Six of Clubs (6)    Queen of Spades (10)    Seven of Spades (7) Two of Diamonds (2) 
Queen of Clubs (10) Jack of Spades (10) Three of Spades (3) Two of Diamonds (2) 
Ace of Hearts (11)  Ace of Spades (11)  Four of Hearts (4)  Three of Hearts (3) 
Jack of Hearts (10) King of Clubs (10)  Four of Spades (4)  Eight of Diamonds (8)   
Six of Diamonds (6) Three of Spades (3) King of Diamonds (10)   Four of Hearts (4)  
Queen of Diamonds (10)  Two of Hearts (2)   Queen of Clubs (10) Queen of Hearts (10)    
Ten of Hearts (10)  Two of Spades (2)   Seven of Diamonds (7)   Nine of Diamonds (9)    
Two of Hearts (2)   Four of Diamonds (4)    Seven of Hearts (7) Five of Diamonds (5)    
Four of Clubs (4)   Nine of Hearts (9)  Eight of Hearts (8) Five of Hearts (5)  
Eight of Diamonds (8)   Three of Diamonds (3)   Two of Clubs (2)    Jack of Diamonds (10)   
Six of Spades (6)   Five of Clubs (5)   Seven of Hearts (7) Ten of Diamonds (10)    
Four of Spades (4)  Ace of Hearts (11)  Queen of Hearts (10)    Three of Hearts (3) 
Ace of Diamonds (11)    Eight of Spades (8) King of Clubs (10)  Eight of Spades (8) 
Two of Spades (2)   King of Hearts (10) Six of Hearts (6)   Ace of Diamonds (11)


After reshuffling
Two of Hearts (2)	Two of Spades (2)	Six of Spades (6)	Seven of Clubs (7)	
Four of Hearts (4)	Five of Diamonds (5)	Eight of Diamonds (8)	Ten of Diamonds (10)	
Ace of Spades (11)	Ace of Clubs (11)	Four of Diamonds (4)	Three of Hearts (3)	
Eight of Hearts (8)	King of Hearts (10)	Jack of Diamonds (10)	King of Clubs (10)	
Queen of Hearts (10)	King of Spades (10)	Six of Clubs (6)	Seven of Hearts (7)	
Two of Diamonds (2)	Seven of Diamonds (7)	Ten of Clubs (10)	Ace of Diamonds (11)	
Ace of Hearts (11)	Five of Diamonds (5)	Queen of Spades (10)	Five of Hearts (5)	
Eight of Clubs (8)	Six of Hearts (6)	Queen of Spades (10)	Jack of Clubs (10)	
Three of Clubs (3)	Nine of Diamonds (9)	Jack of Clubs (10)	Queen of Clubs (10)	
Three of Hearts (3)	Nine of Hearts (9)	Seven of Spades (7)	Four of Spades (4)	
Jack of Diamonds (10)	Five of Hearts (5)	Nine of Diamonds (9)	Queen of Diamonds (10)	
Ten of Spades (10)	Seven of Clubs (7)	Four of Diamonds (4)	Three of Diamonds (3)	
King of Diamonds (10)	Jack of Spades (10)	Ten of Hearts (10)	Four of Clubs (4)	
Three of Diamonds (3)	King of Diamonds (10)	Queen of Hearts (10)	Jack of Hearts (10)	
King of Hearts (10)	Seven of Hearts (7)	Ace of Hearts (11)	Jack of Spades (10)	
Eight of Hearts (8)	Ten of Hearts (10)	Eight of Spades (8)	Six of Spades (6)	
Eight of Clubs (8)	Two of Clubs (2)	Five of Clubs (5)	Five of Spades (5)	
Ten of Spades (10)	Four of Hearts (4)	Two of Clubs (2)	Seven of Spades (7)	
Ace of Diamonds (11)	Six of Diamonds (6)	Nine of Clubs (9)	Ace of Clubs (11)	
Seven of Diamonds (7)	Nine of Spades (9)	Ten of Diamonds (10)	Four of Spades (4)	
Queen of Diamonds (10)	King of Spades (10)	Two of Diamonds (2)	Six of Hearts (6)	
Six of Diamonds (6)	Nine of Clubs (9)	Six of Clubs (6)	Five of Spades (5)	
Eight of Spades (8)	Three of Spades (3)	Two of Hearts (2)	Three of Clubs (3)	
King of Clubs (10)	Nine of Spades (9)	Four of Clubs (4)	Ten of Clubs (10)	
Two of Spades (2)	Nine of Hearts (9)	Three of Spades (3)	Ace of Spades (11)	
Jack of Hearts (10)	Queen of Clubs (10)	Five of Clubs (5)	Eight of Diamonds (8)	
    
 */