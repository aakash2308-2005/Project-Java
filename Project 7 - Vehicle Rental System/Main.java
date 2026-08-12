import java.util.Scanner;

public class Main{

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Handler handler = new Handler(sc);

        boolean stop = false;

        while (!stop)
        {
            System.out.println(
            "\n\n===== VEHICLE RENTAL SYSTEM =====\n" +
            "1. Add Vehicle\n" + 
            "2. Register Customer\n" +
            "3. View Available Vehicles\n" +
            "4. View All Vehicles\n" +
            "5. Rent Vehicle\n" +
            "6. Return Vehicle\n" +
            "7. View All Rentals\n" +
            "8. View Customer Details\n" +
            "9. View Vehicle Details\n" +
            "10. Exit\n");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:
                    handler.addVehicle();
                    break;

                case 2:
                    handler.registerCustomer();
                    break;

                case 3:
                    handler.viewAvailableVehicles();
                    break;

                case 4:
                    handler.viewAllVehicles();
                    break;

                case 5:
                    handler.rentVehicle();
                    break;

                case 6:
                    handler.returnVehicle();
                    break;

                case 7:
                    handler.viewAllRentals();
                    break;

                case 8:
                    handler.viewCustomerDetails();
                    break;

                case 9:
                    handler.viewVehicleDetails();
                    break;

                case 10:
                    stop = true;
                    System.out.println("GoodBye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

    }
}