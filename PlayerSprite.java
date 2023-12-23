import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayerSprite extends JPanel {
  private BufferedImage playerSprite;
  private int playerX, playerY;

  public PlayerSprite(String spritePath) {
    playerX = 0;
    playerY = 0;
    
    // Load the player sprite image based on the given path
    try {
      playerSprite = loadImage(spritePath);
    } catch (IOException e) {
      System.err.println("Error loading player sprite image: " + e.getMessage());
      playerSprite = loadDefaultSprite();
    }
    
    setPreferredSize(new Dimension(playerSprite.getWidth(), playerSprite.getHeight()));
    setVisible(true);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Draw the sprite at its fixed position
    if (playerSprite != null) {
      g.drawImage(playerSprite, playerX, playerY, null);
    } else {
      System.out.println("The player sprite image is null. Make sure it was loaded correctly.");
    }
  }

    // Set the player's position
  public void setPlayerPosition(int x, int y) {
    playerX = x;
    playerY = y;
    repaint(); // Update the JPanel to show the changes
  }

    // Load an image from the file system
  private BufferedImage loadImage(String filename) throws IOException {
    try {
      System.out.println("Loading image from path: " + filename);
      return ImageIO.read(new File(filename));
    } catch (IOException e) {
      // Print the error and throw a new IOException
      System.err.println("Error loading image: " + e.getMessage());
      throw new IOException("Unable to load image: " + filename, e);
    }
  }

    
  private BufferedImage loadDefaultSprite() {
    try {
      String defaultSpritePath = "G:\\Meine Ablage\\HNBK\\SW\\SW Abschluss\\Code\\SW Projekt DnD\\Picture Resized\\gourry_by_albertov_df38ima (1).png";
      return ImageIO.read(new File(defaultSpritePath));
    } catch (IOException e) {
      System.err.println("Error loading default sprite: " + e.getMessage());
      return null; 
    }
    
  }
  public void setPlayerSprite(String spritePath) {
    try {
      playerSprite = loadImage(spritePath);
      setPreferredSize(new Dimension(playerSprite.getWidth(), playerSprite.getHeight()));
      setVisible(true);
      repaint(); // repaint to reflect the new sprite
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println("Error loading player sprite image: " + e.getMessage());
    }
  }

}
