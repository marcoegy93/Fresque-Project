package fresco.containers.geometricShapes;

import fresco.containers.geometricShapes.utils.Point;

import java.awt.*;

/**
 * Class that represents a Line
 */
public class Line extends GeometricShapeAbs {

    /**
     * Point representing the 2 edges of the line
     */
    private Point pointA, pointB;

    /**
     * The constructor of a Line
     *
     * @param pointA the edge Point of the Line
     * @param pointB the other edge Point of the Line
     */
    public Line(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.center = getCenter();
    }

    @Override
    public Point getCenter() {
        return new Point((pointA.getX() + pointB.getX()) / 2,
                (pointA.getY() + pointB.getY()) / 2);
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = pointA.calculateDistance(this.pointB);
        System.out.println("\t\tLe périmètre de la ligne vaut : : " + perimeter);
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double area = 0;
        System.out.println("\t\tL'aire de la ligne vaut : " + area);
        return area;
    }

    @Override
    public void translation(int x, int y) {
        pointA.translate(x, y);
        pointB.translate(x, y);
        this.center = getCenter();
        System.out.println("\t\tLa ligne a été translatée de " + x + " en x et de " + y + " en y. " +
                ". Nouvelles coordonnées du centre de la ligne: " + center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void homothetie(Point p, int ratio) {
        this.pointA.homothetie(p, ratio);
        this.pointB.homothetie(p, ratio);
        this.center = getCenter();
        System.out.println("\t\tLa ligne a subi une homothétie de centre O(" +
                p.getX() + "," + p.getY() + ") et de rapport " + ratio + ". " +
                ". Nouvelles coordonnées du centre de la ligne : " + center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void rotation(int angle) {
        this.pointA.rotation(this.center, angle);
        this.pointB.rotation(this.center, angle);
        this.center = getCenter();
        System.out.println("\t\tLa ligne a subi une rotation à " + angle + " degrés" +
                ". Nouvelles coordonnées du point A de la ligne : " + pointA.getX() + " en x et " + pointA.getY() + " en y.");
    }

    @Override
    public void centralSymmetry(Point p) {
        this.pointA.centralSymmetry(p);
        this.pointB.centralSymmetry(p);
        this.center = getCenter();
        System.out.println("\t\tLa ligne a subi une symetrie centrale par rapport " +
                "au point O(" + p.getX() + "," + p.getY() + "). Nouvelles coordonnées du centre de la ligne : " +
                center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void axialSymmetry(int width, int height, String s) {
        this.pointB.axialSymmetry(width, height, s);
        this.pointA.axialSymmetry(width, height, s);
        this.center = getCenter();
        System.out.println("\t\tLa ligne a subi une symetrie axiale par rapport à l'axe " + s +
                ". Nouvelles coordonnées du centre : " + center.getX() + " en x et " + center.getY() + " en y.");
    }


    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        g.drawLine(this.pointA.getX(), this.pointA.getY(), this.pointB.getX(), this.pointB.getY());

    }
}
