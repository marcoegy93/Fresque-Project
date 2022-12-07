package UI.panels;

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

import UI.components.Toolbar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import fresco.containers.Image;

public class ImagePanel extends JPanel {
	private Toolbar toolbar;
    private Drawing drawing;
    private Image currentImage;
    private ListPanel listPanel;
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
		     listPanel = new ListPanel(currentImage.getName());
		     listPanel.setPreferredSize(new Dimension(250,690));

		    
		    
		 }

	    	setLayout(new BorderLayout());

		    this.add(listPanel, BorderLayout.WEST);
	        this.add(toolbar, BorderLayout.NORTH);

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
    
    public void showDrawingChange() {
    	showDrawingBool = !showDrawingBool;
    	repaint();
    }
    
    public void addNewImageBtnClick() {
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
			 listPanel.setNewDataOnList( drawing.getImages());
		    	repaint();
		    	removeAll();
		    	revalidate();
		    	repaint();

		 }
    }
    
    
    //Draw a grid
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	setLayout(new BorderLayout());
    	this.add( listPanel, BorderLayout.WEST);
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
				myPanelPolygon.setLayout(new BoxLayout(myPanelPolygon, BoxLayout.PAGE_AXIS));
				myPanelPolygon.setPreferredSize(new Dimension(400, 400));
				myPanelPolygon .add(new JLabel("x1:"));
				myPanelPolygon .add(xFieldPoligonList.get(0));
				myPanelPolygon .add(new JLabel("y1:"));
				myPanelPolygon .add(yFieldPoligonList.get(0));
				JButton addButton = new JButton("ADD");
				addButton.addActionListener(new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent e) {
						myPanelPolygon.removeAll();

						xFieldPoligonList.add( new JTextField(5) );
						yFieldPoligonList.add( new JTextField(5));

						for(int i = 0; i<xFieldPoligonList.size();i++) {

							myPanelPolygon.add(new JLabel("x"+(i+1)+": "));
							myPanelPolygon.add(xFieldPoligonList.get(i));
							myPanelPolygon.add(new JLabel("y"+(i+1)+": "));
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
  
   public void setCurrentImage(String name){
		
		for(Image image: drawing.getImages()) {
			if(name == image.getName()) {
				currentImage = image;
		    	repaint();
			}
			}
	}
   
   
   public void doTransformation(String transformation) {
	   int result;
	   switch(transformation) {
	   case "Rotation":
		   JTextField xRotation = new JTextField(5);
   	      JTextField yRotation = new JTextField(5);
 		  JTextField angleRotation = new JTextField(5);


   	      JPanel myPanelRotation = new JPanel();
   	   myPanelRotation.add(new JLabel("x:"));
   	myPanelRotation.add(xRotation);
   	myPanelRotation.add(Box.createHorizontalStrut(10)); // a spacer
   	myPanelRotation.add(new JLabel("y:"));
   	myPanelRotation.add(yRotation);

   	myPanelRotation.add(Box.createHorizontalStrut(20)); // a spacer
   	      
   	myPanelRotation.add(new JLabel("Angle:"));
   	myPanelRotation.add(angleRotation);
 	    
 	      
 	     result =  JOptionPane.showConfirmDialog(null, myPanelRotation, 
 	                 "Rotation", JOptionPane.OK_CANCEL_OPTION);
 	     
 	     if (result == JOptionPane.OK_OPTION) {
  	    	currentImage.rotation(new Point(Integer.parseInt(xRotation.getText()),Integer.parseInt(yRotation.getText())), Integer.parseInt(angleRotation.getText()));
 	      }
 	    repaint();
		   break;
	   case "Axial Symmetry":
		   JTextField x1AxialSymmetry = new JTextField(5);
   	      JTextField y1AxialSymmetry = new JTextField(5);
   	   JTextField x2AxialSymmetry = new JTextField(5);
	      JTextField y2AxialSymmetry = new JTextField(5);


   	      JPanel myPanelAxialSymmetry = new JPanel();
   	   myPanelAxialSymmetry.add(new JLabel("x1:"));
   	myPanelAxialSymmetry.add(x1AxialSymmetry);
   	myPanelAxialSymmetry.add(Box.createHorizontalStrut(10)); // a spacer
   	myPanelAxialSymmetry.add(new JLabel("y1:"));
   	myPanelAxialSymmetry.add(y1AxialSymmetry);

   	myPanelAxialSymmetry.add(Box.createHorizontalStrut(20)); // a spacer
   	      
    myPanelAxialSymmetry.add(new JLabel("x2:"));
   	myPanelAxialSymmetry.add(x2AxialSymmetry);
   	myPanelAxialSymmetry.add(Box.createHorizontalStrut(10)); // a spacer
   	myPanelAxialSymmetry.add(new JLabel("y2:"));
   	myPanelAxialSymmetry.add(y2AxialSymmetry);
 	    
 	      
 	     result =  JOptionPane.showConfirmDialog(null, myPanelAxialSymmetry, 
 	                 "Axial Symmetry", JOptionPane.OK_CANCEL_OPTION);
 	     
 	     if (result == JOptionPane.OK_OPTION) {
 	    	currentImage.axialSymmetry(
	    				new Line(
 	    						new Point(
 	    								 Integer.parseInt(x1AxialSymmetry.getText()),
 	    								 Integer.parseInt(y1AxialSymmetry.getText())
 	    								),
 	    						new Point(
	    								 Integer.parseInt(x2AxialSymmetry.getText()),
	    								 Integer.parseInt(y2AxialSymmetry.getText())
	    								)
 	    						 )
 							);
 	     }
 	    repaint();
		   break;
	   case "Central Symmetry":
		   JTextField xCentralSymetrie = new JTextField(5);
   	      JTextField yCentralSymetrie = new JTextField(5);


   	      JPanel myPanelCentralSymetrie = new JPanel();
   	   myPanelCentralSymetrie.add(new JLabel("x:"));
   	myPanelCentralSymetrie.add(xCentralSymetrie);
   	myPanelCentralSymetrie.add(Box.createHorizontalStrut(10)); // a spacer
   	myPanelCentralSymetrie.add(new JLabel("y:"));
   	myPanelCentralSymetrie.add(yCentralSymetrie);

 	     result =  JOptionPane.showConfirmDialog(null, myPanelCentralSymetrie, 
 	                 "Central Symmetry", JOptionPane.OK_CANCEL_OPTION);
 	     
 	     if (result == JOptionPane.OK_OPTION) {
 	    	for(GeometricShapeAbs shape : currentImage.getShapes()) {
 	    		shape.centralSymmetry(new Point(Integer.parseInt(xCentralSymetrie.getText()),Integer.parseInt(yCentralSymetrie.getText())));
 	    	}
 	      }
 	    repaint();
		   break;
	   case "Homothetie":
		   JTextField xHomothetie = new JTextField(5);
   	      JTextField yHomothetie = new JTextField(5);
   	      JTextField ratioHomothetie = new JTextField(5);


   	      JPanel myHomothetie = new JPanel();
   	   myHomothetie.add(new JLabel("x:"));
   	myHomothetie.add(xHomothetie);
   	myHomothetie.add(Box.createHorizontalStrut(10)); // a spacer
   	myHomothetie.add(new JLabel("y:"));
   	myHomothetie.add(yHomothetie);
   	myHomothetie.add(Box.createHorizontalStrut(20)); // a spacer
   	myHomothetie.add(new JLabel("ratio:"));
   	myHomothetie.add(ratioHomothetie);
 	     result =  JOptionPane.showConfirmDialog(null, myHomothetie, 
 	                 "Homothetie", JOptionPane.OK_CANCEL_OPTION);
 	     
 	     if (result == JOptionPane.OK_OPTION) {
 	    	currentImage.homothetie(new Point(Integer.parseInt(xHomothetie.getText()),Integer.parseInt(yHomothetie.getText())), Integer.parseInt(ratioHomothetie.getText()));
 	      }
 	    repaint();
		   break;
	   case "Translation":
		   JTextField xTranslation = new JTextField(5);
   	      JTextField yTranslation = new JTextField(5);


   	      JPanel myPanelTranslation = new JPanel();
   	   myPanelTranslation.add(new JLabel("x:"));
   	myPanelTranslation.add(xTranslation);
   	myPanelTranslation.add(Box.createHorizontalStrut(10)); // a spacer
   	myPanelTranslation.add(new JLabel("y:"));
   	myPanelTranslation.add(yTranslation);
   	
 	     result =  JOptionPane.showConfirmDialog(null,  myPanelTranslation, 
 	                 "Translation", JOptionPane.OK_CANCEL_OPTION);
 	     
 	     if (result == JOptionPane.OK_OPTION) {
 	    	currentImage.translation(Integer.parseInt(xTranslation.getText()),Integer.parseInt(yTranslation.getText()));
 	      }
 	    repaint();
		   break;
	   }
	   
   }
   
   
}
