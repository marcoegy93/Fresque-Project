package fresco.containers.geometricShapes.utils;

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

    public static double calculateDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }

    public void translate(int x_translation, int y_translation) {
        this.setX(x + x_translation);
        this.setY(y + y_translation);
    }

    public void centralSymmetry(Point o) {
        int x_distance = o.getX() - x;
        int y_distance = o.getY() - y;
        translate(x_distance * 2, y_distance * 2);
    }

    public void axialSymmetry(Line l) {
//        int x_distance = (l.getPointA().getX() - x) + (l.getPointB().getX() - x);
//        int y_distance = (l.getPointA().getY() - y) + (l.getPointB().getY() - y);
//        translate(x_distance, y_distance);

    }

    public void homothetie(Point p, int ratio) {
        int x_distance = this.getX() - p.x;
        int y_distance = this.getY() - p.y;
        p.translate(x_distance * ratio, y_distance * ratio);
        this.setX(p.x);
        this.setY(p.y);
    }

    public void rotation(Point p, int angle) {
        int deplacementX = 0, deplacementY = 0;
        Point pcenter;
        if(p.y != 0 || p.x != 0) {
            deplacementX = p.x;
            deplacementY = p.y;
            pcenter = new Point();
            translate(-deplacementX, -deplacementY);
        }else{
            pcenter = p;
        }
        double cos = Math.cos((angle * Math.PI) / 180);
        double sin = Math.sin((angle * Math.PI) / 180);
        int x2 = (int)Math.round(pcenter.x - (x * cos - y * sin));
        int y2 = (int)Math.round(pcenter.y - (x * sin + y * cos));
        setY(y2);
        setX(x2);
        if(deplacementX != 0 || deplacementY != 0) {
            translate(deplacementX, deplacementY);
        }
//        angle = (int) (Math.PI / 180);
//        int xM = this.x - p.x;
//        int yM = this.y - p.y;
//        double x = xM * Math.cos (angle) + yM * Math.sin (angle) + p.x;
//        double y = - xM * Math.sin (angle) + yM * Math.cos (angle) + p.y;
//        setY((int) Math.round(y));
//        setX((int) Math.round(x));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Point p = (Point) o;
        return p.getX() == this.getX() && p.getY() == this.getY();
    }
}
