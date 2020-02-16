import java.text.NumberFormat;
import java.util.Locale;

public class GroceryItemOrder
{
    private String name;
    private int quantity;
    private double pricePerUnit;
    
    public GroceryItemOrder()
    {
        this("",0,0);
    }
    
    public GroceryItemOrder(String name, int quantity, double pricePerUnit)
    {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }
    
    public double getCost()
    {
        return pricePerUnit * quantity;
    }
    
    public void setQuantity(int q)
    {
        this.quantity = quantity;
    }
    
    public String toString()
    {
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return "Item Name: " + name
                + "\tQuantity: " + quantity
                + "\tPrice Per Unit: " + pricePerUnit
                + "Cost: " + moneyFormat.format(getCost());
                
    }
}
