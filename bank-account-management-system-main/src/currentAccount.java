public class currentAccount extends bankAccount implements feeCalculable{


    private double overdraftLimit;

    public currentAccount(String customerName, double balance, double overdraftLimit){
        super(customerName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Public getter methods
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
    public double calculateMonthlyFee(){
        return (getBalance() < 0) ? 5.0 : 0.0; // Fee of 5.0 SEK applied only if balance is negative
    }

    @Override

    public void applyMonthlyFee(){
        double fee= calculateMonthlyFee();
        if (fee > 0){
            balance -= fee;
            System.out.println("Monthly fee of sek" + fee + " applied.");
        }
    }

    @Override
    public void withdraw(double amount){
        if (amount <= 0){
            System.out.println("Withdrawal must be positive");
        }else if ((getBalance()- amount) < -overdraftLimit){
            System.out.println("Transaction rejected");
        } else{
            balance -= amount;
            System.out.println(("Withdrew sek" + amount + " and remaining balance is sek" + getBalance()));
        }

    }
// Display account details
    @Override
    public void displayAccInfo(){
        super.displayAccInfo();
        System.out.println("Overdraft Limit: sek" + overdraftLimit );
        System.out.println("Total available amount : sek"+ (getBalance() + overdraftLimit));
    }

}
