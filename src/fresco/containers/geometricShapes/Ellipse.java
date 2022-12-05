package fresco.containers.geometricShapes;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.utils.Point;

import static java.lang.Math.sqrt;

import java.awt.Graphics;

public class Ellipse extends GeometricShapeAbs {

    private Line littleAxis;
    private Line bigAxis;

    public Ellipse(Point center, int littleRadius,int bigRadius) {
        super(center);
        this.littleAxis = new Line(center,new Point(center.getX(),center.getY() + littleRadius));
        this.bigAxis = new Line(center,new Point(center.getX() + bigRadius, center.getY()));
    }

    public Line getLittleAxis() {
        return littleAxis;
    }

    public Line getBigAxis() {
        return bigAxis;
    }

    public void setLittleAxis(Line littleAxis) {
        this.littleAxis = littleAxis;
    }

    public void setBigAxis(Line bigAxis) {
        this.bigAxis = bigAxis;
    }

    @Override
    public double calculatePerimeter() {
        double a = this.bigAxis.calculatePerimeter();
        double b = this.littleAxis.calculatePerimeter();
        return Math.PI * (3*(a + b) - sqrt((3*a+b)*(a+3*b)));
    }

    @Override
    public double calculateArea() {
        double a = this.bigAxis.calculatePerimeter();
        double b = this.littleAxis.calculatePerimeter();
        return a * b * Math.PI;
    }

    @Override
    public void translation(int x, int y) {
        this.center.translate(x,y);
        this.bigAxis.translation(x,y);
        this.littleAxis.translation(x,y);
    }

    @Override
    public void homothetie(Point p, int ratio) {

    }

    @Override
    public void rotation(Point p, int angle) {

    }

    @Override
    public void centralSymmetry(Point p) {
        littleAxis.centralSymmetry(p);
        bigAxis.centralSymmetry(p);
    }

    @Override
    public void axialSymmetry(Line l) {
        littleAxis.axialSymmetry(l);
        bigAxis.axialSymmetry(l);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
        Ellipse e = (Ellipse) o;
        if(e.bigAxis.equals(this.bigAxis) && e.littleAxis.equals(this.littleAxis) && e.center.equals(this.center)){
            return true;
        }
        return false;
    }

	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX(), center.getY(), (int)littleAxis.calculatePerimeter(), (int)bigAxis.calculatePerimeter());
	}

}
