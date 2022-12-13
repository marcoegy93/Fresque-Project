package fresco.containers.geometricShapes;

import fresco.containers.geometricShapes.utils.Point;

import java.awt.*;

import static java.lang.Math.sqrt;

/**
 * Class that represents an Ellipse
 */
public class Ellipse extends GeometricShapeAbs {
    /**
     * Integers representing height and width
     */
    private int height, width;

    /**
     * Constructor of an Ellipse
     * @param center the center of the Ellipse
     * @param height the height of the Ellipse
     * @param width the width of the Ellipse
     */
    public Ellipse(Point center, int height, int width) {
        super(center);
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * (3 * (height + width) - sqrt((3 * height + width) * (height + 3 * width)));
    }

    @Override
    public double calculateArea() {
        return height * width * Math.PI;
    }

    @Override
    public void translation(int x, int y) {
        this.center.translate(x, y);
    }

    @Override
    public void homothetie(Point p, int ratio) {
        this.center.homothetie(p, ratio);
        this.height *= ratio;
        this.width *= ratio;
    }

    @Override
    public void rotation(int angle) {
        //à refaire
        Point pHeight = new Point(this.center.getX() + height, this.center.getY() + height );
        Point pWidth = new Point(this.center.getX() + width, this.center.getY() + width );
        pHeight.rotation(this.center,angle);
        pWidth.rotation(this.center,angle);

    }

    @Override
    public void centralSymmetry(Point p) {
        center.centralSymmetry(p);
    }

    @Override
    public void axialSymmetry(int width, int height,String s) {

        center.axialSymmetry(width, height, s);
        if(s == "vertical"){
            this.center.setX(this.center.getX() - this.width);
        }else{
            this.center.setY(this.center.getY() - this.height);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Ellipse e = (Ellipse) o;
        return e.height == height && e.width == width && e.center.equals(this.center);
    }

    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        g.drawOval(center.getX(), center.getY(), width, height);
    }

}
