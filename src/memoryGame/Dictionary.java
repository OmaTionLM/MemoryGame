package memoryGame;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used for ...
 * Alan Valderrama - 2042836 - alan.valderrama@correounivalle.edu.co
 * Jeison Perea - 2077250 - jeison.perea@correounivalle.edu.co
 * @version v.1.0.0 date:17/02/2022
 */
public class Dictionary
{
    /*
     * Attributes
     */
    private ArrayList<String> words=new ArrayList<String>();
    private FileManager fileManager;

    /*
     * Constructor
     */
    public Dictionary()
    {
        fileManager=new FileManager();
        words=fileManager.readingFileWords();
    }

    /*
     * Method that returns the number of the phrases in the level
     */
    public ArrayList<String> getPhrases(int level)
    {
        ArrayList<String> gamePhrases=new ArrayList<String>();
        Random random=new Random();
        int numberOfPhrases=0;
        switch (level)
        {
            case 1:
                while(numberOfPhrases < 20)
                {
                    int number=random.nextInt(words.size());
                    gamePhrases.add(words.get(number));
                    words.remove(number);
                    numberOfPhrases++;
                }
                break;

            case 2:
                while(numberOfPhrases < 40)
                {
                    int number=random.nextInt(words.size());
                    gamePhrases.add(words.get(number));
                    words.remove(number);
                    numberOfPhrases++;
                }
                break;

            case 3:
                while(numberOfPhrases < 50)
                {
                    int number=random.nextInt(words.size());
                    gamePhrases.add(words.get(number));
                    words.remove(number);
                    numberOfPhrases++;
                }
                break;

            case 4:
                while(numberOfPhrases < 60)
                {
                    int number=random.nextInt(words.size());
                    gamePhrases.add(words.get(number));
                    words.remove(number);
                    numberOfPhrases++;
                }
                break;

            case 5:
                while(numberOfPhrases < 70)
                {
                    int number=random.nextInt(words.size());
                    gamePhrases.add(words.get(number));
                    words.remove(number);
                    numberOfPhrases++;
                }
                break;

            case 6:
                while(numberOfPhrases < 80)
                {
                    int number=random.nextInt(words.size());
                    gamePhrases.add(words.get(number));
                    words.remove(number);
                    numberOfPhrases++;
                }
                break;

            case 7:
                while(numberOfPhrases < 100)
                {
                    int number=random.nextInt(words.size());
                    gamePhrases.add(words.get(number));
                    words.remove(number);
                    numberOfPhrases++;
                }
                break;

            case 8:
                while(numberOfPhrases < 120)
                {
                    int number=random.nextInt(words.size());
                    gamePhrases.add(words.get(number));
                    words.remove(number);
                    numberOfPhrases++;
                }
                break;

            case 9:
                while(numberOfPhrases < 140)
                {
                    int number=random.nextInt(words.size());
                    gamePhrases.add(words.get(number));
                    words.remove(number);
                    numberOfPhrases++;
                }
                break;

            case 10:
                while(numberOfPhrases < 200)
                {
                    int number=random.nextInt(words.size());
                    gamePhrases.add(words.get(number));
                    words.remove(number);
                    numberOfPhrases++;
                }
                break;
        }
        return gamePhrases;
    }
}