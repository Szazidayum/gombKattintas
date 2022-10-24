package kinezet;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class Jatek_gui_V03 {

    private JFrame frame;
    
    public static void main(String[] args) {
        new Jatek_gui_V03();
    }
    
    public Jatek_gui_V03(){
        ini();
    }
    
    private void ini(){
        frame = new JFrame("V03 Itt a piros...");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        
        LayoutManager lymFlowFelso = new FlowLayout(FlowLayout.CENTER);
        JPanel pnlFelso = new JPanel(lymFlowFelso);
        pnlFelso.setBorder(new TitledBorder("Leírás"));
        JLabel lblLeiras = new JLabel("<html><p>Itt a piros, hol a piros?</p><center>Mi a tipp?</center></html>");
        pnlFelso.add(lblLeiras);
        
        LayoutManager lymGridAlso = new GridLayout(2,1);
        JPanel pnlAlso = new JPanel(lymGridAlso);//grid: pnlAlsoJatektter és pnlAlsoLeiras
        pnlAlso.setBorder(new TitledBorder("Játéktér"));
                
        LayoutManager lymFlowAlso = new FlowLayout(FlowLayout.LEFT);
        JPanel pnlAlsoJatekter = new JPanel(lymFlowAlso);//pnlAlso-n lesz, gombokat tartalmaz
        JPanel pnlAlsoLeiras = new JPanel(lymFlowAlso);//pnlAlso-n lesz, labelt tartalmaz
        
        pnlAlso.add(pnlAlsoJatekter);//pnlAlso grid 1. sora
        pnlAlso.add(pnlAlsoLeiras);//pnlAlso grid 2. sora

        JButton gomb1 = new JButton("1");
        JButton gomb2 = new JButton("2");
        JButton gomb3 = new JButton("3");
        pnlAlsoJatekter.add(gomb1);
        pnlAlsoJatekter.add(gomb2);
        pnlAlsoJatekter.add(gomb3);
        
        JLabel lblVissza = new JLabel("<html><p>Találat visszajelzés!</p></html>");
        pnlAlsoLeiras.add(lblVissza);
        
        LayoutManager lymGridFrame = new GridLayout(2, 1);
        frame.setLayout(lymGridFrame);
        frame.getContentPane().add(pnlFelso);
        frame.getContentPane().add(pnlAlso);
        
        frame.setVisible(true);
    }
}
