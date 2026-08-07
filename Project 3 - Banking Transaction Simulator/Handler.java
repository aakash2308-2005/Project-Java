import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Handler
{
    Scanner sc = new Scanner(System.in);
    List<Account> accounts = new ArrayList<>();

    public void createAccount()
    {
        Account acc = new Account();

        while (true)
        {
            boolean found = false;
            System.out.println("Account number: ");
            int accountNumber = sc.nextInt();
            sc.nextLine();
            for (Account account : accounts)
            {
                if (account.getAccountNumber() == accountNumber)
                {
                    found = true;
                    System.out.println("Account number already exists.");
                    break;
                }
            }

            if (!found)
            {
                acc.setAccountNumber(accountNumber);
                break;
            }
        }

        while (true)
        {
            System.out.println("Account holder name: ");
            String accountHolderName = sc.nextLine();

            if (accountHolderName.equals(""))
            {
                System.out.println("Account holder name cannot be empty.");
            }
            else
            {
                acc.setAccountHolderName(accountHolderName);
                break;
            }
        }

        while (true)
        {
            System.out.println("Account type: ");
            String accountType = sc.nextLine();

            if ((accountType.toLowerCase()).equals("savings") || (accountType.toLowerCase()).equals("current"))
            {
                acc.setAccountType(accountType);
                break;
            }
            else
            {
                System.out.println("Account type must be valid.");
            }
        }

        while (true)
        {
            System.out.println("Initial Balance: ");
            
            try{
                BigDecimal balance = new BigDecimal(sc.next());

                if (balance.compareTo(new BigDecimal("0")) >= 0)
                {
                    acc.setBalance(balance);
                    break;
                }
                else{
                    System.out.println("Initial balance cannot be negative.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a valid number.");
            }


        }
        
        accounts.add(acc);
    }

    public void depositMoney()
    {
        Account searchAccount = null;
        BigDecimal depositAmount;
        while (true)
        {
            boolean found = false;
            System.out.println("Account number: ");
            int accountNumber = sc.nextInt();
            for (Account account : accounts)
            {
                if (account.getAccountNumber() == accountNumber)
                {
                    searchAccount = account;
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.println("Account not found.\nTry Again.");
            }
            else
            {
                break;
            }
        }

        while (true)
        {
            System.out.println("Deposit Amount: ");

            try {
                depositAmount = new BigDecimal(sc.next());

                if (depositAmount.compareTo(new BigDecimal("0")) > 0 )
                {
                    break;
                }
                else
                {
                    System.out.println("Deposit amount must be greater than 0.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Pleas enter a valid number.");
            }

        }
        searchAccount.setBalance(searchAccount.getBalance().add(depositAmount));
        searchAccount.transactions.add("Deposit successful.\nCurrent Balance: " + searchAccount.getBalance());
        System.out.println("Deposit successful.\nCurrent Balance: " + searchAccount.getBalance());
            
    }


    public void withdrawMoney()
    {
        Account searchAccount = null;
        BigDecimal withdrawAmount;
        while (true)
        {
            boolean found = false;
            System.out.println("Account number: ");
            int accountNumber = sc.nextInt();
            for (Account account : accounts)
            {
                if (account.getAccountNumber() == accountNumber)
                {
                    searchAccount = account;
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.println("Account not found.\nTry Again.");
            }
            else
            {
                break;
            }
        }

        while (true)
        {
            System.out.println("Withdraw Amount: ");

            try{
                withdrawAmount = new BigDecimal(sc.next());

                if (withdrawAmount.compareTo(new BigDecimal("0.0")) > 0)
                {
                    if (withdrawAmount.compareTo(searchAccount.getBalance()) > 0)
                    {
                        System.out.println("Withdrawal cannot exceed available balance.");
                    }
                    else
                    {
                        break;
                    }
                }
            
                else
                {
                    System.out.println("Amount must be greater than 0.");
                }
            }

            catch (NumberFormatException e)
            {
                System.out.println("Invalid amount. Please enter a valid number.");
            }
        }

        searchAccount.setBalance(searchAccount.getBalance().subtract(withdrawAmount));
        searchAccount.transactions.add("Withdrawal successful.\nCurrent Balance: " + searchAccount.getBalance());
        System.out.println("Withdrawal successful.\nCurrent Balance: " + searchAccount.getBalance());

    }

    public void checkBalance()
    {
        while (true)
        {
            boolean found = false;
            System.out.println("Account number: ");
            int accountNumber = sc.nextInt();
            for (Account account : accounts)
            {
                if (account.getAccountNumber() == accountNumber)
                {
                    System.out.println("Current Balance : " + account.getBalance());
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.println("Account not found.\nTry Again.");
            }
            else
            {
                break;
            }
        }
    }

    public void transferBalance()
    {
        Account senderAccount = null;
        Account receiverAccount = null;
        BigDecimal amount;

        while (true)
        {
            boolean found = false;
            System.out.println("Sender Account: ");
            int accountNumber = sc.nextInt();
            for (Account account : accounts)
            {
                if (account.getAccountNumber() == accountNumber)
                {
                    senderAccount = account;
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.println("Account not found.\nTry Again.");
            }
            else
            {
                break;
            }
        }

        while (true)
        {
            boolean found = false;
            System.out.println("Receiver Account: ");
            int accountNumber = sc.nextInt();
            for (Account account : accounts)
            {
                if (account.getAccountNumber() == accountNumber)
                {
                    if (senderAccount.getAccountNumber() != accountNumber)
                    {
                        receiverAccount = account;
                        found = true;
                        break;
                    }

                    else
                    {
                        System.out.println("Sender and receiver cannot be the same.");
                    }
                
                }
            }

            if (!found)
            {
                System.out.println("Receiver account not found.Try Again.");
            }
            else
            {
                break;
            }
        }

        while (true)
        {
            System.out.println("Amount: ");

            try {
                amount = new BigDecimal(sc.next());

                if (amount.compareTo(new BigDecimal("0.0")) > 0)
                {
                    if (amount.compareTo(senderAccount.getBalance()) > 0)
                    {
                    System.out.println("Transfer amount cannot exceed available balance.");
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    System.out.println("Amount must be greater than 0.");
                }
            }

            catch (NumberFormatException e)
            {
                System.out.println("Invalid amount. Please enter a valid number.");
            }
        }

        receiverAccount.setBalance(receiverAccount.getBalance().add(amount));
        senderAccount.setBalance(senderAccount.getBalance().subtract(amount));
        senderAccount.transactions.add("Transfer sent.\nTo Account: " + receiverAccount.getAccountNumber()
            + "Amount: " +  amount + "\n");
        receiverAccount.transactions.add("Transfer recieved.\nFrom Account: " + senderAccount.getAccountNumber()
            + "Amount: " +  amount + "\n");
        

        System.out.println("Transfer successful.\nSender Balance: " + senderAccount.getBalance() + "\n" +
            "Receiver Balance: " + receiverAccount.getBalance() + "\n");
    }

    public void displayAccountDetails()
    {
        while (true)
        {
            boolean found = false;
            System.out.println("Account Number: ");
            int accountNumber = sc.nextInt();
            for (Account account : accounts)
            {
                if (account.getAccountNumber() == accountNumber)
                {
                    System.out.println(account);
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.println("Account not found.\nTry Again.");
            }
            else
            {
                break;
            }
        }

    }

    public void transactionHistory()
    {
        while (true)
        {
            boolean found = false;
            System.out.println("Account Number: ");
            int accountNumber = sc.nextInt();
            for (Account account : accounts)
            {
                if (account.getAccountNumber() == accountNumber)
                {
                    System.out.println("===== TRANSACTION HISTORY =====\n\n");
                    int count = 1;
                    for (String transaction : account.transactions)
                    {
                        System.out.println(count + ". " +transaction);
                        count += 1;
                    }

                    found = true;
                    break;

                }
            }

            if (!found)
            {
                System.out.println("Try Again.");
            }
            else
            {
                break;
            }

        }

    }
}
