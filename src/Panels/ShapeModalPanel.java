package Panels;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;

public abstract class ShapeModalPanel extends JDialog{

	
	public ShapeModalPanel(String reson) {
	    JLabel labelShape = new JLabel("Ajout " + reson);
	    labelShape.setFont(new Font("Verdana", Font.PLAIN, 25));
	    add(labelShape);
	    
        setSize(300, 300); 
        setVisible(true); 
	}
	
}
