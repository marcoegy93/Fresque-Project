package appli;

import java.awt.Dimension;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.Image;

public class X {
	private static ImagePanel imagePanel;
	private static Image i ; 
	
	public static void implementImagePanel( ImagePanel newImagePanel) {
		imagePanel = newImagePanel;
		i = new Image();
	}
	
	public static void addShape(GeometricShapeAbs shape) {
		i.addShape(shape);
		i.setPreferredSize(new Dimension(700,700));
		imagePanel.addImage(i);
	}
	
	
}
