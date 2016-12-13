package group2.lesson3.prog3_1_account;

class Account {
//	public final static String CHECKING = "checking";
//	public final static String SAVINGS = "savings";
//	public final static String RETIREMENT = "retirement";
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private String acctType;
	private Employee employee;

	Account(Employee emp, String acctType, double balance) {
		this.employee = emp;
		getAcctTypeInfo(acctType);
		
		this.balance = balance;
	}

	Account(Employee emp, String acctType) {
		this(emp, acctType, DEFAULT_BALANCE);
	}
	
	private void getAcctTypeInfo(String acctType)
	{
		if(acctType.equals(AccountType.CHECKING.toString()))
			this.acctType = AccountType.CHECKING.toString();
		else if(acctType.equals(AccountType.SAVINGS.toString()))
			this.acctType = AccountType.SAVINGS.toString();
		else if(acctType.equals(AccountType.RETIREMENT.toString()))
			this.acctType = AccountType.RETIREMENT.toString();
	}
	
	public String toString() {
			return "type = " + acctType + ", balance = " + balance;
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
		
		return false;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	
	
}
