package UI.components;

import appli.ImagePanelDrawUtil;

import javax.swing.*;

/**
 * Class that represents a button which draw shapes on an image
 */
public class DrawingButton extends JButton {

    /**
     * Constructor that creates a button to draw a given shape on the panel
     *
     * @param name       the name of the shape that the button draws
     * @param pathToIcon the path to the icon shown on the button
     */
    public DrawingButton(String name, String pathToIcon) {
        setIcon(new ImageIcon(pathToIcon));
        setText(name);
        addActionListener(e -> {
            ImagePanelDrawUtil.openModalShape(name);
        });

    }


}
