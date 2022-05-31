package HHAssignment1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WordSearchMenu 
{
    public static void introduction()
    {
        System.out.printf("~Welcome to Word Search Generator!~%n%n"
                        + "You may choose to generate a word search with words entered manually,%n"
                        + "or you can select a text file with a pre-selected list of themed words!");
    } // end of introduction method

    public static void mainMenu() 
        throws IOException
    {
        Scanner input = new Scanner(System.in);
        //boolean validSelection = false;
        File file;
        char[][] wordSearch;
        char userInput;
        System.out.printf("Please make a selection:%n"
                        + "|g| Generate a new word search%n"
                        + "|p| Print a word search%n"
                        + "|s| Print the solution to a word search%n"
                        + "|q| Quit the program%n%n");
        do
        {
            System.out.println("Type the corresponding letter of your menu choice.");
            userInput = input.nextLine().charAt(0);
            switch (userInput)
            {
                case 'g':
                    userCreateFile();
                    //validSelection = true;
                    break;
                case 'p':
                    file = selectFile();
                    wordSearch = WordSearch.generate(file);
                    WordSearch.printPuzzle(wordSearch);
                    //validSelection = true;
                    break;
                case 's':
                    file = selectFile();
                    wordSearch = WordSearch.generate(file);
                    WordSearch.printSolution(wordSearch);
                    //validSelection = true;
                    break;
                case 'q':
                    System.out.printf("%n%nEnding the program.");
                    //validSelection = true;
                    break;
                default:
                    System.out.printf("%n%nInvalid selection.%n%n");
                    //validSelection = false;
                    break;
            }
        } while (userInput != 'q');
    } // end of mainMenu class

    public static File selectFile()
    {
        Scanner input = new Scanner(System.in);
        String fileName;
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
                    fileName = "UserWordSearch.txt";
                    file = new File(fileName);
                    invalidSelection = false;
                    break;
                case 'c':
                    fileName = "WAcities.txt";
                    file = new File(fileName);
                    invalidSelection = false;
                    break;
                case 'p':
                    fileName = "PastaAndPastaDishes.txt";
                    file = new File(fileName);
                    invalidSelection = false;
                    break;
                case 'd':
                    fileName = "DogBreeds.txt";
                    file = new File(fileName);
                    invalidSelection = false;
                    break;
                case 'w':
                    fileName = "WeatherPhenomenon.txt";
                    file = new File(fileName);
                    invalidSelection = false;
                    break;
                default:
                    invalidSelection = true;
                    break;
            } // end of switch case
            
        } while(invalidSelection);
        
        return file;
    } // end of selectFile method

    public static void userCreateFile() 
        throws IOException
    {
        int wordCount;
        String userWord;
        Scanner input = new Scanner(System.in);

        FileWriter file = new FileWriter("UserWordSearch.txt");
        BufferedWriter writer = new BufferedWriter(file);

        System.out.println("How many words would you like to enter for your word search?");
        wordCount = input.nextInt();
        input.nextLine();
        System.out.printf("You may now begin entering words.%n"
                        + "Please note that words may not contain spaces "
                        + "or special characters.%n%n");
        for (int i = 1; i <= wordCount; i++)
        {
            userWord = userString(input);
            writer.write(userWord + "\n");
        } // end of for loop
    } // end of userCreateFile method

   // userString method, intakes a single String from the user and returns it
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
                if (letter >= 65 && letter <= 90)
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
