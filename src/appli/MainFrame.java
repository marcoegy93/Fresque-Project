package appli;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        super("Draw me a sheep...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);//RATIO 16:9
        setResizable(false);
        setLayout(new BorderLayout());
        ImagePanel imagePanel = new ImagePanel();
        ImagePanelDrawUtil.ImagePanelDrawUtil(imagePanel);
        add( imagePanel, BorderLayout.CENTER);

        //------------SHOULD ALWAYS BE AT THE END !!--------------
        setVisible(true);
    }
}
