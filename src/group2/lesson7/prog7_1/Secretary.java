package group2.lesson7.prog7_1;

import java.time.LocalDate;

public class Secretary extends DeptEmployee {
	
	private double overtimeHours;
	Secretary(String name, double salary, LocalDate hireDate, double overtimeHours) {
		super(name, salary, hireDate);
		this.overtimeHours = overtimeHours;
	}
	
	public double getOvertimeHours() {
		return overtimeHours;
	}

	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}
	
	public double computeSalary() {
		double sal = super.computeSalary() + 12 * overtimeHours;
		return sal;
	}
	
}
