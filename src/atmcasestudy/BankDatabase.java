/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author Asus
 */
public class BankDatabase {

    private Account[] accounts;

    public BankDatabase() {
        accounts = new Account[2];
        accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
        accounts[1] = new Account(98765, 56789, 200.0, 200.0);
    }

    private Account getAccount(int accountNumber) {
        for (Account currentAccount : accounts) 
        {
            if(currentAccount.getAccountNumber() == accountNumber)
            {
                return currentAccount;
            }
        }
        return null;
    }
    
    public boolean authenticUser(int userAccountNumber , int userPin)
    {
        Account userAccount = getAccount(userAccountNumber);
        boolean permit =  (userAccount!=null)? userAccount.validatePin(userPin) :false;
        
        return permit;
    }
    
    
    public double getAvilableBalance(int userAccountNumber)
    {
        return getAccount(userAccountNumber).getAvailbleBalance();
    }
    
    public double getTotalBalance (int userAccountNumber)
    {
        return getAccount((userAccountNumber)).getTotalBalance();
    }
    
    public void credit(int userAccountNumber , double amount)
    {
        getAccount(userAccountNumber).credit(amount);
    }
    
    public void  debit(int userAccountNumber , double amount)
    {
        getAccount(userAccountNumber).debit(amount);
    }
}
