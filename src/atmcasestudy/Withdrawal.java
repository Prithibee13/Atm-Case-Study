/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author Asus
 */
public class Withdrawal extends Transaction {

    private int accountNumber;
    private Keypad keypad;
    private int amount;

    private cashDispenser casDispenser;

    private final static int CANCELED = 6;

    public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, cashDispenser atmCasDispenser) {
        super(userAccountNumber, atmScreen, atmBankDatabase);

        keypad = atmKeypad;
        casDispenser = atmCasDispenser;
    }

    @Override
    public void execute() 
    {
        boolean cashDispensed = false;
        double availableBalance;

        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        do 
        {
            amount = displayMenuOfAmounts();
            
            if(amount != CANCELED)
            {
              availableBalance = bankDatabase.getAvilableBalance(getAccountNumber());
              if(amount <= availableBalance)
              {
                  if(casDispenser.isSufficientCashAvailable( amount ))
                  {
                      bankDatabase.debit(getAccountNumber() , amount);
                      
                      casDispenser.dispenseCash(amount);
                      cashDispensed = true;
                      
                      String message = "Your cash has been " + " dispensed. \n Please take your cash now.";
                      
                      screen.displayMessageLine(message);
                      
                   }
                  else
                  { // cash dispenser does not have enough cash
                        screen.displayMessageLine("\nInsufficient cash available in the ATM." + "\n\nPlease choose a smaller amount." );
                  }
                  
               }
              else
              {
                  screen.displayMessageLine("\nInsufficient funds in your account."+"\n\nPlease choose a smaller amount.");
                  
              }
            }
            
            else
            {
                screen.displayMessageLine( "\nCanceling transaction...");
                return;
            }
        }while(!cashDispensed);
        
        
    }
}
