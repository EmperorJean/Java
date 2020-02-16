import java.text.NumberFormat;
import java.util.*;


public class GroceryList
{
    private ArrayList<GroceryItemOrder> gList;
    private final int MAX_SIZE = 10;
    public GroceryList()
    {
        gList = new ArrayList<>();
    }
    
    public void add(GroceryItemOrder item)
    {
        gList.add(item);
    }
    
    public String getTotalCost()
    {
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        double total = 0;
        
        for(int i = 0; i < gList.size(); i++)
        {
            total += gList.get(i).getCost();
        }
        
        return "Total Cost: " + total;
    }
    
    public String toString()
    {
        String s = "";
        for(int i = 0; i < gList.size(); i++)
        {
            s += gList.get(i).toString() + "\n";
        }
        return s;
    }
}
