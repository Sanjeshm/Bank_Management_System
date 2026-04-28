import java.util.*;

public class MiniStatement {

    List<Transaction> transactions;

    public MiniStatement() {
        transactions = new ArrayList<>();
    }

    
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    
    public void generate() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\n MINI STATEMENT ");
        for (Transaction t : transactions) {
            t.getReceipt();
        }
    }

    
}
