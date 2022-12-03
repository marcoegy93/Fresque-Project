package appli;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.Line;

import fresco.containers.geometricShapes.utils.Point;
import javax.swing.*;
import java.awt.*;
import fresco.containers.Image;

public class ImagePanel extends JPanel {
	private Toolbar toolbar;
    public ImagePanel(){
    	toolbar = new Toolbar();
        add(toolbar, BorderLayout.NORTH);
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
    
    public void addImage(Image image) {
    	removeAll();
    	repaint();
    	revalidate();
    	add(toolbar);
    	add(image);
    	repaint();
    	revalidate();
    }

}
