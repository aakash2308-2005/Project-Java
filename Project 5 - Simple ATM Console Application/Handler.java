import java.math.BigDecimal;
import java.util.Scanner;

class Handler{

    Scanner sc = new Scanner(System.in);
    Accounts accts = new Accounts();
    public void atmLogin()
    {
        int count = 0;

        while (true)
        {
            System.out.println("Enter Account Number: ");
            String accountNumber = sc.next();
            System.out.println("Enter PIN: ");
            int pin = sc.nextInt();
            boolean fnd = false;

            for (Account account : accts.accounts)
            {
                if (accountNumber.equals(account.accountNumber))
                {
                    fnd = true;
                    if (pin == account.pin)
                    {
                        System.out.println("Login successful.");
                        boolean notStop = true;
                        while (notStop)
                        {
                            System.out.println("===== ATM MENU =====\n\n");
                            System.out.println(
                                "1. Check Balance\n2. Deposit Money\n3. Withdraw Money\n4. Transfer Money\n" +
                                "5. Transaction History\n6. Logout\n");

                            System.out.println("Enter your choice: ");
                            int choice = sc.nextInt();

                            switch(choice)
                            {
                                case 1:
                                    System.out.println("===== BALANCE =====\n");
                                    System.out.println(
                                        "Account Holder : " + account.accountHolderName +"\n" +
                                        "Account Number : " + account.accountNumber + "\n" +
                                        "Available Balance : ₹" + account.balance + "\n");
                                    break;

                                case 2:        
                                    BigDecimal depositMoney = new BigDecimal("0.0");
                                    while (true)
                                    {
                                        System.out.println("Enter amount to deposit: ");
                                        depositMoney = new BigDecimal(sc.next());

                                        if (depositMoney.compareTo(new BigDecimal("0")) > 0)
                                        {
                                            break;
                                        }

                                        else
                                        {
                                            System.out.println("Enter valid amount!");
                                        }
                                    }
                                    account.balance = account.balance.add(depositMoney);
                                    System.out.println("Deposit successful.\nAmount deposited : ₹" + depositMoney +"\n" +
                                        "New balance : ₹" + account.balance);
                                    account.transactionHistory.add("DEPOSIT +₹" + depositMoney + "\n");
                                    break;
                                case 3:
                                    
                                    BigDecimal withdrawMoney = new BigDecimal("0.0");
                                    while (true)
                                    {
                                        System.out.println("Enter amount to withdraw: ");
                                        withdrawMoney = new BigDecimal(sc.next());

                                        if (withdrawMoney.compareTo(new BigDecimal("0.0")) > 0)
                                        {
                                            if (withdrawMoney.compareTo(account.balance) > 0)
                                            {
                                                System.out.println("Insufficient balance");
                                            }
                                            else
                                            {
                                                break;
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Enter valid amount!");
                                        }
                                    }
                                    account.balance = account.balance.subtract(withdrawMoney);
                                    System.out.println("Withdrawal successful.\nAmount withdrawn : ₹" + withdrawMoney +"\n" +
                                        "Remaining balance : ₹" + account.balance);
                                    account.transactionHistory.add("WITHDRAW -₹" + withdrawMoney + "\n");
                                    break;
                                case 4:

                                    System.out.println("Enter recipient account number: ");
                                    String recipientAccountNumber = sc.next();
                                    if (recipientAccountNumber.equals(accountNumber))
                                    {
                                        System.out.println("You cannot transfer to yourself.");
                                    }
                                    else
                                    {
                                        boolean found = false;
                                        for (Account acc : accts.accounts)
                                        {
                                            if (acc.accountNumber.equals(recipientAccountNumber))
                                            {
                                                found = true;
                                                
                                                BigDecimal amount = new BigDecimal("0.0");
                                                while(true)
                                                {
                                                    System.out.println("Enter amount to transfer:");
                                                    amount = new BigDecimal(sc.next());

                                                    if(amount.compareTo(new BigDecimal("0")) > 0)
                                                    {
                                                        if (amount.compareTo(account.balance) > 0)
                                                        {
                                                            System.out.println("Insufficient balance.");
                                                        }
                                                        else{
                                                            break;
                                                        }

                                                    }
                                                    else
                                                    {
                                                        System.out.println("Enter valid amount!");
                                                    }
                                                }

                                                acc.balance = acc.balance.add(amount);
                                                account.balance = account.balance.subtract(amount);

                                                System.out.println(
                                                    "Transfer successful.\n" + 
                                                    "Transferred : ₹" + amount + "\n" +
                                                    "To Account : " + recipientAccountNumber + "\n" +
                                                    "Remaining balance : ₹" + account.balance
                                                );
                                                acc.transactionHistory.add("TRANSFER FROM" + accountNumber + "+₹" + amount);
                                                account.transactionHistory.add("TRANSFER TO" + recipientAccountNumber  +"-₹" + amount);
                                                break;
                                            }
                                        }

                                        if (!found)
                                        {
                                            System.out.println("No such account exists.");
                                        }
                                    }
                                    break;

                                case 5:
                                    int cnt = 1;
                                    System.out.println("===== TRANSACTION HISTORY =====");
                                    for (String history: account.transactionHistory)
                                    {
                                        System.out.println(cnt + ". " + history);
                                        cnt += 1;
                                    }
                                    break;

                                case 6:
                                    System.out.println("You have been logged out successfully.\nThank you for using the ATM.\n");
                                    notStop = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                            }
                        }
                        break;
                    }

                    else
                    {
                        System.out.println("Invalid account number or PIN.");
                        count += 1;
                        if (count == 3)
                        {
                            System.out.println("Too many failed attempts.\nATM locked.");
                            return;
                        }
                    }
                }
            }

            if (!fnd)
            {
                count += 1;
                if (count == 3)
                {
                    System.out.println("Too many failed attempts.\nATM locked.");
                    return;
                }
            }
        }
    }
}
