public class bankAccount {

    String customerName;
    double balance;

    public bankAccount(String customerName, int balance) {
        this.customerName = customerName;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance+= amount;
    }

    public void withdraw(double amount){
        balance-= amount;
    }

    public void displayAccInfo (){
        System.out.println("Customer Name: "+ customerName +"\nBalance: " + balance);
    }



}
