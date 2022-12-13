package UI.components;


import appli.ImagePanelDrawUtil;

import javax.swing.*;

/**
 * Class that represents a button which shows the shape properties (area and perimeter)
 */
public class ActionButton extends JButton {

    /**
     * Constructor that creates a button that shows a given property for the current shape
     * @param name the property name
     */
    public ActionButton(String name) {
        setText(name);
        addActionListener(e -> {
            ImagePanelDrawUtil.openModalAction(name);
        });

    }


}
