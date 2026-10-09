public class bankAccount {

    String customerName;
    double balance;

    public bankAccount(String customerName, int balance) {
        this.customerName = customerName;
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("Balance cannot be negative.");
        } else{
        balance+= amount;}
    }

    public void withdraw(double amount){
        if(amount <= 0) {
            System.out.println("Withdrawal must be positive.");
        }
        else if (amount > balance){
            System.out.println("Insufficient balance");
        } else{
        balance-= amount;}
    }

    public void displayAccInfo (){
        System.out.println("Customer Name: "+ customerName +"\nBalance: " + balance);
    }



}
