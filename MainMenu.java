import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author Leigh Rubin
 * MainMenu.java
 * Blueprint for a MainMenu
 */
public class MainMenu extends JFrame
{
    //outline of class found in series starting with https://www.youtube.com/watch?v=lE18VALSCAA    
    private int screenWidth = 1280;
    private int screenHeight = 1000;

    private int buttonWidth = 400;
    private int buttonHeight = 200;

    private JButton Play;
    private JButton Quit;
    private JLabel logo;
    
    /**
     * Creates a new Main Menu
     */
    public MainMenu()
    {
        //many questions answered on http://stackoverflow.com/
        addButtons();
        addActions();

        getContentPane().setLayout(null);
        
        logo.setBounds(screenWidth / 2 - 202, 20 , 405, 246);
        Play.setBounds((screenWidth - buttonWidth) / 2, 45 + 300, buttonWidth, buttonHeight);
        Quit.setBounds((screenWidth - buttonWidth) / 2, 630, buttonWidth, buttonHeight);
        
        getContentPane().add(logo);
        getContentPane().add(Play);
        getContentPane().add(Quit);

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
     * Adds JButton to JFrame
     */
    private void addButtons()
    {
        logo = new JLabel(new ImageIcon("logo.gif"));
        Play = new JButton("Play");
        Play.setFont(new Font("Algerian", Font.PLAIN, 40));
        Quit = new JButton("Quit");
        Quit.setFont(new Font("Algerian", Font.PLAIN, 40));
    }

    /**
     * Associates actions with JButtons
     */
    private void addActions()
    {
        Play.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    dispose();
                    
                    new StartMenu();
                }
            });

        Quit.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(0);
                }
            });
    }
}
