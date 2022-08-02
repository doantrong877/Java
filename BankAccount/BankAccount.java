public class BankAccount{
    private double checkingBalance, savingBalance;
    public static int accountCount;
    public static double totalFund;
    public BankAccount(){
        this.checkingBalance = 0;
        this.savingBalance = 0;
        this.accountCount++;

    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public double getSavingBalance(){
        return this.savingBalance;
    }
    public void deposit(double amount, String accountType){
        if(accountType.toLowerCase() == "saving"){
            this.savingBalance += amount;
            this.totalFund += amount;

        } else if (accountType.toLowerCase() == "checking"){
            this.checkingBalance += amount;
            this.totalFund += amount;
        }
    }

    public void withdraw(double amount, String accountType){
        if(accountType.toLowerCase() == "saving"){
            if(amount <= this.savingBalance){
                this.savingBalance -= amount;
                this.totalFund -= amount;
            } else {
                System.out.println("insufficient funds");
            }
            
        } else if (accountType.toLowerCase() == "checking"){
            if(amount <= this.checkingBalance){
                this.checkingBalance -= amount;
                this.totalFund -= amount;
            } else {
                System.out.println("insufficient funds");
            }
        }
    }

    public double totalBalance(){
        return this.savingBalance + this.checkingBalance;
    }
}