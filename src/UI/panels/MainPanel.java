package UI.panels;


import fresco.Fresco;
import fresco.containers.Drawing;
import fresco.containers.geometricShapes.utils.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private static final String cardA = "A";
    private static final String cardB = "B";
    private static Fresco fresco;
    private final CardLayout cards;
    private final JPanel cardHolder = this;

    public MainPanel() {
        fresco = new Fresco();
        JToolBar newToolbar = new JToolBar();
        DrawingPanel drawingPanel = new DrawingPanel();
        JButton ba = new JButton("Go to image panel");
        JButton areaDrawing = new JButton("Show area");
        areaDrawing.addActionListener(e -> {
            this.openModalAction(areaDrawing.getText());
        });
        JButton perimeterDrawing = new JButton("Show perimeter");
        perimeterDrawing.addActionListener(e -> {
            this.openModalAction(areaDrawing.getText());
        });
        ba.setPreferredSize(new Dimension(800, 20));
        ba.addActionListener(new Switcher(cardB));

        String[] transformations = {"", "Rotation", "Axial Symmetry", "Central Symmetry", "Homothetie", "Translation"};
        JComboBox jComboBox = new JComboBox(transformations);
        jComboBox.setMaximumSize(new Dimension(200, 50));
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doTransformation(transformations[jComboBox.getSelectedIndex()]);
                jComboBox.setSelectedIndex(0);
            }
        });

        jComboBox.setSelectedIndex(0);
        jComboBox.setLightWeightPopupEnabled(false);


        newToolbar.add(ba);
        newToolbar.addSeparator();
        newToolbar.addSeparator();
        newToolbar.add(areaDrawing);
        newToolbar.add(perimeterDrawing);
        newToolbar.addSeparator();
        newToolbar.addSeparator();
        newToolbar.add(jComboBox);
        drawingPanel.add(newToolbar, BorderLayout.NORTH);

        ImagePanel imagePanel = new ImagePanel(drawingPanel);
        JButton bb = new JButton("<< Back to drawing panel");
        bb.addActionListener(new Switcher(cardA));
        imagePanel.getToolbar().add(bb);

        cards = new CardLayout();
        setLayout(cards);
        add(drawingPanel, cardA);
        add(imagePanel, cardB);
    }

    public static Fresco getFresco() {
        return fresco;
    }

    public void openModalAction(String action) {
        switch (action) {
            case "Show area":
                int totalArea = 0;
                for (Drawing d : fresco.getDrawings()) {
                    totalArea += d.calculateArea();
                }
                JOptionPane.showMessageDialog(null, "The total area of this drawing is " + totalArea, "Total Area", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Show perimeter":
                int totalPerimeter = 0;
                for (Drawing d : fresco.getDrawings()) {
                    totalPerimeter += d.calculatePerimeter();
                }
                JOptionPane.showMessageDialog(null, "The total perimeter of this drawing is " + totalPerimeter, "Total Perimeter", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    public void doTransformation(String transformation) {
        int result;
        switch (transformation) {
            case "Rotation":
                JTextField xRotation = new JTextField(5);
                JTextField yRotation = new JTextField(5);
                JTextField angleRotation = new JTextField(5);


                JPanel myPanelRotation = new JPanel();
                myPanelRotation.add(new JLabel("x:"));
                myPanelRotation.add(xRotation);
                myPanelRotation.add(Box.createHorizontalStrut(10)); // a spacer
                myPanelRotation.add(new JLabel("y:"));
                myPanelRotation.add(yRotation);

                myPanelRotation.add(Box.createHorizontalStrut(20)); // a spacer

                myPanelRotation.add(new JLabel("Angle:"));
                myPanelRotation.add(angleRotation);


                result = JOptionPane.showConfirmDialog(null, myPanelRotation,
                        "Rotation", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    for (Drawing d : fresco.getDrawings()) {
                        d.rotation(Integer.parseInt(angleRotation.getText()));
                    }
                }
                repaint();
                break;
            case "Axial Symmetry":
                JRadioButton rBtn1 = new JRadioButton("Horizontal");
                JRadioButton rBtn2 = new JRadioButton("Vertical");
                rBtn1.setBounds(40, 60, 200, 50);
                rBtn2.setBounds(40, 100, 200, 50);
                ButtonGroup bg = new ButtonGroup();
                bg.add(rBtn1);
                bg.add(rBtn2);
                rBtn1.setSelected(true);
                JPanel myPanelAxialSymmetry = new JPanel();
                myPanelAxialSymmetry.add(rBtn1);
                myPanelAxialSymmetry.add(rBtn2);


                result = JOptionPane.showConfirmDialog(null, myPanelAxialSymmetry,
                        "Axial Symmetry", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    String symmetrie = "horizontal";
                    if (rBtn1.isSelected())
                        symmetrie = "horizontal";
                    if (rBtn2.isSelected())
                        symmetrie = "vertical";

                    for (Drawing d : fresco.getDrawings()) {
                        d.axialSymmetry(
                                getWidth(),
                                getHeight(),
                                symmetrie
                        );
                    }
                }
                repaint();
                break;
            case "Central Symmetry":
                JTextField xCentralSymetrie = new JTextField(5);
                JTextField yCentralSymetrie = new JTextField(5);


                JPanel myPanelCentralSymetrie = new JPanel();
                myPanelCentralSymetrie.add(new JLabel("x:"));
                myPanelCentralSymetrie.add(xCentralSymetrie);
                myPanelCentralSymetrie.add(Box.createHorizontalStrut(10)); // a spacer
                myPanelCentralSymetrie.add(new JLabel("y:"));
                myPanelCentralSymetrie.add(yCentralSymetrie);

                result = JOptionPane.showConfirmDialog(null, myPanelCentralSymetrie,
                        "Central Symmetry", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    for (Drawing d : fresco.getDrawings()) {
                        d.centralSymmetry(new Point(Integer.parseInt(xCentralSymetrie.getText()), Integer.parseInt(yCentralSymetrie.getText())));
                    }
                }
                repaint();
                break;
            case "Homothetie":
                JTextField xHomothetie = new JTextField(5);
                JTextField yHomothetie = new JTextField(5);
                JTextField ratioHomothetie = new JTextField(5);


                JPanel myHomothetie = new JPanel();
                myHomothetie.add(new JLabel("x:"));
                myHomothetie.add(xHomothetie);
                myHomothetie.add(Box.createHorizontalStrut(10)); // a spacer
                myHomothetie.add(new JLabel("y:"));
                myHomothetie.add(yHomothetie);
                myHomothetie.add(Box.createHorizontalStrut(20)); // a spacer
                myHomothetie.add(new JLabel("ratio:"));
                myHomothetie.add(ratioHomothetie);
                result = JOptionPane.showConfirmDialog(null, myHomothetie,
                        "Homothetie", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    for (Drawing d : fresco.getDrawings()) {
                        d.homothetie(new Point(Integer.parseInt(xHomothetie.getText()), Integer.parseInt(yHomothetie.getText())), Integer.parseInt(ratioHomothetie.getText()));
                    }
                }
                repaint();
                break;
            case "Translation":
                JTextField xTranslation = new JTextField(5);
                JTextField yTranslation = new JTextField(5);


                JPanel myPanelTranslation = new JPanel();
                myPanelTranslation.add(new JLabel("x:"));
                myPanelTranslation.add(xTranslation);
                myPanelTranslation.add(Box.createHorizontalStrut(10)); // a spacer
                myPanelTranslation.add(new JLabel("y:"));
                myPanelTranslation.add(yTranslation);

                result = JOptionPane.showConfirmDialog(null, myPanelTranslation,
                        "Translation", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    for (Drawing d : fresco.getDrawings()) {
                        d.translation(Integer.parseInt(xTranslation.getText()), Integer.parseInt(yTranslation.getText()));
                    }
                }
                repaint();
                break;
        }

    }

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


}