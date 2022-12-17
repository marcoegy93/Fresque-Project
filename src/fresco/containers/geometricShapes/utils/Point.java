package fresco.containers.geometricShapes.utils;

/**
 * Utility class that represents a Point placed in a 2 dimension plane
 * It allows the abstraction of complex shape transformations to simple 2D point transformations
 */
public class Point {
    /**
     * Integers representing the coordinates of the point in the 2 dimension plane
     */
    private int x, y;

    /**
     * Default constructor of a point, where it's coordinates are set to zero
     */
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructor of a point with given coordinates
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method that calculates the distance to a point
     * @param b the point to get to
     * @return the distance to the given point
     */
    public double calculateDistance(Point b) {
        return Math.sqrt(Math.pow(b.getX() - getX(), 2) + Math.pow(b.getY() - getY(), 2));
    }

    /**
     * Getter that gets the horizontal coordinate of the point
     * @return the horizontal coordinate of the Point
     */
    public int getX() {
        return x;
    }

    /**
     * Setter that sets the horizontal coordinate of the Point from a given integer
     * @param x the new horizontal coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter that gets the vertical coordinate
     * @return the vertical coordinate of the Point
     */
    public int getY() {
        return y;
    }

    /**
     * Setter that sets the vertical coordinate of the Point from a given integer
     * @param y the new vertical coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Method that translates the point by x and y
     * @param x the horizontal movement to apply to the Point
     * @param y the vertical movement to apply to the Point
     */
    public void translate(int x, int y) {
        this.setX(this.x + x);
        this.setY(this.y + y);
    }

    /**
     * Method that does the center symmetry of the Point around a given point
     * @param o the center of symmetry
     */
    public void centralSymmetry(Point o) {
        int x_distance = o.getX() - x;
        int y_distance = o.getY() - y;
        translate(x_distance * 2, y_distance * 2);
    }

    /**
     * Method that does the axial symmetry of the Point based on horizontal or vertical axis
     * @param width the width which defines the movement of the shape on the horizontal axis
     * @param height the height which defines the movement of the shape on the vertical axis
     * @param s the type of axial symmetry (whether 'Vertical' or 'Horizontal')
     */
    public void axialSymmetry(int width, int height, String s) {
        if (s == "vertical") {
            this.setX(width - this.x);
        } else {
            this.setY(height - this.y);
        }
    }

    /**
     * Method that scales to point (growing or shrinking)
     * @param p     the origin of the homothety
     * @param ratio the ratio that scales the shape
     */
    public void homothetie(Point p, int ratio) {
        int x_distance = this.getX() - p.x;
        int y_distance = this.getY() - p.y;
        p.translate(x_distance * ratio, y_distance * ratio);
        this.setX(p.x);
        this.setY(p.y);
    }

    /**
     * Method that rotates the shape with a given angle
     *
     * @param p the point to help with the rotation
     * @param angle the angle of the rotation
     */
    public void rotation(Point p, int angle) {
        int deplacementX = 0, deplacementY = 0;
        Point pcenter;
        if (p.y != 0 || p.x != 0) {
            deplacementX = p.x;
            deplacementY = p.y;
            pcenter = new Point();
            translate(-deplacementX, -deplacementY);
        } else {
            pcenter = p;
        }
        double cos = Math.cos((angle * Math.PI) / 180);
        double sin = Math.sin((angle * Math.PI) / 180);
        int x2 = (int) Math.round(pcenter.x - (x * cos - y * sin));
        int y2 = (int) Math.round(pcenter.y - (x * sin + y * cos));
        setY(y2);
        setX(x2);
        if (deplacementX != 0 || deplacementY != 0) {
            translate(deplacementX, deplacementY);
        }
    }
}
