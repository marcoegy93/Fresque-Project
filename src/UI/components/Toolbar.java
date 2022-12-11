package UI.components;

import UI.panels.ListPanel;
import appli.ImagePanelDrawUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JToolBar {
    private final DrawingButton addLine;
    private final DrawingButton addCircle;
    private final DrawingButton addEllipse;
    private final DrawingButton addPolygon;

    public Toolbar() {
        addLine = new DrawingButton("Line");
        add(addLine);
        addCircle = new DrawingButton("Circle");
        add(addCircle);
        addEllipse = new DrawingButton("Ellipse");
        add(addEllipse);
        addPolygon = new DrawingButton("Polygon");
        add(addPolygon);
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
    }

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

    public void enableButtons() {
        addLine.setEnabled(true);
        addCircle.setEnabled(true);
        addEllipse.setEnabled(true);
        addPolygon.setEnabled(true);
    }
}
