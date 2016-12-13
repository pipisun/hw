package hwfpp.lesson8.lession8;

import java.util.Scanner;

//1-Create a node
/*class Mylist2 {

	int info;// first field of the node ...info field will hold int data
	Mylist2 link; // next pointer field

	Mylist2() {

		this.link = null;
	}

}*/

public class LinkingLogic2 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);

		Mylist a = new Mylist();// creation ofnodes
		

		a.link=new Mylist();//will create a new node b and link it.
		a.link.link=new Mylist();//will create a new node c and link it.Therefore linking logic not required
		
		// Store the data into the in for field.....
		System.out.println("\t Please enter the data for info field a: ");
		a.info = s.nextInt();

		System.out.println("\t Please enter the data for info field b: ");
		a.link.info = s.nextInt();

		System.out.println("\t Please enter the data for info field c: ");
		a.link.link.info = s.nextInt();


		
		System.out.println("null");
	}

}
