package week_4;
//Ian Spooner
//Week 4 - Project 2
//04/10/16
//This is a simple ATM
import java.security.PrivilegedActionException;
public class Week_4 {
    public static void main(String args[])throws PrivilegedActionException {       
        java.awt.EventQueue.invokeLater(() -> {
            BuildAtm dialog = new BuildAtm(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
}