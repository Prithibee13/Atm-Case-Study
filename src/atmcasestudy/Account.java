/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author Asus
 */
public class Account 
{
    
    private int accountNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;
    
    
    public Account(int theAccountNumber, int thePin, double theAvailableBlance, double theTotalBalance)
    {
        this.accountNumber = theAccountNumber;
        this.pin = thePin;
        this.availableBalance = theAvailableBlance;
        this.totalBalance = theTotalBalance;
    }
    public boolean validatePin( int userPin)
    {
        if (userPin == pin)
            return true;
        else
            return false;
    }
    
    public double getAvailbleBalance()
    {
        return availableBalance;
    }
    
    public double getTotalBalance()
    {
        return totalBalance;
    }
    
    public void credit(double amount)
    {
        totalBalance = totalBalance+ amount;
    }
    
    public  void debit(double amount)
    {
        availableBalance = availableBalance - amount;
        totalBalance = totalBalance - amount;
    }
    
    public int getAccountNumber()
    {
        return accountNumber;
    }
    
}
