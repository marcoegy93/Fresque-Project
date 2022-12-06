package fresco.containers.geometricShapes;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.utils.Point;

import static java.lang.Math.sqrt;

import java.awt.Graphics;
import java.awt.Graphics;

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
public class Ellipse extends GeometricShapeAbs {
    private int height,width;

    public Ellipse(Point center, int height,int width) {
        super(center);
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * (3*(height + width) - sqrt((3*height+width)*(height+3*width)));
    }

    @Override
    public double calculateArea() {
        return height * width * Math.PI;
    }

    @Override
    public void translation(int x, int y) {
        this.center.translate(x,y);
    }

    @Override
    public void homothetie(Point p, int ratio) {
        this.center.homothetie(p, ratio);
        this.height*= ratio;
        this.width*= ratio;
    }

    @Override
    public void rotation(int angle) {
        //à refaire
        Point pHeight = new Point(this.center.getX() + height, this.center.getY() + height );
        Point pWidth = new Point(this.center.getX() + width, this.center.getY() + width );
        pHeight.rotation(this.center,angle);
        pWidth.rotation(this.center,angle);

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
        Ellipse e = (Ellipse) o;
        if(e.height == height && e.width == width && e.center.equals(this.center)){
            return true;
        }
        return false;
    }

	@Override
	public void draw(Graphics g, Color c ) {
		g.setColor(c);
		g.drawOval(center.getX(), center.getY(),width, height);
	}

}
