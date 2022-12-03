package appli;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import fresco.containers.geometricShapes.Circle;
import fresco.containers.geometricShapes.Ellipse;
import fresco.containers.geometricShapes.Line;
import fresco.containers.geometricShapes.utils.Point;

import javax.swing.*;

public class DrawingButton extends JButton {
    public DrawingButton(String name){
   
        setText(name);
        addActionListener(e -> {

            if(name =="Line") {
        		Line l =new Line(new Point(),new Point());
                ImagePanelDrawUtil.addShape(l);
        	}
        	if(name=="Circle") {
        		Circle c = new Circle(new Point(10,20),new Point(200,300));

                ImagePanelDrawUtil.addShape(c);
        	}
        	if(name=="Ellipse") {
        		Ellipse el = new Ellipse(new Point(),5,10);

                ImagePanelDrawUtil.addShape(el);
        	}
           
        });
      
    }
    
 
}
