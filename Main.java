import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

class Main {

    private static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Account loggedInAccount = null;

        BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            accounts.add(new Account(parts[0], parts[1], Double.parseDouble(parts[2])));
        }
        reader.close();

        System.out.println("----- Greetings! -----");
        System.out.println("- Available options -");
        System.out.println("1 - Create an account");
        System.out.println("2 - Log in");

        System.out.print("Please choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            System.out.println("Please create your account!");

            System.out.print("Please enter your username: ");
            String regUsername = scanner.nextLine();

            System.out.print("Please enter your password: ");
            String regPassword = scanner.nextLine();

            Account newAccount = new Account(regUsername, regPassword, 0);
            accounts.add(newAccount);

            FileWriter writer = new FileWriter("accounts.txt", true);
            writer.write(regUsername + "," + regPassword + ",0.0\n");
            writer.close();

            System.out.println("Your account has been created! Please log in!");
        }
        else if (option == 2) {
            System.out.println("Please log in your account!");

            System.out.print("Please enter your username: ");
            String logUsername = scanner.nextLine();

            System.out.print("Please enter your password: ");
            String logPassword = scanner.nextLine();

            for (Account account : accounts) {
                if (account.getUsername().equals(logUsername) && account.getPassword().equals(logPassword)) {
                    loggedInAccount = account;
                    break;
                }
            }

            if (loggedInAccount != null) {
                System.out.println("Login Successful!");
            }
            else {
                System.out.println("Login failed.. Try again!");
            }
        }
        else {
            System.out.println("Please choose a correct action!");
        }

        while (loggedInAccount != null) {

            System.out.println("- Available Actions -");
            System.out.println("1 - Add Money");
            System.out.println("2 - Withdraw Money");
            System.out.println("3 - Check Balance");
            System.out.println("4 - Exit");

            System.out.print("Input the action: ");
            int userAction = scanner.nextInt();

            switch (userAction) {

                case 1:
                    System.out.print("How much would you like to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    loggedInAccount.deposit(depositAmount);
                break;

                case 2:
                    System.out.print("How much would you like to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    loggedInAccount.withdraw(withdrawAmount);
                break;

                case 3:
                    loggedInAccount.getBalance();
                break;

                case 4:
                    loggedInAccount.exit();
                return;

                default:
                    System.out.println("Please choose an available action!");
                    break;
            }
        }
    }
}