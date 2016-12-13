package group2.lesson7.prog7_6.case3;

import java.util.GregorianCalendar;

public class PersonWithJob {
	private double salary;
	private Person person;
	PersonWithJob(String n, GregorianCalendar dob, double s) {
		person = new Person(n, dob);
		this.salary = s;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public boolean equals(Object aPersonWithJob) {

		if (this == aPersonWithJob) {
			return true;
		}
		if (!(aPersonWithJob instanceof PersonWithJob)) {
			return false;
		}
		if (this.getClass() != aPersonWithJob.getClass()) {
			return false;
		}
		PersonWithJob p = (PersonWithJob) aPersonWithJob;
		return this.salary == p.salary && p.person.getName().equals(person.getName())
				&& p.person.getDateOfBirth().equals(person.getDateOfBirth());

	}
}