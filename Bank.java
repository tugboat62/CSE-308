package BankAndEmployees;

import Accounts.*;

import java.util.HashMap;
import java.util.LinkedList;

public class Bank {
    private double budget;
    private HashMap<String, Employee> employees;
    private HashMap<String, Account> accounts;
    private HashMap<String, Account> frozenAccounts;
    private LinkedList<Account.Request> loanRequests;
    private boolean hasLoanRequest;
    private int years;
    private double studentInterestRate;
    private double savingsInterestRate;
    private double fixedInterestRate;

    public Bank() {
        this.budget = 1000000;
        employees = new HashMap<>();
        accounts = new HashMap<>();
        frozenAccounts = new HashMap<>();
        loanRequests = new LinkedList<>();
        this.employees.put("MD", new Employee("MD", "Managing Director", this));
        this.employees.put("S1", new Employee("S1", "Officer", this));
        this.employees.put("S2", new Employee("S2", "Officer", this));
        this.employees.put("C1", new Employee("C1", "Cashier", this));
        this.employees.put("C2", new Employee("C2", "Cashier", this));
        this.employees.put("C3", new Employee("C3", "Cashier", this));
        this.employees.put("C4", new Employee("C4", "Cashier", this));
        this.employees.put("C5", new Employee("C5", "Cashier", this));
        this.fixedInterestRate = .15;
        this.studentInterestRate = .05;
        this.savingsInterestRate = .1;
        hasLoanRequest = false;
        System.out.println("BankAndEmployees.Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created");
    }

    public void createAccount(String name, String type, double amount) {
        if (accounts.containsKey(name))
            System.out.println("Already an account with the name exists");
        else {
            if (type.equals("Fixed") && amount < 100000)
                System.out.println("You have to deposit at least 100000$.");
            else if (type.equals("Fixed")){
                Account a = new Fixed(name, type, amount);
                accounts.put(name, a);
                a.setBank(this);
                System.out.println("Your account is created with name "+name+" successfully. Current balance " + amount + "$");
            }
            switch (type) {
                case "Loan" -> {
                    Account a = new Loan(name, type, amount);
                    accounts.put(name, a);
                    a.setBank(this);
                    System.out.println("Your account is created with name " + name + " successfully. Current balance " + amount + "$");
                }
                case "Student" -> {
                    Account a = new Student(name, type, amount);
                    accounts.put(name, a);
                    a.setBank(this);
                    System.out.println("Your account is created with name " + name + " successfully. Current balance " + amount + "$");
                }
                case "Savings" -> {
                    Account a = new Savings(name, type, amount);
                    accounts.put(name, a);
                    a.setBank(this);
                    System.out.println("Your account is created with name " + name + " successfully. Current balance " + amount + "$");
                }
            }
        }
    }

    protected void lookUpForAccount(String accName) {
        if (accounts.containsKey(accName)) {
            double loan = accounts.get(accName).getLoanAmount();
            if (loan > 0)
                System.out.println(accName + " has a total deposit of " + accounts.get(accName).getInitialAmount() + "$."+
                    " .Loan is "+loan+"$.");
            else System.out.println(accName + " has a total deposit of " + accounts.get(accName).getInitialAmount() + "$.");
        } else {
            System.out.println("No such account with that name exists.");
        }
    }

    public void addLoanRequest (Account.Request request) {
        loanRequests.add(request);
        hasLoanRequest = true;
    }

    public boolean getLoanRequestState() {
        return hasLoanRequest;
    }

    protected void approveLoanRequests () {
        if(!loanRequests.isEmpty()) {
            Account.Request request = loanRequests.remove();
            double sum = 0;
            for (String key: accounts.keySet())
                sum += accounts.get(key).getInitialAmount();

            if (budget >= request.loan+sum) {
                accounts.get(request.name).setLoanAmount(request.loan);
                budget -= request.loan;
                System.out.println("Loan request of "+request.name+" approved with amount "+request.loan+"$.");
            }
            else System.out.println("Sorry your loan request was not approved.");
            if (loanRequests.isEmpty()) hasLoanRequest = false;
        }
        else System.out.println("No new request to  approve.");
    }

    protected void setNewInterestRate(String accType, double rate) {
        switch (accType) {
            case "Savings" -> savingsInterestRate = rate;
            case "Student" -> studentInterestRate = rate;
            case "Fixed" -> fixedInterestRate = rate;
        }
    }

    protected double getInternalFund() {
        return budget;
    }

    public Account getAccount(String name) {
        return accounts.get(name);
    }

    public Employee getEmployees(String name) {
        return employees.get(name);
    }

    public void incrementYear() {
        years += 1;
        System.out.println("1 year passed");
        for (String key: accounts.keySet()) {
            Account a = accounts.get(key);
            double balance = a.getInitialAmount();
            double loan = a.getLoanAmount();
            double indicator;
            String type = a.getType();
            if (type.equals("Loan")) indicator = balance+.1*balance+500;
            else indicator = balance-500-loan*.1;
            if (type.equals("Student") && indicator+studentInterestRate*balance >= 0)
                budget += a.setBalance(studentInterestRate);
            else if (type.equals("Fixed") && indicator+fixedInterestRate*balance >= 0)
                budget += a.setBalance(fixedInterestRate);
            else if (type.equals("Savings") && indicator+savingsInterestRate*balance >= 0)
                budget += a.setBalance(savingsInterestRate);
            else {
                accounts.remove(key);
                frozenAccounts.put(key, a);
            }
        }
    }

    public void addValue(double amount, String name) {
        budget += amount;
        Account a = accounts.get(name);
        a.deposit(amount);
    }

    public boolean getFrozenAccount(String name) {
        return frozenAccounts.containsKey(name);
    }

    public void reduceValue(double amount, String name) {
        budget -= amount;
        Account a = accounts.get(name);
        a.withdraw(amount);
    }
}
