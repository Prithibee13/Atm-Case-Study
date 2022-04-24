/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author Asus
 */
public class cashDispenser 
{
    private final static int initialCount = 500;
    private int count;
    
    public cashDispenser()
    {
        count = initialCount;
    }
    
    public  void  dispenseCash(int amount)
    {
        int billsRequired = amount / 20;
        count = count - billsRequired;
    }
    
    public boolean isSufficientCashAvailable (int amount)
    {
        int billsRequired = amount/20;
        boolean result;
        
       result = (count >= billsRequired) ? true : false;
  
        return result;
    }
}
