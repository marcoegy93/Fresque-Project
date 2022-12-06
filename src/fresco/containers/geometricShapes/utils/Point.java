package fresco.containers.geometricShapes.utils;

import fresco.containers.geometricShapes.Circle;
import fresco.containers.geometricShapes.Line;

public class Point {
    private int x;
    private int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static double calculateDistance(Point a, Point b){
        return Math.sqrt(Math.pow(b.getX() - a.getX(),2) + Math.pow(b.getY() - a.getY(),2));
    }

    public void translate(int x_translation, int y_translation){
        this.setX(x + x_translation);
        this.setY(y + y_translation);
    }

    public void centralSymmetry(Point o){
        int x_distance = o.getX() - x;
        int y_distance = o.getY() - y;
        translate(x_distance*2, y_distance*2);
    }

    public void axialSymmetry(Line l){
        int x_distance = (l.getPointA().getX() - x) + (l.getPointB().getX() - x);
        int y_distance = (l.getPointA().getY() - y) + (l.getPointB().getY() - y);
        translate(x_distance, y_distance);
    }

    public void homothetie(Point p, int ratio){
        int x_distance = this.getX() - p.x;
        int y_distance = this.getY() - p.y;
        p.translate(x_distance*ratio, y_distance*ratio);
        this.setX(p.x);
        this.setY(p.y);
    }

    public void rotation(Point p, int angle) {
        int x2 = (int)Math.round(p.x - (x * Math.cos((angle * Math.PI) / 180) - y * Math.sin((angle * Math.PI) / 180)));
        int y2 = (int)Math.round(p.y - (x * Math.sin((angle * Math.PI) / 180) + y * Math.cos((angle * Math.PI) / 180)));
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
