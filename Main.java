import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        float balance = 100; 

        System.out.println("----- Greetings! -----");

        while (true) {

            System.out.println("- Available Actions -");
            System.out.println("1 - Add Money");
            System.out.println("2 - Withdraw Money");
            System.out.println("3 - Check Balance");
            System.out.println("4 - Exit");

            System.out.print("Input the action: ");
            int userAction = scanner.nextInt();

            switch (userAction) {

                // Add money to the balance
                case 1:
                    System.out.print("How much would you like to add: ");
                    float userAdd = scanner.nextFloat(); 
                    if (userAdd > 0) { 
                        balance = balance + userAdd;
                    }
                    else {
                        System.out.println("Please use a valid amount!");
                    }
                break;

                // Withdraw money from the balance
                case 2:
                    System.out.print("How much Awould you like to withdraw: ");
                    float userWithdraw = scanner.nextFloat();
                    if (userWithdraw > 0) {
                        balance = balance - userWithdraw;                
                    }
                    else {
                        System.out.println("Please use a valid amount!");
                    }
                break;

                // Check the balance
                case 3:
                    System.out.println("Your balance is: " + balance);
                break;

                // Exits the program
                case 4:
                    System.out.println("-- Goodbye! --");
                return;

                // If invalid action
                default:
                    System.out.println("Please choose an available action!");
                    break;
            }
        }
    }  
}