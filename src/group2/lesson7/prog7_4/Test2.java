package group2.lesson7.prog7_4;

import group2.lesson7.prog7_4.good.Polygon;

public class Test2 {

	public static void main(String[] args) {

		Polygon[] objects = { new Square(3), new Triangle(4, 5, 6), new Rectangle(3, 4) };

		String str = "";
		for (Polygon cc : objects) {
			if (cc instanceof Square)
				str = "For this Square";
			if (cc instanceof Triangle)
				str = "For this Triangle";
			if (cc instanceof Rectangle)
				str = "For this Rectangle";

			System.out.println(str + "\n  Number of sides = " + cc.getNumberOfSides() + " \n  Perimeter = "
					+ cc.computePerimeter());

		}
	}
}