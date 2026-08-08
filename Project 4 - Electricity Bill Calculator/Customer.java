public class Customer
{
    private String customerId;
    private String customerName;
    private String meterNumber;
    private String customerType;
    private int unitsConsumed;

    public void setCustomerId(String customerId)
    {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public void setMeterNumber(String meterNumber)
    {
        this.meterNumber = meterNumber;
    }

    public void setCustomerType(String customerType)
    {
        this.customerType = customerType;
    }

    public void setUnitsConsumed(int unitsConsumed)
    {
        this.unitsConsumed = unitsConsumed;
    }

    public String getCustomerId()
    {
        return customerId;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public String getMeterNumber()
    {
        return meterNumber;
    }

    public String getCustomerType()
    {
        return customerType;
    }

    public int getUnitsConsumed()
    {
        return unitsConsumed;
    }

    @Override
    public String toString()
    {
        String output = 
        "CustomerId   : " + customerId + "\n" +
        "customerName : " + customerName + "\n" +
        "meterNumber  : " + meterNumber + "\n" +
        "customerType : " + customerType + "\n" +
        "unitsConsumed: " + unitsConsumed + "\n";

        return output;
    }



}