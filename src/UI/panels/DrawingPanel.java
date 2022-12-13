package UI.panels;

import fresco.containers.Drawing;
import fresco.containers.Image;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private final Drawing drawing;
    private JPanel insidePanel;

    public DrawingPanel() {
        setLayout(new BorderLayout());
        insidePanel = new JPanel();
        insidePanel.setBackground(Color.orange);
        insidePanel.setLayout(new GridLayout(3, 3));
        drawing = new Drawing();
        MainPanel.getFresco().addDrawing(drawing);
        add(insidePanel, BorderLayout.CENTER);
    }

    public Drawing getDrawing() {
        return drawing;
    }

    @Override
    protected void paintComponent(Graphics g) {
        insidePanel.removeAll();
        insidePanel.revalidate();
        insidePanel.repaint();
        for (Image image : drawing.getImages()) {
            insidePanel.add(new ImagePanel(image));
        }
        for (int i = 0; i < 9 - drawing.getImages().size(); i++) {
            insidePanel.add(new JPanel());
        }
    }
}
