import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creates a new Scanner object
        float balance = 100; // User balance

        System.out.println("----- Greetings! -----");
        System.out.println("- Available Actions -");
        System.out.println("1 - Add Money");
        System.out.println("2 - Withdraw Money");
        System.out.println("3 - Check Balance");
        System.out.println("4 - Exit");

        while (true) {
            System.out.print("Input the action: ");
            int userAction = scanner.nextInt();

            // Add money to the balance
            if (userAction == 1) {
                System.out.print("How much would you like to add: ");
                float userAdd = scanner.nextFloat(); // Reads user input
                if (userAdd > 0) { // Check if user writes a positive amount
                    balance = balance + userAdd;
                }
                else {
                    System.out.println("Please use a valid amount!");
                    continue; 
                }
            }

            // Withdraw money from the balance
            if (userAction == 2) {
                System.out.print("How much would you like to withdraw: ");
                float userWithdraw = scanner.nextFloat();
                if (userWithdraw > 0) {
                    balance = balance - userWithdraw;                
                }
                else {
                    System.out.println("Please use a valid amount!");
                    continue;
                }
            }

            // Check the balance
            if (userAction == 3) {
                System.out.println("Your balance is: " + balance);
            }

            // Exits the program
            if (userAction == 4) {
                System.out.println("-- Goodbye! --");
                break; // Stops the program
            }
        }
    }  
}