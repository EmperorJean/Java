import java.util.*;

public class MemoryMatch
{
    
    static final int NUM_PAIRS = 5;
    static int N = NUM_PAIRS * 2;
    static int[] gameBoard = new int[N+1];
    static Scanner console = new Scanner(System.in);
    
    static String[] guess = new String[N+1]; 
    
    static int turn=0;
    static int w = 0;
    static int pairs = NUM_PAIRS;
    static int playerNum;
    static int[] playerScore;
    static String[] playerName;
    
   
    public static void main()
    {
         init();
         updateScreen();
        do
        {
        if(turn >= playerNum)
        {
            turn = 0;
        }
        game(gameBoard,guess);
        turn++;
    }while(pairs > 0);
       w = 0;
        updateScreen();
    end();
    }
   
    static int total = 0;
    public static String tie(int n)
    {
      String ans = "There was a tie between ";
      String last = "";
      
      
      int ii = playerScore.length-1;
      while(playerScore[playerScore.length-1] == playerScore[ii])
      {
          total++;
          ii--;
          
      }
      System.out.println("Total tie: " + total);
      for(int i = 0; i < playerScore.length; i ++)
      {
          if(playerScore[n] == playerScore[i])
          {
              ans += playerName[i] + ", ";
            }
        }
        
        return ans + " with a score of " + playerScore[n];
    }
    
    public static void end()
    {
        String ans = "";
        boolean tie = false;
        for(int i = 1; i < playerScore.length; i ++)
        {
            //finding the position of the winner
            if(playerScore[i] > playerScore[w])
            {   
                w = i;
               tie = false;
            }else if(playerScore[i] == playerScore[w])
            {
                tie = true;
            }
        }
        if(!tie)
        {
        System.out.println("The Winner is " + playerName[w] + " with a score of " + playerScore[w]);
        }
        else{
            System.out.println(tie(w));
        }
        
    }
    public static void game(int[] a, String[] b)
    {
        int f1 = 0;
        int f2 = 0;
        //a is the gameboard and b is their guess board
        
        Boolean again = false;
        
        do
        {
                 System.out.println("What's your first guess " + playerName[turn] + "?");
        f1 = console.nextInt();
        //Making sure their second guess is valid before making it show the number at the guessed spot(f1)
        while(f1 < 1 || f1 > N || !(b[f1].charAt(0) == '*'))
        {
            System.out.println("You have entered an invalid choice, it's either been picked already or out of range? Try again.");
            f1 = console.nextInt();
        }
        b[f1] = Integer.toString(a[f1]);
        updateScreen();
        System.out.println("And your second?");
        f2 = console.nextInt();
        //Making sure their second guess is valid before making it show the number at the guessed spot(f2)
        while(f2 < 1 || f2 > N || !(b[f2].charAt(0) == '*'))
        {
            System.out.println("You have entered an invalid choice, it's either been picked already or out of range? Try again.");
            f2 = console.nextInt();
        }
        b[f2] = Integer.toString(a[f2]);
        updateScreen();
        
        //checking if they got a match or not
        if(a[f2]==a[f1])
        {
            System.out.println(playerName[turn] + " got a match! Congratulations!");
            playerScore[turn]++;
            //once it gets to zero screen is filled
            pairs--;
            again = true;
            
        }else{
            //if they don't have a match, reset to stars
            b[f1] = "*";
            b[f2] = "*";
            again = false;
        }
        
        if(pairs < 1)
        { 
            break;
        }
        updateScreen();
    }while(again);
    }
    public static void updateScreen()
    {
        
        System.out.println();
        printBoard();
        
        System.out.println("_______________________________________");     
                            
    }
    
    public static void printBoard()
    {
        //print out the name of players and their scores
        for(int i = 0; i < playerNum; i++)
        {
            System.out.println("\tPlayer: " + (i+1) + " " + playerName[i] + "\tScore: " + playerScore[i]);
        }
        //Print out the numbers that they can pick to flip
        System.out.println();
        for(int i = 1; i <= N; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 1; i <= N; i++)
        {
            System.out.print(gameBoard[i] + " ");
        }
  
        //print out what they've picked and what still haven't been picked, they have a "*"
        System.out.println();
        for(int i = 1; i <= N; i++)
        {
            System.out.print(guess[i] + " ");
        }
        System.out.println();
    }
    
    public static void init()
    {
        //Set up player data, 
        //filling in the board
        int c = 1;
        for(int i = 1; i <= N; i+=2 )
        {
            gameBoard[i] = c;
            gameBoard[i+1] = c;
            c++;
        }
        System.out.println(Arrays.toString(gameBoard));
        
        //making it for multiple players
        System.out.println("How many player will there be?");
        playerNum = console.nextInt();
        playerScore = new int[playerNum];
        playerName = new String[playerNum];
        
        //setUp Names and scores
        for(int i = 0; i < playerNum; i++)
        {
            System.out.println("Enter player " + (i+1) + "'s name");
            playerName[i] = console.next();
            playerScore[i] = 0;
        }
           
        
        
        
        //shuffle the array
        shuffle(gameBoard);
        
        
        //Fill array guess with *
        for(int i = 1; i <= N; i++)
        {
            guess[i] = "*";
        }
        
        
    }
    
    public static void shuffle(int[] a)
    {
        int temp = 0;
        int place  = (int)(Math.random()*N + 1);
        for(int i = 1; i < 1000; i++)
        {
           for(int j = 1; j <= N; j++)
            {
                //picks a random place and switches it with whatever is at j
            temp = a[j];
            a[j] = a[place];
            a[place] = temp;
            place  = (int)(Math.random()*N +1 );
            }
            
        }
    
    }
    
    
}
