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
     * Point at the extremities of height and width
     */
    private Point extremityHeight, extremityWidth;

    /**
     * Constructor of an Ellipse
     *
     * @param center the center of the Ellipse
     * @param height the height of the Ellipse
     * @param width  the width of the Ellipse
     */
    public Ellipse(Point center, int height, int width) throws Exception {
        super(center);
        if (height == width) {
            throw new Exception("La width et la height d'une Ellipse ne peuvent être égaux, sinon, c'est un cercle ! ");
        }
        this.height = height;
        this.width = width;
        this.extremityHeight = new Point(this.center.getX(), this.center.getY() + height);
        this.extremityWidth = new Point(this.center.getX() + width, this.center.getY());
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = Math.PI * (3 * (height + width) - sqrt((3 * height + width) * (height + 3 * width)));
        System.out.println("\t\tLe périmètre de l'ellipse vaut : : " + perimeter);
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double area = height * width * Math.PI;
        System.out.println("\t\tL'aire de l'ellipse vaut : " + area);
        return area;
    }

    @Override
    public void translation(int x, int y) {
        this.center.translate(x, y);
        this.extremityWidth.translate(x, y);
        this.extremityHeight.translate(x, y);
        System.out.println("\t\tL'ellipse a été translatée de " + x + " en x et de " + y + " en y. " +
                "Nouvelles coordonnées du centre : " + center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void homothetie(Point p, int ratio) {
        this.center.homothetie(p, ratio);
        this.extremityWidth.homothetie(p, ratio);
        this.extremityHeight.homothetie(p, ratio);
        this.height *= ratio;
        this.width *= ratio;
        System.out.println("\t\tL'ellipse a subi une homothétie de centre O(" +
                p.getX() + ","+ p.getY() + ") et de rapport " + ratio + ". " +
                "Nouvelles coordonnées du centre : " + center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void rotation(int angle) {
        this.extremityWidth.rotation(center, angle);
        this.extremityHeight.rotation(center, angle);
        System.out.println("\t\tL'ellipse a subi une rotation à " + angle + " degrés" +
                ". Nouvelles coordonnées du point à l'extrémité de la largeur : " + extremityWidth.getX() + " en x et " + extremityWidth.getY() + " en y. " +
                "Nouvelles coordonnées du point à l'extrémité de la hauteur : " + extremityHeight.getX() + " en x et " + extremityHeight.getY() + " en y.");
    }

    @Override
    public void centralSymmetry(Point p) {
        center.centralSymmetry(p);
        extremityHeight.centralSymmetry(p);
        extremityWidth.centralSymmetry(p);
        System.out.println("\t\tL'ellipse a subi une symetrie centrale par rapport " +
                "au point O(" + p.getX() + "," + p.getY() + "). Nouvelles coordonnées du centre : " +
                center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void axialSymmetry(int width, int height, String s) {

        center.axialSymmetry(width, height, s);
        extremityWidth.axialSymmetry(width, height, s);
        extremityHeight.axialSymmetry(width, height, s);
        System.out.println("\t\tL'ellipse a subi une symetrie axiale par rapport à l'axe " + s +
                ". Nouvelles coordonnées du centre : " + center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        int centerX = this.center.getX() - width;
        int centerY = this.center.getY() - height;
        g.drawOval(centerX, centerY, width * 2, height * 2);
    }

}
