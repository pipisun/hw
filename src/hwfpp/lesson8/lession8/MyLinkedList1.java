package hwfpp.lesson8.lession8;

import java.util.LinkedList;

public class MyLinkedList1 {
	public static void main(String args[]) {
		LinkedList<String> name = new LinkedList<String>();
		name.add("peter");
		name.add("bill");
		name.add("mike");
		name.add("harry");
		System.out.println("After calling add function");
		for (String x : name) {
			System.out.println(x);
		}
		
		name.addFirst("Dove");
		System.out.println("After calling add first function");
		for (String x : name) {
			System.out.println(x);
		}
		name.set(1, "Peter");
		System.out.println("After calling set function");
		for (String x : name) {
			System.out.println(x);
		}
		
		name.removeLast();
		System.out.println("After calling remove last function");
		for (String x : name) {
			System.out.println(x);
		}
		System.out.println(name.size());
		name.clear();
		System.out.println("After calling clear function");
		for (String x : name) {
			System.out.println(x);
		}
		
	}
}
