package UI.components;

import appli.ImagePanelDrawUtil;

import javax.swing.*;

public class DrawingButton extends JButton {
    public DrawingButton(String name) {

        setText(name);
        addActionListener(e -> {
            ImagePanelDrawUtil.openModalShape(name);
        });

    }


}