import java.awt.image.BufferedImage;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class fiber {

    private BufferedImage image; // image to represent fibrs

    public Point pos; // fiber's position on the screen

    public fiber() { // put the fiber on the screen (its just a F for now but ill make some pictures
                     // later) 
        loadImage();
        pos = new Point(0, 0);
    }

    private void loadImage() { // function to actually load in the image, throws error if image not found or
                               // smth
        try {
            final String imageName = "fibers.png";
            image = ImageIO.read(new File("res/" + imageName)); // load in the image. placeholder image rn
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) { // i guess draw the image on the board
        g.drawImage(
            image, pos.x * board.TILE_SIZE, pos.y * board.TILE_SIZE, observer
        );
    }
}