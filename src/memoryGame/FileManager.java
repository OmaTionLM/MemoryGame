package memoryGame;

import java.io.*;
import java.util.ArrayList;

/**
 * This class is used for ...
 * Alan Valderrama - 2042836 - alan.valderrama@correounivalle.edu.co
 * Jeison Perea - 2077250 - jeison.perea@correounivalle.edu.co
 * @version v.1.0.0 date:17/02/2022
 */
public class FileManager
{
    /*
     * Attributes
     */
    private static final String PATH_USERS="src/files/users.txt";
    private static final String PATH_WORDS="src/files/words.txt";
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    /**
     * Method that returns registered users
     */
    public ArrayList<String> readingFileUsers()
    {
        ArrayList<String>usersName=new ArrayList<>();
        try {
            fileReader = new FileReader(PATH_USERS);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line!=null)
            {
                usersName.add(line);
                line=input.readLine();
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return usersName;
    }

    /**
     * Method that returns the words of the file
     */
    public ArrayList<String> readingFileWords()
    {
        ArrayList<String> phrases=new ArrayList<String>();
        try {
            fileReader = new FileReader(PATH_WORDS);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line!=null)
            {
                phrases.add(line);
                line=input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return phrases;
    }

    /*
     * Method that allows writing to the file
     */
    public void writeText(String linea, int level)
    {
        try
        {
            fileWriter = new FileWriter(PATH_USERS,true);
            output = new BufferedWriter(fileWriter);
            output.write(linea+":"+level);
            output.newLine();
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try
            {
                output.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /*
     * Method that allows re-writing to the file
     */
    public void reWriteLevel(ArrayList<String> users, String name, int level)
    {
        try
        {
            fileWriter = new FileWriter(PATH_USERS,true);
            output = new BufferedWriter(fileWriter);
            output.write(name+":"+level);
            output.newLine();
            for (int i=0; i < users.size(); i++)
            {
                int twoPoints=users.get(i).indexOf(":");
                if (!users.get(i).substring(0, twoPoints).equals(name))
                {
                    output.write(users.get(i));
                    output.newLine();
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try
            {
                output.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /*
     * Method that allows clean the file
     */
    public void cleanText()
    {
        try
        {
            output = new BufferedWriter(new FileWriter(PATH_USERS));
            output.write("");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
