import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.text.DecimalFormat;
import sun.audio.*;
import java.io.*;
import javax.sound.sampled.*;
import java.net.URL;
/**
 * @author Leigh Rubin
 * GameGUI.java
 * Blueprint for a Blackjack Game
 */
public class GameGUI extends StartMenu
{
    //outline of class found in series starting with https://www.youtube.com/watch?v=lE18VALSCAA 
    private Dealer d;
    private Player p;
    private Shoe s;
    private Hand pH;
    private Hand dH;

    private int increment = 10;

    private int screenWidth = 1280;
    private int screenHeight = 850;

    private int buttonWidth = 213;
    private int buttonHeight = 75;

    private int cardWidth = 71;
    private int cardHeight = 96;

    private JButton cashOut;
    private JButton sound;
    private JButton music;
    private JButton strategy;
    private JButton startHand;
    private JButton hit;
    private JButton stay;
    private JButton doubleDown;
    private JButton purchaseInsurance;
    private JButton incrementBet;
    private JButton decrementBet;

    private JLabel logo;
    private JLabel background;
    private JLabel bet;
    private JLabel down;
    private JLabel result;
    private JLabel currentPlayer;
    private JLabel player;
    private JLabel moneyLeft;
    private JLabel resultBox;
    private JLabel box1;
    private JLabel strategyCard;
    private JLabel suggestion;
    private JLabel bigRect;

    private String outcome = "";
    private double money;
    private String playerName;

    private ArrayList<JLabel> cards;

    private double currentBet = 0;
    private boolean inHand = false;
    private int playerHits = 0;
    private int dealerHits = 0;
    public static boolean soundOn = true;
    private static boolean musicOn = true;
    private double lastBet = 0;

    private double initialBalance = 0;

    private int x;
    private int y;
    DecimalFormat f = new DecimalFormat("0.00");

    private static Clip clip;
    /**
     * Creates a new Game with a player's name, bank, and amount of decks in the shoe
     * @param String name
     * @param double bank
     * @param int decks
     */
    public GameGUI(String name, double bank, int decks)
    {
        //many questions answered on http://stackoverflow.com/

        playerName = name;
        money = bank;

        addButtons();
        addLabels();
        addActions();

        d = new Dealer();
        s = d.getShoe();
        s.setDecks(decks);
        p = new Player(name, bank);
        pH = p.getHand();
        dH = d.getHand();
        cards = new ArrayList<JLabel>();

        money = p.getMoney();
        initialBalance = p.getMoney();

        s.shuffle();

        getContentPane().setLayout(null);

        cashOut.setBounds(0, screenHeight - 100, buttonWidth, buttonHeight / 2);
        cashOut.setEnabled(false);
        startHand.setBounds(0, screenHeight - 64, buttonWidth, buttonHeight / 2);
        startHand.setEnabled(false);
        hit.setBounds(buttonWidth, screenHeight - 100, buttonWidth, buttonHeight);
        stay.setBounds(buttonWidth * 2, screenHeight - 100, buttonWidth, buttonHeight);
        doubleDown.setBounds(buttonWidth * 3, screenHeight - 100, buttonWidth, buttonHeight);
        purchaseInsurance.setBounds(buttonWidth * 4, screenHeight - 100, buttonWidth, buttonHeight);
        incrementBet.setBounds(buttonWidth * 5, screenHeight - 100, buttonWidth, buttonHeight / 3);
        decrementBet.setBounds(buttonWidth * 5, screenHeight - 50, buttonWidth, buttonHeight / 3);
        background.setBounds(0, 0, 1280, 850);
        logo.setBounds(screenWidth / 2 - 202, 5, 405, 246);
        sound.setBounds(5, 80, 30, 30);
        music.setBounds(40, 80, 30, 30);
        suggestion.setBounds(-40, -40, 22, 12);
        strategy.setBounds(75, 83, 250, 24);
        bigRect.setBounds(162, 462, 72, 19);
        strategyCard.setBounds(75, 115, 250, 382);
        bet.setBounds(buttonWidth * 5 + buttonWidth / 2 - 60, screenHeight - 75, buttonWidth, buttonHeight / 3);
        result.setBounds(10, 15, 450, 40);
        resultBox.setBounds(5, 10, 450, 60);
        currentPlayer.setBounds(screenWidth - 300, 17, 336, 205 / 4);
        player.setBounds(screenWidth - 330, 50, 300, 205 / 2);
        moneyLeft.setBounds(screenWidth - 330, 95, 336, 205 / 2);
        box1.setBounds(screenWidth - 350, 10, 336, 205);

        //background: https://www.youtube.com/watch?v=IRYSm0O8MyE
        setContentPane(background);
        getContentPane().add(cashOut);
        getContentPane().add(startHand);
        getContentPane().add(hit);
        getContentPane().add(stay);
        getContentPane().add(doubleDown);
        getContentPane().add(purchaseInsurance);
        getContentPane().add(incrementBet);
        getContentPane().add(decrementBet);
        getContentPane().add(logo);
        getContentPane().add(sound);
        getContentPane().add(music);
        getContentPane().add(strategy);
        getContentPane().add(bet);
        getContentPane().add(result);
        getContentPane().add(resultBox);
        getContentPane().add(currentPlayer);
        getContentPane().add(player);
        getContentPane().add(moneyLeft);
        getContentPane().add(box1);
        getContentPane().add(suggestion);
        getContentPane().add(bigRect);
        getContentPane().add(strategyCard);

        if(p.getMoney() >= 100000)
            increment = 10000;
        else if(p.getMoney() >= 50000)
            increment = 5000;
        else if(p.getMoney() >= 10000)
            increment = 1000;
        else if(p.getMoney() >= 5000)
            increment = 500;
        else if(p.getMoney() >= 1000)
            increment = 100;
        else if(p.getMoney() >= 500)
            increment = 50;
        else if(p.getMoney() < 500)
            increment = 10;
        stay.doClick();
        startHand.doClick();

        playSound("shuffle.wav");

        pack();
        setVisible(true);
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0, 120, 0));
        setTitle("BlackJack");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    /**
     * Add JButtons to JFrame
     */
    private void addButtons()
    {
        loopSound("backgroundMusic.wav");
        cashOut = new JButton("Cash Out");
        sound = new JButton(new ImageIcon("soundOn.gif"));
        music = new JButton(new ImageIcon("musicOn.gif"));
        strategy = new JButton("Show Strategy Card");
        startHand = new JButton("Next Hand");
        hit = new JButton("Hit");
        stay = new JButton("Stay");
        doubleDown = new JButton("Double Down");
        purchaseInsurance = new JButton("Purchase Insurance");
        incrementBet = new JButton("Increment Bet");
        decrementBet = new JButton("Decrement Bet");
    }

    /**
     * Adds JLabel to JFrame
     */
    private void addLabels()
    {
        logo = new JLabel(new ImageIcon("logo.gif"));
        background = new JLabel(new ImageIcon("background.gif"));
        if(currentBet < 10000000)
            bet = new JLabel("$" + Double.toString(currentBet) + "0");
        else
            bet = new JLabel("$" + Double.toString(currentBet)); 
        bet.setFont(new Font("Algerian", Font.PLAIN, 25));
        result = new JLabel("Result: \n" + outcome);
        result.setFont(new Font("Algerian", Font.PLAIN, 15));
        resultBox = new JLabel(new ImageIcon("resultBox1.gif"));
        currentPlayer = new JLabel("Current Player");
        currentPlayer.setFont(new Font("Algerian", Font.PLAIN, 25));
        player = new JLabel("Name: " + playerName);
        player.setFont(new Font("Algerian", Font.PLAIN, 30));
        moneyLeft = new JLabel("");
        String x = Double.toString(money);
        if(money >= 1E7)
            moneyLeft.setText("Bank = $" + x);
        else
            moneyLeft.setText("Bank = $" + x + "0");
        moneyLeft.setFont(new Font("Algerian", Font.PLAIN, 30));
        box1 = new JLabel(new ImageIcon("box1.gif"));
        suggestion = new JLabel(new ImageIcon("arrow.gif"));
        suggestion.setVisible(false);
        bigRect = new JLabel(new ImageIcon("18+.gif"));
        bigRect.setVisible(false);
        strategyCard = new JLabel(new ImageIcon("strategy.gif"));
        strategyCard.setVisible(false);
    }

    /**
     * Associates actions with JButtons
     */
    private void addActions()
    {
        cashOut.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(money - initialBalance < 0)
                        playSound("gameOver.wav");
                    try{
                        clip.stop();
                    }
                    catch(Exception ex){}
                    dispose();

                    new EndMenu(playerName, money, money - initialBalance);
                }
            });

        startHand.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(currentBet > 0 && startHand.getText().equals("Start Hand"))
                    {
                        startHand.setEnabled(false);
                        if(p.getMoney() >= 1.5 * currentBet)
                            purchaseInsurance.setEnabled(true);
                        if(p.getMoney() >= 2 * currentBet)
                            doubleDown.setEnabled(true);
                        hit.setEnabled(true);
                        stay.setEnabled(true);
                        cashOut.setEnabled(false);
                        incrementBet.setEnabled(false);
                        decrementBet.setEnabled(false);
                        doubleDown.setEnabled(true);
                        inHand = true;
                        playerHits = 0;
                        dealerHits = 0;

                        p.bet(currentBet * 1.);

                        Card c = s.dealCard();
                        JLabel j = c.getImage();
                        j.setBounds(screenWidth / 2 - cardWidth - 5, screenHeight - 220, cardWidth, cardHeight);
                        add(j);
                        cards.add(j);
                        pH.addCard(c);

                        Card c1 = s.dealCard();
                        ImageIcon i;
                        if(p.getName().equalsIgnoreCase("Tiveron") || p.getName().equalsIgnoreCase("Derrick"))
                            i = new ImageIcon("cardBack.gif");
                        else if(p.getName().equalsIgnoreCase("Svetty") || p.getName().equalsIgnoreCase("Svetlik"))
                            i = new ImageIcon("cardBackS.gif");
                        else
                            i = new ImageIcon("b2fv.gif");
                        down = new JLabel(i);
                        down.setBounds(screenWidth / 2 - cardWidth - 5, 300, cardWidth, cardHeight);
                        add(down);
                        cards.add(down);
                        dH.addCard(c1);

                        Card c2 = s.dealCard();
                        JLabel j2 = c2.getImage();
                        j2.setBounds(screenWidth / 2 + 5, screenHeight - 220, cardWidth, cardHeight);
                        add(j2);
                        cards.add(j2);
                        pH.addCard(c2);

                        Card c3 = s.dealCard();
                        JLabel j3 = c3.getImage();
                        j3.setBounds(screenWidth / 2 + 5, 300, cardWidth, cardHeight);
                        add(j3);
                        cards.add(j3);
                        dH.addCard(c3);
                        repaint();

                        if(pH.blackjack())
                        {    
                            hit.setEnabled(false);
                            doubleDown.setEnabled(false);
                            purchaseInsurance.setEnabled(false);
                            inHand = false;
                            stay.doClick();
                            stay.setEnabled(false);
                        }
                        else if(!(d.getUpCard().getRank().equals("Ace")))
                            purchaseInsurance.setEnabled(false);
                        if(inHand) 
                        {
                            moveBox();
                            suggestion.setBounds(x, y, 70, 36);
                        }
                    }
                    else if(startHand.getText().equals("Next Hand"))
                    {
                        for(int i = cards.size() - 1; i >= 0; i--)
                        {
                            remove(cards.get(i));
                            cards.remove(i);
                        }
                        if(p.getMoney() >= 100000)
                            increment = 10000;
                        else if(p.getMoney() >= 50000)
                            increment = 5000;
                        else if(p.getMoney() >= 10000)
                            increment = 1000;
                        else if(p.getMoney() >= 5000)
                            increment = 500;
                        else if(p.getMoney() >= 1000)
                            increment = 100;
                        else if(p.getMoney() >= 500)
                            increment = 50;
                        else if(p.getMoney() < 500)
                            increment = 10;
                        currentBet = 0;
                        bet.setText("$" + Double.toString(currentBet) + "0");
                        repaint();
                        startHand.setText("Start Hand");
                        cashOut.setEnabled(true);
                        incrementBet.setEnabled(true);
                        decrementBet.setEnabled(true);
                        cashOut.setEnabled(false);
                    }
                    else if(startHand.getText().equals("GAME OVER"))
                    {
                        dispose();

                        new MainMenu();
                    }
                }
            });

        hit.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(dH.blackjack())
                        stay.doClick();
                    else if(inHand && pH.getValue() < 21)
                    {
                        playSound("deal.wav");                     
                        playerHits++;
                        purchaseInsurance.setEnabled(false);
                        doubleDown.setEnabled(false);
                        Card c = s.dealCard();
                        JLabel j = c.getImage();
                        j.setBounds(screenWidth / 2 + (cardWidth * playerHits) + (playerHits * 10) + 6, screenHeight - 220, cardWidth, cardHeight);
                        add(j);
                        cards.add(j);
                        pH.addCard(c);
                        repaint();
                        if(pH.fiveCardCharlie())
                        {
                            inHand = false;
                            playSound("win.wav");
                            outcome = "Five Card Charlie! Payout 1:1";
                            p.setMoney(p.getBet());
                            stay.doClick();
                        }
                        if(pH.getValue() >= 21)
                        {
                            hit.setEnabled(false);
                            if(pH.busted())
                            {
                                inHand = false;
                                outcome = "You busted. You lose your bet.";
                                p.setMoney(-p.getBet());
                                if(p.getMoney() != 0)
                                    playSound("loss.wav");
                            }
                            stay.doClick();
                        }
                        if(inHand) 
                        {
                            moveBox();
                            suggestion.setBounds(x, y, 70, 36);
                        }
                    }
                }
            });

        stay.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(inHand)
                    {
                        remove(down);
                        cards.remove(down);
                        JLabel j1 = dH.getCardInHand(0).getImage();
                        j1.setBounds(screenWidth / 2 - cardWidth - 8, 300, cardWidth, cardHeight);
                        add(j1);
                        cards.add(j1);
                        repaint();
                        while(dH.getValue() < 17)
                        {
                            Card c = d.hit();
                            dealerHits++;
                            JLabel j = c.getImage();
                            j.setBounds(screenWidth / 2 + (cardWidth * dealerHits) + (dealerHits * 10) + 6, 300, cardWidth, cardHeight);
                            add(j);
                            cards.add(j);
                            repaint();
                        }
                        if((dH.busted() && !(pH.busted())) && !(pH.blackjack())){
                            outcome = "Dealer busted. Payout 1:1";
                            p.setMoney(p.getBet());
                            playSound("win.wav");
                        }
                        else if(pH.getValue() > dH.getValue() && !(pH.busted()) && !(pH.blackjack())){
                            outcome = "You win the hand. Payout 1:1";
                            p.setMoney(p.getBet());
                            playSound("win.wav");
                        }
                        else if(pH.getValue() < dH.getValue() && !(dH.busted())){
                            outcome = "Dealer wins the hand. You lose your bet.";
                            p.setMoney(-p.getBet());
                            if(p.getMoney() != 0)
                                playSound("loss.wav");
                        }
                        else if(!(dH.busted()) && pH.getValue() == dH.getValue()){
                            outcome = "Hand is a push. Your bet is returned to you.";
                            playSound("push.wav");
                        }
                    }
                    inHand = false;
                    if(pH.blackjack() && !(dH.blackjack())){
                        outcome = "BLACKJACK! Payout 3:2";
                        p.setMoney(p.getBet() * 1.5);
                        playSound("21.wav");
                    }
                    if(p.getMoney() > 9999999)
                        p.setMoney(9999999-p.getMoney());
                    money = p.getMoney();
                    f.format(money);
                    String x = Double.toString(money);
                    if(x.substring(x.indexOf(".")).length() == 3)
                        moneyLeft.setText("Bank = $" + x);
                    else
                        moneyLeft.setText("Bank = $" + x + "0");
                    result.setText(outcome);
                    repaint();
                    s.reshuffle();
                    p.bet(0);
                    pH.handOver();
                    dH.handOver();
                    if(money == 0)
                    {
                        incrementBet.setEnabled(false);
                        decrementBet.setEnabled(false);
                        cashOut.setEnabled(true);
                        cashOut.doClick();
                    }
                    else
                        startHand.setText("Next Hand");
                    startHand.setEnabled(true);
                    hit.setEnabled(false);
                    stay.setEnabled(false);
                    doubleDown.setEnabled(false);
                    purchaseInsurance.setEnabled(false);
                    cashOut.setEnabled(true);
                }
            });

        doubleDown.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(inHand && pH.getCards().size() == 2 && 2 * currentBet <= p.getMoney())
                    {
                        p.doubleDown();
                        hit.doClick();
                        stay.doClick();
                    }
                }
            });

        purchaseInsurance.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(inHand && d.getUpCard().getRank().equals("Ace") && pH.getCards().size() == 2)
                    {
                        p.insure();
                        purchaseInsurance.setEnabled(false);
                        if(dH.blackjack())
                        {
                            p.setMoney(p.getInsurance());
                            p.setMoney(2 * p.getBet());
                            stay.doClick();
                            outcome = "Dealer has blackjack. You win insurance bet.";
                            inHand = false;
                            hit.setEnabled(false);
                            doubleDown.setEnabled(false);
                            result.setText(outcome);
                            playSound("win.wav");
                        }
                        else
                        {
                            outcome = "Dealer does not have blackjack. You lose insurance.";
                            result.setText(outcome);
                            p.setMoney(-p.getInsurance());
                            bet.setText("$" + Double.toString(currentBet));
                            repaint();
                            playSound("loss.wav");
                        }
                        p.insure();
                    }
                }
            });

        incrementBet.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(p.getMoney() != currentBet)
                    {
                        if(p.getMoney() >= currentBet + increment && !inHand)
                        {
                            lastBet = currentBet;
                            currentBet += increment;
                            f.format(currentBet);
                            String x = Double.toString(currentBet);
                            if(x.substring(x.indexOf(".")).length() == 3)
                                bet.setText("$" + x);
                            else
                                bet.setText("$" + x + "0");
                        }
                        else if(increment + currentBet > p.getMoney() && !inHand)
                        {
                            lastBet = currentBet;
                            currentBet = p.getMoney();
                            f.format(currentBet);
                            String x = Double.toString(currentBet);
                            if(x.substring(x.indexOf(".")).length() == 3)
                                bet.setText("$" + x);
                            else
                                bet.setText("$" + x + "0");
                        }
                    }
                }
            });

        decrementBet.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(currentBet >= increment && !inHand)
                    {
                        if(lastBet < currentBet)
                        {
                            currentBet = lastBet;
                            lastBet = Double.POSITIVE_INFINITY;
                        }
                        else
                            currentBet -= increment;
                        f.format(currentBet);
                        String x = Double.toString(currentBet);
                        if(x.substring(x.indexOf(".")).length() == 3)
                            bet.setText("$" + x);
                        else
                            bet.setText("$" + x + "0");
                    }
                    else if(currentBet - increment < 0 && !inHand)
                    {
                        currentBet = 0;
                        f.format(currentBet);
                        String x = Double.toString(currentBet);
                        if(x.substring(x.indexOf(".")).length() == 3)
                            bet.setText("$" + x);
                        else
                            bet.setText("$" + x + "0");
                    }
                }
            });

        sound.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(soundOn)
                    {
                        soundOn = false;
                        sound.setIcon(new ImageIcon("soundOff.gif"));
                    }
                    else
                    {
                        soundOn = true;
                        sound.setIcon(new ImageIcon("soundOn.gif"));
                    }
                }
            });

        music.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(musicOn)
                    {
                        musicOn = false;
                        music.setIcon(new ImageIcon("musicOff.gif"));
                        clip.stop();
                    }
                    else
                    {
                        musicOn = true;
                        music.setIcon(new ImageIcon("musicOn.gif"));
                        clip.start();
                    }
                }
            });

        strategy.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(strategy.getText().equals("Show Strategy Card"))
                    {
                        strategy.setText("Hide Strategy Card");
                        strategyCard.setVisible(true);
                        suggestion.setVisible(true);
                        if(y == -40)
                            bigRect.setVisible(true);
                    }
                    else
                    {
                        strategy.setText("Show Strategy Card");
                        strategyCard.setVisible(false);
                        suggestion.setVisible(false);
                        bigRect.setVisible(false);
                    }
                }
            });
    }

    //http://www.javaworld.com/article/2077521/learn-java/java-tip-24--how-to-play-audio-in-applications.html
    /**
     * Plays a sound
     * @param String name of sound
     */
    public static void playSound(String sound)
    {
        if(soundOn)
        {
            try{    
                InputStream in = new FileInputStream(sound);
                AudioStream as = new AudioStream(in);
                AudioPlayer.player.start(as);  
            }
            catch(Exception ex){}
        }
    }

    /**
     * Plays a sound in a loop
     * @param String Name of the sound
     */
    public static void loopSound(String sound)
    {
        if(musicOn)
        {
            try{
                AudioInputStream ais = AudioSystem.getAudioInputStream(new File(sound));
                clip = AudioSystem.getClip();
                clip.open(ais);
                clip.loop(Integer.MAX_VALUE);
                clip.start();
            }
            catch(Exception ex){}
        }
    }

    /**
     * Moves arrow to box according to cards delt
     */
    public void moveBox()
    {
        switch(d.getUpCard().getValue())
        {
            case 2:  x = 114;
            break;
            case 3:  x = 134;
            break;
            case 4:  x = 153;
            break;
            case 5:  x = 173;
            break;
            case 6:  x = 193;
            break;
            case 7:  x = 213;
            break;
            case 8:  x = 231;
            break;
            case 9:  x = 251;
            break;
            case 10: x = 270;
            break;
            case 11: x = 289;
            break;
        }
        if(pH.getCardInHand(0).getRank().equals("Ace") || pH.getCardInHand(1).getRank().equals("Ace"))
        {
            switch(pH.getValue())
            {
                case 13: y = 342;
                break;
                case 14: y = 355;
                break;
                case 15: y = 365;
                break;
                case 16: y = 379;
                break;
                case 17: y = 390;
                break;
                case 18: y = 403;
                break;
                case 19: y = 414;
                break;
                case 20: y = 426;
                break;
            }
        }
        else
        {
            switch(pH.getValue())
            {
                case 4:  y = 184;
                break;
                case 5:  y = 184;
                break;
                case 6:  y = 184;
                break;
                case 7:  y = 184;
                break;
                case 8: y = 196;
                break;
                case 9: y = 209;
                break;
                case 10: y = 221;
                break;
                case 11: y = 233;
                break;
                case 12: y = 246;
                break;
                case 13: y = 257;
                break;
                case 14: y = 269;
                break;
                case 15:  y = 281;
                break;
                case 16:  y = 295;
                break;
                case 17:  y = 307;
                break;
                default: y = -40;
            }
        }
        if(y == -40 && strategy.getText().equals("Hide Strategy Card"))
            bigRect.setVisible(true);
        else
            bigRect.setVisible(false);
    }
}