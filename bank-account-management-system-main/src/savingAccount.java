public class savingAccount extends bankAccount{
    private double maxWithdrawal = 1000.0;
    private double interestRate = 0.04;

public savingAccount (String customerName, double balance){
    super(customerName, balance);
}

public savingAccount(String customerName, double balance, double maxWithdrawal, double interestRate) {
        super(customerName, balance);
        this.maxWithdrawal = maxWithdrawal;
        this.interestRate = interestRate;
}

public double getMaxWithdrawal() {
    return maxWithdrawal;
}

public double getInterestRate() {
    return interestRate;
}

    public double calculateInterest(){
    return getBalance() * interestRate;
}

public void applyInterest (){
    double interest = calculateInterest();
    deposit(interest);
    System.out.println("Applied sek" + interest + "in interest.");
}

@Override

public void withdraw(double amount){
    if (amount > maxWithdrawal){
        System.out.println("Can't withdraw more than sek" + maxWithdrawal + " per transaction. ");
    } else{
        super.withdraw(amount);}
}

@Override
public void displayAccInfo(){
    super.displayAccInfo();
    System.out.println("Interest rate: " + (interestRate * 100) + "%");
    System.out.println("Customer Name: "+ getCustomerName() +"\nBalance after withdrawal: " + getBalance());
    }

}
