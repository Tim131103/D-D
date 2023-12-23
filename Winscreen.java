import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 17.11.2023
 * @author 
 */

public class Winscreen extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JLabel lDuhastgewonnen = new JLabel();
  private JButton bNeuesSpiel = new JButton();
  // Ende Attribute
  
  public Winscreen() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 613; 
    int frameHeight = 530;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Winscreen");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    bNeuesSpiel.setBounds(184, 440, 187, 49);
    bNeuesSpiel.setText("Neues Spiel");
    bNeuesSpiel.setMargin(new Insets(2, 2, 2, 2));
    bNeuesSpiel.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bNeuesSpiel_ActionPerformed(evt);
      }
    });
    bNeuesSpiel.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
    bNeuesSpiel.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 0));
    cp.add(bNeuesSpiel);
    lDuhastgewonnen.setBounds(184, 336, 187, 89);
    lDuhastgewonnen.setText("Du hast gewonnen");
    lDuhastgewonnen.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
    lDuhastgewonnen.setForeground(Color.WHITE);
    cp.add(lDuhastgewonnen);
    jLabel1.setBounds(0, 0, 553, 329);
    jLabel1.setText("text");
    cp.add(jLabel1);
    
    
    // Bild zum JLabel hinzufügen
    ImageIcon imageIcon = new ImageIcon("G:\\Meine Ablage\\HNBK\\SW\\SW Abschluss\\Code\\SW Projekt DnD\\red_by_estra1515_db8yvao.jpg");
    jLabel1.setIcon(imageIcon);
    
    // Position und Größe des JLabels einstellen
    jLabel1.setBounds(0, 0, 849, 489);
    
    // JLabel zum ContentPane hinzufügen
    cp.add(jLabel1);
    
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Winscreen
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Winscreen();
  } // end of main
  
  public void bNeuesSpiel_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    // Neue Instanz von DDgame erstellen
    DdGameBeginn newGame = new DdGameBeginn();
    
    // Das aktuelle Winscreen-Fenster schließen
    this.dispose();
    
  } // end of bNeuesSpiel_ActionPerformed

  // Ende Methoden
} // end of class Winscreen
