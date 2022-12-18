package fresco.containers.geometricShapes;

import fresco.containers.geometricShapes.utils.Point;

import java.awt.*;

/**
 * Class that represents a Circle
 */
public class Circle extends GeometricShapeAbs {

    /**
     * The radius of the Circle
     */
    private int radius;

    /**
     * A point on the Circle
     */
    private Point pointOfCircle;

    /**
     * The constructor of a Circle
     *
     * @param center the center Point of the circle
     * @param radius the radius of the circle
     */
    public Circle(Point center, int radius) {
        super(center);
        this.radius = radius;
        this.pointOfCircle = new Point(this.center.getX() + radius, this.center.getY());
    }

    /**
     * Getter that gets the radius of the circle
     *
     * @return the radius of the circle
     */
    public int getRadius() {
        return radius;
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = Math.PI * 2 * radius;
        System.out.println("\t\tLe périmètre du cercle vaut : : " + perimeter);
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double area = Math.pow(radius, 2) * Math.PI;
        System.out.println("\t\tL'aire du cercle vaut : " + area);
        return area;
    }

    @Override
    public void translation(int x, int y) {
        center.translate(x, y);
        pointOfCircle.translate(x, y);
        System.out.println("\t\tLe cercle a été translaté de " + x + " en x et de " + y + " en y. " +
                ". Nouvelles coordonnées du centre : " + center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void homothetie(Point p, int ratio) {
        this.center.homothetie(p, ratio);
        this.pointOfCircle.homothetie(p, ratio);
        this.radius *= ratio;
        System.out.println("\t\tLe cercle a subi une homothétie de centre O(" +
                p.getX() + "," + p.getY() + ") et de rapport " + ratio + ". " +
                ". Nouvelles coordonnées du centre : " + center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void rotation(int angle) {
        this.pointOfCircle.rotation(center, angle);
        System.out.println("\t\tLe cercle a subi une rotation à " + angle + " degrés" +
                ". Nouvelles coordonnées du point sur le cercle : " + pointOfCircle.getX() + " en x et " + pointOfCircle.getY() + " en y.");
    }

    @Override
    public void centralSymmetry(Point p) {
        center.centralSymmetry(p);
        pointOfCircle.centralSymmetry(p);
        System.out.println("\t\tLe cercle a subi une symetrie centrale par rapport " +
                "au point O(" + p.getX() + "," + p.getY() + "). Nouvelles coordonnées du centre : " +
                center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void axialSymmetry(int width, int height, String s) {
        center.axialSymmetry(width, height, s);
        pointOfCircle.axialSymmetry(width, height, s);
        System.out.println("\t\tLe cercle a subi une symetrie axiale par rapport à l'axe " + s +
                ". Nouvelles coordonnées du centre : " + center.getX() + " en x et " + center.getY() + " en y.");
    }


    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        int centerX = this.center.getX() - radius;
        int centerY = this.center.getY() - radius;
        g.drawOval(centerX, centerY, radius * 2, radius * 2);
    }

}
