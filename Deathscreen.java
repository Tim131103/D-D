import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Deathscreen extends JFrame {
    // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JButton bNeuesSpiel = new JButton();
  private JLabel lMeinLebenlaeuftgeradestressig = new JLabel();
    // Ende Attribute

  public Deathscreen() {
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 861;
    int frameHeight = 532;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Deathscreen");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    lMeinLebenlaeuftgeradestressig.setBounds(288, 96, 257, 113);
    lMeinLebenlaeuftgeradestressig.setText("Mein Leben läuft gerade stressig");
    cp.add(lMeinLebenlaeuftgeradestressig);
    bNeuesSpiel.setBounds(312, 352, 169, 65);
    bNeuesSpiel.setText("Neues Spiel");
    bNeuesSpiel.setMargin(new Insets(2, 2, 2, 2));
    bNeuesSpiel.setFont(new Font("Dialog", Font.BOLD, 16));
    bNeuesSpiel.setForeground(Color.RED);
    bNeuesSpiel.setBackground(Color.BLACK);
    bNeuesSpiel.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 0));
    bNeuesSpiel.setBorderPainted(false);
    // ActionListener für bNeuesSpiel hinzufügen
    bNeuesSpiel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        bNeuesSpiel_ActionPerformed(evt);
      }
    });
    cp.add(bNeuesSpiel);
    
    // Bild zum JLabel hinzufügen
    ImageIcon imageIcon = new ImageIcon("G:\\Meine Ablage\\HNBK\\SW\\SW Abschluss\\Code\\SW Projekt DnD\\you_died_by_mog90044_d5pzihx.jpg");
    jLabel1.setIcon(imageIcon);
    
    // Position und Größe des JLabels einstellen
    jLabel1.setBounds(0, 0, 849, 489);
    
    // JLabel zum ContentPane hinzufügen
    cp.add(jLabel1);
  
    
    // Ende Komponenten
    setVisible(true);
  } // end of public Deathscreen
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Deathscreen();
  } // end of main
  
  public void bNeuesSpiel_ActionPerformed(ActionEvent evt) {
    // Neue Instanz von DDgame erstellen
    DdGameBeginn newGame = new DdGameBeginn();
    
    // Das aktuelle Deathscreen-Fenster schließen
    this.dispose();
  }
  
  // Ende Methoden
} // end of class Deathscreen
