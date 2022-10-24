package kinezet;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Jatek_gui_V01 {

    private JFrame frame;
    
    public static void main(String[] args) {
        new Jatek_gui_V01();
    }
    
    public Jatek_gui_V01(){
        ini();
    }
    
    private void ini(){
        frame = new JFrame("V01 Itt a piros...");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setSize(450, 300);
        
        JButton gomb1 = new JButton("1");
        JButton gomb2 = new JButton("2");
        JButton gomb3 = new JButton("3");
        
        LayoutManager grid = new GridLayout(1, 1);
        JPanel panel = new JPanel(grid);
        
        //LayoutManager flow = new FlowLayout(FlowLayout.LEFT);
        //JPanel panel = new JPanel(flow);
        
        panel.add(gomb1);
        panel.add(gomb2);
        panel.add(gomb3);
        
        //frame.getContentPane().add(gomb1, BorderLayout.WEST);
        //frame.getContentPane().add(gomb2, BorderLayout.CENTER);
        //frame.getContentPane().add(gomb3, BorderLayout.EAST);
        
        frame.getContentPane().add(panel);
        
        frame.setVisible(true);
    }
}
