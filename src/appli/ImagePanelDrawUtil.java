package appli;

import java.awt.Dimension;
import java.util.List;
import java.util.Set;

import UI.panels.ImagePanel;
import fresco.containers.GeometricShapeAbs;
import fresco.containers.Image;

public class ImagePanelDrawUtil {
    private static ImagePanel imagePanel;

    public ImagePanelDrawUtil( ImagePanel newImagePanel) {
        imagePanel = newImagePanel;
    }

    public static void openModalShape(String shape) {
        imagePanel.openModalShape(shape);
    }

    public static void openModalAction(String action) {
        imagePanel.openModalAction(action);
    }
    
    public static void setCurrentImage(String name) {
        //imagePanel.setCurrentImage(name);

    }
    
    public static void addNewImageBtnClick() {
        //imagePanel.addNewImageBtnClick();

    }
    
    public static void showDrawingChange() {
    	//imagePanel.showDrawingChange();
    }
    
    public static void doTransformation(String transformation) {
    	if(imagePanel!= null)
    		imagePanel.doTransformation(transformation);
    }
}
