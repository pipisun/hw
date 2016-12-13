package group2.lesson7.prog7_3.employeeinfo;

public class SavingsAccount extends Account {
	
	private final double INTEREST_RATE = 0.25;
	SavingsAccount(Employee emp, double balance) {
		super(emp, AccountType.SAVINGS, balance);
	}
	
	public AccountType getAcctType() {
		return AccountType.SAVINGS;
	}
	public double getBalance() {
		double baseBalance = super.getBalance();
		double interest = (INTEREST_RATE/100)*baseBalance;
		return baseBalance + interest;
	}
}
