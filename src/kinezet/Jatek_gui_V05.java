package kinezet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Jatek_gui_V05 implements ActionListener{

    private JFrame frame;
    
    public static void main(String[] args) {
        new Jatek_gui_V05();
    }

    public Jatek_gui_V05() {
        ini();
    }
    
    private void ini(){
        /* A FŐ ablak beállításai */
        frame = new JFrame("V05 Itt a piros...");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setSize(300, 250);//középre rakjuk
        
        /* középre */
        Dimension kep = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(kep.width/2-150, kep.height/2-125, 300, 250);
        
        /* MENÜ */
        JMenuBar menuBar = new JMenuBar();
        JMenu mnuPrg = new JMenu("Program");
        mnuPrg.setMnemonic(KeyEvent.VK_P);
        JMenu mnuEgyeb = new JMenu("Egyéb");
        mnuEgyeb.setMnemonic(KeyEvent.VK_E);
        menuBar.add(mnuPrg);
        menuBar.add(mnuEgyeb);
        
        //JMenuItem mnuPrgUjra = new JMenuItem("Újra", new ImageIcon("src/kepek/folder.gif"));
        JMenuItem mnuPrgUjra = new JMenuItem("Újra", new ImageIcon(this.getClass().getResource("/kepek/folder.gif")));
        mnuPrgUjra.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        mnuPrgUjra.addActionListener(this);
        mnuPrg.add(mnuPrgUjra);
        
        mnuPrg.addSeparator();
        
        JMenuItem mnuPrgKilep = new JMenuItem("Kilép...");
        mnuPrgKilep.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
        mnuPrgKilep.addActionListener(this);
        mnuPrg.add(mnuPrgKilep);
        
        //JPanel pnlMenu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //pnlMenu.add(menuBar);
        
        // ez nem jó a menühöz:
        //frame.getContentPane().add(pnlMenu);
        frame.setJMenuBar(menuBar);
        
        /* TARTALOM */
        LayoutManager lymGridFrame = new GridLayout(2, 1);//pnlAlso, pnlFelso
        frame.setLayout(lymGridFrame);
        
        /* felső */
        LayoutManager lymFlowFelso = new FlowLayout(FlowLayout.CENTER);
        JPanel pnlFelso = new JPanel(lymFlowFelso);
        pnlFelso.setBorder(new TitledBorder("Leírás"));
        
        /* also */
        LayoutManager lymGridAlso = new GridLayout(2,1);
        JPanel pnlAlso = new JPanel(lymGridAlso);//grid: pnlJatektter és pnlAlsoLeiras
        pnlAlso.setBorder(new TitledBorder("Játéktér"));
        
        frame.getContentPane().add(pnlFelso);
        frame.getContentPane().add(pnlAlso);
        
        /* felső tartalma */
        JPanel pnlFelsoLeiras = new JPanel();
        JLabel lblLeiras = new JLabel("<html><p>Itt a piros, hol a piros?</p><center>Mi a tipp?</center></html>");
        pnlFelsoLeiras.add(lblLeiras);
        
        JPanel pnlFelsoStatisztika = new JPanel();
        pnlFelsoStatisztika.setBorder(new LineBorder(Color.BLACK));
        JLabel lblStatisztika = new JLabel("<html><p>Játék: 1, klikk: 0</p><p>Összes klikk: 0</p></html>");
        pnlFelsoStatisztika.add(lblStatisztika);
        
        pnlFelso.add(pnlFelsoLeiras);
        pnlFelso.add(pnlFelsoStatisztika);
        
        /* alsó tartalma */    
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

        //ez is középre helyez
        //frame.setLocationRelativeTo(null);
        //frame.pack();
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(frame, "Kilépés", "Biztos kilép?", JOptionPane.YES_NO_OPTION);
    }



    
}
