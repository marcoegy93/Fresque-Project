package UI;

import javax.swing.*;

import UI.panels.DrawingPanel;
import UI.panels.ImagePanel;
import UI.panels.MainPanel;
import appli.ImagePanelDrawUtil;

import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        super("Draw me a sheep...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);//RATIO 16:9
        setResizable(false);
        /*
        ImagePanel imagePanel = new ImagePanel();
        ImagePanelDrawUtil.ImagePanelDrawUtil(imagePanel);
        add(imagePanel);
        */
        add(new MainPanel(), BorderLayout.CENTER);
        //------------SHOULD ALWAYS BE AT THE END !!--------------
        setVisible(true);
    }
}