public class Account {
	int accountNumber;
    String holderName;
    double balance;
    String accountType;
    String status;
    int pin;

    Account(int accountNumber, String holderName, double balance, String accountType, int pin) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.accountType = accountType;
        this.status = "ACTIVE";
        this.pin = pin;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

}
