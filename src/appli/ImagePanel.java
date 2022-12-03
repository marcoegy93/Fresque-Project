package appli;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.Line;

import fresco.containers.geometricShapes.utils.Point;
import javax.swing.*;
import java.awt.*;
import fresco.containers.Image;

public class ImagePanel extends JPanel {
	private Toolbar toolbar;
    private Image image;
    public ImagePanel(){
        image = new Image();
        toolbar = new Toolbar();
        this.add(toolbar);
    }

    //Draw a grid
    @Override
    public void paintComponent(Graphics g) {
        this.add(toolbar);
        //https://tips4java.wordpress.com/2009/05/08/custom-painting-approaches/
        Graphics g2 = (Graphics2D) g;
        int height = getHeight();
        int width = getWidth();

        /*
        for (int i = 0; i < 10; i++) {
            g.drawLine((width / 10) * i, 0, (width / 10) * i, height);
            g.drawLine(0, (height / 10) * i, width, (height / 10) * i);
        }
         */
        for(GeometricShapeAbs shape : image.getShapes()){
            drawingDispatcher(shape, g2);
        }
    }
    
    public void addShape(GeometricShapeAbs shape) {
        image.addShape(shape);
        removeAll();
        repaint();
        revalidate();
    }

    private void drawingDispatcher(GeometricShapeAbs s, Graphics g){
        switch(s.getClass().getSimpleName()){
            case "Line":
                g.drawLine(0,0,1000,500);
                break;
            case "Circle":
                g.drawOval((int)s.getCenter().getX(), (int)s.getCenter().getY(), 200, 200);
        }
    }
}
