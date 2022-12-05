package appli;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.Circle;
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

        for(GeometricShapeAbs shape : image.getShapes()){
           shape.draw(g2);
        }
    }
    
    public void addShape(GeometricShapeAbs shape) {
        image.addShape(shape);
        removeAll();
        repaint();
        revalidate();
    }

    public void openModalShape(String shape) {
    	int result;
    	switch (shape) {
    	case "Line":
    	  JTextField x1FieldLine = new JTextField(5);
  	      JTextField y1FieldLine  = new JTextField(5);
  	      
  	      JTextField x2FieldLine  = new JTextField(5);
	      JTextField y2FieldLine  = new JTextField(5);

  	      JPanel myPanelLine  = new JPanel();
  	      myPanelLine .add(new JLabel("x1:"));
  	      myPanelLine .add(x1FieldLine );
  	      myPanelLine .add(Box.createHorizontalStrut(10)); // a spacer
  	      myPanelLine .add(new JLabel("y1:"));
  	      myPanelLine .add(y1FieldLine );

  	      myPanelLine .add(Box.createHorizontalStrut(20)); // a spacer
  	      
  	     myPanelLine .add(new JLabel("x2:"));
	      myPanelLine .add(x2FieldLine );
	      myPanelLine .add(Box.createHorizontalStrut(10)); // a spacer
	      myPanelLine .add(new JLabel("y2:"));
	      myPanelLine .add(y2FieldLine );
	      
	     result =  JOptionPane.showConfirmDialog(null, myPanelLine , 
	                 "Adding Line", JOptionPane.OK_CANCEL_OPTION);
	     
	     if (result == JOptionPane.OK_OPTION) {
	    	 addShape( 
	    			 new Line(
		    			 new Point(Integer.parseInt(x1FieldLine .getText()),Integer.parseInt(y1FieldLine .getText())),
		    			 new Point(Integer.parseInt(x2FieldLine .getText()),Integer.parseInt(y2FieldLine .getText()))
	    					 )
	    			 );
	        
	      }
	     break;
    	case "Circle":
    		  JTextField xFieldCircle = new JTextField(5);
      	      JTextField yFieldCircle = new JTextField(5);
    		  JTextField rayFieldCircle = new JTextField(5);


      	      JPanel myPanelCircle = new JPanel();
      	      myPanelCircle.add(new JLabel("x:"));
      	      myPanelCircle.add(xFieldCircle);
      	      myPanelCircle.add(Box.createHorizontalStrut(10)); // a spacer
      	      myPanelCircle.add(new JLabel("y:"));
      	      myPanelCircle.add(yFieldCircle);

      	      myPanelCircle.add(Box.createHorizontalStrut(20)); // a spacer
      	      
      	     myPanelCircle.add(new JLabel("Ray:"));
    	      myPanelCircle.add(rayFieldCircle);
    	    
    	      
    	     result =  JOptionPane.showConfirmDialog(null, myPanelCircle, 
    	                 "Adding  Circle", JOptionPane.OK_CANCEL_OPTION);
    	     
    	     if (result == JOptionPane.OK_OPTION) {
    	    	 addShape(new Circle(new Point(
						 Integer.parseInt(xFieldCircle.getText()),
						 Integer.parseInt(yFieldCircle.getText())),
						 Integer.parseInt(rayFieldCircle.getText())
				 ));
    	      }
    		break;
			case "Ellipse":

				break;
    	}
    }
    
    
   public void openModalAction(String action) {
	   System.out.println(action);
	   switch (action) {
	   case "Show area": 
		   JOptionPane.showMessageDialog(null,"The total area of this image is " + this.image.calculateArea(), "Total Area", JOptionPane.INFORMATION_MESSAGE);
		   break;
	   case "Show perimeter":
		   JOptionPane.showMessageDialog(null,"The total perimeter of this image is " + this.image.calculatePerimeter(), "Total Perimeter", JOptionPane.INFORMATION_MESSAGE);
		   break;
	   }
   }
  
   
}
