package group2.lesson7.prog7_2;

public class Test {
	
	public static void main(String[] args) {

		ClosedCurve[] objects = {new Triangle(4,5,6),
								 new Square(3),
								 new Rectangle(3, 7),
								 new Circle(3)};
		//compute areas
		String str = "";
		for(ClosedCurve cc : objects) {
			if(cc instanceof Triangle)
				str = "Triangle";
			if(cc instanceof Square)
				str = "Square";
			if(cc instanceof Rectangle)
				str = "Rectangle";
			if(cc instanceof Circle)
				str = "Circle";
			
			System.out.println("The area of this "  + str + " is " + cc.computeArea());
		}
	}
}