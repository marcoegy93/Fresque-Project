package appli;

import java.awt.Dimension;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.Image;

public class ImagePanelDrawUtil {
    private static ImagePanel imagePanel;
    private static Image i ;

    public static void ImagePanelDrawUtil( ImagePanel newImagePanel) {
        imagePanel = newImagePanel;
        i = new Image();
    }

    public static void addShape(GeometricShapeAbs shape) {
        imagePanel.addShape(shape);
    }


}
