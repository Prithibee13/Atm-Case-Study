/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author Asus
 */
public abstract class Transaction 
{
    private int accountNumber;
    private Screen screen;
    
    public Transaction(int userAccountNumber , Screen atmScreen)
    {
        accountNumber = userAccountNumber;
        screen = atmScreen;
    }
    
    public int getAccountNumber()
    {
        return  accountNumber;
    }
    
    public Screen getScreen()
    {
        return  screen;
    }
    
    abstract public  void  execute();
}
