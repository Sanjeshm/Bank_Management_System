public class Bank {
	String bankCode;
    String name;

    Bank(String bankCode, String name) {
        this.bankCode = bankCode;
        this.name = name;
    }

    public Account createAccount(int accNo, String holdername, double balance, String type, int pin) {
        return new Account(accNo, holdername, balance, type, pin);
    }

    public void closeAccount(Account acc) {
        acc.status = "CLOSED";
    }

}
