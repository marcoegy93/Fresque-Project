package fresco.containers.geometricShapes;

import fresco.containers.geometricShapes.utils.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a Polygon
 */
public class Polygon extends GeometricShapeAbs {

    /**
     * An ArrayList of Point that represents the polygon (the last element is linked to the first)
     */
    private ArrayList<Point> points;

    /**
     * The default constructor of a Polygon
     * Initialize the ArrayList of Point
     */
    public Polygon() {
        super();
        this.points = new ArrayList<>();
    }

    /**
     * Method that adds a new point to the ArrayList
     * @param point the Point to add
     */
    public void addPoint(final Point point) {
        this.points.add(point);
        this.center = getCenter();
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 0;
        int i;
        for (i = 1; i < points.size(); i++) {
            perimeter += new Line(new Point(points.get(i - 1).getX(), points.get(i - 1).getY()), new Point(points.get(i).getX(), points.get(i).getY())).calculatePerimeter();
        }
        perimeter += new Line(new Point(points.get(i - 1).getX(), points.get(i - 1).getY()), new Point(points.get(0).getX(), points.get(0).getY())).calculatePerimeter();
        System.out.println("\t\tLe périmètre du polygone vaut : " + perimeter);
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double somme = 0;
        for (int j = 0; j < points.size(); j++) {
            if (j == 0) {
                somme += points.get(j).getX() * (points.get(j + 1).getY() - points.get(points.size() - 1).getY());
            } else if (j == points.size() - 1) {
                somme += points.get(j).getX() * (points.get(0).getY() - points.get(j - 1).getY());
            } else {
                somme += points.get(j).getX() * (points.get(j + 1).getY() - points.get(j - 1).getY());
            }
        }

        double area = 0.5 * Math.abs(somme);
        System.out.println("\t\tL'aire du polygone vaut : " + area);
        return area;
    }

    @Override
    public void translation(int x, int y) {

        for (Point point : points) point.translate(x, y);
        this.center = getCenter();
        System.out.println("\t\tLe polygone a été translaté de " + x + " en x et de " + y + " en y. " +
                "Nouvelles coordonnées du centre : " + center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void homothetie(Point p, int ratio) {
        for (Point point : points) {
            point.homothetie(p, ratio);
        }
        this.center = getCenter();
        System.out.println("\t\tLe polygone a subi une homothétie de centre O(" +
                p.getX() + ","+ p.getY() + ") et de rapport " + ratio + ". " +
                "Nouvelles coordonnées du centre : " + center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void rotation(int angle) {
        for (Point point : points) {
            point.rotation(this.center, angle);
        }
        this.center = getCenter();
        System.out.println("\t\tLe polygone a subi une rotation à " + angle + " degrés" +
                ". Nouvelles coordonnées d'une des points du polygone : " + points.get(0).getX() + " en x et " + points.get(0).getY() + " en y.");
    }

    @Override
    public void centralSymmetry(Point p) {

        for (Point point : points) point.centralSymmetry(p);
        this.center = getCenter();
        System.out.println("\t\tLe polygone a subi une symetrie centrale par rapport " +
                "au point O(" + p.getX() + "," + p.getY() + "). Nouvelles coordonnées du centre : " +
                center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void axialSymmetry(int width, int height, String s) {
        for (Point point : points) point.axialSymmetry(width, height, s);
        this.center = getCenter();
        System.out.println("\t\tLe polygone a subi une symetrie axiale par rapport à l'axe " + s +
                ". Nouvelles coordonnées du centre : " + center.getX() + " en x et " + center.getY() + " en y.");
    }

    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        int[] points_x = new int[points.size()];
        int[] points_y = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            points_x[i] = points.get(i).getX();
            points_y[i] = points.get(i).getY();
        }
        g.drawPolygon(points_x, points_y, points.size());
    }

    @Override
    public Point getCenter() {
        int SommeDesX = 0;
        int SommeDesY = 0;
        for (int i = 0; i < points.size(); i++) {
            SommeDesX += points.get(i).getX();
            SommeDesY += points.get(i).getY();
        }
        return new Point(SommeDesX / points.size(), SommeDesY / points.size());
    }
}
