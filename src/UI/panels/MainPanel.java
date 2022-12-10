package UI.panels;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private CardLayout cards;
    private final JPanel cardHolder = this;
    private static final String cardA = "A";
    private static final String cardB = "B";

    private class Switcher implements ActionListener{
        String card;
        Switcher(String card) { this.card = card; }
        @Override
        public void actionPerformed(ActionEvent e) {
            cards.show(cardHolder, card);
        }

    }
    public MainPanel(){
        DrawingPanel drawingPanel = new DrawingPanel();
        JButton ba = new JButton("Go to image panel");
        ba.addActionListener(new Switcher(cardB));
        drawingPanel.add(ba);

        ImagePanel imagePanel = new ImagePanel(drawingPanel);
        JButton bb = new JButton("Back to drawing panel");
        bb.addActionListener(new Switcher(cardA));
        imagePanel.getToolbar().add(bb);

        cards = new CardLayout();
        setLayout(cards);
        add(drawingPanel, cardA);
        add(imagePanel, cardB);
    }
}
