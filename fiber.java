import java.awt.image.BufferedImage;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class fiber {

    private BufferedImage image; // image to represent fibrs

    private Point pos; // fiber's position on the screen

    public fiber() { // put the fiber on the screen (its just a F for now but ill make some pictures
                     // later)
        loadImage();
        pos = new Point(0, 0);
    }

    private void loadImage() { // function to actually load in the image, throws error if image not found or
                               // smth
        try {
            image = ImageIO.read(new File("fiber.png")); // load in the image. placeholder image rn
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
}