package group2.lesson7.prog7_4;

import group2.lesson7.prog7_4.good.Polygon;

public final class Square extends ClosedCurve implements Polygon {
	private final double side;

	public Square(double side) {
		this.side = side;

	}

	public double computeArea() {
		return side * side;
	}

	@Override
	public int getNumberOfSides() {
		return 4;
	}

	@Override
	public double computePerimeter() {
 		return side * 4;
	}

}
