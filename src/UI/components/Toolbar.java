package UI.components;

import UI.panels.ListPanel;
import appli.ImagePanelDrawUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class which represents the Toolbar used to do various operations on an image
 */
public class Toolbar extends JToolBar {
    /**
     * The buttons that draws the shapes
     */
    private final DrawingButton addLine, addCircle, addEllipse, addPolygon;

    /**
     * The constructor that creates the toolbar with 4 sets of buttons
     * - Buttons for drawing shapes on the ImagePanel
     * - Buttons to show shapes properties (area and perimeter)
     * - Buttons do transformations on GeometricShapes in the image (@see ITransformation)
     * - Buttons that allow the navigation in the application (Back to DrawingPanel, Change Image...)
     * The Toolbar uses the default FlowLayout defined by Swing
     */
    public Toolbar() {
        add(addLine = new DrawingButton("Line", "resources/icons/line.png"));
        add(addCircle = new DrawingButton("Circle", "resources/icons/circle.png"));
        add(addEllipse = new DrawingButton("Ellipse", "resources/icons/ellipse.png"));
        add(addPolygon = new DrawingButton("Polygon", "resources/icons/polygon.png"));
        addSeparator();
        addSeparator();

        add(new ActionButton("Show area"));
        add(new ActionButton("Show perimeter"));

        addSeparator();
        addSeparator();

        String[] transformations = {"", "Rotation", "Axial Symmetry", "Central Symmetry", "Homothetie", "Translation"};
        JComboBox jComboBox = new JComboBox(transformations);
        jComboBox.setMaximumSize(new Dimension(200, 50));
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImagePanelDrawUtil.doTransformation(transformations[jComboBox.getSelectedIndex()]);
                jComboBox.setSelectedIndex(0);
            }
        });

        jComboBox.setSelectedIndex(0);
        jComboBox.setLightWeightPopupEnabled(false);
        add(jComboBox);
        addSeparator();
        addSeparator();
        JButton editImage = new JButton("Edit other images");
        editImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListPanel listPanel = new ListPanel();
                int result = JOptionPane.showConfirmDialog(null, listPanel,
                        "Select an image to edit", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    ImagePanelDrawUtil.setCurrentImage(listPanel.getSelectedIndex());
                }
            }
        });
        add(editImage);
        addSeparator();
    }

    /**
     * Disable a given button
     *
     * @param simpleName the name of the button to disable
     */
    public void disableButton(String simpleName) {
        switch (simpleName) {
            case "Line":
                addLine.setEnabled(false);
                break;
            case "Circle":
                addCircle.setEnabled(false);
                break;
            case "Ellipse":
                addEllipse.setEnabled(false);
                break;
            case "Polygon":
                addPolygon.setEnabled(false);
                break;
        }
    }

    /**
     * Enables all the buttons of the toolbar at once
     * Primarily used when switching between images
     */
    public void enableButtons() {
        addLine.setEnabled(true);
        addCircle.setEnabled(true);
        addEllipse.setEnabled(true);
        addPolygon.setEnabled(true);
    }
}
