import java.util.ArrayList;
import java.util.List;

public class Character {
  private String name;
  public int hp;
  public int atk;
  public int def;
  public int dex;
  public int inte;
  public int heal;
  private Weapon equippedWeapon;
  private Armor equippedArmor;
  
  public Character(String name, int atk, int def, int dex, int inte, int hp) {
    this.name = name;
    this.atk = atk;
    this.def = def;
    this.dex = dex;
    this.inte = inte;
    this.hp = hp;
    
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getHp() {
    return hp;
  }
  
  public void setHp(int hp) {
    this.hp = hp;
  }
  
  public int getAtk() {
    return atk;
  }
  
  public void setAtk(int atk) {
    this.atk = atk;
  }
  
  public int getDef() {
    return def;
  }
  
  public void setDef(int def) {
    this.def = def;
  }
  
  public int getDex() {
    return dex;
  }
  
  public void setDex(int dex) {
    this.dex = dex;
  }
  
  public int getInte() {
    return inte;
  }

  public void setInte(int inte) {
    this.inte = inte;
  }

  public void equipWeapon(Weapon weapon) {
    this.equippedWeapon = weapon;
  }

  public void equipArmor(Armor armor) {
    this.equippedArmor = armor;
  }

  public int attack(Enemy enemy) {
    int damage = 0;
    int attackRoll = Dice.rollD20();
    
    damage = equippedWeapon.getAtk() + getAtk() + attackRoll;
    enemy.takeDamage(damage);
    
    return damage;
  }

  public void takeDamage(int damage) {
    hp -= damage * (0.03 * def);
    
  }
  
   /*public void dodge(int dex, int damage) {
    int dodgeRoll = Dice.rollD20();
    if (dodgeRoll > 9) {
      hp -= damage * 0;
    } else {
      hp -= damage * (0.03 * def);  
      } // end of if-else// end of if
  }                                 */
  
  public int heal(int amount) {
    int hpRoll = Dice.rollD10();
    hp += amount + (int)(0.5 * inte) + hpRoll; // Hier den Heilungsbetrag richtig berechnen und zu hp hinzufügen
    heal = amount + (int)(0.5 * inte) + hpRoll; // Das Attribut 'heal' aktualisieren
    if (hp > getMaxHp()) {
      hp = getMaxHp(); // HP kann nicht über das Maximum steigen
    }
    return heal;
  }

  // Methode, um das maximale HP des Charakters abzurufen
  public int getMaxHp() {
    return 10 + (2 * def) + (3 * inte);
  }
  
}
