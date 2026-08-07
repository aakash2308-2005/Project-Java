import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

class Account{
    private int accountNumber;
    private String accountHolderName;
    private String accountType;
    private BigDecimal balance;

    public List<String> transactions = new ArrayList<>();


    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName)
    {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public void setBalance(BigDecimal balance)
    {
        this.balance = balance;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public String getAccountHolderName()
    {
        return accountHolderName;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public BigDecimal getBalance()
    {
        return balance;
    }

    @Override
    public String toString()
    {
        String output = 
        "===== ACCOUNT DETAILS =====\n\n" + 
        "Account Number : " + accountNumber + "\n" +
        "Holder Name    : " + accountHolderName + "\n" +
        "Account Type   : " + accountType + "\n" + 
        "Balance        : " + balance;

        return output;
    }
}