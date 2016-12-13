package group2.lesson6;

public class Exponential {

	public static void main(String[] args) {
		Exponential exp = new Exponential();
		double pow = exp.power(2, 10);
		System.out.println("Pow(2,10)=" + pow);

	}
	
	public double power(double x,int n) {
		if(n == 1)
			return x;
		else if(n % 2 == 0)
			return power(x, n/2) * power(x, n/2);
		else
			return x * power(x, n - 1);
	}
}
