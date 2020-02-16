
import java.util.*;

public class MasterMind
{
    static int tries = 10;
    static String code = "RYYR";
    static char[] secretCode = new char[4];
    static char[] guess  = new char[4];
    static char[] xo = new char[4];
    static String input = "";
    static Scanner console = new Scanner(System.in);
    static String gguess = "";
    static String xxo = "";
    static boolean play = true;
    public static void main()
    {
    
        init();
        do
        {
        guess();
        process(guess,secretCode);
        update(guess,xo);
        
        tries--;
    }while(tries > 0 && !equal(guess, secretCode));
    
    if(!equal(guess, secretCode))
    {
        System.out.println("You ran out of tries!\nWanna play again?");
    }
    else{
        System.out.println("Congratulations!! It took " + (tries * -1 + 10) + " tries.\nDo you want to play again?");
       
    }
     char ans = console.next().toUpperCase().charAt(0);
        switch(ans)
        {
            case 'Y': System.out.println("Lets go again! \n\n####################################################\n\n"); main(); break;
            case 'N': System.out.println("Sad to see you go, come back soon! Have a great day!"); break;
            default: System.out.println("Bye!");
        }

    }
    
    public static boolean equal(char[] a,char[] b)
    {
        for(int i = 0; i < a.length; i ++)
        {
            if(a[i] != b[i])
            {
                return false;
            }
        }
        return true;
    }
    
    public static void update(char[] a, char[] b)
    {
        //array a is the guess and b is the XO
        System.out.print(tries * -1 +11 + ") \t");
        
        
        System.out.println(gguess + "\t\t" + xxo);
        
    }
    
    public static void process(char[] a,char[] b)
    {
        //a is guess b is secret 
        int x = 0;
        int o = 0;
        String xoHold = "";
       
            for(int i = 0; i < a.length; i++)
            {
               if(a[i] == b[i])
               {
                   //checking for the Xś first and if there are any theyŕe changed to blanks for secret and - for guess
                   b[i] = ' ';
                   a[i] = '-';
                   x++;
                   xoHold += "X";
                }
            }
            for(int k = 0; k < a.length; k++)
            {
            for(int j = 0; j < a.length; j++)
             {
               if(a[k] == b[j])
                        {
                            //Checking for the Os
                            b[j] = ' ';
                            o++;
                            xoHold += "O";
                            break;
                        }         
             }
            }
            fill(secretCode, code);   
            //filling in the guess array and the xo array
            xxo = xoHold;
        fill(xo, xoHold);
        fill(guess, gguess);
    }
        
   
    
    public static void fill(char[] c, String s)
    {
         for(int i = 0; i < s.length();i++)
        {
            c[i] = s.charAt(i);
        }
    }
    
    public static void guess()
    {
        System.out.println("\nPlease enter your guess. (Ex. \"RBGP\")");
        input = console.next().toUpperCase();
        //This will make sure whatever they enter is valid
        while(!(input.length() == 4))
        {
            System.out.println("\nIt's not hard. Here's the example again. (Ex. \"RBGP\")");
            input = console.next().toUpperCase();
        };
        gguess = input;
        //placing their string into an Array
       fill(guess, input);
        System.out.println("Your Guess: " + Arrays.toString(guess));
       
    }
    
    public static void init()
    {
        System.out.println("Welcome to MasterMind. Your Goal is to get the secret code withen 10 tries."
                            + "\n Guess for colors at a time, if there is a right color in the right spot there will be an X, if it's the right color in the wrong spot there'll be an O.");
        System.out.println("Here are the color codes: "
                            + "\nK = Black"
                            + "\nB = Blue"
                            + "\nY = Yellow"
                            + "\nW = white"
                            + "\nR = Red"
                            + "\nG = Green"
                            + "\n Have Fun! ");
                            //Set Up Secret code and reset tries to 10 if they click play Again
        fill(secretCode, code);
        tries = 10;
    }
}
