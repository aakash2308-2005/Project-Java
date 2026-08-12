import java.math.BigDecimal;

public class Rental
{
    private String rentalId;
    private Customer customer;
    private Vehicle vehicle;
    private int numberOfRentalDays;
    private BigDecimal rentalPrice;
    private RentalStatus rentalStatus = RentalStatus.ACTIVE;

    public Rental(String rentalId, Customer customer, Vehicle vehicle, int numberOfRentalDays)
    {
        this.rentalId = rentalId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.numberOfRentalDays = numberOfRentalDays;
    }

    public String getRentalId() {
        return rentalId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getNumberOfRentalDays() {
        return numberOfRentalDays;
    }

    public BigDecimal getRentalPrice() {
        return rentalPrice;
    }

    public RentalStatus getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalId(String rentalId) {
        this.rentalId = rentalId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setNumberOfRentalDays(int numberOfRentalDays) {
        this.numberOfRentalDays = numberOfRentalDays;
    }

    public void setRentalStatus(RentalStatus rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public void calculateRentalPrice()
    {
        this.rentalPrice = vehicle.getBaseRentalPricePerDay().multiply(new BigDecimal(String.valueOf(numberOfRentalDays)));
    }

    @Override
    public String toString()
    {
        String output = 
        "Rental id: " + rentalId + "\n" +
        "Customer: " + customer.getName() + "\n" +
        "Vehicle: " + vehicle.getBrand() + "\n" +
        "Number Of Days: " + numberOfRentalDays + "\n" +
        "Rental Price: " + rentalPrice + "\n" +
        "Rental Status: " + rentalStatus + "\n";  

        return output;
    }

}