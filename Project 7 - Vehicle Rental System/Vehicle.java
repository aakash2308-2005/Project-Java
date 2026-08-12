import java.math.BigDecimal;

public class Vehicle {

    private String vehicleId;
    private String brand;
    private String model;
    private int year;
    private BigDecimal baseRentalPricePerDay;
    private VehicleStatus status= VehicleStatus.AVAILABLE;

    public Vehicle(String vehicleId, String brand, String model, int year, BigDecimal baseRentalPricePerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.baseRentalPricePerDay = baseRentalPricePerDay;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public BigDecimal getBaseRentalPricePerDay() {
        return baseRentalPricePerDay;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBaseRentalPricePerDay(BigDecimal baseRentalPricePerDay) {
        this.baseRentalPricePerDay = baseRentalPricePerDay;
    }

    public VehicleStatus getStatus()
    {
        return status;
    }

    public void setStatus(VehicleStatus status)
    {
        this.status = status;
    }

    public String vehicleSpecificInformation()
    {
        return "Vehicle";
    }
}


class Car extends Vehicle{
    private int numberOfSeats;

    public Car(String vehicleId, String brand, String model, int year, BigDecimal baseRentalPricePerDay, int numberOfSeats) {
        super(vehicleId, brand, model, year, baseRentalPricePerDay);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats()
    {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats)
    {
        this.numberOfSeats = numberOfSeats;
    }

    public String vehicleSpecificInformation()
    {
        return numberOfSeats + "Seats";
    }
}

class Bike extends Vehicle{
    private int engineCapacity;

    public Bike(String vehicleId, String brand, String model, int year, BigDecimal baseRentalPricePerDay, int engineCapacity) {
        super(vehicleId, brand, model, year, baseRentalPricePerDay);
        this.engineCapacity = engineCapacity;
    }


    public int getEngineCapacity()
    {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity)
    {
        this.engineCapacity = engineCapacity;
    }

    public String vehicleSpecificInformation()
    {
        return engineCapacity + "cc";
    }
}

class Truck extends Vehicle{
    private int loadCapacity;

    public Truck(String vehicleId, String brand, String model, int year, BigDecimal baseRentalPricePerDay, int loadCapacity) {
        super(vehicleId, brand, model, year, baseRentalPricePerDay);
        this.loadCapacity = loadCapacity;
    }


    public int getLoadCapacity()
    {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity)
    {
        this.loadCapacity = loadCapacity;
    }

    public String vehicleSpecificInformation()
    {
        return loadCapacity + "kg";
    }
}