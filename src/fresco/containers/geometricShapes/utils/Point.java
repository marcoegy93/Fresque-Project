package fresco.containers.geometricShapes.utils;

import fresco.containers.geometricShapes.Circle;

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
