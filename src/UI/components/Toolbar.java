package UI.components;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import appli.ImagePanelDrawUtil;

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
        
        String[] transformations = {"","Rotation", "Axial Symmetry", "Central Symmetry", "Homothetie", "Translation"};
        JComboBox  jComboBox =  new JComboBox(transformations);
        jComboBox.setMaximumSize(new Dimension(200,50));
        jComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
            	ImagePanelDrawUtil.doTransformation( transformations[jComboBox.getSelectedIndex()] );
                jComboBox.setSelectedIndex(0);
			}
        });
      
        jComboBox. setSelectedIndex(0);
        jComboBox.setLightWeightPopupEnabled(false);
        add(jComboBox);
        addSeparator();
        addSeparator();
    }
}
