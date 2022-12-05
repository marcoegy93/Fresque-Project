package fresco.containers.geometricShapes;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.utils.Point;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;
import java.util.Set;

import javax.swing.JComponent;

public class Circle extends GeometricShapeAbs {

    private int radius;

    public Circle(Point center, int radius){
        super(center);
        this.radius = radius;
    }

    public int getRadius() {return radius;}

    public void setRadius(int radius) {this.radius = radius;}

    @Override
    public double calculatePerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public double calculateArea() {
        return Math.pow(radius,2) * Math.PI;
    }

    @Override
    public void translation(int x, int y) {
        center.translate(x,y);
    }

    @Override
    public void homothetie(Point p, int ratio) {
        int newCenterX = ratio * (this.center.getX() - p.getX()) + p.getX();
        int newCenterY = ratio * (this.center.getY() - p.getY()) + p.getY();
        Point newCenter = new Point(newCenterX, newCenterY);
        this.setCenter(newCenter);

       this.radius*= ratio;
    }

    @Override
    public void rotation(Point p, int angle) {
        return;
    }

    @Override
    public void centralSymmetry(Point p) {
        center.centralSymmetry(p);
    }

    @Override
    public void axialSymmetry(Line l) {
        center.axialSymmetry(l);
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

	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX(), center.getY(), radius, radius);
	}

}
