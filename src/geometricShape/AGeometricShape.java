package geometricShape;

public abstract class AGeometricShape {
    private Point anchor;

    public Point getAnchor() {return anchor;}

    public void setAnchor(Point anchor) {this.anchor = anchor;}

    public abstract double perimeter();
    public abstract double area();

    public void homothetie(){

    }

    public void translate(int x, int y){
        this.anchor.setX(anchor.getX() + x);
        this.anchor.setY(anchor.getY() + y);
    }

    public void centralSymmetry(Point O){
        int x_translation = O.getX() - anchor.getX();
        int y_translation = O.getY() - anchor.getY();
        translate(x_translation, y_translation);
    }

    public void axialSymmetry(int axe){

    }
}
