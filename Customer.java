import java.util.*;

public class Customer {
	int customerId;
    String name;
    String phone;
    List<Account> accounts;
    
    Customer(int customerId, String name, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.accounts = new ArrayList<>();
        
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
        
    }

    public boolean authenticate(int enteredPin, int accNo) {
        for (Account acc : accounts) {
            if (acc.accountNumber == accNo && acc.pin == enteredPin) {
                return true;
            }
        }
        return false;
    }

    public Account getAccount(int accNo) {
        for (Account acc : accounts) {
            if (acc.accountNumber == accNo) return acc;
        }
        return null;
    }

    

    
 }



