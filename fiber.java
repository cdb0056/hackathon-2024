import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
//import javax.swing.JPanel;
import java.awt.image.ImageObserver;

public class fiber {

    private BufferedImage image; // image to represent fibrs

    public Point pos; // fiber's position on the screen
    //public Point rectPos;
    public Point startPos;

    public int objectWidth;
    public int objectHeight;

    public int x = 565; //CHANGE THESE X, Y  TO CHANGE WHERE THE FABRIC SPAWNS. SAME FOR ALL OBJECTS
    public int y = 25;

    private boolean isVisible = true;


    public fiber() { // put the fiber on the screen (its just a F for now but ill make some pictures
                     // later) 
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

    private void loadImage() { // function to actually load in the image, throws error if image not found or
                               // smth
        try {
            final String imageName = "fiber.png";
            image = ImageIO.read(new File("res/" + imageName)); // load in the image. placeholder image rn
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) { // draw the image
        //if (image != null) {
            g.drawImage(
            image, pos.x, pos.y, 50, 50, observer
        );
        //System.out.println("x: " + pos.x + " y: " + pos.y);
        //}
    }

    public boolean contains(Point point) {
        //rectPos.x = 200;
        //rectPos.y = 200;

        //Rectangle bounds = new Rectangle(pos.x, pos.y, image.getWidth(), image.getHeight());
        //return bounds.contains(point);

        
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
   
    }

    public void setPosition(Point newPosition) {
        this.pos = newPosition;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
}