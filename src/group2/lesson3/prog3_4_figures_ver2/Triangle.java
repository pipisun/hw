package group2.lesson3.prog3_4_figures_ver2;

final public class Triangle {

	final private double base;
	final private double height;
	
	public double getBase() {
		return base;
	}

	public double getHeight() {
		return height;
	}

	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	public double computeArea() {
		// Area of a triangle = 1/2 * base * height
		return this.base * this.height / 2;
	}

}
