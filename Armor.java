public class Armor extends Item {
  private int def;
  
  public Armor(String name, int def) {
    super(name, 0); 
    this.setName(name);
    this.def = def;
  }

  public int getDef() {
    return def;
  }
  
  public void setDef(int def) {
    this.def = def;
  }
}