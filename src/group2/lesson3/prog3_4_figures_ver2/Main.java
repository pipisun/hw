package group2.lesson3.prog3_4_figures_ver2;

public class Main{

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(23, 7);
		double rectangleArea = rectangle.computeArea();
		System.out.println("Area of Rectangle is "+ rectangleArea);
		
		Triangle triangle = new Triangle(2,3);
		double triangleArea = triangle.computeArea();
		System.out.println("Area of Triangle is "+triangleArea);
		
		Circle circle = new Circle(4);
		double circleArea = circle.computeArea();
		System.out.println("Area of Circle is "+circleArea);
		
	}
}
