import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Hashtable;
import java.awt.font.TextAttribute;
import java.util.Random;
import java.io.IOException;


public class DdGameBeginn extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JLabel lWiesollihrCharacterheissen = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JLabel lWelcheKlassewollenSieSpielen = new JLabel();
  private JButton bZauberer = new JButton();
  private JButton bBestaetigenSieihrenNamen = new JButton();
  private JButton bPaladin = new JButton();
  private JButton bDieb = new JButton();
  private String playerName; // Variable, um den Spielername zu speichern
  private String backgroundImage = "G:\\Meine Ablage\\HNBK\\SW\\SW Abschluss\\Code\\SW Projekt DnD\\mournstead_map_by_junebugkittydm_ddf5zhq.png";
  public Character character;
  //character = new Character("Spieler",0, 0, 0, 0, 0); // Character initialisieren
  PlayerSprite playerSprite1;
  
  // Ende Attribute
  
  public DdGameBeginn() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 758; 
    int frameHeight = 469;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("DdGameBeginn");
    setResizable(false);
    Container cp = getContentPane();
    
    // Setze das LayoutManager auf null, um die absolute Positionierung zu ermöglichen
    cp.setLayout(null);
    
    
    
    // Anfang Komponenten
    bDieb.setBounds(392, 288, 340, 65);
    bDieb.setText("Dieb");
    bDieb.setMargin(new Insets(2, 2, 2, 2));
    bDieb.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDieb_ActionPerformed(evt);
      }
    });
    bDieb.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
    bDieb.setEnabled(false); // Anfangs deaktiviert
    cp.add(bDieb);
    bPaladin.setBounds(392, 200, 340, 65);
    bPaladin.setText("Paladin");
    bPaladin.setMargin(new Insets(2, 2, 2, 2));
    bPaladin.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bPaladin_ActionPerformed(evt);
      }
    });
    bPaladin.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
    bPaladin.setEnabled(false); // Anfangs deaktiviert
    cp.add(bPaladin);
    bZauberer.setBounds(392, 112, 340, 65);
    bZauberer.setText("Zauberer");
    bZauberer.setMargin(new Insets(2, 2, 2, 2));
    bZauberer.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bZauberer_ActionPerformed(evt);
      }
    });
    bZauberer.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
    bZauberer.setEnabled(false); // Anfangs deaktiviert
    cp.add(bZauberer);
    lWelcheKlassewollenSieSpielen.setBounds(392, 16, 340, 73);
    lWelcheKlassewollenSieSpielen.setText("Welche Klasse wollen Sie Spielen?");
    lWelcheKlassewollenSieSpielen.setHorizontalAlignment(SwingConstants.CENTER);
    lWelcheKlassewollenSieSpielen.setHorizontalTextPosition(SwingConstants.CENTER);
    lWelcheKlassewollenSieSpielen.setForeground(Color.WHITE);
    lWelcheKlassewollenSieSpielen.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
    cp.add(lWelcheKlassewollenSieSpielen);
    lWiesollihrCharacterheissen.setBounds(16, 8, 313, 105);
    lWiesollihrCharacterheissen.setText("Wie soll ihr Character heißen?");
    lWiesollihrCharacterheissen.setHorizontalAlignment(SwingConstants.CENTER);
    lWiesollihrCharacterheissen.setHorizontalTextPosition(SwingConstants.CENTER);
    lWiesollihrCharacterheissen.setForeground(Color.WHITE);
    lWiesollihrCharacterheissen.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
    cp.add(lWiesollihrCharacterheissen);
    bBestaetigenSieihrenNamen.setBounds(16, 200, 313, 65);
    bBestaetigenSieihrenNamen.setText("Bestätigen Sie ihren Namen!");
    bBestaetigenSieihrenNamen.setMargin(new Insets(2, 2, 2, 2));
    bBestaetigenSieihrenNamen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBestaetigenSieihrenNamen_ActionPerformed(evt);
      }
    });
    bBestaetigenSieihrenNamen.setFont(new Font("Bauhaus 93", Font.BOLD, 16));
    bBestaetigenSieihrenNamen.setEnabled(true); 
    bBestaetigenSieihrenNamen.setFocusPainted(false); 
    cp.add(bBestaetigenSieihrenNamen);
    jTextField1.setBounds(16, 128, 313, 49);
    cp.add(jTextField1);
    
    // Setze das Bild als Hintergrund für jLabel1
    ImageIcon backgroundImageIcon = new ImageIcon(backgroundImage);
    jLabel1.setIcon(backgroundImageIcon);
    jLabel1.setBounds(0, 0, 758, 469);
    cp.add(jLabel1);
    
    
    // Ende Komponenten
    
    character = new Character("Spieler", 0, 0, 0, 0, 0); // Character initialisieren
    
    setVisible(true);
  } // end of public DdGameBeginn
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new DdGameBeginn();
  } // end of main
  
  
  
  public void bBestaetigenSieihrenNamen_ActionPerformed(ActionEvent evt) {
    playerName = jTextField1.getText(); // Speichere den eingegebenen Namen
    
    // Aktiviere die Klassen-Buttons, da der Name bestätigt wurde
    bZauberer.setEnabled(true);
    bPaladin.setEnabled(true);
    bDieb.setEnabled(true);
  } // end of bBestaetigenSieihrenNamen_ActionPerformed
  
  
  public void bZauberer_ActionPerformed(ActionEvent evt) {
    // Pfad zum Zauberer-Sprite-Bild
    String spritePath = "G:\\Meine Ablage\\HNBK\\SW\\SW Abschluss\\Code\\SW Projekt DnD\\Picture Resized\\wizard__sk__by_shreowo_dfhszqr (1).png";
    
    //createAndShowPlayerSprite(spritePath);
    // Neue Instanz von DDgame erstellen
    Random rand = new Random();
    character.setName(playerName);
    character.setAtk(rand.nextInt(75) + 50);
    character.setDef(rand.nextInt(75) + 25);
    character.setInte(rand.nextInt(100) + 25);
    character.setDex(rand.nextInt(50) + 25);
    DdGamd newGame = new DdGamd(character, spritePath);
    this.dispose();
    
  }
  
  
  public void bPaladin_ActionPerformed(ActionEvent evt) {
    // Pfad zum Paladin-Sprite-Bild
    String spritePath = "G:\\Meine Ablage\\HNBK\\SW\\SW Abschluss\\Code\\SW Projekt DnD\\Picture Resized\\gourry_by_albertov_df38ima (1).png";
    
    //createAndShowPlayerSprite(spritePath);
    // Neue Instanz von DDgame erstellen
    Random rand = new Random();
    character.setName(playerName);
    character.setAtk(rand.nextInt(50) + 25);
    character.setDef(rand.nextInt(100) + 50);
    character.setInte(rand.nextInt(100) + 50);
    character.setDex(rand.nextInt(75) + 25);
    DdGamd newGame = new DdGamd(character, spritePath);
    this.dispose();
    
  }
  public void bDieb_ActionPerformed(ActionEvent evt) {
    // Pfad zum Dieb-Sprite-Bild
    String spritePath = "G:\\Meine Ablage\\HNBK\\SW\\SW Abschluss\\Code\\SW Projekt DnD\\Picture Resized\\female_archer_by_komoreba_dca2wjk (1).png";
    
    //createAndShowPlayerSprite(spritePath);
    // Neue Instanz von DDgame erstellen
    Random rand = new Random();
    character.setName(playerName);
    character.setAtk(rand.nextInt(100) + 50);
    character.setDef(rand.nextInt(50) + 25);
    character.setInte(rand.nextInt(75) + 25);
    character.setDex(rand.nextInt(100) + 50);
    DdGamd newGame = new DdGamd(character, spritePath);
    this.dispose();
    
  }

   }

  // Methode zum Erstellen einer Instanz von PlayerSprite und Anzeigen des Bilds
  /*private void createAndShowPlayerSprite(String spritePath) throws IOException {
    playerSprite1 = new PlayerSprite(spritePath);
    
    JFrame frame = new JFrame("Sprite Demo");
    
    frame.add(playerSprite1);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }    */      
          