import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
/**
 * @author Leigh Rubin
 * StartMenu.java
 * Blueprint for a StartMenu
 */
public class StartMenu extends JFrame
{
    //outline of class found in series starting with https://www.youtube.com/watch?v=lE18VALSCAA      
    private Color defaultColor;
    private Color pressedColor = new Color(0,128,255);

    private int screenWidth = 1280;
    private int screenHeight = 1000;

    private int buttonWidth = 200;
    private int buttonHeight = 100;

    private int textFieldWidth = 200;
    private int textFieldHeight = 40;

    private JButton twoDecks;
    private JButton fourDecks;
    private JButton sixDecks;
    private JTextField name;
    private JTextField bank;
    private JButton begin;
    private JLabel logo;

    private int decks = 0;
    private String playerName = null;
    private double startingBank = 0;

    /**
     * Creates a new Start Menu
     */
    public StartMenu()
    {
        //many questions answered on http://stackoverflow.com/
        addButtons();
        addActions();

        getContentPane().setLayout(null);

        logo.setBounds(screenWidth / 2 - 202, 20 , 405, 246);
        twoDecks.setBounds((screenWidth - buttonWidth) / 4, 30 + 346, buttonWidth, buttonHeight);
        fourDecks.setBounds((screenWidth - buttonWidth) / 4 * 2, 30 + 346, buttonWidth, buttonHeight);
        sixDecks.setBounds((screenWidth - buttonWidth) / 4 * 3, 30 + 346, buttonWidth, buttonHeight);
        name.setBounds((screenWidth - buttonWidth) / 2, 506, textFieldWidth, textFieldHeight);
        bank.setBounds((screenWidth - buttonWidth) / 2, 200 + 360, textFieldWidth, textFieldHeight);
        begin.setBounds((screenWidth - buttonWidth) / 2, 400 + 246, buttonWidth, buttonHeight);

        getContentPane().add(logo);
        getContentPane().add(twoDecks);
        getContentPane().add(fourDecks);
        getContentPane().add(sixDecks);
        getContentPane().add(name);
        getContentPane().add(bank);
        getContentPane().add(begin);

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
        logo = new JLabel(new ImageIcon("logo.gif"));
        twoDecks = new JButton("Two(2) Decks");
        twoDecks.setFont(new Font("Algerian", Font.PLAIN, 20));
        fourDecks = new JButton("Four(4) Decks");
        fourDecks.setFont(new Font("Algerian", Font.PLAIN, 20));
        sixDecks = new JButton("Six(6) Decks");
        sixDecks.setFont(new Font("Algerian", Font.PLAIN, 20));
        name = new JTextField("NAME");
        name.setFont(new Font("TimesRoman-Bold", Font.PLAIN, 15));
        name.setHorizontalAlignment(JTextField.CENTER);
        name.selectAll();
        bank = new JTextField("STARTING BANKROLL");
        bank.setFont(new Font("TimesRoman-Bold", Font.PLAIN, 15));
        bank.setHorizontalAlignment(JTextField.CENTER);
        begin = new JButton("Begin Game");
        begin.setFont(new Font("Algerian", Font.PLAIN, 20));
    }

    /**
     * Associates actions with JButtons
     */
    private void addActions()
    {
        twoDecks.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    decks = 2;
                    twoDecks.setBackground(pressedColor);
                    fourDecks.setBackground(new JButton().getBackground());
                    sixDecks.setBackground(new JButton().getBackground());
                }
            });

        fourDecks.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    decks = 4;
                    fourDecks.setBackground(pressedColor);
                    twoDecks.setBackground(new JButton().getBackground());
                    sixDecks.setBackground(new JButton().getBackground()); 
                }
            });

        sixDecks.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    decks = 6;
                    sixDecks.setBackground(pressedColor);
                    fourDecks.setBackground(new JButton().getBackground());
                    twoDecks.setBackground(new JButton().getBackground());
                }
            });

        begin.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    //http://stackoverflow.com/questions/3133770/how-to-find-out-if-the-value-contained-in-a-string-is-double-or-not
                    boolean isDouble = false;
                    try {
                        Double.parseDouble(bank.getText());
                        isDouble = true;
                    } catch (NumberFormatException ex) {
                        isDouble = false;
                    }
                    if(isDouble && Double.parseDouble(bank.getText()) < 1E7 && decks != 0 && bank.getText() != null && name.getText() != null && Double.parseDouble(bank.getText()) > 0)
                    {
                        DecimalFormat d = new DecimalFormat("#.##");
                        playerName = name.getText();
                        try{
                            String x = d.format(Double.parseDouble(bank.getText()));
                            startingBank = Double.parseDouble(x);
                        }
                        catch(Exception ex){}
                        dispose();
                        try{
                            GameGUI g = new GameGUI(playerName, startingBank, decks);
                        }
                        catch(Exception ex){}
                    }
                    try{
                        if(Double.parseDouble(bank.getText()) >= 1E7)
                        {
                            bank.setText("Limit = $9,999,999.00");
                            repaint();
                        }
                    }
                    catch(Exception ex){}
                }
            });
    }
}
