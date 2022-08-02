public class BankAccountTest{

    public static void main(String[] args ){
        BankAccount user1 = new BankAccount();
        BankAccount user2 = new BankAccount();

        user1.deposit(2.0, "checking");
        System.out.println(user1.totalBalance());
        
        user2.deposit(3.0, "saving");
        

        System.out.println(user1.totalFund);
    }
}