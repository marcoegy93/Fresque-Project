package fresco.containers;

import fresco.containers.calculatePerimeterAndArea.ICalculatePerimeterAndArea;
import fresco.containers.geometricShapes.Line;
import fresco.containers.geometricShapes.utils.Point;
import fresco.containers.transformations.ITransformation;

import java.util.Set;

public abstract class GeometricShapeAbs implements ICalculatePerimeterAndArea, ITransformation {
    protected Point center;

    public GeometricShapeAbs(){
        this.center = new Point();
    }

    public GeometricShapeAbs(Point center){
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public abstract double calculatePerimeter();

    public abstract double calculateArea();

    public abstract void translation(double x, double y);

    public abstract void homothetie(Point p, double ratio);

    public abstract void rotation(Point p, double angle);

    public abstract void centralSymetry(Point p);

    public abstract void axialSymetry(Line l);
}
