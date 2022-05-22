package Accounts;

public class Savings extends Account {
    public Savings(String name, String type, double initialAmount) {
        super(name, type, initialAmount);
    }

    @Override
    public void withdraw(double amount) {
        if (super.getInitialAmount()-amount > 1000)
            super.withdraw(amount);
        else
            System.out.println("Invalid request. This much withdrawal results to a deposit of less than 1000$.");
    }

    @Override
    public void requestLoan(double amount) {
        if (amount > 10000)
            System.out.println("Invalid request. Maximum allowable loan is 10,000$.");
        else super.requestLoan(amount);
    }
}
