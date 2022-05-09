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
    
    private int displayMenuOfAmounts()
    {
        int userChoice = 0;
        
        Screen screen = getScreen();
        
        int[] amounts = {0,20,40,60,100,200};
        
        while(userChoice == 0)
        {
            screen.displayMessageLine( "\nWithdrawal Menu:");
            screen.displayMessageLine( "1 - 20" );
            
            screen.displayMessageLine( "2 - 40" );
            
            
            screen.displayMessageLine( "3 - 60" );
            
            
            screen.displayMessageLine( "4 - 100" );
            
            screen.displayMessageLine( "5 - 200" );
            
            
            screen.displayMessageLine(  "\nChoose a withdrawal amount: " ) ;
            
            int input = keypad.getInput();
            
            switch( input )
            {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    userChoice = amounts[input];
                    break;
                case CANCELED :
                    userChoice = CANCELED;
                    break;
                default: 
                   screen.displayMessageLine(  "\nnInvalid selection. Try again. " ) ;
                
                    
            }
        }
        return userChoice;
    }
}
