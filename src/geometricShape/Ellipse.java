package geometricShape;

import static java.lang.Math.sqrt;

public class Ellipse {
    private final double pi = 3.14159;
    private double a;
    private double b;

    public Ellipse(double a, double b){
        this.a = a;
        this.b = b;
    }
    public double calculPerimeter(){
        return this.pi * (3 * (a+b) - sqrt((3*a+b)*(a+3*b)));
    }

    public double calculArea(){
        return a * b * pi;
    }
}
