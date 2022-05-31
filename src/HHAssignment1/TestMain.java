package HHAssignment1;

import java.io.FileNotFoundException;

public class TestMain
{
    public static void main(String[] args) 
        throws FileNotFoundException
    {
        WordSearch.generate();
        
        /*
        for (int i = 0; i <= 20; i++)
        {
            System.out.println(WordSearch.randomNumGenerator(10));
        }
        */
    } // end of main method
} // end of TestMain class