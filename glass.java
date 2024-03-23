import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class glass {

    private BufferedImage image; // image to represent glass

    private Point pos; // glass's position on the screen

    public glass() { // put the glass on the screen (its just a G for now but ill make some pictures later)
        loadImage(); 
        pos = new Point(0,0);
    }

    private void loadImage() { // function to actually load in the image, throws error if image not found or smth
        try {
            image = ImageIO.read(new File("glass.png")); // load in the image. placeholder image rn
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
}