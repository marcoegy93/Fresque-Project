package fresco.containers.geometricShapes;

import fresco.containers.GeometricShapeAbs;
import fresco.containers.geometricShapes.utils.Point;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
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
public class Polygon extends GeometricShapeAbs {

    private ArrayList<Point> points;

    public Polygon() {
        super();
        this.points = new ArrayList<>();
    }

    public Polygon(ArrayList<Point> points) {
        super();
        this.points = points;
    }



    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
    public void addPoint(final Point point){
        this.points.add(point);
    }
    @Override
    public double calculatePerimeter() {

        return 0;
    }

    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public void translation(int x, int y) {
        for(Point point : points) point.translate(x,y);
    }

    @Override
    public void homothetie(Point p, int ratio) {

    }

    @Override
    public void rotation(Point p, int angle) {

    }

    @Override
    public void centralSymmetry(Point p) {
        for(Point point : points) point.centralSymmetry(p);
    }

    @Override
    public void axialSymmetry(Line l) {
        for(Point point : points) point.axialSymmetry(l);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
        Polygon p = (Polygon) o;
        int i =0;
        if(this.points.size() == p.points.size() && this.points.containsAll(p.points)){
            return true;
        }
        return false;
    }

	@Override
	public void draw(Graphics g,Color c) {
		g.setColor(c);
        int points_x [] = new int[points.size()];
        int points_y [] = new int[points.size()];
        for(int i=0; i<points.size(); i++){
            points_x[i] = points.get(i).getX();
            points_y[i] = points.get(i).getY();
        }
        g.drawPolygon(points_x, points_y, points.size());
	}

}
