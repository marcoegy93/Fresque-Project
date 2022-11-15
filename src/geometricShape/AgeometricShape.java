package geometricShape;

import property.AgeometricProperty;

public abstract class AgeometricShape extends AgeometricProperty{
	
	private double horizontal;
	private double vertical;

	public AgeometricShape(double horizontal, double vertical, int air, int perimeter) {
		
		super(air,perimeter);
		this.horizontal=horizontal;
		this.vertical = vertical;
		
	}
	
}
