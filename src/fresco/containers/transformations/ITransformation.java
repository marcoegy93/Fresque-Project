package fresco.containers.transformations;

import fresco.containers.geometricShapes.Line;
import fresco.containers.geometricShapes.utils.Point;

public interface ITransformation {

    void translation(double x, double y);
    void homothetie(Point p, double ratio);
    void rotation(Point p, double angle);
    void centralSymmetry(Point p);
    void axialSymmetry(Line l);
}
