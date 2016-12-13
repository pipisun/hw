package group2.lesson4.prog4_0_implement_ver1;

//4¡¢(anonymous inner classes)£º

public class Car_AnonymousInnerClass {

	interface Tire {
		public void tireRadius();
	}

	private double radius;

	public Car_AnonymousInnerClass(double circumference) {
		Tire tire = new Tire() {
			public void tireRadius() {
				radius = circumference / 2 * Math.PI; // (R=C/2pi);
			}
		};
		tire.tireRadius();
	}

	public static void main(String[] args) {
		Car_AnonymousInnerClass car = new Car_AnonymousInnerClass(10);
		System.out.println(car.radius);
	}

}