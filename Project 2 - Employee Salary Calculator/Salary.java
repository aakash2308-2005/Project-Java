import java.math.BigDecimal;
import java.math.RoundingMode;

class Salary{

    private BigDecimal basicSalary;

    public Salary(BigDecimal basicSalary)
    {
        this.basicSalary = basicSalary;
    }


    public  BigDecimal calculateHRA()
    {
        BigDecimal hra;

        if (basicSalary.compareTo(new BigDecimal("30000.0")) < 0)
        {
            hra = basicSalary.multiply(new BigDecimal("0.1"));
        }

        else if (basicSalary.compareTo(new BigDecimal("60000.0")) < 0)
        {
            hra = basicSalary.multiply(new BigDecimal("0.15"));
        }

        else
        {
            hra = basicSalary.multiply(new BigDecimal("0.2"));
        }

        return hra;
    }

    public BigDecimal calculateDA()
    {
        BigDecimal da;

        if (basicSalary.compareTo(new BigDecimal("30000.0")) < 0)
        {
            da = basicSalary.multiply(new BigDecimal("0.08"));
        }

        else if (basicSalary.compareTo(new BigDecimal("60000.0")) < 0)
        {
            da = basicSalary.multiply(new BigDecimal("0.1"));
        }

        else
        {
            da = basicSalary.multiply(new BigDecimal("0.12"));
        }

        return da;
    }

    public BigDecimal calculateSpecialAllowance()
    {
        return basicSalary.multiply(new BigDecimal("0.05"));
    }

    public BigDecimal calculateGrossSalary()
    {
        return basicSalary.add(calculateHRA()).add(calculateDA()).add(calculateSpecialAllowance());
    }

    public BigDecimal calculateProvidentFund(){
        return basicSalary.multiply(new BigDecimal("0.12"));
    }

    public BigDecimal calculateProfessionalTax(){
        BigDecimal grossSalary = calculateGrossSalary();
        BigDecimal pTax;
        if (grossSalary.compareTo(new BigDecimal("25000.0")) <= 0)
        {
            pTax = new BigDecimal("0.0");
        }

        else if (grossSalary.compareTo(new BigDecimal("50000.0")) <=0)
        {
            pTax = new BigDecimal("200.0");
        }

        else
        {
            pTax = new BigDecimal("300.0");
        }

        return pTax;
    }

    public BigDecimal calculateIncomeTax(){
        BigDecimal annualGrossSalary = calculateGrossSalary().multiply(new BigDecimal("12"));

        BigDecimal tax;

        if (annualGrossSalary.compareTo(new BigDecimal("300000.0")) <= 0)
        {
            tax = new BigDecimal("0.0");
        }

        else if (annualGrossSalary.compareTo(new BigDecimal("600000.0")) <= 0)
        {
            tax = annualGrossSalary.multiply(new BigDecimal("0.05"));
        }

        else if (annualGrossSalary.compareTo(new BigDecimal("1000000.0")) <= 0)
        {
            tax = annualGrossSalary.multiply(new BigDecimal("0.1"));
        }
        else
        {
            tax = annualGrossSalary.multiply(new BigDecimal("0.2"));
        }

        return tax.divide(new BigDecimal("12"), 2, RoundingMode.HALF_UP);

    }

    public BigDecimal calculateTotalDeductions()
    {
        return calculateProvidentFund().add(calculateProfessionalTax()).add(calculateIncomeTax());
    }

    public BigDecimal calculateNetSalary()
    {
        return calculateGrossSalary().subtract(calculateTotalDeductions());
    }

    public String calculateSalaryGrade()
    {
        BigDecimal annualGrossSalary = calculateGrossSalary().multiply(new BigDecimal("12"));

        if (annualGrossSalary.compareTo(new BigDecimal("300000.0")) <= 0)
        {
            return "C";
        }
        else if (annualGrossSalary.compareTo(new BigDecimal("600000.0")) <= 0)
        {
            return "B";
        }

        else if (annualGrossSalary.compareTo(new BigDecimal("1000000.0")) <= 0)
        {
            return "A";
        }
        else
        {
            return "A+";
        }
    }

    @Override
    public String toString()
    {
        String output = "----------------------------------------\n" + 
                        "EARNINGS\n" + 
                        "----------------------------------------\n\n"+
                        "Basic Salary        : " + basicSalary + "\n" +
                        "HRA                 : " + calculateHRA() + "\n" +
                        "DA                  : " + calculateDA() + "\n" +
                        "Special Allowance   : " + calculateSpecialAllowance() + "\n" +
                        "Gross Salary        : " + calculateGrossSalary() + "\n\n" +
                        "----------------------------------------\n" + 
                        "DEDUCTIONS\n" +
                        "----------------------------------------\n\n" +
                        "Provident Fund      : " + calculateProvidentFund() + "\n" +
                        "Professional Tax    : " + calculateProfessionalTax() + "\n" +
                        "Income Tax          : " + calculateIncomeTax() + "\n" +
                        "Total Deductions    : " + calculateTotalDeductions() + "\n" +
                        "----------------------------------------\n" +
                        "NET SALARY          : " + calculateNetSalary() + "\n" +
                        "SALARY GRADE        : " + calculateSalaryGrade() + "\n" +
                        "========================================";

        return output;

    
    }
}