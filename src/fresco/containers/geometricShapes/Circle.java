package fresco.containers.geometricShapes;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.utils.Point;

import java.util.Objects;
import java.util.Set;

public class Circle extends GeometricShapeAbs {

    private Point pointOfCircle;

    public Circle(Point center, Point pointOfCircle){
        super(center);
        this.pointOfCircle = pointOfCircle;
    }

    public Point getPointOfCircle() {
        return pointOfCircle;
    }

    public void setPointOfCircle(Point pointOfCircle) {
        this.pointOfCircle = pointOfCircle;
    }

    public double getRadius(){
        return Point.calculateDistance(center, pointOfCircle);
    }

    public void setRadius(double radius){
        this.pointOfCircle.setX(this.center.getX() + radius);
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * 2 * this.getRadius();
    }

    @Override
    public double calculateArea() {
        return Math.pow(this.getRadius(),2) * Math.PI;
    }

    @Override
    public void translation(double x, double y) {
        this.center.setX(this.center.getX() + x);
        this.center.setY(this.center.getY() + y);
        this.pointOfCircle.setX(this.pointOfCircle.getX() + x);
        this.pointOfCircle.setY(this.pointOfCircle.getY() + y);
    }

    @Override
    public void homothetie(Point p, double ratio) {
        double newCenterX = ratio * (this.center.getX() - p.getX()) + p.getX();
        double newCenterY = ratio * (this.center.getY() - p.getY()) + p.getY();
        Point newCenter = new Point(newCenterX, newCenterY);
        this.setCenter(newCenter);
        double newPointofCircleX = ratio *(this.pointOfCircle.getX() - p.getX()) + p.getX();
        double newPointofCircleY = ratio *(this.pointOfCircle.getY() - p.getY()) + p.getY();
        Point newPointOfCircle = new Point(newPointofCircleX,newPointofCircleY);
        this.setPointOfCircle(newPointOfCircle);
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
        Circle c = (Circle) o;
        if(c.center.equals(this.center) && c.getRadius() == this.getRadius()){
            return true;
        }
        return false;
    }
}
