package fresco.containers.geometricShapes;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.utils.Point;

import java.util.Set;

public class Line extends GeometricShapeAbs {

    private Point pointA;
    private Point pointB;

    public Line(Point pointA,Point pointB) {
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

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    @Override
    public Point getCenter() {
        return new Point((this.getPointA().getX() + this.getPointB().getX()) / 2,
                (this.getPointA().getY() + this.getPointB().getY()) / 2);
    }
    @Override
    public double calculatePerimeter() {
        return Point.calculateDistance(this.pointA,this.pointB);
    }

    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public void translation(double x, double y) {
        Point a = new Point(this.getPointA().getX()+x,this.getPointA().getY()+y);
        Point b =new Point(this.getPointB().getX()+x,this.getPointB().getY()+y);
        this.setPointA(a);
        this.setPointB(b);
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
        Line l = (Line) o;
        if(l.pointA.equals(this.pointA) && l.pointB.equals(this.pointB)){
            return true;
        }
        return false;
    }
}
