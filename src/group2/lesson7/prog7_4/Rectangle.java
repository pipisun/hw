package group2.lesson7.prog7_4;

import group2.lesson7.prog7_4.good.Polygon;

public final class Rectangle extends ClosedCurve implements Polygon {
	private final double width;
	private final double length;

	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;

	}

	public double computeArea() {
		return this.width * this.length;
	}

	@Override
	public int getNumberOfSides() {
		return 4;
	}

	@Override
	public double computePerimeter() {
		return (this.width + this.length) * 2;
	}

}
