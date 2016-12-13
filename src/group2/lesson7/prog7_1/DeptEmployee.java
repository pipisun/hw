package group2.lesson7.prog7_1;

import java.time.LocalDate;

public class DeptEmployee {
	
	private String name;
	private double salary;
	private LocalDate hireDate;
	
	public double computeSalary() {
		return salary;
	}
	
	DeptEmployee(String name, double salary, LocalDate hireDate) {
		this.name = name;
		this.salary = salary;
		this.hireDate = hireDate;
	}
	
	public String getName() {
		return name;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
}
