package UI.components;

import appli.ImagePanelDrawUtil;

import javax.swing.*;

public class DrawingButton extends JButton {
    public DrawingButton(String name, String pathToIcon) {
        setIcon(new ImageIcon(pathToIcon));
        setText(name);
        addActionListener(e -> {
            ImagePanelDrawUtil.openModalShape(name);
        });

    }


}
