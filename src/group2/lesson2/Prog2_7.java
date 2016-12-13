package group2.lesson2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
  * Prog2_7
  * Write a program that generates a random set of 8 addition problems (intended for a child in elementary school). 
  * Numbers to be added should be randomly chosen from the range 1..99. 
  * Each run of the program should result in a different set of problems 
  * (actually, there is a tiny probability that two runs of the program will produce the same set of problems, but I don¡¯t expect anyone will encounter this). 
  * Console output should be formatted like this:
	   8    23    31     99
	+ 10  + 17   + 9   + 42
	_____ ____   ____   ____
	  83    67    39      5
	+ 17   + 7  + 19   + 49
    _____ ____   ____   ____
 * A Hint is provided in the folder that accompanies this assignment, in this directory. 
 * 
 */
public class Prog2_7 {
	
	public static void main(String[] args) {

		Set<Integer> set = new HashSet<Integer>();
		while (true) {
			set.add((int) (Math.random() * 99) + 1);
			if (set.size() == 16) {
				break;
			}
		}

		Iterator<Integer> it = set.iterator();
		// for (int i = 0; i < 20; i++) {
		// 		System.out.println(it.next());
		// }

		String output = "";
		for (int i = 0; i < 2; i++) {
			output += String.format("%16d %12d %12d %12d %n %n", it.next(), it.next(), it.next(), it.next());
			output += String.format("%13s %2d %9s %2d %9s %2d %9s %2d %n", "+", it.next(), "+", it.next(), "+", it.next(), "+", it.next());
			output += String.format("%16s %12s %12s %12s", "____", "____", "____", "____");
			output += String.format("%n %n %n %n");
		}
		System.out.println(output);

	}
	
}
