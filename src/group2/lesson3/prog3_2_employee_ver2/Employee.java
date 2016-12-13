package group2.lesson3.prog3_2_employee_ver2;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {

	private Account savingsAcct;
	private Account checkingAcct;
	private Account retirementAcct;
	private String name;
	private LocalDate hireDate;
	
	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
		this.name = name;
/* update, using LocalDate
		GregorianCalendar cal = new GregorianCalendar(yearOfHire,monthOfHire-1,dayOfHire);
		hireDate = cal.getTime(); 
*/
		this.hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
	}

	
	public void createNewChecking(double startAmount) {
		// implement
		checkingAcct = new Account(this, AccountType.CHECKING.toString(), startAmount);
	}

	public void createNewSavings(double startAmount) {
		// implement
		savingsAcct = new Account(this, AccountType.SAVINGS.toString(), startAmount);
	}

	public void createNewRetirement(double startAmount) {
		// implement
		retirementAcct = new Account(this, AccountType.RETIREMENT.toString(), startAmount);
	}

	public String getName() {
		return name;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}


	public String getFormattedAcctInfo() {
		// implement
		String strFormat = "";
		if(checkingAcct != null)
			strFormat = String.format("%s", checkingAcct);
		if(savingsAcct != null)
			strFormat += String.format("%s", savingsAcct);
		if(retirementAcct != null)
			strFormat += String.format("%s", retirementAcct);
		
		String strFormatPattern = String.format("ACCOUNT INFO FOR %s:\n\n", this.name) + strFormat;
		return strFormatPattern;
	}
	public void deposit(String acctType, double amt){
		// implement
		if(acctType.equals(AccountType.CHECKING.toString()) && checkingAcct != null)
			checkingAcct.makeDeposit(amt);
		else if(acctType.equals(AccountType.SAVINGS.toString()) && savingsAcct != null)
			savingsAcct.makeDeposit(amt);
		else if(acctType.equals(AccountType.RETIREMENT.toString()) && retirementAcct != null)
			retirementAcct.makeDeposit(amt);
	}
	public boolean withdraw(String acctType, double amt){
		// implement
		if(acctType.equals(AccountType.CHECKING.toString()) && checkingAcct != null)
			return checkingAcct.makeWithdrawal(amt);
		else if(acctType.equals(AccountType.SAVINGS.toString()) && savingsAcct != null)
			return savingsAcct.makeWithdrawal(amt);
		else if(acctType.equals(AccountType.RETIREMENT.toString()) && retirementAcct != null)
			return retirementAcct.makeWithdrawal(amt);
		
		return false;
	}
}
