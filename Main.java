import BankAndEmployees.Bank;
import BankAndEmployees.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
        Bank b = new Bank();
        String currentUser = null;
        int user = 0;

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line = br.readLine();
        while (line != null) {
            line = line.trim();
            String[] p = line.split("\\s+|\\t+");
            String operation = p[0].toLowerCase();
            if (operation.equals("create")){
                b.createAccount(p[1], p[2], Double.parseDouble(p[3]));
                currentUser = p[1];
                user = 1;
            }
            else if (operation.equals("deposit")){
                b.addValue(Double.parseDouble(p[1]), currentUser);
            }
            else if (operation.equals("withdraw")){
                b.reduceValue(Double.parseDouble(p[1]), currentUser);
            }
            else if (operation.equals("query")){
                b.getAccount(currentUser).query();
            }
            else if (operation.equals("request")){
                b.getAccount(currentUser).requestLoan(Double.parseDouble(p[1]));
            }
            else if (operation.equals("open")){
                currentUser = p[1];
                if (currentUser != null && b.getEmployees(currentUser) != null) {
                    System.out.print(currentUser+" active, ");
                    user = 2;
                    Employee e = b.getEmployees(currentUser);
                    if (b.getLoanRequestState())
                        System.out.println("there are loan approvals pending.");
                    else System.out.println();
                }
                else if (currentUser != null && b.getAccount(currentUser) != null){
                    System.out.println("Welcome back, "+currentUser);
                    user = 1;
                }
                else if (currentUser != null && b.getFrozenAccount(currentUser))
                    System.out.println("Sorry your account has been frozen. For more info please contact us.");
                else System.out.println("Sorry no such account with that name.");
            }
            else if (operation.equals("close")){
                if (user == 1)
                    System.out.println("Transaction closed for "+currentUser);
                else if (user == 2)
                    System.out.println("Operations closed for "+currentUser);
                currentUser = null;
                user = 0;
            }
            else if (operation.equals("approve")){
                b.getEmployees(currentUser).approveLoan();
            }
            else if (operation.equals("change")){
                b.getEmployees(currentUser).changeInterestRate(p[1], Double.parseDouble(p[2]));
            }
            else if (operation.equals("lookup")){
                b.getEmployees(currentUser).lookUp(p[1]);
            }
            else if (operation.equals("see")){
                b.getEmployees(currentUser).seeInternalFund();
            }
            else if (operation.equals("inc")){
                b.incrementYear();
            }
            line = br.readLine();
        }

        br.close();
    }
}
