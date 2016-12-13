package group2.lesson4.prog4_0_implement_ver1;

//1¡¢ (static inner classes)
//OuterClass.InnerClass inner = new OuterClass.InnerClass();

public class Car_StaticInner {

	/**
	 * StaticInner
	 */
	public static class Tire {
		private static double radius;

		public Tire(double circumference) {
			this.radius = circumference / 2 * Math.PI; // (R=C/2pi);
		}
	}

	public static void main(String[] args) {
		Car_StaticInner.Tire tire = new Car_StaticInner.Tire(10);
		System.out.println(tire.radius);
	}
}