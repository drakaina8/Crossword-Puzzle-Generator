// Programmer: Hannah Hendrickson
// Assignment 1 Crossword Puzzle
// Class: CS145 Hybrid01
// Date: 05/27/2022
// Purpose: Generate a functional Crossword Puzzle
// using user String inputs or Strings from a .txt file.

// Notes: +


package HHAssignment1;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class WordSearch 
{
    private static final int PUZZLE_SIZE = 15;
    private static Set<String> words;
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
        crossWord = new char[PUZZLE_SIZE][PUZZLE_SIZE];
        try
        {
        Scanner file = new Scanner("wordlist.txt");
        } // end of try
        catch (Exception FileNotFoundException)
        {
            System.out.println("No such file!");
        } // end of catch

        for (int x = 0; x <= PUZZLE_SIZE -1; x++)
        {
            for(int y = 0; y <= PUZZLE_SIZE -1; y++)
            {
                crossWord[x][y] = 0;
            } // end of for each
        } // end of for each

        // populates word set with all words in file
        /*
        while (file.hasNextLine())
        {
            words.add(file.nextLine());
            
        } // end of while
        */

    } // end of generate method

    public static void fillPuzzle(Set<String> words, Scanner file)
    {
        String word;
        while (file.hasNextLine())
        {
            word = file.nextLine();
            for (int x = 0; x <= PUZZLE_SIZE; x++)
            {
                for(int y = 0; y <= PUZZLE_SIZE; y++)
                {
                    if (crossWord[x][y] == 0)
                    {
                        addHorizontal(word, x, y);
                    }
                } // end of for each
            } // end of for each
        } // end of while loop

    } // end of fillPuzzle

    public static void addHorizontal(String word, int x, int y)
    {
        int length = word.length();
        boolean validPlacement = true;
        //int tempY = y;
        try
        {
            for (int i = y; i <= (y + length -1); i++)
            {
                if (crossWord[x][y] != 0)
                {
                    validPlacement = false;
                } // end of if
            } // end of for loop

                if (validPlacement)
                {
                    for (int i = 0; i <= length; i++)
                    {
                        crossWord[x][y] = word.charAt(i);
                        y++;
                    } // end of for
                } // end of if
            
        } // end of try
        catch (Exception e)
        {

        } // end of catch
    } // end of addHorizontal

    public static void addHorizontalBackwards()
    {

    } // end of addHorizontalBackwards

    public static void addVertical()
    {

    } // end of addVertical

    public static void addVerticalBackwards()
    {

    } // end of addVerticalBackwards

    public static void addDiagnonally()
    {

    } // end of addDiagnonally

    public static void addDiagnonallyBackwards()
    {

    } // end of addDiagnonallyBackwards
    
    // print method, prints out the word search puzzle
    public static void print()
    {

    } // end of print method

    // printSolution method, prints the word search with Xs replacing random letters
    public static void printSolution()
    {

    } // end of printSolution method
} // end of WordSearch class
