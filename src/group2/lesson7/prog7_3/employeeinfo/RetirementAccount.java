package group2.lesson7.prog7_3.employeeinfo;

public class RetirementAccount extends Account {
	
	private final double PENALTY_RATE = 0.02;
	RetirementAccount(Employee emp, double balance) {
		super(emp, AccountType.RETIREMENT, balance);
	}
	public AccountType getAcctType() {
		return AccountType.RETIREMENT;
	}
	
	public boolean makeWithdrawal(double amount) {
		if(super.makeWithdrawal(amount))
		{
			double curBal = super.getBalance();
			double bal = curBal - curBal * PENALTY_RATE;
			super.setBalance(bal);
			
			return true;
		}
		return false;
	}
}
