package property;

public abstract class AgeometricProperty implements IgeometricProperty{

		private double air;
		private double perimeter;
		
		
		public AgeometricProperty(double air, double perimeter){
			this.air = air;
			this.perimeter = perimeter;
		}
		
}
