import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class Accounts{
    public List<Account> accounts = new ArrayList<>();

    Account account1 = new Account("101", "Aakash K", 2308, "savings", new BigDecimal("5000000000000"));
    Account account2 = new Account("102", "Amrith S", 2005, "current", new BigDecimal("500000"));

    public Accounts(){
        accounts.add(account1);
        accounts.add(account2);
    }

}