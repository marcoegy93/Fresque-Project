package fresco.containers.geometricShapes;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.utils.Point;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
        pointA.translate(x,y);
        pointB.translate(x,y);
    }

    @Override
    public void homothetie(Point p, double ratio) {

    }

    @Override
    public void rotation(Point p, double angle) {

    }

    @Override
    public void centralSymmetry(Point p) {
        this.pointA.centralSymmetry(p);
        this.pointB.centralSymmetry(p);
    }

    @Override
    public void axialSymmetry(Line l) {
        this.pointB.axialSymmetry(l);
        this.pointA.axialSymmetry(l);
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

	@Override
	public void paintComponent(Graphics g) {
		Graphics g2 = (Graphics2D) g;
        int height = 200;
        int width = 100;
        for(int i=0; i<10; i++){
            g2.drawLine((width/10)*i, 0, (width/10)*i, height);
            g2.drawLine(0, (height/10)*i, width, (height/10)*i);
        }
		
	}


}
