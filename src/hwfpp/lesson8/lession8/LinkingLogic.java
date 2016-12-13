package hwfpp.lesson8.lession8;

import java.util.Scanner;

//1-Create a node
class Mylist {

	int info;// first field of the node ...info field will hold int data
	Mylist link; // next pointer field...reference variable of Mylist type

	Mylist() {

		this.link = null;//initialise as null
	}

}

public class LinkingLogic {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);

		Mylist a = new Mylist();// creation of nodes
		Mylist b = new Mylist();
		Mylist c = new Mylist();

		// Store the data into the in for field.....
		System.out.println("\t Please enter the data for info field a: ");
		a.info = s.nextInt();

		System.out.println("\t Please enter the data for info field b: ");
		b.info = s.nextInt();

		System.out.println("\t Please enter the data for info field c: ");
		c.info = s.nextInt();

		// Linking of nodes
		a.link = b;
		b.link = c;
		// printing content of info....
		System.out.println("Content of a:" + a.info);
		System.out.println("Content of b:" + a.link.info);
		System.out.println("Content of c:" + a.link.link.info);

		// printing content using loop
		while (a != null) {
			System.out.print(a.info + "->");// this will print but not advance
			a = a.link;// update a for iteration.
		}
		System.out.println("null");
	}

}
