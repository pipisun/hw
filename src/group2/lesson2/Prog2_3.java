package group2.lesson2;

/**
 * Prog2_3
 * Create a class Prog3. Inside its main method,
 * create float variables to store each of the following numbers:
 * 	1.27, 3.881, 9.6
 * Output to the console the following two values:
 * 1. the sum of the floats as an integer, obtained by casting the sum to type int
 * 2. the sum of the floats as an integer, obtained by rounding the sum to the nearest integer, 
 * 	using the Math.round function
 *
 */
public class Prog2_3 {
	
	public static void main(String[] args) {
		float first = 1.27f;
		float second = 3.881f;
		float third = 9.6f;

		int sumInt = (int) (first + second + third);
		int sumRound = Math.round(first + second + third);

		System.out.println("Sum is:" + sumInt);
		System.out.println("Sum is:" + sumRound);
	}
	
}
