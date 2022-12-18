package appli;

import UI.MainFrame;

import javax.swing.*;

/**
 * Main class that launches our application's interface
 */
public class Main {
    /**
     * Main class that creates a MainFrame (@see MainFrame)
     * This will open the application's window
     *
     * @param args the arguments taken by the main (none in our case)
     */
    public static void main(String[] args) {
        JFrame frame = new MainFrame();
    }
}