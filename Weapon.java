public class Weapon extends Item {
  private int atk;
  
  public Weapon(String name, int atk) {
    super(name, 0); 
    this.setName(name);
    this.atk = atk;
  }

  public int getAtk() {
    return atk;
  }
  
  public void setAtk(int atk) {
    this.atk = atk;
  }
}