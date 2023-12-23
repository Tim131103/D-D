import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpritePanel extends JPanel {
  private BufferedImage playerSprite;
  private int playerX, playerY;

  public SpritePanel() {
    // Laden Sie Ihr Sprite-Bild hier
    playerX = 0; // Setze die X-Position gemäß den Bounds
    playerY = 0; // Setze die Y-Position gemäß den Bounds
    
    // Load the player sprite image
    try {
      playerSprite = loadImage("G:\\Meine Ablage\\HNBK\\SW\\SW Abschluss\\Code\\SW Projekt DnD\\pixel_king_by_baldurancz_d96ytg3.png");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Error loading player sprite image: " + e.getMessage());
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Zeichnen Sie das Sprite an seiner festen Position
    if (playerSprite != null) {
      g.drawImage(playerSprite, playerX, playerY, null);
    } else {
      System.out.println("Player sprite image is null. Make sure it is loaded correctly.");
    }
  }

    // Methode zum Laden von Bildern (z.B., aus dem Dateisystem)
  private BufferedImage loadImage(String filename) throws IOException {
    return ImageIO.read(new File(filename));
  }

    // Setze die Position des Spielers
  public void setPlayerPosition(int x, int y) {
    playerX = x;
    playerY = y;
    repaint(); // Aktualisieren Sie das JPanel, um die Änderungen anzuzeigen
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Sprite Demo");
      SpritePanel panel = new SpritePanel();
      frame.add(panel);
      frame.setSize(1200, 600); // Vergrößere das JFrame, um die gesamte Position des Sprites zu zeigen
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    });
  }
}
