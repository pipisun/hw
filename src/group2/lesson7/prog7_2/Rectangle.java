package group2.lesson7.prog7_2;

public final class Rectangle extends ClosedCurve {
	private final double width;
	private final double length;
	
	public Rectangle(double width, double length){
		this.width = width;
		this.length = length;
		
	}
	public double computeArea() {
		return this.width * this.length;
	}


}
