package hwfpp.lesson8.lession8;

import java.util.Scanner;

public class CreatingLinkedList4 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		char c;

		Mylist s = new Mylist();
		Mylist t = s;// t holds starting address of s
		System.out.println("\t Enter data for the info field:");
		s.info = sc.nextInt();
		while (true) {
			System.out.println("\t to add node press y else n");
			c = sc.next().charAt(0);
			if (c == 'n' || c == 'N') {
				break;
			}

			s.link = new Mylist();
			System.out.println("PLease enter the data for the info field");

			s.link.info = sc.nextInt();

			s = s.link;// links the node

		}// end of while
		s = t;// storing the address of s
		System.out.print("\n \t");
		while (s != null) {
			System.out.print(s.info + "->");
			s = s.link;

		}
		System.out.print("null");
	
	}

}
