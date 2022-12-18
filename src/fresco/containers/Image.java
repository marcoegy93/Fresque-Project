package fresco.containers;

import fresco.containers.calculatePerimeterAndArea.ICalculatePerimeterAndArea;
import fresco.containers.geometricShapes.GeometricShapeAbs;
import fresco.containers.geometricShapes.utils.Point;
import fresco.containers.transformations.ITransformation;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Class that represents an Image, a composition of GeometricShapes (@see fresco.containers.geometricShapes)
 */
public class Image implements ICalculatePerimeterAndArea, ITransformation {

    /**
     * The set (Collection) that represents a group of unique GeometricShapes
     * The Collection cannot contain the same GeometricShape twice
     */
    private Set<GeometricShapeAbs> shapes;

    /**
     * The name of the Image, that allows the user to recognize it
     */
    private String name;

    /**
     * The color the GeometricShapes of the Image will be drawn with
     */
    private Color c;

    /**
     * The constructor of an Image
     *
     * @param name the name of the Image
     * @param c    the color of the Image
     */
    public Image(String name, Color c) {
        this.shapes = new LinkedHashSet<GeometricShapeAbs>();
        this.name = name;
        this.c = c;
    }

    /**
     * Getter that gets the name
     *
     * @return the name of the Image
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter that gets the color
     *
     * @return the color of the Image
     */
    public Color getColor() {
        return this.c;
    }

    /**
     * Getter that gets the GeometricShapes contained in the Image
     *
     * @return the Set of GeometricShapes
     */
    public Set<GeometricShapeAbs> getShapes() {
        return shapes;
    }

    /**
     * Setter that sets the Set of GeometricShape with a given Set
     *
     * @param shapes the Set of GeometricShape
     */
    public void setShapes(Set<GeometricShapeAbs> shapes) {
        this.shapes = shapes;
    }

    /**
     * Method that adds a given GeometricShape to the Set of GeometricShape
     *
     * @param gs The GeometricShape to add to the Set
     */
    public void addShape(GeometricShapeAbs gs) {
        this.shapes.add(gs);
        System.out.println("\tUne forme de type " + gs.getClass().getSimpleName() + " a été ajoutée à l'image");
    }

    /**
     * Method that sorts the GeometricShapes contained in the Set based on their perimeter
     */
    public void shapesSort() {
        List<GeometricShapeAbs> list = new ArrayList<GeometricShapeAbs>(shapes);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).calculatePerimeter() < list.get(j).calculatePerimeter()) {
                    GeometricShapeAbs tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
        Set<GeometricShapeAbs> shapes = new LinkedHashSet<>(list);
        this.setShapes(shapes);
    }

    @Override
    public double calculatePerimeter() {
        System.out.println("\tVoici l'ensemble des périmètres des formes contenues dans l'image : ");
        double perimeter = 0;
        for (GeometricShapeAbs gs : shapes) {
            System.out.println("\t\t" + gs.getClass().getSimpleName() + " : ");
            perimeter += gs.calculatePerimeter();
        }
        System.out.println("\tLe périmètre de l'image vaut au total : " + perimeter);
        return perimeter;
    }

    @Override
    public double calculateArea() {
        System.out.println("\tVoici l'ensemble des aires des formes contenues dans l'image : ");
        double area = 0;
        for (GeometricShapeAbs gs : shapes) {
            System.out.println("\t\t" + gs.getClass().getSimpleName() + " : ");
            area += gs.calculateArea();
        }
        System.out.println("\tL'aire de l'image vaut au total : " + area);
        return area;
    }

    @Override
    public void translation(int x, int y) {
        System.out.println("\tL'ensemble des formes contenues dans l'image vont être translatées de " +
                x + " en x et de " + y + " en y : ");
        for (GeometricShapeAbs gs : shapes) {
            System.out.println("\t\t" + gs.getClass().getSimpleName() + " : ");
            gs.translation(x, y);
        }
        System.out.println("\tL'ensemble des formes contenues dans l'image ont été translatées de " +
                x + " en x et de " + y + " en y : ");
    }

    @Override
    public void homothetie(Point p, int ratio) {
        System.out.println("\tL'ensemble des formes contenues dans l'image vont subir une homothétie de centre O(" +
                p.getX() + "," + p.getY() + ") et de rapport " + ratio + " : ");
        for (GeometricShapeAbs gs : shapes) {
            System.out.println("\t\t" + gs.getClass().getSimpleName() + " : ");
            gs.homothetie(p, ratio);
        }
        System.out.println("\tL'ensemble des formes contenues dans l'image ont subies une homothétie de centre O(" +
                p.getX() + "," + p.getY() + ") et de rapport " + ratio);
    }

    @Override
    public void rotation(int angle) {
        System.out.println("\tL'ensemble des formes contenues dans l'image vont subir une rotation à " +
                angle + " degrés : ");
        for (GeometricShapeAbs gs : shapes) {
            System.out.println("\t\t" + gs.getClass().getSimpleName() + " : ");
            gs.rotation(angle);
        }
        System.out.println("\tL'ensemble des formes contenues dans l'image ont subies une rotation à " +
                angle + " degrés");
    }

    @Override
    public void centralSymmetry(Point p) {
        System.out.println("\tL'ensemble des formes contenues dans l'image vont subir une symetrie centrale par rapport " +
                "au point O(" + p.getX() + "," + p.getY() + ") : ");
        for (GeometricShapeAbs gs : shapes) {
            System.out.println("\t\t" + gs.getClass().getSimpleName() + " : ");
            gs.centralSymmetry(p);
        }
        System.out.println("\tL'ensemble des formes contenues dans l'image ont subies une symetrie centrale par rapport " +
                "au point O(" + p.getX() + "," + p.getY() + ")");
    }

    @Override
    public void axialSymmetry(int width, int height, String s) {
        System.out.println("\tL'ensemble des formes contenues dans l'image vont subir une symetrie axiale par rapport " +
                "à l'axe " + s + " : ");
        for (GeometricShapeAbs gs : shapes) {
            System.out.println("\t\t" + gs.getClass().getSimpleName() + " : ");
            gs.axialSymmetry(width, height, s);
        }
        System.out.println("\tL'ensemble des formes contenues dans l'image ont subies une symetrie axiale par rapport " +
                "à l'axe " + s);
    }
}
