import java.math.BigDecimal;

public class Bill{

    private Customer customer;
    private BigDecimal energyCharge;
    private BigDecimal fixedCharge;
    private BigDecimal surCharge;
    private BigDecimal totalBill;


    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setEnergyCharge(BigDecimal energyCharge)
    {
        this.energyCharge = energyCharge;
    }

    public BigDecimal getEnergyCharge()
    {
        return energyCharge;
    }

    public BigDecimal getFixedCharge() {
        return fixedCharge;
    }

    public void setFixedCharge(BigDecimal fixedCharge) {
        this.fixedCharge = fixedCharge;
    }

    public BigDecimal getSurCharge() {
        return surCharge;
    }

    public void setSurCharge(BigDecimal surCharge) {
        this.surCharge = surCharge;
    }


    public BigDecimal getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(BigDecimal totalBill) {
        this.totalBill = totalBill;
    }

}