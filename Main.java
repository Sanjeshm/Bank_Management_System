import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank("001", "MyBank");

        Customer customer = new Customer(1, "Ram", "9874536321");
        Account acc1 = bank.createAccount(101, "Ram", 5000, "SAVINGS", 1212);
        Account acc2 = bank.createAccount(102, "Ram", 3000, "SAVINGS", 1212);

        customer.addAccount(acc1);
        customer.addAccount(acc2);
        
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (!customer.authenticate(pin, accNo)) {
            System.out.println("Authentication Failed");
            sc.close();
            return;
            
        }

        Account current = customer.getAccount(accNo);
        MiniStatement ms = new MiniStatement();

        System.out.println("Login Successful");

        while (true) {
        	
            System.out.println("\nBalance: " + current.getBalance());
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. View Mini Statement");
            System.out.println("5. Exit");

            int ch = sc.nextInt();

            if (ch == 5) break;

            if(ch == 4){
                ms.generate();
                continue;
            }

            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();

            Transaction t = null;

            switch (ch) {
                case 1:
                    t = new Transaction(null, current, amt, "DEPOSIT");
                    break;

                case 2:
                    t = new Transaction(current, null, amt, "WITHDRAW");
                    break;

                case 3:
                    System.out.print("Enter receiver account number: ");
                    int toAccNo = sc.nextInt();
                    Account toAcc = customer.getAccount(toAccNo);

                    if (toAcc == null) {
                        System.out.println("Invalid account");
                        continue;
                    }

                    t = new Transaction(current, toAcc, amt, "TRANSFER");
                    break;
                
                	
                default:
                    System.out.println("Invalid choice");
                    continue;
            }

            if (t.execute()) {
                System.out.println("Transaction Successful");
                ms.addTransaction(t);
            } else {
                System.out.println("Transaction Failed");
            }

            t.getReceipt();
        }
    sc.close();

        
    }
}
