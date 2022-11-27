package fresco.containers.transformations;

import fresco.containers.geometricShapes.Line;
import fresco.containers.geometricShapes.utils.Point;

public interface ITransformation {

    void translation(double x, double y);
    void homothetie(Point p, double ratio);
    void rotation(Point p, double angle);
    void centralSymetry(Point p);
    void axialSymetry(Line l);
}
