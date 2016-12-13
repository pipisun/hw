package group2.lesson7.prog7_3.employeeinfo;

public class Account {
//	public final static String CHECKING = "checking";
//	public final static String SAVINGS = "savings";
//	public final static String RETIREMENT = "retirement";
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private AccountType acctType;
	private Employee employee;

	Account(Employee emp, AccountType acctType, double balance) {
		this.employee = emp;
		this.acctType = acctType;
		this.balance = balance;
	}

	Account(Employee emp, AccountType acctType) {
		this(emp, acctType, DEFAULT_BALANCE);
	}
	
//	private void getAcctTypeInfo(String acctType)
//	{
//		if(acctType.equals(AccountType.CHECKING.toString()))
//			this.acctType = AccountType.CHECKING;
//		else if(acctType.equals(AccountType.SAVINGS.toString()))
//			this.acctType = AccountType.SAVINGS;
//		else if(acctType.equals(AccountType.RETIREMENT.toString()))
//			this.acctType = AccountType.RETIREMENT;
//	}
	
	public String toString() {
		String strPattern = "Account type: %s\nCurrent bal: %.1f\n";
		String strFormatStr = String.format(strPattern, acctType.toString().toLowerCase(), balance);
		return strFormatStr;
	}

	public void makeDeposit(double deposit) {
		this.balance += deposit;
	}

	public boolean makeWithdrawal(double amount) {
		double bal = this.balance - amount;
		if(bal >= 0)
		{
			this.balance = bal;
			return true;
		}
		else
			System.out.println("Error: Insufficient funds!");
		
		return false;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}

	public AccountType getAcctType() {
		return acctType;
	}

	public void setAcctType(AccountType acctType) {
		this.acctType = acctType;
	}
	
	
}
