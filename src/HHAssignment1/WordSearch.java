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
    //private static char[][] crossWord;
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
        char[][] wordSearch = new char[PUZZLE_SIZE][PUZZLE_SIZE];
        ArrayList<String> wordList = new ArrayList<>();
        try
        {
            File txtFile = new File ("src\\HHAssignment1\\wordlist.txt");
            Scanner fileScan = new Scanner(txtFile);
            while (fileScan.hasNextLine())
            {
                word = fileScan.nextLine();
                word = word.toUpperCase();
                wordList.add(word);
            } // end of while
            
            for (int x = 0; x <= PUZZLE_SIZE -1; x++)
            {   
                for(int y = 0; y <= PUZZLE_SIZE -1; y++)
                {
                    wordSearch[x][y] = '+';
                } // end of for each
        } // end of for each
        } // end of try
        catch (Exception FileNotFoundException)
        {
            System.out.println("No such file!");
        } // end of catch
        fillPuzzle(wordList, wordSearch);
        //fillPuzzle(words, file);

    } // end of generate method

    public static void fillPuzzle(ArrayList<String> wordList, char[][] wordSearch)
    {
        Iterator<String> itr = wordList.iterator();
        String word;
        while (!wordList.isEmpty())
        {
            for (int x = 0; x <= PUZZLE_SIZE -1; x++)
            {
                word = itr.next();
                for(int y = 0; y <= PUZZLE_SIZE -1; y++)
                {
                    if (x >= PUZZLE_SIZE || y >= PUZZLE_SIZE)
                    {
                        // empty so that code skips through loop
                    }
                    else if (wordList.isEmpty())
                    {

                    }
                    else if (wordSearch[x][y] == '+' &&
                        wordList.contains(word))
                    {
                            addMain(wordSearch, word, x, y, itr);
                            //print(wordSearch);
                            //System.out.println();
                            //System.out.println();
                    } // end of if
                    y += randomNumGenerator(3);
                    x += randomNumGenerator(3);
                } // end of for each
            } // end of for each
        } // end of while loop

    } // end of fillPuzzle

    public static void addMain(char[][] wordSearch, String word, int x, int y, Iterator<String> itr)
    {
        int rand;
        rand = randomNumGenerator(5) +1;
                        switch(rand)
                        {
                            case 1:
                                addHorizontal(wordSearch, word, x, y, itr);
                                break;
                            case 2:
                                addHorizontalBackwards(wordSearch, word, x, y, itr);
                                break;
                            case 3:
                                addVertical(wordSearch, word, x, y, itr);
                                break;
                            case 4:
                                addVerticalBackwards(wordSearch, word, x, y, itr);
                                break;
                            case 5:
                                addDiagnonally(wordSearch, word, x, y, itr);
                                break;
                            case 6:
                                addDiagnonallyBackwards(wordSearch, word, x, y, itr);
                                break;
                            default:
                                break;

                        } // end of switch case
    } // end of addMain method


    public static void addHorizontal(char[][] wordSearch, String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        //int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int i = y; i <= (y + length); i++)
            {
                if (x >= PUZZLE_SIZE || y >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                } // end of if
                else if (wordSearch[x][y] != '+')
                {
                    validPlacement = false;
                }
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = 0; i <= length -1; i++)
                    {
                        wordSearch[x][y] = word.charAt(i);
                        y++;
                    } // end of for
                    itr.remove();
                } // end of if
            
        } // end of try
        catch (Exception e)
        {

        } // end of catch
    } // end of addHorizontal

    public static void addHorizontalBackwards(char[][] wordSearch, String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        //int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int i = y; i <= (y + length); i++)
            {
                if (x >= PUZZLE_SIZE || i >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                } // end of if
                else if (wordSearch[x][y] != '+')
                {
                    validPlacement = false;
                }
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = length -1; i >= 0; i--)
                    {
                        wordSearch[x][y] = word.charAt(i);
                        y++;
                    } // end of for
                    itr.remove();
                } // end of if
            
        } // end of try
        finally
        {

        } // end of finally
    } // end of addHorizontalBackwards

    public static void addVertical(char[][] wordSearch, String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        //int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int i = x; i <= (x + length); i++)
            {
                if (i >= PUZZLE_SIZE || y >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                } // end of if
                else if (wordSearch[x][y] != '+')
                {
                    validPlacement = false;
                }
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = 0; i <= length -1; i++)
                    {
                        wordSearch[x][y] = word.charAt(i);
                        x++;
                    } // end of for
                    itr.remove();
                } // end of if
            
        } // end of try
        finally
        {

        } // end of finally
    } // end of addVertical

    public static void addVerticalBackwards(char[][] wordSearch, String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        //int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int i = y; i <= (y + length); i++)
            {
                if (x >= PUZZLE_SIZE || y >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                } // end of if
                else if (wordSearch[x][y] != '+')
                {
                    validPlacement = false;
                }
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = length -1; i >= 0; i--)
                    {
                        wordSearch[x][y] = word.charAt(i);
                        x++;
                    } // end of for
                    itr.remove();
                } // end of if
            
        } // end of try
        finally
        {

        } // end of finally
    } // end of addVerticalBackwards

    public static void addDiagnonally(char[][] wordSearch, String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int tempX = x; tempX <= (x + length); tempX++)
            {
                if (tempX >= PUZZLE_SIZE || tempY >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                } // end of if
                else if (wordSearch[x][y] != '+')
                {
                    validPlacement = false;
                }
                tempY++;
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = 0; i <= length -1; i++)
                    {
                        wordSearch[x][y] = word.charAt(i);
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

    public static void addDiagnonallyBackwards(char[][] wordSearch, String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int tempX = x; tempX <= (x + length); tempX++)
            {
                if (tempX >= PUZZLE_SIZE || tempY >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                } // end of if
                else if (wordSearch[x][y] != '+')
                {
                    validPlacement = false;
                }
                tempY++;
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = length -1; i >= 0; i--)
                    {
                        wordSearch[x][y] = word.charAt(i);
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
    public static void print(char[][] wordSearch)
    {
        for (int x = 0; x <= PUZZLE_SIZE -1; x++)
        {
            for(int y = 0; y <= PUZZLE_SIZE -1; y++)
            {
                System.out.print(wordSearch[x][y] + " ");
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
        randomNum = random.nextInt(bound);
        return randomNum;
    } // end of randomNumGenerator
} // end of WordSearch class
