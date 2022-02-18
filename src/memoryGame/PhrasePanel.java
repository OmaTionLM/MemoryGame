package memoryGame;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for ...
 * Alan Valderrama - 2042836 - alan.valderrama@correounivalle.edu.co
 * Jeison Perea - 2077250 - jeison.perea@correounivalle.edu.co
 * @version v.1.0.0 date:17/02/2022
 */
public class PhrasePanel extends JPanel
{
    /*
     * Attribute
     */
    private String word, logo;

    /*
     * Constructor
     */
    public PhrasePanel()
    {
        setBackground(Color.PINK);
        word="";
        logo="I KNOW THAT WORD";
    }

    /*
     * Method for set the word
     */
    public void setWord(String word)
    {
        this.word = word;
        repaint();
    }

    /*
     * Method for set the logo
     */
    public void setLogo(String logo)
    {
        this.logo=logo;
        repaint();
    }

    /*
     * Paint the phrase panel
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillOval(175, 70, 370,370);

        g.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        g.setColor(Color.black);
        g.drawString(logo, 187,265);

        g.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        g.setColor(Color.black);
        g.drawString(word, 260,270);
    }
}
