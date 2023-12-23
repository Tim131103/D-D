public class Enemy {
  // Anfang Attribute
  private String name;
  public int hp;
  private int atk;
  private int def;
  // Ende Attribute
  
  public Enemy(String name, int hp, int atk, int def) {
    this.name = name;
    this.hp = hp;
    this.atk = atk;
    this.def = def;
  }
  // Anfang Methoden
  
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
  
  public int attack(Character character) {
    int damage = 0;
    damage = Dice.rollD6() + atk; 
    character.takeDamage(damage);
    return damage;
  }
  public void takeDamage(int damage) {
    hp -= damage * (0.03 * def);
    
  }
  public int getMaxHp() {
    return 50 + (2 * def);
  }
  // Ende Methoden
}