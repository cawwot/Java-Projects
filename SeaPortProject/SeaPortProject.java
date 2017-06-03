package seaport;

import javax.swing.JFrame;

/**
 * @version 0.2
 * @Date Created 06/01/17
 * @author Ian Spooner
 */
public class SeaPortProject extends JFrame {

    world World = new world();
    
    //main runnable calls gui setup
     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            GUI dialog = new GUI(new javax.swing.JFrame(), true);
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
