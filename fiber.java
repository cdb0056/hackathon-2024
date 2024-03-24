import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;

public class fiber extends JPanel implements MouseListener, MouseMotionListener {

    public BufferedImage image; // image to represent fibrs

    public Point pos; // fiber's position on the screen

    private boolean isDragging = false;
    private int dragOffsetX, dragOffsetY;

    public fiber() { // put the fiber on the screen (its just a F for now but ill make some pictures
                     // later) 
        loadImage();
        pos = new Point(0, 0);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void loadImage() { // function to actually load in the image, throws error if image not found or
                               // smth
        try {
            final String imageName = "fibers.png";
            image = ImageIO.read(new File("res/" + imageName)); // load in the image. placeholder image rn
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, board b) { // draw the image
        if (image != null) {
            g.drawImage(image, pos.x * b.TILE_SIZE, pos.y * b.TILE_SIZE, null);
        }
    }

    // MouseListener methods
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseX >= pos.x && mouseX < pos.x + image.getWidth() &&
            mouseY >= pos.y && mouseY < pos.y + image.getHeight()) {
            isDragging = true;
            dragOffsetX = mouseX - pos.x;
            dragOffsetY = mouseY - pos.y;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isDragging = false;
    }

    // MouseMotionListener methods
    @Override
    public void mouseDragged(MouseEvent e) {
        if (isDragging) {
            int newX = e.getX() - dragOffsetX;
            int newY = e.getY() - dragOffsetY;
            pos.setLocation(newX, newY);
            repaint();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}