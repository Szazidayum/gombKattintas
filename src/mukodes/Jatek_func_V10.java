//Molnár Szabrina
package mukodes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
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

public class Jatek_func_V10 implements ActionListener{


    private JFrame frame;
    private JLabel lblVissza;
    private JButton gomb1, gomb2, gomb3;
    private int golyo, szamlaloKlikk;
    private static int szamlaloJatek, szamlaloOssz;
    private JLabel lblStatisztika;
    private String str = "Kilépés...";
//    JButton[] gombok;
    
    public static void main(String[] args) {
        ujJatek();
    }
     private static void ujJatek() {
        new Jatek_func_V10();
    }
     private static void jatekBezar() {
        
    }
    
    public Jatek_func_V10() {
        ini();
        golyo = (int) (Math.random() * (3 - 1 + 1) + 1);  
        System.out.println(golyo);
    }
    
    private void ini(){
        szamlaloJatek++;
        /* A FŐ ablak beállításai */
        frame = new JFrame("V1.0 Itt a piros...");
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
        
        //JMenuItem mnuPrgUjra = new JMenuItem("Újra");
        JMenuItem mnuPrgUjra = new JMenuItem("Újra", new ImageIcon(this.getClass().getResource("/kepek/folder.gif")));
        mnuPrgUjra.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        mnuPrgUjra.addActionListener(new ujJatekListener());
        mnuPrg.add(mnuPrgUjra);
        
        mnuPrg.addSeparator();
        
        JMenuItem mnuPrgKilep = new JMenuItem("Kilép...");
        mnuPrgKilep.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
        mnuPrgKilep.addActionListener(new jatekKilepListener());
        mnuPrg.add(mnuPrgKilep);

        // ez nem jó a menühöz:
        //frame.getContentPane().add(pnlMenu);
        //JPanel pnlMenu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //pnlMenu.add(menuBar);
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
        lblStatisztika = new JLabel("<html><p>Játék: "+szamlaloJatek+", klikk: 0</p><p>Összes klikk: "+szamlaloOssz+"</p></html>");
        pnlFelsoStatisztika.add(lblStatisztika);
        
        pnlFelso.add(pnlFelsoLeiras);
        pnlFelso.add(pnlFelsoStatisztika);
        
        /* alsó tartalma */    
        LayoutManager lymFlowAlso = new FlowLayout(FlowLayout.LEFT);
        JPanel pnlAlsoJatekter = new JPanel(lymFlowAlso);//pnlAlso-n lesz, gombokat tartalmaz
        JPanel pnlAlsoLeiras = new JPanel(lymFlowAlso);//pnlAlso-n lesz, labelt tartalmaz
        
        //JLabel lblVissza = new JLabel("<html><p>Találat visszajelzés!</p></html>");
        lblVissza = new JLabel("<html><p>Találat visszajelzés!</p></html>");
        pnlAlsoLeiras.add(lblVissza);
        
//        //kezdés gomb
//        kezd = new JButton("Újra");
//        pnlAlsoLeiras.add(kezd);
//        kezd.addActionListener(this);
        
        gomb1 = new JButton("1");
        gomb2 = new JButton("2");
        gomb3 = new JButton("3");
        
//        gombok[0]=gomb1;
//        gombok[1]=gomb2;
//        gombok[2]=gomb3;

        gomb1.addActionListener(this);
        gomb2.addActionListener(this);
        gomb3.addActionListener(this);
        
        pnlAlsoJatekter.add(gomb1);
        pnlAlsoJatekter.add(gomb2);
        pnlAlsoJatekter.add(gomb3);
        
        pnlAlso.add(pnlAlsoJatekter);//pnlAlso grid 1. sora
        pnlAlso.add(pnlAlsoLeiras);//pnlAlso grid 2. sora

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //JOptionPane.showConfirmDialog(frame, "Kilépés", "Biztos kilép?", JOptionPane.YES_NO_OPTION);
        JButton gomb = (JButton)e.getSource();
        String felirat = gomb.getActionCommand();
        System.out.println("kattintott gomb szövege: " + felirat);
        int gombSzam = Integer.valueOf(gomb.getText());
        if(gombSzam == golyo){
            gomb.setText("O");
            lblVissza.setText("Talált!");
            gombokEnged(false);
        }else{
            gomb.setText("X");
            lblVissza.setText("Nem talált!");
        }
        szamlaloKlikk++;
        szamlaloOssz++;
        guitFrissit();
        }
        private void gombokEnged(boolean enged){
//            for(JButton g : gombok){
//                g.setEnabled(enged);
//            }
            gomb1.setEnabled(enged);
            gomb2.setEnabled(enged);
            gomb3.setEnabled(enged);
    }

        private void guitFrissit(){
            String stat = String.format("<html><p>Játék: "+szamlaloJatek+", klikk: "+szamlaloKlikk+"</p><p>Összes klikk: "+szamlaloOssz+"</p></html>");
            lblStatisztika.setText(stat);
        }
        
        class ujJatekListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem kezd = (JMenuItem)e.getSource();
            if(kezd.getText() == "Újra"){
                ujJatek();
            }
            
        }
            
        }
    class jatekKilepListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem kilep = (JMenuItem)e.getSource();
            if(kilep.getText() == "Kilép..."){
//                str += "WindowClosing\n";
                JOptionPane.showMessageDialog(frame, str);
                int valasz= JOptionPane.showConfirmDialog(frame, "Biztosan kilépsz?", str, JOptionPane.YES_OPTION);
                if(valasz == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
            
        }
            
        }
}
