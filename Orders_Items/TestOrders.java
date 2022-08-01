import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item("drip coffee", 1.5);
        Item item2 = new Item("cappuccino",3.5);
        Item item3 = new Item("esspresso", 1.0);

        // Order variables -- order1, order2 etc.
        Order order1 = new Order("Trong");
        Order order2 = new Order("Ethan");
        Order order3 = new Order("Doan");

        // Application Simulations
        order1.additem(item1);
        order1.additem(item2);
        order2.additem(item1);
        order2.additem(item3);
        order3.additem(item2);
        order3.additem(item3);

        order2.setReady(true);
        System.out.println(order2.getStatusMessage());

        System.out.println(order1.getOrderTotal());

        order1.display();
        order2.display();
        order3.display();
        // Use this example code to test various orders' updates
       
    }
}
