package week_4;
//Ian Spooner
//Week 4 - Project 2
//04/10/16
//This is a simple ATM
//this would have been way easier in javaFX...
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class BuildAtm extends javax.swing.JDialog {
    public BuildAtm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Build();
    }
private void Build() {
JFrame frame = new JFrame("ATM");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

jFrame1 = new javax.swing.JFrame();
Withdraw = new javax.swing.JButton();
Deposit = new javax.swing.JButton();
Transfer = new javax.swing.JButton();
Balance = new javax.swing.JButton();
boolChk = new javax.swing.JRadioButton();
boolSav = new javax.swing.JRadioButton();
Amount = new javax.swing.JTextField();

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("ATM");
setPreferredSize(new java.awt.Dimension(230, 175));
getContentPane().setLayout(new java.awt.FlowLayout());

Withdraw.setText("Withdraw");
Withdraw.addActionListener((java.awt.event.ActionEvent evt)-> {
    try {
        WithdrawActionPerformed(evt) ;
    } catch (InsufficientFunds ex) {
        Logger.getLogger(BuildAtm.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(BuildAtm.class.getName()).log(Level.SEVERE, null, ex);
    }
});
getContentPane().add(Withdraw);

Deposit.setText("Deposit");
Deposit.addActionListener((java.awt.event.ActionEvent evt) -> {
    try {
        DepositActionPerformed(evt);
    } catch (InsufficientFunds ex) {
        Logger.getLogger(BuildAtm.class.getName()).log(Level.SEVERE, null, ex);
    }
});
getContentPane().add(Deposit);

Transfer.setText("Transfer");
Transfer.addActionListener((java.awt.event.ActionEvent evt) -> {
    try {
        TransferActionPerformed(evt);
    } catch (InsufficientFunds ex) {
        Logger.getLogger(BuildAtm.class.getName()).log(Level.SEVERE, null, ex);
    }
});
getContentPane().add(Transfer);

Balance.setText("Balance");
Balance.addActionListener((java.awt.event.ActionEvent evt) -> {
    BalanceActionPerformed(evt);
});
getContentPane().add(Balance);

boolChk.setText("Checking");
boolChk.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
    boolChkStateChanged(evt);
});
getContentPane().add(boolChk);

boolSav.setText("Savings");
boolSav.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
    boolSavStateChanged(evt);
});
getContentPane().add(boolSav);

Amount.setText("Enter Amount");
Amount.addFocusListener(new java.awt.event.FocusAdapter() {
    @Override
    public void focusGained(java.awt.event.FocusEvent evt) {
        AmountFocusGained(evt);
    }
    @Override
    public void focusLost(java.awt.event.FocusEvent evt) {
        AmountFocusLost(evt);
    }
});
getContentPane().add(Amount);
pack();}

private void AmountFocusGained(java.awt.event.FocusEvent evt) {                                   
    Account.clearAmtText();
}                                  
private void WithdrawActionPerformed(java.awt.event.ActionEvent evt) throws InsufficientFunds, Exception {                                         
    Account.withdraw();
}                                        
private void AmountFocusLost(java.awt.event.FocusEvent evt) {                                 
    Account.validateAmount();
}                                
private void BalanceActionPerformed(java.awt.event.ActionEvent evt) {                                        
    Account.Balance();
}                                       
private void DepositActionPerformed(java.awt.event.ActionEvent evt) throws InsufficientFunds {                                        
    Account.Deposit();
}                                       
private void TransferActionPerformed(java.awt.event.ActionEvent evt) throws InsufficientFunds {                                         
    Account.Transfer();
}                                        
private void boolChkStateChanged(javax.swing.event.ChangeEvent evt) {                                     
    Account.chkChkd();
}                                    
private void boolSavStateChanged(javax.swing.event.ChangeEvent evt) {                                     
    Account.chkChkd();
}  
    
public static javax.swing.JTextField Amount;
private javax.swing.JButton Balance;
private javax.swing.JButton Deposit;
private javax.swing.JButton Transfer;
private javax.swing.JButton Withdraw;
public static javax.swing.JRadioButton boolChk;
public static javax.swing.JRadioButton boolSav;
private javax.swing.JFrame jFrame1;
}