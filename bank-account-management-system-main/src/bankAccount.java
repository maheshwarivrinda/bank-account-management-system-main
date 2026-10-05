public class bankAccount {

    int deposit;
    int withdraw;
    int balance;
    String displayAccInfo;

    public bankAccount(int deposit, int withdraw, int balance, String displayAccInfo) {
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.balance = balance;
        this.displayAccInfo = displayAccInfo;
    }

    public int getDeposit(){
        return deposit;
    }

    public int getWithdraw(){
        return withdraw;
    }

}
