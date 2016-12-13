package group2.lesson7.prog7_3.employeeinfo;

public class CheckingAccount extends Account {
	
	private final double MONTHLY_CHARGE = 5;
	CheckingAccount(Employee emp, double balance) {
		super(emp, AccountType.CHECKING, balance);
	}
	
	public AccountType getAcctType() {
		return AccountType.CHECKING;
	}
	public double getBalance() {
		double baseBalance = super.getBalance();
		return baseBalance - MONTHLY_CHARGE;
	}
}
