package appli;

import fresco.containers.Drawing;
import fresco.containers.geometricShapes.Line;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Drawing drawing;

    public ImagePanel(){
        add(new Toolbar(), BorderLayout.NORTH);
    }

    //Draw a grid
    @Override
    public void paintComponent(Graphics g) {
        //https://tips4java.wordpress.com/2009/05/08/custom-painting-approaches/
        Graphics g2 = (Graphics2D) g;
        int height = getHeight();
        int width = getWidth();
        for(int i=0; i<10; i++){
            g.drawLine((width/10)*i, 0, (width/10)*i, height);
            g.drawLine(0, (height/10)*i, width, (height/10)*i);
        }
    }


}
