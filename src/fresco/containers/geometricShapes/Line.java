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
        return pointA.calculateDistance(this.pointB);
    }

    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public void translation(int x, int y) {
        pointA.translate(x, y);
        pointB.translate(x, y);
    }

    @Override
    public void homothetie(Point p, int ratio) {
        this.pointA.homothetie(p, ratio);
        this.pointB.homothetie(p, ratio);
    }

    @Override
    public void rotation(int angle) {
        this.pointA.rotation(this.center, angle);
        this.pointB.rotation(this.center, angle);
    }

    @Override
    public void centralSymmetry(Point p) {
        this.pointA.centralSymmetry(p);
        this.pointB.centralSymmetry(p);
    }

    @Override
    public void axialSymmetry(int width, int height, String s) {
        this.pointB.axialSymmetry(width, height, s);
        this.pointA.axialSymmetry(width, height, s);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Line l = (Line) o;
        return l.pointA.equals(this.pointA) && l.pointB.equals(this.pointB);
    }


    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        g.drawLine(this.pointA.getX(), this.pointA.getY(), this.pointB.getX(), this.pointB.getY());

    }
}
