package geometricShape;

import static java.lang.Math.sqrt;

/**
 * Class representing an ellipse
 */
public class Ellipse extends AGeometricShape{
    private double height, length;
    private Point anchor;

    /**
     * Basic constructor of an ellipse
     * @param height the height of the ellipse
     * @param length the length of the ellipse
     * @param anchor the anchor point from which the ellipse will be drawn
     */
    public Ellipse(double height, double length, Point anchor) {
        this.height = height;
        this.length = length;
        this.anchor = anchor;
    }

    /**
     * Compute the perimeter of an ellipse using Ramanujan approximation with approximately 0.01% error
     * @return the approximated perimeter of the ellipse
     */
    @Override
    public double perimeter(){ return Math.PI * (3*(length + height) - sqrt((3*length+height)*(length+3*height)));}

    /**
     * Compute the area of the ellipse
     * @return
     */
    @Override
    public double area() {
        return (height/2) * (length/2) * Math.PI;
    }

}
