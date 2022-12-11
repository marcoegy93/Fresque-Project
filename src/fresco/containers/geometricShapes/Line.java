package fresco.containers.geometricShapes;

import fresco.containers.geometricShapes.utils.Point;

import java.awt.*;

public class Line extends GeometricShapeAbs {

    private Point pointA;
    private Point pointB;

    public Line(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.center = getCenter();
    }


    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    @Override
    public Point getCenter() {
        return new Point((this.getPointA().getX() + this.getPointB().getX()) / 2,
                (this.getPointA().getY() + this.getPointB().getY()) / 2);
    }

    @Override
    public double calculatePerimeter() {
        return Point.calculateDistance(this.pointA, this.pointB);
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
    public void rotation(Point p, int angle) {

    }

    @Override
    public void centralSymmetry(Point p) {
        this.pointA.centralSymmetry(p);
        this.pointB.centralSymmetry(p);
    }

    @Override
    public void axialSymmetry(Line l) {
        this.pointB.axialSymmetry(l);
        this.pointA.axialSymmetry(l);
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
