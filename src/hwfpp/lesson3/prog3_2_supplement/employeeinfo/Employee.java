package hwfpp.lesson3.prog3_2_supplement.employeeinfo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {

//	private Account savingsAcct;
//	private Account checkingAcct;
//	private Account retirementAcct;
//	private LocalDate hireDate;
	private String name;

	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire) {
		this.name = name;
		/*
		 * update, using LocalDate GregorianCalendar cal = new
		 * GregorianCalendar(yearOfHire,monthOfHire-1,dayOfHire); hireDate =
		 * cal.getTime();
		 */
	}

	public void createNewChecking(double startAmount) {
		// implement

	}

	public void createNewSavings(double startAmount) {
		// implement

	}

	public void createNewRetirement(double startAmount) {
		// implement

	}

	public String getFormattedAcctInfo() {
		// implement
		return null;
	}

	public void deposit(String acctType, double amt) {
		// implement
	}

//	public boolean withdraw(String acctType, double amt) {
//		// implement
//	}

}
