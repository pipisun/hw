package hwfpp.lesson8.lession8;

import java.util.*;

/**
 * Emp class modified for Array List
 * 
 */

// a super class to store details of the employee

class Emp implements Comparable<Emp> {
	// instance fields
	private String name;
	public double salary;
	private Date hireDay;

	// constructor
	Emp(String aName, double aSalary, int aYear, int aMonth, int aDay) {
		name = aName;
		salary = aSalary;
		GregorianCalendar cal = new GregorianCalendar(aYear, aMonth - 1, aDay);
		hireDay = cal.getTime();
	}

	// instance methods
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	/**
	 * Compares employees by salary
	 * 
	 * @param other
	 *            another Employee object return a negative value if this
	 *            Employee has a lower salary than other object, 0 if the
	 *            salaries are the same, a positive value otherwise
	 */
	@Override
	public int compareTo(Emp other) {
		return Double.compare(salary, other.salary);
	}

}

class Mgr extends Emp {
	public Mgr(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bonus = 0;
	}

	@Override
	public double getSalary() {
		// no direct access to private variables of superclass
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public void setBonus(double b) {
		bonus = b;
	}

	// no equals (or hashCode) implementation here --
	// Manager uses Employee version

	private double bonus;
}

public class ManagerTest2 {
	// Inheritance Example
	public static void main(String[] args) {

		Mgr boss = new Mgr("Boss Guy", 80000, 2009, 12, 15);

		// Emp[] staff = new Emp[3];

		/*
		 * staff[0] = boss; staff[1] = new Emp("Jimbo", 50000, 2012, 10, 1);
		 * staff[2] = new Emp("Tommy", 40000, 2013, 3, 15);
		 */

		ArrayList<Emp> staff = new ArrayList<>();
		staff.ensureCapacity(5);
		staff.add((boss));
		staff.add(new Emp("Jimbo", 50000, 2012, 10, 1));
		staff.add(new Emp("Lee", 40000, 2013, 3, 15));
		staff.add(new Emp("Tony", 45000, 2013, 3, 15));

		((Mgr) staff.get(0)).setBonus(21.0);

		// print names and salaries
		for (Emp e : staff) {
			// for(int i=0;i<staff.size();i++){
			// Emp e=staff.get(i);
			System.out.println("Name: " + e.getName() + "\nSalary: " + e.getSalary() + "\nHire Day :" + e.getHireDay());
		}

	}
}
