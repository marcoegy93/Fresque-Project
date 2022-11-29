package fresco.containers.geometricShapes.utils;

import fresco.containers.geometricShapes.Circle;
import fresco.containers.geometricShapes.Line;

public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static double calculateDistance(Point a, Point b){
        return Math.sqrt(Math.pow(b.getX() - a.getX(),2) + Math.pow(b.getY() - a.getY(),2));
    }

    public void translate(double x_translation, double y_translation){
        this.setX(x + x_translation);
        this.setY(y + y_translation);
    }

    public void centralSymmetry(Point o){
        double x_distance = o.getX() - x;
        double y_distance = o.getY() - y;
        translate(x_distance*2, y_distance*2);
    }

    public void axialSymmetry(Line l){
        double x_distance = (l.getPointA().getX() - x) + (l.getPointB().getX() - x);
        double y_distance = (l.getPointA().getY() - y) + (l.getPointB().getY() - y);
        translate(x_distance, y_distance);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
        Point p = (Point) o;
        if(p.getX() == this.getX() && p.getY() == this.getY()){
            return true;
        }
        return false;
    }
}
