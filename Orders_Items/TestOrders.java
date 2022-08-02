import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
    
        // Use this example code to test various orders' updates
       CoffeeKiosk kiosk = new CoffeeKiosk();

       kiosk.addMenuItem("cafe", 1.0);
       kiosk.addMenuItem("smoothie", 2.5);
       kiosk.newOrder();
    }
}
