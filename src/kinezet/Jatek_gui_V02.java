package kinezet;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class Jatek_gui_V02 {

    private JFrame frame;
    
    public static void main(String[] args) {
        new Jatek_gui_V02();
    }
    
    public Jatek_gui_V02(){
        ini();
    }
    
    private void ini(){
        frame = new JFrame("V02 Itt a piros...");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        
        LayoutManager lymFlowFelso = new FlowLayout(FlowLayout.CENTER);
        JPanel pnlFelso = new JPanel(lymFlowFelso);
        pnlFelso.setBorder(new TitledBorder("Leírás"));
        JLabel cimke = new JLabel("<html><p>Itt a piros, hol a piros?</p><center>Mi a tipp?</center></html>");
        pnlFelso.add(cimke);
        
        LayoutManager lymFlowAlso = new FlowLayout(FlowLayout.LEFT);
        JPanel pnlAlso = new JPanel(lymFlowAlso);
        pnlAlso.setBorder(new TitledBorder("Játéktér"));
        JButton gomb1 = new JButton("1");
        JButton gomb2 = new JButton("2");
        JButton gomb3 = new JButton("3");
        pnlAlso.add(gomb1);
        pnlAlso.add(gomb2);
        pnlAlso.add(gomb3);
        
        LayoutManager grid = new GridLayout(2, 1);
        frame.setLayout(grid);
        frame.getContentPane().add(pnlFelso);
        frame.getContentPane().add(pnlAlso);
        
        frame.setVisible(true);
    }
}
