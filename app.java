//package hackathon;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.*;
/*import static board.COLUMNS;
import static board.ROWS;
import static board.TILE_SIZE;*/

public class app {
    private static JFrame window;
    private static ActionListener listener;

    private static void initWindow() { // make window for the game
        JFrame window = new JFrame("recyclables"); // set title for window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stop app when window is closed

        window.setResizable(true); // allow user to resize window
        window.pack();
        window.setLocationRelativeTo(null); // window appears in the middle of the screen
        window.setSize(400,300);
        
        window.setVisible(true); // this makes the window show up 
    }

    // call the method :D 
    public static void main(String[] args) {
        initWindow(); // call the method to show the window

        /*board board = new board(listener);
        window.add(board);*/
    }
}
