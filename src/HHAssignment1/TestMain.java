// Programmer: Hannah Hendrickson
// Assignment 1: Word Search Generator
// Class: CS145 Hybrid01
// Date: 5/31/2022
// Purpose: Generates a word search from either
// user word input or from pre-written text files.

// Notes: I didn't add any word overlapping.
// Words are guaranteed not be be lost or skipped over.
// It is possible that the program could hit an infinite loop
// if there is no valid placement for a word.

// Warning: There may be issues with the files being recognized 
// if there's no src folder above the package. 

package HHAssignment1;

import java.io.IOException;

public class TestMain
{
    public static void main(String[] args) 
        throws IOException
    {
        WordSearchMenu.introduction();
        WordSearchMenu.mainMenu();
        
    } // end of main method
} // end of TestMain class