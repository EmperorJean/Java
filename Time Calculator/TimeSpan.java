public class TimeSpan
{
    private int totalMinutes;
    
    public TimeSpan()
    {
        this(0,0);
    } 
    
    public TimeSpan(int h, int m)
    {
       add(h,m);
    }
    public void add(int h, int m)
    {
        
        if(h < 0 || m <0)
        {
            throw new IllegalArgumentException();
        }
        totalMinutes = 0;
        totalMinutes += 60 * h + m;
    }
    
    public void add(TimeSpan span)
    {
        this.totalMinutes += span.totalMinutes;
    }
    
    public void subtract(TimeSpan span)
    {
        this.totalMinutes -= span.totalMinutes;
    }
    
    public void scale(int factor)
    {
        this.totalMinutes *= factor;
    }
    
    public String toString()
    {
            return(totalMinutes / 60 + "h " + totalMinutes % 60 + "m");
        }
    
    
    
    
}
