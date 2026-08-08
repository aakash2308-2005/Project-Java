import java.util.Scanner;

public class Main{

    public static void main(String args[])
    {
        boolean notStop = true;
        Scanner sc = new Scanner(System.in);
        Handler handler = new Handler();

        while (notStop)
        {
            System.out.println(
                "===== ELECTRIC BILL CALCULATOR =====\n\n" + 
                "1. Calculate Electricity Bill\n" +
                "2. Display Customer Bills\n" + 
                "3. Exit\n");
            
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            System.out.println();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    handler.calculateElectricityBill();
                    break;

                case 2:
                    handler.displayCustomerBills();
                    break;

                case 3:
                    System.out.println("GoodBye!");
                    notStop = false;
                    break;

                default:
                    System.out.println("Invalid menu choice");
                    break;
            }
        }
    }
}