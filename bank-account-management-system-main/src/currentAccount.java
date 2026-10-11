public class currentAccount extends bankAccount {


    double overdraftLimit;

    public currentAccount(String customerName, double balance, double overdraftLimit){
        super(customerName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit){
        if (overdraftLimit < 0){
            System.out.println("Overdraft limit cannot be negative.");
        }
        else{
            this.overdraftLimit= overdraftLimit;
        }

    }

    @Override
    public void withdraw(double amount){
        if (amount <= 0){
            System.out.println("Withdrawal must be positive");
        }else if ((balance- amount) < overdraftLimit){
            System.out.println("Transaction rejected");
        } else{
            balance -= amount;
            System.out.println(("Withdrew sek" + amount + " and remaining balance is sek" + balance));
        }

    }

    @Override
    public void displayAccInfo(){
        super.displayAccInfo();
        System.out.println("Overdraft Limit: sek" + overdraftLimit );
        System.out.println("Total available amount : sek"+ (balance + overdraftLimit));
    }

}
