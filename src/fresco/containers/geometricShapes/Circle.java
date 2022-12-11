package fresco.containers.geometricShapes;

import fresco.containers.geometricShapes.utils.Point;

import java.awt.*;

public class Circle extends GeometricShapeAbs {

    private int radius;

    public Circle(Point center, int radius) {
        super(center);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public double calculateArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public void translation(int x, int y) {
        center.translate(x, y);
    }

    @Override
    public void homothetie(Point p, int ratio) {
        this.center.homothetie(p, ratio);
        this.radius *= ratio;
    }

    @Override
    public void rotation(Point p, int angle) {
        return;
    }

    @Override
    public void centralSymmetry(Point p) {
        center.centralSymmetry(p);
    }

    @Override
    public void axialSymmetry(Line l) {
        center.axialSymmetry(l);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Circle c = (Circle) o;
        return c.center.equals(this.center) && c.getRadius() == this.getRadius();
    }

    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        g.drawOval(center.getX(), center.getY(), radius, radius);
    }

}
