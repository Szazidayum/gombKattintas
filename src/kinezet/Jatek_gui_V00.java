package kinezet;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Jatek_gui_V00 {

    private JFrame frame;
    
    public static void main(String[] args) {
        new Jatek_gui_V00();
    }
    
    public Jatek_gui_V00(){
        ini();
    }
    
    private void ini(){
        frame = new JFrame("V00 Itt a piros...");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setSize(450, 300);
        
        JButton gomb1 = new JButton("1");
        JButton gomb2 = new JButton("2");
        JButton gomb3 = new JButton("3");
        
        frame.getContentPane().add(gomb1, BorderLayout.WEST);
        frame.getContentPane().add(gomb2, BorderLayout.CENTER);
        frame.getContentPane().add(gomb3, BorderLayout.EAST);
        
        frame.setVisible(true);
    }
}
