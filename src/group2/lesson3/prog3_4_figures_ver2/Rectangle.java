package group2.lesson3.prog3_4_figures_ver2;

final public class Rectangle {

	final private double width;
	final private double height;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double computeArea() {
		//Area of a rectangle = width * height
		return width * height;
	}

	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}

}
