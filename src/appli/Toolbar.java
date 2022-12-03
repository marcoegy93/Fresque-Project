package appli;

import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar(){
        // TODO: 01/12/2022 CHANGE WITH ICONS
        add(new DrawingButton("Line"));
        add(new DrawingButton("Circle"));
        add(new DrawingButton("Ellipse"));
        add(new DrawingButton("Polygon"));
        addSeparator();
        String[] transformations = {"Rotation", "Axial Symmetry", "Central Symmetry", "Homothetie", "Translation"};
        add(new JComboBox(transformations));
        addSeparator();
        add(new JButton("Show area"));
        add(new JButton("Show perimeter"));
    }
}
