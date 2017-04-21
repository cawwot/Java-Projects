package week_4;
//Ian Spooner
//Week 4 - Project 2
//04/10/16
//This is a simple ATM
//Sorry about all the logic chains. For real.
//I couldn't think of any other way to verify all 
//of the checks at the same time.
//At least its all indented correctly...
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Account {
private static final Float SERV_FEE= 1.50f;
private static Float savBal=0.0f;
private static Float chkBal=0.0f;
private static Float usrAmt=0.0f;
private static boolean sav;
private static boolean chk;
private static int count=0;
static JFrame warn = new JFrame("Error!");
static JFrame bal = new JFrame("Balance");
static DecimalFormat Result = new DecimalFormat("#.##");

public void Account(){
}

public static void clearAmtText() {                                   
// clear text on click
BuildAtm.Amount.setText("");
}

public static void withdraw() throws InsufficientFunds, Exception{
if (BuildAtm.Amount.getText().equals("Enter Amount")){
    JOptionPane.showMessageDialog(warn,
    "Please enter an amount...",
    "Try again",
    JOptionPane.WARNING_MESSAGE);
    }
else if(usrAmt%10!=0){
    JOptionPane.showMessageDialog(warn,
    "Withdrawls can only be in multiples of $10.",
    "Try again",
    JOptionPane.WARNING_MESSAGE);
    }
else{   
    try{ 
        usrAmt=Float.parseFloat(BuildAtm.Amount.getText());
        if(count<=4){           
            if(sav==true){
                if(savBal-usrAmt>=0){   
                    savBal=savBal-usrAmt;
                    JOptionPane.showMessageDialog(bal,
                    "You have withdrawn $" + String.valueOf(Result.format(usrAmt)) + ". The remaining balance is the Savings account is $" + String.valueOf(Result.format(savBal)),
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                    count++;
                    }
                }
            else if(chk==true){
                if(chkBal-usrAmt>=0){   
                    chkBal=chkBal-usrAmt;
                    JOptionPane.showMessageDialog(bal,
                    "You have withdrawn $" + String.valueOf(Result.format(usrAmt)) + ". The remaining balance is the Checking account is $" + String.valueOf(Result.format(chkBal)),
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                    count++;
                    }       
                else{
                    throw new InsufficientFunds("There isn't enough money in that acount...");
                    }
                }
            else if(chk&&sav==false){
                JOptionPane.showMessageDialog(warn,
                "Please select an account...",
                "Try again",
                JOptionPane.WARNING_MESSAGE);
                }
            }
        else if(count>4){
            if(sav==true){    
                if(savBal-usrAmt-SERV_FEE>=0){   
                    savBal=savBal-usrAmt-SERV_FEE;
                    JOptionPane.showMessageDialog(bal,
                    "You have withdrawn $" + String.valueOf(Result.format(usrAmt)) + ". The remaining balance is the Savings account is $" + String.valueOf(Result.format(savBal)) + ". A $1.50 service fee was charged to your account.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                    count++;
                    }
                else{
                    throw new InsufficientFunds("There isn't enough money in that acount...");
                    }
                }
            else if(chk==true){
                if(chkBal-usrAmt-SERV_FEE>=0){   
                    chkBal=chkBal-usrAmt-SERV_FEE;
                    JOptionPane.showMessageDialog(bal,
                    "You have withdrawn $" + String.valueOf(Result.format(usrAmt)) + ". The remaining balance is the Checking account is $" + String.valueOf(Result.format(chkBal)) + ". A $1.50 service fee was charged to your account.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                    count++;
                    }       
                else{
                    throw new InsufficientFunds("There isn't enough money in that acount...");
                    }
                }
            else{
                JOptionPane.showMessageDialog(warn,
                "Please select an account...",
                "Try again",
                JOptionPane.WARNING_MESSAGE);
                }
            }
        else{
            throw new Exception("This shouldn't ever happen, I don't think. It just cleans up the else if.");
            //there must be a cleaner way to do this...
            }
        }
    catch(NumberFormatException e1){
        JOptionPane.showMessageDialog(warn,
        "That doesn't seem to be a valid number format..." + e1,
        "Try again",
        JOptionPane.WARNING_MESSAGE);
        BuildAtm.Amount.setText("");
        }
    }
}

public static void validateAmount(){
if (BuildAtm.Amount.getText().isEmpty()){
    BuildAtm.Amount.setText("Enter Amount");
    }
else{
    try{ 
        usrAmt = Float.parseFloat(BuildAtm.Amount.getText());
        }
    catch(NumberFormatException e1){
        JOptionPane.showMessageDialog(warn,
        "That doesn't seem to be a valid number format..." + e1,
        "Try again",
        JOptionPane.WARNING_MESSAGE);
        BuildAtm.Amount.setText("");
        }
    }
}

public static void Balance(){
if(sav==true){
    JOptionPane.showMessageDialog(bal,
    "Balance of Savings Account: $" + String.valueOf(Result.format(savBal)),
    "Balance",
    JOptionPane.INFORMATION_MESSAGE);
    }
else if(chk==true){
    JOptionPane.showMessageDialog(bal,
    "Balance of Checking Account: $" + String.valueOf(Result.format(chkBal)),
    "Balance",
    JOptionPane.INFORMATION_MESSAGE);
    }
else{
    JOptionPane.showMessageDialog(bal,
    "Please Select an account...",
    "Error.",
    JOptionPane.WARNING_MESSAGE);
    }
}

public static void Deposit() throws InsufficientFunds{
if (BuildAtm.Amount.getText().isEmpty()){
    JOptionPane.showMessageDialog(warn,
    "There doesn't seem to be a number there...",
    "Try again",
    JOptionPane.WARNING_MESSAGE);
    }
else{
    try{ 
        if(sav==true){
            if(savBal+usrAmt>=0){
                savBal=savBal+usrAmt;
                JOptionPane.showMessageDialog(bal,
                "You have deposited $" + String.valueOf(Result.format(usrAmt)) + ". The new balance of the Savings account is $" + String.valueOf(Result.format(savBal)),
                "Success.",
                JOptionPane.INFORMATION_MESSAGE);
                }
            else{
                throw new InsufficientFunds("There isn't enough money in that acount..."); 
                }
            }
        else if(chk==true){
            if(chkBal+usrAmt>=0){
                chkBal=chkBal+usrAmt;
                JOptionPane.showMessageDialog(bal,
                "You have deposited $" + String.valueOf(Result.format(usrAmt)) + ". The new balance of the Checking account is $" + String.valueOf(Result.format(chkBal)),
                "Success.",
                JOptionPane.INFORMATION_MESSAGE);
                }
            else{
                throw new InsufficientFunds("There isn't enough money in that acount..."); 
                }
            }
        else{
            JOptionPane.showMessageDialog(bal,
            "Please Select an account...",
            "Error.",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    catch(NumberFormatException e1){
        JOptionPane.showMessageDialog(warn,
        "That doesn't seem to be a valid number format... " + e1.getCause().getMessage().trim(),//needs to trim more off this stupid message
        "Try again",
        JOptionPane.WARNING_MESSAGE);
        BuildAtm.Amount.setText("");
        } 
    }
}

public static void Transfer() throws InsufficientFunds{
if (BuildAtm.Amount.getText().isEmpty()){
    JOptionPane.showMessageDialog(warn,
    "There doesn't seem to be a number there...",
    "Try again",
    JOptionPane.WARNING_MESSAGE);
    }
else{
    try{ 
        usrAmt=Float.parseFloat(BuildAtm.Amount.getText());
        if(sav==true){
            if(savBal-usrAmt>=0){   
                savBal=savBal-usrAmt;
                chkBal=chkBal+usrAmt;
                JOptionPane.showMessageDialog(bal,
                "You have transferred $" + String.valueOf(Result.format(usrAmt)) + " to the Checking account. The new balance of the Savings account is $" + String.valueOf(Result.format(savBal)),
                "Success.",
                JOptionPane.INFORMATION_MESSAGE);
                }
            else{
                throw new InsufficientFunds("There isn't enough money in that acount...");
                }
            }
        else{
            if(chkBal-usrAmt>=0){   
                chkBal=chkBal-usrAmt;
                savBal=savBal+usrAmt;
                JOptionPane.showMessageDialog(bal,
                "You have transferred $" + String.valueOf(Result.format(usrAmt)) + " to the Savings account. The new balance of the Checking account is $" + String.valueOf(Result.format(chkBal)),
                "Success.",
                JOptionPane.INFORMATION_MESSAGE);
                }
            else{
                throw new InsufficientFunds("There isn't enough money in that acount...");
                }        
            }
        }
    catch(NumberFormatException e1){
        JOptionPane.showMessageDialog(warn,
        "That doesn't seem to be a valid number format..." + e1,
        "Try again",
        JOptionPane.WARNING_MESSAGE);
        BuildAtm.Amount.setText("");
        }
    }
}

public static void chkChkd(){
if (BuildAtm.boolSav.isSelected()){
    BuildAtm.boolChk.setSelected(false);
    sav=true;
    chk=false;
    }
else if(BuildAtm.boolChk.isSelected()){
    BuildAtm.boolSav.setSelected(false);
    sav=false;
    chk=true;
    }
else{}
}

//the end
}