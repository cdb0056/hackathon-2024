import java.awt.image.BufferedImage;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.Rectangle;

public class glass {

    private BufferedImage image; // image to represent glass

    public Point pos; // glass's position on the screen
    public int x = 200;
    public int y = 200;

    private boolean isVisible = true;

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public glass() { // put the glass on the screen (its just a G for now but ill make some pictures later)
        loadImage(); 
        pos = new Point(x, y);
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
        g.drawImage(
            image, pos.x, pos.y, 50, 50, observer
        );
    }

    public boolean contains(Point point) {
        Rectangle bounds = new Rectangle(pos.x, pos.y, image.getWidth(), image.getHeight());
        return bounds.contains(point);
    }

    public void setPosition(Point newPosition) {
        this.pos = newPosition;
    }

}