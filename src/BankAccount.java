public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public BankAccount() {
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Insufficient funds");
            return;
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
