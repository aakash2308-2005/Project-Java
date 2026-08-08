import java.math.BigDecimal;

class BillingService
{
    public BigDecimal calculateBilling(int unitsConsumed, String customerType)
    {
        if (customerType.equals("residential"))
        {
            if (unitsConsumed <= 100)
            {
                return new BigDecimal(unitsConsumed * 2.50);
            }

            else if (unitsConsumed <= 200)
            {
                return new BigDecimal((unitsConsumed - 100) * 4.0 + 250);
            }

            else if (unitsConsumed <= 500)
            {
                return new BigDecimal((unitsConsumed - 200) * 5.50 + 400 + 250);
            }

            else
            {
                return new BigDecimal((unitsConsumed - 500) * 7.00 + 250 + 400 + 1650);
            }
        }

        else
        {
            if (unitsConsumed <= 100)
            {
                return new BigDecimal(unitsConsumed * 4.0);
            }

            else if (unitsConsumed <= 200)
            {
                return new BigDecimal((unitsConsumed - 100) * 6.0 + 400);
            }

            else if (unitsConsumed <= 500)
            {
                return new BigDecimal((unitsConsumed - 200) * 7.50 + 400 + 600);
            }

            else
            {
                return new BigDecimal((unitsConsumed - 500) *9.0 + 600 + 400 + 2250);
            }

        }
    }

    public BigDecimal calculateFixedCharge(String customerType)
    {
        if ((customerType.toLowerCase()).equals("residential"))
        {
            return new BigDecimal("50.0");
        }

        else
        {
            return new BigDecimal("150.0");
        }
    }

    public BigDecimal calculateSurCharge(int unitsConsumed, String customerType)
    {
        BigDecimal subTotal = calculateBilling(unitsConsumed, customerType).add(calculateFixedCharge(customerType));

        if ((customerType.toLowerCase()).equals("residential"))
        {
            if (subTotal.compareTo(new BigDecimal("2000")) > 0)
            {
                return subTotal.multiply(new BigDecimal("0.05"));
            }
            else
            {
                return new BigDecimal("0.0");
            }
        }

        else
        {
            if (subTotal.compareTo(new BigDecimal("5000")) > 0)
            {
                return subTotal.multiply(new BigDecimal("0.08"));
            }
            else
            {
                return new BigDecimal("0.0");
            }
        }

    }

    public BigDecimal calculateFinalBill(int unitsConsumed, String customerType)
    {
        return calculateBilling(unitsConsumed, customerType).add(calculateFixedCharge(customerType)).add(calculateSurCharge(unitsConsumed, customerType));
    }
}