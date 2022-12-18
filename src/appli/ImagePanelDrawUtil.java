package appli;

import UI.panels.ImagePanel;
import fresco.containers.Image;

/**
 * Utility Class that allows external components to directly interact with the imagePanel
 */
public class ImagePanelDrawUtil {
    /**
     * The ImagePanel to interact with
     */
    private static ImagePanel imagePanel;

    /**
     * The constructor of the Class that takes an ImagePanel that will be used through the class
     *
     * @param newImagePanel the ImagePanel
     */
    public ImagePanelDrawUtil(ImagePanel newImagePanel) {
        imagePanel = newImagePanel;
    }

    /**
     * Getter that gets the ImagePanel
     *
     * @return the ImagePanel
     */
    public static ImagePanel getImagePanel() {
        return imagePanel;
    }

    /**
     * Method that opens a modal on the ImagePanel
     * to let the user draw shapes on the ImagePanel
     *
     * @param shape the shape to draw
     */
    public static void openModalShape(String shape) {
        imagePanel.openModalShape(shape);
    }

    /**
     * Method that opens a modal on the ImagePanel
     * to let the user have the properties of the shapes (area and perimeter)
     *
     * @param action the action to do (show are or perimeter)
     */
    public static void openModalAction(String action) {
        imagePanel.openModalAction(action);
    }

    /**
     * Method that sets the currentImage of the ImagePanel to an Image present in the ListPanel (@see ListPanel)
     *
     * @param imageIndex the index of the Image to set
     */
    public static void setCurrentImage(int imageIndex) {
        imagePanel.removeAll();
        imagePanel.setCurrentImage((Image) imagePanel.getLinkedDrawing().getDrawing().getImages().stream().toArray()[imageIndex]);
        imagePanel.revalidate();
        imagePanel.repaint();

    }

    /**
     * Method that does a given transformation on the shapes of the ImagePanel
     *
     * @param transformation the transformation to apply to the shapes
     */
    public static void doTransformation(String transformation) {
        if (imagePanel != null)
            imagePanel.doTransformation(transformation);
    }
}
