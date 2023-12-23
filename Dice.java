public class Dice {
  public static int rollD20() {
    return (int) (Math.random() * 20) + 1;
  }

  public static int rollD10() {
    return (int) (Math.random() * 10) + 1;
  }

  public static int rollD6() {
    return (int) (Math.random() * 6) + 1;
  }
    
  public static int modifier(int attribute) {
    return (attribute - 10) / 2;
  }
}