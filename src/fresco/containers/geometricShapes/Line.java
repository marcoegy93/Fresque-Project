package fresco.containers.geometricShapes;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.utils.Point;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Set;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.utils.Point;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;
import java.util.Set;

import javax.swing.JComponent;
import fresco.containers.Drawing;
import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.Circle;
import fresco.containers.geometricShapes.Ellipse;
import fresco.containers.geometricShapes.Line;

import fresco.containers.geometricShapes.Polygon;
import fresco.containers.geometricShapes.utils.Point;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    public void translation(int x, int y) {
        pointA.translate(x,y);
        pointB.translate(x,y);
    }

    @Override
    public void homothetie(Point p, int ratio) {
        this.pointA.homothetie(p, ratio);
        this.pointB.homothetie(p, ratio);
    }

    @Override
    public void rotation(Point p, int angle) {

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
	public void draw(Graphics g,Color c ) {
		g.setColor(c);
        g.drawLine((int)this.pointA.getX(),(int)this.pointA.getY(),(int)this.pointB.getX(),(int)this.pointB.getY());
		
	}
}
