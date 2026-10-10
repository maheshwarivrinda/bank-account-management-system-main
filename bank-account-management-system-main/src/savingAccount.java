public class savingAccount extends bankAccount{

double maxWithdrawal;
double interest;

public savingAccount (String customerName, double balance){
    super(customerName, balance);
}

@Override

public void withdraw(double amount){
    if(amount <= 0) {
        System.out.println("Withdrawal must be positive.");
    }
    else if (amount < balance){
        System.out.println("Insufficient balance");
        }
    else if (maxWithdrawal<= 1000){
        System.out.println("Can't withdraw more than 1000.");
    } else{
        balance-= amount;}
}

@Override
    public void displayAccInfo(){
    System.out.println("Customer Name: "+ customerName +"\nBalance after withdrawal: " + balance);
    }

}
