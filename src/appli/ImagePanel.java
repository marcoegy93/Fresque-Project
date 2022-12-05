package appli;

import fresco.containers.Drawing;
import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.Circle;
import fresco.containers.geometricShapes.Ellipse;
import fresco.containers.geometricShapes.Line;

import fresco.containers.geometricShapes.Polygon;
import fresco.containers.geometricShapes.utils.Point;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import fresco.containers.Image;

public class ImagePanel extends JPanel {
	private Toolbar toolbar;
    private Drawing drawing;
    private Image currentImage;
    private JList<String> listImage;
    private  JButton addNewImageBtn;
    private  JButton showDrawing;
    private boolean showDrawingBool = false;

    public ImagePanel(){
        toolbar = new Toolbar();
        drawing = new Drawing();
        
		JTextField imageName = new JTextField(50);
		  JPanel addNewImage  = new JPanel();

		  addNewImage.add(new JLabel("Image Name:"));
		  addNewImage.add(imageName);
		  addNewImage.add(Box.createHorizontalStrut(10)); // a spacer
		  JColorChooser colorChooser = new JColorChooser();
		  addNewImage.add(colorChooser);
		 int result =  JOptionPane.showConfirmDialog(null, addNewImage , 
	                 "Create Image",  JOptionPane.DEFAULT_OPTION,
	                 JOptionPane.PLAIN_MESSAGE);
		 
		 if(result == JOptionPane.OK_OPTION) {
			Color c = colorChooser.getColor();
			 currentImage = new Image(imageName.getText(),c);
			 drawing.addImage(currentImage);
		     DefaultListModel<String> l = new DefaultListModel<>();
		     l.addElement(currentImage.getName());
		     listImage= new JList<>(l);

		        listImage.setPreferredSize(new Dimension(250,500));
			     listImage.setSelectedIndex(0);
			     listImage.addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						
					for(Image image: drawing.getImages()) {
						if(listImage.getSelectedValue() == image.getName()) {
							currentImage = image;
					    	repaint();
						}
						}
					}
				
			     
			     });

		     addNewImageBtn = new JButton("Add New");
		    addNewImageBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JTextField imageName = new JTextField(50);
					  JPanel addNewImage  = new JPanel();

					  addNewImage.add(new JLabel("Image Name:"));
					  addNewImage.add(imageName);
					  addNewImage.add(Box.createHorizontalStrut(10)); // a spacer
					  JColorChooser colorChooser = new JColorChooser();
					  addNewImage.add(colorChooser);
					 int result =  JOptionPane.showConfirmDialog(null, addNewImage , 
				                 "Create Image",  JOptionPane.DEFAULT_OPTION,
				                 JOptionPane.PLAIN_MESSAGE);
					 if(result == JOptionPane.OK_OPTION) {
						 Color c = colorChooser.getColor();
						 currentImage = new Image(imageName.getText(),c);
						 drawing.addImage(currentImage);
					     String[] l = new String[drawing.getImages().size()];
					     int index = 0;
						 for(Image image :  drawing.getImages()) {
							l[index]=image.getName(); 
							index++;
						 }
					     listImage.setListData(l)  ;
					     listImage.setSelectedIndex(drawing.getImages().size()-1);
					     repaint();

					 }
					 
				}
			});
		    
		    showDrawing = new JButton("Show the Drawing");
		    showDrawing .addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					showDrawingBool = !showDrawingBool;
			    	repaint();

				}
				
		    
				
		 });
		 }
    }
    
    private int getPanelAddImage() {
    	JTextField imageName = new JTextField(50);
		JPanel addNewImage  = new JPanel();

		  addNewImage.add(new JLabel("Image Name:"));
		  addNewImage.add(imageName);
		  addNewImage.add(Box.createHorizontalStrut(10)); // a spacer
		  JColorChooser colorChooser = new JColorChooser();
		  addNewImage.add(colorChooser);
		return   JOptionPane.showConfirmDialog(null, addNewImage , 
	                 "Create Image",  JOptionPane.DEFAULT_OPTION,
	                 JOptionPane.PLAIN_MESSAGE);
    }
    //Draw a grid
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
       
    	this.add(listImage);
	    this.add(addNewImageBtn);
	    this.add(showDrawing);
        this.add(toolbar);
        
    	
        Graphics g2 = (Graphics2D) g;
     
        if(showDrawingBool) {
        	for(Image image :this.drawing.getImages()) {
        		 for(GeometricShapeAbs shape : image.getShapes()){
        	            shape.draw(g2, image.getColor());
        	         }
        	}
        }
        for(GeometricShapeAbs shape : currentImage.getShapes()){
            shape.draw(g2,currentImage.getColor());
         }
        
       
    }
    
    public void addShape(GeometricShapeAbs shape) {
    	revalidate();
    	repaint();
    	currentImage.addShape(shape);
    	removeAll();
    	revalidate();
    	repaint();
    }
    
    ArrayList<JTextField> xFieldPoligonList = new ArrayList<JTextField>();
	ArrayList<JTextField> yFieldPoligonList = new ArrayList<JTextField>();
	
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
				JTextField xFieldEllipse = new JTextField(5);
				JTextField yFieldEllipse = new JTextField(5);
				JTextField widthEllipse = new JTextField(5);
				JTextField heightEllipse = new JTextField(5);


				JPanel myPanelEllipse = new JPanel();
				myPanelEllipse.add(Box.createHorizontalStrut(10)); // a spacer
				myPanelEllipse.add(new JLabel("x:"));
				myPanelEllipse.add(xFieldEllipse);
				myPanelEllipse.add(new JLabel("y:"));
				myPanelEllipse.add(yFieldEllipse);

				myPanelEllipse.add(Box.createHorizontalStrut(20)); // a spacer

				myPanelEllipse.add(new JLabel("width:"));
				myPanelEllipse.add(widthEllipse);
				myPanelEllipse.add(new JLabel("height:"));
				myPanelEllipse.add(heightEllipse);


				result =  JOptionPane.showConfirmDialog(null, myPanelEllipse,
						"Adding  Ellipse", JOptionPane.OK_CANCEL_OPTION);

				if (result == JOptionPane.OK_OPTION) {
					addShape(new Ellipse(new Point(
							Integer.parseInt(xFieldEllipse.getText()),
							Integer.parseInt(yFieldEllipse.getText())),
							Integer.parseInt(widthEllipse.getText()),
							Integer.parseInt(heightEllipse.getText())
					));
				}
				break;

			case "Polygon":
				
				xFieldPoligonList.add( new JTextField(5) );
				yFieldPoligonList.add( new JTextField(5));
				
				JPanel myPanelPolygon = new JPanel();
				myPanelPolygon.setPreferredSize(new Dimension(400, 400));
				myPanelPolygon .add(new JLabel("x:"));
				myPanelPolygon .add(xFieldPoligonList.get(0));
				myPanelPolygon .add(new JLabel("y:"));
				myPanelPolygon .add(yFieldPoligonList.get(0));
				JButton addButton = new JButton("ADD");
				addButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						myPanelPolygon.removeAll();

						xFieldPoligonList.add( new JTextField(5) );
						yFieldPoligonList.add( new JTextField(5));

						for(int i = 0; i<xFieldPoligonList.size();i++) {

							myPanelPolygon.add(new JLabel("x:"));
							myPanelPolygon.add(xFieldPoligonList.get(i));
							myPanelPolygon.add(new JLabel("y:"));
							myPanelPolygon.add(yFieldPoligonList.get(i));
						}
						myPanelPolygon.add(addButton);
						myPanelPolygon.repaint();
						myPanelPolygon.revalidate();
					}
				});
				myPanelPolygon.add(addButton);
						
				result =  JOptionPane.showConfirmDialog(null, myPanelPolygon,
						"Adding  Polygon", JOptionPane.OK_CANCEL_OPTION);
				
				if (result == JOptionPane.OK_OPTION) {
					System.out.println("d");
					Polygon p = new Polygon();
					for(int i = 0; i<xFieldPoligonList.size()-1;i++) {
						p.addPoint(
								new Point(
										Integer.parseInt(xFieldPoligonList.get(i).getText()),
										Integer.parseInt(yFieldPoligonList.get(i).getText())
										)
									);
					}
					
					addShape(p);
					xFieldPoligonList = new ArrayList<JTextField>();
					yFieldPoligonList = new ArrayList<JTextField>();
				}
				else {
					xFieldPoligonList = new ArrayList<JTextField>();
					yFieldPoligonList = new ArrayList<JTextField>();
				}
				break;
		
    	}
    }
    
    
   public void openModalAction(String action) {
	   System.out.println(action);
	   switch (action) {
	   case "Show area": 
		   JOptionPane.showMessageDialog(null,"The total area of this image is " + this.currentImage.calculateArea(), "Total Area", JOptionPane.INFORMATION_MESSAGE);
		   break;
	   case "Show perimeter":
		   JOptionPane.showMessageDialog(null,"The total perimeter of this image is " + this.currentImage.calculatePerimeter(), "Total Perimeter", JOptionPane.INFORMATION_MESSAGE);
		   break;
	   }
   }
  
   
}
