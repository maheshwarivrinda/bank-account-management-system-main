public class revolvingCreditAccount extends bankAccount{

    double creditLimit;

    public revolvingCreditAccount (String customerName, double balance){
        super(customerName, balance);}

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getAvailableCredit(){
        return getBalance();
    }

    public double getCreditUsed(){
        return creditLimit - getBalance();
    }

    @Override
    public void withdraw(double amount){
        if (amount <= 0 ){
           System.out.println("Withdrawal amount must be positive");
        } else if (amount > getBalance()){
            System.out.println("Insufficient available credit");
        } else {
            balance -= amount;
            System.out.println("Spent sek" + amount + ", available credit id sek " + getAvailableCredit() + "Owed sek "+ getCreditUsed() );}
    }

    public void repay(double amount){
        if (amount <= 0 ){
            System.out.println("Repayment must be greater than zero");
        }else if (amount > balance){
            System.out.println("Cannot repay more than what is owed");
        }else{ balance -= amount;
            System.out.println();}
    }

    @Override
    public void displayAccInfo(){
        super.displayAccInfo();
        System.out.println("Credit Limit: sek" + creditLimit  );
        System.out.println("Available credit: sek" + balance);
        System.out.println("Credit Used: sek" + getCreditUsed());
    }
}
