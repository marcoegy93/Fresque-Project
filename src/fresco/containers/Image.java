package fresco.containers;

import fresco.containers.calculatePerimeterAndArea.ICalculatePerimeterAndArea;
import fresco.containers.geometricShapes.*;
import fresco.containers.geometricShapes.Polygon;
import fresco.containers.geometricShapes.utils.Point;
import fresco.containers.transformations.ITransformation;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;
import java.util.List;

import javax.swing.JComponent;
import fresco.containers.geometricShapes.Line;

import fresco.containers.geometricShapes.utils.Point;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Image implements ICalculatePerimeterAndArea, ITransformation {
	
    private Set<GeometricShapeAbs> shapes;
    private String name;
    private Color c ;

    public Image(String name, Color c){
        this.shapes = new LinkedHashSet<GeometricShapeAbs>();
        this.name = name;
        this.c = c;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public Color getColor() {
    	return this.c;
    }

    public Image(Set<GeometricShapeAbs> shapes){
        this.shapes = shapes;
    }

    public Set<GeometricShapeAbs> getShapes() {
        return shapes;
    }

    public void setShapes(Set<GeometricShapeAbs> shapes) {
        this.shapes = shapes;
    }

    public void addShape(GeometricShapeAbs gs){
        this.shapes.add(gs);
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 0;
        for(GeometricShapeAbs gs : shapes){
            perimeter+= gs.calculatePerimeter();
        }
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double area = 0;
        for(GeometricShapeAbs gs : shapes){
            area+= gs.calculateArea();
        }
        return area;
    }

    @Override
    public void translation(int x, int y) {
        for(GeometricShapeAbs gs : shapes){
            gs.translation(x,y);
        }
    }

    @Override
    public void homothetie(Point p, int ratio) {
        for(GeometricShapeAbs gs : shapes){
            gs.homothetie(p,ratio);
        }
    }

    @Override
    public void rotation(int angle) {
        for(GeometricShapeAbs gs : shapes){
            gs.rotation(angle);
        }
    }

    @Override
    public void centralSymmetry(Point p) {
        for(GeometricShapeAbs gs : shapes){
            gs.centralSymmetry(p);
        }
    }

    @Override
    public void axialSymmetry(Line l) {
        for(GeometricShapeAbs gs : shapes){
            gs.axialSymmetry(l);
        }
    }

    public void shapesSort() {
        List<GeometricShapeAbs> list = new ArrayList<GeometricShapeAbs>(shapes);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).calculatePerimeter() < list.get(j).calculatePerimeter()) {
                    GeometricShapeAbs tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
        Set<GeometricShapeAbs> shapes = new LinkedHashSet<>(list);
        this.setShapes(shapes);
    }
}
