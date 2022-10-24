package kinezet;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Jatek_gui_V04 implements ActionListener{

    private JFrame frame;
    
    public static void main(String[] args) {
        new Jatek_gui_V04();
    }

    public Jatek_gui_V04() {
        ini();
    }
    
    private void ini(){
        frame = new JFrame("V04 Itt a piros...");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        
        LayoutManager lymFlowFelso = new FlowLayout(FlowLayout.CENTER);
        JPanel pnlFelso = new JPanel(lymFlowFelso);
        pnlFelso.setBorder(new TitledBorder("Leírás"));
        
        JPanel pnlFelsoLeiras = new JPanel();
        JLabel lblLeiras = new JLabel("<html><p>Itt a piros, hol a piros?</p><center>Mi a tipp?</center></html>");
        pnlFelsoLeiras.add(lblLeiras);
        
        JPanel pnlFelsoStatisztika = new JPanel();
        pnlFelsoStatisztika.setBorder(new LineBorder(Color.BLACK));
        JLabel lblStatisztika = new JLabel("<html><p>Játék: 1, klikk: 0</p><p>Összes klikk: 0</p></html>");
        pnlFelsoStatisztika.add(lblStatisztika);
        
        pnlFelso.add(pnlFelsoLeiras);
        pnlFelso.add(pnlFelsoStatisztika);
        
        LayoutManager lymGridAlso = new GridLayout(2,1);
        JPanel pnlAlso = new JPanel(lymGridAlso);//grid: pnlJatektter és pnlAlsoLeiras
        pnlAlso.setBorder(new TitledBorder("Játéktér"));
                
        LayoutManager lymFlowAlso = new FlowLayout(FlowLayout.LEFT);
        JPanel pnlAlsoJatekter = new JPanel(lymFlowAlso);//pnlAlso-n lesz, gombokat tartalmaz
        JPanel pnlAlsoLeiras = new JPanel(lymFlowAlso);//pnlAlso-n lesz, labelt tartalmaz
        
        JLabel lblVissza = new JLabel("<html><p>Találat visszajelzés!</p></html>");
        pnlAlsoLeiras.add(lblVissza);
        
        JButton gomb1 = new JButton("1");
        JButton gomb2 = new JButton("2");
        JButton gomb3 = new JButton("3");
        
        gomb1.addActionListener(this);
        gomb2.addActionListener(this);
        gomb3.addActionListener(this);
        
        pnlAlsoJatekter.add(gomb1);
        pnlAlsoJatekter.add(gomb2);
        pnlAlsoJatekter.add(gomb3);
        
        pnlAlso.add(pnlAlsoJatekter);//pnlAlso grid 1. sora
        pnlAlso.add(pnlAlsoLeiras);//pnlAlso grid 2. sora
        
        LayoutManager lymGridFrame = new GridLayout(2, 1);
        frame.setLayout(lymGridFrame);
        frame.getContentPane().add(pnlFelso);
        frame.getContentPane().add(pnlAlso);
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(null, "Kilépés", "Biztos kilép?", JOptionPane.YES_NO_OPTION);
    }

    
}
