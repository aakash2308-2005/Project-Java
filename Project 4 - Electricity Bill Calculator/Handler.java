import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Handler{

    Scanner sc = new Scanner(System.in);
    BillingService billingService = new BillingService();
    List<Bill> bills = new ArrayList<>();

    public void calculateElectricityBill()
    {
        String choice;
        do {
            System.out.println("Customer ID: ");
            String customerId = sc.next();
            sc.nextLine();
            System.out.println("Customer Name: ");
            String customerName = sc.nextLine();
            System.out.println("Meter Number: ");
            String meterNumber = sc.next();
            System.out.println("Customer Type: ");
            String customerType = sc.next();
            System.out.println("Units Consumed: ");
            int unitsConsumed = sc.nextInt();
            sc.nextLine();

            Customer customer = new Customer();
            Bill bill = new Bill();
            customer.setCustomerId(customerId);
            customer.setCustomerName(customerName);
            customer.setMeterNumber(meterNumber);
            customer.setCustomerType(customerType);
            customer.setUnitsConsumed(unitsConsumed);

            bill.setCustomer(customer);
            bill.setEnergyCharge(billingService.calculateBilling(unitsConsumed, customerType));
            bill.setFixedCharge(billingService.calculateFixedCharge(customerType));
            bill.setSurCharge(billingService.calculateSurCharge(unitsConsumed, customerType));
            bill.setTotalBill(billingService.calculateFinalBill(unitsConsumed, customerType));

            System.out.println(
                "========================================\n" +
                "ELECTRICITY BILL\n" + 
                "========================================\n\n" +
                "Customer ID       : " + customerId + "\n" +
                "Customer Name     : " + customerName + "\n"+
                "Meter Number      : " + meterNumber + "\n" +
                "Customer Type     : " +customerType +"\n" +
                "Units Consumed    : " + unitsConsumed +"\n\n\n" +
                "----------------------------------------\n" +
                "Energy Charge     : ₹" + bill.getEnergyCharge() + "\n" +
                "Fixed Charge      : ₹" + bill.getFixedCharge() + "\n" +
                "SurCharge         : ₹" + bill.getSurCharge() + "\n" +
                "----------------------------------------\n" +
                "Total Bill        : ₹" + bill.getTotalBill() + "\n\n" + 
                "========================================\n");
            
            bills.add(bill);
            System.out.println("Do you want to calculate another bill?");
            choice = sc.next();

        }while ((choice.toLowerCase()).equals("yes"));

    }

    public void displayCustomerBills()
    {
        for(Bill bill : bills)
        {
            System.out.println(
                "Customer      : " + bill.getCustomer() +  "\n" +
                "Energy Charge : " + bill.getEnergyCharge() + "\n" +
                "Fixed Charge  : " + bill.getFixedCharge() + "\n" +
                "Surcharge     : " + bill.getSurCharge() + "\n" + 
                "Total Bill    : " + bill.getTotalBill() + "\n"

            );
        }
    }
}