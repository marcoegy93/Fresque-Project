package UI.panels;


import fresco.Fresco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private final CardLayout cards;
    private final JPanel cardHolder = this;
    private static final String cardA = "A";
    private static final String cardB = "B";

    public static Fresco getFresco() {
        return fresco;
    }

    private static Fresco fresco;

    private class Switcher implements ActionListener {
        String card;
        Switcher(String card) {
            this.card = card;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            cardHolder.revalidate();
            cardHolder.repaint();
            cards.show(cardHolder, card);
        }
    }

    public MainPanel() {
        fresco = new Fresco();

        DrawingPanel drawingPanel = new DrawingPanel();
        JButton ba = new JButton("Go to image panel");

        ba.addActionListener(new Switcher(cardB));
        drawingPanel.add(ba, BorderLayout.NORTH);

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
