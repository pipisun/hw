package group2.lesson7.prog7_6.case2;

import java.util.GregorianCalendar;

public class PersonWithJob extends Person {
	private double salary;

	PersonWithJob(String n, GregorianCalendar dob, double s) {
		super(n, dob);
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
		if (!super.equals(aPersonWithJob)) {
			return false;
		}
		if (this.getClass() != aPersonWithJob.getClass()) {
			return false;
		}
		PersonWithJob p = (PersonWithJob) aPersonWithJob;
		return this.salary == p.salary && this.getName().equals(p.getName())
				&& this.getDateOfBirth().equals(p.getDateOfBirth());
	}
}