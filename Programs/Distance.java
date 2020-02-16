import java.util.Scanner;


public class Distance
{
    private static Scanner in = new Scanner(System.in);
    
    public static void main()
    {
        boolean play = true;
        do
        {
        char day = getDay();
          System.out.println("Enter the starting hour in 24 hour format");
        int hours = in.nextInt();
        System.out.println("Enter the starting minute");
        int minutes = in.nextInt();
        int time = toMinutes(hours,minutes);
        //get the amount of time that they spoke for
        System.out.println("How many minutes did you talk for?");
        int talk = in.nextInt();
       
        System.out.println("Total Cost: " + process(day,hours,minutes,talk));
        System.out.println("Want to plug in another call? (y/n)");
        char c = in.next().toUpperCase().charAt(0);
        if(c =='N')
        {
            break;
        }
    }while(play);
        
    } 
    
    
    
    public  static int toMinutes(int h, int m)
    {
        return (h * 60) + m;
    }
    public static double process(char day, int hours, int minutes, int talkTime)
    {
        double cost = 0; //making it 0 because it starts with 0
            int temp_min = 59;
        int day_int = 0;
          switch(day)
        {
            case 'M': day_int = 1; break;
            case 'T': day_int = 2; break;
            case 'W': day_int = 3; break;
            case 'R': day_int = 4; break;
            case 'F': day_int = 5; break;
            case 'A': day_int = 6; break;
            case 'U': day_int = 7; break;
            default: System.out.println("The day you selected wasn't specified, make sure you are typing a single letter and not the entire word.");
            
        }
        
        
          while (talkTime != 0)
            {
                if (day_int >= 1 && day_int <= 5) // if it's between monday - friday
                {


                    if (60 - minutes != 60) // if its not up to one hour.
                    {
                        if (talkTime <= (60 - minutes))
                        {
                            if (hours >= 8 && hours < 18) 
                                cost += 0.40 * talkTime; 
                            else                          
                                cost += 0.25 * talkTime;
                            minutes = 0;
                            talkTime = 0;

                        }
                        else
                        {
                            if (hours >= 8 && hours < 18) 
                                cost += 0.40 * (60 - minutes);
                            else
                                cost += 0.25 * (60 - minutes);
                            talkTime = talkTime - (60 - minutes);
                            minutes = 0;
                            hours += 1;
                        }
                    }

                    else
                    {
                        if (talkTime > 60) // more than an hour-
                        {
                            if (hours >= 8 && hours < 18) 
                                cost += 0.40 * 60;
                            else
                                cost += 0.25 * 60;
                            talkTime -= 60;
                            hours = hours + 1;
                        }
                        else
                        {
                            if (hours >= 8 && hours < 18)
                                cost += 0.40 * (talkTime);
                            else
                                cost += 0.25 * (talkTime);

                            talkTime = 0;
                        }



                    }

                    if (hours == 24) 
                    {
                        hours = 0;
                        day_int += 1;
                        if (day_int == 8) 
                            day_int = 1;
                    }


                }
                if (day_int >= 6 && day_int <= 7) 
                {

                    if (60 - minutes != 60) 
                    {
                        if (talkTime <= (60 - minutes))
                        {

                            cost += 0.15 * talkTime;
                            minutes = 0;
                            talkTime = 0;

                        }
                        else
                        {

                            cost += 0.15 * (60 - minutes);
                            talkTime = talkTime - (60 - minutes);
                            minutes = 0;
                            hours += 1;
                        }
                    }

                    else
                    {
                        if (talkTime > 60)
                        {

                            cost += 0.15 * 60;
                            talkTime -= 60;
                            hours = hours + 1;
                        }
                        else
                        {

                            cost += 0.15 * (talkTime);

                            talkTime = 0;
                        }



                    }

                    if (hours == 24) 
                    {
                        hours = 0;
                        day_int += 1;
                        if (day_int == 8)
                            day_int = 1;
                    }

                }



            }
            return cost; 
        }

        
 
    public static  char getDay()
    {
        System.out.println("What day of the week was the call made?"
                            + "\nM (for Monday)"
                            + "\nT (for Tuesday)"
                            + "\nW (for Wednesday)"
                            + "\nR (for thursday)"
                            + "\nF (for Friday"
                            + "\nA (for Saturday"
                            + "\nU (for Sunday)");
       return in.next().toUpperCase().charAt(0);
               
    }
    
}
