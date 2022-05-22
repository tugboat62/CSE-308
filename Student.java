package Accounts;

public class Student extends Account{
    public Student(String name, String type, double initialAmount) {
        super(name, type, initialAmount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 10000)
            System.out.println("Invalid request.");
        else super.withdraw(amount);
    }

    @Override
    public void requestLoan(double amount) {
        if (amount > 1000)
            System.out.println("Invalid request. Maximum allowable loan is 1000$.");
        else super.requestLoan(amount);
    }
}
