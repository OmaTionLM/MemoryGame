package memoryGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used for ...
 * Alan Valderrama - 2042836 - alan.valderrama@correounivalle.edu.co
 * Jeison Perea - 2077250 - jeison.perea@correounivalle.edu.co
 * @version v.1.0.0 date:17/02/2022
 */
public class GUIGridBagLayout extends JFrame
{
    /*
     * How to play
     */
    public static final String BEGINNING_MESSAGE="Welcome to 'I KNOW THAT WORD!!!' this is a words game, your goal is to guess each word that the game shows you."
            +"\n \n The game has 10 levels, every level is harder than the previous one."
            +"\n \n first they will show you some words that you will have to remember, "
            +"once the game starts random words will appear and you will have to choose if that word is one of the ones that they showed you at the beginning or not, "
            +"depending on your successes you will pass the level."
            +"\n \n GOOD LUCK!!!";

    /*
     * Attributes
     */
    private Header headerProject;
    private JButton about, exit, play;
    private Listener listener;
    private PhrasePanel phrasePanel;
    private FileManager fileManager;
    private Timer timer1, timer2;
    private Control control;



    /**
     * Constructor of GUI class
     */
    public GUIGridBagLayout()
    {
        initGUI();
        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        //this.setUndecorated(true);
        this.setBackground(new Color(255,255,255,255));
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();

        //Create Listener Object and Control Object
        listener=new Listener();
        phrasePanel=new PhrasePanel();
        fileManager=new FileManager();
        control=new Control();

        //Set up JComponents
        /*
         *Header creation
         */
        headerProject = new Header("I KNOW THAT WORD", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=0;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject, constraints);

        /*
         * About button creation
         */
        about=new JButton("ABOUT");
        about.addActionListener(listener);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(about, constraints);

        /*
         *Exit button creation
         */
        exit=new JButton("EXIT");
        exit.addActionListener(listener);
        constraints.gridx=2;
        constraints.gridy=1;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(exit, constraints);

        /*
         *Set Phrase Panel
         */
        phrasePanel.setPreferredSize(new Dimension(700,500));
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=4;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(phrasePanel, constraints);

        /*
         *Play button creation
         */
        play=new JButton("PLAY");
        play.addActionListener(listener);
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth=3;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(play, constraints);

        /*
         * Timer 1 and timer 2 start
         */
        timer1 = new Timer(5000,listener);
        timer1.start();

        timer2 = new Timer(7000,listener);
        timer2.start();
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Listener implements ActionListener
    {
        /*
         * Attributes of the listener class
         */
        private ArrayList<String> usersName, allWordsOfTheLevel, goodWords;
        private boolean flagTimer1=false, flagTimer2=false, repeatLevel=false, levelWin=false;
        private int counter=0, userLevel=1, hits=0, welcome=1, firstTime=1;
        private Random random=new Random();
        private String logo, logo2, name;

        /*
         * Constructor
         */
        public Listener()
        {
            usersName=new ArrayList<String>();
            allWordsOfTheLevel=new ArrayList<String>();
            goodWords=new ArrayList<String>();

            logo="";
            name="";
            logo2="I KNOW THAT WORD";
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            /*
             * Play button
             */
            if(e.getSource()==play)
            {

                /*
                 * Welcome to the user
                 */
                if(welcome==1)
                {
                    int frequentUser=0;
                    usersName=fileManager.readingFileUsers();
                    name=JOptionPane.showInputDialog("Welcome, what's your user name?");
                    for(int i=0; i < usersName.size(); i++)
                    {
                        int twoPoints=usersName.get(i).indexOf(":");
                        if(usersName.get(i).substring(0,twoPoints).equals(name))
                        {
                            userLevel=Integer.parseInt(usersName.get(i).substring(twoPoints+1));
                            JOptionPane.showMessageDialog(null, "Welcome again '"+name+"' enjoy!");
                            frequentUser=1;
                            break;
                        }
                    }
                    if(name!=null && frequentUser==0)
                    {
                        usersName.add(name);
                        fileManager.writeText(name, userLevel);
                    }
                    while(name==null)
                    {
                        name=JOptionPane.showInputDialog("Please, enter a user name.");
                        for(int i=0; i < usersName.size(); i++)
                        {
                            int twoPoints=usersName.get(i).indexOf(":");
                            if(usersName.get(i).substring(0,twoPoints).equals(name))
                            {
                                userLevel= Integer.parseInt(usersName.get(i).substring(twoPoints+1));
                                JOptionPane.showMessageDialog(null, "Welcome again '"+name+"' enjoy!");
                                frequentUser=1;
                                break;
                            }
                        }
                        if(name!=null && frequentUser==0)
                        {
                            usersName.add(name);
                            fileManager.writeText(name, userLevel);
                        }
                    }
                    welcome=0;
                }

                /*
                 * If the user pass the level, this method will be executed
                 */
                if(levelWin==true)
                {
                    fileManager.cleanText();
                    fileManager.reWriteLevel(usersName, name, userLevel);
                    play.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Now you will see words that you must memorize., pay attention!");
                    //dictionary.reset();
                    allWordsOfTheLevel=control.getGameWords(userLevel);
                    goodWords.clear();
                    phrasePanel.setLogo(logo);
                    hits=0;
                    levelWin=false;
                    timer1.start();
                    timer2.start();
                    flagTimer1=true;
                }

                /*
                 * If the user lose the level, he must repeat the level
                 */
                if(repeatLevel==true)
                {
                    play.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Now you will see words that you must memorize., pay attention!");
                    //dictionary.reset();
                    allWordsOfTheLevel=control.getGameWords(userLevel);
                    goodWords.clear();
                    phrasePanel.setLogo(logo);
                    hits=0;
                    repeatLevel=false;
                    timer1.start();
                    timer2.start();
                    flagTimer1=true;
                }

                /*
                 * timer 1 begins
                 */
                if(firstTime==1)
                {
                    play.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Now you will see words that you must memorize., pay attention!");
                    allWordsOfTheLevel=control.getGameWords(userLevel);
                    phrasePanel.setLogo(logo);
                    flagTimer1=true;
                    firstTime=0;
                }
            }

            /*
             * timer 1
             */
            if(e.getSource()==timer1 && flagTimer1==true)
            {
                /*
                 * Words the user must remember
                 */
                if(counter < control.goodWordsSize(userLevel))
                {
                    /*
                     * Set the words on the panel
                     */
                    String theWord=allWordsOfTheLevel.get(random.nextInt(allWordsOfTheLevel.size()));
                    goodWords.add(theWord);
                    phrasePanel.setWord(theWord);
                    phrasePanel.updateUI();
                    counter++;
                }
                else
                {
                    /*
                     *Timer 1 stop and timer 2 begins
                     */
                    timer1.stop();
                    phrasePanel.setWord("");
                    counter=0;
                    JOptionPane.showMessageDialog(null, "Now you will see twice as many words, you need to choose which one was in the first ten words displayed.");
                    System.out.println(goodWords);
                    flagTimer1=false;
                    flagTimer2=true;
                }
            }

            /*
             * Timer 2
             */
            if(e.getSource()==timer2 && flagTimer2==true)
            {
                /*
                 * Words of the level
                 */
                if(counter < allWordsOfTheLevel.size())
                {
                    /*
                     * Set the all words on the panel
                     */
                    String theWord=allWordsOfTheLevel.get(counter);
                    phrasePanel.setWord(theWord);
                    int option=JOptionPane.showConfirmDialog(phrasePanel ,"Is this the word that was in the top ten?", "Choice Window", JOptionPane.YES_NO_OPTION);
                    boolean flag=false;
                    for(int i = 0; i < goodWords.size(); i++)
                    {
                        if(theWord.equals(goodWords.get(i))){
                            flag=true;
                            break;
                        }
                        else
                        {
                            flag=false;
                        }
                    }
                    /*
                     * The user must choose the correct option
                     */
                    if(flag==true && option ==JOptionPane.YES_OPTION)
                    {
                        hits++;
                        JOptionPane.showMessageDialog(null,"YOU RIGHT!!!");
                    }
                    if(flag == false && option ==JOptionPane.YES_OPTION)
                    {
                        JOptionPane.showMessageDialog(null, "YOU DIDN'T RIGHT!!!");
                    }
                    if(flag==true && option==JOptionPane.NO_OPTION)
                    {
                        JOptionPane.showMessageDialog(null, "YOU DIDN'T RIGHT!!!");
                    }
                    if(flag == false && option==JOptionPane.NO_OPTION)
                    {
                        hits++;
                        JOptionPane.showMessageDialog(null,"YOU RIGHT!!!");
                    }
                    counter++;
                }
                else
                {
                    /*
                     * Timer 2 stop
                     */
                    timer2.stop();
                    phrasePanel.setWord("");
                    /*
                     * The user is winner or loser
                     */
                    if(!control.win(userLevel, hits))
                    {
                        JOptionPane.showMessageDialog(null, "You did not meet the number of hits, press the play button to start the round again, good luck!");
                        repeatLevel=true;
                    }
                    if(control.win(userLevel, hits))
                    {
                        JOptionPane.showMessageDialog(null, "GOOD JOB!!! PRESS THE PLAY BUTTON TO START THE NEXT ROUND.");
                        userLevel++;
                        levelWin=true;
                    }
                    play.setEnabled(true);
                    counter=0;
                    phrasePanel.setLogo(logo2);
                    flagTimer2=false;
                }
            }

            /*
             * About button
             */
            if(e.getSource()==about)
            {
                JOptionPane.showMessageDialog(null, BEGINNING_MESSAGE);
            }

            /*
             * Button to exit the game
             */
            if(e.getSource()==exit)
            {
                System.exit(0);
            }
        }
    }
}
