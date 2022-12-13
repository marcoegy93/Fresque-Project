package fresco.containers.transformations;

import fresco.containers.geometricShapes.utils.Point;

/**
 * Interface defining the transformation applied to shape objects
 */
public interface ITransformation {
    /**
     * Method that translates the shape by x and y
     *
     * @param x the horizontal movement
     * @param y the vertical movement
     */
    void translation(int x, int y);

    /**
     * Method that scales the shape (growing or shrinking)
     *
     * @param p     the origin of the homothety
     * @param ratio the ratio that scales the shape
     */
    void homothetie(Point p, int ratio);

    /**
     * Method that rotates the shape with a given angle
     *
     * @param angle the angle of the rotation
     */
    void rotation(int angle);

    /**
     * Method that creates the symmetry of the shape from a given point
     *
     * @param p the point of symmetry
     */
    void centralSymmetry(Point p);

    void axialSymmetry(int width, int height, String s);
}
