package fresco.containers;

import fresco.containers.calculatePerimeterAndArea.ICalculatePerimeterAndArea;
import fresco.containers.geometricShapes.Line;
import fresco.containers.geometricShapes.utils.Point;
import fresco.containers.transformations.ITransformation;

import java.util.*;

public class Image implements ICalculatePerimeterAndArea, ITransformation {
    private Set<GeometricShapeAbs> shapes;

    public Image(){
        this.shapes = new LinkedHashSet<GeometricShapeAbs>();
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
    public void translation(double x, double y) {
        for(GeometricShapeAbs gs : shapes){
            gs.translation(x,y);
        }
    }

    @Override
    public void homothetie(Point p, double ratio) {
        for(GeometricShapeAbs gs : shapes){
            gs.homothetie(p,ratio);
        }
    }

    @Override
    public void rotation(Point p, double angle) {
        for(GeometricShapeAbs gs : shapes){
            gs.rotation(p,angle);
        }
    }

    @Override
    public void centralSymetry(Point p) {
        for(GeometricShapeAbs gs : shapes){
            gs.centralSymetry(p);
        }
    }

    @Override
    public void axialSymetry(Line l) {
        for(GeometricShapeAbs gs : shapes){
            gs.axialSymetry(l);
        }
    }

    public void shapesSort(){
        List<GeometricShapeAbs> list = new ArrayList<GeometricShapeAbs>(shapes);
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(i).calculatePerimeter() < list.get(j).calculatePerimeter()){
                    GeometricShapeAbs tmp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,tmp);
                }
            }
        }
        Set<GeometricShapeAbs> shapes = new LinkedHashSet<>(list);
        this.setShapes(shapes);
    }
}
