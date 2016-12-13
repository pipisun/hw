package group2.lesson4.prog4_0_implement_ver1;

//2¡¢(member inner classes)£º
//
//OuterClass.InnerClass inner = new OuterClass().new InnerClass();
//
//OuterClass.this.a;

public class Car_MemberInner {

	public class Tire {

		private double radius;

		public Tire(double circumference) {
			this.radius = circumference / 2 * Math.PI; // (R=C/2pi);
		}

	}

	public static void main(String[] args) {
		Car_MemberInner.Tire tire = new Car_MemberInner().new Tire(10);
		System.out.println(tire.radius);
	}
}