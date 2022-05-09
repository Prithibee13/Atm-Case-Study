/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmcasestudy;

/**
 *
 * @author Asus
 */
public class Screen 
{
    public void displayMessage(String message)
    {
        System.out.println(message);
    }
    
    public void displayMessageLine(String message)
    {
        System.out.println(message);
    }
    
    public void displayDollerMessage(double amount)
    {
        System.out.println("$%.2f" + amount);
    }
}
