public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 4.0, latte = 5.0, cappuccino = 6.0;
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam", customer3 = "Jimmy", customer4 = "Noah";
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false, isReadyOrder3 = true, isReadyOrder4 = true;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"

        if (isReadyOrder1){
            System.out.println(customer1 + " " +pendingMessage);
        }
    	// ** Your customer interaction print statements will go here ** //
        if (isReadyOrder4){
            System.out.println(customer4 + " " +pendingMessage + " Your total is : " + String.valueOf(cappuccino));
        } 

          if (!isReadyOrder2){
            System.out.println(customer2 + " " +pendingMessage + " Your total is : " + String.valueOf(cappuccino * 2));
        }

        System.out.println(latte - dripCoffee); 

    }
}
