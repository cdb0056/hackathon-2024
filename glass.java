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
    public Point startPos;
    public int x = 565;  //MAKE SURE G DOES NOT HAVE ANYTHING TO THR RIGHT OF OR DIRECTLY BELOW G, OTHERWISE IT GLITCHES. MUST BE RECTANGLE ISSUE
    public int y = 104;

    public int objectWidth;
    public int objectHeight;

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
        startPos = pos;
    }

    public int getStartX() {

        return startPos.x;

    }

    public int getStartY() {

        return startPos.y;

    }

    private void loadImage() { // function to actually load in the image, throws error if image not found or smth
        try {
            final String imageName = "glassCup.png";
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

        objectWidth = image.getWidth();
        objectHeight = image.getHeight();

        // Calculate the bounding box of the object
        int objectLeft = pos.x;
        int objectRight = pos.x + objectWidth;
        int objectTop = pos.y;
        int objectBottom = pos.y + objectHeight;

        // Check if the point is within the bounding box
        return (point.x >= objectLeft && point.x <= objectRight &&
            point.y >= objectTop && point.y <= objectBottom);

        //Rectangle bounds = new Rectangle(pos.x, pos.y, image.getWidth(), image.getHeight());
        //return bounds.contains(point);
    }

    public void setPosition(Point newPosition) {
        this.pos = newPosition;
    }

}