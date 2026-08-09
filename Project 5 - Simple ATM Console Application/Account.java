import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

class Account{
    public String accountNumber;
    public String accountHolderName;
    public int pin;
    public String accountType;
    public BigDecimal balance;
    public List<String> transactionHistory = new ArrayList<>();

    public Account(String accountNumber, String accountHolderName, int pin, String accountType, BigDecimal balance)
    {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.accountType = accountType;
        this.balance = balance;
    }

}