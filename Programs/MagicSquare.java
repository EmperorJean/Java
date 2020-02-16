import java.util.*;

public class MagicSquare
{
    static int N =5;
    static int[][] a = new int[N][N];
    static int r = 0, c = a.length/2, k = 1;;
    
    public static void main()
    {
     a[0][a.length/2] = k;
     System.out.println(Arrays.deepToString(a).replace("], ", "]\n"));
        
     for(int i = 2; i <= Math.pow(N, 2); i++)
     {
         r--;
         c++;
         
         if(r < 0 && c > a.length-1)
         {
           r+=2;
           c--;
         }
         
         if(c> a.length-1)
         {
         c = 0;
         }
         
         if(r < 0)
         {
         r = a[0].length - 1;
        }
    
        if(a[r][c] != 0)
        {
           r++;
           c--;
           r++;
        }
            
            
            a[r][c] = i;
     }
        
          System.out.println(Arrays.deepToString(a).replace("], ", "]\n"));

    }
    
    
}
