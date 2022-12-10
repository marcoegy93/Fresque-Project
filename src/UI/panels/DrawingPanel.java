package UI.panels;

import fresco.containers.Drawing;
import fresco.containers.Image;
import fresco.containers.geometricShapes.Circle;
import fresco.containers.geometricShapes.utils.Point;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private JPanel insidePanel;
    public Drawing getDrawing() {
        return drawing;
    }

    private Drawing drawing;
    public DrawingPanel(){
        insidePanel = new JPanel();
        insidePanel.setLayout(new GridLayout(0,3));
        drawing = new Drawing();
        add(insidePanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        for(Image image : drawing.getImages()) {
            insidePanel.add(new ImagePanel(image));
        }
        add(insidePanel);

    }
}
