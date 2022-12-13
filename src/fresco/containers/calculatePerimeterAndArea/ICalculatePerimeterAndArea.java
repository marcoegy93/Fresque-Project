package fresco.containers.calculatePerimeterAndArea;

/**
 * Interface defining the behaviour of shape objects with area and perimeters properties
 */
public interface ICalculatePerimeterAndArea {

    /**
     * Calculate the perimeter of the given shape in a two-dimensional plane
     * @return the perimeter of the object
     */
    double calculatePerimeter();

    /**
     * Calculate the area of the given shape in a two-dimensional plane
     * @return the area of the object
     */
    double calculateArea();
}
