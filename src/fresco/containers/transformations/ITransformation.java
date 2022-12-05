package fresco.containers.transformations;

import fresco.containers.geometricShapes.Line;
import fresco.containers.geometricShapes.utils.Point;

public interface ITransformation {

    void translation(int x, int y);
    void homothetie(Point p, int ratio);
    void rotation(Point p, int angle);
    void centralSymmetry(Point p);
    void axialSymmetry(Line l);
}
