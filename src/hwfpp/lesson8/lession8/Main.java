package hwfpp.lesson8.lession8;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		Employee e1 = new Employee("BBB", 5);
		Employee e2 = new Employee("AAA", 10);
		Employee e3 = new Employee("CCC", 3);

		list.add(e1);
		list.add(e2);
		list.add(e3);

		System.out.println("Before sort: ");
		for (int i = 0; i < list.size(); i++) {
			Employee e = (Employee) list.get(i);
			System.out.println(e.getName());
		}

		Collections.sort(list, Employee.NAME);

		System.out.println("After sort by Name: ");
		for (int i = 0; i < list.size(); i++) {
			Employee e = (Employee) list.get(i);
			System.out.println(e.getName());
		}

		Collections.sort(list, Employee.AGE);

		System.out.println("After sort by Age: ");
		for (int i = 0; i < list.size(); i++) {
			Employee e = (Employee) list.get(i);
			System.out.println(e.getName());
		}

	}

}