import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<bankAccount> accounts = new ArrayList<>();
        accounts.add(new savingAccount( "Robin" , 5000));
        accounts.add(new currentAccount("Robin" , 4321, 500));
        accounts.add(new revolvingCreditAccount( "Robin" , 2650));

        boolean running =true;

        while (running) {
            System.out.println(" \n ==== Bank Management System ====");
            System.out.print("1. Display All Accounts");
            System.out.print("2. Create an Account");
            System.out.print("3. Deposit Money");
            System.out.print("4. Withdraw Money / Spend");
            System.out.print("5. Repay Credit (Revolving Credit)");
            System.out.print("6. Remove an Account");
            System.out.print("7. Exit");
            System.out.print("Select an option (1-7): ");

            int choice= scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:

                    System.out.println("=== All Accounts ===");
                    for(bankAccount acc: accounts){
                        acc.displayAccInfo();
                    } break;


                case 2:
                    System.out.println("Select Account Type ");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");
                    System.out.println("3 Revolving Credit Account");
                    System.out.print("Choice: ");

                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();

                    if (type == 1) {
                        System.out.print("Enter Initial Balance: €");
                        double balance= scanner.nextDouble();
                        scanner.nextLine();
                        accounts.add(new savingAccount(name, balance));
                        System.out.println("Savings account created successfully.");

                    } else if( type == 2){
                    System.out.print("Enter Initial Balance: €");
                    double bal = scanner.nextDouble();
                    System.out.print("Enter Overdraft Limit: €");
                    double limit = scanner.nextDouble();
                    scanner.nextLine();
                    accounts.add(new currentAccount(name, bal, limit));
                    System.out.println("Current account created successfully.");

                    }else if (type == 3){
                    System.out.print("Enter Credit Limit: €");
                    double limit = scanner.nextDouble();
                    scanner.nextLine();
                    accounts.add(new revolvingCreditAccount(name, limit));
                    System.out.println("Revolving credit account created successfully.");

                }else{
                        System.out.println("Invalid account type.");
                    } break;

                case 3:
                    if (accounts.isEmpty()){
                        System.out.println("No accounts available.");
                        break;
                    }
                    System.out.print("Enter Customer Name: ");
                    String depName = scanner.nextLine();
                    bankAccount depAcc = findAccount(accounts, depName);

                    if (depAcc != null){
                        System.out.print("Enter Deposit Amount: sek ");
                        try {
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            depAcc.deposit(amount);
                        } catch (InputMismatchException e){
                            System.out.println("Provide a valid amount!");
                            scanner.nextLine();
                        }
                    }else{
                        System.out.println("Customer not found.");
                    }break;

                case 4:
                    if (accounts.isEmpty()){
                        System.out.println("No accounts available.");
                        break;
                    }
                    System.out.print("Enter Customer Name: ");
                    String withName = scanner.nextLine();
                    bankAccount withAcc = findAccount(accounts, withName);

                    if (withAcc != null){
                        System.out.print("Enter Withdrawal Amount: sek ");
                        try {
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            withAcc.withdraw(amount);
                        }catch (InputMismatchException e){
                            System.out.println("Provide a valid amount!");
                            scanner.nextLine();
                        }
                    }else {
                        System.out.println("Customer not found.");
                    }break;

                case 5:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                        break;
                    }System.out.print("Enter Customer Name: ");
                    String repayName = scanner.nextLine();
                    bankAccount repayAcc = findAccount(accounts, repayName);
                    if (repayAcc instanceof revolvingCreditAccount){
                        System.out.print("Enter Repayment Amount: sek ");
                        try {
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            ((revolvingCreditAccount) repayAcc).repay(amount);
                        } catch (InputMismatchException e){
                            System.out.println("Provide a valid amount!");
                            break;
                        }
                    }else if (repayAcc != null){
                        System.out.println("Selected account is not a Revolving Credit Account.");
                    }else{
                        System.out.println("Customer not found.");
                    }break;

                case 6:
                    if (accounts.isEmpty()){
                        System.out.println("No accounts available to remove.");
                        break;
                    }

                    System.out.print("Enter Customer Name to remove: ");
                    String remName = scanner.nextLine();
                    bankAccount remAcc = findAccount(accounts, remName);
                    if (remAcc != null){
                        accounts.remove(remAcc);
                        System.out.println("Account removed successfully.");
                    } else{
                        System.out.println("Customer not found.");
                    }break;

                case 7:
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }

        } scanner.close();

    }public static bankAccount findAccount(ArrayList<bankAccount> accounts, String customerName){
        for (bankAccount acc : accounts) {
            if (acc.getCustomerName().equalsIgnoreCase(customerName.trim())) {
                return acc;
            }
        } return null;


        }

}

