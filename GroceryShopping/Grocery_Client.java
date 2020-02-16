public class Grocery_CLIENT
{

   public static void main()
   {
    GroceryList g1 = new GroceryList();
    GroceryList g2 = new GroceryList();     
        
       System.out.println("Filling g1.");
       g1.add(new GroceryItemOrder("Apples",5,0.49));
       g1.add(new GroceryItemOrder("Bananas",3,0.35));
       g1.add(new GroceryItemOrder("Cantelope",4,1.23));
       g1.add(new GroceryItemOrder("Dates",10, 1.22));
       g1.add(new GroceryItemOrder("Eggplant",3, 2.55));
       System.out.println("g1 list: \n" + g1);
       System.out.println("\t g1 total = " + g1.getTotalCost());
       System.out.println("\n\n");
       
      System.out.println("Filling g2.");       
       g2.add(new GroceryItemOrder("Almond Joy",10,0.25));
       g2.add(new GroceryItemOrder("Babe Ruth",2,0.40));
       g2.add(new GroceryItemOrder("Crunch",2,0.10));
       g2.add(new GroceryItemOrder("Gummy Dots",20, 0.05));
       g2.add(new GroceryItemOrder("Easter Egg",1, 1.99));     
       g2.add(new GroceryItemOrder("Fun Dip",1,0.99));
       g2.add(new GroceryItemOrder("Goa Bar",2,0.39));
       g2.add(new GroceryItemOrder("Hershey",1,1.00));
       g2.add(new GroceryItemOrder("Grand",2,0.19));
       g2.add(new GroceryItemOrder("Kit Kat",3,2));
       g2.add(new GroceryItemOrder("M&M",2,1.29));       
       System.out.println("g2 list: \n" + g2);
       System.out.println("\t g2 total = " + g2.getTotalCost());   
    }
  
}
