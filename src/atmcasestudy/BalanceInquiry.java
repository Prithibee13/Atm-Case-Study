/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author Asus
 */
public class BalanceInquiry extends Transaction
{
    
    public BalanceInquiry(int userAccountNummber , Screen atmScreen ,BankDatabase atmBankDatabase )
    {
        super(userAccountNummber, atmScreen , atmBankDatabase);
    }
    @Override
    public void  execute()
    {
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();
        
        double availableBalance = bankDatabase.getAvilableBalance(getAccountNumber());
        
        double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());
        
        screen.displayMessageLine("\nBalance Information:");
        screen.displayMessage("- Available Balance : ");
        screen.displayDollerMessage( availableBalance );
        screen.displayMessage("\n - Total balance :       ");
        screen.displayDollerMessage( totalBalance );
        screen.displayMessageLine("");
    }
}
