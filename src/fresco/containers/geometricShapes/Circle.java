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
     * The constructor of a Circle
     *
     * @param center the center Point of the circle
     * @param radius the radius of the circle
     */
    public Circle(Point center, int radius) {
        super(center);
        this.radius = radius;
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
    public void rotation(int angle) {
        return;
    }

    @Override
    public void centralSymmetry(Point p) {
        center.centralSymmetry(p);
    }

    @Override
    public void axialSymmetry(int width, int height, String s) {
        center.axialSymmetry(width, height, s);
        if (s == "vertical") {
            this.center.setX(this.center.getX() - radius * 2);
        } else {
            this.center.setY(this.center.getY() - radius * 2);
        }
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
        g.drawOval(center.getX(), center.getY(), radius * 2, radius * 2);
    }

}
