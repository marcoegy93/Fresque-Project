package fresco.containers.geometricShapes;

import fresco.containers.calculatePerimeterAndArea.ICalculatePerimeterAndArea;
import fresco.containers.geometricShapes.Line;
import fresco.containers.geometricShapes.utils.Point;
import fresco.containers.transformations.ITransformation;

import java.awt.*;

public abstract class GeometricShapeAbs implements ICalculatePerimeterAndArea, ITransformation {
    protected Point center;

    public GeometricShapeAbs() {
        this.center = new Point();
    }

    public GeometricShapeAbs(Point center) {
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public abstract double calculatePerimeter();

    public abstract double calculateArea();

    public abstract void translation(int x, int y);

    public abstract void homothetie(Point p, int ratio);

    public abstract void rotation(Point p, int angle);

    public abstract void centralSymmetry(Point p);

    public abstract void axialSymmetry(Line l);

    public abstract void draw(Graphics g, Color c);

}
