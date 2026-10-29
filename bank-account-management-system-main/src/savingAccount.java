public class savingAccount extends bankAccount{
    private double maxWithdrawal = 1000.0;
    private double interestRate = 0.04;

    // Constructor using super() to call parent constructor
public savingAccount (String customerName, double balance){
    super(customerName, balance);
}

public savingAccount(String customerName, double balance, double maxWithdrawal, double interestRate) {
        super(customerName, balance);
        this.maxWithdrawal = maxWithdrawal;
        this.interestRate = interestRate;
}

    // Public getter methods
public double getMaxWithdrawal() {
    return maxWithdrawal;
}

public double getInterestRate() {
    return interestRate;
}
    // Calculates interest based on current balance getter
    public double calculateInterest(){
    return balance * interestRate;
}

    // Applies interest using parent's deposit method
public void applyInterest (){
    double interest = calculateInterest();
    deposit(interest);
    }

    // Overridden withdraw method with transaction limit
@Override
public void withdraw(double amount){
    if (amount > maxWithdrawal){
        System.out.println("Can't withdraw more than sek" + maxWithdrawal + " per transaction. ");
    } else{
        super.withdraw(amount);}
}

//Display account details
@Override
public void displayAccInfo(){
    super.displayAccInfo();
    System.out.println("Interest rate: " + (interestRate * 100) + "%");
    System.out.println("Customer Name: "+ getCustomerName() +"\nBalance after withdrawal: " + getBalance());
    }

}
