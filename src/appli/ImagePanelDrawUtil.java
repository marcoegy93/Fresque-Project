package appli;

import UI.panels.ImagePanel;
import fresco.containers.Image;

public class ImagePanelDrawUtil {
    private static ImagePanel imagePanel;

    public static ImagePanel getImagePanel() {
        return imagePanel;
    }

    public ImagePanelDrawUtil(ImagePanel newImagePanel) {
        imagePanel = newImagePanel;
    }

    public static void openModalShape(String shape) {
        imagePanel.openModalShape(shape);
    }

    public static void openModalAction(String action) {
        imagePanel.openModalAction(action);
    }

    public static void setCurrentImage(int imageIndex) {
        imagePanel.removeAll();
        imagePanel.setCurrentImage((Image) imagePanel.getLinkedDrawing().getDrawing().getImages().stream().toArray()[imageIndex]);
        imagePanel.revalidate();
        imagePanel.repaint();

    }

    public static void doTransformation(String transformation) {
        if (imagePanel != null)
            imagePanel.doTransformation(transformation);
    }

    
    

}
