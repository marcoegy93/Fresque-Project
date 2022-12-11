package UI.panels;

import appli.Main;
import fresco.containers.Drawing;
import fresco.containers.Image;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private JPanel insidePanel;
    private JButton showDrawing;

    public Drawing getDrawing() {
        return drawing;
    }

    private final Drawing drawing;

    public DrawingPanel() {
        setLayout(new BorderLayout());
        insidePanel = new JPanel();
        insidePanel.setBackground(Color.orange);
        insidePanel.setLayout(new GridLayout(3, 3));
        drawing = new Drawing();
        MainPanel.getFresco().addDrawing(drawing);
        add(insidePanel, BorderLayout.CENTER);
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
