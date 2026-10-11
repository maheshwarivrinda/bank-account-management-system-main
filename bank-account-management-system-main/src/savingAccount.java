public class savingAccount extends bankAccount{

double maxWithdrawal = 1000.0;
double interestRate = 0.04;

public savingAccount (String accountNumber, String customerName, double balance){
    super(accountNumber, customerName, balance);
}

public double calculateInterest(){
    return balance * interestRate;
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
    System.out.println("Customer Name: "+ customerName +"\nBalance after withdrawal: " + balance);
    }

}
