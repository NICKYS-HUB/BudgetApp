import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

class BudgetApp {
    private double balance;
    private ArrayList<Transaction> transactions;

    public BudgetApp() {
        balance = 0;
        transactions = new ArrayList<>();
    }

    public void addIncome(double amount) {
        balance += amount;
        transactions.add(new Transaction("Income", amount));
    }

    public void addExpense(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Expense cannot be added.");
            return;
        }
        balance -= amount;
        transactions.add(new Transaction("Expense", -amount));
    }

    public void viewTransactions() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDescription() + ": $" + transaction.getAmount());
        }
    }

    public void viewBalance() {
        System.out.println("Current Balance: $" + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BudgetApp budgetApp = new BudgetApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter income amount: $");
                    double incomeAmount = scanner.nextDouble();
                    budgetApp.addIncome(incomeAmount);
                    break;
                case 2:
                    System.out.print("Enter expense amount: $");
                    double expenseAmount = scanner.nextDouble();
                    budgetApp.addExpense(expenseAmount);
                    break;
                case 3:
                    budgetApp.viewTransactions();
                    break;
                case 4:
                    budgetApp.viewBalance();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
