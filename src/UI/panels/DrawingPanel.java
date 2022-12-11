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
    private JButton showDrawing;
    private JScrollPane jScrollPane;
    public Drawing getDrawing() {
        return drawing;
    }

    private Drawing drawing;
    public DrawingPanel(){
        setLayout(new BorderLayout());

        jScrollPane = new JScrollPane(insidePanel);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        insidePanel = new JPanel();
        insidePanel.setBackground(Color.orange);
        insidePanel.setLayout(new GridLayout(3,3));
        drawing = new Drawing();
        add(insidePanel, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        insidePanel.removeAll();
        insidePanel.revalidate();
        insidePanel.repaint();
        for (Image image : drawing.getImages()){
            insidePanel.add(new ImagePanel(image));
        }
        for(int i=0; i<9-drawing.getImages().size(); i++){
            insidePanel.add(new JPanel());
        }

    }
}
