package group2.lesson2;

/**
 * Prog2_8
 * Create a Java method
 * static int min(int[] arrayOfInts)
 * (in a class Prog2_8) that outputs the minimum of an array of ints.
 * Create a class Prog2_8Test that tests your method on the following input array
 * [2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22]
 * using JUnit.
 * NOTE: You may not use the sorting tools available in the Java libraries; 
 * for instance, you may not call Arrays.sort() to sort the input array. 
 * (No credit if you do it this way.)
 */
public class Prog2_8 {
	
//	public static void main(String[] args) {
//		int[] arrayOfInts = new int[]{2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22};
//		System.out.println(min(arrayOfInts));
//	}
	
	static int min(int[] arrayOfInts) {
		int minNum = arrayOfInts[0];
		for (int i = 1; i < arrayOfInts.length; i++) {
			if (arrayOfInts[i] < minNum) {
				minNum = arrayOfInts[i];
			}
		}
		return minNum;
	}
}
