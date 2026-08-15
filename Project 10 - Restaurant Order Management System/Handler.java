import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.math.BigDecimal;

public class Handler{

    Scanner sc;

    public Handler(Scanner sc)
    {
        this.sc = sc;
    }

    private List<MenuItem> menu = new ArrayList<>();
    private Set<String> itemIds = new HashSet<>();
    private List<Customer> customers = new ArrayList<>();
    private Set<String> customerIds = new HashSet<>();
    private List<Order> orders = new ArrayList<>();
    private Set<String> orderIds = new HashSet<>();

    public void addMenuItem()
    {
        System.out.println("Enter Item id: ");
        String itemId = sc.next();
        sc.nextLine();

        if (itemIds.contains(itemId))
        {
            System.out.println("Item id already exists.");
            return;
        }

        System.out.println("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Category: ");
        String category = sc.nextLine();

        MenuCategory menuCategory;

        if (category.equalsIgnoreCase("STARTER"))
        {
            menuCategory = MenuCategory.STARTER;
        }

        else if (category.equalsIgnoreCase("MAINCOURSE"))
        {
            menuCategory = MenuCategory.MAINCOURSE;
        }

        else if (category.equalsIgnoreCase("DESSERT"))
        {
            menuCategory = MenuCategory.DESSERT;
        }

        else if (category.equalsIgnoreCase("BEVERAGE"))
        {
            menuCategory = MenuCategory.BEVERAGE;
        }

        else
        {
            System.out.println("Wrong Category");
            return;
        }

        System.out.println("Enter Price: ");
        BigDecimal price = new BigDecimal(sc.next());
        sc.nextLine();

        MenuItem item = new MenuItem(itemId, name, menuCategory, price);
        menu.add(item);
        itemIds.add(itemId);
    }

    public void viewMenu()
    {
        if (menu.isEmpty())
        {
            System.out.println("No items are available. Sorry!");
            return;
        }
        System.out.println("ID     Name             Category       Price");
        System.out.println("------------------------------------------------");
        for (MenuItem item : menu)
        {
            System.out.println(item);
        }
    }

    public void searchMenuItem()
    {
        System.out.println("1.Item id/2.Item name");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1)
        {
            System.out.println("Enter Item id: ");
            String itemId = sc.next();
            sc.nextLine();

            for (MenuItem item : menu)
            {
                if (item.getItemId().equals(itemId))
                {
                    System.out.println(item);
                    break;
                }
            }
        }
        else if (choice == 2)
        {
            System.out.println("Enter Item Name: ");
            String name = sc.nextLine();

            for (MenuItem item : menu)
            {
                if (item.getItemName().equals(name))
                {
                    System.out.println(item);
                }
            }
        }

        else
        {
            System.out.println("Wrong choice");
            return;
        }
    }

    public void registerCustomer()
    {
        System.out.println("Enter Customer id: ");
        String customerId = sc.next();
        sc.nextLine();

        if (customerIds.contains(customerId))
        {
            System.out.println("Customer id already exists.");
            return;
        }

        System.out.println("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Phone Number: ");
        String phoneNumber = sc.nextLine();

        Customer customer = new Customer(customerId, name, phoneNumber);
        customers.add(customer);
        customerIds.add(customerId);
    }

    public void viewCustomers()
    {
        if (customers.isEmpty())
        {
            System.out.println("No Customers are available. Sorry!");
            return;
        }
        System.out.println("Customer ID    Name              Phone");
        System.out.println("--------------------------------------------");
        for (Customer customer : customers)
        {
            System.out.println(customer);
        }
    }

    public void createOrder()
    {
        System.out.println("Enter Customer id: ");
        String customerId = sc.next();
        sc.nextLine();

        boolean found = false;
        for (Customer customer : customers)
        {
            if (customer.getCustomerId().equals(customerId))
            {
                found = true;

                System.out.println("Enter Order id: ");
                String orderId = sc.next();
                sc.nextLine();

                if (orderIds.contains(orderId))
                {
                    System.out.println("Order Id already exists");
                    return;
                }

                Order order = new Order(orderId, customer);
                orders.add(order);
                orderIds.add(orderId);
                break;
            }
        }

        if (!found)
        {
            System.out.println("Customer id does not exists");
        }

    }

    public void addItemToOrder()
    {
        System.out.println("Enter Order Id : ");
        String orderId = sc.next();
        sc.nextLine();

        boolean found = false;

        for (Order order : orders)
        {
            if (order.getOrderId().equals(orderId))
            {
                found = true;
                if (order.getOrderStatus() != OrderStatus.CANCELLED && order.getOrderStatus() != OrderStatus.COMPLETED)
                {
                    boolean stop = false;
                    while (!stop)
                    {
                        System.out.println("Enter item id (to stop enter STOP): ");
                        String itemId = sc.next();
                        sc.nextLine();

                        if (itemId.equalsIgnoreCase("STOP"))
                        {
                            stop = true;
                            break;

                        }

                        boolean foundItem = false;

                        for (MenuItem item : menu)
                        {
                            if (item.getItemId().equals(itemId))
                            {
                                foundItem = true;
                                if (item.getAvailability() == AvailabilityStatus.AVAILABLE)
                                {
                                    System.out.println("Enter quantity: ");
                                    int quantity = sc.nextInt();
                                    sc.nextLine();

                                    if (quantity > 0)
                                    {
                                        int currentQuantity = order.getOrderedItems().getOrDefault(item, 0);
                                        order.getOrderedItems().put(item, quantity + currentQuantity);
                                    }

                                    else
                                    {
                                        System.out.println("Quantity must be greater than 0.");
                                    }
                        
                                }

                                else
                                {
                                    System.out.println("Item is currently unavailable.");
                                }
                            }
                        }

                        if (!foundItem)
                        {
                            System.out.println("Item not found!Try again");
                        }
                    }

                }

                else
                {
                    System.out.println("You can't nodify completed/cancelled order");
                    return;
                }
            }

        }

        if (!found)
        {
            System.out.println("Order id does not exists");
        }

    }

    public void removeItemFromOrder()
    {
        System.out.println("Enter Order Id : ");
        String orderId = sc.next();
        sc.nextLine();

        boolean found = false;

        for (Order order : orders)
        {
            if (order.getOrderId().equals(orderId))
            {
                found = true;
                if (order.getOrderStatus() != OrderStatus.CANCELLED && order.getOrderStatus() != OrderStatus.COMPLETED)
                {
                    boolean stop = false;
                    while (!stop)
                    {
                        System.out.println("Enter item id to remove (to stop enter STOP): ");
                        String itemId = sc.next();
                        sc.nextLine();

                        if (itemId.equalsIgnoreCase("STOP"))
                        {
                            stop = true;
                            break;

                        }

                        boolean foundItem = false;

                        MenuItem removeItem = null;
                        for (MenuItem item : order.getOrderedItems().keySet())
                        {
                            if (item.getItemId().equals(itemId))
                            {
                                foundItem = true;
                                removeItem = item;
                                break;
                            }
                        }

                        if (!foundItem)
                        {
                            System.out.println("Item not found!Try again");
                        }

                        else
                        {
                            order.setTotalAmount(order.getTotalAmount().subtract(removeItem.getPrice().multiply(new BigDecimal (order.getOrderedItems().get(removeItem)))));
                            order.getOrderedItems().remove(removeItem);
                        }
                    }

                }

                else
                {
                    System.out.println("You can't nodify completed/cancelled order");
                    return;
                }
            }

        }

        if (!found)
        {
            System.out.println("Order id does not exists");
        }

    }

    public void viewOrder()
    {
        System.out.println("Enter Order id: ");
        String orderId = sc.next();
        sc.nextLine();
        boolean found = false;

        for (Order order : orders)
        {
            if (order.getOrderId().equals(orderId))
            {
                found = true;
                System.out.println("========== ORDER DETAILS ==========\n");
                System.out.println("Order ID: " + order.getOrderId());
                System.out.println("Customer: " + order.getCustomer().getCustomerName());
                System.out.println("Status: " + order.getOrderStatus());

                System.out.println("Items: ");

                for (MenuItem item : order.getOrderedItems().keySet())
                {
                    System.out.print(item.getItemName() + "x  "  + order.getOrderedItems().get(item));
                }

                System.out.println("Total: ₹" + order.getTotalAmount());
                break;
            }
        }

        if (!found)
        {
            System.out.println("Order id not found!");
        }

    }

    public void viewAllOrders()
    {
        if (orders.isEmpty())
        {
            System.out.println("No orders available!");
            return;
        }

        System.out.println("Order ID    Customer       Status        Total");
        System.out.println("---------------------------------------------------");

        for (Order order : orders)
        {
            System.out.println(order.getOrderId() + "    " + order.getCustomer().getCustomerName() + "       " +
            order.getOrderStatus() + "        " + order.getTotalAmount());
        }
    }

    public void updateOrderStatus()
    {
        System.out.println("Enter order id : ");
        String orderId = sc.next();
        sc.nextLine();

        boolean foundOrder = false;

        for (Order order : orders)
        {
            if (order.getOrderId().equals(orderId))
            {
                foundOrder = true;

                if (order.getOrderStatus() != OrderStatus.CANCELLED && order.getOrderStatus() != OrderStatus.COMPLETED)
                {
                    System.out.println("Enter new status: ");
                    String newStatus = sc.next();
                    sc.nextLine();

                    OrderStatus status;

                    if (newStatus.equalsIgnoreCase("CANCELLED"))
                    {
                        status = OrderStatus.CANCELLED;
                    }

                    else if (newStatus.equalsIgnoreCase("COMPLETED"))
                    {
                        status = OrderStatus.COMPLETED;
                    }

                    else if (newStatus.equalsIgnoreCase("READY"))
                    {
                        status = OrderStatus.READY;
                    }

                    else if (newStatus.equalsIgnoreCase("PREPARING"))
                    {
                        status = OrderStatus.PREPARING;
                    }

                    else if (newStatus.equalsIgnoreCase("pending"))
                    {
                        status = OrderStatus.PENDING;
                    }

                    else
                    {
                        System.out.println("Inavlid Order Status.");
                        return;
                    }

                    order.setOrderStatus(status);
                    break;
                }   

                else
                {
                    System.out.println("Cancelled or Completed orders cannot be modified!");
                    break;
                }
            }
        }

        if (!foundOrder)
        {
            System.out.println("Order id not Found!");
        }

    }

    public void calculateBill()
    {
        System.out.println("Enter order id : ");
        String orderId = sc.next();
        sc.nextLine();

        boolean foundOrder = false;

        for (Order order : orders)
        {
            if (order.getOrderId().equals(orderId))
            {
                foundOrder = true;

                System.out.println("\n========== BILL ==========\n");
                System.out.println("Order ID: " + order.getOrderId() + "\n" + 
                    "Customer: "  + order.getCustomer().getCustomerName());

                BigDecimal totalBill = new BigDecimal("0.0");
                for (MenuItem item : order.getOrderedItems().keySet())
                {
                    System.out.println(item.getItemName() + "     "  + order.getOrderedItems().get(item) + "    = ₹" + item.getPrice().multiply(new BigDecimal(order.getOrderedItems().get(item))));
                    totalBill = totalBill.add(item.getPrice().multiply(new BigDecimal (order.getOrderedItems().get(item))));
                }
                System.out.println("--------------------------");
                System.out.println("Total: ₹" + totalBill);
                order.setTotalAmount(totalBill);
                break;
            }
        }
        if (!foundOrder)
        {
            System.out.println("Order id not Found!");
        }
    }

    public void viewCustomerOrders()
    {
        System.out.println("Enter customer id : ");
        String customerId = sc.next();
        sc.nextLine();

        if (customerIds.contains(customerId))
        {

            System.out.println("Order ID     Status          Total");
            System.out.println("---------------------------------------");

            boolean found = false;
            for (Order order : orders)
            {
                if (order.getCustomer().getCustomerId().equals(customerId))
                {
                    found = true;
                    System.out.println(order.getOrderId() + "     " + order.getOrderStatus() + "           " + order.getTotalAmount());
                }
            }
            if (!found)
            {
                System.out.println("Customer have no order");
            }
        }
        else
        {
            System.out.println("Customer Id not found.");
            return;
        }
    }
}