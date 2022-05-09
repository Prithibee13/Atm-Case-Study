/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author Asus
 */
public class Deposit extends Transaction
{
    
    private double amount;
    private Keypad keypad;
    private DepositeSlot depositeSlot;
    private final static int CANCELED = 0;
    
    
    public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, DepositeSlot atmDepositeSlot)
    {
        super( userAccountNumber , atmScreen , atmBankDatabase );
        
        keypad = atmKeypad;
        depositeSlot = atmDepositeSlot;
    }
    
    public double promptForDepositAmount()
    {
        Screen screen = getScreen();
        
        screen.displayMessage("\nPlease Enter a deposit amount in " + "CENTS (or 0 to cancel)");
        int input = keypad.getInput();
        
        if(input == CANCELED)
        {
            return CANCELED;
        }
        
        else
        {
            return (double) input / 100;
        }
    }
    
    
    @Override
    public void execute()
    {
        BankDatabase bankDatabase = getBankDatabase();
        
        Screen screen = getScreen();
        
        amount = promptForDepositAmount();
        
        if(amount != CANCELED)
        {
            screen.displayMessage("\nPlease insert a deposit envelop containing ");
            screen.displayDollerMessage(amount);
            screen.displayMessageLine(" ");
            
            
            boolean envelopeReceived = depositeSlot.isEnvelopRecieved();
            
            if( envelopeReceived )
            {
                screen.displayMessageLine("\nYour envelop has been reveived . \n Note: The money just deposit will Not be avaiable until we veryfy the amount of any enclosed cash and your checjs clear.");
                
                bankDatabase.credit(getAccountNumber() , amount);
               
            }
            
            else
            {
                screen.displayMessageLine("\nyou did not insert a envelop , so the ATM has canceled your transaction");
            }
            
        }
        
        else
        {
            screen.displayMessageLine("\nCanceling transaction");
        }
    }
    
}
