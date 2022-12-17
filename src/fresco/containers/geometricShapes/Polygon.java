package fresco.containers.geometricShapes;

import fresco.containers.geometricShapes.utils.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Polygon extends GeometricShapeAbs {

    private ArrayList<Point> points;

    public Polygon() {
        super();
        this.points = new ArrayList<>();
    }

    public void addPoint(final Point point) {
        this.points.add(point);
        this.center = getCenter();
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 0;
        int i;
        for(i = 1; i < points.size(); i++){
            perimeter+= new Line(new Point(points.get(i-1).getX(),points.get(i-1).getY()),new Point(points.get(i).getX(),points.get(i).getY())).calculatePerimeter();
        }
        perimeter+= new Line(new Point(points.get(i-1).getX(),points.get(i-1).getY()),new Point(points.get(0).getX(),points.get(0).getY())).calculatePerimeter();

        return perimeter;
    }

    @Override
    public double calculateArea() {
        double somme = 0;
        for (int j = 0; j < points.size() ; j++)
        {
            if (j == 0)
            {
                somme += points.get(j).getX() * (points.get(j+1).getY() - points.get(points.size() - 1).getY());
            }
            else if (j == points.size() - 1)
            {
                somme += points.get(j).getX() * (points.get(0).getY() - points.get(j-1).getY());
            }
            else
            {
                somme += points.get(j).getX() * (points.get(j+1).getY() - points.get(j-1).getY());
            }
        }

        double area = 0.5 * Math.abs(somme);
        return area;
    }

    @Override
    public void translation(int x, int y) {

        for (Point point : points) point.translate(x, y);
        this.center = getCenter();
    }

    @Override
    public void homothetie(Point p, int ratio) {
        for (Point point : points) {
            point.homothetie(p, ratio);
        }
        this.center = getCenter();
    }

    @Override
    public void rotation(int angle) {
        for (Point point : points) {
            point.rotation(this.center, angle);
        }
        this.center = getCenter();
    }

    @Override
    public void centralSymmetry(Point p) {

        for (Point point : points) point.centralSymmetry(p);
        this.center = getCenter();
    }

    @Override
    public void axialSymmetry(int width, int height, String s) {
        for (Point point : points) point.axialSymmetry(width, height, s);
        this.center = getCenter();
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
        int sumX = 0;
        int sumY = 0;
        for (int i = 0; i < points.size(); i++) {
            sumX += points.get(i).getX();
            sumY += points.get(i).getY();
        }
        return new Point(sumX / points.size(), sumY / points.size());
    }
}
