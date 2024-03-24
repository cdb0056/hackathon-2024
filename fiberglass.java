import java.awt.image.BufferedImage;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class fiberglass { 

    public BufferedImage image; // image to represent fiberglass insulation

    public Point pos; // position on the screen

    public fiberglass() { // put the fiberglass insulation on the screen (its just an FG for now but ill
                          // make some pictures later)
        loadImage();
        pos = new Point(0, 0);
    }

    public void loadImage() { // function to actually load in the image, throws error if image not found or
                               // smth
        try {
            final String imageName = "fiberglass insulation.png";
            image = ImageIO.read(new File("res/" + imageName));  // load in the image. placeholder image rn
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) { // i guess draw the image on the board
        g.drawImage(
            image, pos.x, pos.y, 50, 50, observer
        );
    }
}