// Programmer: Hannah Hendrickson
// Assignment 1: Word Search Generator
// Class: CS145 Hybrid01
// Date: 5/31/2022
// Purpose: Generates a word search from either
// user word input or from pre-written text files.

// Notes: 


package HHAssignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class WordSearch 
{
    private static final int PUZZLE_SIZE = 15;

    // generate method, intakes word list file and generates a word search
    // returns word search as 2d array
    public static char[][] generate(File txtFile)
        throws FileNotFoundException
    {
        //Scanner file = new Scanner("wordlist.txt");
        String word;
        char[][] wordSearch = new char[PUZZLE_SIZE][PUZZLE_SIZE];
        ArrayList<String> wordList = new ArrayList<>();

        try
        {
            Scanner fileScan = new Scanner(txtFile);
            // populates wordList with uppercase words
            // from text file
            while (fileScan.hasNextLine())
            {
                word = fileScan.nextLine();
                word = word.toUpperCase();
                wordList.add(word);
            } // end of while
            
            // populates word search array with crosses
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
        // populates wordsearch array with words
        fillPuzzle(wordList, wordSearch);
        return wordSearch;

    } // end of generate method

    // fillPuzzle method, populates wordsearch array by calling add methods
    public static void fillPuzzle(ArrayList<String> wordList, char[][] wordSearch)
    {
        Iterator<String> itr = wordList.iterator();
        String word;
        word = itr.next();
        do
        {
            // x and y act as coordinates to place individual letters
            for (int x = 0; x <= PUZZLE_SIZE -1; x++)
            {
                for(int y = 0; y <= PUZZLE_SIZE -1; y++)
                {
                    if (x >= PUZZLE_SIZE || y >= PUZZLE_SIZE)
                    {
                        // empty so that code skips through loop
                    }
                    else if (wordSearch[x][y] == '+' &&
                        wordList.contains(word))
                    {
                        // addmain will call a specific add method
                        // this will add the word and delete it from list
                        addMain(wordSearch, word, x, y, itr);
                            
                    } // end of if
                    else if (!wordList.contains(word) &&
                             itr.hasNext())
                    {
                        // once a word has been successfully added
                        // the next one is generated
                        word = itr.next();
                    } // end of else if
                    // allows some randomness so that words
                    // are more distributed through the array
                    y += randomNumGenerator(3);
                    x += randomNumGenerator(3);
                } // end of for each
            } // end of for each
        } while(itr.hasNext()); // end of while loop

    } // end of fillPuzzle

    // addMain method, selects a specific add method through
    // psuedo-random num generation
    public static void addMain(char[][] wordSearch, String word, int x, int y, Iterator<String> itr)
    {
        int rand;
        rand = randomNumGenerator(6);
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

    // addHorizontal method, if possible it places a word horizontally
    public static void addHorizontal(char[][] wordSearch, String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;

        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int tempY = y; tempY <= (y + length -1); tempY++)
            {
                if (x >= PUZZLE_SIZE || tempY >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                } // end of if
                else if (wordSearch[x][tempY] != '+')
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

    // addHorizontalBackwards method, if possible it places 
    // a reversed word horizontally 
    public static void addHorizontalBackwards(char[][] wordSearch, 
        String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;

        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int tempY = y; tempY <= (y + length -1); tempY++)
            {
                if (x >= PUZZLE_SIZE || tempY >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                } // end of if
                else if (wordSearch[x][tempY] != '+')
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

    // addVertical method, if possible it places a word vertically
    public static void addVertical(char[][] wordSearch, String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int tempX = x; tempX <= (x + length -1); tempX++)
            {
                if (tempX >= PUZZLE_SIZE || y >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                } // end of if
                else if (wordSearch[tempX][y] != '+')
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

    // addVertical method, if possible it places a reversed word vertically
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
            for (int tempX = x; tempX <= (x + length -1); tempX++)
            {
                if (tempX >= PUZZLE_SIZE || y >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                } // end of if
                else if (wordSearch[tempX][y] != '+')
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

    // addDiagonally method, if possible it places a word diagonally
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
            for (int tempX = x; tempX <= (x + length -1); tempX++)
            {
                if (tempX >= PUZZLE_SIZE || tempY >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                } // end of if
                else if (wordSearch[tempX][tempY] != '+')
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

    // addDiagonallyBackwards method, if possible it places a reversed word vertically
    public static void addDiagnonallyBackwards(char[][] wordSearch, 
        String word, int x, int y, Iterator<String> itr)
    {
        int length = word.length();
        boolean validPlacement = true;
        int tempY = y;
        try
        {
            // for the range of indexes needed to place a word
            // each x,y pair is checked for whether it is empty/available
            // and checked for whether the index is in bounds
            for (int tempX = x; tempX <= (x + length -1); tempX++)
            {
                if (tempX >= PUZZLE_SIZE || tempY >= PUZZLE_SIZE)
                {
                    validPlacement = false;
                } // end of if
                else if (wordSearch[tempX][tempY] != '+')
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
    public static void printPuzzle(char[][] wordSearch)
    {
        char randChar;
        for (int x = 0; x <= PUZZLE_SIZE -1; x++)
        {
            for(int y = 0; y <= PUZZLE_SIZE -1; y++)
            {
                if (wordSearch[x][y] == '+')
                {
                    // prints out a random capital letter
                    // for each non-word space
                    randChar = (char)(randomNumGenerator(25) + 65);
                    System.out.print(randChar + " ");
                } // end of if
                else
                {
                    // prints the letter of a word
                    System.out.print(wordSearch[x][y] + " ");
                } // end of else
            } // end of for each
            System.out.println();
        } // end of for each
    } // end of print method

    // printSolution method, prints the word search with Xs replacing random letters
    public static void printSolution(char[][] wordSearch)
    {
        for (int x = 0; x <= PUZZLE_SIZE -1; x++)
        {
            for(int y = 0; y <= PUZZLE_SIZE -1; y++)
            {
                if (wordSearch[x][y] == '+')
                {
                    // prints out a capital X
                    // for each non-word space
                    System.out.print("  ");
                } // end of if
                else
                {
                    // prints out a letter in a word
                    System.out.print(wordSearch[x][y] + " ");
                } // end of else
            } // end of for each
            System.out.println();
        } // end of for each
    } // end of printSolution method

    // randomNumGenerator method, returns an int of 1 - bound
    public static int randomNumGenerator(int bound)
    {
        int randomNum;
        Random random = new Random();
        randomNum = random.nextInt(bound) + 1;
        return randomNum;
    } // end of randomNumGenerator
} // end of WordSearch class
