import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.math.BigDecimal;

public class Handler{

    Scanner sc;
    private List<Vehicle> vehicles = new ArrayList<>();
    private Set<String> vehicleIds = new HashSet<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();
    private Set<String> customerIds = new HashSet<>();
    private Set<String> rentalIds = new HashSet<>();
    private static int customerId = 1;
    public static int rentalId = 1;

    public Handler(Scanner sc)
    {
        this.sc = sc;
    }

    public void addVehicle()
    {
        System.out.println("\n1. Car\n2. Bike\n3. Truck\n");

        System.out.println("Enter Vehicle Type:");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Vehicle Id: ");
        String vehicleId = sc.nextLine();

        if (vehicleIds.contains(vehicleId))
        {
            System.out.println("vehicle Id already exists.");
            return;
        }
        System.out.println("Enter Brand: ");
        String brand = sc.nextLine();
        System.out.println("Enter Model: ");
        String model = sc.nextLine();
        System.out.println("Enter Year: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Price Per Day: ");
        BigDecimal pricePerDay = new BigDecimal(sc.next());

        switch (choice)
        {
            case 1:
                System.out.println("Enter Number Of Seats: ");
                int numberOfSeats = sc.nextInt();
                sc.nextLine();

                Vehicle car = new Car(vehicleId, brand, model, year, pricePerDay, numberOfSeats);
                vehicles.add(car);
                vehicleIds.add(vehicleId);
                break;

            case 2:
                System.out.println("Enter Engine Capacity: ");
                int engineCapacity = sc.nextInt();
                sc.nextLine();

                Vehicle bike = new Bike(vehicleId, brand, model, year, pricePerDay, engineCapacity);
                vehicles.add(bike);
                vehicleIds.add(vehicleId);
                break;
            case 3:
                System.out.println("Enter Load Capacity: ");
                int loadCapacity = sc.nextInt();
                sc.nextLine();

                Vehicle truck = new Truck(vehicleId, brand, model, year, pricePerDay, loadCapacity);
                vehicles.add(truck);
                vehicleIds.add(vehicleId);
                break;
            default:
                System.out.println("Invalid Choice");
                return;
        }


    }

    public void registerCustomer()
    {
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Phone: ");
        String phone = sc.nextLine();
        System.out.println("Driving License Number: ");
        String drivingLicenseNumber = sc.nextLine();

        
        Customer customer = new Customer(String.valueOf(customerId), name, phone, drivingLicenseNumber);
        customerIds.add(String.valueOf(customerId));
        customerId += 1;
        customers.add(customer);

    }

    public void viewAvailableVehicles()
    {
        System.out.println("ID     Type    Brand    Model      Price/Day");
        int size = vehicles.size();

        if (size == 0)
        {
            System.out.println("No vehicles available");
            return;
        }
        else
        {
            int count = 0;
            for (Vehicle vehicle : vehicles)
            {
                if (vehicle.getStatus() == VehicleStatus.AVAILABLE)
                {
                    count += 1;
                    if (vehicle instanceof Car)
                    {
                        System.out.println(vehicle.getVehicleId() + "   " + "CAR " + "   " + vehicle.getBrand() + "   " + vehicle.getModel() + "   " + vehicle.getBaseRentalPricePerDay());
                    }

                    else if (vehicle instanceof Bike)
                    {
                        System.out.println(vehicle.getVehicleId() + "   " + "BIKE " + "   " + vehicle.getBrand() + "   " + vehicle.getModel() + "   " + vehicle.getBaseRentalPricePerDay());
                    }

                    else if (vehicle instanceof Truck)
                    {
                        System.out.println(vehicle.getVehicleId() + "   " + "Truck " + "   " + vehicle.getBrand() + "   " + vehicle.getModel() + "   " + vehicle.getBaseRentalPricePerDay());
                    }
                }
            }

            if (count == 0)
            {
                System.out.println("All vehicles are rented.");
            }
        }
    }

    public void viewAllVehicles()
    {
        System.out.println("ID     Type    Brand    Model      Status");
        int size = vehicles.size();

        if (size == 0)
        {
            System.out.println("No vehicles available");
            return;
        }

        for (Vehicle vehicle : vehicles)
            {
                if (vehicle instanceof Car)
                {
                    System.out.println(vehicle.getVehicleId() + "   " + "CAR " + "   " + vehicle.getBrand() + "   " + vehicle.getModel() + "   " + vehicle.getStatus());
                }

                else if (vehicle instanceof Bike)
                {
                    System.out.println(vehicle.getVehicleId() + "   " + "BIKE " + "   " + vehicle.getBrand() + "   " + vehicle.getModel() + "   " + vehicle.getStatus());
                }

                else if (vehicle instanceof Truck)
                {
                    System.out.println(vehicle.getVehicleId() + "   " + "Truck " + "   " + vehicle.getBrand() + "   " + vehicle.getModel() + "   " + vehicle.getStatus());
                }
            }


    }

    public void rentVehicle()
    {
        System.out.println("Customer id: ");
        String cId = sc.next();
        sc.nextLine();

        boolean found = false;

        if (customerIds.contains(cId))
        {
            found = true;
        }

        if (!found)
        {
            System.out.println("Customer Id not found.");
        }
        else
        {
            System.out.println("Vehicle id: ");
            String vId = sc.next();
            sc.nextLine();

            if (vehicleIds.contains(vId))
            {
                for (Vehicle vehicle : vehicles)
                {
                    if (vehicle.getVehicleId().equals(vId))
                    {
                        if (vehicle.getStatus() == VehicleStatus.AVAILABLE)
                        {
                            System.out.println("Number of days ");
                            int numberOfDays = sc.nextInt();
                            sc.nextLine();

                            if (numberOfDays > 0)
                            {

                                for (Customer customer : customers)
                                {
                                    if (customer.getCustomerId().equals(cId))
                                    {
                                        Rental rental = new Rental(String.valueOf(rentalId), customer, vehicle, numberOfDays);
                                        rentalIds.add(String.valueOf(rentalId));
                                        rentalId += 1;
                                        vehicle.setStatus(VehicleStatus.RENTED);
                                        rental.calculateRentalPrice();
                                        rentals.add(rental);
                                    }
                                }

                            }

                            else
                            {
                                System.out.println("Invalid Days");
                                return;
                            }

                        }
                        else
                        {
                            System.out.println("Vehicle is already rented.");
                        }
                    }
                }
            }
            else
            {
                System.out.println("No vehicle id found!");
                return;
            }

        }
    }

    public void returnVehicle()
    {
        System.out.println("Enter rental Id: ");
        String rId = sc.next();
        sc.nextLine();
        boolean found = false;

        for (Rental rental : rentals)
        {
            if (rental.getRentalId().equals(rId))
            {
                found = true;
                if (rental.getRentalStatus() == RentalStatus.ACTIVE)
                {
                    rental.setRentalStatus(RentalStatus.COMPLETED);
                    rental.getVehicle().setStatus(VehicleStatus.AVAILABLE);
                }
                else
                {
                    System.out.println("Rental Closed Already");
                    return;
                }
            }
        }

        if (!found)
        {
            System.out.println("Rental Id Invalid");
            return;
        }

    }

    public void viewAllRentals()
    {
        int size = rentals.size();

        if (size == 0)
        {
            System.out.println("No rental records are available");
            return;
        }

        for (Rental rental : rentals)
        {       
            System.out.println(
                "Rental ID: " + rental.getRentalId() + "\n" +
                "Customer: " + rental.getCustomer().getName() + "\n" +
                "Vehicle: " + rental.getVehicle().getBrand() + " " + rental.getVehicle().getModel() + "\n" + 
                "Days: " + rental.getNumberOfRentalDays() + "\n" +
                "Total: ₹" + rental.getRentalPrice() + "\n" +
                "Status: " + rental.getRentalStatus());
        }
    }

    public void viewCustomerDetails()
    {
        System.out.println("Enter customer Id: ");

        String customerId = sc.next();
        sc.nextLine();

        boolean found = false;

        for (Customer customer : customers)
        {
            if (customer.getCustomerId().equals(customerId))
            {
                found = true;
                System.out.println("Customer ID: " + customerId + "\n" +
                                    "Name: " + customer.getName() + "\n" + 
                                    "Phone: " + customer.getPhoneNumber() + "\n" + 
                                    "Driving license: " + customer.getDrivingLicenseNumber() + "\n");

                for (Rental rental : rentals)
                {
                    if(rental.getCustomer().getCustomerId().equals(customerId))
                    {
                        System.out.println(rental);
                    }
                }
                break;
            }
        }

        if (!found)
        {
            System.out.println("Customer ID not found.");
        }

    }

    public void viewVehicleDetails()
    {
        System.out.println("Vehicle Id: ");

        String vehicleId = sc.next();
        sc.nextLine();

        boolean found = false;

        for (Vehicle vehicle : vehicles)
        {
            if (vehicle.getVehicleId().equals(vehicleId))
            {
                found = true;
                System.out.println("Vehicle ID: " + vehicleId + "\n" +
                                    "Vehicle Type: " + vehicle.getClass().getSimpleName()+ "\n" +
                                    "Brand: " + vehicle.getBrand() + "\n" + 
                                    "Model: " + vehicle.getModel() + "\n" + 
                                    "Year: " + vehicle.getYear() + "\n" +
                                    "Vehicle-Specific-Information: " + vehicle.vehicleSpecificInformation() +"\n" +
                                    "Rental Price: " + vehicle.getBaseRentalPricePerDay() + "\n" +
                                    "Current Status: " + vehicle.getStatus() + "\n");

                for (Rental rental : rentals)
                {
                    if(rental.getVehicle().getVehicleId().equals(vehicleId))
                    {
                        System.out.println(rental);
                    }
                }
                break;
            }
        }

        if (!found)
        {
            System.out.println("Vehicle not found.");
        }




    }

}