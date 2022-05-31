// Programmer: Hannah Hendrickson
// Assignment 1: Word Search Generator
// Class: CS145 Hybrid01
// Date: 5/31/2022
// Purpose: Generates a word search from either
// user word input or from pre-written text files.

// Notes: The user cannot crash the program via any input.
// .txt file paths are pre-defined.

package HHAssignment1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WordSearchMenu 
{
    // introduction method, prints out a simple program intro
    public static void introduction()
    {
        System.out.printf("~Welcome to Word Search Generator!~%n%n"
                        + "You may choose to generate a word search with words entered manually,%n"
                        + "or you can select a text file with a pre-selected list of themed words!");
    } // end of introduction method

    // mainMenu method, controls the bulk of program functions
    // prompts user for menu choice and initiates associated methods
    public static void mainMenu() 
        throws IOException
    {
        Scanner input = new Scanner(System.in);
        //boolean validSelection = false;
        File file;
        char[][] wordSearch;
        char userInput;
        do
        {
        System.out.printf("%n%nPlease make a selection:%n"
                        + "|g| Generate a new word search%n"
                        + "|p| Print a word search%n"
                        + "|s| Print the solution to a word search%n"
                        + "|q| Quit the program%n%n");
     
            System.out.println("Type the corresponding letter of your menu choice.");
            userInput = input.nextLine().charAt(0);
            System.out.printf("%n%n");

            switch (userInput)
            {
                case 'g':
                    userCreateFile();
                    break;
                case 'p':
                    file = selectFile();
                    wordSearch = WordSearch.generate(file);
                    WordSearch.printPuzzle(wordSearch);
                    break;
                case 's':
                    file = selectFile();
                    wordSearch = WordSearch.generate(file);
                    WordSearch.printSolution(wordSearch);
                    break;
                case 'q':
                    System.out.printf("%n%nEnding the program.");
                    break;
                default:
                    System.out.printf("%n%nInvalid selection.%n%n");
                    break;
            }
        } while (userInput != 'q');
        input.close();
    } // end of mainMenu class

    // selectFile method, called for print methods
    // user selects from a list of pre-defined file names
    // returns the file at that path
    public static File selectFile()
    {
        Scanner input = new Scanner(System.in);
        String filePath;
        File file = new File("");
        boolean invalidSelection = false;
        System.out.printf("Select a word list file.%n%n"
                        + "|u| User Generated Words%n"
                        + "|c| Washington Cities%n"
                        + "|p| Pasta and Pasta Dishes%n"
                        + "|d| Dog Breeds%n"
                        + "|w| Weather%n");

        do
        {
            System.out.printf("%nType the corresponding letter of your choice.%n");
            char userInput = input.nextLine().charAt(0);

            switch(userInput)
            {
                case 'u':
                    filePath = "src\\HHAssignment1\\UserWordSearch.txt";
                    file = new File(filePath);
                    invalidSelection = false;
                    break;
                case 'c':
                    filePath = "src\\HHAssignment1\\WAcities.txt";
                    file = new File(filePath);
                    invalidSelection = false;
                    break;
                case 'p':
                    filePath = "src\\HHAssignment1\\PastaAndPastaDishes.txt";
                    file = new File(filePath);
                    invalidSelection = false;
                    break;
                case 'd':
                    filePath = "src\\HHAssignment1\\DogBreeds.txt";
                    file = new File(filePath);
                    invalidSelection = false;
                    break;
                case 'w':
                    filePath = "src\\HHAssignment1\\WeatherPhenomenon.txt";
                    file = new File(filePath);
                    invalidSelection = false;
                    break;
                default:
                    invalidSelection = true;
                    break;
            } // end of switch case
            
        } while(invalidSelection);
        
        return file;
    } // end of selectFile method

    // userCreateFile method, populates UserWordSearch.txt file
    public static void userCreateFile() 
        throws IOException
    {
        int wordCount = 0;
        String userWord;
        Scanner input = new Scanner(System.in);

        FileWriter file = new FileWriter("src\\HHAssignment1\\UserWordSearch.txt");
        //BufferedWriter writer = new BufferedWriter(file);

        System.out.println("How many words would you like to enter for your word search?");
        while (wordCount <= 0)
        {
            try
            {
                wordCount = input.nextInt();
                input.nextLine();
            } // end of try
            catch (Exception InputMismatchException)
            {
                System.out.printf("%n%nPlease enter a number.%n");
            } // end of catch
        } // end of while
        
        System.out.printf("You may now begin entering words.%n"
                        + "Please note that words may not contain spaces "
                        + "or special characters.%n%n");
        for (int i = 1; i <= wordCount; i++)
        {
            userWord = userString(input);
            file.write(userWord + "\n");
        } // end of for loop
        file.close();
    } // end of userCreateFile method

   // userString method, intakes a single String from the user and returns it
   // ensures the String is one word with no special characters
   public static String userString(Scanner input)
    {
        String userEntry = "";
        int length;
        char letter;
        int letterNumValue;
        boolean invalidWord = false;
        do
        {
            System.out.println("Type a word. ");
            userEntry = input.nextLine();
            userEntry = userEntry.toUpperCase();
            length = userEntry.length();

            // Checks that user's String does not contain spaces
            // or special characters. If it does then user will be prompted to reenter
            for (int i = 0; i <= length -1; i++)
            {
                letter = userEntry.charAt(i);
                letterNumValue = Character.getNumericValue(letter);
                if (letter >= 65 && letter <= 90
                    && length <= 13)
                {
                    invalidWord = false;
                } // end of if
                else
                {
                    invalidWord = true;
                    System.out.printf("%nPlease reenter your word without "
                                    + "spaces or special characters.%n%n");
                } // end of else
            } // end of for

        } while (userEntry.equals("") || invalidWord);
        return userEntry;
    } // end of userString

} // end of WordSearchMenu class
