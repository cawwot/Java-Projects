package week_4;
//Ian Spooner
//Week 4 - Project 2
import javax.swing.JOptionPane;
import static week_4.Account.warn;
//04/10/16
//This is a simple ATM
public class InsufficientFunds extends Exception{
    public InsufficientFunds(String message) {
        super(message);
            JOptionPane.showMessageDialog(warn,
            "There isn't enough money in that acount...",
            "Try again",
            JOptionPane.WARNING_MESSAGE);
    }
}
