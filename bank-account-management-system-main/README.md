# Bank-account-management-system

## Project Idea

A bank management system that manages different types of bank accounts (Savings, Current, and Revolving Credit) within a
unified polymorphic collection. The application allows users to view accounts, create accounts, deposit funds, withdraw 
funds, repay credit lines, and remove accounts cleanly while handling invalid user inputs gracefully.

## Superclass
* **Name:** `bankAccount`
* **Common Fields:** `customerName` (String), `balance` (double)
* **Common Methods:** `getCustomerName()`, `getBalance()`, `deposit(double amount)`, `withdraw(double amount)`, `displayAccInfo()`.

## Subclasses
* **`savingAccount`** 
    * It includes a maximum withdrawal limit per transaction (`maxwithdrawal = 1000.0 sek`), an interest rate 
(`interest rate = 0.04`), and a method to calculate and apply interest (`applyInterest()`).
    * Overridden Methods used are `withdraw(double amount)` and `displayAccInfo()`. 


* **`currentAccount`** 
    * It features an overdraft limit(`overdraftLimit`) allowing balances to go below zero down to (`-overdraftLimit`).
  Implements (`feeCalculable`) to apply monthly fees when overdrawn.
    * Overridden methods are `withdraw(double amount)`, `displayAccInfo()`, `calculateMonthlyFee()` and `applyMonthlyFee()`.


* **`revolvingCreditAccount`**
    * It operates as a credit line with a total `creditLimit` , available credit (`balance`), and tracked credit debt 
  (`getCreditUsed()`). Features a unique `repay(double amount)` method to pay off owed debt and restore available credit.
      * Overridden methods are `withdraw(double amount)`, `displayAccInfo()`, `calculateMonthlyFee()` and `applyMonthlyFee()`.


## Interface
* **Name:** `feeCalculable`
* **Methods:** `double calculateMonthlyFee()`, `void applyMonthlyFee()`.
* **Implemented by:** `CurrentAccount`, `RevolvingCreditAccount`


## Meny

1. **Display All Accounts**
2. **Create an Account**
3. **Deposit Money**
4. **Withdraw Money**
5. **Repay Credit**
6. **Remove an account**
7. **Exit**


## Error Scenarios

* **Invalid Scanner Input Types:**  
    Try typing letters (e.g., \`'a'\`) when prompted for menu choices or monetary amounts. Used `Try-Catch` which print
an error message, and invoke `scanner.nextLine()` to clear the invalid token from the input buffer so the program doesn't
crash and instead start the loop again (Meny).


* **Violating account constraints:**  
    Trying to withdraw more than 1000 SEK from a `SavingsAccount`, attempts to overdraw a `CurrentAccount` beyond its overdraft
limit, or tries to repay more credit than is actually owed on a `RevolvingCreditAccount`. Used conditional checks inside methods 
to validate inputs against account attributes before execution and output clear rejection messages if constraints are violated.