package group2.lesson7.prog7_1;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Professor prof1 = new Professor("Alan", 5000, LocalDate.of(2001, 1, 3), 10);
		Professor prof2 = new Professor("John", 4500, LocalDate.of(2002, 3, 3), 10);
		Professor prof3 = new Professor("David", 6000, LocalDate.of(2000, 6, 3), 10);
		Secretary secr1 = new Secretary("Rose", 3000, LocalDate.of(2005, 1, 3), 200);
		Secretary secr2 = new Secretary("Alice", 2500, LocalDate.of(2006, 3, 3), 200);
		
		DeptEmployee[] department = {prof1, prof2, prof3, secr1, secr2};
		String str = "";
		for(DeptEmployee dept : department) {
			if(dept instanceof Professor) {
				Professor pro = (Professor)dept;
				str = String.format("Professor Name:%s, Salary:%.1f, Hire date:%s, No. of publications:%d", pro.getName(), pro.computeSalary(),pro.getHireDate(), pro.getNumberOfPublications());
			}
			if(dept instanceof Secretary) {
				Secretary sec = (Secretary)dept;
				str = String.format("Secretary Name:%s, Salary:%.1f, Hire date:%s, Overtime hours:%.1f", sec.getName(), sec.computeSalary(),sec.getHireDate(),sec.getOvertimeHours());
			}
			System.out.println(str);
		}
		
		double totalSalaries = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("Do you want to see the sum of all salaries in the department(Y/N)?");
		String prompt = in.nextLine();
		if(prompt.toUpperCase().equals("Y")) {
			for(int j=0;j<department.length;j++) {
				totalSalaries += department[j].computeSalary();
			}
			
			System.out.println("The sum of salaries in the department is: " + totalSalaries);
		}
	}
}
