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
                "\n\n========== RESTAURANT ORDER MANAGEMENT SYSTEM ==========\n\n" + 
                "1. Add Menu Item\n" + 
                "2. View Menu\n" + 
                "3. Search Menu Item\n" +
                "4. Register Customer\n" +
                "5. View Customers\n" + 
                "6. Create Order\n" + 
                "7. Add Item to Order\n" + 
                "8. Remove Item from Order\n" + 
                "9. View Order\n" + 
                "10. View All Orders\n" + 
                "11. Update Order Status\n" +
                "12. Calculate/View Bill\n" + 
                "13. View Customer Orders\n" + 
                "14. Exit");

                int choice = sc.nextInt();
                sc.nextLine();

                switch(choice)
                {
                    case 1:
                        handler.addMenuItem();
                        break;
                    case 2:
                        handler.viewMenu();
                        break;
                    case 3:
                        handler.searchMenuItem();
                        break;
                    case 4:
                        handler.registerCustomer();
                        break;
                    case 5:
                        handler.viewCustomers();
                        break;
                    case 6:
                        handler.createOrder();
                        break;
                    case 7:
                        handler.addItemToOrder();
                        break;
                    case 8:
                        handler.removeItemFromOrder();
                        break;
                    case 9:
                        handler.viewOrder();
                        break;
                    case 10:
                        handler.viewAllOrders();
                        break;
                    case 11:
                        handler.updateOrderStatus();
                        break;
                    case 12:
                        handler.calculateBill();
                        break;
                    case 13:
                        handler.viewCustomerOrders();
                        break;
                    case 14:
                        System.out.println("Exiting... Thank you!");
                        stop = true;
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");

                }
        }

        sc.close();

    }
}