package BankAndEmployees;

public class Employee {
    public Bank currentBank;
    private String name;
    private String type;

    Employee(String name, String type, Bank bank) {
        this.name = name;
        this.currentBank = bank;
        this.type = type;
    }

    public void lookUp (String accName) {
        currentBank.lookUpForAccount(accName);
    }

    public void approveLoan() {
        if (type.equals("Cashier"))
            System.out.println("You don't have permission for this operation.");
        else currentBank.approveLoanRequests();
    }

    public void changeInterestRate (String accType, double rate) {
        if (type.equals("Managing Director")) {
            currentBank.setNewInterestRate(accType, rate);
        } else System.out.println("You don't have permission for this operation.");
    }

    public void seeInternalFund () {
        if (type.equals("Managing Director"))
            System.out.println("Internal fund is "+currentBank.getInternalFund()+"$.");
        else System.out.println("You don't have permission for this operation.");
    }
}
