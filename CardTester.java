import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Dimension;
/**
 * @author Leigh Rubin
 * Assignment #2: CardTester.java
 * Tests the Card class
 */
public class CardTester
{
    public static void main()
    {
        
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
        
        Card a = new Card(1, 0);
        System.out.println("Ace as an 11");
        System.out.println(a);
        a.setValue(1);
        JLabel ace = a.getImage();
        ace.setLocation(320,460);
        ace.setSize(71, 96);
        frame.getContentPane().add(ace);
        System.out.println("\nAce as a 1");
        System.out.println(a);
        
        Card j = new Card(11, 3);
        System.out.println("\nA Jack");
        System.out.println(j);
        JLabel jack = j.getImage();
        jack.setLocation(640,460);
        jack.setSize(71, 96);
        frame.getContentPane().add(jack);
        
        Card f = new Card(4, 2);
        System.out.println("\nA Four");
        System.out.println(f);
        JLabel four = f.getImage();
        four.setLocation(960,460);
        four.setSize(71, 96);
        frame.getContentPane().add(four);
    }
}
/*
Ace as an 11
Ace of Clubs (11)

Ace as a 1
Ace of Clubs (1)

A Jack
Jack of Spades (10)

A Four
Four of Hearts (4)
 */