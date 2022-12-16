package UI;

import UI.panels.MainPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Main UI Class that represents the containing window of our Application
 */
public class MainFrame extends JFrame {

    /**
     * The default constructor of the MainFrame
     * It sets the title of the window, its size (a 16:9 ratio) and the component(s) it will contain
     * We decided to not let the user resize the window.
     */
    public MainFrame() {
        super("Draw me a sheep...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);//RATIO 16:9
        setResizable(false);
        add(new MainPanel(), BorderLayout.CENTER);
        //------------SHOULD ALWAYS BE AT THE END !!--------------
        setVisible(true);
    }
}