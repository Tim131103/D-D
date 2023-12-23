import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class DdGamd extends JFrame {
  private JProgressBar jProgressBar1 = new JProgressBar();
  private JLabel lStatsvonSpieler = new JLabel();
  private JLabel lATK = new JLabel();
  private JLabel lDEF = new JLabel();
  private JLabel lINT = new JLabel();
  private JLabel lDEX = new JLabel();
  private JLabel lDungeonDragon = new JLabel();
  private JButton bSpielStarten = new JButton();
  private JButton bWuerfeln = new JButton();
  private JList jList1 = new JList();
  private DefaultListModel jList1Model = new DefaultListModel();
  private JScrollPane jList1ScrollPane = new JScrollPane(jList1);
  private JLabel jLabel7 = new JLabel();
  private JProgressBar jProgressBar2 = new JProgressBar();
  private JLabel lHP = new JLabel();
  private Character character;
  private Enemy enemy;
  private Enemy quest;
  private JProgressBar jProgressBar3 = new JProgressBar();
  private JLabel lHP1 = new JLabel();
  private JScrollPane jScrollPane1 = new JScrollPane();
  private SpritePanel spritePanel1 = new SpritePanel();
  private PlayerSprite playerSprite1 = new PlayerSprite("G:\\Meine Ablage\\HNBK\\SW\\SW Abschluss\\Code\\SW Projekt DnD\\Picture Resized\\wizard__sk__by_shreowo_dfhszqr (1).png");
  
  private int killedEnemies = 0;
  
  public DdGamd(Character character, String spritePath) {
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1524;
    int frameHeight = 658;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("DdGamd");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    playerSprite1.setBounds(336, 216, 433, 289);
    cp.add(playerSprite1);
    spritePanel1.setBounds(840, 128, 329, 281);
    spritePanel1.setOpaque(false);
    cp.add(spritePanel1);
    jScrollPane1.setBounds(800, 440, 265, 49);
    cp.add(jScrollPane1);
    jProgressBar3.setBounds(944, 72, 225, 33);
    jProgressBar3.setForeground(Color.RED);
    jProgressBar3.setStringPainted(true);
    jProgressBar3.setValue(10);
    jProgressBar3.setFont(new Font("Dialog", Font.BOLD, 12));
    jProgressBar3.setBackground(new Color(0xC0C0C0));
    cp.add(jProgressBar3);
    lHP.setBounds(392, 152, 81, 49);
    lHP.setText("HP :");
    lHP.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
    lHP.setHorizontalAlignment(SwingConstants.CENTER);
    lHP.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(lHP);
    jProgressBar2.setBounds(488, 160, 209, 33);
    jProgressBar2.setString("");
    jProgressBar2.setValue(10);
    jProgressBar2.setBackground(new Color(0xC0C0C0));
    jProgressBar2.setForeground(Color.RED);
    jProgressBar2.setFont(new Font("Dialog", Font.BOLD, 12));
    jProgressBar2.setStringPainted(true);
    jProgressBar2.setMaximum(100);
    cp.add(jProgressBar2);
    jLabel7.setBounds(8, 520, 1505, 89);
    jLabel7.setText("text");
    jLabel7.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
    jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel7.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(jLabel7);
    jList1.setModel(jList1Model);
    jList1ScrollPane.setBounds(1176, 288, 313, 209);
    cp.add(jList1ScrollPane);
    bWuerfeln.setBounds(1248, 168, 161, 89);
    bWuerfeln.setText("Würfeln");
    bWuerfeln.setMargin(new Insets(2, 2, 2, 2));
    bWuerfeln.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        bWuerfeln_ActionPerformed(evt);
      }
    });
    bWuerfeln.setFont(new Font("Bauhaus 93", Font.BOLD, 14));
    cp.add(bWuerfeln);
    bSpielStarten.setBounds(1256, 32, 145, 57);
    bSpielStarten.setText("Spiel Starten");
    bSpielStarten.setMargin(new Insets(2, 2, 2, 2));
    bSpielStarten.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        bSpielStarten_ActionPerformed(evt);
      }
    });
    bSpielStarten.setFont(new Font("Bauhaus 93", Font.BOLD, 14));
    cp.add(bSpielStarten);
    lDungeonDragon.setBounds(480, 8, 353, 73);
    lDungeonDragon.setText("Dungeon & Dragon");
    lDungeonDragon.setHorizontalAlignment(SwingConstants.CENTER);
    lDungeonDragon.setHorizontalTextPosition(SwingConstants.LEFT);
    lDungeonDragon.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
    cp.add(lDungeonDragon);
    lATK.setBounds(56, 168, 185, 41);
    lATK.setText("ATK :");
    lATK.setHorizontalAlignment(SwingConstants.CENTER);
    lATK.setHorizontalTextPosition(SwingConstants.CENTER);
    lATK.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
    cp.add(lATK);
    lStatsvonSpieler.setBounds(56, 72, 217, 73);
    lStatsvonSpieler.setText("Stats von Spieler :");
    lStatsvonSpieler.setHorizontalAlignment(SwingConstants.CENTER);
    lStatsvonSpieler.setHorizontalTextPosition(SwingConstants.CENTER);
    lStatsvonSpieler.setFont(new Font("Bauhaus 93", Font.BOLD, 24));
    cp.add(lStatsvonSpieler);
    jProgressBar1.setBounds(584, 104, 161, 25);
    jProgressBar1.setValue(50);
    jProgressBar1.setString("10 %");
    cp.add(jProgressBar1);
    
    lDEF.setBounds(56, 232, 185, 41);
    lDEF.setText("DEF : ");
    lDEF.setHorizontalAlignment(SwingConstants.CENTER);
    lDEF.setHorizontalTextPosition(SwingConstants.CENTER);
    lDEF.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
    cp.add(lDEF);
    lINT.setBounds(56, 296, 185, 41);
    lINT.setText("INT :");
    lINT.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
    lINT.setHorizontalAlignment(SwingConstants.CENTER);
    lINT.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(lINT);
    lDEX.setBounds(48, 360, 185, 41);
    lDEX.setText("DEX :");
    lDEX.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
    lDEX.setHorizontalAlignment(SwingConstants.CENTER);
    lDEX.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(lDEX);
    lHP1.setBounds(856, 64, 81, 49);
    lHP1.setText("HP :");
    lHP1.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
    cp.add(lHP1);
    this.character = character;
    
    
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      Character defaultCharacter = new Character("DefaultPlayer", 50, 50, 50, 50, 50);
      new DdGamd(defaultCharacter, "G:\\Meine Ablage\\HNBK\\SW\\SW Abschluss\\Code\\SW Projekt DnD\\Picture Resized\\wizard__sk__by_shreowo_dfhszqr (1).png");
    });
  }

  public void bSpielStarten_ActionPerformed(ActionEvent evt) {
    
    
    int maxHp = character.getMaxHp();
    character.setHp(maxHp);
    
    Armor armor = new Armor("Plattenpanzer", 10);
    character.equipArmor(armor);
    
    Weapon weapon = new Weapon("Langschwert", 12);
    character.equipWeapon(weapon);
    lStatsvonSpieler.setText("Stats von : " + character.getName());
    lATK.setText("ATK : " + String.valueOf(character.getAtk()));
    lDEF.setText("DEF : " +String.valueOf(character.getDef()));
    lINT.setText("INT : " +String.valueOf(character.getInte()));
    lDEX.setText("DEX : " +String.valueOf(character.getDex()));
    
    jProgressBar2.setValue(maxHp);
    jProgressBar2.setString("100 %");
    
    quest = new Enemy("König", 1, 0, 0);
    jLabel7.setText("Held du hast eine wichtige aufgabe ... du musst es Schaffen den Dämonenkönig zu töten");
    
    jProgressBar3.setString("100 %");
    jProgressBar3.setValue(100);
    
  }

  public void bWuerfeln_ActionPerformed(ActionEvent evt) {
    if (enemy == null || enemy.getHp() <= 0) {
      createNewEnemy();
    }
    
    int damageToEnemy = character.attack(enemy);
    jLabel7.setText("Der Spieler hat dem Gegner " + damageToEnemy + " Schaden zugefügt");
    System.out.println("Spieler HP : " + character.getHp());
    
    int damageToCharacter = enemy.attack(character);
    jLabel7.setText("Der Gegner hat dem Spieler " + damageToCharacter + " Schaden zugefügt");
    System.out.println("Gegner HP : " + enemy.getHp());
    
    if (enemy.getHp() <= 0) {
      jLabel7.setText("Der Charakter hat gewonnen!");
      
      int healAmount = character.heal(5); 
      jLabel7.setText("Der Charakter hat gewonnen! Du hast " + healAmount + " HP geheilt.");
      
      Weapon gewonnenesItem = createRandomWeapon();
      Armor gewonneneRuestung = createRandomArmor();
      
      character.equipWeapon(gewonnenesItem);
      character.equipArmor(gewonneneRuestung);
      
      createNewEnemy();
      
      killedEnemies++;
      
      if (killedEnemies == 10) {
        showWinscreen();
      }
      
    } else if (character.getHp() <= 0) {
        jLabel7.setText("Der Gegner hat gewonnen!");
        
        showDeathScreen();
      }
    updateCharacterHealthProgressBar();
  }

  private void showWinscreen() {
    Winscreen winscreen = new Winscreen();
    this.dispose();
  }

  private void showDeathScreen() {
    Deathscreen deathscreen = new Deathscreen();
    
    this.dispose();
  }

  private void createNewEnemy() {
    enemy = new Enemy("Gegner", 0, 0, 0);
    Random rand = new Random();
    enemy.setAtk(rand.nextInt(30) + 5);
    enemy.setDef(rand.nextInt(30) + 5);
    
    int enemyMaxHp = enemy.getMaxHp();
    enemy.setHp(enemyMaxHp);
    
    updateCharacterHealthProgressBar();
  }

  public void updateCharacterHealthProgressBar() {
    int currentHP = character.getHp();
    int maxHP = character.getMaxHp();
    int enemyCurrentHP = enemy.getHp();
    int enemyMaxHP = enemy.getMaxHp();
    
    int percentageCharacter = (currentHP * 100) / maxHP;
    int percentageEnemy = (enemyCurrentHP * 100) / enemyMaxHP;
    
    if (percentageCharacter > 100) {
      percentageCharacter = 100;
    }
    
    if (percentageEnemy > 100) {
      percentageEnemy = 100;
    }
    
    jProgressBar2.setValue(percentageCharacter);
    jProgressBar2.setString(percentageCharacter + " %");
    jProgressBar2.repaint();
    jProgressBar3.setValue(percentageEnemy);
    jProgressBar3.setString(percentageEnemy + " %");
  }
  
  private Weapon createRandomWeapon() {
    
    Random rand = new Random();
    String[] weaponNames = {"Schwert", "Axt", "Stab", "Bogen"};
    String randomWeaponName = weaponNames[rand.nextInt(weaponNames.length)];
    int randomAtk = rand.nextInt(20) + 5; 
    return new Weapon(randomWeaponName, randomAtk);
  }

  private Armor createRandomArmor() {
    
    Random rand = new Random();
    String[] armorNames = {"Lederpanzer", "Kettenhemd", "Robe", "Plattenpanzer"};
    String randomArmorName = armorNames[rand.nextInt(armorNames.length)];
    int randomDef = rand.nextInt(15) + 5; 
    return new Armor(randomArmorName, randomDef);
  }
    
}
