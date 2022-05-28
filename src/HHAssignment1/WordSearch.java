package HHAssignment1;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

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
        //words = new HashSet<String>();
        Scanner file = new Scanner("wordlist.txt");

        for (int x = 0; x <= PUZZLE_SIZE; x++)
        {
            for(int y = 0; y <= PUZZLE_SIZE; y++)
            {
                crossWord[x][y] = 0;
            } // end of for each
        } // end of for each

        // populates word set with all words in file
        while (file.hasNextLine())
        {
            words.add(file.nextLine());
        } // end of while


    } // end of generate method

    public static void fillPuzzle(Set<String> words)
    {
        for (int x = 0; x <= PUZZLE_SIZE; x++)
        {
            for(int y = 0; y <= PUZZLE_SIZE; y++)
            {
                if (crossWord[x][y] == 0)
                {
                    addHorizontal();
                }
            } // end of for each
        } // end of for each

    } // end of fillPuzzle

    public static void addHorizontal()
    {

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
