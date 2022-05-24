package Accounts;

import BankAndEmployees.Bank;

public class Account {
    private final String name;
    private final String type;
    private int year;
    private double balance;
    private Bank currentBank;
    private double loanAmount;

    Account(String name, String type, double initialAmount) {
        this.name = name;
        this.type = type;
        this.balance = initialAmount;
        this.year = 0;
        this.loanAmount = 0;
    }

    public String getName() {
        return name;
    }

    public void setBank(Bank b) {
        currentBank = b;
    }

    public void query() {
        if (loanAmount > 0)
            System.out.println(name + " has a total deposit of " + balance + "$." +
                    " Account.Loan is " + loanAmount + "$.");
        else System.out.println(name + " has a total deposit of " + balance + "$.");
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public double getInitialAmount() {
        return balance;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount+"$ deposited. Current balance: "+balance+"$.");
    }

    public void withdraw(double amount) {
        if (amount > balance)
            System.out.print("Invalid request. ");
        else {
            balance -= amount;
            System.out.println("Withdrawal successful. ");
            currentBank.reduceValue(amount);
        }
        System.out.println("Current balance: "+balance+"$.");
    }

    public double setBalance(double interestRate) {
        double deduct = 500 + loanAmount*.1;
        balance = balance - deduct + interestRate*balance;
        return deduct;
    }


    public class Request {
        public double loan;
        public String name;

        Request(String name, double loan) {
            this.name = name;
            this.loan = loan;
        }
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void requestLoan(double amount) {
        currentBank.addLoanRequest(new Request(name, amount));
        System.out.println("Your loan request is sent for approval.");
    }

    public void incrementYear() {
        year += 1;
    }
}
