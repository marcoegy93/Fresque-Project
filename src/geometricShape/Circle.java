package geometricShape;

public class Circle implements IGeometricalShape{
    private Point center;
    private double rayon;

    public Circle(double rayon, Point center){
        this.rayon = rayon;
        this.center = center;
    }

    public double computePerimeter(){
        return 2 * this.rayon * Math.PI;
    }

    public double area(){
        return Math.PI * this.rayon * this.rayon;
    }
}
