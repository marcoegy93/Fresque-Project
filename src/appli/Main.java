package appli;

import fresco.Fresco;
import fresco.containers.Drawing;
import fresco.containers.GeometricShapeAbs;
import fresco.containers.Image;
import fresco.containers.geometricShapes.Ellipse;
import fresco.containers.geometricShapes.utils.Point;

public class Main {
    public static void main(String[] args) {
        Fresco f = new Fresco();
        Drawing d = new Drawing();
        Image i = new Image();
        Point center = new Point(5,5);
        GeometricShapeAbs gs = new Ellipse(center,8,7);
        GeometricShapeAbs gs2 = new Ellipse(center,5,6);
        GeometricShapeAbs gs3 = new Ellipse(center,10,12);
        GeometricShapeAbs gs4 = new Ellipse(center,15,16);
        System.out.println(gs.calculatePerimeter());
        i.addShape(gs);
        i.addShape(gs2);
        i.addShape(gs3);
        i.addShape(gs4);
        i.addShape(gs);
        i.addShape(gs);
        i.addShape(gs);
        i.addShape(gs);
        double a = gs.calculatePerimeter();
        double b = gs2.calculatePerimeter();
        double c = gs3.calculatePerimeter();
        double e = gs4.calculatePerimeter();
        i.shapesSort();
        d.addImage(i);
        f.addDrawing(d);
    }
}