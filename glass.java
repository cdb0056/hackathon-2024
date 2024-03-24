import java.awt.image.BufferedImage;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class glass {

    private BufferedImage image; // image to represent glass

    public Point pos; // glass's position on the screen

    private boolean isVisible = true;

    // Getter method for visibility
    public boolean isVisible() {
        return isVisible;
    }

    // Setter method for visibility
    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public glass() { // put the glass on the screen (its just a G for now but ill make some pictures later)
        loadImage(); 
        pos = new Point(0,0);
    }

    private void loadImage() { // function to actually load in the image, throws error if image not found or smth
        try {
            final String imageName = "glass.png";
            image = ImageIO.read(new File("res/" + imageName)); // load in the image. placeholder image rn
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) { // i guess draw the image on the board
        if (isVisible && image != null) {
            int scaledWidth = 50;
            int scaledHeight = 50;
            g.drawImage(image, pos.x, pos.y, scaledWidth, scaledHeight, observer);
        }
    }

    public boolean contains(Point point) {
        Rectangle bounds = new Rectangle(pos.x, pos.y, image.getWidth(), image.getHeight());
        return bounds.contains(point);
    }

    public void setPosition(Point newPosition) {
        this.pos = newPosition;
    }
}