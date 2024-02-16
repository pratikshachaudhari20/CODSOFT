package task4;

public class ATM {
	private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
    }

    public void withdraw(double amount) {
        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: " + bankAccount.checkBalance());
        }
    }

    public void deposit(double amount) {
        if (bankAccount.deposit(amount)) {
            System.out.println("Deposit successful. New balance: " + bankAccount.checkBalance());
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + bankAccount.checkBalance());
}
}