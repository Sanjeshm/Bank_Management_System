import java.util.*;

public class Transaction {
    static int count = 1;
    int txnId;
    Account fromAccount;
    Account toAccount;
    double amount;
    String type;
    Date timestamp;
    String status;

    Transaction(Account fromAccount, Account toAccount, double amount, String type) {
        this.txnId = count++;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.type = type;
        this.timestamp = new Date();
        this.status = "PENDING";
    }

    public boolean execute() {
        switch (type) {
            case "DEPOSIT":
                toAccount.deposit(amount);
                status = "SUCCESS";
                return true;

            case "WITHDRAW":
                if (fromAccount.withdraw(amount)) {
                    status = "SUCCESS";
                    return true;
                }
                break;

            case "TRANSFER":
                if (fromAccount.withdraw(amount)) {
                    toAccount.deposit(amount);
                    status = "SUCCESS";
                    return true;
                }
                break;
        }
        status = "FAILED";
        return false;
    }

    

    public void getReceipt() {
        System.out.println("TxnID: " + txnId +" | Type: " + type +" | Amount: " + amount +" | Status: " + status +" | Time: " + timestamp);
    }
}
