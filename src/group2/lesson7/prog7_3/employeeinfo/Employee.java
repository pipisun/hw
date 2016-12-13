package group2.lesson7.prog7_3.employeeinfo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

import group2.lesson7.prog7_3.AccountList;
import group2.lesson7.prog7_3.MyStringList;

public class Employee {

//	private Account savingsAcct;
//	private Account checkingAcct;
//	private Account retirementAcct;
	private String name;
	private LocalDate hireDate;
	private AccountList accounts = new AccountList();
	
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
		Account checkingAcct = new Account(this, AccountType.CHECKING, startAmount);
		accounts.add(checkingAcct);
	}

	public void createNewSavings(double startAmount) {
		// implement
		Account savingsAcct = new Account(this, AccountType.SAVINGS, startAmount);
		accounts.add(savingsAcct);
	}

	public void createNewRetirement(double startAmount) {
		// implement
		Account retirementAcct = new Account(this, AccountType.RETIREMENT, startAmount);
		accounts.add(retirementAcct);
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
		for(int i=0;i<accounts.size();i++)
		{
			Account acct = accounts.get(i);
			if(accounts.get(i) != null)
				strFormat += String.format("%s", acct);	
		}
		String strFormatPattern = String.format("ACCOUNT INFO FOR %s:\n\n", this.name) + strFormat;
		return strFormatPattern;
	}
	
	public void deposit(int accountIndex, double amt){
		Account selected = accounts.get(accountIndex);
		selected.makeDeposit(amt);
	}
	
	public boolean withdraw(int accountIndex, double amt){
		// implement
		Account selected = accounts.get(accountIndex);
		if(selected.makeWithdrawal(amt))
			return true;
		
		return false;
	}
	
	public String[] getNamesOfAccounts() {
		MyStringList msl = new MyStringList();
		String[] names = new String[accounts.size()];
		for(int i=0;i<names.length;i++) {
			names[i] = accounts.get(i).getAcctType().toString();
			msl.add(names[i]);
		}
		
		return names;
	}
}
