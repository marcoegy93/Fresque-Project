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
        addSeparator();

       

        add(new ActionButton("Show area"));
        add(new ActionButton("Show perimeter"));
        
        addSeparator();
        addSeparator();
        
        String[] transformations = {"Rotation", "Axial Symmetry", "Central Symmetry", "Homothetie", "Translation"};
        add(new JComboBox(transformations));
        add(new ActionButton("DO"));
    }
}
