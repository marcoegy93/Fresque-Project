package Panels;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 
public class FrescoPanel extends JPanel implements ActionListener  {

	
	public FrescoPanel () {
				
		
		 //Label add shape
	    JLabel labelShape = new JLabel("Ajouter Forme");
	    labelShape.setBounds(120,40,300,50);
	    labelShape.setFont(new Font("Verdana", Font.PLAIN, 25));
	    add( labelShape);
	    
	    
	    //Add button circle
	    JButton btnElipse = new JButton("Elipse");
	    btnElipse.setBounds(50,100,150,40);
	    btnElipse.addActionListener(this);
	    this.add(btnElipse);
	    
	    //Add button circle
	    JButton btnCircle = new JButton("Circle");
	    btnCircle.setBounds(220,100,150,40);
	    btnCircle.addActionListener(this);
	    this.add(btnCircle);
	   
	    
	    //Add button line
	    JButton btnLine = new JButton("Line");
	    btnLine.setBounds(50,150,150,40);
	    btnLine.addActionListener(this);
	    this.add(btnLine);
	    
	    //Add button Polygon
	    JButton btnPolygon = new JButton("Polygon");
	    btnPolygon.setBounds(220,150,150,40);
	    btnPolygon.addActionListener(this);
	    this.add(btnPolygon);
	    
	    //Label add Transformation
	    JLabel labelTransformation = new JLabel("Transformations");
	    labelTransformation.setBounds(115,220,300,40);
	    labelTransformation.setFont(new Font("Verdana", Font.PLAIN, 25));
	    this.add(labelTransformation);
	    
	    //Add button Translation
	    JButton btnTranslation = new JButton("Translation");
	    btnTranslation.setBounds(50,270,315,20);
	    this.add(btnTranslation);
	    
	    //Add button Homotethie
	    JButton btnHomotethie = new JButton("Homotethie");
	    btnHomotethie.setBounds(50,300,315,20);
	    this.add(btnHomotethie);
	    
	  //Add button Homotethie
	    JButton btnRotation = new JButton("Rotation");
	    btnRotation.setBounds(50,330,315,20);
	    this.add(btnRotation);
	    

	    //Add button Symetrie Central
	    JButton btnCentralSymetrie = new JButton("Symetrie Central");
	    btnCentralSymetrie.setBounds(50,360,315,20);
	    this.add(btnCentralSymetrie);
	    
	    //Add button Axial Central
	    JButton btnAxialSymetrie = new JButton("Symetrie Central");
	    btnAxialSymetrie.setBounds(50,390,315,20);
	    this.add(btnAxialSymetrie);
	    
	    
	    //Label add Transformation
	    JLabel labelAP = new JLabel("Air & Perimetre");
	    labelAP.setBounds(115,430,300,40);
	    labelAP.setFont(new Font("Verdana", Font.PLAIN, 25));
	    this.add(labelAP);
	    
	    //Add button Area
	    JButton btnAir = new JButton("Calculer Air");
	    btnAir.setBounds(50,480,315,20);
	    this.add(btnAir);
	    
	    //Add button Perimeter
	    JButton btnPerimeter = new JButton("Calculer Perimetre");
	    btnPerimeter.setBounds(50,510,315,20);
	    this.add(btnPerimeter);
		//setSize(600,600);
		setBounds(0,0,1300,700);
	}

	@Override
	public void paintComponent(Graphics g){
		Graphics g2 = (Graphics2D) g;
		g.drawLine(450, 315, 1250, 315);
		g.drawLine(820, 50, 820, 550);
		
		for(int i = 450;i<=1250;i+=10) {
			g.drawLine(i, 318, i, 312);
		}
		
		for(int i = 50;i<=550;i+=10) {
			g.drawLine(822, i, 818, i);
		}

}

	@Override
	public void actionPerformed(ActionEvent e) {
		String reson = e.getActionCommand(); 
		System.out.println(e);
		
		switch(reson) {
			case "Circle" : new CircleModalPanel(reson); break;
			case "Elipse":  new ElipseModalPanel(reson); break;
			case "Line":  new ElipseModalPanel(reson); break;
			case "Polygon":  new ElipseModalPanel(reson); break;
		}
		
		
	}
	
}
