import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            performAction(choice);
        }
    }

    private void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void performAction(int choice) {
        switch (choice) {
            case 1:
                handleWithdraw();
                break;
            case 2:
                handleDeposit();
                break;
            case 3:
                handleCheckBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance is " + account.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is " + account.getBalance());
    }

    private void handleCheckBalance() {
        System.out.println("Your current balance is " + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(account);
        atm.start();
    }
}
