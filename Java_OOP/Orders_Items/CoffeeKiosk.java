import java.util.ArrayList;

public class CoffeeKiosk{
    ArrayList<Item> menu;
    ArrayList<Order> orders;

    public CoffeeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price){
        Item newItem = new Item(name, price);
        menu.add(newItem);
        newItem.setIndex(menu.indexOf(newItem));
    }

    public void displayMenu(){
        for( int i = 0; i < this.menu.size(); i++){
            System.out.println(this.menu.get(i).getIndex() + " " + this.menu.get(i).getName() + " -- " + "$" + this.menu.get(i).getPrice());
        };
    }
        public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        Order or = new Order(name);

        System.out.println("Menu: ");
        displayMenu();
    	// Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            int num = Integer.parseInt(itemNumber);
            if(num < this.menu.size()){
                or.addItem(this.menu.get(num));
            } else{
                System.out.println("There is no such index");
            }
             or.display();
             System.out.println("Please enter a menu item index or q to quit:");
             itemNumber = System.console().readLine();
           
             
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        or.display();
        this.orders.add(or);
    }

    
}