
public class TimeSpan_CLIENT
{
    public static void main()
    {
    TimeSpan t1, t2, t3, t4;
    
        t1 = new TimeSpan();
        System.out.println("t1 = " + t1.toString());
        System.out.println();
        
        t1.add(1,30);
        System.out.println("t1.add(1,30) = " + t1);
        System.out.println();
        
        t2 = new TimeSpan(3,45);
        System.out.println("t2 = new TimeSpan(3,45) = " + t2);
        System.out.println();        
        
        t2.add(t1);
        System.out.println("t2.add(t1) = " + t2);
        System.out.println();          
        
        t2.subtract(t1);
        System.out.println("t2.subtract(t1) = " + t2);
        System.out.println();          
        
        t1.scale(3);
        System.out.println("t1.scale(3) = " + t1);
        System.out.println();         
                
    }  // main
   
} // TimeSpan_CLIENT
