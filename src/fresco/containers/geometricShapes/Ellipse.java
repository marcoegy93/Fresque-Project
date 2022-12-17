package fresco.containers.geometricShapes;

import fresco.containers.geometricShapes.utils.Point;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

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
     *
     * @param center the center of the Ellipse
     * @param height the height of the Ellipse
     * @param width  the width of the Ellipse
     */
    public Ellipse(Point center, int height, int width) throws Exception {
        super(center);
        if(height == width){
            throw new Exception("La width et la height d'une Ellipse ne peuvent être égaux, sinon, c'est un cercle ! ");
        }
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
    }

    @Override
    public void centralSymmetry(Point p) {
        center.centralSymmetry(p);
    }

    @Override
    public void axialSymmetry(int width, int height, String s) {
        center.axialSymmetry(width, height, s);
    }

    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        int centerX = this.center.getX() - width;
        int centerY = this.center.getY() - height;
        g.drawOval(centerX, centerY, width * 2, height * 2);
    }

}
