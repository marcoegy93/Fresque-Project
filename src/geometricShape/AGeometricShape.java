package geometricShape;

public abstract class AGeometricShape {
    private Point anchor;

    public Point getAnchor() {return anchor;}

    public void setAnchor(Point anchor) {this.anchor = anchor;}

    public abstract double perimeter();
    public abstract double area();

    public void homothetie(){

    }

    public void translate(){

    }

}
