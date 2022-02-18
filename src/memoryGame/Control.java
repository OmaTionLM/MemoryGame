package memoryGame;

import java.util.ArrayList;

/**
 * This class is used for ...
 * Alan Valderrama - 2042836 - alan.valderrama@correounivalle.edu.co
 * Jeison Perea - 2077250 - jeison.perea@correounivalle.edu.co
 * @version v.1.0.0 date:17/02/2022
 */
public class Control
{
    /*
     * Attributes
     */
    private Dictionary words;
    private ArrayList<String> gameWords;

    /*
     * Constructor
     */
    public Control()
    {
        gameWords=new ArrayList<String>();
        words= new Dictionary();
    }

    /*
     * Method that returns the words of te level
     */
    public ArrayList<String> getGameWords(int level)
    {
        gameWords=words.getPhrases(level);
        return gameWords;
    }

    /*
     * Method that returns the size of the good words in the level
     */
    public int goodWordsSize(int level)
    {
        int thelevel=0;
        switch (level)
        {
            case 1: thelevel=10;
                break;

            case 2: thelevel=20;
                break;

            case 3: thelevel=25;
                break;

            case 4: thelevel=30;
                break;

            case 5: thelevel=35;
                break;

            case 6: thelevel=40;
                break;

            case 7: thelevel=50;
                break;

            case 8: thelevel=60;
                break;

            case 9: thelevel=70;
                break;

            case 10: thelevel=100;
                break;
        }
        return thelevel;
    }

    /*
     * Method that returns if the user is winner or loser
     */
    public boolean win(int level, int hits)
    {
        boolean isWinner=false;
        switch (level)
        {
            case 1:
                if(hits>=14)
                {
                    isWinner=true;
                }
                break;
            case 2:
                if(hits>=28)
                {
                    isWinner=true;
                }
                break;
            case 3:
                if(hits>=37)
                {
                    isWinner=true;
                }
                break;
            case 4:
                if(hits>=48)
                {
                    isWinner=true;
                }
                break;
            case 5:
                if(hits>=56)
                {
                    isWinner=true;
                }
                break;
            case 6:
                if(hits>=68)
                {
                    isWinner=true;
                }
                break;
            case 7:
                if(hits>=90)
                {
                    isWinner=true;
                }
                break;
            case 8:
                if(hits>=108)
                {
                    isWinner=true;
                }
                break;
            case 9:
                if(hits>=133)
                {
                    isWinner=true;
                }
                break;
            case 10:
                if(hits>=200)
                {
                    isWinner=true;
                }
                break;
        }
        return isWinner;
    }
}
