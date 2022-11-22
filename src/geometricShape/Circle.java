package geometricShape;

public class Circle {
    private double rayon;
    private final double pi = 3.14159;

    public Circle(double rayon){
        this.rayon = rayon;
    }

    public double calculPerimeter(){
        return 2 * this.rayon * this.pi;
    }

    public double calculArea(){
        return this.pi * this.rayon * this.rayon;
    }
}
