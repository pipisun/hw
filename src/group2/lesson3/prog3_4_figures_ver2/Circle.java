package group2.lesson3.prog3_4_figures_ver2;

final public class Circle{
	
	final private double radius;
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public double computeArea(){
		//Area of a circle = PI * radius * radius
		double area = Math.PI * radius * radius;
		return Double.parseDouble(String.format("%.2f",area));
	}
}
