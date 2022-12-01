package appli;

import fresco.containers.geometricShapes.Line;
import fresco.containers.geometricShapes.utils.Point;

import javax.swing.*;

public class DrawingButton extends JButton {
    public DrawingButton(String name){
        setText(name);
        addActionListener(e -> {
            // TODO: 01/12/2022 CUSTOM MODAL FOR USER PROMPTS
            JOptionPane.showInternalMessageDialog(null, "Creating "+name);
        });
    }
}
