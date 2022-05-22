package Accounts;

public class Fixed extends Account{
    public Fixed(String name, String type, double initialAmount) {
        super(name, type, initialAmount);
    }

    @Override
    public void deposit(double amount){
        if (amount < 50000)
            System.out.println("Invalid request. You have to deposit at least 50000$.");
        else super.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        if (super.getYear() >= 1)
            super.withdraw(amount);
        else
            System.out.println("Invalid request. You account was created less than 1 year from now.");
    }

    @Override
    public void requestLoan(double amount) {
        if (amount > 100000)
            System.out.println("Invalid request. Maximum allowable loan is 100,000$.");
        else super.requestLoan(amount);
    }
}
