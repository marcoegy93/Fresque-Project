package fresco.containers.geometricShapes;

import fresco.containers.calculatePerimeterAndArea.ICalculatePerimeterAndArea;
import fresco.containers.geometricShapes.utils.Point;
import fresco.containers.transformations.ITransformation;

import java.awt.*;

/**
 * Abstract class that defines the behaviour of a GeometricShape
 */
public abstract class GeometricShapeAbs implements ICalculatePerimeterAndArea, ITransformation {
    /**
     * The center of the shape
     */
    protected Point center;

    /**
     * The Default constructor of a GeometricShape
     */
    public GeometricShapeAbs() {
        this.center = new Point();
    }

    /**
     * The constructor of a GeometricShape with a given center
     *
     * @param center the center of the shape
     */
    public GeometricShapeAbs(Point center) {
        this.center = center;
    }

    /**
     * Getter that gets the center of the shape
     *
     * @return the center of the shape
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Methods that calculates the perimeter of the GeometricShape
     *
     * @return the perimeter of the GeometricShape
     */
    public abstract double calculatePerimeter();

    /**
     * Methods that calculates the area of the GeometricShape
     *
     * @return the area of the GeometricShape
     */
    public abstract double calculateArea();

    /**
     * Methods that draws the GeometricShape on a Image
     *
     * @param g the Graphics of the JPanel to draw on
     * @param c the Color used to draw the shape
     */
    public abstract void draw(Graphics g, Color c);

}
