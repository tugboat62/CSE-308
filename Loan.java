package Accounts;

public class Loan extends Account{
    public Loan(String name, String type, double initialAmount) {
        super(name, type, initialAmount);
    }

    @Override
    public void deposit(double amount) {
        if (getInitialAmount() < amount)
            System.out.println("You cannot deposit this amount of money.");
        else super.deposit(-amount);
    }

    @Override
    public void requestLoan(double amount) {
        double allowable = super.getInitialAmount()*.05;
        if (amount > allowable)
            System.out.println("Invalid request. Maximum allowable loan is "+allowable+"$.");
        else super.requestLoan(amount);
    }
}
