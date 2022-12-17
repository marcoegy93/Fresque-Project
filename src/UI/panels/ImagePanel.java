package UI.panels;

import UI.components.Toolbar;
import appli.ImagePanelDrawUtil;
import fresco.containers.Image;
import fresco.containers.geometricShapes.Polygon;
import fresco.containers.geometricShapes.*;
import fresco.containers.geometricShapes.utils.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * UI Class that shows a specific Image on a JPanel,
 * which is a composition of GeometricShapes (@see Image)
 */
public class ImagePanel extends JPanel {
    /**
     * The Image currently shown on the ImagePanel
     */
    private Image currentImage;

    /**
     * The parent Drawing in which the currentImage is contained in
     */
    private DrawingPanel linkedDrawing;

    /**
     * The toolbar of the ImagePanel (@see Toolbar)
     */
    private Toolbar toolbar;

    /**
     * Button that allows the creation of new images
     */
    private JButton createNewImage;

    /**
     * Boolean that will tell if ImagePanel is in editing mode (changes the interface behaviour)
     */
    private boolean editMode = false;

    /**
     * TextFields to add on user demand while creating a Polygon
     */
    private ArrayList<JTextField> xFieldPolygonList = new ArrayList<JTextField>(), yFieldPolygonList = new ArrayList<JTextField>();

    /**
     * Constructor of an ImagePanel used only to display an Image. (editMode = false)
     * The constructor will only draw the GeometricShapes contained in the Image, without the Toolbar or any buttons
     *
     * @param image the Image to display
     */
    public ImagePanel(Image image) {
        setBackground(Color.white);
        this.setPreferredSize(new Dimension(1280, 720));
        this.currentImage = image;
    }

    /**
     * Constructor of an ImagePanel used to create and edit an Image. (editMode = true)
     * The constructor will draw the GeometricShapes if there is any, as well as drawing the Toolbar
     *
     * @param drawingPanel
     */
    public ImagePanel(DrawingPanel drawingPanel) {
        setBackground(Color.white);
        linkedDrawing = drawingPanel;
        toolbar = new Toolbar();
        ImagePanelDrawUtil imagePanelDrawUtil = new ImagePanelDrawUtil(this);
        editMode = true;
        createNewImage = new JButton("+ New image");
        createNewImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewImage();
            }
        });
        add(createNewImage, BorderLayout.CENTER);
    }

    /**
     * Setter that sets the currentImage to a given Image
     *
     * @param currentImage the Image to set currentImage
     */
    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    /**
     * Getter that gets the Drawing in which the currentImage is contained in
     *
     * @return the parent Drawing
     */
    public DrawingPanel getLinkedDrawing() {
        return linkedDrawing;
    }

    /**
     * Getter that gets the Toolbar used by the ImagePanel
     *
     * @return the toolbar
     */
    public Toolbar getToolbar() {
        return toolbar;
    }

    /**
     * Method that allows the creation of a new Image.
     * It opens a Dialog to let the user choose its name and its color.
     * Then, it repaints the whole ImagePanel empty in editing mode (editMode = true)
     */
    public void createNewImage() {
        if (linkedDrawing.getDrawing().getImages().size() == 9) {
            String message = "You reached the maximum amount of images in a drawing\n";
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JPanel addNewImage = new JPanel();

            addNewImage.add(new JLabel("Image Name:"));
            JTextField imageName = new JTextField(50);
            addNewImage.add(imageName);

            addNewImage.add(Box.createHorizontalStrut(10)); // a spacer
            JColorChooser colorChooser = new JColorChooser();
            addNewImage.add(colorChooser);
            int result = JOptionPane.showConfirmDialog(null, addNewImage,
                    "Create Image", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                Color c = colorChooser.getColor();
                String name = imageName.getText().isEmpty() ? "Image " + (linkedDrawing.getDrawing().getImages().size() + 1) : imageName.getText();
                currentImage = new Image(name, c);
                linkedDrawing.getDrawing().addImage(currentImage);
            }

            removeAll();
            toolbar.addSeparator();
            toolbar.add(createNewImage);
            add(toolbar);
            revalidate();
            repaint();
        }
    }

    /**
     * Method that paints the component whenever it needs to be (on initialization, on update)
     * If editMode is true, it will paint a toolbar and draw the axis (horizontal and vertical)
     * If editMode is false, it will scale down the Image to fit in the grid of a DrawingPanel
     * It then paints all the GeometricShapes of the Image, if there is any
     *
     * @param g the Graphics that allows the painting of the JPanel
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (editMode) {

            add(toolbar);
            toolbar.enableButtons();
            disableDrawingButtons();

            g2.setColor(Color.lightGray);
            g2.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
            g2.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
        }
        if (!editMode) g2.scale(0.33, 0.33);
        if (currentImage != null) {
            for (GeometricShapeAbs shape : currentImage.getShapes()) {
                shape.draw(g2, currentImage.getColor());
            }
        }

    }

    /**
     * Method that adds a new GeometricShape to the Image
     * It removes all entities on the ImagePanel, then trigger a repaint to update the ImagePanel
     *
     * @param shape
     */
    public void addShape(GeometricShapeAbs shape) {
        revalidate();
        repaint();
        removeAll();
        currentImage.addShape(shape);
        revalidate();
        repaint();
    }

    /**
     * Method that disables the drawingButtons for which the shape has already been drawn for the currentImage
     */
    public void disableDrawingButtons() {
        if (currentImage != null) {
            for (GeometricShapeAbs shape : currentImage.getShapes()) {
                toolbar.disableButton(shape.getClass().getSimpleName());
            }
        }
    }

    /**
     * Method that opens a Modal when the user wants to draw a new GeometricShape.
     * It opens a different Modal for each shape, depending on its parameter needs
     *
     * @param shape the Shape that the user wants to draw
     */
    public void openModalShape(String shape) {
        int result;
        switch (shape) {
            case "Line":
                JTextField x1FieldLine = new JTextField(5);
                JTextField y1FieldLine = new JTextField(5);

                JTextField x2FieldLine = new JTextField(5);
                JTextField y2FieldLine = new JTextField(5);

                JPanel myPanelLine = new JPanel();
                myPanelLine.add(new JLabel("x1:"));
                myPanelLine.add(x1FieldLine);
                myPanelLine.add(Box.createHorizontalStrut(10)); // a spacer
                myPanelLine.add(new JLabel("y1:"));
                myPanelLine.add(y1FieldLine);

                myPanelLine.add(Box.createHorizontalStrut(20)); // a spacer

                myPanelLine.add(new JLabel("x2:"));
                myPanelLine.add(x2FieldLine);
                myPanelLine.add(Box.createHorizontalStrut(10)); // a spacer
                myPanelLine.add(new JLabel("y2:"));
                myPanelLine.add(y2FieldLine);

                result = JOptionPane.showConfirmDialog(null, myPanelLine,
                        "Adding Line", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    addShape(
                            new Line(
                                    new Point(Integer.parseInt(x1FieldLine.getText()), Integer.parseInt(y1FieldLine.getText())),
                                    new Point(Integer.parseInt(x2FieldLine.getText()), Integer.parseInt(y2FieldLine.getText()))
                            )
                    );

                }
                break;
            case "Circle":
                JTextField xFieldCircle = new JTextField(5);
                JTextField yFieldCircle = new JTextField(5);
                JTextField rayFieldCircle = new JTextField(5);


                JPanel myPanelCircle = new JPanel();
                myPanelCircle.add(new JLabel("x:"));
                myPanelCircle.add(xFieldCircle);
                myPanelCircle.add(Box.createHorizontalStrut(10)); // a spacer
                myPanelCircle.add(new JLabel("y:"));
                myPanelCircle.add(yFieldCircle);

                myPanelCircle.add(Box.createHorizontalStrut(20)); // a spacer

                myPanelCircle.add(new JLabel("Ray:"));
                myPanelCircle.add(rayFieldCircle);


                result = JOptionPane.showConfirmDialog(null, myPanelCircle,
                        "Adding  Circle", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    addShape(new Circle(new Point(
                            Integer.parseInt(xFieldCircle.getText()),
                            Integer.parseInt(yFieldCircle.getText())),
                            Integer.parseInt(rayFieldCircle.getText())
                    ));
                }
                break;
            case "Ellipse":
                JTextField xFieldEllipse = new JTextField(5);
                JTextField yFieldEllipse = new JTextField(5);
                JTextField widthEllipse = new JTextField(5);
                JTextField heightEllipse = new JTextField(5);


                JPanel myPanelEllipse = new JPanel();
                myPanelEllipse.add(Box.createHorizontalStrut(10)); // a spacer
                myPanelEllipse.add(new JLabel("x:"));
                myPanelEllipse.add(xFieldEllipse);
                myPanelEllipse.add(new JLabel("y:"));
                myPanelEllipse.add(yFieldEllipse);

                myPanelEllipse.add(Box.createHorizontalStrut(20)); // a spacer

                myPanelEllipse.add(new JLabel("width:"));
                myPanelEllipse.add(widthEllipse);
                myPanelEllipse.add(new JLabel("height:"));
                myPanelEllipse.add(heightEllipse);


                result = JOptionPane.showConfirmDialog(null, myPanelEllipse,
                        "Adding  Ellipse", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    try{
                        addShape(new Ellipse(new Point(
                                Integer.parseInt(xFieldEllipse.getText()),
                                Integer.parseInt(yFieldEllipse.getText())),
                                Integer.parseInt(heightEllipse.getText()),
                                Integer.parseInt(widthEllipse.getText())
                        ));
                    }catch(Exception e){
                        JPanel panelError = new JPanel();
                        panelError.add(Box.createHorizontalStrut(10)); // a spacer
                        panelError.add(new JLabel(e.getMessage()));
                        JOptionPane.showMessageDialog(null, panelError,
                                "ERROR Adding  Ellipse", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

            case "Polygon":

                xFieldPolygonList.add(new JTextField(5));
                yFieldPolygonList.add(new JTextField(5));

                JPanel myPanelPolygon = new JPanel();
                myPanelPolygon.setLayout(new BoxLayout(myPanelPolygon, BoxLayout.PAGE_AXIS));
                myPanelPolygon.setPreferredSize(new Dimension(400, 400));
                myPanelPolygon.add(new JLabel("x1:"));
                myPanelPolygon.add(xFieldPolygonList.get(0));
                myPanelPolygon.add(new JLabel("y1:"));
                myPanelPolygon.add(yFieldPolygonList.get(0));
                JButton addButton = new JButton("ADD");
                addButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myPanelPolygon.removeAll();

                        xFieldPolygonList.add(new JTextField(5));
                        yFieldPolygonList.add(new JTextField(5));

                        for (int i = 0; i < xFieldPolygonList.size(); i++) {

                            myPanelPolygon.add(new JLabel("x" + (i + 1) + ": "));
                            myPanelPolygon.add(xFieldPolygonList.get(i));
                            myPanelPolygon.add(new JLabel("y" + (i + 1) + ": "));
                            myPanelPolygon.add(yFieldPolygonList.get(i));
                        }
                        myPanelPolygon.add(addButton);
                        myPanelPolygon.repaint();
                        myPanelPolygon.revalidate();
                    }
                });
                myPanelPolygon.add(addButton);

                result = JOptionPane.showConfirmDialog(null, myPanelPolygon,
                        "Adding  Polygon", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    Polygon p = new Polygon();
                    for (int i = 0; i < xFieldPolygonList.size(); i++) {
                        p.addPoint(
                                new Point(
                                        Integer.parseInt(xFieldPolygonList.get(i).getText()),
                                        Integer.parseInt(yFieldPolygonList.get(i).getText())
                                )
                        );
                    }

                    addShape(p);
                    xFieldPolygonList = new ArrayList<JTextField>();
                    yFieldPolygonList = new ArrayList<JTextField>();
                } else {
                    xFieldPolygonList = new ArrayList<JTextField>();
                    yFieldPolygonList = new ArrayList<JTextField>();
                }
                break;

        }
    }


    /**
     * Method that opens a Modal to show the Image properties (area or perimeter)
     *
     * @param action the property to be shown in the Modal
     */
    public void openModalAction(String action) {
        switch (action) {
            case "Show area":
                JOptionPane.showMessageDialog(null,
                        "The total area of this image is " + this.currentImage.calculateArea(),
                        "Total Area", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Show perimeter":
                JOptionPane.showMessageDialog(null,
                        "The total perimeter of this image is " + this.currentImage.calculatePerimeter(),
                        "Total Perimeter", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    /**
     * Method that opens a Modal when the user wants to apply a Transformation on the shapes of the Image to get the
     * parameters it wants
     *
     * @param transformation the transformation to be done on the GeometricShapes
     */
    public void doTransformation(String transformation) {
        int result;
        switch (transformation) {
            case "Rotation":
                JTextField angleRotation = new JTextField(5);
                JPanel myPanelRotation = new JPanel();
                myPanelRotation.add(new JLabel("Angle:"));
                myPanelRotation.add(angleRotation);
                result = JOptionPane.showConfirmDialog(null, myPanelRotation,
                        "Rotation", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    currentImage.rotation(Integer.parseInt(angleRotation.getText()));
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
                    System.out.println(getWidth());
                    System.out.println(getHeight());

                    String symmetrie = "horizontal";
                    if (rBtn1.isSelected())
                        symmetrie = "horizontal";
                    if (rBtn2.isSelected())
                        symmetrie = "vertical";

                    currentImage.axialSymmetry(
                            getWidth(),
                            getHeight(),
                            symmetrie
                    );
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
                    currentImage.centralSymmetry(new Point(Integer.parseInt(xCentralSymetrie.getText()),
                            Integer.parseInt(yCentralSymetrie.getText())));

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
                    currentImage.homothetie(new Point(Integer.parseInt(xHomothetie.getText()),
                            Integer.parseInt(yHomothetie.getText())), Integer.parseInt(ratioHomothetie.getText()));
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
                    currentImage.translation(Integer.parseInt(xTranslation.getText()), Integer.parseInt(yTranslation.getText()));
                }
                repaint();
                break;
        }

    }


}
