package fresco.containers.geometricShapes;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.utils.Point;

import java.util.LinkedHashSet;
import java.util.Set;

public class Polygon extends GeometricShapeAbs {

    private Set<Point> points;

    public Polygon() {
        super();
        this.points = new LinkedHashSet<Point>();
    }

    public Polygon(Set<Point> points) {
        super();
        this.points = points;
    }



    public void setPoints(Set<Point> points) {
        this.points = points;
    }
    public void addPoint(final Point point){
        this.points.add(point);
    }
    @Override
    public double calculatePerimeter() {

        return 0;
    }

    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public void translation(double x, double y) {

    }

    @Override
    public void homothetie(Point p, double ratio) {

    }

    @Override
    public void rotation(Point p, double angle) {

    }

    @Override
    public void centralSymetry(Point p) {

    }

    @Override
    public void axialSymetry(Line l) {

    }

    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
        Polygon p = (Polygon) o;
        int i =0;
        if(this.points.size() == p.points.size() && this.points.containsAll(p.points)){
            return true;
        }
        return false;
    }
}
