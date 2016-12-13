package hwfpp.lesson8.lession8;

import java.util.Scanner;

//1-Create a node
/*class Mylist2 {

 int info;// first field of the node ...info field will hold int data
 Mylist2 link; // next pointer field

 Mylist2() {

 this.link = null;
 }

 }
 */
public class CreatingLikedList3 {
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
			Mylist l = new Mylist();// creating node with l

			System.out.println("PLease enter the data for the info field");
			l.info = sc.nextInt();// data stored

			s.link = l;// update and linking s by l

			s = l;// update the s. S is new node

		} // end of while
		s = t;// storing the address of s
		System.out.print("\n \t");
		while (s != null) {
			System.out.print(s.info + "->");
			s = s.link;

		}
		System.out.print("null");
	}

}
