package group2.lesson7.prog7_6.case1;

import java.util.GregorianCalendar;

public class Person {
	private String name;
	private GregorianCalendar dateOfBirth;

	Person(String name, GregorianCalendar dob) {
		this.name = name;
		dateOfBirth = dob;
	}

	public String getName() {
		return name;
	}

	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof Person)) return false;
		Person p = (Person)ob;
		return p.name.equals(name) && p.dateOfBirth.equals(dateOfBirth);
	}

	public static void main(String[] args) {
		 Person p1 = new Person("Joe",new GregorianCalendar(2013, 11, 12, 1, 3, 2));
		 Person p3 = new Person("Joe",new GregorianCalendar(2013, 11, 12, 1, 3, 2));
		 Person p2 = new PersonWithJob("Joe",new GregorianCalendar(2013, 11, 12, 1, 3, 2), 20000);
		 System.out.println("p1.equals(p2)? " + p1.equals(p2));
		 System.out.println("p1.equals(p3)? " + p1.equals(p3));
		 System.out.println("p2.equals(p1)? " + p2.equals(p1));
		 System.out.println("p2.equals(p2)? " + p2.equals(p2));

	}
}