import java.awt.image.BufferedImage;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class fiberglass { 

    private BufferedImage image; // image to represent fiberglass insulation

    private Point pos; // position on the screen

    public fiberglass() { // put the fiberglass insulation on the screen (its just an FG for now but ill
                          // make some pictures later)
        loadImage();
        pos = new Point(0, 0);
    }

    private void loadImage() { // function to actually load in the image, throws error if image not found or
                               // smth
        try {
            final String imageName = "fiberglass insulation.png";
            image = ImageIO.read(new File("res/" + imageName));  // load in the image. placeholder image rn
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
}