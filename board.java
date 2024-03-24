import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class board extends JPanel implements MouseListener, MouseMotionListener {
    // board things
    public static final int TILE_SIZE = 50;
    public static final int ROWS = 12;
    public static final int COLUMNS = 18;

    // things that appear on the board
    // elements
    private glass glass;
    private fiber fiber;

    // results
    private fiberglass fiberglass;

    // other
    private ActionListener listener;
    private boolean isDragging = false;
    private int dragOffsetX, dragOffsetY;
    private Point draggedItemPosition;

    public boolean fiberDrag = false;
    public boolean  glassDrag = false;

    public board(ActionListener listener) {
        this.listener = listener;
    }

    public board() { // create board/background
        setPreferredSize(new Dimension(TILE_SIZE * COLUMNS, TILE_SIZE * ROWS)); // set the size
        setBackground(new Color(232, 232, 232)); // set the bg color

        // initialize elements
        glass = new glass();
        fiber = new fiber();

        // initialize some resulting elements
        fiberglass = new fiberglass();

        // add mouse listeners
        addMouseListener(this);
        addMouseMotionListener(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawGlass(g);
        drawFiberglass(g);
        drawFiber(g);
    }

    private void drawBackground(Graphics g) { // draw the bg, may look weird cuz its orginally supposed to be checkered
        g.setColor(new Color(232, 232, 232));
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                // only color every other tile
                if ((row + col) % 2 == 1) {
                    // draw a square tile at the current row/column position
                    g.fillRect(
                        col * TILE_SIZE, 
                        row * TILE_SIZE, 
                        TILE_SIZE, 
                        TILE_SIZE
                    );
                }
            }    
        }
    }

    private void drawGlass(Graphics g) {
        glass.draw(g, this);
    }

    private void drawFiber(Graphics g) {
        fiber.draw(g, this);
    }

    private void drawFiberglass(Graphics g) {
        fiberglass.draw(g, this);
    }

    // mouse listener methods

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
    
        // check if the mouse is pressed on the fiber object
        if (fiber != null && fiber.contains(new Point(mouseX, mouseY)) ) {
            isDragging = true;
            dragOffsetX = mouseX - fiber.pos.x;
            dragOffsetY = mouseY - fiber.pos.y;
            fiberDrag = true;

        }

        if (glass != null && glass.contains(new Point(mouseX, mouseY)) ) {
            isDragging = true;
            dragOffsetX = mouseX - glass.pos.x;
            dragOffsetY = mouseY - glass.pos.y;
            glassDrag = true;
        }

    }

    @Override
public void mouseDragged(MouseEvent e) {
    if (isDragging) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        int newX = mouseX - dragOffsetX;
        int newY = mouseY - dragOffsetY;

        if (fiberDrag == true) {
            fiber.setPosition(new Point(newX, newY));
        }

        if (glassDrag == true) {
            glass.setPosition(new Point(newX, newY));
        }

        //fiber.setPosition(new Point(newX, newY));

        /*if (mouseX == fiber.pos.x && mouseY == fiber.pos.y) {
            fiber.setPosition(new Point(newX, newY));
        }

        if (mouseX == glass.pos.x && mouseY == glass.pos.y) {
            glass.setPosition(new Point(newX, newY));
        }*/
     

        
        repaint();
    }
}

    @Override
    public void mouseReleased(MouseEvent e) {
        // when the mouse button is released

        fiberDrag = false;
        glassDrag = false;

    }

    @Override 
    public void mouseClicked(MouseEvent e) {
        // when the mouse button has been clicked (pressed and released)
    }

    @Override 
    public void mouseEntered(MouseEvent e) {
        // when the mouse enters a component
    }

    @Override 
    public void mouseExited(MouseEvent e) {
        // when the mouse exits a component
    }

    @Override 
    public void mouseMoved(MouseEvent e) {
        // when the mouse button is moved ?!
    }

}