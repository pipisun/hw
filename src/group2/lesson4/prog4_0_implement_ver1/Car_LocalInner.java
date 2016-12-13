package group2.lesson4.prog4_0_implement_ver1;

//3¡¢(local inner classes)£º

public class Car_LocalInner {

	public double execute(double circumference) {
		class InnerClass {
			private double radius;

			public InnerClass() {
				this.radius = circumference / 2 * Math.PI; // (R=C/2pi);
			}
		}
		return new InnerClass().radius;
	}

	public static void main(String[] args) {
		Car_LocalInner localInner = new Car_LocalInner();
		System.out.println(localInner.execute(10));
	}
}