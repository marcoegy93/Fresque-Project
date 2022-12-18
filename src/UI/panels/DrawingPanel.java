package UI.panels;

import fresco.containers.Drawing;
import fresco.containers.Image;

import javax.swing.*;
import java.awt.*;

/**
 * UI Class that shows a specific Drawing on a JPanel,
 * which is a composition of images (@see Drawing)
 */
public class DrawingPanel extends JPanel {
    /**
     * The Drawing that will be shown on the DrawingPanel
     */
    private final Drawing drawing;

    /**
     * InsidePanel contains all the ImagePanel created for each Image of the Drawing
     * It allows to use a GridLayout for better interface, without impacting the DrawingPanel layout
     */
    private JPanel insidePanel;

    /**
     * Default Constructor of a Drawing Panel
     * Sets the InsidePanel as a GridLayout of 3 rows and 3 cols; Thus limiting the amount of ImagePanel to 9
     */
    public DrawingPanel() {
        setLayout(new BorderLayout());
        insidePanel = new JPanel();
        insidePanel.setLayout(new GridLayout(3, 3));
        drawing = new Drawing();
        MainPanel.getFresco().addDrawing(drawing);
        add(insidePanel, BorderLayout.CENTER);
    }

    /**
     * Getter that gets the Drawing of the DrawingPanel
     *
     * @return the Drawing
     */
    public Drawing getDrawing() {
        return drawing;
    }

    /**
     * Method that paints the component whenever it needs to be (on initialization, on update)
     * It first removes everything there is on the panel, then paints each Image as an ImagePanel
     * It then completes the grid with empty JPanels to have a consistent interface
     *
     * @param g the Graphics that allows the painting of the JPanel
     */
    @Override
    protected void paintComponent(Graphics g) {
        insidePanel.removeAll();
        insidePanel.revalidate();
        insidePanel.repaint();
        for (Image image : drawing.getImages()) {
            insidePanel.add(new ImagePanel(image));
        }
        for (int i = 0; i < 9 - drawing.getImages().size(); i++) {
            insidePanel.add(new JPanel());
        }
    }
}
