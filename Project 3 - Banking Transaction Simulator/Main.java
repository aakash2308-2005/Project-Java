import java.util.Scanner;
import java.util.InputMismatchException;

class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Handler handler = new Handler();
        boolean notStop = true;

        while (notStop)
        {
            System.out.println("===== BANKING TRANSACTION SIMULATOR =====\n\n");
            System.out.println(
                "1. Create Account\n"+
                "2. Deposit Money\n"+
                "3. Withdraw Money\n"+
                "4. Check Balance\n"+
                "5. Transfer Money\n"+
                "6. Display Account Details\n"+
                "7. Transaction History\n"+
                "8. Exit\n\n");

            System.out.print("Enter choice:");
            int choice;
            
            while (true)
            {
                try {
                    choice = sc.nextInt();
                    break;
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Invalid choice.\nPlease try again.");
                    sc.nextLine();
                }
            }

            switch (choice)
            {
                case 1:
                    handler.createAccount();
                    break;

                case 2:
                    handler.depositMoney();
                    break;

                case 3:
                    handler.withdrawMoney();
                    break;

                case 4:
                    handler.checkBalance();
                    break;

                case 5:
                    handler.transferBalance();
                    break;

                case 6:
                    handler.displayAccountDetails();
                    break;

                case 7:
                    handler.transactionHistory();
                    break;

                case 8:
                    System.out.println("Thank you for using Banking Transaction Simulator.\nGoodbye!");
                    notStop = false;
                    break;

                default:
                    System.out.println("Invalid choice.\nPlease try again.");
                    break;
            }
        }
    }
}