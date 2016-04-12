import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Dimension;
/**
 * @author Leigh Rubin
 * Assignment #5: HandTester.java
 * Tests the Hand class
 */
public class HandTester
{
    public static void main()
    {
        Shoe s = new Shoe(4);
        s.shuffle();
        Hand h = new Hand();
        System.out.println("Initial hand:\n" + h);

        
        Card c1 = s.dealCard();
        h.addCard(c1);

        Card c2 = s.dealCard();
        h.addCard(c2);

        System.out.println("\nDealt hand:\n" + h);
        System.out.println("\tBlackjack = " + h.blackjack());
        System.out.println("\tFive Card Charlie = " + h.fiveCardCharlie());

        Card c3 = s.dealCard();
        h.addCard(c3);
        System.out.println("\nHand after hit:\n" + h);
        System.out.println("\tBusted = " + h.busted());
        h.handOver();
        System.out.println("\nHand after ending hand:\n" + h);
        
        h.addCard(new Card(1,1));
        h.addCard(new Card(2,2));
        h.addCard(new Card(1,2));
        h.addCard(new Card(1,3));
        h.addCard(new Card(8,2));
        
        System.out.println("\n" + h);
        System.out.println("\tBusted = " + h.busted());
        System.out.println("\tFive Card Charlie = " + h.fiveCardCharlie());
    }
}
/*
Initial hand:
Hand: []
Value: 0

Dealt hand:
Hand: [Ace of Hearts (11), Jack of Clubs (10)]
Value: 21
Blackjack = true
Five Card Charlie = false

Hand after hit:
Hand: [Ace of Hearts (1), Jack of Clubs (10), Five of Hearts (5)]
Value: 16
Busted = false

Hand after ending hand:
Hand: []
Value: 0

Initial hand:
Hand: []
Value: 0

Dealt hand:
Hand: [Ace of Diamonds (11), Six of Hearts (6)]
Value: 17
Blackjack = false
Five Card Charlie = false

Hand after hit:
Hand: [Ace of Diamonds (1), Six of Hearts (6), Six of Spades (6)]
Value: 13
Busted = false

Hand after ending hand:
Hand: []
Value: 0
 */