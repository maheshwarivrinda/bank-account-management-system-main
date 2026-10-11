public class bankAccount {

    String accountNumber;
    String customerName;
    double balance;

    public bankAccount(String accountNumber, String customerName, double balance) {
        this.customerName = customerName;
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("Balance cannot be negative.");
        } else{
        balance+= amount;
        System.out.println("Deposited: sek" + amount + ". New Balance: sek" + balance);}
    }

    public void withdraw(double amount){
        if(amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        }
        else if (amount > balance){
            System.out.println("Insufficient balance.");
        } else{
        balance-= amount;
        System.out.println("Withdrew: sek" + amount + ". Remaining balance : sek" + balance);}
    }

    public void displayAccInfo (){
        System.out.println("Customer Name: "+ customerName +"\nBalance: " + balance);
    }


}
