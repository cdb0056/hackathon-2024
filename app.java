import javax.swing.*;

public class app {
    private static void initWindow() { // make window for the game
        JFrame window = new JFrame("recyclables"); // set title for window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stop app when window is closed

        window.setResizable(true); // dont allow user to resize window
        window.setSize(400, 300); // set initial size of the window
        window.setVisible(true); // this makes the window show up 
    }

    // call the method :D 
    public static void main(String[] args) {
        initWindow(); // call the method to initialize the window
        
    }
}
