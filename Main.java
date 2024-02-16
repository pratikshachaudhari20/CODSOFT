package task4;

import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) {
            System.out.println("\nATM Options:");
            atm.displayOptions();

            System.out.print("Enter option (1-3, or 'q' to quit): ");
            String choice = sc.next();

            if (choice.equals("q")) {
            	System.out.println("Exiting ATM");
                break;
            }

            try {
                int option = Integer.parseInt(choice);
                switch (option) {
                    case 1:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        atm.checkBalance();
                        break;
                     
                    default:
                        System.out.println("Invalid option. Please choose a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        sc.close();
    }
}
