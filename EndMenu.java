import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import javax.sound.sampled.*;
import java.net.URL;
/**
 * @author Leigh Rubin
 * EndMenu.java
 * Blueprint for a EndMenu
 */
public class EndMenu extends JFrame
{
    //outline of class found in series starting with https://www.youtube.com/watch?v=lE18VALSCAA    
    private int screenWidth = 1280;
    private int screenHeight = 1000;

    private int buttonWidth = 347;
    private int buttonHeight = 145;

    private JLabel fireworks;
    private JLabel logo;
    private JLabel name;
    private JLabel money;
    private JLabel cards;
    private JLabel cards2;
    private JLabel cards3;
    private JLabel cards4;
    private JButton newGame;

    private String player = "";
    private double cash = 0;

    private static Clip clip;
    /**
     * Creates a new End Menu with a name, bank, and difference in the starting bank from the current bank
     * @param String name
     * @param double bank
     * @param double difference
     */
    public EndMenu(String playerName, double dollars, double difference)
    {
        //many questions answered on http://stackoverflow.com/
        player = playerName;
        cash = dollars;

        addButtons();
        addActions();

        getContentPane().setLayout(null);

        fireworks.setBounds(JLabel.CENTER, JLabel.CENTER, 1280, 1000);
        logo.setBounds(screenWidth / 2 - 202, 20 , 405, 246);
        cards.setBounds(65, 60, 226, 158);
        cards2.setBounds(950, 60, 226, 158);
        cards3.setBounds(65, 600, 226, 158);
        cards4.setBounds(950, 600, 226, 158);
        name.setBounds(0, 350, 1280, 70);
        name.setHorizontalAlignment(JLabel.CENTER);
        money.setBounds(0, 450, 1280, 70);
        money.setHorizontalAlignment(JLabel.CENTER);
        newGame.setBounds((screenWidth - buttonWidth) / 2, 625, buttonWidth, buttonHeight);
        if(player.equalsIgnoreCase("Tiveron") || player.equalsIgnoreCase("Derrick"))
            name.setText("APCS ROCKS!");
        else
            name.setText(player + ",");
        getContentPane().add(logo);
        getContentPane().add(cards);
        getContentPane().add(cards2);
        getContentPane().add(cards3);
        getContentPane().add(cards4);
        getContentPane().add(name);
        getContentPane().add(money);
        getContentPane().add(newGame);
        if(difference >= 0 || player.equalsIgnoreCase("Tiveron") || player.equalsIgnoreCase("Derrick"))
        {
            getContentPane().add(fireworks);
            loopSound("fireworks.wav");
        }

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
        fireworks = new JLabel(new ImageIcon("fireworks.gif"));
        logo = new JLabel(new ImageIcon("logo.gif"));
        cards = new JLabel(new ImageIcon("cards.gif"));
        cards2 = new JLabel(new ImageIcon("cards.gif"));
        cards3 = new JLabel(new ImageIcon("cards.gif"));
        cards4 = new JLabel(new ImageIcon("cards.gif"));
        name = new JLabel("");
        name.setFont(new Font("Algerian", Font.PLAIN, 70));
        name.setForeground(Color.white);
        if(Double.toString(cash).substring(Double.toString(cash).indexOf(".")).length() < 3)
            money = new JLabel("You ended with $" + Double.toString(cash) + "0!!");
        else
            money = new JLabel("You ended with $" + Double.toString(cash) + "!!");
        money.setFont(new Font("Algerian", Font.PLAIN, 70));
        money.setForeground(Color.white);
        newGame = new JButton("New Game");
        newGame.setHorizontalTextPosition(JButton.CENTER);
        newGame.setVerticalTextPosition(JButton.CENTER);
        newGame.setFont(new Font("Algerian", Font.PLAIN, 50));
    }
    
    /**
     * Associates actions with JButtons
     */
    private void addActions()
    {
        newGame.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    dispose();
                    try{
                        clip.stop();
                    }
                    catch(Exception ex){}

                    new StartMenu();
                }
            });
    }
    
    /**
     * Plays a sound in a loop
     * @param String Name of the sound
     */
    public static void loopSound(String sound)
    {
        if(GameGUI.soundOn)
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
}