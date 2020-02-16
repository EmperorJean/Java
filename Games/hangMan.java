 

import java.util.*;

public class HangMan
{
    static String w = "AMYGDALA";
    static int lives = 5; 
    static String[] parts = { "   |\n  /\\","   O\n   |\n  /\\\n   |\n   \\","   O\n   |\n  /\\","   O\n   |\n   \\","   O\n   |","   O"};
    static char[] word;
    static char[] op;
    static Scanner console = new Scanner(System.in);
    static char[] guesses = new char[26];
    static char guess = '_';
    static int guessPos = 0;
    static boolean exist = false, win = false;
    
    public static void main()
    {
        
        System.out.println("Welcome to Hangman! Try and guess my secret word! Remember, you only have " + lives + " lives!");
        init();
        System.out.println("Lives: " + lives);
        
        while(!equal(word,op) && lives > 0)
        {
            System.out.println("Guess a letter\n");
            guess = console.next().toUpperCase().charAt(0);
            guesses[guessPos] = guess;
            check(guess,word);
            guessPos++;
            updateProgress(op);
            updateGuesses();
            
        }
        
        if(lives > 0)
        System.out.println("You Won!");
        else{
         System.out.println("You ran out of lives");   
        }
    }
    
   
    public static boolean equal(char[] a, char[] b)
    {
        for(int i = 0; i < word.length; i ++)
        {
            if(a[i] != b[i])
            {
                return false;
            }
        }
        return true;
    }
    
    public static void check(char c, char[] a)
    {
        for(int i = 0; i < word.length; i++)
        {
            if(a[i] == c)
            {
                op[i] = a[i];
                exist = true;
            }
           
        }
     if(!exist)
            lives--;
    }
    
    public static void init()
    {
        word = new char[w.length()];
        op = new char[word.length]; 
        
        for(int i = 0; i < w.length(); i++)
        {
            word[i] = w.charAt(i);
        }
        
        for(int i = 0; i < op.length; i++)
        {
            op[i] = '_';
        }
        
    }
    
    public static void updateGuesses()
    {
        System.out.println();
        System.out.print("Your Guesses: ");
        for(int i = 0; i < guessPos; i++)
        {
            System.out.print(guesses[i] + " ");
        }
        System.out.println();
        
    }
    public static void updateProgress(char a[])
    { 
        System.out.print("Progress: " + a[0]);
        for(int i = 1; i < word.length; i++)
        {
            System.out.print(" " + a[i] );
        }
        System.out.println();
        System.out.println("Lives: " + lives);
        System.out.print(parts[lives]);
       
        exist = false;
    }
    
}
