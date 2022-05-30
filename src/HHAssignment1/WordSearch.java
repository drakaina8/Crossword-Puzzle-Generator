// Programmer: Hannah Hendrickson
// Assignment 1 Crossword Puzzle
// Class: CS145 Hybrid01
// Date: 05/27/2022
// Purpose: Generate a functional Crossword Puzzle
// using user String inputs or Strings from a .txt file.

// Notes: +


package HHAssignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class WordSearch 
{
    private static final int PUZZLE_SIZE = 15;
    //private static Set<String> words;
    private static char[][] crossWord;
    // printIntro method, prints introductions to the program
    public static void printIntro()
    {
        System.out.println("Welcome to CrossWord Puzzles!");
        System.out.println();
    } // end of printIntro method

    // generate method, prompts user for the number of words to enter
    // intakes user's words and generates a word search
    public static void generate()
        throws FileNotFoundException
    {
        //Scanner file = new Scanner("wordlist.txt");
        String word;
        crossWord = new char[PUZZLE_SIZE][PUZZLE_SIZE];
        ArrayList<String> words = new ArrayList<>();
        try
        {
            File txtFile = new File ("src\\HHAssignment1\\wordlist.txt");
            Scanner fileScan = new Scanner(txtFile);
            while (fileScan.hasNextLine())
            {
                word = fileScan.nextLine();
                words.add(word);
            } // end of while
            
            for (int x = 0; x <= PUZZLE_SIZE -1; x++)
            {   
                for(int y = 0; y <= PUZZLE_SIZE -1; y++)
                {
                    crossWord[x][y] = '+';
                } // end of for each
        } // end of for each
        } // end of try
        catch (Exception FileNotFoundException)
        {
            System.out.println("No such file!");
        } // end of catch
        print();
        fillPuzzle(words);
        //fillPuzzle(words, file);

    } // end of generate method

    public static void fillPuzzle(ArrayList<String> words)
    {
        Iterator<String> itr = words.iterator();
        String word;
        while (itr.hasNext())
        {
            word = itr.next();
            for (int x = 0; x <= PUZZLE_SIZE -1; x++)
            {
                for(int y = 0; y <= PUZZLE_SIZE -1; y++)
                {
                    if (Character.compare(crossWord[x][y] == 0) &&
                        words.contains(word))
                    {
                            addMain(words, word, x, y, itr);
                            //itr.remove();
                            print();
                            System.out.println();
                            System.out.println();
                            y += randomNumGenerator(3);
                    } // end of if
                } // end of for each
            } // end of for each
            //itr.remove();
        } // end of while loop

    } // end of fillPuzzle

    public static void addMain(ArrayList<String> words, String word, int x, int y, Iterator<String> itr)
    {
        int rand;
        rand = randomNumGenerator(10);
                        switch(rand)
                        {
                            case 1:
                                addHorizontal(word, x, y, itr);
                                break;
                            case 2:
                                addHorizontalBackwards(word, x, y, itr);
                                break;
                            case 3:
                                addVertical(word, x, y, itr);
                                break;
                            case 4:
                                addVerticalBackwards(word, x, y, itr);
                                break;
                            case 5:
                                addDiagnonally(word, x, y, itr);
                                break;
                            case 6:
                                addDiagnonallyBackwards(word, x, y, itr);
                                break;
                            default:
                                break;

                        } // end of switch case
    } // end of addMain method


    public static void addHorizontal(String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        //int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int i = y; i <= (y + length -1); i++)
            {
                if (crossWord[x][y] != '+')
                {
                    validPlacement = false;
                } // end of if
                else if (x >= PUZZLE_SIZE || y >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                }
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = 0; i <= length -1; i++)
                    {
                        crossWord[x][y] = word.charAt(i);
                        y++;
                    } // end of for
                    itr.remove();
                } // end of if
            
        } // end of try
        catch (Exception e)
        {

        } // end of catch
    } // end of addHorizontal

    public static void addHorizontalBackwards(String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        //int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int i = y; i <= (y + length -1); i++)
            {
                if (crossWord[x][y] != '+')
                {
                    validPlacement = false;
                } // end of if
                else if (x >= PUZZLE_SIZE || y >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                }
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = length -1; i >= 0; i--)
                    {
                        crossWord[x][y] = word.charAt(i);
                        y++;
                    } // end of for
                    itr.remove();
                } // end of if
            
        } // end of try
        finally
        {

        } // end of finally
    } // end of addHorizontalBackwards

    public static void addVertical(String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        //int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int i = y; i <= (y + length -1); i++)
            {
                if (crossWord[x][y] != '+')
                {
                    validPlacement = false;
                } // end of if
                else if (x >= PUZZLE_SIZE || y >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                }
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = 0; i <= length -1; i++)
                    {
                        crossWord[x][y] = word.charAt(i);
                        x++;
                    } // end of for
                    itr.remove();
                } // end of if
            
        } // end of try
        finally
        {

        } // end of finally
    } // end of addVertical

    public static void addVerticalBackwards(String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        //int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int i = y; i <= (y + length -1); i++)
            {
                if (crossWord[x][y] != '+')
                {
                    validPlacement = false;
                } // end of if
                else if (x >= PUZZLE_SIZE || y >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                }
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = length -1; i >= 0; i--)
                    {
                        crossWord[x][y] = word.charAt(i);
                        x++;
                    } // end of for
                    itr.remove();
                } // end of if
            
        } // end of try
        finally
        {

        } // end of finally
    } // end of addVerticalBackwards

    public static void addDiagnonally(String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        //int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int i = y; i <= (y + length -1); i++)
            {
                if (crossWord[x][y] != '+')
                {
                    validPlacement = false;
                } // end of if
                else if (x >= PUZZLE_SIZE -1 || y >= PUZZLE_SIZE -1)
                {
                    validPlacement = false;
                }
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = 0; i <= length -1; i++)
                    {
                        crossWord[x][y] = word.charAt(i);
                        x++;
                        y++;
                        
                    } // end of for
                    itr.remove();
                } // end of if
            
        } // end of try
        finally
        {

        } // end of finally
    } // end of addDiagnonally

    public static void addDiagnonallyBackwards(String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        //int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int i = y; i <= (y + length -1); i++)
            {
                if (crossWord[x][y] != '+')
                {
                    validPlacement = false;
                } // end of if
                else if (x >= PUZZLE_SIZE -1 || y >= PUZZLE_SIZE -1)
                {
                    validPlacement = false;
                }
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = length -1; i >= 0; i--)
                    {
                        crossWord[x][y] = word.charAt(i);
                        x++;
                        y++;
                    } // end of for
                    itr.remove();
                } // end of if
            
        } // end of try
        finally
        {

        } // end of finally
    } // end of addDiagnonallyBackwards
    
    // print method, prints out the word search puzzle
    public static void print()
    {
        for (int x = 0; x <= PUZZLE_SIZE -1; x++)
        {
            for(int y = 0; y <= PUZZLE_SIZE -1; y++)
            {
                System.out.print(crossWord[x][y]);
            } // end of for each
            System.out.println();
        } // end of for each
    } // end of print method

    // printSolution method, prints the word search with Xs replacing random letters
    public static void printSolution()
    {
        
    } // end of printSolution method

    private static int randomNumGenerator(int bound)
    {
        int randomNum;
        Random random = new Random();
        randomNum = random.nextInt(bound) -1;
        return randomNum;
    } // end of randomNumGenerator
} // end of WordSearch class
